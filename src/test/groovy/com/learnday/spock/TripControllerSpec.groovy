package com.learnday.spock

import org.springframework.mock.web.MockHttpServletResponse
import org.springframework.test.web.servlet.MockMvc
import spock.lang.*
import com.blogspot.toomuchcoding.spock.subjcollabs.Subject
import com.blogspot.toomuchcoding.spock.subjcollabs.Collaborator

import static com.learnday.spock.TestUtils.performJsonRequest
import static com.learnday.spock.TestUtils.performRequest
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup


class TripControllerSpec extends Specification {


    @Subject
    TripController tripController

    @Collaborator
    TripService tripService = Mock(TripService)

    MockMvc mockMvc
    Closure<Object> jsonResponse
    Closure<MockHttpServletResponse> httpResponse

    def setup() {
        mockMvc = standaloneSetup(tripController).build()
        httpResponse = performRequest(mockMvc)
        jsonResponse = performJsonRequest(mockMvc)
    }

    def "GET /trip response with 200 OK"() {
        when: "trips are requested"
            def response = httpResponse(get("/trip"))
        then: "Http Status is 200 OK"
            response.status == 200
    }

    // more controller tests here

}
