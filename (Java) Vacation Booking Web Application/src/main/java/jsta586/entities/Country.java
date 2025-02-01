package jsta586.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="countries")
public class Country {

    //Variables and their column mappings
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Long id;


    @Column(name = "country")
    private String country_name;


    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;


    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;


    @OneToMany(mappedBy = "country", cascade = {CascadeType.ALL}
    )
    private Set<Division> divisions = new HashSet<>();



}