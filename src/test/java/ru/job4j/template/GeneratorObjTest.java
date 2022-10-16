package ru.job4j.template;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class GeneratorObjTest {

    @Test
    void produce() {
        String template = "I am a ${name}, Who are ${subject}? ";
        String expected = "I am a Petr Arsentev, Who are you? ";
        GeneratorObj generatorobj = new GeneratorObj();
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr Arsentev");
        map.put("subject", "you");
        assertThat(generatorobj.produce(template, map)).isEqualTo(expected);
    }

    @Test
    void produceException() {
        String template = "I am a ${name}, Who are ${subject}? ";
        String expected = "I am a Petr Arsentev, Who are you? ";
        GeneratorObj generatorobj = new GeneratorObj();
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr Arsentev");
        map.put("subject2", "you");
        assertThatThrownBy(() ->generatorobj.produce(template, map))
                .isInstanceOf(IllegalArgumentException.class);
    }
}