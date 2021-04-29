package hu.nive.ujratervezes.kepesitovizsga.phonebook;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class Phonebook {

    public void exportPhonebook(Map<String, String> contacts, String output){
        if(contacts == null || output == null){
            throw new IllegalArgumentException("The parameters should not be null");
        }

        try(PrintWriter writer = new PrintWriter(Files.newBufferedWriter(Path.of(output)))){
            for(Map.Entry entry : contacts.entrySet()){
                writer.print(entry.getKey());
                writer.print(": ");
                writer.println(entry.getValue());
            }
        } catch (IOException ioe){
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }
}
