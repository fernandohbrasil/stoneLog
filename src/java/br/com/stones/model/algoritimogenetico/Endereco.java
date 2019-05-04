package br.com.stones.model.algoritimogenetico;

import java.io.Serializable;
import java.util.Objects;

public class Endereco implements Serializable{

    private double latitude;
    private double longitude;    
    private String descricao;
    private Roteiro roteiro;

    public Endereco() {
    }

    public Endereco(double latitude, double longitude, String descricao, Roteiro roteiro) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.descricao = descricao;
        this.roteiro = roteiro;
    }

    
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
 
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }       

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.latitude) ^ (Double.doubleToLongBits(this.latitude) >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.longitude) ^ (Double.doubleToLongBits(this.longitude) >>> 32));
        hash = 17 * hash + Objects.hashCode(this.descricao);
        hash = 17 * hash + Objects.hashCode(this.roteiro);
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
        final Endereco other = (Endereco) obj;
        if (Double.doubleToLongBits(this.latitude) != Double.doubleToLongBits(other.latitude)) {
            return false;
        }
        if (Double.doubleToLongBits(this.longitude) != Double.doubleToLongBits(other.longitude)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.roteiro, other.roteiro)) {
            return false;
        }
        return true;
    }
    
    
}
