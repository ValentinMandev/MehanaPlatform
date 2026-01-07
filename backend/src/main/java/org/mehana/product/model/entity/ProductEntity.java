package org.mehana.product.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.mehana.common.model.entity.BaseEntity;
import org.mehana.product.model.enums.ProductTypeEnum;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "products")
public class ProductEntity extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductTypeEnum type;

    @Column(nullable = false, unique = true, name = "name_eng")
    private String nameEng;

    @Column(nullable = false, name = "image_url")
    private String imageUrl;

    @Column(nullable = false)
    private BigDecimal price;

    @Column
    private boolean isOnPromotion;

    @Column
    private BigDecimal promoPrice;

    @Column boolean isEnabled;
}
