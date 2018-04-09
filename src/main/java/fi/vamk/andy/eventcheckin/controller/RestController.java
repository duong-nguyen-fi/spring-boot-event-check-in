package fi.vamk.andy.eventcheckin.controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    @Qualifier("qrCodeWriter")
    QRCodeWriter qrCodeWriter;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public byte[] newQRCode(@RequestParam("content") String content) {

        System.out.print("\n Content: " + content);

        try {
            return getQRCodeImage(content, 350, 350);

        }
        catch (Exception e) {
            return null;
        }

    }

    private byte[] getQRCodeImage(String text, int width, int height) throws WriterException, IOException {

        BitMatrix bitMatrix = this.qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
        byte[] pngData = pngOutputStream.toByteArray();
        return pngData;
    }
}
