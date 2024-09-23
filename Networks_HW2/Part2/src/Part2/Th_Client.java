package Part2;
public class Th_Client implements Runnable {
    TCP_Client tcpclient;
    boolean done;
    public void stop(){ done = true;}
    Th_Client(TCP_Client tcpc) {
        tcpclient = tcpc;}
    public void start() {
        Thread thread = new Thread(this);
        thread.start();}
    public void run() {
        while (true) {            
            tcpclient.receive();}}
}
