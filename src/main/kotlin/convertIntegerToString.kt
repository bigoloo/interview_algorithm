fun main() {
    val number = 654321
    var numberEqual = number
    var result = ""
    while (numberEqual> 0) {
        result += numberEqual.rem(10).toString()
        numberEqual /= 10
    }
    println(result.reversed())
}