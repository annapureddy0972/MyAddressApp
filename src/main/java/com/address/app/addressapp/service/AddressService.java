package com.address.app.addressapp.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class AddressService {

    private List<Address> addressList;

    @PostConstruct
    public void loadAddresses(){

        addressList = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();

        TypeReference<List<Address>> addressReference = new TypeReference<List<Address>>(){};
        List<String> validCountryList = Arrays.asList("USA","NED","CAN","MEX");
        try{
            List<Address> fullList = mapper.readValue(new ClassPathResource("addresses.json").getFile(),addressReference);
            for (Address adr :fullList) {
                if(validCountryList.contains(adr.getCountryCode())){
                    addressList.add(adr);
                }
            }
        } catch (IOException e){
            System.out.println("Unable to load addresses:" + e.getMessage());
        }
    }

    public Address getRandomAddress(){
        if(addressList.isEmpty()){
            return null;
        }
        return addressList.get(new Random().nextInt(addressList.size()));
    }

}
