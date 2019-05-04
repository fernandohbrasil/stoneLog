package br.com.stones.model;

import java.io.Serializable;
import java.util.Objects;

public class Cliente implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private int id;
    private String nome;
    private String cpf;
    private String email;
    private String bairro;
    private String rua;
    private String numero;
    private String telefone;
    private Municipio municipio;

    public Cliente(int id, String nome, String cpf, String email, String bairro, String rua, String numero, String telefone, Municipio municipio) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.telefone = telefone;
        this.municipio = municipio;
    }

    public Cliente() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.id;
        hash = 17 * hash + Objects.hashCode(this.nome);
        hash = 17 * hash + Objects.hashCode(this.cpf);
        hash = 17 * hash + Objects.hashCode(this.email);
        hash = 17 * hash + Objects.hashCode(this.bairro);
        hash = 17 * hash + Objects.hashCode(this.rua);
        hash = 17 * hash + Objects.hashCode(this.numero);
        hash = 17 * hash + Objects.hashCode(this.telefone);
        hash = 17 * hash + Objects.hashCode(this.municipio);
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
        final Cliente other = (Cliente) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.bairro, other.bairro)) {
            return false;
        }
        if (!Objects.equals(this.rua, other.rua)) {
            return false;
        }
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.municipio, other.municipio)) {
            return false;
        }
        return true;
    }

}
