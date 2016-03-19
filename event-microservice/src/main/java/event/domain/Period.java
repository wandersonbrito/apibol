package event.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @author Claudio E. de Oliveira on 28/02/16.
 */
@Data
public class Period {
    
    @NotEmpty
    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss.SSSZ")
    private LocalDateTime start;

    @NotEmpty
    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss.SSSZ")
    private LocalDateTime end;

    Period(){}
    
    private Period(LocalDateTime start, LocalDateTime end) {
        this.start = start;
        this.end = end;
    }

    public static Period newPeriod(LocalDateTime start,LocalDateTime end){
        return new Period(start,end);
    }

}