package br.com.rhuan.services

import br.com.rhuan.dto.ProductReq
import br.com.rhuan.dto.ProductRes

interface ProductService {
    fun create(req: ProductReq): ProductRes
}