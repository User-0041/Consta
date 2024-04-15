package constat.mobile.dev.Entitys;
import java.util.Date;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Inheritance(strategy =InheritanceType.SINGLE_TABLE)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor 
public class Chouffeur  extends User{
  private long permisDeConduire;
  private Date delivre;
  @OneToMany
  private Set<Constat> constats;
  
  }