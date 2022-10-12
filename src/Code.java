import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Code {
    public static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("Enter the file way:");
        String fileName = scanner.nextLine();
        System.out.println("Select the shift value:");
        int key = scanner.nextInt();
        encode_decode_File(fileName, key);
        System.out.println("Enter the Name for new encoded File:");
        String newFile = scanner.nextLine();
        createFile(newFile);
    }

    private static void encode_decode_File(String fileName, int key) {
        ArrayList<String> newText = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready() || reader.readLine() != null) {
                String text = reader.readLine();
                newText.add(text);
            }
        } catch (Exception FileNotFoundException) {
            System.out.println("File not Found!");
        }
        ArrayList<String> codeText = new ArrayList<>();
        for (String s : newText) {
            codeText.add(encode(s, key));
        }
        System.out.println(codeText);
    }

    private static String encode(String in, int shift) {
        StringBuilder sb = new StringBuilder();
        char[] chars = in.toCharArray();
        for (char c : chars) {
            char shifted = (char) (c + shift);
            sb.append(shifted);
        }
        return sb.toString();
    }

    private static void createFile(String in) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(in))){
            File f = new File(in);
            //writer.write();
            if (f.createNewFile())
                System.out.println("File created");
            else
                System.out.println("File already exists");
        } catch (IOException e) {
            System.out.println("Not working");
        }
    }
}
