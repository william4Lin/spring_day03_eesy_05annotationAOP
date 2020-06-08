package com.william.service;

/**
 * 账户保存的业务层
 */
public interface IAccountService {
    /**
     * 账户保存
     */
    void saveAccount();

    /**
     * 账户更新
     * @param i
     */
    void updateAccount(int i);

    /**
     * 账户删除
     * @return
     */
    int deleteAccount();
}
