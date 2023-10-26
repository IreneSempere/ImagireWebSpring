package com.irene_sempere.hibernate.spring;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

/**
 * 
 * Esta es la clase que usaremos para acceder a los datos de las entidades User.
 * Al estar anotada con el estereotipo @Repository, será localizada rapidamente,
 * y usada para tal fin.
 * 
 * Al tener definido un motor de transacciones en DatabaseConfig, toda clase
 * anotada con @Transactional provocará que se invoquen los método begin()
 * y commit() de forma "mágica" en el inicio y el fin del método.
 * 
 * 
 */
@Repository
@Transactional
public class ClientesDao {	
	
	// A través de la anotación @PersistenceContext, se inyectará automáticamente
	// un EntityManager producido desde el entityManagerFactory definido en la clase
	// DatabaseConfig.
	
	@PersistenceContext
	private EntityManager entityManager;
	
	/**
	 * Almacena el usuario en la base de datos
	 */
	public void create(Clientes cliente) {
		entityManager.persist(cliente);
	}
	
	/**
	 * Elimina el usuario de la base de datos.
	 */
	public void delete(Clientes cliente) {
		if (entityManager.contains(cliente)) {
			entityManager.remove(cliente);
		}else {
			entityManager.remove(entityManager.merge(cliente));
		}
	}
	
	/**
	 * Actualiza el usuario proporcionado
	 */
	public void update(Clientes cliente) {
		entityManager.merge(cliente);
	}
	
	/**
	 * Devuelve un usuario en base a su Id
	 */
	public Clientes getById(int id) {
		return entityManager.find(Clientes.class, id);
	}
	
	/**
	 * Devuelve todos los usuarios de la base de datos.
	 */
	@SuppressWarnings("unchecked")
	public List<Clientes> getAll(){
		return entityManager.createQuery("from Clientes").getResultList();
	}
}
