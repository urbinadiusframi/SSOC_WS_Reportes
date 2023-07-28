package co.gov.ssoc.gedess.sgd.cfg.audit;

//import static io.debezium.data.Envelope.FieldName.AFTER;
//import static io.debezium.data.Envelope.FieldName.BEFORE;
//import static io.debezium.data.Envelope.FieldName.OPERATION;
import static java.util.stream.Collectors.toMap;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.commons.lang3.tuple.Pair;
//import org.apache.kafka.connect.data.Field;
//import org.apache.kafka.connect.data.Struct;
//import org.apache.kafka.connect.source.SourceRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

//import io.debezium.config.Configuration;
//import io.debezium.data.Envelope.Operation;
//import io.debezium.embedded.Connect;
//import io.debezium.engine.DebeziumEngine;
//import io.debezium.engine.RecordChangeEvent;
//import io.debezium.engine.format.ChangeEventFormat;

//@Component
public class DebeziumListener {

//	private static final Logger LOGGER = LoggerFactory.getLogger("audit-events");
//
//	private final Executor executor = Executors.newSingleThreadExecutor();
//	private final DebeziumEngine<RecordChangeEvent<SourceRecord>> debeziumEngine;
//
//	@Autowired
//	private KafkaTemplate<String, String> kafkaTemplate;
//
//	public void sendMessage(String message) {
//		kafkaTemplate.send("auditoria_log", message);
//	}
//
//	public DebeziumListener(Configuration customerConnectorConfiguration) {
//
//		this.debeziumEngine = DebeziumEngine.create(ChangeEventFormat.of(Connect.class))
//				.using(customerConnectorConfiguration.asProperties()).notifying(this::handleChangeEvent).build();
//
////		this.customerService = customerService;
//	}
//
//	private void handleChangeEvent(RecordChangeEvent<SourceRecord> sourceRecordRecordChangeEvent) {
//		SourceRecord sourceRecord = sourceRecordRecordChangeEvent.record();
//
//		LOGGER.info("Key = '{}' value = '{}'", sourceRecord.key(), sourceRecord.value());
//
//		Struct sourceRecordChangeValue = (Struct) sourceRecord.value();
//
//		if (sourceRecordChangeValue != null) {
//			Operation operation = Operation.forCode((String) sourceRecordChangeValue.get(OPERATION));
//			if (operation != Operation.READ) {
//				String record = operation == Operation.DELETE ? BEFORE : AFTER; // Handling Update & Insert operations.
//
//				Struct struct = (Struct) sourceRecordChangeValue.get(record);
//				Map<String, Object> payload = struct.schema().fields().stream().map(Field::name)
//						.filter(fieldName -> struct.get(fieldName) != null)
//						.map(fieldName -> Pair.of(fieldName, struct.get(fieldName)))
//						.collect(toMap(Pair::getKey, Pair::getValue));
//
////				this.customerService.replicateData(payload, operation);
//				LOGGER.info("Updated Data: {} with Operation: {}", payload, operation.name());
//				sendMessage(struct.toString());
//			}
//		}
//	}
//
//	@PostConstruct
//	private void start() {
//		this.executor.execute(debeziumEngine);
//	}
//
//	@PreDestroy
//	private void stop() throws IOException {
//		if (this.debeziumEngine != null) {
//			this.debeziumEngine.close();
//		}
//	}

}
