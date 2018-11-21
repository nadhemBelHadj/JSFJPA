package com.iset.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.iset.entities.Client;
import com.iset.util.JPAutil;


//classe contenant les méthodes génériques ajouter,  supprimer, consulter par clé primaire (Id)
public  class ClientDao {
private EntityManager entityManager=JPAutil.getEntityManager("MonProjetJPA");
 
//méthode ajouter d'une entité à  la bd
	 public   void ajouter(Object c)
	{
	 	EntityTransaction tx = entityManager.getTransaction();
	 	tx.begin();
	 	entityManager.persist(c);
	 	tx.commit();
	 	  
	}
	 
	 //méthode modifier d'une entité à  partir de la bd
	 public   void modifier(Client c)
		{
		 	EntityTransaction tx = entityManager.getTransaction();
		 	tx.begin();
		 	entityManager.merge(c);
		 	tx.commit();
		 	  
		}
	 
	 //méthode Supprimer d'une entité à  partir de la bd
	 public  void supprimer(Client c)
	{ 
		EntityTransaction tx = entityManager.getTransaction();
	    tx.begin();
	    c=entityManager.merge(c); // important
	    entityManager.remove(c);
	    tx.commit();  
	}
	 
	 //méthode Consulter d'une entité à  partir de la bd
	 public  Client Consulter(Client c,Object id)
	{
	 	return entityManager.find(c.getClass(), id);
		}
	 
	 //méthode pour lister tous les objetsà  partir de la bd
	 public List<Client> listerTous() {
		 List<Client> clients =entityManager.createQuery( "select c from Client c").getResultList();
		 return clients;
		 }
	 
	//méthode pour lister tous les objetsà  partir de la bd
		 public List<Client> listerParNom(String nom) {
			 List<Client> clients =entityManager.createQuery( "select c from Client c where c.nom like :pnom")
					 				            .setParameter("pnom", "%"+nom+"%").getResultList();
			 return clients;
			 }
	 
}
