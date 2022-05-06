package br.com.rhuan.services.impl

import br.com.rhuan.dto.ProductReq
import br.com.rhuan.dto.ProductRes
import br.com.rhuan.repository.ProductRepository
import br.com.rhuan.services.ProductService
import br.com.rhuan.util.toDomain
import br.com.rhuan.util.toProductRes
import jakarta.inject.Singleton

@Singleton
class ProductServiceImpl(
    private val productRepository: ProductRepository
    ) : ProductService {
    override fun create(req: ProductReq): ProductRes {
        val productSaved = productRepository.save(req.toDomain())
        return productSaved.toProductRes()
    }
}