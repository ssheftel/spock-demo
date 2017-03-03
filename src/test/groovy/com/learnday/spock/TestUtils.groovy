package com.learnday.spock

import groovy.json.JsonSlurper
import org.springframework.mock.web.MockHttpServletResponse
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder

class TestUtils {
    /**
     * Convenience function for making a function for performing
     * mockMvc request and returning the response
     *
     * @param mockMvc
     * @return
     */
    static performRequest(MockMvc mockMvc) {
        Closure<MockHttpServletResponse> httpResponse = { MockHttpServletRequestBuilder mockHttpServletRequestBuilder ->
            def response = mockMvc.perform(mockHttpServletRequestBuilder).andReturn().response
            response
        }
        return httpResponse
    }

    /**
     * Convenience function for converting mockHttpResponse to Json
     *
     * @param response
     * @return
     */
    static Object toJson(MockHttpServletResponse response) {
        return new JsonSlurper().parseText(response.contentAsString)
    }

    /**
     * Convenience function for making a function for performing
     * mockMvc request and parsing response as json
     *
     * @param mockMvc
     * @return jsonResponse function
     */
    static performJsonRequest(MockMvc mockMvc) {
        Closure<Object> jsonResponse = { MockHttpServletRequestBuilder mockHttpServletRequestBuilder ->
            def response = mockMvc.perform(mockHttpServletRequestBuilder).andReturn().response
            def json = toJson(response)
            json
        }
        return jsonResponse
    }
}
