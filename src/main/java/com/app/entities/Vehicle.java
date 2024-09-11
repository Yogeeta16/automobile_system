
package com.app.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


import lombok.Data;

@Data
@Entity
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String vname;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Company company;

    @NotBlank
    @Size(min = 10, max = 10)
    @Column(nullable = false, unique = true)
    private String vnumber;

    @NotBlank
    @Column(nullable = false)
    private String vtype;

    @ManyToOne
    @JoinColumn(name = "uid", nullable = false)
    private User user;
}
