package com.cn.mapper;

import com.cn.mybatis.SysUser;

import java.util.List;

/**
* @author cn
* @description 针对表【sys_user(用户表)】的数据库操作Mapper
* @createDate 2025-05-14 12:30:34
* @Entity com.cn.mybatis.SysUser
*/
public interface SysUserMapper {

    List<SysUser> selectAllUserAndRoles();

}




