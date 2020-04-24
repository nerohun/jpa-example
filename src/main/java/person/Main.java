package person;


import com.github.javafaker.Faker;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Main {

    public static Person randomPerson(){
        Faker faker = new Faker();
        Person person = new Person();



            Date date = faker.date().birthday();
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            person.setName(faker.name().fullName());
            person.setDob(localDate);
            person.setGender(faker.options().option(Person.Gender.class));
            person.setAddress(
                    new Address(
                            faker.address().country(),
                            faker.address().state(),
                            faker.address().city(),
                            faker.address().streetAddress(),
                            faker.address().zipCode()
                    ));
            person.setEmail(faker.internet().emailAddress());
            person.setProfession(faker.company().profession());



            return person;
        }




    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-example");
        EntityManager em = emf.createEntityManager();

        for (int i =1;i<=10;i++) {
            Person user = randomPerson();
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
            System.out.println(user);
        }
        em.close();
        emf.close();


    }



}
