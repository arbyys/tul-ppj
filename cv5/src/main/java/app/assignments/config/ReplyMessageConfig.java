package app.assignments.config;

import app.assignments.message.Message;
import app.assignments.message.ReplyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({MessageConfig.class})
public class ReplyMessageConfig {

    @Autowired
    @Qualifier("pingMessage")
    public Message replyMessage;

    @Bean
    public ReplyMessage replyMessage() {
        return new ReplyMessage(replyMessage, "pong");
    }
}
