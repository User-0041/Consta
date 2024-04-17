package constat.mobile.dev.Services;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;

import com.itextpdf.barcodes.qrcode.EncodeHintType;
import com.itextpdf.barcodes.qrcode.ErrorCorrectionLevel;
import com.itextpdf.barcodes.qrcode.QRCodeWriter;
import com.itextpdf.barcodes.qrcode.WriterException;

@Service
public class QrcodeService<BitMatrix> {

    public byte[] generateQrCode(String text, int width, int height, Object MatrixToImageWriter, Object BarcodeFormat) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

        @SuppressWarnings("unchecked")
        BitMatrix bitMatrix = (BitMatrix) qrCodeWriter.encode(text, BarcodeFormat.hashCode(), width, hints);

        BufferedImage bufferedImage = ((Object) MatrixToImageWriter Writer).toBufferedImage();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "png", outputStream);

        return outputStream.toByteArray();
    }
}

