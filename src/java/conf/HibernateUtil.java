/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conf;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 *
 * @author Marcos H. Costa
 */
public class HibernateUtil {
    
    private static SessionFactory factory;
    private static ServiceRegistry serviceRegistry;
    private static Configuration conf;
    
    static{      
        conf = new Configuration();        
        conf.configure("/hibernate.cfg.xml");
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        factory = conf.buildSessionFactory(serviceRegistry);
    }
    
    public static void gerarBanco(){
        SchemaExport se =  new SchemaExport(conf);
        se.create(true, true);
    }
    
    public static Session getSession(){
        return factory.openSession();
    }        
}
