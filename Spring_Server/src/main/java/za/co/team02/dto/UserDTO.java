package za.co.team02.dto;

import lombok.Data;

@Data
public class UserDTO {
    private int adminId;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String role;
    private String address;
}
