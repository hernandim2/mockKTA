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

		MockKTARequestParamDTO mockKTARequestParamDTO = exchange.getIn().getBody(MockKTARequestParamDTO.class);

		/*mockKTARequestParamDTO.getEstado();
		String jobId = mockKTARequestParamDTO.getJobid();*/
		MockKTARequestResponseDTO mockKTARequestResponseDTO = new MockKTARequestResponseDTO();
		String jobid = mockKTARequestParamDTO.getJobInitialization().getInputVariablesArray().get(0).getValue();
	/*	if(jobId.equals("9611767697"))
		{*/

		//C9FA778AB15341088D3869F6551DFC51 //Valido 8531229767

		//83637892D377488A967708C3D671D338// no valido 8539577182
		int statusCode = 500;
		if(!jobid.equals("83637892D377488A967708C3D671D338"))
		{
			statusCode=200;
		}
		mockKTARequestResponseDTO.setCuenta(jobid);
		mockKTARequestResponseDTO.setStatusCode(statusCode);
		exchange.getOut().setHeader(Exchange.HTTP_RESPONSE_CODE, statusCode);
		exchange.getOut().setHeader(Exchange.CONTENT_TYPE, "application/json");
		exchange.getOut().setBody(mockKTARequestResponseDTO);
		//}

		//exchange.getOut().setBody(exchange.getIn().getBody());
		//exchange.setProperty("HTTP_CODE","200");

		//exchange.getOut().setHeaders((Map)exchange.getProperty("REST_HEADERS"));
	}


}
