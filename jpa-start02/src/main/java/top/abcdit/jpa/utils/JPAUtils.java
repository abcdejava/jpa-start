package top.abcdit.jpa.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {

    // 通过getEntityManagerFactory()获得实体管理工厂
    public static final EntityManagerFactory ENTITY_MANAGER_FACTORY = JPAUtils.getEntityManagerFactory();

    // 1.获得实体管理工厂
    private static EntityManagerFactory getEntityManagerFactory() {

        return Persistence.createEntityManagerFactory("NewPersistenceUnit");

    }

    //2.获得会话对象
    public static EntityManager getEntityManager(){
        return ENTITY_MANAGER_FACTORY.createEntityManager();

    }

    public static void main(String[] args) {
        System.out.println(JPAUtils.getEntityManager());
        System.out.println("test1");
    }
}