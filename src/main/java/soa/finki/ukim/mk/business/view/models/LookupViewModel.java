package soa.finki.ukim.mk.business.view.models;

/**
 * Created by DarkoM on 14.5.2017.
 */
public class LookupViewModel {
    private Long id;
    private String name;

    protected LookupViewModel(){}

    public LookupViewModel(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
