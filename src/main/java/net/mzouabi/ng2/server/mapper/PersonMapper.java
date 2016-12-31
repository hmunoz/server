package net.mzouabi.ng2.server.mapper;

import net.mzouabi.ng2.server.dto.PersonDTO;
import net.mzouabi.ng2.server.model.Person;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

/**
 * Created by mouradzouabi on 04/12/15.
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PersonMapper {


    @Mappings({
            @Mapping(source = "dateOfBirth", target = "dateOfBirth", dateFormat = "dd/MM/yyyy"),
            @Mapping(target = "age",  expression = "java(person.toAge())")
    })
    public PersonDTO toDTO(Person person);


    @InheritInverseConfiguration
    public Person toEntity(PersonDTO person);

    public void mapToEntity(PersonDTO personDTO, @MappingTarget Person person);

}
