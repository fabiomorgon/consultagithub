package br.com.alura.consultagithub.principal;

import br.com.alura.consultagithub.excecao.ErroConsultaGitHubException;
import br.com.alura.consultagithub.modelos.RetornoGitRecord;
import br.com.alura.consultagithub.modelos.UsuarioGit;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println("Informe a conta a ser pesquisada: ");
        Scanner leitura = new Scanner(System.in);
        String usuario = leitura.nextLine();
        String uriConsulta = "https://api.github.com/users/" + usuario;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uriConsulta))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String retornoGit = response.body();
        System.out.println(retornoGit);

        Gson gson = new GsonBuilder()
                .create();
        RetornoGitRecord retornoGitRecord = gson.fromJson(retornoGit, RetornoGitRecord.class);
        try {
            UsuarioGit usuarioGit = new UsuarioGit(retornoGitRecord);
            System.out.println(usuarioGit);
        } catch (ErroConsultaGitHubException e) {
            System.out.println(e.getMessage());
        }
    }
}