// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {
    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        if (usuario !in inscritos) {
            inscritos.add(usuario)
            println("${usuario.nome} foi matriculado na formação $nome.")
        } else {
            println("${usuario.nome} já está matriculado na formação $nome.")
        }
    }

    fun desmatricular(usuario: Usuario) {
        if (usuario in inscritos) {
            inscritos.remove(usuario)
            println("${usuario.nome} foi desmatriculado da formação $nome.")
        } else {
            println("${usuario.nome} não está matriculado na formação $nome.")
        }
    }
}

fun main() {
    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 90)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos", 120)
    val formacao = Formacao("Formação de Kotlin", listOf(conteudo1, conteudo2))
    val usuario1 = Usuario("Adrian")
    val usuario2 = Usuario("Raquel")

    formacao.matricular(usuario1)
    formacao.matricular(usuario2)
    formacao.matricular(usuario1) // Tentando matricular o mesmo usuário novamente
    formacao.desmatricular(usuario1)
    formacao.desmatricular(usuario2)
    formacao.desmatricular(usuario1) // Tentando desmatricular um usuário que não está matriculado
}
