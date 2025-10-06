package az.moon.managementsystem.entity;

import java.time.LocalDateTime;

public class BaseDomain<T> {

    private LocalDateTime created;
    private String createdBy;
    private LocalDateTime modified;
    private String modifiedBy;

}