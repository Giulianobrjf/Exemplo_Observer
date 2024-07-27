package org.example;

import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer {
        private String nome;
        private String ultimaNotificacao;

        public Cliente(String nome){
            this.nome = nome;
        }
        public String getUltimaNotificacao(){
                return this.ultimaNotificacao;
        }
        public void solicitarSuporte(Suporte suporte){
            suporte.addObserver(this);
        }
        public void update (Observable suporte,  Object arg1){
            this.ultimaNotificacao = this.nome + ", você tem uma nova atualização do suporte: " + suporte.toString();
          //  System.out.println(this.ultimaNotificacao);
        }
}
