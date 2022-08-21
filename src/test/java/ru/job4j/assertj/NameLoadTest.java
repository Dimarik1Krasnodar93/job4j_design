package ru.job4j.assertj;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

class NameLoadTest {
    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void parseVoid() {
        NameLoad nameload = new NameLoad();
        String[] strArray = {};
        assertThatThrownBy(() -> nameload.parse(strArray))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Names array is empty");
    }

    @Test
    void parseDoesdNotContaitsCorrctArg() {
        NameLoad nameload = new NameLoad();
        String[] strArray = {"dsfsd"};
        assertThatThrownBy(() -> nameload.parse(strArray))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format("this name: %s does not contain the symbol \"=\"", "dsfsd"));
    }

    @Test
    void parseDoesdNotContaitsCorrctArgLast() {
        NameLoad nameload = new NameLoad();
        String[] strArray = {"dsfsd="};
        assertThatThrownBy(() -> nameload.parse(strArray))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format("this name: %s does not contain a value", "dsfsd="));
    }

    @Test
    void parseDoesdNotContaitsCorrctArgStartsWith() {
        NameLoad nameload = new NameLoad();
        String[] strArray = {"=dsfsd"};
        assertThatThrownBy(() -> nameload.parse(strArray))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format("this name: %s does not contain a key", "=dsfsd"));
    }
}