package br.com.stones.bean;

import br.com.stones.model.Categoria;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "categoriaBean")
@ViewScoped
public class CategoriaBean extends AbstractBean implements Serializable {

    private Categoria categoria;
    private List<Categoria> categorias;

    @PostConstruct
    public void init() {
        categoria = new Categoria();
        atualizaLista();
    }
    
    public void salvar() {
        if (categoria.getId() > 0) {
            if (daoFactory.getCategoriaDao().update(categoria)) {
                addInfoMessage("Salvo com Sucesso");
                categoria = new Categoria();
                atualizaLista();
            } else {
                addErrorMessage("Erro ao Salvar");
            }
        } else {
            categoria.setId(daoFactory.getCategoriaDao().getNextId());
            if (daoFactory.getCategoriaDao().insert(categoria)) {
                addInfoMessage("Salvo com Sucesso");
                categoria = new Categoria();
                atualizaLista();
            } else {
                addErrorMessage("Erro ao Salvar");
            }
        }
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Categoria> getCategorias() {
        try {
            return categorias;
        } catch (Exception e) {
            return null;
        }
    }

    private void atualizaLista() {
        this.categorias = daoFactory.getCategoriaDao().buscarTodos();
    }
    
    public void alterar(Categoria c) {
        this.categoria = c;        
    }
}
