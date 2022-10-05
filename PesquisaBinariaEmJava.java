import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;
import java.util.Arrays;

class PesquisaBinariaEmJava implements Cloneable {
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

    public PesquisaBinariaEmJava() {

    }

    public PesquisaBinariaEmJava(int app_id, String nome) {
        this.app_id = app_id;
        this.nome = nome;
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

    public static PesquisaBinariaEmJava ler(String frase) throws IOException, ParseException {
        PesquisaBinariaEmJava jogo = new PesquisaBinariaEmJava();
        Scanner arquivo = new Scanner(new File("/tmp/games.csv"));
        String[] linha = new String[4403];

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
                jogo = new PesquisaBinariaEmJava();
                String[] array = linha[i].split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

                jogo.setApp_id(Integer.parseInt(array[0]));
                jogo.setNome(array[1]);
            }
        }
        return jogo;
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
        String[] aux2 = new String[50];
        PesquisaBinariaEmJava GAME = new PesquisaBinariaEmJava();
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