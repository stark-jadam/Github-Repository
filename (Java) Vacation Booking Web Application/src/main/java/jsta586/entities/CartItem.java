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
@Table(name="cart_items")
public class CartItem {

    //Variables and their column mappings
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "vacation_id", nullable = false)
    private Vacation vacation;


    @ManyToMany
    @JoinTable(name = "excursion_cartitem",
            joinColumns = @JoinColumn(name = "cart_item_id"),
            inverseJoinColumns = @JoinColumn(name = "excursion_id"))
    private Set<Excursion> excursions = new HashSet<>();


    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;


    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;


    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;



}