package pet.qr.resteasyjackson;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.io.File;  
import java.io.IOException;  
import java.util.HashMap;  
import java.util.Map;  
import com.google.zxing.BarcodeFormat;  
import com.google.zxing.EncodeHintType;  
import com.google.zxing.MultiFormatWriter;  
import com.google.zxing.NotFoundException;  
import com.google.zxing.WriterException;  
import com.google.zxing.client.j2se.MatrixToImageWriter;  
import com.google.zxing.common.BitMatrix;  
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;  

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

@Path("/resteasy-jackson/quarks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class JacksonResource {

    public static void main(String[] args) throws WriterException, IOException {
        //data that we want to store in the QR code  
        String str= "THE HABIT OF PERSISTENCE IS THE HABIT OF VICTORY.";  
        //path where we want to get QR Code  
        String path = "/home/uenderley/Documentos/qrcode/Quote.png";  
        //Encoding charset to be used  
        String charset = "UTF-8";  
        Map<EncodeHintType, ErrorCorrectionLevel> hashMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();  
        //generates QR code with Low level(L) error correction capability  
        hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);  
        //invoking the user-defined method that creates the QR code  
        generateQRcode(str, path, charset, hashMap, 200, 200);//increase or decrease height and width accodingly   
        //prints if the QR code is generated   
        System.out.println("QR Code created successfully.");  
    }

    public static void generateQRcode(String data, String path, String charset, Map map, int h, int w) throws WriterException, IOException  
    {  
        BitMatrix matrix = new MultiFormatWriter().encode(new String(data.getBytes(charset), charset), 
                BarcodeFormat.QR_CODE, w, h);  
        MatrixToImageWriter.writeToFile(matrix, path.substring(path.lastIndexOf('.') + 1), new File(path));  
    }  

    private final Set<Quark> quarks = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public JacksonResource() {
        quarks.add(new Quark("Up", "The up quark or u quark (symbol: u) is the lightest of all quarks, a type of elementary particle, and a major constituent of matter."));
        quarks.add(new Quark("Strange", "The strange quark or s quark (from its symbol, s) is the third lightest of all quarks, a type of elementary particle."));
        quarks.add(new Quark("Charm", "The charm quark, charmed quark or c quark (from its symbol, c) is the third most massive of all quarks, a type of elementary particle."));
        quarks.add(new Quark("???", null));
    }

    @GET
    public Set<Quark> list() {
        return quarks;
    }

    @POST
    public Set<Quark> add(Quark quark) {
        quarks.add(quark);
        return quarks;
    }

    @DELETE
    public Set<Quark> delete(Quark quark) {
        quarks.removeIf(existingQuark -> existingQuark.name.contentEquals(quark.name));
        return quarks;
    }

    public static class Quark {
        public String name;
        public String description;

        public Quark() {
        }

        public Quark(String name, String description) {
            this.name = name;
            this.description = description;
        }
    }
}
