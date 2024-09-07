package com.snapdrive.snapdrive.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "cars")
@SQLDelete(sql = "UPDATE cars SET is_deleted = true WHERE id = ?")
@SQLRestriction("is_deleted=false")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String model;

    @Column(nullable = false, unique = true)
    private String brand;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    private int inventory;   // number of this spec cars in storage

    @Column(nullable = false)
    private BigDecimal dailyFee; //usd

    @Column(nullable = false)
    private boolean isDeleted;

    public enum Type {
        SEDAN,
        SUV,
        HATCHBACK,
        UNIVERSAL
    }
}
