public class Caculate_Y {
    public static void main(String[] args) {
        float x = 5.2f;
        float y = 7f;
        float z = 2.3f;

        float result = CalculateValueOfY(x,y,z);
        System.out.println("Y的结果为: "+result);
    }

    public static float CalculateValueOfY(float x,float y,float z) {
        float num_float = (x+y)/2;
        num_float = (float)num_float/2;
        float num_int = (float)x/z;
        return num_float+num_int;
    }
}
