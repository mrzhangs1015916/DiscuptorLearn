package bean;

import com.lmax.disruptor.EventHandler;

public class ConsumerHander implements EventHandler<UserInfo> {
    public void onEvent(UserInfo userInfo, long l, boolean b) throws Exception {
        System.out.println("id is:"+l);
        System.out.println("ConsumerHander user age is :"+userInfo.getAge());
    }
}
