package constat.mobile.dev.Entitys;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;


@Entity
RCData
public class Chouffeur  extends User{
  private long permisDeConduire;
  private Date delivre;
  @ManyToMany
 private Set<Constat> constats = new HashSet<>();
  public Object getPermisDeConduire() {
    
    throw new UnsupportedOperationException("Unimplemented method 'getPermisDeConduire'");
  }
public void setPermisDeConduire(Object permisDeConduire2) {
  
    throw new UnsupportedOperationException("Unimplemented method 'setPermisDeConduire'");
}
}
