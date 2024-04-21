package constat.mobile.dev.Controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MapsController {

    @Value("${google.maps.api.key}")
    private String googleMapsApiKey; // Clé d'API Google Maps

    // Endpoint pour obtenir la localisation à partir des coordonnées géographiques
    @GetMapping("/localisation")
    public ResponseEntity<String> getLocalization(@RequestParam("latitude") double latitude,
                                                   @RequestParam("longitude") double longitude) {
        // Appel au service de géolocalisation de Google Maps pour récupérer l'adresse
        String url = "https://maps.googleapis.com/maps/api/geocode/json?latlng=" + latitude + "," + longitude + "&key=" + googleMapsApiKey;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        // Vérification de la réponse
        if (response.getStatusCode() == HttpStatus.OK) {
            // Si la réponse est OK, renvoyer l'adresse trouvée
            return ResponseEntity.ok(response.getBody());
        } else {
            // Sinon, renvoyer un message d'erreur
            return ResponseEntity.status(response.getStatusCode()).body("Erreur lors de la récupération de l'adresse");
        }
    }
}
