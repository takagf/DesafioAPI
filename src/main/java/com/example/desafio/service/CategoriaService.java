package com.example.desafio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desafio.model.Categoria;
import com.example.desafio.repository.CategoriaRepository;

@Service
public class CategoriaService  {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria adicionar(Categoria categoria){

        return categoriaRepository.save(categoria);
    }

    public List<Categoria> obterTodos(){
        return categoriaRepository.findAll();
    }
    
    public Categoria obterPorId(Long id){
        Optional<Categoria> optCategoria = categoriaRepository.findById(id);

        if(optCategoria.isEmpty()){
            throw new IllegalArgumentException("Não existe um categoria com o ID " + id);
        }

        return optCategoria.get();
    }

    public Categoria atualizar(long id, Categoria categoria){

        categoria.setId(id);
        return categoriaRepository.save(categoria);
    }

    public void deletar(long id){
        categoriaRepository.deleteById(id);
    }

}
