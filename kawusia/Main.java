import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[50];
        fillArray(array);
        findValue(array);
    }

    public static void fillArray(int[] array){
        Random losowanie = new Random(100);
        for(int i=0; i<array.length; i++){
            array[i] = losowanie.nextInt();
        }
    }

    public static void findValue(int[] array){
        Scanner sc = new Scanner(System.in);

        System.out.println("Search for value: ");
        int toSearch = sc.nextInt();

        for(int i=0; i<array.length; i++){
            if(array[i]==toSearch){
                array[i] = array[51];
            }
        }

    }
}
