package net.java.springboot_rabbitmq.Dto;


import java.io.Serializable;

public class Usuario implements Serializable {

        private String correo;
        private String subject;
        private String body;

        // Getters y setters
        public String getCorreo() {
            return correo;
        }

        public void setCorreo(String correo) {
            this.correo = correo;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }



}
