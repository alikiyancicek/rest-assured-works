import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class ValidateAddPlaceAPI {
    public static void main(String[] args) {
        // first example - validate if "Add Place API" ia working properly

        //given, when, there methods in the automation tests in rest assured

        //given - all input details
        //when - submit the API -  resources and http methods
        //then - validate the response
        // initialize the baseURI
        RestAssured.baseURI = "https://rahulshettyacademy.com";

        //given
        // given belong to rest assured static package so we need to import that static package. ln 2
        // following line , we describe our key ( from url ) and its value ( refer to postman)
        //.log().all() shows givin data as well as output perfectly. this is a must
        given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
                .body("{\r\n" +
                        "  \"location\":{\r\n" +
                        "    \"lat\":-38.383494,\r\n" +
                        "    \"lng\":33.427362\r\n" +
                        "  },\r\n" +
                        "  \"accuracy\":50,\r\n" +
                        "  \"name\":\"Rahul Shetty Academy\",\r\n" +
                        "  \"phone_number\": \"(+49) 983 9797 34 34\",\r\n" +
                        "  \"address\": \" 29, side layout, cohen 90\",\r\n" +
                        "  \"types\":[\r\n" +
                        "    \"shoe park\",\r\n" +
                        "    \"shop\"\r\n" +
                        "  ],\r\n" +
                        "  \"website\": \"http://rahulshettyacademy.com\",\r\n" +
                        "  \"language\":\"French-IN\"\r\n" +
                        "}\r\n" +
                        "").
                when().post("maps/api/place/add/json")
                .then().log().all().assertThat().statusCode(200);

    }

}
