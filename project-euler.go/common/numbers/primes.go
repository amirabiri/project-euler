package numbers

import "math"

var p235 = [...]int { 2, 3, 5 };
var p30  = [...]int { 1, 7, 11, 13, 17, 19, 23, 29 };

type ProbablePrimesGenerator struct {
	i int
	k int
}

func (this *ProbablePrimesGenerator) Next() int {
	this.i++
	if this.i == len(p30) {
		this.i = 0
		this.k++
	}
	return this.k * 30 + p30[this.i]
}

type PrimesGenerator struct {
	probablePrimes ProbablePrimesGenerator
	knownPrimes    []int
}

func (this *PrimesGenerator) Next() int {
	number := this.probablePrimes.Next()
	for !this.isPrime(number) {
		number = this.probablePrimes.Next()
	}
	this.knownPrimes = append(this.knownPrimes, number)
	return number
}

func (this *PrimesGenerator) isPrime(number int) bool {
	sqr := int(math.Floor(math.Sqrt(float64(number))))
	for _,p := range this.knownPrimes {
		if p > sqr {
			break
		}
		if number % p == 0 {
			return false
		}
	}
	return true
}

func NewPrimesGenerator() *PrimesGenerator {
	primesGenerator := PrimesGenerator{}
	primesGenerator.knownPrimes = append(primesGenerator.knownPrimes, p235[0:len(p235)-1]...)
	return &primesGenerator
}

func GetPrimeFactors(number int) []int {
	factors := []int{}

	for _,f := range p235 {
		for number % f == 0 {
			factors = append(factors, f)
			number /= f;
		}
	}

	probablePrimes := ProbablePrimesGenerator{}
	x := probablePrimes.Next()

	for x <= number / x {
		for number % x == 0 {
			factors = append(factors, x)
			number /= x
		}
		x = probablePrimes.Next()
	}

	if (number > 1) {
		factors = append(factors, number)
	}

	return factors
}
