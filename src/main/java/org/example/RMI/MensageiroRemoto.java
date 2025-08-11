package org.example.RMI;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MensageiroRemoto extends Remote {
    String digaOla(String nome) throws RemoteException;
}