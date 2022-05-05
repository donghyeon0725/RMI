import java.rmi.Naming;

/**
 * 클라이언트
 * */
public class RCMain {
    public static void main(String[] args) {
        try {
            String url = "//127.0.0.1/server";

            RSInterface rs = (RSInterface) Naming.lookup(url);

            for (int i=0; i<10; i++) {
                rs.println(i + " 번 째 클라이언트 호출");
                Thread.sleep(200);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
