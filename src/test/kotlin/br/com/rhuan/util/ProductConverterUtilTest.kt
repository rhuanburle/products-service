package br.com.rhuan.util

import br.com.rhuan.domain.Product
import br.com.rhuan.dto.ProductReq
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ProductConverterUtilTest {

    @Test
    fun `when toProductRes is call, should return a ProductRes with all data`() {
        val product = Product(1,"product-name", 10.90,10)
        val productRes = product.toProductRes()

        Assertions.assertEquals(product.id, productRes.id)
        Assertions.assertEquals(product.name, productRes.name)
        Assertions.assertEquals(product.price, productRes.price)
        Assertions.assertEquals(product.quantityInStock, productRes.quantityInStock)
    }

    @Test
    fun `when toDomain is call, should return a Product with all data`() {
        val productReq = ProductReq("product-name", 10.90,10)
        val product = productReq.toDomain()

        Assertions.assertEquals(null, product.id)
        Assertions.assertEquals(productReq.name, product.name)
        Assertions.assertEquals(productReq.price, product.price)
        Assertions.assertEquals(productReq.quantityInStock, product.quantityInStock)
    }

}