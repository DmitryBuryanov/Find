package helpProgram;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.Option;

import java.io.File;

public class FindFile {
    @Option(name = "-r")
    private boolean under;
    @Option(name = "-d")
    private String directoryName;
    @Argument(required = true)
    private String fileName;

    private String knowDirectory() {
        File directory = new File("Find-1.0-SNAPSHOT-jar-with-dependencies.jar");
        return (directory.getAbsolutePath().replace("Find-1.0-SNAPSHOT-jar-with-dependencies.jar", ""));
    }

    public String find() throws Exception {
       File found = new File(fileName);

        if (directoryName == null) directoryName = knowDirectory().substring(0, knowDirectory().length() - 1);
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
            } else if (file.getName().equals(fileName.getName())) return file.getAbsolutePath();
        }
        return "File is not found";
    }

}

