package app.assignments.config;

import app.assignments.message.CustomMessage;
import app.assignments.message.PingMessage;
import app.assignments.message.ReplyMessage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


@Configuration
public class MessageConfig {
    @Bean
    @Scope("prototype")
    public PingMessage pingMessage() {
        return new PingMessage();
    }

    @Bean
    public CustomMessage customMessage() {
        return new CustomMessage("Boleslav", "Vaclav", "umřels");
    }

}
