package br.com.stones.bean;

import br.com.stones.model.Categoria;
import br.com.stones.model.OrdemCompra;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "ordemCompraBean")
@ViewScoped
public class OrdemCompraBean extends AbstractBean implements Serializable {
    
    OrdemCompra ordemCompra;
    
    @PostConstruct
    public void init() {
        ordemCompra = new OrdemCompra();
        //atualizaLista();
    }
    
    public void salvar() {
        if (ordemCompra.getId() > 0) {
            if (daoFactory.getOrdemCompraDao().update(ordemCompra)) {
                addInfoMessage("Salvo com Sucesso");
                ordemCompra = new OrdemCompra();
                //atualizaLista();
            } else {
                addErrorMessage("Erro ao Salvar");
            }
        } else {
            ordemCompra.setId(daoFactory.getOrdemCompraDao().getNextId());
            if (daoFactory.getOrdemCompraDao().insert(ordemCompra)) {
                addInfoMessage("Salvo com Sucesso");
                ordemCompra = new OrdemCompra();
                //atualizaLista();
            } else {
                addErrorMessage("Erro ao Salvar");
            }
        }
    }

    public OrdemCompra getOrdemCompra() {
        return ordemCompra;
    }

    public void setOrdemCompra(OrdemCompra ordemCompra) {
        this.ordemCompra = ordemCompra;
    }
    
}
