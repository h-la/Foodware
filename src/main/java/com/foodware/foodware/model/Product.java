package com.foodware.foodware.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.validation.constraints.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product extends AbstractPersistable<Long> {

    @Size(min = 2, message = "Tuotteen nimessä pitää olla vähintään 2 kirjainta.")
    private String productName;
    @Positive(message = "Tuotteen määrän on oltava suurempi kuin nolla.")
    private int quantity;
    @NotNull
    private QuantityUnit quantityUnit;
    @NotNull
    private Gategory gategory;

}
