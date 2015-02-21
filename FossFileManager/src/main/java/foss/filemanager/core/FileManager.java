/*
 * Copyright (C) 2015 Nicolai Carlo Abruzzese Aguirre <nicolai@todoOpen.com>
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

import com.todoopen.archivos.entity.Archivo;
import com.todoopen.platform.dao.ArchivoDAO;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.Date;
import java.util.List;
import net.codejava.crypto.CryptoException;
import net.codejava.crypto.CryptoUtils;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author CustomFileManager@gmail.com
 */
public class FileManager implements StorageManager, CustomFileManager {

    ArchivoDAO dao;

    public FileManager(){
        dao = new ArchivoDAO(Archivo.class);
    }

    private void saveFile(File file, String path) throws IOException, CryptoException{
        File serverFile = new File(path + File.separator + file.getName());
        encryptFile(file, serverFile);
        persistFile(serverFile);
    }

    private void persistFile(File file) throws IOException{
        Archivo arch = new Archivo();
        arch.setFechaCreacion(new Date());
        arch.setTipoArchivo(Archivo.TipoArchivo.OTRO);
        arch.setRutaParcial(file.getAbsolutePath());
        arch.setIsEncrypted(true);
        arch.setMd5(md5sum(file));
        arch.setTipoDeContenido(file.toURL().openConnection().getContentType());
        dao.create(arch);
    }

    private void encryptFile(File inputFile, File encryptedFile) throws CryptoException{
        CryptoUtils.encrypt(CryptoUtils.key, inputFile, encryptedFile);
    }

    private String md5sum(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        String md5 = org.apache.commons.codec.digest.DigestUtils.md5Hex(fis);
        fis.close();
        return md5;
    }

    @Override
    public void save(File file) throws IOException, CryptoException{
        Configuration conf = new FileConfiguration();
        if (!conf.serverPathAsDir().exists()) {
            conf.serverPathAsDir().mkdirs();
        }
        saveFile(file, conf.serverPathAsString());
    }

    @Override
    public void save(File file, String path) throws IOException, CryptoException{
        saveFile(file, path);
    }

    @Override
    public void save(File file, Encoding enc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(File file, Encoding enc, String path) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(File file, Encoding enc, String path, File pathAsFile) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(byte[] fileBArray, String path) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(byte[] fileBArray, Encoding enc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(byte[] fileBArray, Encoding enc, String path) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(byte[] fileBArray, Encoding enc, File path) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isFileZeroBytes(File file) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isFileZeroBytes(String path) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isFileEncoding(File file, Encoding enc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isFileEncoding(String path, Encoding enc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public File load(String path) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public File load(String path, Encoding enc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(File file, Archivo archivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(File file, String path, Archivo archivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(File file, Encoding enc, Archivo archivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(byte[] fileBArray, Archivo archivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(byte[] fileBArray, Encoding enc, Archivo archivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isFileZeroBytes(Archivo archivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isFileEncoding(Archivo archivo, Encoding enc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public File load(Archivo archivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public File load(Archivo archivo, Encoding enc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public File load(Long archivoId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Archivo loadArchivo(Archivo archivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Files> loadArchivos(List<Long> archivosIds) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<File> load(List<Long> archivosIds) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Archivo> loadArchivosAsArchs(List<Archivo> archivoss) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
