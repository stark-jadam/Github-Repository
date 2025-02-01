package jsta586.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="vacations")
public class Vacation {

    //Variables and their column mappings
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacation_id")
    private Long id;


    @Column(name = "vacation_title")
    private String vacation_title;


    @Column(name = "description")
    private String description;


    @Column(name = "travel_fare_price")
    private BigDecimal travel_price;


    @Column(name = "image_url")
    private String image_URL;


    @Column(name = "create_date")
    @CreationTimestamp
    private Date created_date;


    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;


    @OneToMany(mappedBy = "vacation", cascade = {CascadeType.ALL})
    private Set<Excursion> excursions = new HashSet<>();




}
