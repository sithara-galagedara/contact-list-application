package com.kuehnenagel.contactlist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

/* // TODO: 8/8/2022
*  Remove the "exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class}"
*  when connecting the datasource in yml
* */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class ContactListApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContactListApplication.class, args);
    }

}
