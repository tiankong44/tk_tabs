package com.tiankong44.tool.test.service;

import com.tiankong44.tool.mapper.slave.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**

 * @Description :
 * @Author zhanghao_SMEICS
 * @Date 2022/10/21  15:23
 **/
@Service
public class TestService {

    @Autowired
    TestMapper testMapper;

    public int test() {
        return testMapper.test();

    }
}
