package my.learn.service;

import lombok.Getter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService {

    @Getter
    public String filePath;


    public void setFilePath(String filePath) throws Exception {
        this.filePath = filePath;
        if (!isValidFilePath()) {
            invalidateFile();
        }
    }


    public String getFileText() throws Exception {
        String content = "";
        try {
            Path path = Paths.get(filePath);
            content = Files.readString(path);
        } catch (Exception e) {
            invalidateFile();
        }
        return content;
    }

    public boolean isValidFilePath() {
        try {
            Path path = Paths.get(filePath);
            Files.readString(path);
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    public int getCountOfWords() throws Exception {
        String fileText = getFileText();
        char[] charArray = fileText.toCharArray();
        int count = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == ' ') {
                count++;
            }
        }
        if  (count == 0 && charArray.length != 0) {
            return 1;
        }
        return count;
    }

    public int findCountSubstringInFile(String userInput) throws Exception {
        String fileText = getFileText();
        String[] split = fileText.split(userInput);
        return split.length > 1? split.length - 1 : split.length;
    }


    public void invalidateFile() throws Exception {
        filePath = null;
        throw new Exception("Файл не найден, повторите ввод");
    }

}
