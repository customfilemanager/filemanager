/*
 * Copyright (C) 2015 davis
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package foss.filemanager.core;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import net.codejava.crypto.CryptoException;
import net.codejava.crypto.CryptoUtils;
import org.apache.tika.parser.txt.CharsetDetector;
import org.apache.tika.parser.txt.CharsetMatch;

/**
 *
 * @author davis
 */
public class Utils {
    
    public static void encryptFile(File inputFile, File encryptedFile) throws CryptoException{
        CryptoUtils.encrypt(CryptoUtils.key, inputFile, encryptedFile);
    }

    public static String md5sum(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        String md5 = org.apache.commons.codec.digest.DigestUtils.md5Hex(fis);
        fis.close();
        return md5;
    }

    public static void transform(File input, File output, Charset dstCharset) throws IOException{
        BufferedReader br = null;
        FileWriter fileWriter = new FileWriter(output);
        try {
            String sCurrentLine;
            br = new BufferedReader(new FileReader( input ));
            int i= 0;
            while ((sCurrentLine = br.readLine()) != null) {
                //Charset srcCharset = Charset.forName("UTF-8");
                InputStream is = new FileInputStream(input);
                Charset srcCharset = Charset.forName(guessEncoding(is));
                byte[] isoB =  encode( sCurrentLine.getBytes(), srcCharset, dstCharset);
                fileWriter.write(new String(isoB, dstCharset ));
                fileWriter.write("\n");
                System.out.println( i++ );
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    static byte[] encode(byte[] arr, Charset srcCharset, Charset dstCharset){
        ByteBuffer inputBuffer = ByteBuffer.wrap( arr );
        CharBuffer data = srcCharset.decode(inputBuffer);
        ByteBuffer outputBuffer = dstCharset.encode(data);
        byte[] outputData = outputBuffer.array();

        return outputData;
    }

    public static String guessEncoding(InputStream is) throws IOException {
        CharsetDetector charsetDetector = new CharsetDetector();
        charsetDetector.setText( is instanceof BufferedInputStream ? is : new BufferedInputStream(is) );
        charsetDetector.enableInputFilter(true);
        CharsetMatch cm = charsetDetector.detect();
        return cm.getName();
    }
}
