package za.co.team02.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity(name= "userss")
@Table(name = "userss", schema = "dbo")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SiteUser
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int User_id;


    @Column(name = "first_name", length=255, nullable=false)
    private String First_Name;

    @Column(name = "last_name", length=255, nullable=false)
    private String lastName;

    @Column(name = "user_name", length=255, nullable=false)
    private String username;

    @Column(name = "password", length=255, nullable=false)
    private String password;

    @Column(name = "email", length=255, nullable=false)
    private String email;

    @Column(name = "role", length=50, nullable=false)
    private String role;

    @Column(name = "address", length=255, nullable=false)
    private String address;

}
