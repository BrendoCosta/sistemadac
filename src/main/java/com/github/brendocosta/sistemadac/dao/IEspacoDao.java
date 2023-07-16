package com.github.brendocosta.sistemadac.dao;

import com.github.brendocosta.sistemadac.entity.Espaco;

import java.util.List;

public interface IEspacoDao {
    
    void atualizar(Espaco e);
    void salvar(Espaco e);
    void remover(long id);
    Espaco buscarPorId(long id);
    List<Espaco> buscarTodos();
    
}
