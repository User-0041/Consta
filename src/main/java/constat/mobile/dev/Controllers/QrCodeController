package constat.mobile.dev.Controllers;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.barcodes.qrcode.WriterException;

@RestController
public class QrCodeController<QrCodeService> {

    @Autowired
    private QrCodeService qrCodeService;

    @GetMapping("/qrcode")
    public ResponseEntity<byte[]> generateQrCode(@RequestParam String text, @RequestParam(defaultValue = "200") int width, @RequestParam(defaultValue = "200") int height) {
        try {
            byte[] qrCodeBytes = ((Object) qrCodeService).generateQrCode(text, width, height);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_PNG);
            headers.setContentDispositionFormData("filename", "qrcode.png");

            return new ResponseEntity<>(qrCodeBytes, headers, HttpStatus.OK);
        } catch (WriterException | IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


