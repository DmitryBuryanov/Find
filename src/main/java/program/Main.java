package program;

import helpProgram.FindFile;
import org.kohsuke.args4j.CmdLineParser;

public class Main {
    public static void main(String[] args) {
        FindFile finder = new FindFile();
        CmdLineParser parser = new CmdLineParser(finder);
        try {
            parser.parseArgument(args);
            finder.find();
            System.out.println(finder.find());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
