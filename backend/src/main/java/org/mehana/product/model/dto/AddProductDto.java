package org.mehana.product.model.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.mehana.product.model.enums.ProductTypeEnum;

import java.math.BigDecimal;

@Getter
@Setter
public class AddProductDto {

    @NotEmpty(message = "Product name is empty")
    private String name;

    private ProductTypeEnum type;

    @NotEmpty(message = "English name is empty")
    private String nameEng;

    @NotEmpty(message = "Please add a product image")
    private String imageUrl;

    @NotNull(message = "Please enter product price")
    private BigDecimal price;
}
