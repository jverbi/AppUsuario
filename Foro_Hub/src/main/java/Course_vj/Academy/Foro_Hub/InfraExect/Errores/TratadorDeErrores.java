package Course_vj.Academy.Foro_Hub.InfraExect.Errores;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErrores {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity error404(){

        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity error400( MethodArgumentNotValidException e){
        var errores = e.getFieldErrors().stream().map(ErrorValidation::new).toList();
        return ResponseEntity.badRequest().body(errores);
    }
    private record ErrorValidation(String campo, String error){
        public ErrorValidation(FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
