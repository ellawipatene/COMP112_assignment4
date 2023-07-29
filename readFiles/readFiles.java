
import ecs100.*;
import java.awt.Color;
import java.util.*;
import java.io.*;
import java.nio.file.*;

public class readFiles
{
    public void displayFile(String fileName){ // to read a file and put the lines into a string
        try{
            List<String> allLines = Files.readAllLines(Path.of(fileName));
            for (String line: allLines){
                UI.println(line); 
            } 
        } catch (IOException e){UI.println("File Failure:" + e);}
    }
    
    public void copyFile(){ // copy/duplicating a file
        String fromFile = UIFileChooser.open("File to copy"); 
        String toFile = UIFileChooser.save("File name to save to"); 
        try{
            List<String> lines = Files.readAllLines(Path.of(fromFile)); 
            PrintStream outfile = new PrintStream(toFile);
            for(String line: lines){
                outline.println(line); 
            }
            outfile.close();
        }catch (IOException e){UI.println("File failure:" + e);}
    }
    
    public void makeFile(String fileName){ // writing to a file - new file
        ArrayList<String> lines = UI.askString("Type in file contents");
        try{
            PrintStream outfile = new PrintStream(filename); 
            for (String line: lines){
                outfile.println(line); 
            }
            outfile.close(); 
        } catch (IOException e){UI.println("File failure:" + e); }
    }
    
    
    // Using UIFileChooser
    // Has an open method and a save method
    // open puts up a diologe box that lets a user choose a file
    public void makeFile(){
        ArrayList<String> lines = UI.askStrings("Type in file contents:");
        String filename = UIFileChooser.save("Filename to save to"); 
        try{
            PrintStream outfile = new PrintStream(filename); 
            for (String line: lines){
                outfile.println(line); 
            }
            outfile.close();
        }catch(IOException e){UI.println("File Failure:" + e);}
    }
    
    
    // Find all lines in a file containing a search word
    public void findWordInFile(){
        String fileName = UIFileChooser.open("Choose file to search");
        String word = UI.askString("Word to search for:"); 
        try{
            List<String> allLines = Files.readAllLines(Path.of(fileName)); 
            int lineNumber = 1;
            for (String line: allLines){
                if(line.contains(word)){
                    UI.printf("Found %s on line %d: %s/n", word, lineNumber, line); 
                }
                lineNumber++; 
            }
        }catch(IOException e){UI.println("File failure:" + e);}
    }
    
    
    // Scanners 
    public void scanner(){
        Scanner scan = new Scanner("4447 quince 11.45");
        String PLU = scan.nextInt();
        String product = scan.next(); 
        String price= scan.nextDouble(); 
        
        
        Scanner scan2 = new Scanner("This string has (exactly) 10 tokens: a-b-c-d & 9.0 #10");
        for (int i = 0; i < 10; i++){
            String tok = scan.next();
            UI.println("Token " + i + " : " + tok); 
        }
        
        
        
        // if you do not know how many tokens are in a string:
        while(sc.hasNext()){
            String word = sc.next(); 
        }
        
        scan.hasNextInt(); // boolean statement, is there another token and is it an int?
        scan.hasNextDouble(); // boolean statement, is there another token and is it an int?
        
        Scanner sc = new Scanner(UI.askSting("Enter some tokens"));
        int total = 0; 
        while (sc.hasNext()){
            if (sc.hasNextInt()){
                int num = sc.nextInt(); 
                total = total + num;
            } else{ // if next token is not an int, read it and throw it away
                sc.next(); 
            
            }
        }
        
        
        // reading from scanner
        Scanner scan = new Scanner(line); 
        String salesperson = scan.next(); //e.g. we know that the fist value will be someones name
        double total = 0; 
        while (scan.hasNextDouble()){
            total = total + scan.nextDouble();
        }
  
    }
    
    public void scannerExample(){ 
        // for an image
        List<String> allLines = Files.readAllLines(Path.of("image.jpg"));
        for (String line: allLines){
            Scanner scan = new Scanner(line); 
            UI.setColor(new Color (scan.nextInt(), scan.nextInt(), scan.nextInt())); 
            UI.fillRect(x, y, 2, 2);
            x = x + 2; 
            if (x > RIGHT){
                x = LEFT;
                y = y + 2; 
            }
        }
        
        
        // for a temp analyser that will find the max temp
        List<String> allLines = Files.readAllLines(Path.of("numbers.txt"));
        for (String line: allLines){
            
            double max = Double.NEGATIVE_INFINITY;
            

            while (scan.hasNextDouble()){
                double num = scan.nextDouble();
                if (num  > max){
                    max = num; 
                }
            }
        }
        UI.println(max); 
    }
}
