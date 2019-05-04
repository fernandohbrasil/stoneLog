package br.com.stones.model.algoritimogenetico;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Roteiro implements Serializable{

    private PontoPartida pontoPartida;
    private List<Endereco> enderecos;

    public Roteiro() {
    }

    public Roteiro(PontoPartida pontoPartida, List<Endereco> enderecos) {
        this.pontoPartida = pontoPartida;
        this.enderecos = enderecos;
    }

    public PontoPartida getPontoPartida() {
        return pontoPartida;
    }

    public void setPontoPartida(PontoPartida pontoPartida) {
        this.pontoPartida = pontoPartida;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.pontoPartida);
        hash = 31 * hash + Objects.hashCode(this.enderecos);
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
        final Roteiro other = (Roteiro) obj;
        if (!Objects.equals(this.pontoPartida, other.pontoPartida)) {
            return false;
        }
        if (!Objects.equals(this.enderecos, other.enderecos)) {
            return false;
        }
        return true;
    }

    
}
