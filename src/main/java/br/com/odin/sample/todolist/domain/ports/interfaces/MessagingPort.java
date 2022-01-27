package br.com.odin.sample.todolist.domain.ports.interfaces;

import br.com.odin.sample.todolist.shared.avro.TodoListAvro;
import org.apache.avro.specific.SpecificRecordBase;
import org.apache.kafka.clients.producer.ProducerRecord;

public interface MessagingPort<T extends SpecificRecordBase> {
	
	String topic();
	
	ProducerRecord<String, T> createProducerRecord(T type);

	void send(TodoListAvro todoListAvro);

	void read();
}
