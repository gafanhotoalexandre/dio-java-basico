package me.simplebank.domain.model.user;

import jakarta.persistence.*;
import lombok.*;
import me.simplebank.dto.UserDTO;

import java.math.BigDecimal;

@Entity(name = "users")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;
    private String lastname;

    @Column(unique = true)
    private String document;
    @Column(unique = true)
    private String email;
    private String password;

    private BigDecimal balance;
    @Enumerated(EnumType.STRING)
    private UserType userType;

    public User(UserDTO data) {
        this.firstname = data.firstname();
        this.lastname = data.lastname();
        this.balance = data.balance();
        this.userType = data.userType();
        this.document = data.document();
        this.email = data.email();
        this.password = data.password();
    }
}
