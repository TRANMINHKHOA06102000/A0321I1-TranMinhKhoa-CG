package b5_accessmodifier_staticmethod_staticproperty.thuchanh.accessmodifier;
class A{

    private static int data=40;

    private void msg(){System.out.println("Hello java");}

}
public class Private {
    public static void main(String args[]){

        A obj=new A();

        /*System.out.println(obj.data);//Compile Time Error

        obj.msg();//Compile Time Error
*/
    }
}
