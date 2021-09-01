package br.com.grpc.externo

import br.com.grpc.CadastraChaveRequest
import br.com.grpc.chavepix.ChavePix


data class ConsultaCorrentistaResponse(
    val tipo: String,
    val agencia: String,
    val numero: String,
    val titular: Titular
) {
    val titular_id = titular.id
    val nome = titular.nome
    val cpf = titular.cpf


    fun toChavePix(request: CadastraChaveRequest): ChavePix{
        return ChavePix(request.tipoChave, request.valor, this.tipo, this.agencia,
            this.numero, this.nome, this.cpf, this.titular_id)
    }
}
data class Titular(
    val id: String,
    val nome: String,
    val cpf: String
)