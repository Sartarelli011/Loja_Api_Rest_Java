package br.com.sartarelli011.loja.entity;

import br.com.sartarelli011.loja.dtos.Request.UserRequestDTO;
import br.com.sartarelli011.loja.enums.UserTypes;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity(name = "User")
@Table(name = "usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserTypes role;


    public User(UserRequestDTO userDTO, String encryptedPassword) {
        this.firstName = userDTO.firstName();
        this.lastName = userDTO.lastName();
        this.email = userDTO.email();
        this.password = encryptedPassword;
        this.role = userDTO.role();
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UserTypes.EMPLOYE) {
            return List.of(new SimpleGrantedAuthority("ROLE_EMPLOYE"), new SimpleGrantedAuthority("ROLE_CLIENT"));
        } else return List.of(new SimpleGrantedAuthority("ROLE_CLIENT"));

    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
