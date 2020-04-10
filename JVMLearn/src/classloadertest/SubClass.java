package classloadertest;

public class SubClass extends SuperClass
{
    /*
     * main调用 SubClass.value属于被动引用，因此该子类不会被初始化
     */
    static
    {
        System.out.println("SubClass init");
    }
}
