package entity;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class Teststudents
{
	@Test
	public void testschemaExport()
	{
		Configuration configuration=new Configuration().configure();
        ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session=sessionFactory.getCurrentSession();
        SchemaExport export=new SchemaExport(configuration);
        export.create(true,true);
	}
	
	//��Ӳ�������
	@Test
	public void testsavestudent()
	{
		Configuration configuration=new Configuration().configure();
        ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session=sessionFactory.getCurrentSession();
        Transaction tx=session.beginTransaction();
        
        Students student1=new Students("s0000001", "zhangsan", "��", new Date(), "����");
        Students student2=new Students("s0000002", "����", "Ů", new Date(), "�Ϻ�");
        session.save(student1);
        session.save(student2);
        tx.commit();
        sessionFactory.close();
		
	}
}
