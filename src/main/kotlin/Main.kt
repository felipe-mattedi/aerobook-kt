fun main() {

    val usuario = User("Joaquim")
    val usuario_2 = User ("Jose")
    exibesaudacao(usuario)
    usuario.adiciona_milhas(15200)
    usuario.adiciona_milhas(1000)
    usuario.exibe_saldo()
    usuario.debita_milhas(-2000)
    usuario.debita_milhas(3000)
    usuario.debita_milhas(5000)
    usuario.exibe_saldo()
    usuario.adiciona_trechos(3)
    usuario.debita_trechos(1)
    usuario.adiciona_trechos(3)
    usuario.transfere_milhas(6000, usuario_2)
    exibesaudacao(usuario)
    exibesaudacao(usuario_2)

}

class User (val nome: String){
    val codigo_usuario = "000001"          //ajustar apos integrar com banco de dados
    var saldo_milhas = 0
        private set
    var trechos_qualificaveis = 0
        private set

    fun exibe_saldo(){
        when{
            saldo_milhas == 0 -> println("Não existem milhas para o usuario")
            saldo_milhas == 1 -> println("O saldo atual é de 1 milha")
            else -> println ("O saldo atual é de $saldo_milhas milhas")
        }
    }
    fun adiciona_milhas(quantidade : Int): Boolean{
        if(quantidade > 0) {
            saldo_milhas += quantidade
            println("Foram adicionadas $quantidade milhas")
            println("O novo saldo é de $saldo_milhas milhas")
            return true
        }
        return false
    }
    fun adiciona_trechos(quantidade : Int): Boolean{
        if(quantidade > 0) {
            trechos_qualificaveis += quantidade
            println("Foram adicionadas $quantidade terchos qualificáveis")
            println("O novo saldo é de $trechos_qualificaveis trechos qualificáveis")
            return true
        }
        return false
    }

    fun debita_milhas(quantidade : Int): Boolean{
        if(quantidade > 0 && saldo_milhas > quantidade){
            saldo_milhas -= quantidade
            println("Foram debitadas $quantidade milhas")
            println("O novo saldo é de $saldo_milhas milhas")
            return true
        }
        return false
    }


    fun debita_trechos(quantidade : Int): Boolean{
        if(quantidade > 0 && trechos_qualificaveis > quantidade) {
            trechos_qualificaveis -= quantidade
            return true
        }
        return false
    }

    fun transfere_milhas(quantidade : Int, destino: User): Boolean{
        if(this.debita_milhas(quantidade)) {
            destino.adiciona_milhas(quantidade)
            println("Foram transferidas $quantidade milhas para o usuário ${destino.nome}")
            return true
        }
        return false
    }
}

fun exibesaudacao (usuario: User) {

    val saudacao = "Bem vindo, ${usuario.nome}, ao sistema de milhagem AeroBook!"
    println(saudacao)
    usuario.exibe_saldo()
}
