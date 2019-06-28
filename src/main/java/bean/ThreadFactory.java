package bean;

public class ThreadFactory implements java.util.concurrent.ThreadFactory {
    public Thread newThread(Runnable r) {
        return new Thread(r,"test-disprtor");
    }
}
