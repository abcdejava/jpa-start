import org.junit.Test;
import top.abcdit.jpa.pojo.StudentEntity;
import top.abcdit.jpa.utils.JPAUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.Timestamp;

public class StudentTest {
    public static void main(String[] args) {


        try {
            //1.获得操作对象
            EntityManager entityManager = JPAUtils.getEntityManager();
            //2.启动事务
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            //进行持久化操作
            StudentEntity studentEntity = new StudentEntity();
            studentEntity.setStudentName("王5");
            studentEntity.setStudentPwd("1234565");

            studentEntity.setStudentStatus(1);

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            studentEntity.setCreateDate(timestamp);
            //3.插入
            entityManager.persist(studentEntity);
            //4.提交事务
            transaction.commit();
            //5.关闭
            entityManager.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void save(){

        //1.创建 EntityManagerFactory
        String persistenceUnitName = "NewPersistenceUnit";
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);

        //2.创建 EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //3.开启事务
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        //4.进行持久化操作
        StudentEntity student = new StudentEntity();
        student.setStudentName("王5");
        student.setStudentPwd("1123654");

        //5.提交事务
        transaction.commit();

        //6.关闭entityManager
        entityManager.close();
        //7.关闭entityManagerFactory
        entityManagerFactory.close();


    }


}
