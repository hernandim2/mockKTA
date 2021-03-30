package ar.com.edenor.ocp.processors;

import ar.com.edenor.ocp.api.MockKTARequestParamDTO;
import ar.com.edenor.ocp.mapper.MockKTARequestParamMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;

import static ar.com.edenor.ocp.util.Constants.WS_MOCK_KTA_OPERATION_NAME;

@Slf4j
public class SetWebServiceParameterProcessor extends BaseProcessor {

	@Autowired
	private MockKTARequestParamMapper existePPRequestParamMapper;


	@Override
	public void process(Exchange exchange)  {

		MockKTARequestParamDTO mockKTARequestParamDTO = new MockKTARequestParamDTO();
		/*mockKTARequestParamDTO.setEstado("1919");
		mockKTARequestParamDTO.setJobid("asdf");*/
		exchange.getOut().setBody(mockKTARequestParamDTO);
		//exchange.getOut().setHeader("operationName",WS_MOCK_KTA_OPERATION_NAME);
		//MockKTARequestParamDTO mockKTARequestParamDTO = (MockKTARequestParamDTO)exchange.getIn().getBody();
		//EXISTEPP existepp = existePPRequestParamMapper.toDomain(existePPRequestParamDTO);
		//exchange.getOut().setBody(mockKTARequestParamDTO);
	}

}
