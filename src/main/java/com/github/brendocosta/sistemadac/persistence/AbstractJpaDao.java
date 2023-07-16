package com.github.brendocosta.sistemadac.persistence;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public abstract class AbstractJpaDao {
    
    protected EntityManagerFactory emFactory;
    
    public AbstractJpaDao() {
        
        this.emFactory = Persistence.createEntityManagerFactory("io.github.brendocosta.postgres_sistemadac");
        
    }
    
}
