package com.example.client;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="countings")
public class CountEntity {

    public CountEntity(int count, String comment) {
        this.count = count;
        this.comment = comment;
    }
    
    @Id
    @SequenceGenerator(name="countings_gen", sequenceName = "countings_seq", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="countings_gen")
    int id;
    int count;
    String comment;

    public int getId() {return id;}
    public int getCount() {return count;}
    public String getComment() {return comment;}


}
