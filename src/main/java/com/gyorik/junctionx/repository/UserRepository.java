package com.gyorik.junctionx.repository;

import com.gyorik.junctionx.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/*
@Repository
public class UserRepository{

    @PersistenceContext
    private EntityManager em;


    @Transactional
    public User save(User feedback) {
        return em.merge(feedback);
    }

    public List<User> findAll() {
        return em.createQuery("SELECT n FROM User n", User.class).getResultList();
    }

    public User findById(long id) {
        return em.find(User.class, id);
    }

    public List<User> findByKeyword(String keyword) {
        return em.createQuery("SELECT n FROM User n WHERE n.text LIKE ?1", User.class).setParameter(1, '%' + keyword + '%').getResultList();
    }

    @Transactional
    public void deleteById(long id) {
        User temp = findById(id);
        em.remove(temp);
    }

}*/

public interface UserRepository extends JpaRepository<User, Long> {

}