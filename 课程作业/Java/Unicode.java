public class Unicode {
    public static void main(String args[]) {
        char name[] = {'杨','阳'};
        for (int i = 0; i < 2; i++) {
            int a = (int) name[i];
            System.out.println("第一个字" + name[i] + "的编码是："+(int)a);
        }
    }
}
