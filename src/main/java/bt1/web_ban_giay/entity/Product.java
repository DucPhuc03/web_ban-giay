package bt1.web_ban_giay.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "products")
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(columnDefinition = "MEDIUMTEXT")
    private String description;
    private double price;
    private int stock;
    private String image_url;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
