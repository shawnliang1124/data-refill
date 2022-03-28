package com.shawnliang.data.refill.service.impl;

import com.shawnliang.data.refill.domain.DataPackage;
import com.shawnliang.data.refill.mapper.DataPackageMapper;
import com.shawnliang.data.refill.service.DataPackageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2022/3/28
 */
@Service
public class DataPackageServiceImpl implements DataPackageService {
    /**
     * 流量套餐mapper组件
     */
    @Autowired
    private DataPackageMapper dataPackageMapper;

    @Override
    public List<DataPackage> queryAll() {
        return dataPackageMapper.queryAll();
    }
}
