package com.ch.vm.websiteInformation.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ch.vm.websiteInformation.entity.Banner;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 各栏目banner Mapper 接口
 * </p>
 *
 * @author 朱清
 * @since 2020-04-08
 */
@Repository
public interface BannerMapper extends BaseMapper<Banner> {

    List<Banner> selectBannerPageByName(@Param("name") String name, Page<Banner> page);

}
