import helpProgram.FindFile;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class Tests {

    FindFile findfile = new FindFile();
    String curdir = findfile.knowDirectory();
    Path path1 = Paths.get(curdir);

    @Test
    public void test1() throws Exception {
        Path path2 = Paths.get(findfile.launch(new String[]{"-r", "-d", "testDirectory", "TestFile1.txt"}));

        assertEquals("testDirectory\\TestFile1.txt", path1.relativize(path2).toString());
    }

    @Test
    public void test2() throws Exception {
        Path path2 = Paths.get(findfile.launch(new String[]{"-r", "-d",
                "testDirectory\\testDirectory2", "TestFile4.txt"}));

        assertEquals("testDirectory\\testDirectory2\\testDirectory3\\TestFile4.txt",
                path1.relativize(path2).toString());
    }

    @Test
    public void test3() throws Exception {
        assertEquals("File is not found", findfile.launch(new String[]{"-d", "testDirectory", "TestFile4.txt"}));
    }

    @Test
    public void test4() throws Exception {
        Path path2 = Paths.get(findfile.launch(new String[]{"-r", "TestFile1.txt"}));
        assertEquals("testDirectory\\TestFile1.txt", path1.relativize(path2).toString());
    }

    @Test
    public void test5() throws Exception {
        assertEquals("File is not found", findfile.launch(new String[]{"-r", "-d", "testDirectory", "TestFile5.txt"}));
    }


}
