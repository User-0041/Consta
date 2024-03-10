package constat.mobile.dev.Entitys;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Constat {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  private Date date;

  private String lieu;
  
  private String description ;
  
  @ManyToOne
  private Chouffeur chouffeurA;

    
  @ManyToOne
  private Chouffeur chouffeurB;


  @ManyToOne
  private Assureur assureurA;

    
  @ManyToOne
  private Chouffeur assureurB;




}
