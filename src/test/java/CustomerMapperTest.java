/**
 *  Copyright 2012-2016 Gunnar Morling (http://www.gunnarmorling.de/)
 *  and/or other contributors as indicated by the @authors tag. See the
 *  copyright.txt file in the distribution for a full listing of all
 *  contributors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import net.mzouabi.ng2.server.ServerApplication;
import net.mzouabi.ng2.server.dto.CustomerDto;
import net.mzouabi.ng2.server.dto.OrderItemDto;
import net.mzouabi.ng2.server.mapper.CustomerMapper;
import net.mzouabi.ng2.server.model.Customer;
import net.mzouabi.ng2.server.model.OrderItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 *
 * @author Filip Hrisafov
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServerApplication.class)
public class CustomerMapperTest {

    @Test
    public void testMapDtoToEntity() {

        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(10L);
        customerDto.setCustomerName("Filip");
        OrderItemDto order1 = new OrderItemDto();
        order1.setId(1L);
        order1.setName("Table");
        order1.setQuantity( 2L);
        order1.setDateOrden("30/12/2016");
        customerDto.setOrders(new ArrayList<>( Collections.singleton( order1 ) ));

        Customer customer = CustomerMapper.MAPPER.toEntity( customerDto );

        assertThat( customer.getId() ).isEqualTo( 10 );
        assertThat( customer.getName() ).isEqualTo( "Filip" );
        assertThat( customer.getOrderItems() )
            .extracting( "name", "quantity" )
            .containsExactly( tuple( "Table", 2L ) );
    }

    @Test
    public void testEntityDtoToDto() {

        Customer customer = new Customer();
        customer.setId( 10L );
        customer.setName( "Filip" );
        OrderItem order1 = new OrderItem();
        order1.setName( "Table" );
        order1.setQuantity( 2L );
        order1.setDate(new Date());
        order1.setId( 1L );
        customer.setOrderItems( Collections.singleton( order1 ) );

        CustomerDto customerDto = CustomerMapper.MAPPER.toDTO( customer );

        assertThat( customerDto.getId() ).isEqualTo( 10 );
        assertThat( customerDto.getCustomerName() ).isEqualTo( "Filip" );
        assertThat( customerDto.getOrders() )
            .extracting( "name", "quantity" )
            .containsExactly( tuple( "Table", 2L ) );
    }
}
