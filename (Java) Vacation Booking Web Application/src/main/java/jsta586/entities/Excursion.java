package jsta586.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "excursions")
public class Excursion {


    //Variables and their column mappings
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="excursion_id")
    private Long id;


    @Column(name="excursion_title")
    private String excursion_title;


    @Column(name="excursion_price")
    private BigDecimal excursion_price;


    @Column(name="image_url")
    private String image_URL;


    @Column(name="create_date")
    @CreationTimestamp
    private Date create_date;


    @Column(name="last_update")
    @UpdateTimestamp
    private Date last_update;


    @ManyToOne
    @JoinColumn(name="vacation_id", nullable = false)
    private Vacation vacation;



    @ManyToMany(mappedBy = "excursions")
    private Set<CartItem> cartItems = new HashSet<>();





}
