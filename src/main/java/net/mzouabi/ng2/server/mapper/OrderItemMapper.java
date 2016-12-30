/**
 * Copyright 2012-2016 Gunnar Morling (http://www.gunnarmorling.de/)
 * and/or other contributors as indicated by the @authors tag. See the
 * copyright.txt file in the distribution for a full listing of all
 * contributors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.mzouabi.ng2.server.mapper;


import net.mzouabi.ng2.server.dto.OrderItemDto;
import net.mzouabi.ng2.server.dto.PersonDTO;
import net.mzouabi.ng2.server.model.OrderItem;
import net.mzouabi.ng2.server.model.Person;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

/**
 * @author Filip Hrisafov
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface OrderItemMapper {

   // OrderItemMapper MAPPER = Mappers.getMapper(OrderItemMapper.class);



    @Mappings({
            @Mapping(source = "date", target = "dateOrden", dateFormat = "dd/MM/yyyy"),
    })
    public OrderItemDto toDTO(OrderItem orderItem);



    @InheritInverseConfiguration
    public OrderItem toEntity(OrderItemDto orderItemDto);

    public void mapToEntity(OrderItemDto orderItemDto, @MappingTarget OrderItem orderItem);
}
