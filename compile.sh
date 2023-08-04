trap "exit" INT

clear

usage="Usage: $0 <App 1:Admin, 2:cdencia, 3:AdminUGPP, 4:cache-sigs, 5:cache-radicacion, 6:GestorTemplate, 7:SSOC_SPRING_Cfg, 8:SSOC_OPE_Administracion_Tramites> <Deployment 0:texto 1:DEV, 2:QA>"

if [ -z "$1" ]; then
  echo "$usage"
  exit 1
fi

case $1 in
  1)
    text="SSOC_WS_Administracion_Instrumentos_Archivisticos"
    warfile="administracionInstrumentosArchivisticos"
    ;;
  2)
    text="SSOC_WS_Integraciones"
    warfile="correspondencia-sgd-api"
    ;;
  3)
    text="UGPP_WS_Administracion_Instrumentos_Archivisticos"
    warfile="administracionInstrumentosArchivisticos"
    ;;
  4)
    text="SSOC_CacheSigsPersonaNJ-Api"
    warfile="cacheSigsPersonaNJ-api"
    ;;
  5)
    text="SSOC_CacheRadicacion-Api"
    warfile="cacheRadicacion-api"
    ;;
  6)
    text="UGPP_Gestor-Templates-SpireDoc"
    warfile="ssoc-ws-radicacion-masivos-0.0.1-SNAPSHOT"
    ;;
  6)
    text="UGPP_Gestor-Templates-SpireDoc"
    warfile="Gestor-Templates-SpireDoc"
    ;;
  7)
    text="SSOC_SPRING_Cfg"
    warfile="SSOC_SPRING_Cfg"
    ;;
  8)
    text="SSOC_DB_Model"
    warfile="SSOC_DB_Model"
    ;;
  9)
    text="SSOC_OPE_Administracion_Tramites"
    warfile="SSOC_OPE_Administracion_Tramites"
    ;;
  *)
    echo "Unkown App"
    exit 1
    ;;
esac

cd $text

pwd

if [ ! -z "$2" ] && [ "$2" -lt 1 ]; then
  echo "Build $text"
  mvn clean package install -DskipTests=true -U
fi

if [ ! -z "$2" ] && [ "$2" -eq 1 ]; then
  echo "Sonar $text"
  mvn sonar:sonar
fi

if [ "$2" -gt 2 ]; then

  if [ "$1" -lt 6 ] && [ ! -z "$2" ] && [ "$2" -gt 1 ]; then
    wildfly_path="deployments"
    wildfly_host="//SSWV2-SGD07"
    wildfly="//SSWV2-SGD07/deployments"
    echo " --->PREP<----"
    echo "cp target/$warfile.war $wildfly"
    nombrefinal="$wildfly/$warfile"
  elif [ "$1" -lt 6 ] && [ ! -z "$2" ] && [ "$2" -gt 0 ]; then
    wildfly="//SSWV3-SGD07/deployments"
    echo " --->DLLO<----"
    echo "cp target/$warfile.war $wildfly"
    nombrefinal="$wildfly/$warfile"
  fi

  network_file_address="$nombrefinal.**"
  if ls $network_file_address 1> /dev/null 2>&1; then
      rm "$network_file_address"
      sleep 5
  else
      echo "$network_file_address sin resultados."
  fi


  retry_count=2
  retry_delay=2

  network_file_address="$nombrefinal.war.is*"
  for i in $(seq 1 $retry_count); do
    if ls $network_file_address 1> /dev/null 2>&1; then
      echo "$network_file_address EXISTE, esperando $retry_delay segundos (intento $i de $retry_count)."
      sleep $retry_delay
    else
      echo "$network_file_address no existe"
    fi
  done


  network_file_address="$nombrefinal.**"
  if ls $network_file_address 1> /dev/null 2>&1; then
    echo "Existen archivos $network_file_address debe revisar si el proceso quedó bloqueado y reiniciar Wildfly"
    exit 1
  fi


  if [ ! -z "$2" ] && [ "$2" -gt 0 ]; then
    for i in $(seq 1 $retry_count); do
      if ls $network_file_address 1> /dev/null 2>&1; then
        echo "$network_file_address EXISTE, esperando $retry_delay segundos (intento $i de $retry_count)."
        sleep $retry_delay
      else
        echo "$network_file_address no existe"
        break
      fi
    done
    touch "$nombrefinal.war.doundeploy"
    #cp target/$warfile.war $wildfly

    rsync --progress "target/$warfile.war" "$wildfly_host:$wildfly_path"

    # Wait until file copy is complete
    while true; do
      # Get progress of file transfer
      progress=$(rsync --info=progress2 "$wildfly_path" "$wildfly_host:$wildfly_path" | tail -n 1 | awk '{print $2}')
      # If progress is 100%, exit the loop
      if [ "$progress" = "100%" ]; then
        break
      fi
      # Wait for 5 seconds before checking again
      sleep 5
    done

    rm "$nombrefinal.war.*"
    touch "$nombrefinal.dodeploy"
  fi
fi

echo "$usage"
exit 1
