package co.gov.ssoc.gedess.sgd.model.cfg;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import co.gov.ssoc.gedess.sgd.model.entity.OEstadoRadicacion;
import co.gov.ssoc.gedess.sgd.model.entity.OParametros;
import co.gov.ssoc.gedess.sgd.model.entity.OProceso;
import co.gov.ssoc.gedess.sgd.model.entity.OSerie;
import co.gov.ssoc.gedess.sgd.model.entity.OSubSerie;
import co.gov.ssoc.gedess.sgd.model.entity.OTipoCuaderno;
import co.gov.ssoc.gedess.sgd.model.entity.OTipoDocumental;
import co.gov.ssoc.gedess.sgd.model.entity.OTipoExpediente;
import co.gov.ssoc.gedess.sgd.model.entity.OTipoRadicacion;
import co.gov.ssoc.gedess.sgd.model.entity.OTipoSeguridad;
import co.gov.ssoc.gedess.sgd.model.entity.OTramite;
import co.gov.ssoc.gedess.sgd.model.entity.repository.EstadoRadicacionRepository;
import co.gov.ssoc.gedess.sgd.model.entity.repository.ParametrosRepository;
import co.gov.ssoc.gedess.sgd.model.entity.repository.ProcesoRepository;
import co.gov.ssoc.gedess.sgd.model.entity.repository.SerieRepository;
import co.gov.ssoc.gedess.sgd.model.entity.repository.SubSerieRepository;
import co.gov.ssoc.gedess.sgd.model.entity.repository.TipoCuadernoRepository;
import co.gov.ssoc.gedess.sgd.model.entity.repository.TipoDocumentalRepository;
import co.gov.ssoc.gedess.sgd.model.entity.repository.TipoExpedienteRepository;
import co.gov.ssoc.gedess.sgd.model.entity.repository.TipoRadicacionRepository;
import co.gov.ssoc.gedess.sgd.model.entity.repository.TipoSeguridadRepository;
import co.gov.ssoc.gedess.sgd.model.entity.repository.TramitesRepository;

@Component
public class VerificadorConstantesCdenciaRunner implements ApplicationRunner {

	private static final String MEDIO_ENVIO = "MEDIO_ENVIO";

	private static final Logger LOGGER = LoggerFactory.getLogger(VerificadorConstantesCdenciaRunner.class);

	@Autowired
	private SerieRepository serieRepository;
	@Autowired
	private ProcesoRepository procesoRepository;
	@Autowired
	private SubSerieRepository subSerieRepository;
	@Autowired
	private ParametrosRepository parametrosRepository;
	@Autowired
	private TipoCuadernoRepository tipoCuadernoRepository;
	@Autowired
	private TramitesRepository tramiteRelacionesRepository;
	@Autowired
	private TipoSeguridadRepository tipoSeguridadRepository;
	@Autowired
	private TipoExpedienteRepository tipoExpedienteRepository;
	@Autowired
	private TipoRadicacionRepository tipoRadicacionRepository;
	@Autowired
	private TipoDocumentalRepository tipoDocumentalRepository;
	@Autowired
	private EstadoRadicacionRepository estadoRadicacionRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		long start = System.currentTimeMillis();
		LOGGER.debug("constantsVerifier-run init");
		
