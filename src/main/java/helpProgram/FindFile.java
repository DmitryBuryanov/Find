package helpProgram;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class FindFile {
    @Option(name = "-r")
    private boolean under;
    @Option(name = "-d")
    private String directoryName;
    @Argument(required = true)
    private String fileName;

    public static void main(String[] args) throws Exception {
        FindFile finder = new FindFile();
        System.out.println(finder.launch(args));
    }

    public String knowDirectory() {
        return System.getProperty("user.dir");
    }

    public String find() throws Exception {
        File found = new File(fileName);

        if (directoryName == null) directoryName = knowDirectory();
        File directory = new File(directoryName);

        if (!directory.exists()) throw new Exception("Введена неверная директория");

        return (searchRealization(directory, found));
    }

    private String searchRealization(File directoryName, File fileName) {
        File[] list = directoryName.listFiles();
        assert list != null;
        for (File file : list) {
            if (file.isDirectory() && under) {
                searchRealization(file, fileName);
                if (!searchRealization(file, fileName).equals("File is not found"))
                    return searchRealization(file, fileName);
            } else if (file.getName().equals(fileName.getName()))
                return Paths.get(file.getAbsolutePath()).toString();
        }
        return "File is not found";
    }

    public String launch(String[] args) throws Exception {
        CmdLineParser parser = new CmdLineParser(FindFile.this);
        try {
            parser.parseArgument(args);
            return FindFile.this.find();
        } catch (IOException | CmdLineException e) {
            e.printStackTrace();
        }
        return "File is not found";
    }

}