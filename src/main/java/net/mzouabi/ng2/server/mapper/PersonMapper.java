package net.mzouabi.ng2.server.mapper;

import net.mzouabi.ng2.server.dto.PersonDTO;
import net.mzouabi.ng2.server.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * Created by mouradzouabi on 04/12/15.
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PersonMapper {

   // PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);


    public PersonDTO toDTO(Person person);

    public Person toEntity(PersonDTO person);

    public void mapToEntity(PersonDTO personDTO, @MappingTarget Person person);

}
