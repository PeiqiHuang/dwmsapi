package com.dwms.user.dao;

import com.dwms.common.mapper.IdMapper;
import com.dwms.user.model.bean.User;
import com.dwms.user.model.form.UpdForm;
import com.dwms.user.model.vo.UserVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户信息DAO接口
 * @author windy
 * @date 2018-11-23
 */
public interface IUserDAO extends IdMapper<User> {

    /**
     * 查询用户
     * @author windy
     * @date 2018-11-28
     */
    UserVO selectById(@Param("userId") String userId);

    /**
     * 查询用户
     * @author windy
     * @date 2018-11-28
     */
    UserVO selectByMobile(@Param("mobile") String mobile);

    /**
     * 党员列表
     * @author windy
     * @date 2018-12-06
     */
    List<UserVO> selectByPartyId(@Param("partyId") Integer partyId);

    /**
     * 校验密码
     * @author windy
     * @date 2018-11-28
     */
    boolean check(@Param("mobile") String mobile, @Param("password") String password);

    /**
     * 重设密码
     * @author windy
     * @date 2018-11-28
     */
    boolean reset(@Param("mobile") String mobile, @Param("password") String password);

    /**
     * 修改信息
     * @author windy
     * @date 2018-11-28
     */
    boolean upd(@Param("form") UpdForm form);

}
