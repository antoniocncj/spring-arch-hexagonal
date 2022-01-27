package br.com.odin.sample.todolist.infrastructure.configs;

import org.apache.avro.specific.SpecificRecordBase;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.producer.Producer;
import org.springframework.stereotype.Component;

public interface MessagingConfig<T extends SpecificRecordBase> {
	
	Producer<String, T> configureProducer();

	Consumer<String, T> configureConsumer();
	
}
