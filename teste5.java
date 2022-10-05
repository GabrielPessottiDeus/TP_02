public class teste5 {
    public static void main (String[] args) {
        String frase = MyIO.readLine();
        String[] array = new String[17];

        array = frase.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
        

        for (String novo : array) {
            System.out.print(" " + novo);
        }
        System.out.println("\n");
        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println(array[3]);
        System.out.println(array[4]);
        System.out.println(array[5]);
        System.out.println(array[6]);
        System.out.println(array[7]);
        System.out.println(array[8]);
        System.out.println(array[9]);
        System.out.println(array[10]);

}
}
