package com.example.educationalmaterialsshop.model.entity;

import com.example.educationalmaterialsshop.model.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "orders")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id")
    User customer;
    @OneToMany(cascade = CascadeType.PERSIST)
    @Fetch(FetchMode.SUBSELECT)
    List<OrderItem> orderItems;
    @Enumerated(EnumType.STRING)
    OrderStatus status;
}
