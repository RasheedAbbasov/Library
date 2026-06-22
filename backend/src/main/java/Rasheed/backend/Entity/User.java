package Rasheed.backend.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;




//NOTE -- reference the User Id for bookcheckout instead of asking for name in there for easier use.
@Table(name = "users")
@Entity
public class User {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "first_Name", nullable = false, length = 255)
    private String first_Name;

    @Column(name = "last_Name", nullable = false, length = 255)
    private String last_Name;

    @Column(name = "email", nullable = false, length = 255)
    private String email;

    @OneToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;
    


}
