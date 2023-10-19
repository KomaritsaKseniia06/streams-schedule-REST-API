package com.REST_API.streamsschedule.controller;

import com.REST_API.streamsschedule.model.LiveStream;
import com.REST_API.streamsschedule.repository.LiveStreamRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/streams")
public class LiveStreamController {

    private final LiveStreamRepository liveStreamRepository;

    public LiveStreamController(LiveStreamRepository liveStreamRepository) {
        this.liveStreamRepository = liveStreamRepository;
    }

    @GetMapping
    public List<LiveStream> findAll() {
        return liveStreamRepository.findAll();
    }

    @GetMapping("/{id}")
    public LiveStream findById(@PathVariable String id) {
        return liveStreamRepository.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public LiveStream create(@RequestBody LiveStream stream) {
        return liveStreamRepository.create(stream);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody LiveStream stream, @PathVariable String id) {
        liveStreamRepository.update(stream, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        liveStreamRepository.delete(id);
    }
}
