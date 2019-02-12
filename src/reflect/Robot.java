package reflect;

public class Robot {
    private String name;
    public void sayHi(String s)
    {
        System.out.println(s+":"+name);
    }
    private String throwHello(String tag)
    {
        return "Hello"+tag;
    }
    private void test()
    {
        System.out.println("just test private void method");
    }
    private void newtest(String a,String b)
    {
        System.out.println("other test");
    }
}
