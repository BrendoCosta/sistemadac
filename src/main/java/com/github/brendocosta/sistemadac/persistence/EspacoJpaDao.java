package com.github.brendocosta.sistemadac.persistence;

import com.github.brendocosta.sistemadac.entity.Espaco;
import com.github.brendocosta.sistemadac.dao.IEspacoDao;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class EspacoJpaDao extends AbstractJpaDao implements IEspacoDao {
    
    @Override
    public void atualizar(Espaco e) {
    
        EntityManager em = this.emFactory.createEntityManager();
        
            EntityTransaction transaction = em.getTransaction();
            
            transaction.begin();
                
                em.merge(e);
            
            transaction.commit();
            
        em.close();
    
    }
    
    @Override
    public void salvar(Espaco e) {
        
        EntityManager em = this.emFactory.createEntityManager();
        
            EntityTransaction transaction = em.getTransaction();
            
            transaction.begin();
                
                em.persist(e);
            
            transaction.commit();
            
        em.close();
        
    }
    
    @Override
    public void remover(long id) {
        
        EntityManager em = this.emFactory.createEntityManager();
            
            EntityTransaction transaction = em.getTransaction();
            
            transaction.begin();
                
                Espaco e = em.find(Espaco.class, id);
                
                if (e != null) {
                    
                    em.remove(e);
                    
                }
                
            transaction.commit();
            
        em.close();
        
    }
    
    @Override
    public Espaco buscarPorId(long id) {
        
        EntityManager em = this.emFactory.createEntityManager();
        
            Espaco e = em.find(Espaco.class, id);
        
        em.close();
        
        return e;
        
    }
    
    public List<Espaco> buscarTodos() {
        
        String queryStr = "SELECT e FROM Espaco e";
        
        EntityManager em = this.emFactory.createEntityManager();
            
            Query query = em.createQuery(queryStr);
            List<Espaco> e = query.getResultList();
            
        em.close();
        
        return e;
        
    }
    
}
