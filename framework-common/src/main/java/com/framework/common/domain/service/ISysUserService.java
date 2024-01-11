package com.framework.common.domain.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.framework.common.domain.entity.SysUser;
import com.framework.common.model.vo.sysuer.AddUserReqVo;
import com.framework.common.model.vo.sysuer.FindUserPageListReqVo;
import com.framework.common.model.vo.sysuer.ViewUserReqVo;
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
     * 添加用户
     * @return
     */
    Response addSysUser(AddUserReqVo addUserReqVo);

    /**
     * 查看用户详情
     * @return
     */
    Response viewSysUser(ViewUserReqVo viewUserReqVo);

    /**
     * 删除用户
     * @return
     */
    Response deleteSysUser(ViewUserReqVo viewUserReqVo);
}
