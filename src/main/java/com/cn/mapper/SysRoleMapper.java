package com.cn.mapper;

import com.cn.mybatis.SysRole;

/**
* @author cn
* @description 针对表【sys_role(角色表)】的数据库操作Mapper
* @createDate 2025-05-14 12:30:27
* @Entity com.cn.mybatis.SysRole
*/
public interface SysRoleMapper {


   SysRole selectRoleById(Long id);

}




