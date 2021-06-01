import java.math.BigInteger
import kotlin.random.Random

object DiffieHellman {

    fun privateKey(prime: BigInteger): BigInteger {
        return Random.nextLong(1, prime.toLong()).toBigInteger()
    }

    fun publicKey(p: BigInteger, g: BigInteger, privKey: BigInteger): BigInteger {
        return g.pow(privKey.toInt()).mod(p)
    }

    fun secret(prime: BigInteger, publicKey: BigInteger, privateKey: BigInteger): BigInteger {
        return publicKey.pow(privateKey.toInt()).mod(prime)
    }
}
