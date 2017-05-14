package soa.finki.ukim.mk.business.view.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by DarkoM on 14.5.2017.
 */
public class UpdateUserViewModel extends RegisterUserViewModel {
    @NotNull @Min(1)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
