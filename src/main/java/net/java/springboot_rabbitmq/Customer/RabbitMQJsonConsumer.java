package net.java.springboot_rabbitmq.Customer;

import net.java.springboot_rabbitmq.Dto.Usuario;
import net.java.springboot_rabbitmq.Service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonConsumer {

    private static  final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonConsumer.class);

private final EmailService emailService;

    public RabbitMQJsonConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = {"${rabbitmq.queue.json.name}"})
    public void consumeJsonMensaje(Usuario usuario) {
        LOGGER.info(String.format("Mensaje JSON recibido -> %s", usuario.toString()));


        String subject = usuario.getSubject();  // Asunto del correo
        String body = usuario.getBody();        // Cuerpo del correo


        if (usuario.getCorreo() != null && !usuario.getCorreo().isEmpty()) {
            // Enviar el correo usando la dirección de correo, asunto y cuerpo del JSON
            emailService.enviarEmail(usuario.getCorreo(), subject, body);
            LOGGER.info("Correo enviado a: " + usuario.getCorreo());
        } else {
            LOGGER.error("El correo electrónico no está definido.");
        }
    }
}
