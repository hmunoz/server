import net.mzouabi.ng2.server.ServerApplication;
import net.mzouabi.ng2.server.dto.PersonDTO;
import net.mzouabi.ng2.server.mapper.PersonMapper;
import net.mzouabi.ng2.server.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServerApplication.class)
public class TestDto {


    @Autowired
    PersonMapper personMapper;

    @Test
    public void test() {

        //given
        Person paerson = new Person("Horacio", "Munoz", 36);

        //when
        PersonDTO paersonDto = personMapper.toDTO(paerson);

        //then

        assertThat(paersonDto).isNotNull();
        assertThat(paersonDto.getFirstname()).isEqualTo("Horacio");
        //assertThat(paersonDto.getDateOfBirth()).isEqualTo();

    }

}