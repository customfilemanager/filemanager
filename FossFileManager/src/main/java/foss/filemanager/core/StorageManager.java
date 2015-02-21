/*
 * Copyright (C) 2015 CustomFileManager@gmail.com
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

import static foss.filemanager.core.StorageManager.TypeStorage.FILE;
import java.io.File;
import java.io.IOException;
import net.codejava.crypto.CryptoException;


/**
 *
 * @author CustomFileManager@gmail.com
 */
public interface StorageManager {
    
    /**
     * Type of storage.
     */
    StorageManager.TypeStorage type = FILE;
    
    public static enum TypeStorage { FILE, DATABASE };
    
    /**
     * Enconding avalilable.
     */
    public static enum Encoding { UTF8, ISO_8859_1 };
    
    void save(File file) throws IOException, CryptoException;
    
    void save(File file, String path);
    
    void save(File file, Encoding enc);
    
    void save(File file, Encoding enc, String path);
    
    void save(File file, Encoding enc, String path, File pathAsFile);
    
    void save(byte[] fileBArray, String path);
    
    void save(byte[] fileBArray, Encoding enc);
    
    void save(byte[] fileBArray, Encoding enc, String path);
    
    void save(byte[] fileBArray, Encoding enc, File path);
    
    boolean isFileZeroBytes(File file);
    
    boolean isFileZeroBytes(String path);
    
    boolean isFileEncoding(File file, Encoding enc);
    
    boolean isFileEncoding(String path, Encoding enc);
    
    File load(String path);
    
    File load(String path, Encoding enc);
    
}
