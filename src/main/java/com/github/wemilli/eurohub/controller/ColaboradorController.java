package com.github.wemilli.eurohub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.wemilli.eurohub.dto.ColaboradorRequestCreate;
import com.github.wemilli.eurohub.dto.ColaboradorRequestUpdate;
import com.github.wemilli.eurohub.dto.ColaboradorResponse;
import com.github.wemilli.eurohub.dto.IdeiaResponse;
import com.github.wemilli.eurohub.service.ColaboradorService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("colaboradores")
public class ColaboradorController {
    @Autowired
    private ColaboradorService colaboradorService;

    @PostMapping
    public ResponseEntity<ColaboradorResponse> createColaborador(@RequestBody ColaboradorRequestCreate dto) {
        return ResponseEntity.ok().body(new ColaboradorResponse().toDto(colaboradorService.createColaborador(dto)));
    }

    @PutMapping ("/{id}")
    public ResponseEntity<ColaboradorResponse> updateColaborador(@PathVariable Long id, @RequestBody ColaboradorRequestUpdate dto) {
        return colaboradorService.updateColaborador(id, dto)
        .map(c -> new ColaboradorResponse().toDto(c))
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deleteColaborador(@PathVariable Long id) {
        if (colaboradorService.deleteColaborador(id)) {
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }   

    @GetMapping ("/{id}")
    public ResponseEntity<ColaboradorResponse> findColaboradorById(@PathVariable Long id) {
        return colaboradorService.getColaboradorById(id)
        .map(c -> new ColaboradorResponse().toDto(c))
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ColaboradorResponse>> getAll() {
        List<ColaboradorResponse> lista = colaboradorService.getAll().stream()
        .map(colaborador -> new ColaboradorResponse().toDto(colaborador)).toList();

        return ResponseEntity.ok().body(lista);
    }  

    @GetMapping ("/{id}/ideias")
    public ResponseEntity<List<IdeiaResponse>> getIdeiasPorColaborador (@PathVariable Long id) {
        List<IdeiaResponse> lista = colaboradorService.getIdeiasPorColaborador(id).stream()
        .map(i -> new IdeiaResponse().toDto(i)).toList();

        return ResponseEntity.ok().body(lista);
    }
}
