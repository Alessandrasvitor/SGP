package sansyro.com.br.exemplo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.not;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.github.database.rider.core.api.dataset.DataSet;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class CursoTest {

    @Test
    @DataSet("produto.yml")
    public void testExisteProduto() {
    	Assert.assertEquals(Produto.count(), 1);
    	
    }

    @Test
    public void testGet() {
        given()
          .when().get("/curso")
          .then()
             .statusCode(200)
             .body(not("[]"));
    }  

}