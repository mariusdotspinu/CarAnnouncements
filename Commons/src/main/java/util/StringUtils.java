package util;


import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

abstract class StringUtils {
    private static final String UTF8_CHARSET = "UTF-8";

    static List<String> getEncodedStringImages(List<byte[]> imageStreams) {
        List<String> encodedImageStrings = new ArrayList<String>();

        for (byte[] imageStream : imageStreams) {
            encodedImageStrings.add(StringUtils.getEncodedImageString(imageStream));
        }
        return encodedImageStrings;
    }

    private static String getEncodedImageString(byte[] imageStream) {
        try {
            return new String(Base64.encodeBase64(imageStream), UTF8_CHARSET);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
