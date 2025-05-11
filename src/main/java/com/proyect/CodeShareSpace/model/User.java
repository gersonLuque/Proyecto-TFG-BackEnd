package com.proyect.CodeShareSpace.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Setter @Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    private String username;
    private String password;
    @Column(name = "complete_name")
    private String completeName;

    @Enumerated(EnumType.STRING)
    private Rol rol;

   @ManyToMany
   @JoinTable(
           name = "users_courses",
           joinColumns = @JoinColumn(name = "user_id"),
           inverseJoinColumns = @JoinColumn(name = "course_id")
   )
    @JsonManagedReference // evita la recursion infinita en el json
    private List<Course> courses;

    @OneToMany(mappedBy = "student",cascade = CascadeType.REMOVE)
    private List<Solution> solutions;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + rol.name()));
    }

    public List<Solution> getSolutions() {
        return solutions;
    }

    public Long getUserId() {
        return userId;
    }

    public String getCompleteName() {
        return completeName;
    }

    public Rol getRol() {
        return rol;
    }

    public List<Course> getCourses() {
        return courses;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }
    public void addCourse(Course course){
        if (course != null) {
            if (this.courses == null) {
                this.courses = new ArrayList<>();
            }
            this.courses.add(course);

            if (course.getUsers() == null) {
                course.setUsers(new ArrayList<>());
            }
            course.getUsers().add(this);
        }
    }
}


