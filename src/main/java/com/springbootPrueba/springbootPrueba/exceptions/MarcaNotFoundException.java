package com.springbootPrueba.springbootPrueba.exceptions;

import javassist.NotFoundException;

public class MarcaNotFoundException extends NotFoundException {
    public MarcaNotFoundException(String msg) {
        super(msg);
    }

    public MarcaNotFoundException(String msg, Exception e) {
        super(msg, e);
    }
}
