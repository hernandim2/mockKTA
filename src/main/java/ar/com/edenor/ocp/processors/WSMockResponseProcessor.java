package ar.com.edenor.ocp.processors;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

@Slf4j
public class WSMockResponseProcessor implements Processor {
	

	@Override
	public void process(Exchange exchange)  {
		log.info("DebugProcessor zzzzzzzzzzzzzzzzzzz ");
/*
		javax.xml.ws.Holder<com.oracle.existepp.EXISTEPP> holder = exchange.getIn().getBody(javax.xml.ws.Holder.class);


		if (holder.value.getCuenta().equals("0612046184")) {
			holder.value.setExistePPActivo("false");
		} else if (holder.value.getCuenta().equals("0051000000")) {
			holder.value.setExistePPActivo("true");
		} else if (holder.value.getCuenta().equals("0781478642")) {
            holder.value.setExistePPActivo("false");
        }else if (holder.value.getCuenta().equals("061204618")) {
		    holder.value.setMensajeDeError("La cuenta {061204618} es inexistente en CC&amp;B");
        }else if (holder.value.getCuenta().equals("0612046184")) {
            holder.value.setExistePPActivo("true");
        }
*/


	}

}