		// ESTADO RADICACION
		try {
			OEstadoRadicacion oEstadoRadicacion = new OEstadoRadicacion(null, "1", "Radicado", true);
			if (estadoRadicacionRepository.findAll(Example.of(oEstadoRadicacion)).isEmpty())
				estadoRadicacionRepository.save(oEstadoRadicacion);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-estado-radicacion", e);
		}
		try {
			OEstadoRadicacion oEstadoRadicacion = new OEstadoRadicacion(null, "2", "Digitalizado", true);
			if (estadoRadicacionRepository.findAll(Example.of(oEstadoRadicacion)).isEmpty())
				estadoRadicacionRepository.save(oEstadoRadicacion);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-estado-radicacion", e);
		}
		try {
			OEstadoRadicacion oEstadoRadicacion = new OEstadoRadicacion(null, "3", "Asignado", true);
			if (estadoRadicacionRepository.findAll(Example.of(oEstadoRadicacion)).isEmpty())
				estadoRadicacionRepository.save(oEstadoRadicacion);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-estado-radicacion", e);
		}
		try {
			OEstadoRadicacion oEstadoRadicacion = new OEstadoRadicacion(null, "4", "Tramitado", true);
			if (estadoRadicacionRepository.findAll(Example.of(oEstadoRadicacion)).isEmpty())
				estadoRadicacionRepository.save(oEstadoRadicacion);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-estado-radicacion", e);
		}
		try {
			OEstadoRadicacion oEstadoRadicacion = new OEstadoRadicacion(null, "5", "Archivado", true);
			if (estadoRadicacionRepository.findAll(Example.of(oEstadoRadicacion)).isEmpty())
				estadoRadicacionRepository.save(oEstadoRadicacion);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-estado-radicacion", e);
		}
		try {
			OEstadoRadicacion oEstadoRadicacion = new OEstadoRadicacion(null, "6", "Anulado", true);
			if (estadoRadicacionRepository.findAll(Example.of(oEstadoRadicacion)).isEmpty())
				estadoRadicacionRepository.save(oEstadoRadicacion);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-estado-radicacion", e);
		}
		try {
			OEstadoRadicacion oEstadoRadicacion = new OEstadoRadicacion(null, "7", "Cerrado", true);
			if (estadoRadicacionRepository.findAll(Example.of(oEstadoRadicacion)).isEmpty())
				estadoRadicacionRepository.save(oEstadoRadicacion);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-estado-radicacion", e);
		}
		try {
			OEstadoRadicacion oEstadoRadicacion = new OEstadoRadicacion(null, "8", "Firmado", true);
			if (estadoRadicacionRepository.findAll(Example.of(oEstadoRadicacion)).isEmpty())
				estadoRadicacionRepository.save(oEstadoRadicacion);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-estado-radicacion", e);
		}
		try {
			OEstadoRadicacion oEstadoRadicacion = new OEstadoRadicacion(null, "9", "Finalizado", true);
			if (estadoRadicacionRepository.findAll(Example.of(oEstadoRadicacion)).isEmpty())
				estadoRadicacionRepository.save(oEstadoRadicacion);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-estado-radicacion", e);
		}

		// TIPO DOCUMENTAL
		OTipoDocumental otipodocumentalTodos = null;
		try {
			otipodocumentalTodos = new OTipoDocumental(null, "0", "TODOS", true, null, null);
			List<OTipoDocumental> list = tipoDocumentalRepository.findAll(Example.of(otipodocumentalTodos));
			if (list.isEmpty())
				otipodocumentalTodos = tipoDocumentalRepository.save(otipodocumentalTodos);
			else
				otipodocumentalTodos = list.get(0);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-tipo-documental", e);
		}

		OTipoDocumental otipodocumentalActas = null;
		try {
			otipodocumentalActas = new OTipoDocumental(null, null, "ACTAS", true, null, null);
			List<OTipoDocumental> list = tipoDocumentalRepository.findAll(Example.of(otipodocumentalActas));
			if (list.isEmpty()) {
				otipodocumentalActas.setCodigo("TD-1");
				otipodocumentalActas = tipoDocumentalRepository.save(otipodocumentalActas);
			} else
				otipodocumentalActas = list.get(0);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-tipo-documental-actas", e);
		}

		// TIPO CUADERNO
		OTipoCuaderno ocuadernoTodos = null;
		try {
			ocuadernoTodos = new OTipoCuaderno(null, 0, "TODOS", null, null);
			List<OTipoCuaderno> list = tipoCuadernoRepository.findAll(Example.of(ocuadernoTodos));
			if (list.isEmpty())
				ocuadernoTodos = tipoCuadernoRepository.save(ocuadernoTodos);
			else
				ocuadernoTodos = list.get(0);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-tipo-cuaderno-todos", e);
		}
		OTipoCuaderno ocuadernoNA = null;
		try {
			ocuadernoNA = new OTipoCuaderno(null, -1, "NA", null, null);
			List<OTipoCuaderno> list = tipoCuadernoRepository.findAll(Example.of(ocuadernoNA));
			if (list.isEmpty())
				ocuadernoNA = tipoCuadernoRepository.save(ocuadernoNA);
			else
				ocuadernoNA = list.get(0);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-tipo-cuaderno-na", e);
		}

