package az.moon.managementsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "organizations")
public class Organization extends BaseDomain<Long> {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
    private Boolean status;
    private Integer contactId; // contact entity`nin PK id`si (primary key)

}