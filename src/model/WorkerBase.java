package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class WorkerBase{
    private String name_file;
    private String[] resultString;

    public WorkerBase(String name_file){
        this.name_file = name_file;
    }

    public void init() throws IOException {
        File file = new File(name_file);
        FileInputStream fis = new FileInputStream(file);
        byte[] byteArray = new byte[(int)file.length()];
        fis.read(byteArray);
        String data = new String(byteArray);
        resultString = data.split("\r\n");
    }

    public int countString() throws IOException {
        return resultString.length;
    }

    public int  randomString() throws IOException {
        return (int) (Math.random() * countString());
    }

    public String getRandomString() throws IOException {
        int result_string = randomString();
        return resultString[result_string];
    }

}
