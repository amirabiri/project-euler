package _13

import (
	"project-euler/common/data"
	"math/big"
	"strconv"
)

var numbers []big.Int

func Initialize() {
	numbers = []big.Int{}
	for _,line := range data.ReadLines() {
		n := big.NewInt(0)
		n.SetString(line, 10)
		numbers = append(numbers, *n)
	}
}

func Solve() int64 {
	sum := big.NewInt(0)
	for _,n := range numbers {
		sum.Add(sum, &n)
	}

	result, _ := strconv.ParseInt(sum.String()[0:10], 10, 64)
	return result
}
