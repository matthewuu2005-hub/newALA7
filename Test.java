
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        ArrayList<String> animalAL = new ArrayList<>(500);
        try {
            Scanner read = new Scanner(new File("animals.txt"));
            while(read.hasNextLine()) {
                animalAL.add(read.nextLine());
            }
            read.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        // totals for iterations
        int cTotal = 0;
        int rTotal = 0;
        int aTotal = 0;

        //test add, remove, contains
        for(int i = 0; i < 20; i++){
            int randomIndex = (int)(Math.random() * animalAL.size());
            String randomAnimal = animalAL.get(randomIndex);
            animalAL.contains(randomAnimal); 
            animalAL.remove(randomAnimal); 
            animalAL.add(randomIndex, randomAnimal ); 
            System.out.printf("%-20s\t%-10d\t%-10d\t%-10d%n", randomAnimal, ArrayList.cIterations, ArrayList.rIterations, ArrayList.aIterations);
            cTotal += ArrayList.cIterations;
            rTotal += ArrayList.rIterations;
            aTotal += ArrayList.aIterations;
        }
        System.out.printf("%-20s\t%-10d\t%-10d\t%-10d%n", "Average", cTotal/20, rTotal/20, aTotal/20);
    }
}
