package br.com.rhuan.resources

import br.com.rhuan.ProductsServiceReply
import br.com.rhuan.ProductsServiceRequest
import br.com.rhuan.ProductsServiceServiceGrpc
import io.grpc.stub.StreamObserver

class ProductResources : ProductsServiceServiceGrpc.ProductsServiceServiceImplBase() {

    override fun send(request: ProductsServiceRequest?, responseObserver: StreamObserver<ProductsServiceReply>?) {
        super.send(request, responseObserver)
    }

}