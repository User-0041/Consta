package constat.mobile.dev.Controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admins")
public class AdministrateurController {

    @GetMapping
    public String getAllAdmins() {
        // Code pour récupérer tous les administrateurs depuis la base de données ou un service
        return "Liste de tous les administrateurs";
    }

    @PostMapping
    public String addAdmin(@RequestBody Admin admin) {
        // Code pour ajouter un nouvel administrateur dans la base de données ou un service
        return "Administrateur ajouté avec succès";
    }

    @PutMapping("/{id}")
    public String updateAdmin(@PathVariable Long id, @RequestBody Admin admin) {
        // Code pour mettre à jour les informations d'un administrateur avec l'ID spécifié
        return "Administrateur mis à jour avec succès";
    }

    @DeleteMapping("/{id}")
    public String deleteAdmin(@PathVariable Long id) {
        // Code pour supprimer l'administrateur avec l'ID spécifié de la base de données ou du service
        return "Administrateur supprimé avec succès";
    }
}
