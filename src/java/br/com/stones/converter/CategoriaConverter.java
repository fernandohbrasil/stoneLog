package br.com.stones.converter;

import br.com.stones.model.Categoria;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Categoria.class)
public class CategoriaConverter extends AbstractConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id = Integer.parseInt(string);
        return daoFactory.getCategoriaDao().getCategoria(id);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Categoria categoria = (Categoria) o;
        String retorno = Integer.toString(categoria.getId());
        return retorno;
    }
}
