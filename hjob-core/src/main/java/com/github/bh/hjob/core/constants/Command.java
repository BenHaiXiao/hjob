package com.github.bh.hjob.core.constants;

/**
 * @author xiaobenhai
 */
public enum Command {

    START("start"), PAUSE("pause"), END("end");

    private final String value;

    Command(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

