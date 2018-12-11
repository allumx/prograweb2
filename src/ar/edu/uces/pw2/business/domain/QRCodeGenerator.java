package ar.edu.uces.pw2.business.domain;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import org.springframework.stereotype.Component;

/*
 * https://www.callicoder.com/generate-qr-code-in-java-using-zxing/
 */
//@Component
public class QRCodeGenerator {

	/*private String pathQr;

    public String getPathQr() {
		return pathQr;
	}

	public void setPathQr(String pathQr) {
		this.pathQr = pathQr;
	}*/
	public QRCodeGenerator() {	
	}
	public void generateQRCodeImage(String text, int width, int height, String filePath)
            throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
        System.out.println("qr ok");
    }

    /*public static void main(String[] args) {
        try {
            generateQRCodeImage("This is my first QR Code", 350, 350, QR_CODE_IMAGE_PATH);
        } catch (WriterException e) {
            System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
        }
    }*/
	
}
