import java.math.BigInteger

fun main() {
    println(factorial(44.toBigInteger()))
}

tailrec fun factorial(n: BigInteger): BigInteger {
    return if (n == 0.toBigInteger() || n == 1.toBigInteger()) 1.toBigInteger()
    else n * factorial(n - 1.toBigInteger())
}
