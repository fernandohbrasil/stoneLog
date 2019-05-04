package br.com.stones.model;

import java.io.Serializable;
import java.util.Objects;

public class Cesta implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private int id;    
    private double valor;
    private Cliente cliente;

    public Cesta() {
    }

    public Cesta(int id, double valor, Cliente cliente) {
        this.id = id;
        this.valor = valor;
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id;
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.valor) ^ (Double.doubleToLongBits(this.valor) >>> 32));
        hash = 67 * hash + Objects.hashCode(this.cliente);
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
        final Cesta other = (Cesta) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.valor) != Double.doubleToLongBits(other.valor)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        return true;
    }

}
