import org.junit.jupiter.api.Test;
import program.Main;

import static org.junit.jupiter.api.Assertions.*;

public class Tests {

    @Test
    public void test1() throws Exception {
        assertEquals("C:\\Users\\Uzer\\IdeaProjects\\Find\\TestDirectory\\TestFile1.txt",
                Main.getResult(new String[]{"-r", "-d", "TestDirectory", "TestFile1.txt"}));
    }

    @Test
    public void test2() throws Exception {
        assertEquals("C:\\Users\\Uzer\\IdeaProjects\\Find\\TestDirectory\\TestDirectory2\\TestDirectory3\\TestFile4.txt",
                Main.getResult(new String[]{"-r", "-d", "TestDirectory\\TestDirectory2", "TestFile4.txt"}));
    }

    @Test
    public void test3() throws Exception {
        assertEquals("File is not found", Main.getResult(new String[]{"-d", "TestDirectory", "TestFile4.txt"}));
    }

    @Test
    public void test4() throws Exception {
        assertEquals("C:\\Users\\Uzer\\IdeaProjects\\Find\\TestDirectory\\TestFile1.txt",
                Main.getResult(new String[]{"-r", "TestFile1.txt"}));
    }

    @Test
    public void test5() throws Exception {
        assertEquals("File is not found", Main.getResult(new String[]{"-r", "-d", "TestDirectory", "TestFile5.txt"}));
    }
}
