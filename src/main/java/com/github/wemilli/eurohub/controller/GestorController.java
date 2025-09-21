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

import com.github.wemilli.eurohub.dto.DesafioResponse;
import com.github.wemilli.eurohub.dto.GestorRequestCreate;
import com.github.wemilli.eurohub.dto.GestorRequestUpdate;
import com.github.wemilli.eurohub.dto.GestorResponse;
import com.github.wemilli.eurohub.service.GestorService;

@RestController
@RequestMapping ("gestores")
public class GestorController {
    @Autowired
    private GestorService gestorService;

    @PostMapping
    public ResponseEntity<GestorResponse> createGestor(@RequestBody GestorRequestCreate dto) {
        return ResponseEntity.ok().body(new GestorResponse().toDto(gestorService.createGestor(dto)));
    }

    @PutMapping ("/{id}")
    public ResponseEntity<GestorResponse> updateGestor(@PathVariable Long id, @RequestBody GestorRequestUpdate dto) {
        return gestorService.updateGestor(id, dto)
        .map(g -> new GestorResponse().toDto(g))
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deleteGestor(@PathVariable Long id) {
        if (gestorService.deleteGestor(id)) {
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }   

    @GetMapping ("/{id}")
    public ResponseEntity<GestorResponse> findGestorById(@PathVariable Long id) {
        return gestorService.getGestorById(id)
        .map(g -> new GestorResponse().toDto(g))
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<GestorResponse>> getAll() {
        List<GestorResponse> lista = gestorService.getAll().stream()
        .map(g -> new GestorResponse().toDto(g)).toList();

        return ResponseEntity.ok().body(lista);
    }  

    @GetMapping ("/{id}/desafios")
    public ResponseEntity<List<DesafioResponse>> getDesafiosPorGestor (@PathVariable Long id) {
        List<DesafioResponse> lista = gestorService.getDesafiosPorGestor(id).stream()
        .map(i -> new DesafioResponse().toDto(i)).toList();

        return ResponseEntity.ok().body(lista);
    }
}
