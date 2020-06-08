package com.william.service.impl;

import com.william.service.IAccountService;
import org.springframework.stereotype.Service;

/**
 * 账户保存的业务层的实现
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    /**
     * 模拟账户保存
     */
    public void saveAccount() {
        System.out.println("账户保存了。。。");

    }

    /**
     * 模拟账户更新
     * @param i
     */
    public void updateAccount(int i) {
        System.out.println("账户更新了。。。");

    }

    /**
     * 模拟账户删除
     * @return
     */
    public int deleteAccount() {
        System.out.println("账户删除了。。。");
        return 0;
    }
}
