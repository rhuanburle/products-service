package br.com.rhuan.util

import br.com.rhuan.domain.Product
import br.com.rhuan.dto.ProductReq
import br.com.rhuan.dto.ProductRes

fun Product.toProductRes(): ProductRes {
    return ProductRes(
        id = id!!,
        name = name,
        price = price,
        quantityInStock = quantityInStock
    )
}

fun ProductReq.toDomain(): Product {
    return Product(
        id = null,
        name = name,
        price = price,
        quantityInStock = quantityInStock)
}