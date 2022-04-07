package the.best.amazonclonebackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    @Min(0)
    private Double price;
    private String title;
    private String image;
    @Min(1)
    @Max(5)
    private Integer rating;
    @Min(1)
    @Max(3)
    private Integer width;
}
