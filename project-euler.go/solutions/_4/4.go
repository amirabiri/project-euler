package _4

func Solve() int64 {
	leftSide := 999
	num      := makePalindrome(leftSide)

	for !check(num) {
		leftSide--
		num = makePalindrome(leftSide)
	}

	return int64(num)
}

func makePalindrome(num int) int {
	c := num % 10
	b := (num / 10) % 10
	a := num / 100

	return num * 1000 + c * 100 + b * 10 + a
}

func check(num int) bool {
	if num % 11 != 0  {
		return false
	}

	for fac := 999; fac >= 900; fac-- {
		if num % fac == 0 && num / fac < 1000 {
			return true
		}
	}

	return false
}
