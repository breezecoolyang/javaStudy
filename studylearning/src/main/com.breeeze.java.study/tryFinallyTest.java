import java.util.HashMap;

public class tryFinallyTest {
    public static void main(String[] args) {
//        int value =3;
//
//       try {
//           System.out.println("run before return ");
//           value++;
//           return ;
//
//       }finally {
//           value++;
//           System.out.println("run in finally, i is " + value);
//       }
        HashMap<String, String> queueEnvironment = new HashMap<String, String>();
        queueEnvironment.put("hello", "world");
        System.out.println(queueEnvironment);
    }
}
