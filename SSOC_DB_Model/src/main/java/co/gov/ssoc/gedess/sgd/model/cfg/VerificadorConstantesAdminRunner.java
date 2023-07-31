package co.gov.ssoc.gedess.sgd.model.cfg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import co.gov.ssoc.gedess.sgd.model.entity.OCaracteristicas;
import co.gov.ssoc.gedess.sgd.model.entity.ODisposicionFinal;
import co.gov.ssoc.gedess.sgd.model.entity.OMotivos;
import co.gov.ssoc.gedess.sgd.model.entity.OProceso;
import co.gov.ssoc.gedess.sgd.model.entity.OSoportes;
import co.gov.ssoc.gedess.sgd.model.entity.OTipoCuaderno;
import co.gov.ssoc.gedess.sgd.model.entity.OTipoDocumental;
import co.gov.ssoc.gedess.sgd.model.entity.OTipoExpediente;
import co.gov.ssoc.gedess.sgd.model.entity.OTipoRadicacion;
import co.gov.ssoc.gedess.sgd.model.entity.OTipoSeguridad;
import co.gov.ssoc.gedess.sgd.model.entity.OTipoSerie;
import co.gov.ssoc.gedess.sgd.model.entity.repository.CaracteristicasRepository;
import co.gov.ssoc.gedess.sgd.model.entity.repository.DisposicionFinalRepository;
import co.gov.ssoc.gedess.sgd.model.entity.repository.MotivosRepository;
import co.gov.ssoc.gedess.sgd.model.entity.repository.ProcesoRepository;
import co.gov.ssoc.gedess.sgd.model.entity.repository.SoportesRepository;
import co.gov.ssoc.gedess.sgd.model.entity.repository.TipoCuadernoRepository;
import co.gov.ssoc.gedess.sgd.model.entity.repository.TipoDocumentalRepository;
import co.gov.ssoc.gedess.sgd.model.entity.repository.TipoExpedienteRepository;
import co.gov.ssoc.gedess.sgd.model.entity.repository.TipoRadicacionRepository;
import co.gov.ssoc.gedess.sgd.model.entity.repository.TipoSeguridadRepository;
import co.gov.ssoc.gedess.sgd.model.entity.repository.TipoSerieRepository;

