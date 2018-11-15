package lt.bta.java2.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJsonProvider;

import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import static org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJaxbJsonProvider.DEFAULT_ANNOTATIONS;

public class ClientProducer {

    private JacksonJsonProvider jsonProvider;

    public ClientProducer() {
        // Create an ObjectMapper to be used for (de)serializing to/from JSON.
        ObjectMapper objectMapper = new ObjectMapper();
        // Register the JavaTimeModule for JSR-310 DateTime (de)serialization
        objectMapper.registerModule(new JavaTimeModule());
        // Configure the object mapper te serialize to timestamp strings.
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        // Create a Jackson Provider
        this.jsonProvider = new JacksonJaxbJsonProvider(objectMapper, DEFAULT_ANNOTATIONS);
    }

    @Produces
    public Client produceClient() {

        return ClientBuilder.newClient()
                // Register the jsonProvider
                .register(this.jsonProvider);
    }
}
