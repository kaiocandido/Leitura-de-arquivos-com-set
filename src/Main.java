import entities.logEntry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter file full path: ");
        String path = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            Set<logEntry> set = new HashSet<>();

            String line = br.readLine();

            while (line != null){
                String[] fields = line.split(" ");
                String username = fields[0];
                Date dateMonent = Date.from(Instant.parse(fields[1]));


                set.add(new logEntry(username,dateMonent));

                line = br.readLine();
            }

            System.out.println("Total users: " + set.size());

        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}