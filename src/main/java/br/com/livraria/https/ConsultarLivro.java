package br.com.livraria.https;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.File;
import java.util.Scanner;

@Path("/livros")
public class ConsultarLivro {

    private static final String FILE_PATH = "livros.json";

    @GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarLivros() {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("{\"erro\": \"Nenhum livro cadastrado ainda!\"}")
                        .build();
            }

            StringBuilder jsonContent = new StringBuilder();
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                jsonContent.append(scanner.nextLine());
            }
            scanner.close();

            return Response.ok(jsonContent.toString()).build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"erro\": \"Erro ao ler os livros!\"}")
                    .build();
        }
    }
}
