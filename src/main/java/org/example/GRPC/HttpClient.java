package org.example.GRPC;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.IOException;

public class HttpClient {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient cliente = HttpClients.createDefault();
        HttpGet requisicao = new HttpGet("https://api.github.com/users/google");

        System.out.println("Chamando a URL...");
        CloseableHttpResponse resposta = cliente.execute(requisicao);

        String corpoDaResposta = EntityUtils.toString(resposta.getEntity());
        System.out.println("Resposta recebida:");
        System.out.println(corpoDaResposta);

        resposta.close();
    }
}