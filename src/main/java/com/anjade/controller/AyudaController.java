package com.anjade.controller;

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

import com.anjade.entity.AyudaDto;
import com.anjade.service.AyudaService;

@RestController
@RequestMapping("/api/v1/ayudas")
public class AyudaController {

    @Autowired
    private AyudaService ayudaService;

    @PostMapping
    public ResponseEntity<AyudaDto> createAyuda(@RequestBody AyudaDto ayuda) {
        return ResponseEntity.ok(ayudaService.saveAyuda(ayuda));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AyudaDto> getAyuda(@PathVariable Long id) {
    	AyudaDto ayuda = ayudaService.getAyudaById(id);
        return ayuda != null ? ResponseEntity.ok(ayuda) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<AyudaDto>> getAllAyudas() {
        return ResponseEntity.ok(ayudaService.getAllAyudas());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AyudaDto> updateAyuda(@PathVariable Long id, @RequestBody AyudaDto ayuda) {
    	AyudaDto updatedAyuda = ayudaService.updateAyuda(id, ayuda);
        return updatedAyuda != null ? ResponseEntity.ok(updatedAyuda) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAyuda(@PathVariable Long id) {
        ayudaService.deleteAyuda(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/modulo/{modulo}")
    public ResponseEntity<List<AyudaDto>> getAyudasByModulo(@PathVariable String modulo) {
        List<AyudaDto> ayudas = ayudaService.getAyudasByModulo(modulo);
        return ayudas.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(ayudas);
    }
}