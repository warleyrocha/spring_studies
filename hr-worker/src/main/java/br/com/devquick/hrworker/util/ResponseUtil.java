package br.com.devquick.hrworker.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface ResponseUtil {

    static ResponseEntity wrapOrNotFound(Optional<?> maybeResponse) {
        return maybeResponse.map((response) -> ResponseEntity.ok().body(response)).orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }
}
