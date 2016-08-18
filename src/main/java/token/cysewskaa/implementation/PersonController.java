package token.cysewskaa.implementation;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import token.cysewskaa.crudInterfaces.DataToOrderDTO;
import token.cysewskaa.crudInterfaces.OrderDTO;
import token.cysewskaa.entities.AddressEntity;
import token.cysewskaa.entities.PersonEntity;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sun.xml.internal.ws.api.message.Packet.Status.Response;

/**
 * Created by izodorczyka on 2016-08-01.
 */
@RestController
public class PersonController {



    @Autowired
    PersonRepo personRepo;

    private String message = "Hello World";

    @Autowired
    DataToOrderDTO dataToOrderDTO;

    @RequestMapping(value = "/a", method = RequestMethod.GET)
    public String test(ModelAndView modelAndView) {
        return "login";
    }

@Autowired
PersonEntityImpl personEntityImpl;
    final static Logger logger = Logger.getLogger(PersonController.class);



    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ModelAndView hello() {
        return new ModelAndView("hello").addObject("name", "Yashwant");
    }

    @RequestMapping(value = "/person", method = RequestMethod.GET )
    List<PersonEntity> personsGET(){

       logger.info("POLICZONE " +  personRepo.count());
        return personRepo.getAllPerson();
    }

    @RequestMapping(value = "/person/{personId}", method = RequestMethod.GET)
    PersonEntity personByIdGET(@PathVariable("personId") long personId){
        return personRepo.getPersonById(personId);

    }

    @RequestMapping(value = "/redirect", method = RequestMethod.GET)
    public String method(HttpServletResponse httpServletResponse) {
        return "login";
    }

  /*  @GetMapping("/")
    public String welcome() {

        return "login";
    }


*/




    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/person", method = RequestMethod.POST, consumes = "application/json")
    void personSET(@Valid @RequestBody PersonEntity data)
    {
personRepo.save(data);
      //  personEntityImpl.setPerson(data);
    }

    @RequestMapping(value = "/person/{personId}", method = RequestMethod.PUT, consumes = "application/json")
    void personPUT(@Valid @RequestBody PersonEntity data, @PathVariable("personId") long personId){

        personEntityImpl.updatePerson(data,personId);
    }
    @RequestMapping(value = "address/{addressID}", method = RequestMethod.PUT, consumes = "application/json")
    void addressPut(@Valid @RequestBody AddressEntity data, @PathVariable("addressID") long addressID){
        PersonEntity one = personRepo.findOne(addressID);
        one.getId();

        personRepo.updateAddress(addressID, data);
    }

    @RequestMapping(value = "/person/{personId}", method = RequestMethod.DELETE)
    void personDELETE(@PathVariable("personId") long personId){
        personRepo.deletePersonById(personId);

    }

    @RequestMapping(value = "/dto/{dtoID}", method = RequestMethod.GET )
    OrderDTO getDTO(@PathVariable("dtoID") long dtoID){
        return   dataToOrderDTO.setFirstName(dtoID);
    }

    @Autowired
    AddressEntityImpl addressDaoImpl;

    @RequestMapping(value = "/person/{personId}/address", method = RequestMethod.GET )
    List<PersonEntity> addressesGET(@PathVariable("personId") long personId){
        return addressDaoImpl.getAddressList(personId);

    }

  /*  @RequestMapping(value = "/person/{personId}/address/{addressId}", method = RequestMethod.GET)
    AddressEntity addressByIdGET(@PathVariable("personId") long personId, @PathVariable("addressId") long addressId){
        return addressDaoImpl.getAddressById(personId, addressId);
    }*/
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/person/{personId}/address", method = RequestMethod.POST, consumes = "application/json")
    void addressSET(@RequestBody AddressEntity data, @PathVariable("personId") long personId){
        addressDaoImpl.setAddress(data,personId);
    }

    @RequestMapping(value = "/person/{personId}/address/{addressId}", method = RequestMethod.PUT, consumes = "application/json")
    void addressPUT(@RequestBody AddressEntity data, @PathVariable("personId") long personId, @PathVariable("addressId") long addressId){
        addressDaoImpl.updateAddress(data,personId,addressId);
    }

    @RequestMapping(value = "/person/{personId}/address/{addressId}", method = RequestMethod.DELETE)
    void addressDELETE(@PathVariable("personId") long personId,@PathVariable("addressId") long addressId){
        addressDaoImpl.deleteAddress(personId,addressId);
    }


}
