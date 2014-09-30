package _6

func Solve() int64 {
	var sum int64;
	var sumSqrs int64;

	for i := int64(1); i <= 100; i++ {
		sum     += i
		sumSqrs += i * i
	}

	return sum * sum - sumSqrs
}
