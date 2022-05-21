package com.foodware.foodware.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product extends AbstractPersistable<Long> {

    @NotEmpty
    @Size(min = 2)
    private String productName;
    private int quantity;
    private QuantityUnit quantityUnit;
    private Gategory gategory;
}
