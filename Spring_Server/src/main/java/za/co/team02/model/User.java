package za.co.team02.model;

import jakarta.persistence.OneToOne;

public class User {
    private int candidateId;
    private String firstName;
    private String lastName;

    @OneToOne
    private int locationId;
}
