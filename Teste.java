import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.CharArrayReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.*;
import java.util.Arrays;

import javax.swing.plaf.multi.MultiButtonUI;
import javax.swing.text.html.HTMLDocument.BlockElement;

class Teste implements Cloneable {
    private int app_id;
    private String nome;

    public int getApp_id() {
        return app_id;
    }
    public void setApp_id(int app_id) {
        this.app_id = app_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Teste() {

    }

    public Teste(int app_id, String nome) {
        this.app_id = app_id;
        this.nome = nome;
    }

    /*public void StringParse(String linha, String id) {
        String categoria = "";
        int virgulas = linha.indexOf(',');

        for (int i = 0; i < virgulas; i++) {
            categoria = categoria + linha.charAt(i);
        }

        if (categoria.equals(id)) {

            String[] array = linha.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

            setApp_id(array[0]);
            setNome(array[1]);
        }
    }
    */

    public static Teste ler(String frase) throws IOException, ParseException {
        Scanner arquivo = new Scanner(new File("games.csv"));
        String[] linha = new String[4403];
        Teste jogo = new Teste();

        int n = 0;
        while (arquivo.hasNext()) {
            linha[n] = arquivo.nextLine();
            n++;
        }

        for(int i = 0; i < n; i++) {
            String categoria = "";
            int virgulas = linha[i].indexOf(',');

            for(int k = 0; k < virgulas; k++) {
                categoria = categoria + linha[i].charAt(k);
            }

            if(categoria.equals(frase)) {
                jogo = new Teste();
                String[] array = linha[i].split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

                jogo.setApp_id(Integer.parseInt(array[0]));
                jogo.setNome(array[1]);
            }
        }
        return jogo;
    }

    public static boolean pesquisaBinaria(String[] vet, String x) {
        boolean teste = false;
        int direita = (vet.length - 1), esquerda = 0, meio;

        while (esquerda <= direita) {
            meio = (esquerda + direita) / 2;
            if(x.compareTo(vet[meio]) == 0) {
                teste = true;
                esquerda = direita + 1;
            }
            else if (x.compareTo(vet[meio]) > 0) {
                esquerda = meio + 1;
            }
            else {
                direita = meio - 1;
            }
        }
        return teste;
    }

    static boolean isFim(String palavra) {
        boolean result = false;
        if (palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M') {
            result = true;
        }
        return result;
    }

    public static void main(String[] args) throws IOException, ParseException {
        String aux = "";
        String[] aux2 = new String[3];
        Teste GAME = new Teste();
        int n = 0;
        boolean teste = false;
        long Inicio = System.currentTimeMillis();
        int comparacoes = 0;

        aux = MyIO.readLine();
        while (isFim(aux) == false) {
            GAME = ler(aux);
            aux2[n] = GAME.getNome();
            aux = MyIO.readLine();
            n++;
        }
        aux = MyIO.readLine();
        while (isFim(aux) == false) {
            Arrays.sort(aux2);
            for(int i = 0; i < n; i++) {
                if(pesquisaBinaria(aux2, aux)) {
                    teste = true;
                    comparacoes++;
                }
                else {
                    teste = false;
                }
                comparacoes++;
            }
            if(teste == false) {
                System.out.println("NAO");
            }
            else {
                System.out.println("SIM");
            }
            aux = MyIO.readLine();
        }

        long Final = System.currentTimeMillis();
        long tempoCodigo = Final - Inicio;
        comparacoes = comparacoes + 1;
        BufferedWriter arquivo = new BufferedWriter (new FileWriter("matrícula_binaria.txt"));
        arquivo.write("763674\t" + tempoCodigo + "\t" + comparacoes );
        arquivo.close();
    }
}