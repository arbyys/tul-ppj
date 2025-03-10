package app.assignments.app;

import app.assignments.config.MessageConfig;
import app.assignments.config.ReplyMessageConfig;
import app.assignments.config.WriterConfig;
import app.assignments.message.PingMessage;
import app.assignments.message.CustomMessage;
import app.assignments.message.ReplyMessage;
import app.assignments.message.Message;
import app.assignments.writer.StdoutWriter;
import app.assignments.writer.ListWriter;
import app.assignments.writer.Writer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Configuration
@Import({
        ReplyMessageConfig.class,
        WriterConfig.class
})
@ComponentScan("app.assignments")
public class Main {

    public static void main(String[] args) {

        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/application-context.xml");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Main.class);

        Message ping = applicationContext.getBean(PingMessage.class);
        Message hello = applicationContext.getBean(CustomMessage.class);
        Message pingReply = applicationContext.getBean(ReplyMessage.class);

        Writer stdoutWriter = applicationContext.getBean(StdoutWriter.class);
        ListWriter listWriter = applicationContext.getBean(ListWriter.class);
        stdoutWriter.write(ping);
        stdoutWriter.write(hello);
        stdoutWriter.write(pingReply);


        listWriter.write(ping);
        listWriter.listWrittenMessages().forEach(stdoutWriter::write);

    }

}
