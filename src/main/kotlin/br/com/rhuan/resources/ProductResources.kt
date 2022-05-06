package br.com.rhuan.resources

import br.com.rhuan.ProductServiceRequest
import br.com.rhuan.ProductServiceResponse
import br.com.rhuan.ProductsServiceGrpc
import br.com.rhuan.dto.ProductReq
import br.com.rhuan.services.ProductService
import io.grpc.stub.StreamObserver
import io.micronaut.grpc.annotation.GrpcService

@GrpcService
class ProductResources(
    private val productService: ProductService
) : ProductsServiceGrpc.ProductsServiceImplBase() {
    override fun create(request: ProductServiceRequest?, responseObserver: StreamObserver<ProductServiceResponse>?) {
        val productReq = ProductReq(request!!.name, price = request.price, quantityInStock = request.quantityInStock)
        val productRes = productService.create(productReq)
        val productResponse = ProductServiceResponse.newBuilder()
            .setId(productRes.id)
            .setName(productRes.name)
            .setPrice(productRes.price)
            .setQuantityInStock(productRes.quantityInStock)
            .build()

        responseObserver?.onNext(productResponse)
        responseObserver?.onCompleted()
    }
}