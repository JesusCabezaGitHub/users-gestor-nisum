package tech.nisum.user_managment.configurations;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "Gestor de Usuarios - Nisum",
                description = "Api rest para prueba técnica dentro del proceso de selección Fullstack Java - Angular",
                contact = @Contact(
                        name = "Jesús Cabeza Acero",
                        url = "https://www.linkedin.com/in/jesus-cabeza-acero/",
                        email = "jesusenriquecabezaacero@gmail.com"
                ),
                license = @License(
                        name = "MIT Licence",
                        url = "https://github.com/thombergs/code-examples/blob/master/LICENSE"
                )
        ),
        servers = @Server(url = "http://localhost:8080")
)
public class SwaggerConfiguration {
}
