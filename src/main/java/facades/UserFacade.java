package facades;

import security.IUserFacade;
import entity.Users;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import rest.User;
import security.IUser;
import security.PasswordStorage;

public class UserFacade implements IUserFacade {

    EntityManagerFactory emf;

    /*When implementing your own database for this seed, you should NOT touch any of the classes in the security folder
    Make sure your new facade implements IUserFacade and keeps the name UserFacade, and that your Entity User class implements 
    IUser interface, then security should work "out of the box" with users and roles stored in your database */
    public UserFacade() {
        addEntityManagerFactory(Persistence.createEntityManagerFactory("seed"));
        EntityManager em = emf.createEntityManager();
        
        try {
            Users u1 = new Users();
            Users u = new Users();
            u.setUserName("Anne");
            String password = PasswordStorage.createHash("test");
            u.setPassword(password);
            u.setRoles("Admin");
            PasswordStorage.createHash(password);

            u1.setUserName("Peter");
            String password1 = PasswordStorage.createHash("test");
            u1.setPassword(password1);
            u1.setRoles("User");
            em.getTransaction().begin();
            em.persist(u);
            em.persist(u1);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }

    }

    public static void main(String[] args) {
        Persistence.generateSchema("seed", null);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("seed");
        EntityManager em = emf.createEntityManager();
        
        try {
            Users u1 = new Users();
            Users u = new Users();
            u.setUserName("Anne");
            String password = PasswordStorage.createHash("test");

            u.setPassword(password);
            u.setRoles("Admin");

            u1.setUserName("Peter");
            String password1 = PasswordStorage.createHash("test");

            u1.setPassword(password1);
            u1.setRoles("User");
            em.getTransaction().begin();
            em.persist(u);
            em.persist(u1);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
    }

    public void addEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Users getUserByUserId(String id) {
        EntityManager em = emf.createEntityManager();

        try {
            return em.createQuery("SELECT u FROM Users u WHERE u.userName = :uname", Users.class).setParameter("uname", id).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /*
  Return the Roles if users could be authenticated, otherwise null
     */
    @Override
    public List<String> authenticateUser(String userName, String password) {
        EntityManager em = emf.createEntityManager();
        List<String> roles = new ArrayList();
        Users user = em.createQuery("SELECT u FROM Users u WHERE u.userName =:userName", Users.class).setParameter("userName", userName).getSingleResult();
        try {
            if (PasswordStorage.verifyPassword(password, user.getPassword())) {
                roles.add(user.getRoles());
                return roles;
            } else {
                roles = null;
            }
        } catch (PasswordStorage.CannotPerformOperationException ex) {
            Logger.getLogger(UserFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PasswordStorage.InvalidHashException ex) {
            Logger.getLogger(UserFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return roles;
    }

    @Override
    public void addNewUser(String username, String password) {
        EntityManager em = emf.createEntityManager();
        System.out.println("Adding new user");
        try {
            Users user = new Users();
            user.setUserName(username);
            String hashedPassword = PasswordStorage.createHash(password);

            user.setPassword(hashedPassword);
            user.setRoles("User");

            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
    }

}
