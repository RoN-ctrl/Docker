package com.buzhovych.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Notebooks")
@Data
@NoArgsConstructor
public class Notebook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "model")
    private String model;

    @Column(name = "producer")
    private String producer;

    @Column(name = "processor")
    private String processor;

    @Column(name = "memory_capacity_gb")
    private int memoryGb;

    @Column(name = "used")
    private boolean used;

    @Column(name = "case_material")
    private String caseMaterial;

    @Column(name = "price")
    private double price;

    @Column(name = "release_date")
    private String releaseDate;

    public Notebook(String model, String producer, String processor, int memoryGb, boolean used, String caseMaterial,
                    double price, String releaseDate) {
        this.model = model;
        this.producer = producer;
        this.processor = processor;
        this.memoryGb = memoryGb;
        this.used = used;
        this.caseMaterial = caseMaterial;
        this.price = price;
        this.releaseDate = releaseDate;
    }
}
