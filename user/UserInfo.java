package user;

import java.util.Scanner;

public class UserInfo {
    private String name;
    private int age;
    private String gender;
    private String phoneNumber;
    
    public UserInfo() {
        this.name = "";
        this.age = 0;
        this.gender = "";
        this.phoneNumber = "";
    }
    
    public UserInfo(String name, int age, String gender, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }
    
    public void collectUserDetails(Scanner scanner) throws InvalidInputException {
        try {
            System.out.print("Enter your name: ");
            this.name = scanner.nextLine();
            
            if(name.trim().isEmpty()) {
                throw new InvalidInputException("Name cannot be empty!");
            }
            
            System.out.print("Enter your age: ");
            this.age = scanner.nextInt();
            scanner.nextLine();
            
            if(age <= 0 || age > 150) {
                throw new InvalidInputException("Invalid age! Age must be between 1 and 150.");
            }
            
            System.out.print("Enter your gender (Male/Female/Other): ");
            this.gender = scanner.nextLine();
            
            System.out.print("Enter your phone number: ");
            this.phoneNumber = scanner.nextLine();
            
            if(phoneNumber.length() != 10) {
                throw new InvalidInputException("Phone number must be 10 digits!");
            }
            
        } catch(InvalidInputException e) {
            throw e;
        } catch(Exception e) {
            throw new InvalidInputException("Invalid input format!");
        }
    }
    
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String getPhoneNumber() { return phoneNumber; }
    
    public void displayUserInfo() {
        System.out.println("Customer Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Phone: " + phoneNumber);
    }
}