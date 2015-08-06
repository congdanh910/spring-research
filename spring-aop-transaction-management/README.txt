1. Website reference :

        http://www.dineshonjava.com/2012/12/declarative-transaction-management.html#.VcI0gZOqqko
        http://www.mkyong.com/spring/spring-aop-transaction-management-in-hibernate/
        http://www.journaldev.com/2583/spring-aop-example-tutorial-aspect-advice-pointcut-joinpoint-annotations-xml-configuration
        http://stackoverflow.com/questions/13087928/spring-hibernate-transaction-management
2. Note something :

    There are 7 types of propagation supported by Spring :
        PROPAGATION_REQUIRED – Support a current transaction; create a new one if none exists.
        PROPAGATION_SUPPORTS – Support a current transaction; execute non-transactionally if none exists.
        PROPAGATION_MANDATORY – Support a current transaction; throw an exception if no current transaction exists.
        PROPAGATION_REQUIRES_NEW – Create a new transaction, suspending the current transaction if one exists.
        PROPAGATION_NOT_SUPPORTED – Do not support a current transaction; rather always execute non-transactionally.
        PROPAGATION_NEVER – Do not support a current transaction; throw an exception if a current transaction exists.
        PROPAGATION_NESTED – Execute within a nested transaction if a current transaction exists, behave like PROPAGATION_REQUIRED else.
    In most cases, you may just need to use the PROPAGATION_REQUIRED.