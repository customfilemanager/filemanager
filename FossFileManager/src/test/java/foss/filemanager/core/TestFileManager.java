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
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import net.codejava.crypto.CryptoException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Rule;
import org.junit.Test;

/**
 *
 * @author Davis Mendoza davis.men.pa@gmail.com
 */
public class TestFileManager extends TestBaseFileManager{

    @Rule
    FileManager fileManager = new FileManager();
    
    private final File testFile;
    private final File testFileTxt_1;
    private final File testFileTxt_2;
    private final File testFileTxt_3;

    public TestFileManager(){
        testFile = new File(getTestDirectory(), "file-test");
        testFileTxt_1 = new File(getTestDirectory(), "file-test-1.txt");
        testFileTxt_2 = new File(getTestDirectory(), "file-test-2.txt");
        testFileTxt_3 = new File(getTestDirectory(), "file-test-3.txt");
    }

    @Override
    protected void setUp() throws Exception {
        getTestDirectory().mkdirs();
        getTestTmpDirectory().mkdirs();
        createFile(testFile);
        createFileTxt(testFileTxt_1, 50);
        createFileTxt(testFileTxt_2, 150);
        createFileTxt(testFileTxt_3, 200);
    }

    @Override
    protected void tearDown() throws Exception {
        FileUtils.deleteDirectory(getTestDirectory());
        FileUtils.deleteDirectory(getTestTmpDirectory());
    }

    @Test
    public void testSave(){
        try {
            fileManager.save(testFile);
        } catch (final IOException ex) {
            // expected
        } catch (CryptoException ex) {
            // expected
        }
    }

    @Test
    public void testSavePath(){
        try {
            String path = getTestTmpDirectory().getAbsolutePath();
            fileManager.save(testFile, path);
        } catch (final IOException ex) {
            // expected
        } catch (CryptoException ex) {
            // expected
        }
    }

    @Test
    public void testSaveEncoding(){
        try {
            fileManager.save(testFileTxt_1, Charset.forName("UTF-8"));
            fileManager.save(testFileTxt_2, Charset.forName("ISO-8859-1"));
            fileManager.save(testFileTxt_3, Charset.forName("windows-1252"));
        } catch (final IOException ex) {
            // expected
        } catch (CryptoException ex) {
            // expected
        }
    }

    @Test
    public void testSaveEncodingPath(){
        String path = getTestTmpDirectory().getAbsolutePath();
        try {
            fileManager.save(testFileTxt_1, Charset.forName("UTF-8"), path);
            fileManager.save(testFileTxt_2, Charset.forName("ISO-8859-1"), path);
            fileManager.save(testFileTxt_3, Charset.forName("windows-1252"), path);
        } catch (final IOException ex) {
            // expected
        } catch (CryptoException ex) {
            // expected
        }
    }

    @Test
    public void testSaveByte(){
        String path = getTestTmpDirectory().getAbsolutePath();
        try {
            byte[] bFile1 = IOUtils.toByteArray(new FileInputStream(testFileTxt_1));
            byte[] bFile2 = IOUtils.toByteArray(new FileInputStream(testFileTxt_2));
            byte[] bFile3 = IOUtils.toByteArray(new FileInputStream(testFileTxt_3));
            fileManager.save(bFile1 , path);
            fileManager.save(bFile2, path);
            fileManager.save(bFile3, path);
        } catch (final IOException ex) {
            // expected
        } catch (CryptoException ex) {
            // expected
        }
    }
}
