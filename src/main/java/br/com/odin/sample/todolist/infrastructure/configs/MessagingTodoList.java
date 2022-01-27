package br.com.odin.sample.todolist.infrastructure.configs;

import br.com.odin.sample.todolist.shared.avro.TodoListAvro;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

import static io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG;
import static org.apache.kafka.clients.producer.ProducerConfig.*;

@Configuration
public class MessagingTodoList  implements MessagingConfig<TodoListAvro> {

    @Autowired
    private KafkaProperties kafkaProperties;

    @Bean("producerTodoList")
    @Override
    public Producer<String, TodoListAvro> configureProducer() {
        Properties properties = this.getProperties();
        properties.put(KEY_SERIALIZER_CLASS_CONFIG, kafkaProperties.getKeySerializer());
        properties.put(VALUE_SERIALIZER_CLASS_CONFIG, kafkaProperties.getValueSerializer());
        return new KafkaProducer<String, TodoListAvro>(properties);

    }

    @Bean("consumerTodoList")
    @Override
    public Consumer<String,TodoListAvro> configureConsumer() {

        Properties properties = this.getProperties();
        properties.put(KEY_DESERIALIZER_CLASS_CONFIG, kafkaProperties.getKeyDeserializer());
        properties.put(VALUE_DESERIALIZER_CLASS_CONFIG, kafkaProperties.getValueDeserializer());
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "consumer-group-todolist");
        return new KafkaConsumer<String, TodoListAvro>(properties);
    }

    private Properties getProperties(){

        Properties properties = new Properties();

        properties.put(BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        properties.put(ACKS_CONFIG, kafkaProperties.getAcksConfig());
        properties.put(RETRIES_CONFIG, kafkaProperties.getRetriesConfig());
        properties.put(SCHEMA_REGISTRY_URL_CONFIG, kafkaProperties.getSchemaRegistryUrl());

        return properties;
    }
}
