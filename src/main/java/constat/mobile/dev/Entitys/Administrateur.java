package constat.mobile.dev.Entitys;




import jakarta.persistence.Entity;

import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Inheritance(strategy =InheritanceType.SINGLE_TABLE)
@Entity 
public class Administrateur extends User {


}