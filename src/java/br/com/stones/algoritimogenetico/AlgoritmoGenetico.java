package br.com.stones.algoritimogenetico;

import br.com.stones.model.algoritimogenetico.PontoPartida;
import br.com.stones.model.algoritimogenetico.Roteiro;
import br.com.stones.model.algoritimogenetico.Endereco;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jgap.InvalidConfigurationException;

public class AlgoritmoGenetico {

    public static void main(String[] args) throws IOException {
        Roteiro roteiro = new Roteiro();        

        List<Endereco> pontos = new ArrayList<>();

        // Ponto de partida
        Endereco endereco = new Endereco();
        endereco.setDescricao("Ponto de partida - Ituporanga");
        //(4208500, "Ituporanga",  "SC", -27.4101, -49.5963),
        endereco.setLatitude(-27.4101);
        endereco.setLongitude(-49.5963);
        PontoPartida pontoPartida = new PontoPartida(endereco);
        roteiro.setPontoPartida(pontoPartida);

        endereco = new Endereco();
        endereco.setDescricao("Laura Meneghini Ribeiro    -Aurora");
        //(4201901, "Aurora",      "SC", -27.3098, -49.6295),
        endereco.setLatitude(-27.3098);
        endereco.setLongitude(-49.6295);
        

        pontos.add(endereco);

        endereco = new Endereco();
        endereco.setDescricao("Aizhis Linda Boaventura Luz   -    Rio do Sul ");
        //(4214805, "Rio do Sul",  "SC", -27.2156, -49.643),
        endereco.setLatitude(-27.2156);
        endereco.setLongitude(-49.643);
        
        pontos.add(endereco);

        endereco = new Endereco();
        endereco.setDescricao("Emanuelli V. Brugalli Gonçalves    -    Lontras");
        //(4209904, "Lontras", "SC", -27.1684, -49.535),
        endereco.setLatitude(-27.1684);
        endereco.setLongitude(-49.535);
        
        pontos.add(endereco);

        endereco = new Endereco();
        endereco.setDescricao("Leticia Bortoli Noel   -  Blumenau");
        //(4202404, "Blumenau", "SC", -26.9155, -49.0709),
        endereco.setLatitude(-26.9155);
        endereco.setLongitude(-49.0709);
        
        pontos.add(endereco);

        endereco = new Endereco();
        endereco.setDescricao("João Augusto Budinhac   -    Ibirama");
        //(4206900, "Ibirama", "SC", -27.0547, -49.5193),
        endereco.setLatitude(-27.0547);
        endereco.setLongitude(-49.5193);
        
        pontos.add(endereco);

        endereco = new Endereco();
        endereco.setDescricao("João Augusto Budinhac   -    Ibirama");
        //(4208203, "Itajaí", "SC", -26.9101, -48.6705),
        endereco.setLatitude(-26.9101);
        endereco.setLongitude(-48.6705);
        
        pontos.add(endereco);

        endereco = new Endereco();
        endereco.setDescricao("João Augusto Budinhac   -    Ibirama");
        //(4201703, "Ascurra", "SC", -26.9548, -49.3783),
        endereco.setLatitude(-26.9548);
        endereco.setLongitude(-49.3783);
        
        pontos.add(endereco);

        endereco = new Endereco();
        endereco.setDescricao("João Augusto Budinhac   -    Ibirama");
        ////(4201257, "Apiúna", "SC", -27.0375, -49.3885),
        endereco.setLatitude(-27.0375);
        endereco.setLongitude(-49.3885);
        
        pontos.add(endereco);
        
        endereco = new Endereco();
        endereco.setDescricao("João Augusto Budinhac   -    Ibirama");
        //(4202008, "Balneário Camboriú", "SC", -26.9926, -48.6352),
        endereco.setLatitude(-26.9926);
        endereco.setLongitude(-48.6352);
        
        pontos.add(endereco);  
        
        endereco = new Endereco();
        endereco.setDescricao("João Augusto Budinhac   -    Ibirama");
        //(4205902, "Gaspar", "SC", -26.9336, -48.9534),
        endereco.setLatitude(-26.9336);
        endereco.setLongitude(-48.9534);
        
        pontos.add(endereco);  
        
        endereco = new Endereco();
        endereco.setDescricao("João Augusto Budinhac   -    Ibirama");
        //(4207502, "Indaial", "SC", -26.8992, -49.2354),
        endereco.setLatitude(-26.8992);
        endereco.setLongitude(-49.2354);
        
        pontos.add(endereco);  
        
        roteiro.setEnderecos(pontos);

        Algoritmo algoritmo = new Algoritmo(roteiro, 500);
        try {
            algoritmo.executar();
        } catch (InvalidConfigurationException ex) {
            Logger.getLogger(AlgoritmoGenetico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
