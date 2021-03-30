package ar.com.edenor.ocp.mapper;

import ar.com.edenor.ocp.api.MockKTARequestParamDTO;
import ar.com.edenor.ocp.api.MockKTARequestResponseDTO;
import ar.com.edenor.ocp.model.MockKTADTO;
import ar.com.edenor.ocp.model.ModelRequestKta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface MockKTARequestResponseMapper {
    MockKTARequestResponseDTO toDomainDto(ModelRequestKta modelRequestKta);
}
