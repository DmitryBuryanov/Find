package program;

import helpProgram.FindFile;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws Exception {
        FindFile finder = new FindFile();
        CmdLineParser parser = new CmdLineParser(finder);
        try {
            parser.parseArgument(args);
            System.out.println(finder.find());
        } catch (IOException | CmdLineException e) {
            e.printStackTrace();
        }
    }

    public static String getResult(String[] args) throws Exception {
        FindFile finder = new FindFile();
        CmdLineParser parser = new CmdLineParser(finder);
        try {
            parser.parseArgument(args);
            return finder.find();
        } catch (IOException | CmdLineException e) {
            e.printStackTrace();
        }
        return "File is not found";
    }
}
