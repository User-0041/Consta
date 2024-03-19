package constat.mobile.dev.Entitys;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Assurances {
@Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;
  private String name;
@OneToMany
  private Set<Constat> constats;
@OneToMany
  private Set<Assureur> assureur;

}
