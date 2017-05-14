package soa.finki.ukim.mk.models;

import javax.persistence.*;

/**
 * Created by DarkoM on 07.5.2017.
 */

@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId(){
        return id;
    }
}
