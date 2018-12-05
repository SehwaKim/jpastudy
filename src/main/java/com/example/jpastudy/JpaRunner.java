package com.example.jpastudy;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = new Account();
        account.setUsername("sehwa");
        account.setPassword("1235");

        Session session = entityManager.unwrap(Session.class);

//        entityManager.persist(account); jpa api 직접 이용하는 방법
        session.save(account); // 하이버네이트 api 직접 이용하는 방법
    }
}
