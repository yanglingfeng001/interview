package bytecode;

public class ByteCode {
    //class文件存放的是java文件编译过后形成的二进制字节码
    //给自己加上了无参数的构造函数
    //跨平台执行class文件的时候需要与原来的class文件拥有一样的package结构才行
    public static void main(String[] args) {
        int i=1,j=5;
        i++;
        ++j;
        System.out.println(i);
        System.out.println(j);
    }
}
