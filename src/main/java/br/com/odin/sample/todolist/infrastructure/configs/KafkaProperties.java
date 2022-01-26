package br.com.odin.sample.todolist.infrastructure.configs;

import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(
    prefix = "kafka"
)
public class KafkaProperties {
	
	private List<String> bootstrapServers;
	private String acksConfig;
	private String retriesConfig;
	private Class<?> keySerializer = StringSerializer.class;
	private Class<?> valueSerializer = KafkaAvroSerializer.class;
	private String schemaRegistryUrl;

	public List<String> getBootstrapServers() {
		return bootstrapServers;
	}

	public void setBootstrapServers(List<String> bootstrapServers) {
		this.bootstrapServers = bootstrapServers;
	}

	public String getAcksConfig() {
		return acksConfig;
	}

	public void setAcksConfig(String acksConfig) {
		this.acksConfig = acksConfig;
	}

	public String getRetriesConfig() {
		return retriesConfig;
	}

	public void setRetriesConfig(String retriesConfig) {
		this.retriesConfig = retriesConfig;
	}

	public Class<?> getKeySerializer() {
		return keySerializer;
	}

	public void setKeySerializer(Class<?> keySerializer) {
		this.keySerializer = keySerializer;
	}

	public Class<?> getValueSerializer() {
		return valueSerializer;
	}

	public void setValueSerializer(Class<?> valueSerializer) {
		this.valueSerializer = valueSerializer;
	}

	public String getSchemaRegistryUrl() {
		return schemaRegistryUrl;
	}

	public void setSchemaRegistryUrl(String schemaRegistryUrl) {
		this.schemaRegistryUrl = schemaRegistryUrl;
	}
}
