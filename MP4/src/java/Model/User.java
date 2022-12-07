package Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import javax.servlet.ServletContext;

/* Represents a user on the website */

public class User {
    private int id;
    private String email;
    private String username;
    private String password;

    public User(int id, String email, String username, String password){
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
    }


    public String getEmail(){
        return this.email;
    }
    public int getId(){
        return this.id;
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }
    
    //Reads the users.txt and stores the values in a list of user objects
    public static List<User> readUsersFile(ServletContext servletContext)throws IOException{
 
        List<User> list = new ArrayList<>();

        InputStream ins = servletContext.getResourceAsStream("/files/users.txt");
        InputStreamReader isr = new InputStreamReader(ins);
                BufferedReader reader = new BufferedReader(isr);
                String line = "";
                while ((line = reader.readLine()) != null) {
                    String[] byComma = line.split(",");
                    list.add(new User(Integer.parseInt(byComma[0]), byComma[1], byComma[2], byComma[3]));
                }

        return list;
    }
    
    // iterates through a list and returns a boolean value if a match is found between the response and list
    public static boolean validateUsername(List<User> users, String requestUsername){
        ListIterator<User> usersIterator = users.listIterator();
        while(usersIterator.hasNext()){
            if (usersIterator.next().getUsername().equals(requestUsername)){
                return true;
            } 
        }
        return false;
    }
    
    // same structure as validateUsername except for password
    public static boolean validatePassword(List<User> users, String requestPassword){
        ListIterator<User> usersIterator = users.listIterator();
        while(usersIterator.hasNext()){
            if (usersIterator.next().getPassword().equals(requestPassword)){
                return true;
            } 
        }
        return false;
    }
    
}
