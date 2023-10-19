package com.REST_API.streamsschedule.repository;

import com.REST_API.streamsschedule.model.LiveStream;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Repository
public class LiveStreamRepository {
    List<LiveStream> streams = new ArrayList<>();

    public LiveStreamRepository() {
        streams.add(new LiveStream(
                UUID.randomUUID().toString(),
                "How to Make a 3D Model on Blender?",
                "Blender 3D is a free, open-source computer graphics program used to create 3D models and effects for animated videos, computer art, video games, and applications. Blender 3D's interface may seem complicated at first, but you'll get used to it pretty quickly. Soon you will find yourself easily making any object you want. Just watch our stream!",
                "https://www.stream.tv/computer_graphics",
                LocalDateTime.of(2023, 11, 4, 11, 0),
                LocalDateTime.of(2023, 11, 4, 12, 30)

        ));

        streams.add(new LiveStream(
                UUID.randomUUID().toString(),
                "The BIG 5 AI problems",
                " Ethical issues facing AI systems everywhere! Just watch our stream and ensure!",
                "https://www.stream.tv/AI_problems",
                LocalDateTime.of(2023, 10, 28, 14, 0),
                LocalDateTime.of(2023, 10, 28, 15, 0)

        ));

        streams.add(new LiveStream(
                UUID.randomUUID().toString(),
                "Which Programming Language Should You Choose in 2023?",
                "Over the last decade, internet usage has more than doubled to over 4.95 billion global users. The number of websites, games, and applications has steadily increased as well. These programs and platforms all started as an idea that computer programming brought to life. Whether you're interested in launching a career or simply bringing your own ideas to life, learning a programming language is step one. It can be tough to know where to start, but this stream may help guide your decision-making process.",
                "https://www.stream.tv/programming_languages",
                LocalDateTime.of(2023, 12, 16, 17, 0),
                LocalDateTime.of(2023, 12, 16, 18, 0)
        ));
    }

    public List<LiveStream> findAll() {
        return streams;
    }

    public LiveStream findById(String id) {
        return streams.stream()
                .filter(stream -> stream.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No LiveStream found with ID: " + id));
    }

    public LiveStream create(LiveStream stream) {
        streams.add(stream);
        return stream;
    }

    public void update(LiveStream stream, String id) {
        LiveStream existing_stream = streams.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No LiveStream found with ID: " + id));
        int stream_index = streams.indexOf(existing_stream);
        streams.set(stream_index, stream);
    }

    public void delete(String id) {
        streams.removeIf(stream -> stream.getId().equals(id));
    }

}
