import kotlin.math.*

data class ComplexNumber(val real: Double = 0.0, val imag: Double = 0.0) {
    val abs = sqrt(real.pow(2) + imag.pow(2))

    operator fun plus(otherComplex: ComplexNumber): ComplexNumber {
        return ComplexNumber(real + otherComplex.real, imag + otherComplex.imag)
    }

    operator fun minus(otherComplex: ComplexNumber): ComplexNumber {
        return ComplexNumber(real - otherComplex.real, imag - otherComplex.imag)
    }

    operator fun times(otherComplex: ComplexNumber): ComplexNumber {
        val realPart = (real * otherComplex.real) - (imag * otherComplex.imag)
        val imagPart = (imag * otherComplex.real) + (real * otherComplex.imag)
        return ComplexNumber(realPart, imagPart)
    }

    operator fun div(otherComplex: ComplexNumber): ComplexNumber {
        val divisor = (otherComplex.real.pow(2) + otherComplex.imag.pow(2))
        val realPart = ((real * otherComplex.real) + (imag * otherComplex.imag)) / divisor
        val imagPart = ((imag * otherComplex.real) - (real * otherComplex.imag)) / divisor
        return ComplexNumber(realPart, imagPart)
    }

    fun conjugate(): ComplexNumber {
        return ComplexNumber(real, -1 * imag)
    }
}

fun exponential(complex: ComplexNumber): ComplexNumber {
    val exponential = exp(complex.real)
    val real = exponential * cos(complex.imag)
    val imag = exponential * sin(complex.imag)
    return ComplexNumber(real, imag)
}