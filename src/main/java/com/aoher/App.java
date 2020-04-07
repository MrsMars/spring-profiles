package com.aoher;

import com.aoher.exception.ServiceException;
import com.aoher.model.Personne;
import com.aoher.service.PersonneService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) throws ServiceException {

        ApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:applicationContext.xml");

        PersonneService personneService = (PersonneService) context.getBean("personneService");
        personneService.setValeur("valuer1");
        personneService = (PersonneService) context.getBean("personneService");


        System.out.println(personneService.getValeur());

        Personne personne = new Personne(null, "dupont", "pierre");
        personneService.save(personne);
    }

}
