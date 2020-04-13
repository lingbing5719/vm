package com.ch.vm.user.mapper;

import com.ch.vm.user.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 菜单信息 Mapper 接口
 * </p>
 *
 * @author 林乐福
 * @since 2020-04-03
 */
@Repository
public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> getAllMenu();
}
