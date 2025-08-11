package org.example.RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.Naming;

public class RMIServer {
    public static void main(String[] args) {
        try {
            MensageiroRemoto mensageiro = new MensageiroImpl();
            LocateRegistry.createRegistry(1099); // Inicia o RMI Registry na porta 1099

            // Registra o objeto remoto no Registry com o nome "Mensageiro"
            Naming.rebind("rmi://localhost:1099/Mensageiro", mensageiro);

            System.out.println("Servidor RMI pronto para receber chamadas.");
        } catch (Exception e) {
            System.err.println("Erro no servidor RMI: " + e.getMessage());
            e.printStackTrace();
        }
    }
}