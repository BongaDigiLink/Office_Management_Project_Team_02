package za.co.team02.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity(name = "userss")
@Table(name = "userss", schema = "dbo")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SiteUser
{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "User_id")
    private int User_id;

    @Column(name = "First_Name")
    private String First_Name;

    @Column(name = "last_Name")
    private String lastName;

    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "Email")
    private String email;

    @Column(name = "Role")
    private String role;

    @Column(name = "Address")
    private String address;

}
