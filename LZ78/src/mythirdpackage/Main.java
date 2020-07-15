package mythirdpackage;
import java.security.PublicKey;
import java.sql.SQLOutput;
import java.util.*;
import java.util.ArrayList;
import java.lang.*;


public class Main {

    public static void Compression(String s) {
        ArrayList dictionary = new ArrayList<String>();
        ArrayList pointer = new ArrayList<Integer>();
        ArrayList nextChar = new ArrayList<Character>();
        dictionary.add(null);
        //dictionary  formation
        for (int i = 0; i < s.length(); i++) {
            String temp = new String();
            int index = 0;
            temp += s.charAt(i);

            for (int j = 1; j < dictionary.size(); j++) {
                if (temp.equals(dictionary.get(j))) {
                    index = j;
                    if (i == s.length() - 1)
                        break;
                    i++;
                    temp += s.charAt(i);
                }
            }

            if (i == s.length() - 1 && dictionary.contains(temp)) {
                pointer.add(index);
                nextChar.add(null);
                break;
            }

            dictionary.add(temp);
            pointer.add(index);
            nextChar.add(temp.charAt(temp.length() - 1));
        }

        //printing dictionary
        System.out.println("Dictionary: ");
        for (int i = 0; i < dictionary.size(); i++)
            System.out.println(i + " : " + dictionary.get(i));

        //printing hashmap
        System.out.println("Output: ");
        for (int i = 0; i < pointer.size(); i++)
            System.out.println("< " + pointer.get(i) + " , '" + nextChar.get(i) + "' >");

        Decompression(pointer, nextChar);

    }


    public static void Decompression(ArrayList<Integer> pointer, ArrayList<Character> nextChar) {
        String output = new String();
        ArrayList dictionary = new ArrayList<String>();
        dictionary.add(null);
        for (int i = 0; i < pointer.size(); i++) {
            String temp = new String();
            if (pointer.get(i) != 0)
                temp += dictionary.get(pointer.get(i));
            if (nextChar.get(i) != null)
                temp += nextChar.get(i);
            output += temp;
            if (!dictionary.contains(temp))
                dictionary.add(temp);
        }
        System.out.println("The output is: " + output);
        System.out.println("Dictionary: ");
        for (int i = 0; i < dictionary.size(); i++)
            System.out.println(i + " : " + dictionary.get(i));
    }


    public static void main(String[] args) {
        // write your code here
        while (true) {
            System.out.println("Choose 1-Compression   2-Decompression  3-Exit");
            Scanner in = new Scanner(System.in);
            int c = in.nextInt();
            if (c == 1) {
                System.out.println("Enter your word");
                Scanner word = new Scanner(System.in);
                String s = word.nextLine();
                Compression(s);
               }

            else if (c == 2) {
                ArrayList pointer = new ArrayList<Integer>();
                ArrayList nextChar = new ArrayList<Character>();
                boolean check = true;

                while (check) {
                    System.out.println("Enter your tag \n Enter index: ");
                    Scanner index = new Scanner(System.in);
                    int num = in.nextInt();
                    pointer.add(num);
                    System.out.println("Enter char: ");
                    Scanner word = new Scanner(System.in);
                    char Char = word.next().charAt(0);
                    nextChar.add(Char);
                    System.out.println("Continue? Y/N ?");
                    char Ch = word.next().charAt(0);
                    if (Ch == 'N')
                        check = false;
                    }
                Decompression(pointer, nextChar);
                }
            else if (c == 3) {
                System.out.printf("Thanks for using our program !");
                break;
            }
        }
    }
}
