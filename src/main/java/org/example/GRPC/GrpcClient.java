package org.example.GRPC;

import br.com.seuprojeto.SeuServicoGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import br.com.seuprojeto.Pedido;
import br.com.seuprojeto.Resposta;

public class GrpcClient {

    public static void main(String[] args) {
        // Conecta no servidor gRPC
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        // Cria o "stub" (o objeto que faz a chamada)
        SeuServicoGrpc.SeuServicoBlockingStub stub = SeuServicoGrpc.newBlockingStub(channel);

        // Monta a requisição
        Pedido pedido = Pedido.newBuilder()
                .setNome("Nicolas")
                .setFatorial(5)
                .build();


        System.out.println("Chamando o serviço gRPC...");

        // Chama o serviço e pega a resposta
        Resposta resposta = stub.retornarFatorial(pedido);

        System.out.println("Resposta do servidor: " + resposta.getMessage());

        // Desliga a conexão
        channel.shutdown();
    }
}
