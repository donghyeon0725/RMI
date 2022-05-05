import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RSInterface extends Remote {
    /**
     * 클라이언트에서 호출할 RMI 메서드
     * 메세지를 콘솔에 출력합니다.
     * @param msg 프린트할 메세지
     * @throws RemoteException
     * */
    public void println(String msg) throws RemoteException;
}
