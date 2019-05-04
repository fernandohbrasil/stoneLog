package br.com.stones.bean;

import br.com.stones.model.ContasReceber;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "contasReceberBean")
@ViewScoped
public class ContasReceberBean extends AbstractBean implements Serializable {
    
    private ContasReceber contasReceber;
    
    @PostConstruct
    public void init() {
        contasReceber = new ContasReceber();      
    }
    
    public void salvar() {
        if (contasReceber.getId() > 0) {
            if (daoFactory.getContasReceberDao().update(contasReceber)) {
                addInfoMessage("Salvo com Sucesso");
                contasReceber = new ContasReceber();                
            } else {
                addErrorMessage("Erro ao Salvar");
            }
        } else {
            contasReceber.setId(daoFactory.getContasReceberDao().getNextId());
            if (daoFactory.getContasReceberDao().insert(contasReceber)) {
                addInfoMessage("Salvo com Sucesso");
                contasReceber = new ContasReceber();                
            } else {
                addErrorMessage("Erro ao Salvar");
            }
        }
    }

    public ContasReceber getContasReceber() {
        try {
            return contasReceber;
        } catch (Exception e) {
            return null;
        }
    }

    public void setContasReceber(ContasReceber contasReceber) {
        this.contasReceber = contasReceber;
    }
    
    
    
}
