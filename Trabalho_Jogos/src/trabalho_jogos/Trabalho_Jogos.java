/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_jogos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.TreeMap;

/**
 *
 * @author jefferson.kist
 */
public class Trabalho_Jogos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       TreeMap<String, Apoio> map = new TreeMap<String, Apoio>();
        
        int total = 0;
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("game-reviews.csv"));
            String linha = null;
            String[] linhaSplit = null;
            Apoio g = null;
            br.readLine();
            while ((linha = br.readLine()) != null) {
                linhaSplit = linha.split(";");
                total++;

                if (!map.containsKey(linhaSplit[4])) { //procura o Genero do jogo na 5º coluna do csv
                    g = new Apoio();
                    g.setGeneroJogo(linhaSplit[4]);//seta o genero da lina
                    map.put(g.getGeneroJogo(), g);                    
                } else { g = map.get(linhaSplit[4]); } //se não for o mesmo genero muda

                g.getScores().add(Double.valueOf(linhaSplit[3])); //coleta o score do jogo

                if (linhaSplit[2].equals("Amazing") || linhaSplit[2].equals("amazing")) {  //coleta os amazing p calcular a %
                    g.setAmazingPercentage(g.getAmazingPercentage() + 1);
                }

                if (linhaSplit[2].equals("Masterpiece") || linhaSplit[2].equals("masterpiece")) {
                    g.setMasterpiece(g.getMasterpiece() + 1);
                }

                if (linhaSplit[4].equals("Action")) {
                    g.setPlataforma(g.getPlataforma() + 1);
                    g.getScoresNintendo().add(Double.valueOf(linhaSplit[3]));
                }

                if (g.getMelhorJogo() == null || g.getMelhorJogoAvaliado() < Double.valueOf(linhaSplit[3])) {
                    g.setMelhorJogo(linhaSplit[0]);
                    g.setMelhorJogoAvaliado(Double.valueOf(linhaSplit[3]));
                }

                if (g.getPiorJogo() == null || g.getPiorJogoAvaliado() > Double.valueOf(linhaSplit[3])) {
                    g.setPiorJogo(linhaSplit[0]);
                    g.setPiorJogoAvaliado(Double.valueOf(linhaSplit[3]));
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String plataforma = null;
        
     

        // INICIA A IMPRESSÃO DOS DADOS
        double console = 0;
        double median = 0.0;
        for (String k : map.keySet()) {
            System.out.println("------------------------------------------------------------------");
            System.out.println("Gênero: " + k );
            System.out.println("");
            System.out.println("Número de reviews: " + map.get(k).getNReviews());
            System.out.println("Percentual de Reviews do tipo 'Amazing': " + (map.get(k).getAmazingPercentage()));
            System.out.println("Média Aritmética: " +  map.get(k).getMedia());
            System.out.println("Desvio Padrão: " + map.get(k).getDesvioPadrao());
            System.out.println("Melhor jogo: " + map.get(k).getMelhorJogo());
            System.out.println("Pior jogo: " + map.get(k).getPiorJogo());


            if (plataforma == "null" || console < map.get(k).getPlataforma()) {
                if (map.get(k).getMediaImpressao()> console) {
                    plataforma = k;
                    console = map.get(k).getMediaImpressao();
                    
                }
            }

        }
        System.out.println("");
        System.out.println("");
        System.out.println("");
        
        System.out.println("Genero mais comum da Nintendo: " + plataforma);
        System.out.println("");
        System.out.println("");
    }
}
