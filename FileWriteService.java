package homework;


import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Properties;


public class FileWriteService {

    private FileOutputStream fileOutputStream;

    public FileWriteService()  {

            this.init();

    }

    public void init() {
        try {
            Properties p = new Properties();
            BufferedReader bf = new BufferedReader(
                    new FileReader("D:\\Javaweb123\\aopwork\\src\\main\\resource\\file.propertier"));
            p.load(bf);
            String path =  p.getProperty("path");
            File file = new File(path);
            if(!file.isFile()) {
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file);
            System.out.println("文件已打开。");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(String content){

        byte [] str_byte = content.getBytes();

        try {
            fileOutputStream.write(str_byte,0,str_byte.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("写入");

    }

    public void destory(){
        if (fileOutputStream!=null){
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("关闭");

    }
}
