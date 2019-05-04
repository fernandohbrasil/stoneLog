package br.com.stones.algoritimogenetico;

import br.com.stones.model.algoritimogenetico.Endereco;
import br.com.stones.model.algoritimogenetico.Roteiro;
import org.jgap.FitnessFunction;
import org.jgap.IChromosome;

public class Fitness extends FitnessFunction {

    private Roteiro roteiro;

    public Fitness() {
    }

    public Fitness(Roteiro roteiro) {
        this.roteiro = roteiro;
    }

    @Override
    protected double evaluate(IChromosome ic) {
        double fitness;
        fitness = calcularDistancia(ic);
        fitness += verificaPontosIguais(ic) * 1000;
        return 1000000 - fitness;
    }
    
    public int verificaPontosIguais(IChromosome ic){
        int n = 0;
        for (int i = 0; i < ic.getGenes().length; i++) {
            for (int j = 0; j < ic.getGenes().length; j++) {
                if (ic.getGene(i).getAllele().equals(ic.getGene(j).getAllele())){
                    n++;
                }
            }
        }
        return n;
    }

    public double calcularDistancia(IChromosome ic) {
        double distanciaTotal = 0;
        Endereco end1, end2;

        end1 = roteiro.getEnderecos().get((Integer) ic.getGene(0).getAllele());

        //calcula discancia do ponto de partida para o primeiro gene
        distanciaTotal += distance(roteiro.getPontoPartida().getEndereco().getLatitude(), 
                roteiro.getPontoPartida().getEndereco().getLongitude(), 
                end1.getLatitude(), end1.getLongitude());

        //calcula distancia de um gene ao outro
        for (int i = 1; i < ic.getGenes().length; i++) {
            end1 = roteiro.getEnderecos().get(((Integer) ic.getGene(i - 1).getAllele()));
            end2 = roteiro.getEnderecos().get(((Integer) ic.getGene(i).getAllele()));

            distanciaTotal += distance(end1.getLatitude(), end1.getLongitude(),
                    end2.getLatitude(), end2.getLongitude());
        }
        end1 = roteiro.getEnderecos().get((Integer) ic.getGene(ic.getGenes().length - 1).getAllele());

        //calcula a distancia do ultimo gene para o ponto de partoda
        distanciaTotal += distance(roteiro.getPontoPartida().getEndereco().getLatitude(),
                roteiro.getPontoPartida().getEndereco().getLongitude(),
                end1.getLatitude(), end1.getLongitude());

        return distanciaTotal;
    }

    public double distance(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        dist = dist * 1.609344;
        return (dist);
    }

    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }

}
