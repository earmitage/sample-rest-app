package za.co.deltaceti.samples.rest;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import za.co.deltaceti.samples.rest.security.JwtAuthenticationRequest;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = za.co.deltaceti.samples.rest.DriversApplication.class)
public class AuthenticationRestServicesDocumentation {

    private static Logger log = LoggerFactory.getLogger(AuthenticationRestServicesDocumentation.class);

    @Rule
    public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("target/generated-snippets");
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
                .apply(documentationConfiguration(this.restDocumentation))
                .build();

    }

    @Test
    public void when_requestToken_expect_tokenAssignedSuccessfully() throws Exception {
        this.mockMvc.perform(post("/api/auth").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(
                new ObjectMapper().writeValueAsString(new JwtAuthenticationRequest("sebastian", "vettel"))))
                .andExpect(status().isOk())
                .andDo(document("security-authenticate",
                        responseFields(
                                fieldWithPath("token").description("The JWT token to pass back as the Authorization header"))));

    }

}
