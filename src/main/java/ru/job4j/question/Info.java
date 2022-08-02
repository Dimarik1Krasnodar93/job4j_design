package ru.job4j.question;

import java.util.Objects;

public class Info {

    private int added;
    private int changed;
    private int deleted;

    public Info(int added, int changed, int deleted) {
        this.added = added;
        this.changed = changed;
        this.deleted = deleted;
    }

    @Override
    public boolean equals(Object obj) {
        return ((Info)obj).added == added
                && ((Info)obj).changed == changed
                && ((Info)obj).deleted == deleted;
    }
}