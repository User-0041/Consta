package constat.mobile.dev.Controllers;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.function.ThrowingConsumer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

@SpringBootApplication
@RestController
public class QRCodeControllers {

    private static final String ImageType = null;
    public static void main(String[] args) {
        SpringApplication.run(QRCodeControllers.class, args);
    }

    @GetMapping(value = "/generateQRCode", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<StreamingResponseBody> generateQRCode(@RequestParam ThrowingConsumer<String[]> text) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        SpringApplication.from(text).to(ImageType.PNG).stream().writeTo(outputStream);
        StreamingResponseBody responseBody = outputStream::writeTo;
        return ResponseEntity.ok().body(responseBody);
    }
}

