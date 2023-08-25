package com.example.manageprojectemployeeretro;

import com.example.manageprojectemployeeretro.bean.PrototypeBean;
import com.example.manageprojectemployeeretro.bean.SingletonBean;
import com.example.manageprojectemployeeretro.config.Config;
import com.example.manageprojectemployeeretro.bean.Girl;
import com.example.manageprojectemployeeretro.config.Menu;
import com.example.manageprojectemployeeretro.scheduled.Schedule;
import com.example.manageprojectemployeeretro.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.EntityManagerFactory;

@SpringBootApplication
@EnableScheduling
@EnableAsync
@EnableConfigurationProperties
public class ManageProjectEmployeeRetroApplication implements CommandLineRunner {

    @Autowired
    Menu menu;

    @Autowired
    Config config;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    private Schedule schedule;


    public static void main(String[] args) {
        System.out.println("> Before the IoC Container is initialized");
        ApplicationContext context = SpringApplication.run(ManageProjectEmployeeRetroApplication.class, args);
        System.out.println("> After the IoC Container is initialized");

        Girl girl = context.getBean(Girl.class);
        ((ConfigurableApplicationContext)context).getBeanFactory().destroyBean(girl);
        System.out.println("After IOC destroy girl");

        //        Scope bean singleton
        SingletonBean bean1 = context.getBean(SingletonBean.class);
        System.out.println(bean1.getMessage()); // Output: Hello, I am a singleton bean!
        bean1.setMessage("Đây alf 1 bean mơi");
        SingletonBean bean2 = context.getBean(SingletonBean.class);
        System.out.println(bean2.getMessage()); // Output: Hello, I am a singleton bean!


        System.out.println(bean1 == bean2); // Output: true (cùng một instance)
        //        Scope bean singleton
        PrototypeBean prototypebean1 = context.getBean(PrototypeBean.class);
        System.out.println(prototypebean1.getMessage());

        PrototypeBean prototypebean2 = context.getBean(PrototypeBean.class);
        System.out.println(prototypebean2.getMessage());

        System.out.println("prototype sẽ cho instance khác nhau : " + (prototypebean1 == prototypebean2));// ra false

//
        String password = "anhladuong";
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // Mã hóa mật khẩu
        String encodedPassword = passwordEncoder.encode(password);
        System.out.println("Encoded password: " + encodedPassword);

        // Kiểm tra mật khẩu
        boolean matches = passwordEncoder.matches(password, encodedPassword);
        System.out.println("Password matches: " + matches);

    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("\t mail: "+ menu.getEmail());
        System.out.println("\t menus: "+ menu.getGoogleAnalyticsId());
    }


}
