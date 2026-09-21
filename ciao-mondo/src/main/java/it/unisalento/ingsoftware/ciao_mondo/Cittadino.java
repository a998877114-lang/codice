package it.unisalento.ingsoftware.ciao_mondo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Cittadino {
    private String nome;
    private String cognome;
    private Citta citta;
    private Residenza residenza;

    @Autowired
    public Cittadino(Citta citta, Residenza residenza) {
        this.citta = citta;
        this.residenza = residenza;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Citta getCitta() {
        return citta;
    }

    public void setCitta(Citta citta) {
        this.citta = citta;
    }

    public Residenza getResidenza() {
        return residenza;
    }

    public void setResidenza(Residenza residenza) {
        this.residenza = residenza;
    }

    public void ciaoCittadino(String nomeCitta, String nomeCittaResidenza) {
        System.out.println("Ciao " + nome + " " + cognome);
        citta.setNome(nomeCitta);
        System.out.println("Che vivi a " + citta.getNome());
        residenza.setIndirizzo("Via Garibaldi 13");
        citta.setNome(nomeCittaResidenza);
        System.out.println("E che risiedi in " + residenza.getIndirizzo() + " a " + residenza.getCitta().getNome());
    }
}
