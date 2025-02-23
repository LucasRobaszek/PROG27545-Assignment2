//Lucas Robaszek 991727191
package ca.sheridan.robaszel.assignment2.beans;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
public class PasswordRecord implements Serializable{
    @Id
    @Column(name="ID")
    private Long id;
    @Column(name="TITLE")
    private String title;
    @Column(name="USERNAME")
    private String username;
    @Column(name="PASSWORD")
    private String password;
    @Column(name="URL")
    private String url;
    @Column(name="EMAIL")
    private String email;
    @Column(name="NOTES")
    private String notes;
}
