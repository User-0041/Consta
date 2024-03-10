package constat.mobile.dev.Entitys;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicule {
@Id
private String idMatricule;
private String marque;
private String sens;
@ManyToOne
private Assureur assureur;
}
