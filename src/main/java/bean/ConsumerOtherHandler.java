package bean;

import com.lmax.disruptor.EventHandler;

public class ConsumerOtherHandler implements EventHandler<UserInfo> {
    public void onEvent(UserInfo userInfo, long l, boolean b) throws Exception {
        System.out.println(l);
        int tmp = userInfo.getAge()+10;
        System.out.println("ConsumerOtherHandler user age is :"+tmp);
    }
}
