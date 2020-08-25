package highnes.top.template;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author DangR-X
 * @date 2020/8/25
 * @description
 */
@SpringBootApplication
@MapperScan("highnes.top.template.mapper")
public class TemplateApplication {


    public static void main(String[] args) {
        SpringApplication.run(TemplateApplication.class,args);
    }

}