		// TIPOS RADICACION
		OTipoRadicacion tipoRadicacionTodos = null;
		try {
			tipoRadicacionTodos = new OTipoRadicacion(null, 0, "TODOS", true);
			List<OTipoRadicacion> list = tipoRadicacionRepository.findAll(Example.of(tipoRadicacionTodos));
			if (list.isEmpty())
				tipoRadicacionTodos = tipoRadicacionRepository.save(tipoRadicacionTodos);
			else
				tipoRadicacionTodos = list.get(0);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-tipo-radicacion", e);
		}
		OTipoRadicacion tipoRadicacionEntrada = null;
		try {
			tipoRadicacionEntrada = new OTipoRadicacion(null, 10, "ENTRADA", true);
			List<OTipoRadicacion> list = tipoRadicacionRepository.findAll(Example.of(tipoRadicacionEntrada));
			if (list.isEmpty())
				tipoRadicacionRepository.save(tipoRadicacionEntrada);
			else
				tipoRadicacionEntrada = list.get(0);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-tipo-radicacion", e);
		}
		OTipoRadicacion tipoRadicacionInterna = null;
		try {
			tipoRadicacionInterna = new OTipoRadicacion(null, 20, "INTERNA", true);
			List<OTipoRadicacion> list = tipoRadicacionRepository.findAll(Example.of(tipoRadicacionInterna));
			if (list.isEmpty())
				tipoRadicacionRepository.save(tipoRadicacionInterna);
			else
				tipoRadicacionInterna = list.get(0);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-tipo-radicacion", e);
		}
		OTipoRadicacion tipoRadicacionSalida = null;
		try {
			tipoRadicacionSalida = new OTipoRadicacion(null, 30, "SALIDA", true);
			List<OTipoRadicacion> list = tipoRadicacionRepository.findAll(Example.of(tipoRadicacionSalida));
			if (list.isEmpty())
				tipoRadicacionRepository.save(tipoRadicacionSalida);
			else
				tipoRadicacionSalida = list.get(0);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-tipo-radicacion", e);
		}

