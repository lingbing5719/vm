package com.ch.vm.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ch.vm.user.entity.Role;
import com.ch.vm.user.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author 林乐福
 * @since 2020-04-03
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    User loadUserByUsername(String s);
    List<Role> getRolesByUserId(Long username);
}
