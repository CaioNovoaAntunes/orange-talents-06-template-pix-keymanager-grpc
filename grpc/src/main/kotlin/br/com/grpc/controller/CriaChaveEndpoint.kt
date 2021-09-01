package br.com.grpc.controller


import br.com.grpc.CadastraChaveRequest
import br.com.grpc.CadastraChaveResponse
import br.com.grpc.KeyManagerServiceGrpc
import br.com.grpc.chavepix.ChavePixRepository
import br.com.grpc.externo.ConsultaCorrentista
import io.grpc.stub.StreamObserver
import io.micronaut.validation.Validated
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@Validated
class CriaChaveEndpoint(

    @Inject val chavePixRepository: ChavePixRepository,
    @Inject val client: ConsultaCorrentista
) : KeyManagerServiceGrpc.KeyManagerServiceImplBase() {


    override  fun registrarChave(
        request: CadastraChaveRequest,
        responseObserver: StreamObserver<CadastraChaveResponse>

    ){
        val novaChavePix = client.consultaCliente(request)
        val response = chavePixRepository.save(novaChavePix)
            .let { chavePix ->
                CadastraChaveResponse.newBuilder()
                    .setPixId(chavePix?.pixId.toString())
                    .build()
            }

        responseObserver.onNext(response)
        responseObserver.onCompleted()
    }

}