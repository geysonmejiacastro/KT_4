import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter
import com.google.zxing.client.j2se.MatrixToImageWriter
import java.io.ByteArrayOutputStream
import java.nio.file.Paths

// Exercise 1: Save QR to file
fun saveQRCode(content: String, fileName: String) {
    val bitMatrix = QRCodeWriter().encode(content, BarcodeFormat.QR_CODE, 300, 300)
    MatrixToImageWriter.writeToPath(bitMatrix, "PNG", Paths.get(fileName))
}

// Exercise 2: Return QR as stream (memory)
fun generateQR(content: String): ByteArrayOutputStream {
    val bitMatrix = QRCodeWriter().encode(content, BarcodeFormat.QR_CODE, 300, 300)

    val stream = ByteArrayOutputStream()
    MatrixToImageWriter.writeToStream(bitMatrix, "PNG", stream)

    return stream
}