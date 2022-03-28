package com.shawnliang.data.refill;

import com.shawnliang.data.refill.db.DruidDataSourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Import;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2022/3/28
 */

@SpringBootApplication
@ServletComponentScan
@Import(DruidDataSourceConfig.class)
public class DataRefillApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataRefillApplication.class, args);
    }


}
