package com.shawnliang.data.refill.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * Description :   账户金额mapper组件 .
 *
 * @author : Phoebe
 * @date : Created in 2022/3/28
 */
@Mapper
public interface AccountAmountMapper {

    /**
     * 修改账户的金额
     * @param userAccountId 用户账号id
     * @param amount 账号金额
     */
    @Update("UPDATE account_amount "
            + "SET amount=amount + #{updatedAmount} "
            + "WHERE user_account_id=#{userAccountId}")
    void updateAmount(
            @Param("userAccountId") Long userAccountId,
            @Param("updatedAmount") Double updatedAmount);
}
