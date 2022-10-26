package com.codegym.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.io.*;
import java.time.LocalDateTime;

@Aspect
@Component
public class AspectBookTitleController {

    @After("execution(* com.codegym.controller.TitleController.*(..))")
    public void logAfterMethodTitleController(JoinPoint joinPoint) throws IOException {
        String methodName = joinPoint.getSignature().getName();
        String log = "User call " + methodName + ": " + LocalDateTime.now();
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream ot = null;
//        try{
//            fileOutputStream = new FileOutputStream("C:\\code_gym\\module_4\\ss10_Aop\\BookManager\\BookManager\\src\\main\\java\\com\\codegym\\aspect\\logTitleController.txt");
//            ot = new ObjectOutputStream(fileOutputStream);
//            ot.writeObject(log);
//            ot.close();
//            fileOutputStream.close();
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
            File file = new File("C:\\\\code_gym\\\\module_4\\\\ss10_Aop\\\\BookManager\\\\BookManager\\\\src\\\\main\\\\java\\\\com\\\\codegym\\\\aspect\\\\logTitleController.txt");
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(log);
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
    }

}
