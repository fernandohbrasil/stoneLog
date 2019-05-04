package br.com.stones.bean;

import br.com.stones.model.Produto;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "produtoBean")
@ViewScoped
public class ProdutoBean extends AbstractBean implements Serializable {

    private Produto produto;
    private List<Produto> produtos;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @PostConstruct
    public void init() {
        produto = new Produto();
        atualizaLista();
    }

    public void salvar() {
        if (produto.getId() > 0) {
            if (daoFactory.getProdutoDao().update(produto)) {
                addInfoMessage("Salvo com Sucesso");
                produto = new Produto();
                atualizaLista();
            } else {
                addInfoMessage("Erro ao Salvar");
            }
        } else {
            produto.setId(daoFactory.getProdutoDao().getNextId());            
            if (daoFactory.getProdutoDao().insert(produto)) {
                addInfoMessage("Salvo com Sucesso");
                produto = new Produto();
                atualizaLista();
            } else {
                addErrorMessage("Erro ao Salvar");
            }
        }
    }

    public List<Produto> getProdutos() {
        try {
            return produtos;
        } catch (Exception e) {
            return null;
        }
    }

    private void atualizaLista() {
        this.produtos = daoFactory.getProdutoDao().buscarTodos();
    }
    
    public void alterar(Produto p) {
        this.produto = p;        
    }
}
