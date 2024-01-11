package com.framework.common.domain.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.framework.common.domain.entity.SysUser;
import com.framework.common.model.vo.sysuer.*;
import com.framework.common.utils.Response;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author renbao
 * @since 2024-01-09
 */
public interface ISysUserService extends IService<SysUser> {

    /**
     * 获取当前登录用户信息
     * @return
     */
    Response findUserInfo();

    /**
     * 用户列表
     * @return
     */
    Response findUserPageList(FindUserPageListReqVo findUserPageListReqVo);

    /**
     * 查看用户详情
     * @return
     */
    Response viewSysUser(ViewUserReqVo viewUserReqVo);

    /**
     * 添加用户
     * @return
     */
    void addSysUser(AddUserReqVo addUserReqVo);

    /**
     * 删除用户
     * @return
     */
    void deleteSysUser(ViewUserReqVo viewUserReqVo);

    /**
     * 更新用户
     * @return
     */
    void updateSysUser(UpdateUserReqVo updateUserReqVo);

    /**
     * 更新用户密码
     * @return
     */
    void updatePassword(UpdataPassWordReqVo updataPassWordReqVo);
}
