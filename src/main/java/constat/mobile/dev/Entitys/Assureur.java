package constat.mobile.dev.Entitys;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy =InheritanceType.SINGLE_TABLE)
public class Assureur extends User  {
private String tel ;
@OneToMany
private Set<Vehicule> vehicules; 


@ManyToOne
private Assurances assurances;
}
