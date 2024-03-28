package constat.mobile.dev.Services;

import org.springframework.data.repository.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Méthode pour récupérer tous les utilisateurs
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Méthode pour récupérer un utilisateur par son ID
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Utilisateur introuvable avec l'ID : " + id));
    }

    // Méthode pour créer un nouvel utilisateur
    public User createUser(User user) {
        // Ajoutez ici la logique pour valider les données de l'utilisateur, par exemple, vérifier les champs obligatoires
        return userRepository.save(user);
    }

    // Méthode pour mettre à jour un utilisateur existant
    public User updateUser(Long id, User user) {
        // Vérifie si l'utilisateur existe
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("Utilisateur introuvable avec l'ID : " + id);
        }
        // Met à jour l'utilisateur avec les nouvelles données
        user.setId(id);
        return userRepository.save(user);
    }

    // Méthode pour supprimer un utilisateur
    public void deleteUser(Long id) {
        // Vérifie si l'utilisateur existe
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("Utilisateur introuvable avec l'ID : " + id);
        }
        // Supprime l'utilisateur
        userRepository.deleteById(id);
    }
}
