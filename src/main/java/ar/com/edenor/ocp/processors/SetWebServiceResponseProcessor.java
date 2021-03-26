package ar.com.edenor.ocp.processors;

import ar.com.edenor.ocp.api.MockKTARequestParamDTO;
import ar.com.edenor.ocp.api.MockKTARequestResponseDTO;
import ar.com.edenor.ocp.mapper.MockKTARequestResponseMapper;
import ar.com.edenor.ocp.model.MockKTADTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;



@Slf4j
public class SetWebServiceResponseProcessor extends BaseProcessor {

	@Autowired
	private MockKTARequestResponseMapper mockKTARequestResponseMapper;


	@Override
	public void process(Exchange exchange)  {

		MockKTARequestParamDTO mockKTARequestParamDTO =(MockKTARequestParamDTO)exchange.getIn().getBody();
		mockKTARequestParamDTO.getEstado();
		String jobId = mockKTARequestParamDTO.getJobid();
		MockKTARequestResponseDTO mockKTARequestResponseDTO = new MockKTARequestResponseDTO();

	/*	if(jobId.equals("9611767697"))
		{*/
			mockKTARequestResponseDTO.setCuenta("9611767697");
			mockKTARequestResponseDTO.setStatusCode("500");
			//exchange.getOut().setHeader(Exchange.HTTP_RESPONSE_CODE, 500);
			exchange.getOut().setBody(mockKTARequestResponseDTO);
		//}

		//exchange.getOut().setBody(exchange.getIn().getBody());
		//exchange.setProperty("HTTP_CODE","200");

		//exchange.getOut().setHeaders((Map)exchange.getProperty("REST_HEADERS"));
	}


}
