package com.proxiBanque.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.proxiBanque.dto.received.AuthDto;
import com.proxiBanque.model.Advisor;
import com.proxiBanque.model.Agency;
import com.proxiBanque.model.Person;
import com.proxiBanque.service.IAuthService;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@TestPropertySource(locations = "classpath:test.properties")
public class AuthControllerTest {

    @MockBean
    private IAuthService authService;
    @Autowired
    private MockMvc mockMvc;

    //implementé la requet HTTP methode Yann
    // @Test
    // public void  givenCorrectBody_WhenPostAuth_ThenSuccess() throws Exception {
    //     AuthDto authDto=new AuthDto( "identifiant",  "mdp");
    //     Agency agency=new Agency("city","country");
    //     Advisor advisor= new Advisor("name", "firstname", "phone", "mail", "password", agency);
    //     advisor.setId(1);
    //     Person person=advisor;
    //     Mockito.when(this.authService.authentification(Mockito.any())).thenReturn(Optional.of(person));
        
    //     ObjectMapper objectMapper= new ObjectMapper();
    //     MockHttpServletResponse response= mockMvc.perform(
    //                 post("/api/auth")
    //                 .contentType("application/json")
    //                 .content(objectMapper.writeValueAsString(authDto)));
    //     // String body=objectMapper
    //     //                 .valueToTree(authDto)
    //     //                 .toPrettyString();

    //     // MockHttpServletRequestBuilder query = MockMvcRequestBuilders
    //     //                         .post("/api/auth")
    //     //                         .contentType("application/json")
    //     //                         .content(body);

    //     // MvcResult result = mockMvc.perform(query).andReturn();
    //     // String returnedJsonStr = result.getResponse().getContentAsString();

    //     // JsonNode returnedJson = objectMapper.readTree(returnedJsonStr);

    //     String jsonStr = """
    //             {
    //                 "id" : 1,
    //                 "name" : "name",
    //                 "firstName" : "firstname",
    //                 "phone" : "phone",
    //                 "mail" : "mail"
    //             }
    //             """;
    //     JsonNode expectedJson = objectMapper.readTree(jsonStr);
    
    //     assertEquals(expectedJson, returnedJson);
    
    // }


    //implementé la requet HTTP methode Alex
    @Test
    public void  givenCorrectBody_WhenPostAuth_ThenSuccess() throws Exception {
        AuthDto authDto=new AuthDto( "identifiant",  "mdp");
        Agency agency=new Agency("city","country");
        Advisor advisor= new Advisor("name", "firstname", "phone", "mail", "password", agency);
        advisor.setId(1);
        Person person=advisor;
        Mockito.when(this.authService.authentification(Mockito.any())).thenReturn(Optional.of(person));
        
        ObjectMapper objectMapper= new ObjectMapper();
        String body=objectMapper
                        .valueToTree(authDto)
                        .toPrettyString();

        MockHttpServletRequestBuilder query = MockMvcRequestBuilders
                                .post("/api/auth")
                                .contentType("application/json")
                                .content(body);

        MvcResult result = mockMvc.perform(query).andReturn();
        String returnedJsonStr = result.getResponse().getContentAsString();
                
        JsonNode returnedJson = objectMapper.readTree(returnedJsonStr);
        
        String jsonStr = """
                        {
                            "id" : 1,
                            "name" : "name",
                            "firstName" : "firstname",
                            "phone" : "phone",
                            "mail" : "mail"
                        }
                        """;
        JsonNode expectedJson = objectMapper.readTree(jsonStr);
                        
        assertEquals(expectedJson, returnedJson);

    }
    @Test
    public void  givenCorrectBody_WhenPostAuth_ThenStatus200() throws Exception {
        AuthDto authDto=new AuthDto( "identifiant",  "mdp");
        Agency agency=new Agency("city","country");
        Advisor advisor= new Advisor("name", "firstname", "phone", "mail", "password", agency);
        advisor.setId(1);
        Person person=advisor;
        Mockito.when(this.authService.authentification(Mockito.any())).thenReturn(Optional.of(person));
        
        ObjectMapper objectMapper= new ObjectMapper();
        String body=objectMapper
                        .valueToTree(authDto)
                        .toPrettyString();

        MockHttpServletRequestBuilder query = MockMvcRequestBuilders
                                .post("/api/auth")
                                .contentType("application/json")
                                .content(body);

        int status = mockMvc
                        .perform(query)
                        .andReturn()
                        .getResponse()
                        .getStatus();

        assertEquals(200, status);
        Mockito.verify(this.authService).authentification(Mockito.any());

    }

    @Test void givenIncorrectBodyFieldIdentificationEmpty_WhenPostAuth_ThenStatus400() throws Exception{
        AuthDto authDto=new AuthDto( "",  "mdp");
        Mockito.when(this.authService.authentification(Mockito.any())).thenReturn(Optional.empty());
        
        ObjectMapper objectMapper= new ObjectMapper();
        String body=objectMapper
                        .valueToTree(authDto)
                        .toPrettyString();

        MockHttpServletRequestBuilder query = MockMvcRequestBuilders
                                .post("/api/auth")
                                .contentType("application/json")
                                .content(body);

        int status = mockMvc
                        .perform(query)
                        .andReturn()
                        .getResponse()
                        .getStatus();

        assertEquals(400, status);
    }

    @Test void givenIncorrectBodyFieldMdpEmpty_WhenPostAuth_ThenStatus400() throws Exception{
        AuthDto authDto=new AuthDto( "identifiant",  "");
        Mockito.when(this.authService.authentification(Mockito.any())).thenReturn(Optional.empty());
        
        ObjectMapper objectMapper= new ObjectMapper();
        String body=objectMapper
                        .valueToTree(authDto)
                        .toPrettyString();

        MockHttpServletRequestBuilder query = MockMvcRequestBuilders
                                .post("/api/auth")
                                .contentType("application/json")
                                .content(body);

        int status = mockMvc
                        .perform(query)
                        .andReturn()
                        .getResponse()
                        .getStatus();

        assertEquals(400, status);
    }

    @Test void givenCorrectBodyButNotFoundPerson_WhenPostAuth_ThenStatus404() throws Exception{
        AuthDto authDto=new AuthDto( "identifiant",  "mdp");
        Mockito.when(this.authService.authentification(Mockito.any())).thenReturn(Optional.empty());
        
        ObjectMapper objectMapper= new ObjectMapper();
        String body=objectMapper
                        .valueToTree(authDto)
                        .toPrettyString();

        MockHttpServletRequestBuilder query = MockMvcRequestBuilders
                                .post("/api/auth")
                                .contentType("application/json")
                                .content(body);

        int status = mockMvc
                        .perform(query)
                        .andReturn()
                        .getResponse()
                        .getStatus();

        assertEquals(404, status);
    }
    
}
