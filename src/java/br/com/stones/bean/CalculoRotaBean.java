package br.com.stones.bean;

import br.com.stones.algoritimogenetico.Algoritmo;
import br.com.stones.algoritimogenetico.AlgoritmoGenetico;
import br.com.stones.model.Cesta;
import br.com.stones.model.Municipio;
import br.com.stones.model.algoritimogenetico.Endereco;
import br.com.stones.model.algoritimogenetico.PontoPartida;
import br.com.stones.model.algoritimogenetico.Roteiro;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.jgap.InvalidConfigurationException;

@ManagedBean(name = "calculoRotaBean")
@ViewScoped
public class CalculoRotaBean extends AbstractBean implements Serializable {

    //instancias necessarias para gerar a rota
    List<Cesta> cestas;
    Roteiro roteiro;
    List<Endereco> pontos;
    Municipio municipioPartida;

    @PostConstruct
    public void init() {
        roteiro = new Roteiro();
        pontos = new ArrayList<>();
        cestasDisponíveis();
    }

    private void cestasDisponíveis() {
        cestas = daoFactory.getCestaDao().buscarTodos();
    }

    public void montarRota() throws IOException {
        this.roteiro.setEnderecos(null);
        for (Cesta umaCesta : this.cestas) {
            Endereco oEndereco = new Endereco();
            oEndereco.setDescricao(umaCesta.getCliente().getMunicipio().getDescricao());
            oEndereco.setLatitude(umaCesta.getCliente().getMunicipio().getLatitude());
            oEndereco.setLongitude(umaCesta.getCliente().getMunicipio().getLongitude());
            pontos.add(oEndereco);
        }
        this.roteiro.setEnderecos(pontos);

        Algoritmo algoritmo = new Algoritmo(roteiro, 10000);

        try {
            this.roteiro = algoritmo.executar();
        } catch (InvalidConfigurationException ex) {
            Logger.getLogger(AlgoritmoGenetico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Municipio getMunicipioPartida() {
        return municipioPartida;
    }

    public void setMunicipioPartida(Municipio municipioPartida) {
        Endereco endereco = new Endereco();
        endereco.setDescricao(municipioPartida.getDescricao());
        endereco.setLatitude(municipioPartida.getLatitude());
        endereco.setLongitude(municipioPartida.getLongitude());
        PontoPartida pontoPartida = new PontoPartida(endereco);
        this.roteiro.setPontoPartida(pontoPartida);
    }

    public List<Cesta> getCestas() {
        return cestas;
    }

    public Roteiro getRoteiro() {
        return roteiro;
    }

    public List<Endereco> getPontos() {
        return pontos;
    }
}
