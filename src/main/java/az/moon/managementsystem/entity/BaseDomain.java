package az.moon.managementsystem.entity;

import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class BaseDomain {

    private LocalDateTime created;
    private String createdBy;
    private LocalDateTime modified;
    private String modifiedBy;

}