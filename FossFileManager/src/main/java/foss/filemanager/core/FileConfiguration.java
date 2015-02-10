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

import foss.filemanager.core.StorageManager.Encoding;
import java.io.File;

/**
 * Configuration for file management on filesystem.
 * @author CustomFileManager@gmail.com
 */
public class FileConfiguration implements Configuration {

    @Override
    public String serverPathAsString() {
        return "/tmp";
    }

    @Override
    public File serverPathAsDir() {
        return new File("/tmp");
    }

    @Override
    public StorageManager.Encoding defaultEncoding() {
        return Encoding.UTF8;
    }

    @Override
    public String defaultEncodingAsStr() {
        return Encoding.UTF8.toString();
    }

    @Override
    public boolean isEncriptionEnabled() {
        return true;
    }
    
}
