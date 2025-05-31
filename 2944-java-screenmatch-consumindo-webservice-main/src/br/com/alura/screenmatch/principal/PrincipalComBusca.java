package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Titulo;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o nome do filme para busca:");
        var busca = leitura.next();

        String endereco = "https://www.omdbapi.com/?t=" + busca + "&apikey=f896c64f";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        System.out.println(json);

        Gson gson = new Gson();
        Titulo meuTitulo = gson.fromJson(json, Titulo.class);
        // esse código da erro. Pela explicação do Paulo, eu entendi que, como o json gerado está com os nomes em ingles
        // e o codigo esta com os atributos em portugues, e durante avarredura do Gson no jason, não foi encontrado as
        // referencias corretas
        // tem que mudar o formato de conversão
        System.out.println(meuTitulo);
    }
}
