package com.github.brendocosta.sistemadac.service;

import com.github.brendocosta.sistemadac.entity.Espaco;
import com.github.brendocosta.sistemadac.persistence.EspacoJpaDao;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ejb.Stateless;
import jakarta.ws.rs.core.Response;

@Stateless
@Path("espacos")
public class EspacosService {
    
    @GET
    @Path("/")
    @Produces({MediaType.APPLICATION_JSON})
    public Response buscarTodos() {
        
        EspacoJpaDao dao = new EspacoJpaDao();
        
        return Response.status(Response.Status.OK).entity(dao.buscarTodos()).build();
        
    }
    
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response salvar(Espaco e) {
    
        EspacoJpaDao dao = new EspacoJpaDao();
        
        if (!e.validar())
            return Response.status(Response.Status.BAD_REQUEST).build();
        
        if (dao.buscarPorId(e.getId()) != null)
            return Response.status(Response.Status.CONFLICT).build();
        
        dao.salvar(e);
        return Response.status(Response.Status.OK).build();
    
    }
    
    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizar(Espaco e) {
        
        EspacoJpaDao dao = new EspacoJpaDao();
        
        if (!e.validar())
            return Response.status(Response.Status.BAD_REQUEST).build();
        
        if (dao.buscarPorId(e.getId()) == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        
        dao.atualizar(e);
        return Response.status(Response.Status.OK).build();
    
    }
    
    @DELETE
    @Path("/{id}")
    public Response remover(@PathParam("id") long id) {
        
        EspacoJpaDao dao = new EspacoJpaDao();
       
        if (dao.buscarPorId(id) == null)
            return Response.status(Response.Status.NOT_FOUND).build();
       
        dao.remover(id); 
        return Response.status(Response.Status.OK).build();
        
    }
    
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response buscarPorId(@PathParam("id") long id) {
        
        EspacoJpaDao dao = new EspacoJpaDao();
       
        if (dao.buscarPorId(id) == null)
            return Response.status(Response.Status.NOT_FOUND).build();
       
        return Response.status(Response.Status.OK).entity(dao.buscarPorId(id)).build();
        
    }
    
}
