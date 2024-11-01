package ui;

import java.io.FileNotFoundException;

// The format of try catch is from JsonSerializationDemo
public class Main {
    public static void main(String[] args) {
        try {
            new GameApp();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
            throw new RuntimeException();
        }
    }
}
