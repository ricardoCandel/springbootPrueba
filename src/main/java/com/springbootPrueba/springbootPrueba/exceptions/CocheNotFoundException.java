package com.springbootPrueba.springbootPrueba.exceptions;

import javassist.NotFoundException;

public class CocheNotFoundException extends NotFoundException {
    public CocheNotFoundException(String msg) {
        super(msg);
    }

    public CocheNotFoundException(String msg, Exception e) {
        super(msg, e);
    }
}
