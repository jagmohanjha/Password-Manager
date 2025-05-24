public class PasswordEntry {
    
    String website;
    String username;
    String password;

    public PasswordEntry(String website, String username, String password) {
        this.website = website;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Website: " + website + ", Username: " + username + ", Password: " + password;
    }
}


