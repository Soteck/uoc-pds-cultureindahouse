package dto;

import lombok.Data;

@Data
public class AddOrUpdateUser {

    public String nif;
    public String email;
    public String password;
    public String name;
    public String surname;
    public String preferedLanguage;
    public String address;
}
