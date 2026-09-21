package it.unisalento.ingsoftware.ciao_mondo;

import org.springframework.stereotype.Component;

@Component
public class Citta {
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
