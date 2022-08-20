package ru.job4j.assertj;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;


class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void initTestNotEquals() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isNotEqualTo("S1phere1111");
    }

    @Test
    void initTestIsExist() {
        Box box = new Box(0, 10);
        assertThat(box.isExist()).isTrue();
    }

    @Test
    void getAreaVertex0() {
        Box box = new Box(8, 10);
        assertThat(box.getArea()).isEqualTo(600, withPrecision(0.01d));
    }
}