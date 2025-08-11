package org.example.RMI;

import java.rmi.Naming;

public class RMIClient {
    public static void main(String[] args) {
        try {
            // Procura pelo objeto remoto no RMI Registry
            MensageiroRemoto mensageiro = (MensageiroRemoto) Naming.lookup("rmi://localhost:1099/Mensageiro");

            // Invoca o método remoto
            String resposta = mensageiro.digaOla("Mundo Java");

            System.out.println("Resposta do servidor: " + resposta);
        } catch (Exception e) {
            System.err.println("Erro no cliente RMI: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
