package br.com.stones.model;

import java.io.Serializable;
import java.util.Objects;

public class OrdemCompra implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private int id;
    private int status;
    private String fornecedor;
    private double custoAquisicao;
    private int quantidade;
    private Produto produto;

    public OrdemCompra() {
    }

    public OrdemCompra(int id, int status, String fornecedor, double custoAquisicao, int quantidade, Produto produto) {
        this.id = id;
        this.status = status;
        this.fornecedor = fornecedor;
        this.custoAquisicao = custoAquisicao;
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public double getCustoAquisicao() {
        return custoAquisicao;
    }

    public void setCustoAquisicao(double custoAquisicao) {
        this.custoAquisicao = custoAquisicao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.id;
        hash = 67 * hash + this.status;
        hash = 67 * hash + Objects.hashCode(this.fornecedor);
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.custoAquisicao) ^ (Double.doubleToLongBits(this.custoAquisicao) >>> 32));
        hash = 67 * hash + this.quantidade;
        hash = 67 * hash + Objects.hashCode(this.produto);
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
        final OrdemCompra other = (OrdemCompra) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (Double.doubleToLongBits(this.custoAquisicao) != Double.doubleToLongBits(other.custoAquisicao)) {
            return false;
        }
        if (this.quantidade != other.quantidade) {
            return false;
        }
        if (!Objects.equals(this.fornecedor, other.fornecedor)) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        return true;
    }        
}
