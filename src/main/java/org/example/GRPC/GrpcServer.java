package org.example.GRPC;

import br.com.seuprojeto.Pedido;
import br.com.seuprojeto.Resposta;
import br.com.seuprojeto.SeuServicoGrpc;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;

public class GrpcServer {

    private Server server;

    // 1. Classe interna que implementa a base do serviço gRPC
    static class SeuServicoImpl extends SeuServicoGrpc.SeuServicoImplBase {

        // 2. Metodo que definimos no .proto
        @Override
        public void retornarFatorial(Pedido request, StreamObserver<Resposta> responseObserver) {
            System.out.println("Recebi uma requisição do cliente: " + request.getNome());

            long numeroParaCalcular = request.getFatorial();
            long resultado = 1;

            for (long i = 1; i <= numeroParaCalcular; i++) {
                resultado = resultado * i;
            }

            // 3. Resposta
            String mensagem = "Olá, " + request.getNome() + "! Tudo certo por aqui. O fatorial de " + numeroParaCalcular + " é " + resultado  ;
            Resposta resposta = Resposta.newBuilder().setMessage(mensagem).build();

            // 4. Envio da resposta para o cliente
            responseObserver.onNext(resposta);

            // 5. Finalização a chamada
            responseObserver.onCompleted();
        }
    }

    // Metodo para iniciar o servidor
    private void start() throws IOException {
        int port = 50051;
        server = ServerBuilder.forPort(port)
                .addService(new SeuServicoImpl())
                .build()
                .start();

        System.out.println("✅ Servidor gRPC iniciado na porta " + port);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("*** Desligando o servidor gRPC ***");
            GrpcServer.this.stop();
            System.err.println("*** Servidor desligado ***");
        }));
    }

    // Metodo para parar o servidor
    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    // Metodo para manter o servidor rodando em primeiro plano
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        final GrpcServer server = new GrpcServer();
        server.start();
        server.blockUntilShutdown();
    }
}