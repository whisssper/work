package homework;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {
    public static void main(String[] args){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("task.xml");
        FileWriteService fileWriteService = (FileWriteService) context.getBean("service");
        fileWriteService.init();
        fileWriteService.write("1");
        fileWriteService.destory();
    }
}
