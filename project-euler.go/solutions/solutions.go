package solutions

import (
	"fmt"
	"time"
	"errors"
	"project-euler/common/data"
)

var initialize map[int]func()
var solve      map[int]func()int64

func RunSolution(num int, showTime bool) (err error) {
	solutionFunc := solve[num]
	if solutionFunc == nil {
		return errors.New("Invalid solution")
	}

	initializeFunc := initialize[num]
	if initializeFunc != nil {
		data.SetCurrentDataFilename(fmt.Sprintf("%v.txt", num))
		initializeFunc()
	}

	start := time.Now()

	result := solutionFunc()

	elapsed := time.Since(start)

	fmt.Println(result)
	if showTime {
		fmt.Println(int64(elapsed/time.Millisecond))
	}

	return
}

func BenchmarkSolution(num int, runTimes int) (err error) {
	solutionFunc := solve[num]
	if solutionFunc == nil {
		return errors.New("Invalid solution")
	}

	initializeFunc := initialize[num]
	if initializeFunc != nil {
		data.SetCurrentDataFilename(fmt.Sprintf("%v.txt", num))
		initializeFunc()
	}

	start := time.Now()

	for i := 0; i < runTimes; i++ {
		solutionFunc()
	}

	elapsed := time.Since(start)
	fmt.Println(int64(elapsed/time.Millisecond))

	return
}
