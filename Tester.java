public class Tester{
    public static void main(String[] args) throws Exception
    {
        MyStringBuilder msb1 = new MyStringBuilder('x');
        MyStringBuilder msb2 = new MyStringBuilder("String");
        MyStringBuilder copy = new MyStringBuilder(msb2);
        //System.out.println("here "+ msb1.start); make instance vars public for testing
        System.out.println(copy.subString(5));
        System.out.println(msb1.append('a'));
        MyStringBuilder MSB = new MyStringBuilder("");
        MSB.toString();
        //nothing prints
    } 
}