package admin;

public class UsersDisplayConstructor {
    public String firstname;
    public String lastname;
    public String email;
    public String password;
    public String user_type;
    public UsersDisplayConstructor(String firstname,String lastname,String email,String password,String user_type){
        this.firstname=firstname;
        this.lastname=lastname;
        this.email=email;
        this.password=password;
        this.user_type=user_type;
        
    
    }
    public void setFirstname(String firstname){
        this.firstname=firstname;
    }
    public void setLastname(String lastname){
        this.lastname=lastname;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public void setPassword(String password){
    this.password=password;
    }
    public void setUser_type(String user_type){
    this.user_type=user_type;
    }
    
    public String getFirstname(){
        return this.firstname;
    }
    public String getLastname(){
        return this.lastname;
    }
    public String getEmail(){
        return this.email;
    }
    public String getPassword(){
    return this.password;
    }
    public String getUser_type(){
    return this.user_type;
    }
    
}
