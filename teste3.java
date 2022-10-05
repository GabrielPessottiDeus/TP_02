import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.CharArrayReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.*;
import java.util.Arrays;

import javax.swing.plaf.multi.MultiButtonUI;
import javax.swing.text.html.HTMLDocument.BlockElement;

class teste3 implements Cloneable {
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

    public teste3() {

    }

    public teste3(int app_id, String nome) {
        this.app_id = app_id;
        this.nome = nome;
    }

    public void StringParse(String linha, String id) {
        String categoria = "";
        int virgulas = linha.indexOf(',');

        for (int i = 0; i < virgulas; i++) {
            categoria = categoria + linha.charAt(i);
        }

        if (categoria.equals(id)) {
            teste3 jogo = new teste3();
            String[] array = linha.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

            //System.out.println(array[0]);
            //System.out.println(array[1]);
            jogo.setApp_id(Integer.parseInt(array[0]));
            jogo.setNome(array[1]);
        }
    }

    public void ler(String frase) throws IOException, ParseException {
        Scanner arquivo = new Scanner(new File("games.csv"));
        String[] linha = new String[4403];

        int n = 0;
        while (arquivo.hasNext()) {
            linha[n] = arquivo.nextLine();
            StringParse(linha[n], frase);

            n++;
        }
    }

    static Boolean isFim(String palavra) {
        boolean result = false;
        if (palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M') {
            result = true;
        }
        return result;
    }

    public static void main(String[] args) throws IOException, ParseException {
        String aux = "";
        String[] aux2 = new String[50];
        teste3 GAME = new teste3();
        int n = 0;
        Boolean teste = false;
        long Inicio = System.currentTimeMillis();
        int comparacoes = 0;

        Scanner sc = new Scanner(System.in);
        aux = sc.nextLine();
        while (isFim(aux) == false) {
            GAME.ler(aux);
            aux2[n] = GAME.getNome();
            aux = sc.nextLine();
            n++;
        }
        aux2 = new String[n];
        System.out.println(Arrays.toString(aux2));
        System.out.println(aux2.length);
        Arrays.sort(aux2);
        sc.close();
        System.out.println(Arrays.toString(aux2));
    }
}