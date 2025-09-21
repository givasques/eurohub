package com.github.wemilli.eurohub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.wemilli.eurohub.dto.DesafioRequestCreate;
import com.github.wemilli.eurohub.dto.DesafioRequestUpdate;
import com.github.wemilli.eurohub.dto.DesafioResponse;
import com.github.wemilli.eurohub.dto.IdeiaResponse;
import com.github.wemilli.eurohub.service.DesafioService;

@RestController
@RequestMapping ("desafios")
public class DesafioController {
    @Autowired
    private DesafioService desafioService;

    @PostMapping
    public ResponseEntity<DesafioResponse> createDesafio(@RequestBody DesafioRequestCreate dto) {
        return ResponseEntity.ok().body(new DesafioResponse().toDto(desafioService.createDesafio(dto)));
    }

    @PutMapping ("/{id}")
    public ResponseEntity<DesafioResponse> updateDesafio(@PathVariable Long id, @RequestBody DesafioRequestUpdate dto) {
        return desafioService.updateDesafio(id, dto)
        .map(d -> new DesafioResponse().toDto(d))
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deleteDesafio(@PathVariable Long id) {
        if (desafioService.deleteDesafio(id)) {
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
        
    @GetMapping ("/{id}")
    public ResponseEntity<DesafioResponse> findDesafioById(@PathVariable Long id) {
        return desafioService.getDesafioById(id)
        .map(d -> new DesafioResponse().toDto(d))
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<DesafioResponse>> getAll() {
        List<DesafioResponse> lista = desafioService.getAll().stream()
        .map(d -> new DesafioResponse().toDto(d)).toList();

        return ResponseEntity.ok().body(lista);
    }  
    
    @GetMapping ("/{id}/ideias")
    public ResponseEntity<List<IdeiaResponse>> getIdeiasPorDesafio (@PathVariable Long id) {
        List<IdeiaResponse> lista = desafioService.getIdeiasPorDesafio(id).stream()
        .map(i -> new IdeiaResponse().toDto(i)).toList();

        return ResponseEntity.ok().body(lista);
    }
}
