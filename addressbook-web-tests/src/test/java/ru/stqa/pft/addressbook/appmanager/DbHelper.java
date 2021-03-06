package ru.stqa.pft.addressbook.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.stqa.pft.addressbook.model.AddressData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.List;

/**
 * Created by Nadin_Kot on 03.08.2016.
 */
public class DbHelper {

  private final SessionFactory sessionFactory;

  public DbHelper(){
    // A SessionFactory is set up once for an application!
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
      sessionFactory= new MetadataSources( registry ).buildMetadata().buildSessionFactory();
  }

  public Groups groups(){
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<GroupData> result = session.createQuery( "from GroupData" ).list(); //OQL - object query language
    session.getTransaction().commit();
    session.close();
    return new Groups(result);
  }

  public Contacts contacts(){
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<AddressData> result = session.createQuery( "from AddressData where deprecated='0000-00-00 00:00:00'" ).list(); //OQL - object query language
    session.getTransaction().commit();
    session.close();
    return new Contacts(result);
  }

  public GroupData groupsByUniqID(int uniqID) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    GroupData result =(GroupData)session.createQuery("from GroupData where group_id=" + uniqID).uniqueResult();
    session.getTransaction().commit();
    session.close();
    return result;
  }

  public AddressData contactByUniqID(int uniqID) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    AddressData result = (AddressData)session.createQuery("from AddressData where deprecated = '0000-00-00 00:00:00' and id = " +uniqID+"").uniqueResult();
    System.out.println(result);
    session.getTransaction().commit();
    session.close();
    return result;
  }


}
