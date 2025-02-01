package jsta586.entities;


import jakarta.persistence.*;
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
@Table(name = "divisions")
public class Division {

    //Variables and their column mappings
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id")
    private Long id;


    @Column(name = "division")
    private String division_name;


    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;


    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;


    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;


    @Column(name = "country_id", insertable = false, updatable = false)
    private Long country_id;


    @OneToMany(mappedBy = "division", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Customer> customers = new HashSet<>();



    public void setCountry(Country country){
        this.country = country;
    }

    public void add(Customer item){

        if(item != null){
            if (customers == null){
                customers = new HashSet<>();
            }

            customers.add(item);
            item.setDivision(this);

        }
    }


}