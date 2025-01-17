package br.com.grpc.externo

import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.QueryValue
import io.micronaut.http.client.annotation.Client

@Client("http://localhost:9091/api/v1/clientes")
interface ConsultaCorrentistaClient {

    @Get("/{clienteId}/contas")
    fun consultaCliente(@PathVariable clienteId: String, @QueryValue tipo: String): ConsultaCorrentistaResponse
}