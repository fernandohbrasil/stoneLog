package br.com.stones.converter;

import br.com.stones.model.Produto;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Produto.class)
public class ProdutoConverter extends AbstractConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id = Integer.parseInt(string);
        return daoFactory.getProdutoDao().getProduto(id);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Produto produto =  (Produto) o;
        String retorno = Integer.toString(produto.getId());
        return retorno;
    }

}
