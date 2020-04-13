package com.ch.vm.vod.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ch.vm.vod.entity.ResourceType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 点播资源类型 Mapper 接口
 * </p>
 *
 * @author 朱清
 * @since 2020-04-08
 */
@Repository
public interface ResourceTypeMapper extends BaseMapper<ResourceType> {

    List<ResourceType> selectResourceTypePageByName(@Param("name") String m, Page<ResourceType> page);

    List<ResourceType> selectPageVO(@Param("id") int id);
}
