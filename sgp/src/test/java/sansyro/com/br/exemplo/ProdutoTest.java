package sansyro.com.br.exemplo;

import org.junit.Assert;

import org.junit.jupiter.api.Test;

import com.github.database.rider.cdi.api.DBRider;
import com.github.database.rider.core.api.dataset.DataSet;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;

@DBRider
@QuarkusTest
@QuarkusTestResource(DatabaseTest.class)
public class ProdutoTest {

    @Test
    @DataSet("produto.yml")
    public void testExisteProduto() {
    	Assert.assertEquals(Produto.count(), 1);
    }

}