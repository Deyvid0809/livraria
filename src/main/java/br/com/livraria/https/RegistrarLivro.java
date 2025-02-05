package br.com.livraria.https;

import br.com.livraria.Class.Livro;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

@Path("livro")
public class RegistrarLivro {

    private static final String FILE_PATH = "livros.json";

    @POST
    @Path("/cadastrar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response cadastrarLivro(Livro livro) {
        if (livro.getTitulo() == null || livro.getAutor() == null || livro.getEditora() == null || livro.getIsbn() == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity ("{\"erro\": \"Título, autor, isbn e editora são obrigatórios!\"}")
                    .build();
        }


        salvarLivrojson(livro);

        return Response.ok ("{\"mensagem\": \"Livro cadastrado com sucesso!\"}").build();
    }

    private void salvarLivrojson(Livro livro) {

        try {


            File file = new File(FILE_PATH);
            StringBuilder jsonContent = new StringBuilder("{");

            if (file.exists()) {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    jsonContent.append(scanner.nextLine());
                }
                scanner.close();

                if (jsonContent.length() > 1) {
                    jsonContent.deleteCharAt(jsonContent.length() - 1);
                    jsonContent.append(",");
                }
            }
            jsonContent.append("\"")
                    .append(livro.getTitulo())
                    .append("\": {\"titulo\": \"")
                    .append(livro.getTitulo())
                    .append("\", \"autor\": \"")
                    .append(livro.getAutor())
                    .append("\", \"isbn\": \"")
                    .append(livro.getIsbn())
                    .append("\", \"editora\": \"")
                    .append(livro.getEditora())
                    .append("\"}");


            FileWriter writer = new FileWriter(FILE_PATH, false);
                    writer.write(jsonContent.toString());
                    writer.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
