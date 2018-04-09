package com.nab.nlinkweb.components;

import com.nab.nlinkweb.domain.domainmapper.ConversionRateMapper;
import nlink.wsdl.domain.ConversionRate;
import nlink.wsdl.domain.ConversionRateResponse;
import nlink.wsdl.domain.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

@Component
public class NlinkSoapConsumer extends WebServiceGatewaySupport {

    @Autowired
    public NlinkSoapConsumer(Jaxb2Marshaller marshaller) {
        this.setDefaultUri("http://www.webservicex.com/stockquote.asmx");
        this.setMarshaller(marshaller);
        this.setUnmarshaller(marshaller);
    }

    public com.nab.nlinkweb.domain.restdomain.ConversionRate getConversionRate() {
        ConversionRate request = new ConversionRate();
        request.setFromCurrency(Currency.AED);
        request.setToCurrency(Currency.USD);


        /*ConversionRateResponse response = (ConversionRateResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://www.webservicex.com/stockquote.asmx",
                        request,
                        new SoapActionCallback("http://www.webserviceX.NET/GetQuote"));*/

        ConversionRateResponse response = new ConversionRateResponse();
        response.setConversionRateResult(Double.MAX_VALUE);

        return ConversionRateMapper.convert(response);

    }

}
