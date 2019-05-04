package br.com.stones.model.algoritimogenetico;

import java.io.Serializable;
import java.util.Objects;


public class PontoPartida implements Serializable{
    
    private Endereco endereco;

    public PontoPartida() {
    }

    public PontoPartida(Endereco endereco) {
        this.endereco = endereco;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.endereco);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PontoPartida other = (PontoPartida) obj;
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
