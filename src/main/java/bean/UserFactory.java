package bean;

import com.lmax.disruptor.EventFactory;

public class UserFactory implements EventFactory<UserInfo> {
    public UserInfo newInstance() {
        return new UserInfo();
    }
}
