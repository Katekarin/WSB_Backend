package mapper;

import pl.wsb.to.PatientTo;
import pl.wsb.to.VisitTo;
import com.medi.model.Visit;
import java.util.stream.Collectors;
import java.util.List;
import com.medi.model.Doctor;

public class VisitMapper {

    public static VisitTo toTO(Visit entity) {
        VisitTo to = new VisitTo();
        to.setDate(entity.getDate());

        if (entity.getDoctor() != null) {
            to.setDoctorFirstName(entity.getDoctor().getFirstName());
            to.setDoctorLastName(entity.getDoctor().getLastName());
        }

        List<String> treatments = entity.getTreatments().stream()
                .map(t -> t.getName())
                .collect(Collectors.toList());

        to.setTreatmentTypes(treatments);
        return to;
    }
}
