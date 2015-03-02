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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;
import junit.framework.TestCase;

/**
 *
 * @author davis
 */
public abstract class TestBaseFileManager extends TestCase{

    private static volatile File testDir;
    private static volatile File testTmpDir;

    public static File getTestDirectory() {
        if (testDir == null) {
            testDir = new File("test/files/").getAbsoluteFile();
        }
        testDir.mkdirs();
        return testDir;
    }

    public static File getTestTmpDirectory() {
        if (testTmpDir == null) {
            testTmpDir = new File("test/tmp-files/").getAbsoluteFile();
        }
        testTmpDir.mkdirs();
        return testTmpDir;
    }

    protected void createFile(final File file)
            throws IOException {
        RandomAccessFile f = new RandomAccessFile(file, "rw");
        f.setLength(256);
    }

    protected void createFileTxt(final File file, int size) {
        try {
          BufferedWriter output = new BufferedWriter(new FileWriter(file));
          output.write(randomContent(size));
          output.close();
        } catch ( IOException e ) {
           // expected
        }
    }

    private String randomContent(int length) {
        String base = "0123456789ABCDEFGHIJKLMNÑOPQRSTUVWXYZabsdefghijklmnñopqrstuvwxyzáéíóú";
        Random random = new Random();
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < length; i++) {
            b.append(base.charAt(random.nextInt(base.length())));
        }
        return b.toString();
    }
}
