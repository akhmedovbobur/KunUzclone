package uz.isystem.kunuzclone.exeption;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExeption {
    @ExceptionHandler
    public ResponseEntity<?> exeption (KunUzExeption e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
