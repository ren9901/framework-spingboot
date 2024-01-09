package com.framework.jwt.service;

import com.framework.common.domain.entity.SysRole;
import com.framework.common.domain.entity.SysUser;
import com.framework.common.domain.entity.SysUserRole;
import com.framework.common.domain.mapper.SysRoleMapper;
import com.framework.common.domain.mapper.SysUserMapper;
import com.framework.common.domain.mapper.SysUserRoleMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author renxiansheng
 * @date 2023/10/23 16:53
 * @description: TODO
 */
@Service
@Slf4j
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserMapper userMapper;
    @Autowired
    private SysUserRoleMapper userRoleMapper;

    @Autowired
    private SysRoleMapper roleMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 从数据库中查询
        SysUser userDO = userMapper.findByUsername(username);

        // 判断用户是否存在
        if(Objects.isNull(userDO)){
            throw new UsernameNotFoundException("该用户不存在");
        }
        SysUserRole sysUserRole = userRoleMapper.getRoleByUserId(userDO.getUserId());

        // 用户角色
        List<SysRole> sysRoleDos = roleMapper.selectByUserId(sysUserRole.getRoleId());

        String[] roleArr = null;
        if(!CollectionUtils.isEmpty(sysRoleDos)){
            List<String> roles  = sysRoleDos.stream().map(p -> p.getRoleKey()).collect(Collectors.toList());
            roleArr = roles.toArray(new String[roles.size()]);
        }

        // authorities 用于指定角色，
        return User.withUsername(userDO.getUserName())
                .password(userDO.getPassword())
                .authorities(roleArr)
                .build();
    }
}
