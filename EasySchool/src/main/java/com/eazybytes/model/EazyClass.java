package com.eazybytes.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;

/**
 * @author VietDev
 * @date 11/08/2023
 * @role
 */
@Entity
@Table(name="class")
@Getter
@Setter
public class EazyClass extends BaseEntity{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int classId;

    @NotBlank(message="Name must not be blank")
    @Size(min=3, message="Name must be at least 3 characters long")
    private String name;

    @OneToMany(mappedBy = "eazyClass", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, targetEntity = Person.class)
    private Set<Person> persons;
}

