package com.tools.crm.exception;

import com.tools.crm.common.exception.BaseRuntimeException;
import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends BaseRuntimeException {
    public ResourceNotFoundException(Long id) {
        super("Resource with " + id + " not found", HttpStatus.NOT_FOUND);
    }
}
