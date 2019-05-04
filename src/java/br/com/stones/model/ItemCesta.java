package br.com.stones.model;

import java.io.Serializable;
import java.util.Objects;

public class ItemCesta implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private int cestaId;
    private int sequencia;
    private double valorAtual;
    private Produto produto;

    public ItemCesta() {
    }

    public ItemCesta(int cestaId, int sequencia, double valorAtual, Produto produto) {
        this.cestaId = cestaId;
        this.sequencia = sequencia;
        this.valorAtual = valorAtual;
        this.produto = produto;
    }

    public int getCestaId() {
        return cestaId;
    }

    public void setCestaId(int cestaId) {
        this.cestaId = cestaId;
    }

    public int getSequencia() {
        return sequencia;
    }

    public void setSequencia(int sequencia) {
        this.sequencia = sequencia;
    }

    public double getValorAtual() {
        return valorAtual;
    }

    public void setValorAtual(double valorAtual) {
        this.valorAtual = valorAtual;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.cestaId;
        hash = 97 * hash + this.sequencia;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.valorAtual) ^ (Double.doubleToLongBits(this.valorAtual) >>> 32));
        hash = 97 * hash + Objects.hashCode(this.produto);
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
        final ItemCesta other = (ItemCesta) obj;
        if (this.cestaId != other.cestaId) {
            return false;
        }
        if (this.sequencia != other.sequencia) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorAtual) != Double.doubleToLongBits(other.valorAtual)) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        return true;
    }           
}
