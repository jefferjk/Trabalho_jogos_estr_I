/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_jogos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jefferson.kist
 */
public class Apoio {
    private String genero;
    private List<Double> scores;
    private double melhorPorcentagem;
    private int melhor;
    private int plataforma;
    private List<Double> scoresPlataforma;
    private String melhorJogo;
    private double MelhorJogoAvaliado;
    private String piorJogo;
    private String generoMaisComum;
    private double piorJogoAvaliado;
    public Apoio() {
        scores = new ArrayList<Double>();
        scoresPlataforma = new ArrayList<>();
    }
     public String getGeneroJogo() {
        return genero;
    }

    public void setGeneroJogo(String genre) {
        this.genero = genre;
    }

    public int getMasterpiece() {
        return melhor;
    }

    public void setMasterpiece(int masterpiece) {
        this.melhor = masterpiece;
    }

    public double getAmazingPercentage() {
        return melhorPorcentagem;
    }

    public void setAmazingPercentage(double amazingPercentage) {
        this.melhorPorcentagem = amazingPercentage;
    }

    public double getMelhorJogoAvaliado() {
        return MelhorJogoAvaliado;
    }

    public void setMelhorJogoAvaliado(double bestGameScore) {
        this.MelhorJogoAvaliado = bestGameScore;
    }

    public String getMelhorJogo() {
        return melhorJogo;
    }

    public void setMelhorJogo(String bestGame) {
        this.melhorJogo = bestGame;
    }

    public double getPiorJogoAvaliado() {
        return piorJogoAvaliado;
    }

    public void setPiorJogoAvaliado(double worstGameScore) {
        this.piorJogoAvaliado = worstGameScore;
    }

    public String getPiorJogo() {
        return piorJogo;
    }

    public void setPiorJogo(String worstGame) {
        this.piorJogo = worstGame;
    }

    public String getMostCommonGenre() {
        return generoMaisComum;
    }

    public void setMostCommonGenre(String mostCommonGenre) {
        this.generoMaisComum = mostCommonGenre;
    }

    public int getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(int getPlataforma) {
        this.plataforma = getPlataforma;
    }

    public List<Double> getScores() {
        return scores;
    }

    public void setScores(List<Double> scores) {
        this.scores = scores;
    }

    public List<Double> getScoresNintendo() {
        return scoresPlataforma;
    }

    public void setScoresNintendo(List<Double> scoresNintendo) {
        this.scoresPlataforma = scoresNintendo;
    }
    public int getNReviews() {
        return getScores().size(); // retorna o tamanho
    }
    public double getMedia() {
        double totalScore = 0.0;
        for (Double score : getScores()) {
            totalScore = totalScore + score;
        }
        return totalScore / getNReviews(); // total dividido pelo tamanho para obter a média
    }
    public double getMediaImpressao() {
        double totalScore = 0.0;
        for (Double score : scoresPlataforma) {
            totalScore = totalScore + score;
        }
        return totalScore / plataforma;
    }
    
    
    public double getDesvioPadrao() { ///calculo do desvio padrao
        double media = getMedia(); //coleta a média na função já pronta
        double var = 0.0;
        for (Double score : getScores()) {
            var = var + Math.pow(score - media, 2.0); // base elevada pelo expoente
        }
        var = var / getNReviews();
        return Math.sqrt(var); //efetua calculo de raiz quadrada para obter o resultado do desvio padrao
    }
}
