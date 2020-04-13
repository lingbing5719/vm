package com.ch.vm.log.service.impl;

import com.ch.vm.log.entity.Oplog;
import com.ch.vm.log.mapper.OplogMapper;
import com.ch.vm.log.service.OplogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 操作日志 服务实现类
 * </p>
 *
 * @author 林乐福
 * @since 2020-04-07
 */
@Service
public class OplogServiceImpl extends ServiceImpl<OplogMapper, Oplog> implements OplogService {

}
