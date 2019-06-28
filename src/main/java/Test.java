import bean.*;
import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.EventHandlerGroup;
import com.lmax.disruptor.dsl.ProducerType;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        UserFactory factory = new UserFactory();
        ThreadFactory threadFactory = new ThreadFactory();
        Disruptor<UserInfo> disruptor = new Disruptor<UserInfo>(factory,1024,threadFactory, ProducerType.MULTI,new BlockingWaitStrategy());
        ConsumerHander c1 = new ConsumerHander();
        ConsumerOtherHandler c2 = new ConsumerOtherHandler();
        EventHandlerGroup<UserInfo> group = disruptor.handleEventsWith(c2);
        group.then(c1);
        disruptor.start();
        RingBuffer<UserInfo> ringBuffer = disruptor.getRingBuffer();
        for (int i=0;i<100;i++) {
            Long id = ringBuffer.next();
            UserInfo userInfo = ringBuffer.get(id);
            userInfo.setAge(i);
            userInfo.setName(String.valueOf(i));
            ringBuffer.publish(id);
        }
        Thread.sleep(10000);
        disruptor.shutdown();
    }
}
