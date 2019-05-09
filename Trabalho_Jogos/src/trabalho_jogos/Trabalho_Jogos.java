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

               
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    
     // INICIA A IMPRESSÃO DOS DADOS
      
        for (String k : map.keySet()) {
            System.out.println("------------------------------------------------------------------");
            System.out.println("Gênero: " + k );
            System.out.println("");
            System.out.println("Percentual de Reviews do tipo 'Amazing': " + (map.get(k).getAmazingPercentage()));

        }
    }
    
}
