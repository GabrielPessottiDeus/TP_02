import java.io.StreamCorruptedException;

public class teste4 {
    public static void main (String[] args) {
        String frase = MyIO.readLine();
        String[] array = new String[17];

        array = frase.split("[,\"]");
        String id = array[0];
        String nome = array[1];
        String data = array[3];
        String owners = array[4];
        String age = array[6];
        String price = array[7];
        String dlcs = array[8];
        String linguas = array[9];

        for (String novo : array) {
            System.out.print(" " + novo);
        }
        System.out.println("\n");
        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[3]);
        System.out.println(array[4]);
        System.out.println(array[6]);
        System.out.println(array[7]);
        System.out.println(array[8]);
        System.out.println(array[9]);
        System.out.println(array[11]);

        for(int i = 0; i < array.length; i++) {
            if(frase.charAt(i) == '[') {
                array = frase.split("\'");
            }
           
        }
}
}

/*730,Counter-Strike: Global Offensive,"Aug 21, 2012",50000000 - 100000000,0,0.0,1,"['Czech', 'Danish', 'Dutch', 'English', 'Finnish', 'French', 'German', 'Hungarian', 'Italian', 'Japanese', 'Korean', 'Norwegian', 'Polish', 'Portuguese', 'Portuguese - Brazil', 'Romanian', 'Russian', 'Simplified Chinese', 'Spanish - Spain', 'Swedish', 'Thai', 'Traditional Chinese', 'Turkish', 'Bulgarian', 'Ukrainian', 'Greek', 'Spanish - Latin America', 'Vietnamese']",http://blog.counter-strike.net/,True,True,True,5764420,766677,30484,"Valve,Hidden Path Entertainment","Action,Free to Play" */
