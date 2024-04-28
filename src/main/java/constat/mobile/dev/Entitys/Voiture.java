package constat.mobile.dev.Entitys;

import java.util.HashSet;
import java.util.Set;

import constat.mobile.dev.Services.AssureurService;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
@Entity
@Data

public class Voiture {
    @Id
    private Long id;

    private String name ;
    @ManyToOne
    private AssureurService assureur;
 @ManyToMany
 private Set<Constat> constats = new HashSet<>();
}
