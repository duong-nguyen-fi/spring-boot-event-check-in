package fi.vamk.andy.eventcheckin;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

@SpringBootApplication
public class EventCheckInApplication{

	public static void main(String[] args) {
		SpringApplication.run(EventCheckInApplication.class, args);
	}

	@Bean
	QRCodeWriter qrCodeWriter()
	{
		return new QRCodeWriter();
	}
}
