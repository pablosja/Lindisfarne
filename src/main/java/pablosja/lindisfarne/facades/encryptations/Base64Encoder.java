package pablosja.lindisfarne.facades.encryptations;

import java.util.Base64;
import org.springframework.stereotype.Component;

import pablosja.lindisfarne.implementations.IEncoder;

@Component
public class Base64Encoder implements IEncoder {

    @Override
    public String encode(String data) {
        return Base64.getEncoder().encodeToString(data.getBytes());
    }

    public String decode(String data) {
        byte[] decodedBytes = Base64.getDecoder().decode(data);
        return new String(decodedBytes);
    }
}
