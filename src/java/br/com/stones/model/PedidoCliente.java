package br.com.stones.model;

import java.io.Serializable;
import java.util.Objects;

public class PedidoCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Cliente cliente;
    private Produto produto;
    private int status;

    public PedidoCliente() {
    }

    public PedidoCliente(Cliente cliente, Produto produto, int status) {
        this.cliente = cliente;
        this.produto = produto;
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.cliente);
        hash = 43 * hash + Objects.hashCode(this.produto);
        hash = 43 * hash + this.status;
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
        final PedidoCliente other = (PedidoCliente) obj;
        if (this.status != other.status) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        return true;
    }       
}
