package main;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class User implements UserDetails {
    private String email;
    private String phoneNumber;
    private String name;
    private boolean active;
    private String password;
    private String role;
    private LocalDateTime localDateTime = null;

    public User() {

        this.email = null;
        this.phoneNumber = null;
        this.name = null;
        this.active = false;
        this.password = null;
        this.role = null;
    }

    public User(String email, String phoneNumber, String name,  String password, boolean active, String roles) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.active = active;
        this.password = password;
        this.role = roles;
        this.localDateTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "User{" +

                " email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", name='" + name + '\'' +
                ", active=" + active +
                ", password='" + password + '\'' +
                ", roles=" + role +
                ", localDateTime=" + localDateTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return  active == user.active && Objects.equals(email, user.email) && Objects.equals(phoneNumber, user.phoneNumber) && Objects.equals(name, user.name) && Objects.equals(password, user.password) && Objects.equals(role, user.role) && Objects.equals(localDateTime, user.localDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, phoneNumber, name, active, password, role, localDateTime);
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
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
        return active;
    }
}
