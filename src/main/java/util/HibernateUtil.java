package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        // Création du registre de services standard
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // Charge la configuration à partir de hibernate.cfg.xml
                .build();

        try {
            // Création de la session factory à partir du registre
            return new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception ex) {
            // Destruction du registre en cas d'erreur
            StandardServiceRegistryBuilder.destroy(registry);
            throw new ExceptionInInitializerError("Erreur lors de la création de la SessionFactory : " + ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Fermeture de la session factory lors de l'arrêt de l'application
        getSessionFactory().close();
    }
}
