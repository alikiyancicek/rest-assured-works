import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class ValidateAddPlaceAPI {
    public static void main(String[] args) {
        // first example - validate if "Add Place API" ia working properly - POST req.

        //given, when, there methods in the automation tests in rest assured
        //1- given - all input details
        //2- when - submit the API -  resources and http methods
        //3- then - validate the response
        //initialize the baseURI
        RestAssured.baseURI = "https://rahulshettyacademy.com";

        // given belong to rest assured static package so we need to import that static package. ln 2
        // following line , we describe our key ( from url ) and its value ( refer to postman)
        //.log().all() shows givin data as well as output perfectly. this is a must
        given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
                // calling clas-> then the static method which has our json data
                .body(jsonData.jsonDatas()).
                when().post("maps/api/place/add/json")
                .then().log().all().assertThat().statusCode(200)
                //validating if scope=APP with body and equal to method. also equal to method is under the static package called harmcast.matchers.
                // we need to import it manually
                .body("scope",equalTo("APP"))
                // all methods after written THEN will be return or output.
                // following line checks the server is validated as ours or not. because we might hacked.
                //this is most commonly used technic
                .header("server","Apache/2.4.41 (Ubuntu)");

                // Add place - > Update place with new address -> get place to validate if new address presents in the response.
                // ( end to end automation test sample)
                // first need to tell which place going to change based on place_id


    }

}
