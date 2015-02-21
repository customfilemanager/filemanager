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

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import junit.framework.TestCase;

/**
 *
 * @author davis
 */
public abstract class TestBaseFileManager extends TestCase{

    private static volatile File testDir;

    public static File getTestDirectory() {
        if (testDir == null) {
            testDir = new File("test/files/").getAbsoluteFile();
        }
        testDir.mkdirs();
        return testDir;
    }

    protected void createFile(final File file)
            throws IOException {
        RandomAccessFile f = new RandomAccessFile(file, "rw");
        f.setLength(256);
    }
}
