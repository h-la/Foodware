package com.foodware.foodware.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product  extends AbstractPersistable<Long> {

    private String productName;
    //private int number;
    private double quantity;
    private QuantityUnit quantityUnit;
    private Gategory gategory;
}
