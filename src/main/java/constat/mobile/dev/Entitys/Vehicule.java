package constat.mobile.dev.Entitys;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicule {
@Id
private String idMatricule;
private String marque;
private String from;
private String to;

@ManyToOne
private Assureur assureur;
}
