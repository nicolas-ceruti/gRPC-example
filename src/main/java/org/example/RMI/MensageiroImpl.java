package org.example.RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MensageiroImpl extends UnicastRemoteObject implements MensageiroRemoto {

    public MensageiroImpl() throws RemoteException {
        super();
    }

    @Override
    public String digaOla(String nome) throws RemoteException {
        // Como o add do exemplo do professor, metodo que fica no servidor

        System.out.println("Chamada de método recebida: digaOla(" + nome + ")");
        return "Olá, " + nome + "! A mensagem veio do servidor RMI.";
    }
}