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
     public String getGeneroJogo() {
        return genero;
    }
     
      public void setGeneroJogo(String genre) {
        this.genero = genre;
    }
      
      public List<Double> getScores() {
        return scores;
    }

    public void setScores(List<Double> scores) {
        this.scores = scores;
    }
    public double getAmazingPercentage() {
        return melhorPorcentagem;
    }

    public void setAmazingPercentage(double amazingPercentage) {
        this.melhorPorcentagem = amazingPercentage;
    }

    
}
