package za.co.team02.dto;

import lombok.Data;
import za.co.team02.model.Event;

import java.util.Set;

@Data
public class UserDTO
{
    private int Admin_Id;
    private int User_id;
    private String First_Name;
    private String Last_Name;
    private int Cohort_id;
    private String Username;
    private String password;
    private String email;
    private String role;
    private int Location_id;
    private String address;
    private Set<Event> events;
}
