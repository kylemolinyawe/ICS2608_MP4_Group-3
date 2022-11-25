
/**
 *
 * @author Kyle Molinyawe
 */
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
    
}
