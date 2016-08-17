package token.cysewskaa.implementation;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import token.cysewskaa.entities.AddressEntity;


import java.util.List;

/**
 * Created by izodorczyka on 2016-08-01.
 */
@RestController
@Slf4j
public class AddressController {

    @Autowired
    AddressEntityImpl addressDaoImpl;

    @RequestMapping(value = "/person/{personId}/address", method = RequestMethod.GET )
    List<AddressEntity> addressesGET(@PathVariable("personId") long personId){
        return addressDaoImpl.getAddressList(personId);
    }

    @RequestMapping(value = "/person/{personId}/address/{addressId}", method = RequestMethod.GET)
    AddressEntity addressByIdGET(@PathVariable("personId") long personId, @PathVariable("addressId") long addressId){
        return addressDaoImpl.getAddressById(personId, addressId);
    }
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
