package br.com.alura.screenmatch.modelos;

public record TituloOmdb(String title, String year, String runtime) {
    //TituloOmdb(String title, String year, String runtime)
    // com os atributos escritos em minusculos, o Gson não consegue achar os dados no Json por lá está escrito em
    //maiusculo.
    //Se for colocado em maiusculo aqui, vai funcionar, porém, isso não é uma boa prática e não deve ser feito

}
