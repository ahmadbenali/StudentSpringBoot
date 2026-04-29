package com.example.SpringBoot.DAO;

import com.example.SpringBoot.Entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImp implements StudentDAO{

    private final EntityManager entityManager;

    @Autowired
    public StudentDaoImp(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional//it's a safety way when update or modification with database, without it will give error
    public void save(Student student) {
    entityManager.persist(student); // to save in DB
    }

    @Override
    public Student findById(int Id){
        return entityManager.find(Student.class,Id);
    }

    @Override
    public List<Student> findAll() {
        //FROM Student, here Student is the name of entity(class name) not name of the table.
        //this a big topic to see and learn
        TypedQuery<Student> theQuery=entityManager.createQuery("FROM Student",Student.class);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        entityManager.merge(student);
    }
}
