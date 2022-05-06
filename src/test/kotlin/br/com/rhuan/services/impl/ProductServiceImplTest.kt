package br.com.rhuan.services.impl

import br.com.rhuan.domain.Product
import br.com.rhuan.dto.ProductReq
import br.com.rhuan.repository.ProductRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`

internal class ProductServiceImplTest {
    private val productRepository = Mockito.mock(ProductRepository::class.java)
    private val productService = ProductServiceImpl(productRepository)

    @Test
    fun `when create method is call with valid data a ProductRes is returned`() {
        val productInput = Product(id = null, name = "product name", price = 10.00, quantityInStock = 5)
        val productOutput = Product(id = 1, name = "product name", price = 10.00, quantityInStock = 5)

        `when`(productRepository.save(productInput))
            .thenReturn(productOutput)

        val productReq = ProductReq(name = "product name", price = 10.00, quantityInStock = 5)
        val productRes = productService.create(productReq)

        assertEquals(productRes.name, productReq.name)

    }
}