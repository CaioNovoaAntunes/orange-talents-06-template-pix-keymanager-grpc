package br.com.grpc.chavepix

import br.com.grpc.TipoChave
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


@Entity
class ChavePix(
    val tipoChave: TipoChave,
    var valor: String,
    val tipoConta: String,
    val agencia: String,
    val numero: String,
    val nome: String,
    val cpf: String,
    val id_cliente: String,
) {

    init {
        if (tipoChave == TipoChave.CHAVE_ALEATORIA && valor.isNullOrBlank()){
            valor = UUID.randomUUID().toString()
        }
    }
    @Id
    @GeneratedValue(generator = "UUID")
    var pixId: UUID? = null
}