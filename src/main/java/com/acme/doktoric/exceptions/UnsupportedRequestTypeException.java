package com.acme.doktoric.exceptions;

import com.acme.doktoric.types.enums.Category;

public class UnsupportedRequestTypeException extends Exception {

    public UnsupportedRequestTypeException(Category category) {
        super("Unsupported type in request :" + category);
    }
}
