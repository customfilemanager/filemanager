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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Date;
import java.util.List;
import net.codejava.crypto.CryptoException;

/**
 *
 * @author CustomFileManager@gmail.com
 */
public class FileManager implements StorageManager, CustomFileManager {

    ArchivoDAO dao;

    public FileManager(){
        dao = new ArchivoDAO(Archivo.class);
    }

    private String getPathDefault(){
        Configuration conf = new FileConfiguration();
        if (!conf.serverPathAsDir().exists()) {
            conf.serverPathAsDir().mkdirs();
        }
        return conf.serverPathAsString();
    }

    private void saveFile(File file, String path) throws IOException, CryptoException{
        File serverFile = new File(path + File.separator + file.getName());
        Utils.encryptFile(file, serverFile);
        persistFile(serverFile);
    }

    private void persistFile(File file) throws IOException{
        Archivo arch = new Archivo();
        arch.setFechaCreacion(new Date());
        arch.setTipoArchivo(Archivo.TipoArchivo.OTRO);
        arch.setRutaParcial(file.getAbsolutePath());
        arch.setIsEncrypted(true);
        arch.setMd5(Utils.md5sum(file));
        arch.setTipoDeContenido(file.toURL().openConnection().getContentType());
        dao.create(arch);
    }

    @Override
    public void save(File file) throws IOException, CryptoException{
        saveFile(file, getPathDefault());
    }

    @Override
    public void save(File file, String path) throws IOException, CryptoException{
        saveFile(file, path);
    }

    @Override
    public void save(File file, Charset enc) throws FileNotFoundException, IOException, CryptoException{
        String contentType = file.toURL().openConnection().getContentType();
        if(contentType.equalsIgnoreCase("text/plain")){
            File fileTmp = File.createTempFile("temp-file-name", ".tmp");
            Utils.transform(file, fileTmp, enc);
            saveFile(fileTmp, getPathDefault());
        } else {
            saveFile(file, getPathDefault());
        }
    }

    @Override
    public void save(File file, Charset enc, String path) throws FileNotFoundException, IOException, CryptoException{
        String contentType = file.toURL().openConnection().getContentType();
        if(contentType.equalsIgnoreCase("text/plain")){
            File fileTmp = File.createTempFile("temp-file-name", ".tmp");
            Utils.transform(file, fileTmp, enc);
            saveFile(fileTmp, path);
        } else {
            saveFile(file, path);
        }
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
