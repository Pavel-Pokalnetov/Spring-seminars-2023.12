package ru.gb.pokalnetovps.devtools;

public class DevTools {
    public static void printObjMetaData(Object object){
                System.out.print(object.getClass().getSimpleName()+" | ");  // имя класса
                System.out.println(Thread.currentThread().getStackTrace()[2].getMethodName());  // имя метода
        }



}
