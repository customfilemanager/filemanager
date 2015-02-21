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
import java.util.logging.Level;
import java.util.logging.Logger;
import net.codejava.crypto.CryptoException;
import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.Test;
import sun.org.mozilla.javascript.tools.idswitch.FileBody;

/**
 *
 * @author Davis Mendoza davis.men.pa@gmail.com
 */
public class TestFileManager extends TestBaseFileManager{

    @Rule
    FileManager fileManager = new FileManager();
    
    private final File testFile;
    
    public TestFileManager(){
        testFile = new File(getTestDirectory(), "file-test.txt");
    }

    @Override
    protected void setUp() throws Exception {
        getTestDirectory().mkdirs();
        createFile(testFile);
    }

    @Override
    protected void tearDown() throws Exception {
        FileUtils.deleteDirectory(getTestDirectory());
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
}