@Component
public class VerificadorConstantesAdminRunner implements ApplicationRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(VerificadorConstantesAdminRunner.class);

	@Autowired
	private MotivosRepository motivosRepository;
	@Autowired
	private SoportesRepository soporteRepository;
	@Autowired
	private ProcesoRepository procesoRepository;
	@Autowired
	private TipoSerieRepository tipoSerieRepository;
	@Autowired
	private TipoCuadernoRepository cuadernoRepository;
	@Autowired
	private TipoSeguridadRepository tipoSeguridadRepository;
	@Autowired
	private TipoDocumentalRepository tipoDocumentalRepository;
	@Autowired
	private TipoExpedienteRepository tipoExpedienteRepository;
	@Autowired
	private TipoRadicacionRepository tipoRadicacionRepository;
	@Autowired
	private CaracteristicasRepository caracteristicasRepository;
	@Autowired
	private DisposicionFinalRepository disposicionFinalRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		long start = System.currentTimeMillis();
		LOGGER.debug("constantsVerifier-run init");

		// PROCESO
		try {
			OProceso proceso;
			proceso = new OProceso(null, 0, "TODOS", true);
			if (procesoRepository.findAll(Example.of(proceso)).isEmpty())
				procesoRepository.save(proceso);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-soporte", e);
		}

		// TIPO SOPORTE
		OSoportes soporte;
		try {
			soporte = new OSoportes(null, "Electrónico");
			if (soporteRepository.findAll(Example.of(soporte)).isEmpty())
				soporteRepository.save(soporte);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-soporte", e);
		}
		try {
			soporte = new OSoportes(null, "Físico");
			if (soporteRepository.findAll(Example.of(soporte)).isEmpty())
				soporteRepository.save(soporte);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-soporte", e);
		}

		// TIPO DOCUMENTAL
		try {
			OTipoDocumental odisposicionFinal = new OTipoDocumental(null, "0", "TODOS", true, "", "");
			if (tipoDocumentalRepository.findAll(Example.of(odisposicionFinal)).isEmpty())
				tipoDocumentalRepository.save(odisposicionFinal);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-tipo-documental", e);
		}

		// TIPO DISPOSICION FINAL
		try {
			ODisposicionFinal odisposicionFinal = new ODisposicionFinal(null, "CT", null, null, null);
			if (disposicionFinalRepository.findAll(Example.of(odisposicionFinal)).isEmpty())
				disposicionFinalRepository.save(odisposicionFinal);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-soporte", e);
		}
		try {
			ODisposicionFinal odisposicionFinal = new ODisposicionFinal(null, "E", null, null, null);
			if (disposicionFinalRepository.findAll(Example.of(odisposicionFinal)).isEmpty())
				disposicionFinalRepository.save(odisposicionFinal);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-soporte", e);
		}
		try {
			ODisposicionFinal odisposicionFinal = new ODisposicionFinal(null, "MT", null, null, null);
			if (disposicionFinalRepository.findAll(Example.of(odisposicionFinal)).isEmpty())
				disposicionFinalRepository.save(odisposicionFinal);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-soporte", e);
		}
		try {
			ODisposicionFinal odisposicionFinal = new ODisposicionFinal(null, "S", null, null, null);
			if (disposicionFinalRepository.findAll(Example.of(odisposicionFinal)).isEmpty())
				disposicionFinalRepository.save(odisposicionFinal);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-soporte", e);
		}

		// TIPO CARACTERISTICAS
		OCaracteristicas caracteristica = new OCaracteristicas(null, "Legal");
		try {
			if (caracteristicasRepository.findAll(Example.of(caracteristica)).isEmpty())
				caracteristicasRepository.save(caracteristica);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-soporte", e);
		}
		try {
			caracteristica = new OCaracteristicas(null, "Técnica");
			if (caracteristicasRepository.findAll(Example.of(caracteristica)).isEmpty())
				caracteristicasRepository.save(caracteristica);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-soporte", e);
		}
		try {
			caracteristica = new OCaracteristicas(null, "Administrativa");
			if (caracteristicasRepository.findAll(Example.of(caracteristica)).isEmpty())
				caracteristicasRepository.save(caracteristica);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-soporte", e);
		}

		// TIPOS RADICACION
		try {
			OTipoRadicacion tipoRadicacion = new OTipoRadicacion(null, 0, "TODOS", true);
			if (tipoRadicacionRepository.findAll(Example.of(tipoRadicacion)).isEmpty())
				tipoRadicacionRepository.save(tipoRadicacion);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-tipo-radicacion", e);
		}
		try {
			OTipoRadicacion tipoRadicacion = new OTipoRadicacion(null, 10, "ENTRADA", true);
			if (tipoRadicacionRepository.findAll(Example.of(tipoRadicacion)).isEmpty())
				tipoRadicacionRepository.save(tipoRadicacion);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-tipo-radicacion", e);
		}
		try {
			OTipoRadicacion tipoRadicacion = new OTipoRadicacion(null, 20, "INTERNA", true);
			if (tipoRadicacionRepository.findAll(Example.of(tipoRadicacion)).isEmpty())
				tipoRadicacionRepository.save(tipoRadicacion);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-tipo-radicacion", e);
		}
		try {
			OTipoRadicacion tipoRadicacion = new OTipoRadicacion(null, 30, "SALIDA", true);
			if (tipoRadicacionRepository.findAll(Example.of(tipoRadicacion)).isEmpty())
				tipoRadicacionRepository.save(tipoRadicacion);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-tipo-radicacion", e);
		}

		// TIPO DE SERIE
		try {
			OTipoSerie otipoSerie = new OTipoSerie(null, "S", "SIMPLE", null);
			if (tipoSerieRepository.findAll(Example.of(otipoSerie)).isEmpty())
				tipoSerieRepository.save(otipoSerie);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-tipo-serie", e);
		}
		try {
			OTipoSerie otipoSerie = new OTipoSerie(null, "C", "COMPUESTA", null);
			if (tipoSerieRepository.findAll(Example.of(otipoSerie)).isEmpty())
				tipoSerieRepository.save(otipoSerie);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-tipo-serie", e);
		}
		try {
			OTipoSerie otipoSerie = new OTipoSerie(null, "SC", "SIMPLE - COMPUESTA", null);
			if (tipoSerieRepository.findAll(Example.of(otipoSerie)).isEmpty())
				tipoSerieRepository.save(otipoSerie);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-tipo-serie", e);
		}

		// TIPO EXPEDIENTE
		try {
			OTipoExpediente otipoExp = new OTipoExpediente(null, "A", "ADMINISTRATIVO", null);
			if (tipoExpedienteRepository.findAll(Example.of(otipoExp)).isEmpty())
				tipoExpedienteRepository.save(otipoExp);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-tipo-expediente", e);
		}

		try {
			OTipoExpediente otipoExp = new OTipoExpediente(null, "J", "JURISDICCIONAL", null);
			if (tipoExpedienteRepository.findAll(Example.of(otipoExp)).isEmpty())
				tipoExpedienteRepository.save(otipoExp);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-tipo-expediente", e);
		}

		try {
			OTipoExpediente otipoExp = new OTipoExpediente(null, "AJ", "ADMINISTRATIVO - JURISDICCIONAL", null);
			if (tipoExpedienteRepository.findAll(Example.of(otipoExp)).isEmpty())
				tipoExpedienteRepository.save(otipoExp);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-tipo-expediente", e);
		}

		// TIPO SEGURIDAD
		try {
			OTipoSeguridad otipoExp = new OTipoSeguridad(null, "ABIERTA", "ABIERTA", true);
			if (tipoSeguridadRepository.findAll(Example.of(otipoExp)).isEmpty())
				tipoSeguridadRepository.save(otipoExp);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-tipo-seguridad", e);
		}
		try {
			OTipoSeguridad otipoExp = new OTipoSeguridad(null, "JERARQUICA", "JERARQUICA", true);
			if (tipoSeguridadRepository.findAll(Example.of(otipoExp)).isEmpty())
				tipoSeguridadRepository.save(otipoExp);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-tipo-seguridad", e);
		}
		try {
			OTipoSeguridad otipoExp = new OTipoSeguridad(null, "DEPENDENCIA", "DEPENDENCIA", true);
			if (tipoSeguridadRepository.findAll(Example.of(otipoExp)).isEmpty())
				tipoSeguridadRepository.save(otipoExp);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-tipo-seguridad", e);
		}
		try {
			OTipoSeguridad otipoExp = new OTipoSeguridad(null, "MIXTA", "MIXTA", true);
			if (tipoSeguridadRepository.findAll(Example.of(otipoExp)).isEmpty())
				tipoSeguridadRepository.save(otipoExp);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-tipo-seguridad", e);
		}
		try {
			OTipoSeguridad otipoExp = new OTipoSeguridad(null, "RESTRINGIDA", "RESTRINGIDA", true);
			if (tipoSeguridadRepository.findAll(Example.of(otipoExp)).isEmpty())
				tipoSeguridadRepository.save(otipoExp);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-tipo-seguridad", e);
		}
		try {
			OTipoSeguridad otipoExp = new OTipoSeguridad(null, "VIP", "VIP", true);
			if (tipoSeguridadRepository.findAll(Example.of(otipoExp)).isEmpty())
				tipoSeguridadRepository.save(otipoExp);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-tipo-seguridad", e);
		}
		try {
			OTipoSeguridad otipoExp = new OTipoSeguridad(null, "DEPENDENCIAFUN", "DEPENDENCIAFUN", true);
			if (tipoSeguridadRepository.findAll(Example.of(otipoExp)).isEmpty())
				tipoSeguridadRepository.save(otipoExp);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-tipo-seguridad", e);
		}
		try {
			OTipoSeguridad otipoExp = new OTipoSeguridad(null, "FUN", "JERARQUICAFUN", true);
			if (tipoSeguridadRepository.findAll(Example.of(otipoExp)).isEmpty())
				tipoSeguridadRepository.save(otipoExp);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-tipo-seguridad", e);
		}
		try {
			OTipoSeguridad otipoExp = new OTipoSeguridad(null, "MIXTAFUN", "MIXTAFUN", true);
			if (tipoSeguridadRepository.findAll(Example.of(otipoExp)).isEmpty())
				tipoSeguridadRepository.save(otipoExp);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-tipo-seguridad", e);
		}
		try {
			OTipoSeguridad otipoExp = new OTipoSeguridad(null, "REORGANIZACION", "REORGANIZACION", true);
			if (tipoSeguridadRepository.findAll(Example.of(otipoExp)).isEmpty())
				tipoSeguridadRepository.save(otipoExp);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-tipo-seguridad", e);
		}

		// TIPO CUADERNO
		try {
			OTipoCuaderno ocuaderno = new OTipoCuaderno(null, -1, "NA", null, null);
			if (cuadernoRepository.findAll(Example.of(ocuaderno)).isEmpty())
				cuadernoRepository.save(ocuaderno);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-tipo-cuaderno", e);
		}

		// MOTIVOS
		try {
			OMotivos omotivo = new OMotivos(null, "Normatividad");
			if (motivosRepository.findAll(Example.of(omotivo)).isEmpty())
				motivosRepository.save(omotivo);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-motivo", e);
		}
		try {
			OMotivos omotivo = new OMotivos(null, "Nuevas Funciones");
			if (motivosRepository.findAll(Example.of(omotivo)).isEmpty())
				motivosRepository.save(omotivo);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-motivo", e);
		}
		try {
			OMotivos omotivo = new OMotivos(null, "Creación de dependencia");
			if (motivosRepository.findAll(Example.of(omotivo)).isEmpty())
				motivosRepository.save(omotivo);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-motivo", e);
		}
		try {
			OMotivos omotivo = new OMotivos(null, "Reestructuración");
			if (motivosRepository.findAll(Example.of(omotivo)).isEmpty())
				motivosRepository.save(omotivo);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-motivo", e);
		}

		LOGGER.debug("constantsVerifier-run end {}ms", System.currentTimeMillis() - start);
	}
}
