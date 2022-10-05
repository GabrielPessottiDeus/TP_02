import java.util.Arrays;
public class teste2
{
    public static void main(String[] args)
        {
            String[] arrToSort = new String[5];
            for (int n = 0; n < arrToSort.length; n++) {
                arrToSort[n] = MyIO.readLine();
            }
            Arrays.sort(arrToSort, String.CASE_INSENSITIVE_ORDER);//case insensitive sort
            for(int i = 0; i < arrToSort.length; i++)
            {
                System.out.print(arrToSort[i] + " ");
            }
        }
}