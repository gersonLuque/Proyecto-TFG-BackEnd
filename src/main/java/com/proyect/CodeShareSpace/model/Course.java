package com.proyect.CodeShareSpace.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "course_name")
    private String name;

    @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY)
    @JsonBackReference // evita la recursion infita en el json
    private List<User> users;

    @OneToMany(mappedBy = "course",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private List<Task> tasks;

    @Override
    public String toString() {
        return "Course{" + "courseId=" + courseId + ", name='" + name + '\'' + '}';
    }
    @PreRemove
    private void removeAsociationsWithUsers(){
        for (User user : this.users){
            user.getCourses().remove(this);
        }
    }
}