		// TIPO SEGURIDAD
		OTipoSeguridad otipoSegA = null;
		try {
			otipoSegA = new OTipoSeguridad(null, "ABIERTA", "ABIERTA", true);
			List<OTipoSeguridad> list = tipoSeguridadRepository.findAll(Example.of(otipoSegA));
			if (list.isEmpty())
				tipoSeguridadRepository.save(otipoSegA);
			else
				otipoSegA = list.get(0);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-tipo-seguridad-abierta", e);
		}
		OTipoSeguridad otipoSegDep = null;
		try {
			otipoSegDep = new OTipoSeguridad(null, "DEPENDENCIA", "DEPENDENCIA", true);
			List<OTipoSeguridad> list = tipoSeguridadRepository.findAll(Example.of(otipoSegDep));
			if (list.isEmpty())
				tipoSeguridadRepository.save(otipoSegDep);
			else
				otipoSegDep = list.get(0);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-tipo-seguridad-dependencia", e);
		}
		OTipoSeguridad otipoExpJerarquica = null;
		try {
			otipoExpJerarquica = new OTipoSeguridad(null, "JERARQUICA", "JERARQUICA", true);
			List<OTipoSeguridad> list = tipoSeguridadRepository.findAll(Example.of(otipoExpJerarquica));
			if (list.isEmpty())
				tipoSeguridadRepository.save(otipoExpJerarquica);
			else
				otipoExpJerarquica = list.get(0);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-tipo-seguridad-jerarquica", e);
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

		// SERIE
		OSerie oserietodas = null;
		OSubSerie osubserietodas = null;
		try {
			oserietodas = new OSerie(null, 0, "TODAS", null, true, null, null, null, null, null, null, null);
			List<OSerie> list = serieRepository.findAll(Example.of(oserietodas));
			if (list.isEmpty()) {
				oserietodas = serieRepository.save(oserietodas);
			} else
				oserietodas = list.get(0);
			// SUBSERIES

			try {
				osubserietodas = new OSubSerie(null, BigInteger.ZERO, "TODAS", true, oserietodas.getId(), null, null,
						null, null, null, null, null);
				List<OSubSerie> listss = subSerieRepository.findAll(Example.of(osubserietodas));
				if (listss.isEmpty())
					osubserietodas = subSerieRepository.save(osubserietodas);
				else
					osubserietodas = listss.get(0);
			} catch (Exception e) {
				LOGGER.debug("constantsVerifier-run crear-subserie", e);
			}
			Optional<OSerie> optserie = serieRepository.findById(oserietodas.getId());
			oserietodas = optserie.get();
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-serie", e);
		}

		OSerie oseriena = null;
		OSubSerie osubseriena = null;
		try {
			oseriena = new OSerie(null, -1, "NA", null, true, null, null, null, null, null, null, null);
			List<OSerie> list = serieRepository.findAll(Example.of(oseriena));
			if (list.isEmpty()) {
				oseriena = serieRepository.save(oseriena);
			} else
				oseriena = list.get(0);
			// SUBSERIES

			try {
				osubseriena = new OSubSerie(null, BigInteger.valueOf(-1), "NA", true, oseriena.getId(), null, null,
						null, null, null, null, null);
				List<OSubSerie> listss = subSerieRepository.findAll(Example.of(osubseriena));
				if (listss.isEmpty())
					osubseriena = subSerieRepository.save(osubseriena);
				else
					osubseriena = listss.get(0);
			} catch (Exception e) {
				LOGGER.debug("constantsVerifier-run crear-subserie", e);
			}
			Optional<OSerie> optserie = serieRepository.findById(oseriena.getId());
			oseriena = optserie.get();
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-serie", e);
		}

		OSerie actas = null;
		OSubSerie actassub1 = null;
		OSubSerie actassub2 = null;
		OSubSerie actassub3 = null;
		try {
			actas = new OSerie(null, 2, "ACTAS", null, true, null, null, null, null, null, null, null);
			List<OSerie> list = serieRepository.findAll(Example.of(actas));
			if (list.isEmpty()) {
				actas = serieRepository.save(actas);
			} else
				actas = list.get(0);
			// SUBSERIES
			Optional<OSerie> optserie = serieRepository.findById(actas.getId());

			try {
				actassub1 = new OSubSerie(null, new BigInteger("5"), "Actas de Comité de Bienestar y Capacitaciones",
						true, actas.getId(), null, null, null, null, null, null, null);
				List<OSubSerie> listss = subSerieRepository.findAll(Example.of(actassub1));
				if (listss.isEmpty())
					actassub1 = subSerieRepository.save(actassub1);
				else
					actassub1 = listss.get(0);
			} catch (Exception e) {
				LOGGER.debug("constantsVerifier-run crear-actassub5", e);
			}

			try {
				actassub2 = new OSubSerie(null, new BigInteger("6"), "Actas de Comité de Cartera", true, actas.getId(),
						null, null, null, null, null, null, null);
				List<OSubSerie> listss = subSerieRepository.findAll(Example.of(actassub2));
				if (listss.isEmpty())
					actassub2 = subSerieRepository.save(actassub2);
				else
					actassub2 = listss.get(0);
			} catch (Exception e) {
				LOGGER.debug("constantsVerifier-run crear-actassub6", e);
			}

			try {
				actassub3 = new OSubSerie(null, new BigInteger("7"),
						"Actas de Comité de Conciliación y Defensa Judicial", true, actas.getId(), null, null, null,
						null, null, null, null);
				List<OSubSerie> listss = subSerieRepository.findAll(Example.of(actassub3));
				if (listss.isEmpty())
					actassub3 = subSerieRepository.save(actassub3);
				else
					actassub3 = listss.get(0);
			} catch (Exception e) {
				LOGGER.debug("constantsVerifier-run crear-actassub7", e);
			}
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-actas", e);
		}

		// PARAMETROS
		try {
			OParametros oparametro = new OParametros(null, "0", "PARAMETRO_TEST_0", MEDIO_ENVIO, true, null);
			if (parametrosRepository.findAll(Example.of(oparametro)).isEmpty()) {
				oparametro = parametrosRepository.save(oparametro);
			}
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-parametro", e);
		}
		try {
			OParametros oparametro_1 = new OParametros(null, "1", "VENTANILLA", MEDIO_ENVIO, true, null);
			if (parametrosRepository.findAll(Example.of(oparametro_1)).isEmpty()) {
				oparametro_1 = parametrosRepository.save(oparametro_1);
			}
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-parametro", e);
		}
		try {
			OParametros oparametro_10 = new OParametros(null, "10", "INTERNO", MEDIO_ENVIO, true, null);
			if (parametrosRepository.findAll(Example.of(oparametro_10)).isEmpty()) {
				oparametro_10 = parametrosRepository.save(oparametro_10);
			}
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-parametro", e);
		}
		try {
			OParametros oparametro_11 = new OParametros(null, "11", "EXTERNO (INACTIVO)", MEDIO_ENVIO, true, null);
			if (parametrosRepository.findAll(Example.of(oparametro_11)).isEmpty()) {
				oparametro_11 = parametrosRepository.save(oparametro_11);
			}
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-parametro", e);
		}
		try {
			OParametros oparametro_12 = new OParametros(null, "12", "EXPEDIENTE DIGITAL WEB", MEDIO_ENVIO, true, null);
			if (parametrosRepository.findAll(Example.of(oparametro_12)).isEmpty()) {
				oparametro_12 = parametrosRepository.save(oparametro_12);
			}
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-parametro", e);
		}
		try {
			OParametros oparametro_15 = new OParametros(null, "15", "PQRSDF", MEDIO_ENVIO, true, null);
			if (parametrosRepository.findAll(Example.of(oparametro_15)).isEmpty()) {
				oparametro_15 = parametrosRepository.save(oparametro_15);
			}
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-parametro", e);
		}
		try {
			OParametros oparametro_2 = new OParametros(null, "2", "CORREO", MEDIO_ENVIO, true, null);
			if (parametrosRepository.findAll(Example.of(oparametro_2)).isEmpty()) {
				oparametro_2 = parametrosRepository.save(oparametro_2);
			}
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-parametro", e);
		}
		try {
			OParametros oparametro_3 = new OParametros(null, "3", "E-MAIL", MEDIO_ENVIO, true, null);
			if (parametrosRepository.findAll(Example.of(oparametro_3)).isEmpty()) {
				oparametro_3 = parametrosRepository.save(oparametro_3);
			}
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-parametro", e);
		}
		try {
			OParametros oparametro_4 = new OParametros(null, "4", "FAX", MEDIO_ENVIO, true, null);
			if (parametrosRepository.findAll(Example.of(oparametro_4)).isEmpty()) {
				oparametro_4 = parametrosRepository.save(oparametro_4);
			}
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-parametro", e);
		}
		try {
			OParametros oparametro_5 = new OParametros(null, "5", "PORTAL WEB", MEDIO_ENVIO, true, null);
			if (parametrosRepository.findAll(Example.of(oparametro_5)).isEmpty()) {
				oparametro_5 = parametrosRepository.save(oparametro_5);
			}
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-parametro", e);
		}
		try {
			OParametros oparametro_6 = new OParametros(null, "6", "ENTREGA PERSONAL", MEDIO_ENVIO, true, null);
			if (parametrosRepository.findAll(Example.of(oparametro_6)).isEmpty()) {
				oparametro_6 = parametrosRepository.save(oparametro_6);
			}
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-parametro", e);
		}
		try {
			OParametros oparametro_7 = new OParametros(null, "7", "CONSULTA PERSONAL", MEDIO_ENVIO, true, null);
			if (parametrosRepository.findAll(Example.of(oparametro_7)).isEmpty()) {
				oparametro_7 = parametrosRepository.save(oparametro_7);
			}
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-parametro", e);
		}
		try {
			OParametros oparametro_8 = new OParametros(null, "8", "CONSULTA TELEFONICA", MEDIO_ENVIO, true, null);
			if (parametrosRepository.findAll(Example.of(oparametro_8)).isEmpty()) {
				oparametro_8 = parametrosRepository.save(oparametro_8);
			}
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-parametro", e);
		}
		try {
			OParametros oparametro_999 = new OParametros(null, "999", "HISTORICO", MEDIO_ENVIO, true, null);
			if (parametrosRepository.findAll(Example.of(oparametro_999)).isEmpty()) {
				oparametro_999 = parametrosRepository.save(oparametro_999);
			}
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-parametro", e);
		}

		// PROCESO

		OProceso proceso = null;
		try {
			proceso = new OProceso(null, 0, "TODOS", true);
			List<OProceso> list = procesoRepository.findAll(Example.of(proceso));
			if (list.isEmpty())
				procesoRepository.save(proceso);
			else
				proceso = list.get(0);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-proceso", e);
		}

		OProceso proceso1 = null;
		try {
			proceso1 = new OProceso(null, 1, "ASUNTOS DESPACHO SUPERINTENDENTE", true);
			List<OProceso> list = procesoRepository.findAll(Example.of(proceso1));
			if (list.isEmpty())
				procesoRepository.save(proceso1);
			else
				proceso1 = list.get(0);
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-proceso1", e);
		}

		// TIPO EXPEDIENTE
		OTipoExpediente otipoExpA = null;
		try {
			otipoExpA = new OTipoExpediente(null, "A", "ADMINISTRATIVO", null);
			List<OTipoExpediente> list = tipoExpedienteRepository.findAll(Example.of(otipoExpA));
			if (list.isEmpty())
				tipoExpedienteRepository.save(otipoExpA);
			else
				otipoExpA = list.get(0);
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

		// TRAMITE
		try {
			OTramite oparametro_1001 = new OTramite(null, 1001, "COMUNICACIONES ENTIDADES DEL ESTADO", 100,
					"DESPACHO DEL SUPERINTENDENTE", true, 10, true, null, proceso1, otipodocumentalActas,
					tipoRadicacionEntrada, otipoExpA, OSerie.builder().id(actas.getId()).build(),
					OSubSerie.builder().id(actassub1.getId()).build(), ocuadernoNA, otipoSegA);
			if (tramiteRelacionesRepository.findAll(Example.of(oparametro_1001)).isEmpty()) {
				oparametro_1001 = tramiteRelacionesRepository.save(oparametro_1001);
			}
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-tramite-1001", e);
		}
		try {
			OTramite oparametro_1001 = new OTramite(null, 1001, "COMUNICACIONES ENTIDADES DEL ESTADO", 100,
					"DESPACHO DEL SUPERINTENDENTE", true, 10, true, null, proceso1, otipodocumentalActas,
					tipoRadicacionEntrada, otipoExpA, actas, actassub2, ocuadernoNA, otipoSegA);
			if (tramiteRelacionesRepository.findAll(Example.of(oparametro_1001)).isEmpty()) {
				oparametro_1001 = tramiteRelacionesRepository.save(oparametro_1001);
			}
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-tramite-1001", e);
		}
		try {
			OTramite oparametro_1001 = new OTramite(null, 1001, "COMUNICACIONES ENTIDADES DEL ESTADO", 100,
					"DESPACHO DEL SUPERINTENDENTE", true, 10, true, null, proceso1, otipodocumentalActas,
					tipoRadicacionEntrada, otipoExpA, actas, actassub3, ocuadernoNA, otipoSegA);
			if (tramiteRelacionesRepository.findAll(Example.of(oparametro_1001)).isEmpty()) {
				oparametro_1001 = tramiteRelacionesRepository.save(oparametro_1001);
			}
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-tramite-1001", e);
		}
		try {
			OTramite oparametro_1001 = new OTramite(null, 1001, "COMUNICACIONES ENTIDADES DEL ESTADO", 100,
					"DESPACHO DEL SUPERINTENDENTE", true, 10, true, null, proceso1, otipodocumentalActas,
					tipoRadicacionSalida, otipoExpA, actas, actassub1, ocuadernoNA, otipoSegA);
			if (tramiteRelacionesRepository.findAll(Example.of(oparametro_1001)).isEmpty()) {
				oparametro_1001 = tramiteRelacionesRepository.save(oparametro_1001);
			}
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-tramite-1001", e);
		}
		try {
			OTramite oparametro_1001 = new OTramite(null, 1001, "COMUNICACIONES ENTIDADES DEL ESTADO", 100,
					"DESPACHO DEL SUPERINTENDENTE", true, 10, true, null, proceso1, otipodocumentalActas,
					tipoRadicacionSalida, otipoExpA, actas, actassub2, ocuadernoNA, otipoSegA);
			if (tramiteRelacionesRepository.findAll(Example.of(oparametro_1001)).isEmpty()) {
				oparametro_1001 = tramiteRelacionesRepository.save(oparametro_1001);
			}
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-tramite-1001", e);
		}
		try {
			OTramite oparametro_1001 = new OTramite(null, 1001, "COMUNICACIONES ENTIDADES DEL ESTADO", 100,
					"DESPACHO DEL SUPERINTENDENTE", true, 10, true, null, proceso1, otipodocumentalActas,
					tipoRadicacionSalida, otipoExpA, actas, actassub3, ocuadernoNA, otipoSegA);
			if (tramiteRelacionesRepository.findAll(Example.of(oparametro_1001)).isEmpty()) {
				oparametro_1001 = tramiteRelacionesRepository.save(oparametro_1001);
			}
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-tramite-1001", e);
		}
		try {
			OTramite oparametro_1001 = new OTramite(null, 1001, "COMUNICACIONES ENTIDADES DEL ESTADO", 100,
					"DESPACHO DEL SUPERINTENDENTE", true, 10, true, null, proceso1, otipodocumentalActas,
					tipoRadicacionInterna, otipoExpA, actas, actassub1, ocuadernoNA, otipoSegA);
			if (tramiteRelacionesRepository.findAll(Example.of(oparametro_1001)).isEmpty()) {
				oparametro_1001 = tramiteRelacionesRepository.save(oparametro_1001);
			}
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-tramite-1001", e);
		}
		try {
			OTramite oparametro_1001 = new OTramite(null, 1001, "COMUNICACIONES ENTIDADES DEL ESTADO", 100,
					"DESPACHO DEL SUPERINTENDENTE", true, 10, true, null, proceso1, otipodocumentalActas,
					tipoRadicacionInterna, otipoExpA, actas, actassub2, ocuadernoNA, otipoSegA);
			if (tramiteRelacionesRepository.findAll(Example.of(oparametro_1001)).isEmpty()) {
				oparametro_1001 = tramiteRelacionesRepository.save(oparametro_1001);
			}
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-tramite-1001", e);
		}
		try {
			OTramite oparametro_1001 = new OTramite(null, 1001, "COMUNICACIONES ENTIDADES DEL ESTADO", 100,
					"DESPACHO DEL SUPERINTENDENTE", true, 10, true, null, proceso1, otipodocumentalActas,
					tipoRadicacionInterna, otipoExpA, actas, actassub3, ocuadernoNA, otipoSegA);
			if (tramiteRelacionesRepository.findAll(Example.of(oparametro_1001)).isEmpty()) {
				oparametro_1001 = tramiteRelacionesRepository.save(oparametro_1001);
			}
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-tramite-1001", e);
		}

		try {
			OTramite oparametro_999 = new OTramite(null, 8002, "8002", 547, "GRUPO DE GESTION DOCUMENTAL", true, 10,
					true, null, proceso1, otipodocumentalTodos, tipoRadicacionEntrada, otipoExpA,
					OSerie.builder().id(oserietodas.getId()).build(),
					OSubSerie.builder().id(osubserietodas.getId()).seriePadre(oserietodas.getId()).build(),
					ocuadernoTodos, otipoSegA);
			if (tramiteRelacionesRepository.findAll(Example.of(oparametro_999)).isEmpty()) {
				oparametro_999 = tramiteRelacionesRepository.save(oparametro_999);
			}
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-parametro", e);
		}

		try {
			OTramite oparametro_999 = new OTramite(null, 29001, "29001", 547, "GRUPO DE GESTION DOCUMENTAL", true, 10,
					true, null, proceso1, otipodocumentalTodos, tipoRadicacionEntrada, otipoExpA,
					OSerie.builder().id(oserietodas.getId()).build(),
					OSubSerie.builder().id(osubserietodas.getId()).seriePadre(oserietodas.getId()).build(),
					ocuadernoTodos, otipoSegA);
			if (tramiteRelacionesRepository.findAll(Example.of(oparametro_999)).isEmpty()) {
				oparametro_999 = tramiteRelacionesRepository.save(oparametro_999);
			}
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-parametro", e);
		}

		try {
			OTramite otramite_151001 = new OTramite(null, 151001,
					"SOLICITUDES Y DISEÑOS DE FORMULARIOS OFICIALES PRESENTACIÓN INFORMACIÓN", 108,
					"GRUPO DE INNOV, DESARROLLO Y ARQ. DE APLICACIONES", true, 10, true, null, proceso1,
					otipodocumentalTodos, tipoRadicacionEntrada, otipoExpA,
					OSerie.builder().id(oserietodas.getId()).build(),
					OSubSerie.builder().id(osubserietodas.getId()).seriePadre(oserietodas.getId()).build(),
					ocuadernoTodos, otipoSegA);
			if (tramiteRelacionesRepository.findAll(Example.of(otramite_151001)).isEmpty()) {
				otramite_151001 = tramiteRelacionesRepository.save(otramite_151001);
			}
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-parametro", e);
		}

		try {
			OTramite otramite_151001 = new OTramite(null, 151001,
					"SOLICITUDES Y DISEÑOS DE FORMULARIOS OFICIALES PRESENTACIÓN INFORMACIÓN", 108,
					"GRUPO DE INNOV, DESARROLLO Y ARQ. DE APLICACIONES", true, 10, true, null, proceso1,
					otipodocumentalTodos, tipoRadicacionInterna, otipoExpA,
					OSerie.builder().id(oserietodas.getId()).build(),
					OSubSerie.builder().id(osubserietodas.getId()).seriePadre(oserietodas.getId()).build(),
					ocuadernoTodos, otipoSegA);
			if (tramiteRelacionesRepository.findAll(Example.of(otramite_151001)).isEmpty()) {
				otramite_151001 = tramiteRelacionesRepository.save(otramite_151001);
			}
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-parametro", e);
		}

		try {
			OTramite otramite_151001 = new OTramite(null, 151001,
					"SOLICITUDES Y DISEÑOS DE FORMULARIOS OFICIALES PRESENTACIÓN INFORMACIÓN", 108,
					"GRUPO DE INNOV, DESARROLLO Y ARQ. DE APLICACIONES", true, 10, true, null, proceso1,
					otipodocumentalTodos, tipoRadicacionSalida, otipoExpA,
					OSerie.builder().id(oserietodas.getId()).build(),
					OSubSerie.builder().id(osubserietodas.getId()).seriePadre(oserietodas.getId()).build(),
					ocuadernoTodos, otipoSegA);
			if (tramiteRelacionesRepository.findAll(Example.of(otramite_151001)).isEmpty()) {
				otramite_151001 = tramiteRelacionesRepository.save(otramite_151001);
			}
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-parametro", e);
		}

		try {
			OTramite otramite_180021 = new OTramite(null, 180021,
					"SOLICITUDES Y DISEÑOS DE FORMULARIOS OFICIALES PRESENTACIÓN INFORMACIÓN", 108,
					"GRUPO DE INNOV, DESARROLLO Y ARQ. DE APLICACIONES", true, 10, true, null, proceso1,
					otipodocumentalTodos, tipoRadicacionEntrada, otipoExpA,
					OSerie.builder().id(oserietodas.getId()).build(),
					OSubSerie.builder().id(osubserietodas.getId()).seriePadre(oserietodas.getId()).build(), ocuadernoNA,
					otipoSegDep);
			if (tramiteRelacionesRepository.findAll(Example.of(otramite_180021)).isEmpty()) {
				otramite_180021 = tramiteRelacionesRepository.save(otramite_180021);
			}
		} catch (Exception e) {
			LOGGER.debug("constantsVerifier-run crear-parametro", e);
		}

		LOGGER.debug("constantsVerifier-run end {}ms", System.currentTimeMillis() - start);

	}
}
