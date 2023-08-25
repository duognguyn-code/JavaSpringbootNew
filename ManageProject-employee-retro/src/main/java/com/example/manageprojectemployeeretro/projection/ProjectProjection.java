package com.example.manageprojectemployeeretro.projection;

import java.time.LocalDate;

public interface ProjectProjection {
     String getName();
     String getDescription();
     LocalDate getStartDate();
}
//spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
//        spring.datasource.url=jdbc:mysql://localhost:3306/demospring
//        spring.datasource.username=root
//        spring.datasource.password=Nguyentungduong@1
//
//        # ===============================
//        # JPA /
//        # ===============================
//        spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
//        spring.jpa.hibernate.ddl-auto=none
//        spring.jpa.show-sql=true
//
//        # Logback configuration
//        logging.level.org.springframework.security=DEBUG
//        #mail
//        spring.jpa.properties.hibernate.enable_lazy_load_no_trans=true
//        server.port=7777
//        spring.mail.host=smtp.gmail.com
//        spring.mail.port=587
//        spring.mail.username=nguyentungduonglk1@gmail.com
//spring.mail.password=iscdvtuyqsfpwmbp
//        message= this is message in applicationproperties
//        # C?u hình thu?c tính khác (tu? ch?n)
//        spring.mail.properties.mail.smtp.auth=true
//        spring.mail.properties.mail.smtp.starttls.enable=true
//        spring.security.oauth2.client.registration.google.client-id=398668959823-u9lr4pchkou0r61onbqig5bcq523qjav.apps.googleusercontent.com
//        spring.security.oauth2.client.registration.google.client-secret=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
//        spring.security.oauth2.client.registration.google.scope=profile,email
//        spring.security.oauth2.client.registration.google.redirect-uri={baseUrl}/{action}/oauth2/code/{registrationId}
//        spring.security.oauth2.client.provider.google.authorization-uri=https://accounts.google.com/o/oauth2/v2/auth
//        spring.security.oauth2.client.provider.google.token-uri=https://www.googleapis.com/oauth2/v4/token
//        spring.security.oauth2.client.provider.google.user-info-uri=https://www.googleapis.com/oauth2/v3/userinfo
//        spring.security.oauth2.client.provider.google.user-name-attribute=name
