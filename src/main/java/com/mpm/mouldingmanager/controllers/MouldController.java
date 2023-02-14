package com.mpm.mouldingmanager.controllers;

import com.mpm.mouldingmanager.entities.Mould;
import com.mpm.mouldingmanager.repositories.MouldRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MouldController {

    private final MouldRepository mouldRepository;

    public MouldController(MouldRepository mouldRepository) {
        this.mouldRepository = mouldRepository;
    }

    // CREATE

    /**
     * Crea y añade un molde a la base de datos.
     * @param mould
     * @param headers
     * @return
     */
    @PostMapping("/api/moldes")
    public ResponseEntity<Mould> addMould(@RequestBody Mould mould, @RequestHeader HttpHeaders headers) {
        if (mould.getId() == null) {
            return ResponseEntity.badRequest().build();
        }

        Mould result = mouldRepository.save(mould);
        return ResponseEntity.ok(result);
    }

    // Read

    /**
     * Muestra la lista de moldes que hay guardados en la base de datos.
     * Enlace directo: <a href="http://localhost:8080/api/moldes">localhost:8080/api/moldes</a>
     * @return
     */
    @GetMapping("/api/moldes")
    public List<Mould> searchAll() {
        return mouldRepository.findAll();
    }

    /**
     * Busca un molde en concreto mediante su id en la base de datos.
     * Si no encuentra el id indicado devuelve BAD REQUEST.
     * @param id
     * @return
     */
    @GetMapping("/api/moldes/{id}")
    public Mould searchMouldById(@PathVariable Long id) {
        Optional<Mould> optionalMould = mouldRepository.findById(id);
        return optionalMould.orElse((Mould) ResponseEntity.badRequest());
    }

    @GetMapping("/api/moldes/{client}")
    public List<Mould> searchByClient(String client) {
        return null;
    }

    @GetMapping("/api/moldes/{name}")
    public Mould searchByName(String name) {
        return null;
    }

    @GetMapping("/api/moldes/{num}")
    public Mould searchByNum(Integer num) {
        return null;
    }

    @GetMapping("/api/moldes/{medidaPiston}")
    public List<Mould> searchByPiston(Integer pistonSize) {
        return null;
    }

    // UPDATE

    /**
     * Actualiza los parámetro de un molde ya existente.
     * En caso de no insertar el id correspondiente obtendremos una respuesta badRequest, si el id no existe,
     * obtendremos una respuesta notFound.
     * @param mould
     * @return
     */
    @PutMapping("/api/moldes")
    public ResponseEntity<Mould> updateMould(@RequestBody Mould mould) {
        if (mould.getId() == null) {
            return ResponseEntity.badRequest().build();
        }
        if (!mouldRepository.existsById(mould.getId())) {
            return ResponseEntity.notFound().build();
        }

        Mould mouldaccepted = mouldRepository.save(mould);
        return ResponseEntity.ok(mouldaccepted);
    }

    // Delete

    /**
     * Borra un molde insertando su id correspondiente.
     * @param id
     * @return
     */
    @DeleteMapping("/api/moldes/{id}")
    public ResponseEntity<Mould> deleteMouldById(@PathVariable Long id) {
        if (!mouldRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        mouldRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Borra todos los moldes de la base de datos.
     * @return
     */
    @DeleteMapping("/api/moldes")
    public ResponseEntity<Mould> deleteAll() {
        mouldRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
