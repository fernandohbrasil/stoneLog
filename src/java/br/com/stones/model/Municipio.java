package br.com.stones.model;

import java.io.Serializable;
import java.util.Objects;

public class Municipio implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private int codigo_ibge;
    private String descricao;
    private String uf;
    private double latitude;
    private double longitude;

    public Municipio(int codigo_ibge, String descricao, String uf, double latitude, double longitude) {
        this.codigo_ibge = codigo_ibge;
        this.descricao = descricao;
        this.uf = uf;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Municipio() {
    }

    public int getCodigo_ibge() {
        return codigo_ibge;
    }

    public void setCodigo_ibge(int codigo_ibge) {
        this.codigo_ibge = codigo_ibge;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.codigo_ibge;
        hash = 97 * hash + Objects.hashCode(this.descricao);
        hash = 97 * hash + Objects.hashCode(this.uf);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.latitude) ^ (Double.doubleToLongBits(this.latitude) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.longitude) ^ (Double.doubleToLongBits(this.longitude) >>> 32));
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
        final Municipio other = (Municipio) obj;
        if (this.codigo_ibge != other.codigo_ibge) {
            return false;
        }
        if (Double.doubleToLongBits(this.latitude) != Double.doubleToLongBits(other.latitude)) {
            return false;
        }
        if (Double.doubleToLongBits(this.longitude) != Double.doubleToLongBits(other.longitude)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.uf, other.uf)) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public String toString() {
        return uf + " - "+descricao;
    }

}
