package reflect;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Sample {
    public static void main(String[] args) throws Exception{//私有方法的调用
        Class rc=Class.forName("reflect.Robot");
        Robot r=(Robot)rc.newInstance();
        System.out.println("Class name is:"+rc.getName());
        Method getHello=rc.getDeclaredMethod("throwHello", String.class);//不能获取实现的接口的方法和继承的方法
        getHello.setAccessible(true);
        Object str=getHello.invoke(r,"Bob");
        System.out.println(str);

        //另外一种方式
        Method sayHi = rc.getMethod("sayHi", String.class);
        sayHi.invoke(r,"welcome");

        Field name=rc.getDeclaredField("name");
        name.setAccessible(true);
        name.set(r,"Alice");
        sayHi.invoke(r,"welcome");


        Class c=Class.forName("reflect.Robot");//getMethod不可以获取私有方法 ，但可以用declared不可以使用的，两者相辅相成
        // 但getDeclared可以获取私有方法，不能获取实现的接口的方法和继承的方法
        Robot r2=(Robot)c.newInstance();
        Method m=c.getDeclaredMethod("newtest", String.class, String.class);
        m.setAccessible(true);
        m.invoke(r,"a,","b");

    }
}
