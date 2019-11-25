package com.itmuch.conf;

import feign.Contract;
import org.springframework.context.annotation.Bean;

/**
 * @description: FeignConfiguration
 * @author: ding
 * @date: 2019/11/10 10:55
 * @version: 1.0
 */

/**
 * 这里不要用configuration注解,如果添加则不能放在主程序上下文@ComponentScan所扫描的包中
 */

public class FeignConfiguration {

    /**
     * 将契约改为feign原生得默认契约.这样就可以使使用feign自带的注解了
     * 类似的还可以自定义编码器.解码器.日志打印.甚至为feign添加拦截器
     * @return
     */
    @Bean
    public Contract feignContract() {
        return new feign.Contract.Default();
    }
}
