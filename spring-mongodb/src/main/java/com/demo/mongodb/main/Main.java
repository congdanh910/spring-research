package com.demo.mongodb.main;

import com.demo.mongodb.model.Lead;
import com.demo.mongodb.repository.LeadRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by danh.ho on 27/07/2015.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("mongodb-system-servlet.xml");

        LeadRepository leadRepository = ctx.getBean(LeadRepository.class);

        // The methods are implemented with the supporting of Repository by spring data
        /*

        // findByFirstname
        List<Lead> leads = leadRepository.findByFirstname("a");
        for (Lead lead : leads) {
            System.out.println("lead  : " + lead.toString());
        }
        // findByFirstnameLikeOrderByFirstnameDesc
        List<Lead> leads = leadRepository.findByFirstnameLikeOrderByFirstnameDesc("a");
        for (Lead lead : leads) {
            System.out.println("lead  : " + lead.toString());
        }
        */


        // The methods are using custom repository
        /*

        // findAllCustom
        List<Lead> customLeads = leadRepository.findAllCustom();
        for (Lead lead : customLeads) {
            System.out.println("lead  : " + lead.toString());
        }

        // findByIdCustom
        Lead lead = leadRepository.findByIdCustom("55b64eef0364a612487dfc5c");
        System.out.println("findByIdCustom : " + lead);

        // findByFirstNameOrLastNameCustom
        List<Lead> findByFnOrLn = leadRepository.findByFirstNameOrLastNameCustom("Danh", "Dang");
        for (Lead lead : findByFnOrLn) {
            System.out.println("lead  : " + lead.toString());
        }

        //findByFirstNameOrLastNameRegexCustom
        List<Lead> findByFnOrLn = leadRepository.findByFirstNameOrLastNameRegexCustom("a", "n");
        for (Lead lead : findByFnOrLn) {
            System.out.println("lead  : " + lead.toString());
        }

        // findAllOrderByFirstname
        List<Lead> orderByFirstname = leadRepository.findAllOrderByFirstname();
        for (Lead lead : orderByFirstname) {
            System.out.println("lead  : " + lead.toString());
        }
        */
    }

}
