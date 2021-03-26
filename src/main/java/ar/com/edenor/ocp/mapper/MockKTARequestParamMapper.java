package ar.com.edenor.ocp.mapper;

import ar.com.edenor.ocp.api.MockKTARequestParamDTO;
import ar.com.edenor.ocp.model.MockKTADTO;
import org.mapstruct.Mapper;

//WS_MOCK_KTA_OPERATION_NAME
@Mapper(componentModel = "spring")
public interface MockKTARequestParamMapper {
    MockKTADTO toDomain(MockKTARequestParamDTO paramDTO);
}
