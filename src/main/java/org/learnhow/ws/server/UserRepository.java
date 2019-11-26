package org.learnhow.ws.server;

import org.learnhow.ws.schema.Gender;
import org.learnhow.ws.schema.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yanh
 * @create 2019/11/26 18:23
 * @description 业务逻辑
 */
@Component
public class UserRepository {
    private static final Map<String, User> users = new HashMap<>();

    @PostConstruct
    public void initData() {
        User zhangsan = new User();
        zhangsan.setName("张三");
        zhangsan.setAge(16);
        zhangsan.setAddress("上海");
        zhangsan.setGender(Gender.MALE);

        User lisi = new User();
        lisi.setName("李四");
        lisi.setAge(19);
        lisi.setAddress("北京");
        lisi.setGender(Gender.MALE);

        User wangwu = new User();
        zhangsan.setName("王五");
        zhangsan.setAge(17);
        zhangsan.setAddress("深圳");
        zhangsan.setGender(Gender.FEMALE);

        users.put(zhangsan.getName(), zhangsan);
        users.put(lisi.getName(), lisi);
        users.put(wangwu.getName(), wangwu);
    }

    public User findUser(String name) {
        return users.get(name);
    }
}
