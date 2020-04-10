package ua.lviv.iot.dwellingrest.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.lviv.iot.dwellingrest.model.Mansion;

@RequestMapping("/mansions")
@RestController
public class MansionsController {
    private Map<Integer, Mansion> mansions = new HashMap<Integer, Mansion>();
    private AtomicInteger idCounter = new AtomicInteger();

    @GetMapping
    public List<Mansion> getMansions() {
        return new LinkedList<Mansion>(mansions.values());
    }

    @GetMapping(path = "/{id}")
    public Mansion getMansion(final @PathVariable("id") Integer mansionId) {
        return mansions.get(mansionId);
    }

    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public Mansion c(@RequestBody Mansion mansion) {
        mansion.setId(idCounter.incrementAndGet());
        mansions.put(mansion.getId(), mansion);
        return mansion;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Mansion> deleteMansion(@PathVariable("id") Integer mansionId) {
        HttpStatus status = mansions.remove(mansionId) == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
        return ResponseEntity.status(status).build();
    }
    
    @PutMapping(path = "/{id}")
    public ResponseEntity<Mansion> updateMansion(final @PathVariable("id") Integer mansionId,
            final @RequestBody Mansion mansion) {
        mansion.setId(mansionId);
        Mansion previonsMansion = mansions.replace(mansion.getId(), mansion);
        return ResponseEntity.of(previonsMansion == null? Optional.empty() : Optional.of(previonsMansion));
    }
}
