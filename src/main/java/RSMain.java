import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 서버
 * */
public class RSMain extends UnicastRemoteObject implements RSInterface {
    private static final long serialVersionUID = 1L;

    private static final String BIND_NAME = "//localhost/server";

    /**
     * UnicastRemoteObject 를 상속했다면 반드시
     * 생성자를 만들어주어야 한다. (RemoteException 을 던지도록)
     * @throws RemoteException
     * */
    protected RSMain() throws RemoteException {
        super();
    }

    @Override
    public void println(String msg) throws RemoteException {
        // RMI 호출이 되면 메세지를 프린트한다.
        System.out.println("[RMI-SERVER] " + msg);
    }

    public static void main(String[] args) {
        System.out.println("[RIM-Server] START");

        try {
            Naming.rebind(BIND_NAME, new RSMain());

            while (true);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                Naming.unbind(BIND_NAME);
            } catch (Exception e) {}
        }

        System.out.println("[RMI-Server] EXIT");
    }
}
