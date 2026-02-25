package steps.api;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class ApiSteps {

    RequestSpecification request;
    Response response;

    @Given("Saya menyiapkan API dengan app-id {string}")
    public void setupApi(String appId) {
        // Mengatur alamat dasar API DummyAPI
        RestAssured.baseURI = "https://dummyapi.io/data/v1/";

        // Memasukkan "kunci masuk" (app-id) ke dalam Header biar nggak diblokir server
        request = RestAssured.given().header("app-id", appId);
    }

    @When("Saya melakukan request GET ke endpoint user")
    public void sendGetRequest() {
        // Mengirim request GET untuk mengambil daftar user
        response = request.get("user");
    }

    @Then("Saya mendapatkan status code {int} OK")
    public void verifyStatusCode(int expectedStatusCode) {
        // Mengecek apakah server menjawab dengan sukses (200)
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(expectedStatusCode, actualStatusCode);
    }

    @And("Response body memiliki data user yang valid")
    public void verifyResponseBody() {
        // Memastikan isi balasannya ada teks "data"-nya (tandanya datanya beneran ditarik)
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("data"));

        // Menampilkan hasilnya di layar log biar kita bisa lihat bentuk datanya
        System.out.println("Cek Data User: " + responseBody);
    }
}