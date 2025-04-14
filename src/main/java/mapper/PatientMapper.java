package mapper;

import pl.wsb.to.PatientTo;
import pl.wsb.to.VisitTo;
import com.medi.model.Patient; // zakładam, że encje masz w pakiecie model
import mapper.VisitMapper;

import java.util.List;
import java.util.stream.Collectors;

public class PatientMapper {
    public static PatientTo toTO(Patient entity) {
        PatientTo to = new PatientTo();
        to.setId(entity.getId());
        to.setFirstName(entity.getFirstName());
        to.setLastName(entity.getLastName());
        to.setBirthDate(entity.getBirthDate());

        // Przykład dodatkowego pola innego niż String (np. boolean isInsured)
        to.setInsured(entity.isInsured());

        List<VisitTO> visits = entity.getVisits().stream()
                .map(VisitMapper::toTO)
                .collect(Collectors.toList());
        to.setVisits(visits);

        return to;
    }

    public static Patient fromTO(PatientTO to) {
        Patient entity = new Patient();
        entity.setId(to.getId());
        entity.setFirstName(to.getFirstName());
        entity.setLastName(to.getLastName());
        entity.setBirthDate(to.getBirthDate());

        // Dodatkowe pole
        entity.setInsured(to.isInsured());

        // UWAGA: zazwyczaj wizyty nie są odwzorowywane tutaj, tylko przy osobnym mapowaniu!
        return entity;
    }
}

