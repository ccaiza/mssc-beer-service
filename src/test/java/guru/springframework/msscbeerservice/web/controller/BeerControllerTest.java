/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guru.springframework.msscbeerservice.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.msscbeerservice.web.model.BeerDto;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Test de la clase controller BeerController
 *
 * @author Carlos
 */
@WebMvcTest(BeerController.class)
public class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    //provee de funcionalidades para manejar json
    @Autowired
    ObjectMapper objectMapper;

    /**
     * Probamos el mmetodo get de BeerController.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testGetBeerById() throws Exception {
        System.out.println("getBeerById");
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/beer/" + UUID.randomUUID().toString())
                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
//        System.out.println("getBeerById");
//        UUID beerId = null;
//        BeerController instance = new BeerController();
//        ResponseEntity<BeerDto> expResult = null;
//        ResponseEntity<BeerDto> result = instance.getBeerById(beerId);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of saveNewBeer method, of class BeerController.
     */
    @Test
    public void testSaveNewBeer() throws Exception {
        System.out.println("saveNewBeer");
        BeerDto beerDto = BeerDto.builder().build();//construimos un objeto vacio
        String beerDtoJson = this.objectMapper.writeValueAsString(beerDto);
        System.out.println("beerDtoJson ---> " + beerDtoJson);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/beer/")
                .contentType(MediaType.APPLICATION_JSON).content(beerDtoJson))
                .andExpect(MockMvcResultMatchers.status().isCreated());
//        BeerController instance = new BeerController();
//        ResponseEntity expResult = null;
//        ResponseEntity result = instance.saveNewBeer(beerDto);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of updateBeerById method, of class BeerController.
     */
    @Test
    public void testUpdateBeerById() throws Exception {
        System.out.println("updateBeerById");
        BeerDto beerDto = BeerDto.builder().build();//construimos un objeto vacio
        String beerDtoJson = this.objectMapper.writeValueAsString(beerDto);
        System.out.println("beerDtoJson ---> " + beerDtoJson);
        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/beer/"+ UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON).content(beerDtoJson))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
//        UUID beerId = null;
//        BeerDto beerDto = null;
//        BeerController instance = new BeerController();
//        ResponseEntity expResult = null;
//        ResponseEntity result = instance.updateBeerById(beerId, beerDto);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

}
