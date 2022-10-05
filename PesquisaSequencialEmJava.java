import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

class PesquisaSequencialEmJava implements Cloneable {
    private String app_id;
    private String nome;

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public PesquisaSequencialEmJava() {

    }

    public PesquisaSequencialEmJava(String app_id, String nome) {
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

            String[] array = linha.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

            setApp_id(array[0]);
            setNome(array[1]);
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
        PesquisaSequencialEmJava GAME = new PesquisaSequencialEmJava();
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
        aux = sc.nextLine();
        while (isFim(aux) == false) {
            for (int i = 0; i < aux2.length; i++) {
                if (aux.equals(aux2[i])) {
                    System.out.println("SIM");
                    teste = true;
                    i = aux2.length;
                    comparacoes++;
                } else {
                    teste = false;
                }
                comparacoes++;
            }
            if (teste == false) {
                System.out.println("NAO");
            }
            aux = sc.nextLine();
        }
        sc.close();

        long Final = System.currentTimeMillis();
        long tempoCodigo = Final - Inicio;
        comparacoes = comparacoes + 1;
        BufferedWriter arquivo = new BufferedWriter (new FileWriter("matrícula_sequencial.txt"));
        arquivo.write("763674\t" + tempoCodigo + "\t" + comparacoes );
        arquivo.close();
    }
}