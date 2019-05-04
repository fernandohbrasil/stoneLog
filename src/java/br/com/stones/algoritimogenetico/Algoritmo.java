package br.com.stones.algoritimogenetico;

import br.com.stones.model.algoritimogenetico.Endereco;
import br.com.stones.model.algoritimogenetico.Roteiro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.FitnessFunction;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.InvalidConfigurationException;
import org.jgap.impl.BestChromosomesSelector;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.IntegerGene;

public class Algoritmo {

    Roteiro roteiro;
    int nMaxEvolucoes;

    public Algoritmo(Roteiro roteiro, int nMaxEvolucoes) {
        this.roteiro = roteiro;
        this.nMaxEvolucoes = nMaxEvolucoes;
    }

    public Roteiro executar() throws InvalidConfigurationException, IOException {

        //inicia configuração do algoritimo padrao
        Configuration conf = new DefaultConfiguration();

        //cria objeto fitness
        FitnessFunction fitness = new Fitness(roteiro);
        conf.setFitnessFunction(fitness);

        // criar um seletor que nao permite duplicações
        conf.getNaturalSelectors(false).clear();
        BestChromosomesSelector bcs = new BestChromosomesSelector(conf, 1.0d);
        bcs.setDoubletteChromosomesAllowed(false);
        conf.addNaturalSelector(bcs, false);

        // cria um array de genes tamanho quantia de enderecos
        Gene[] genes = new Gene[roteiro.getEnderecos().size()];

        for (int i = 0; i < genes.length; i++) {
            genes[i] = new IntegerGene(conf, 0, roteiro.getEnderecos().size() - 1);
            genes[i].setAllele(i);
        }

        //cria um cromosomo com os genes definidos
        Chromosome chromosome = new Chromosome(conf, genes);

        //adiciona o cromosomoa configuracao
        conf.setSampleChromosome(chromosome);

        //seta o numero da populacao 
        conf.setPopulationSize(80);

        //inicia uma populacao randomicamente apartir do cromosomo criado
        Genotype populacao = Genotype.randomInitialGenotype(conf);

        //evolui a populacao o numero de vezes definido anteriormente
        for (int i = 0; i < nMaxEvolucoes; i++) {
            //Fitness
            populacao.evolve();
        }

        //pega a melhor solucao da populacao
        IChromosome melhor_solucao = populacao.getFittestChromosome();
        List <Endereco> enderecos = new ArrayList<>();

        //Passo a melhor solução para uma lista de endereços que será o retorno da função
        for (Gene gene : melhor_solucao.getGenes()) {
            Endereco oEdereco = roteiro.getEnderecos().get(((Integer) gene.getAllele()));
            enderecos.add(oEdereco);                        
        }
        
        Roteiro oRoteiro = new Roteiro(roteiro.getPontoPartida() , enderecos);        
        return oRoteiro;
    }

}
