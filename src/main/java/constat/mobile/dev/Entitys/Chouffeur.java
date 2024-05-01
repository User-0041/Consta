package constat.mobile.dev.Entitys;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;


@Entity
RCData
public class Chouffeur<permisDeConduire>  extends User{
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
public Object getdelivre() {
	throw new UnsupportedOperationException("Unimplemented method 'getdelivre'");
}
public void setDelivre(Object getdelivre) {
    throw new UnsupportedOperationException("Unimplemented method 'setDelivre'");
}

 @param permisDeConduire the permisDeConduire to set
 
public void setPermisDeConduire(long permisDeConduire) {
  this.permisDeConduire = permisDeConduire;
}

  @return the delivre
 
public Date getDelivre() {
  return delivre;
}

  @param delivre the delivre to set
 
public void setDelivre(Date delivre) {
  this.delivre = delivre;
}
 @return the constats
 
public Set<Constat> getConstats() {
  return constats;
}

  @param constats the constats to set
 
public void setConstats(Set<Constat> constats) {
  this.constats = constats;
}
}







/*package constat.mobile.dev.Entitys;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

@Entity
public class Chouffeur extends User {
    private long permisDeConduire;
    private Date delivre;
    @ManyToMany
    private Set<Constat> constats = new HashSet<>();

    public long getPermisDeConduire() {
        return permisDeConduire;
    }

    public void setPermisDeConduire(long permisDeConduire) {
        this.permisDeConduire = permisDeConduire;
    }

    public Date getDelivre() {
        return delivre;
    }

    public void setDelivre(Date delivre) {
        this.delivre = delivre;
    }

    public Set<Constat> getConstats() {
        return constats;
    }

    public void setConstats(Set<Constat> constats) {
        this.constats = constats;
    }
}
*/
