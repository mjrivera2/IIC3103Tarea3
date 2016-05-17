/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integracion.paisesaeropuertos;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import net.webservicex.Airport;
import net.webservicex.AirportSoap;
import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;

/**
 *
 * @author jesu
 */
@WebService(serviceName = "PaisesAeropuertos")
public class PaisesAeropuertos {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "obtenerPaisesAeropuertos")
    public String[] obtenerPaisesAeropuertos(@WebParam(name = "pais") String pais) {
        String[] result = new String[2];
        GlobalWeather gw = new GlobalWeather();
        GlobalWeatherSoap gwSoap = gw.getGlobalWeatherSoap();
        Airport a = new Airport();
        AirportSoap aSoap = a.getAirportSoap();
        result[0] = gwSoap.getCitiesByCountry(pais);
        result[1] = aSoap.getAirportInformationByCountry(pais);
         
        return result;
    }
}
