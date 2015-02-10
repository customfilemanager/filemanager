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
import java.io.File;
import java.nio.file.Files;
import java.util.List;

/**
 *
 * @author CustomFileManager@gmail.com
 */
public interface CustomFileManager {
    
    void save(File file, Archivo archivo);
    
    void save(File file, String path, Archivo archivo);
    
    void save(File file, StorageManager.Encoding enc, Archivo archivo);
    
    void save(byte[] fileBArray, Archivo archivo);
    
    void save(byte[] fileBArray, StorageManager.Encoding enc);//Archivo archivo
    
    void save(byte[] fileBArray, StorageManager.Encoding enc, Archivo archivo);
    
    boolean isFileZeroBytes(Archivo archivo);
    
    boolean isFileEncoding(Archivo archivo, StorageManager.Encoding enc);
    
    File load(Archivo archivo);
    
    File load(Archivo archivo, StorageManager.Encoding enc);
    
    File load(Long archivoId);
    
    Archivo loadArchivo(Archivo archivo);
    
    List<Files> loadArchivos(List<Long> archivosIds);
    
    List<File> load(List<Long> archivosIds);
    
    List<Archivo> loadArchivosAsArchs(List<Archivo> archivoss);
    
    
}
