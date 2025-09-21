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

import com.github.wemilli.eurohub.dto.IdeiaRequestCreate;
import com.github.wemilli.eurohub.dto.IdeiaRequestUpdate;
import com.github.wemilli.eurohub.dto.IdeiaResponse;
import com.github.wemilli.eurohub.service.IdeiaService;

@RestController
@RequestMapping ("ideias")
public class IdeiaController {
    @Autowired
    private IdeiaService ideiaService;

    @PostMapping
    public ResponseEntity<IdeiaResponse> createIdeia(@RequestBody IdeiaRequestCreate dto) {
        return ResponseEntity.ok().body(new IdeiaResponse().toDto(ideiaService.createIdeia(dto)));
    }

    @PutMapping ("/{id}")
    public ResponseEntity<IdeiaResponse> updateIdeia(@PathVariable Long id, @RequestBody IdeiaRequestUpdate dto) {
        return ideiaService.updateIdeia(id, dto)
        .map(i -> new IdeiaResponse().toDto(i))
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deleteIdeia (@PathVariable Long id) {
        if (ideiaService.deleteIdeia(id)) {
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
        
    @GetMapping ("/{id}")
    public ResponseEntity<IdeiaResponse> findIdeiaById(@PathVariable Long id) {
        return ideiaService.getIdeiaById(id)
        .map(i -> new IdeiaResponse().toDto(i))
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<IdeiaResponse>> getAll() {
        List<IdeiaResponse> lista = ideiaService.getAll().stream()
        .map(i -> new IdeiaResponse().toDto(i)).toList();

        return ResponseEntity.ok().body(lista);
    }  
}
