package db;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MyHibernateSessionFactory {
    private static SessionFactory sessionFactory;  //�Ự��������
    private MyHibernateSessionFactory()//  ˽�л����췽��  ������ģʽ
    {
    	
    }
    
    //һ�����еľ�̬����������ûỰ����������
    public  static SessionFactory getsessionFactory()
    {
    	if(sessionFactory==null)
    		{
           Configuration configuration=new Configuration().configure();
           ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
           sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    	}
			return sessionFactory;
    		
    }
}
