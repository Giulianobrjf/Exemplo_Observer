package org.example;

import java.util.Observable;

public class Suporte extends Observable {
    private String ultimaMensagem;
    private String atendente;
        public Suporte(String atendente){
            this.atendente = atendente;

        }
        public void receberPedido(String mensagem){
            this.ultimaMensagem = mensagem;
            setChanged();
            notifyObservers(mensagem);
        }
    @Override
    public String toString() {
        return "Suporte{" + "Atendido por: "+ atendente+
                "\n ultimaMensagem='" + ultimaMensagem + '\'' +
                '}';
    }
}
