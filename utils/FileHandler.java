package utils;

import java.io.*;

public class FileHandler {
    private String filename;
    
    public FileHandler(String filename) {
        this.filename = filename;
    }
    
    // Write bill to file
    public void writeBillToFile(String billContent) throws IOException {
        FileWriter writer = null;
        BufferedWriter bufferedWriter = null;
        
        try {
            writer = new FileWriter(filename, true);
            bufferedWriter = new BufferedWriter(writer);
            
            bufferedWriter.write(billContent);
            bufferedWriter.newLine();
            bufferedWriter.write("═══════════════════════════════════════════════════════════");
            bufferedWriter.newLine();
            bufferedWriter.newLine();
            
            System.out.println("\n Bill saved successfully to: " + filename);
            
        } catch(IOException e) {
            throw new IOException("Error writing to file: " + e.getMessage());
        } finally {
            if(bufferedWriter != null) {
                bufferedWriter.close();
            }
            if(writer != null) {
                writer.close();
            }
        }
    }
    
    // Read bill from file
    public void readBillFromFile(String billNumber) throws IOException {
        FileReader reader = null;
        BufferedReader bufferedReader = null;
        
        try {
            reader = new FileReader(filename);
            bufferedReader = new BufferedReader(reader);
            
            String line;
            boolean found = false;
            StringBuffer billData = new StringBuffer();
            
            while((line = bufferedReader.readLine()) != null) {
                if(line.contains("Bill Number: " + billNumber)) {
                    found = true;
                    billData.append(line).append("\n");
                } else if(found) {
                    if(line.contains("═══════════════════")) {
                        break;
                    }
                    billData.append(line).append("\n");
                }
            }
            
            if(found) {
                System.out.println("\n--- Bill Details ---");
                System.out.println(billData.toString());
            } else {
                System.out.println("Bill number not found!");
            }
            
        } catch(FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        } finally {
            if(bufferedReader != null) {
                bufferedReader.close();
            }
            if(reader != null) {
                reader.close();
            }
        }
    }
    
    public void displayAllBills() throws IOException {
        FileReader reader = null;
        BufferedReader bufferedReader = null;
        
        try {
            reader = new FileReader(filename);
            bufferedReader = new BufferedReader(reader);
            
            String line;
            System.out.println("\n╔═══════════════════════════════════════════════╗");
            System.out.println("║           ALL BILLS HISTORY                   ║");
            System.out.println("╚═══════════════════════════════════════════════╝\n");
            
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            
        } catch(FileNotFoundException e) {
            System.out.println("No bills found. File does not exist.");
        } finally {
            if(bufferedReader != null) {
                bufferedReader.close();
            }
            if(reader != null) {
                reader.close();
            }
        }
    }
}