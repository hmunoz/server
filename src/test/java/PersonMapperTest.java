import net.mzouabi.ng2.server.ServerApplication;
import net.mzouabi.ng2.server.dto.PersonDTO;
import net.mzouabi.ng2.server.mapper.PersonMapper;
import net.mzouabi.ng2.server.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServerApplication.class)
public class PersonMapperTest {


    @Autowired
    PersonMapper personMapper;

    @Test
    public void test() {

        //given
        LocalDate dateOfBitrh = LocalDate.of(1979, Month.NOVEMBER, 12);
        Person person = new Person("Horacio", "Munoz", Date.from(dateOfBitrh.atStartOfDay(ZoneId.systemDefault()).toInstant()));

        //when
        PersonDTO personDto = personMapper.toDTO(person);

        //then

        assertThat(personMapper).isNotNull();
        assertThat(personDto).isNotNull();
        assertThat(personDto.getFirstname()).isEqualTo("Horacio");
        assertThat(personDto.getAge()).isEqualTo(37);
        assertThat(personDto.getDateOfBirth()).isEqualTo("12/11/1979");

    }

}