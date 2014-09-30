package main

import (
	"project-euler/solutions"
	"fmt"
	"os"
	"strconv"
	"github.com/jessevdk/go-flags"
)

var opts struct {
	ShowTime      bool `short:"t" long:"output-time"                             description:"Output time"`
	Benchmark     bool `short:"b" long:"benchmark"                               description:"Benchmark solution"`
	BenchmarkRuns int  `short:"n" long:"times"       default:"10" value-name:"n" description:"Number of runs if benchmarking"`
	Solution      int
}

var parser *flags.Parser

func main() {
	parseCmdLine()

	err := runSolution()
	if err != nil {
		fmt.Println(err.Error())
		os.Exit(1)
	}
}

func parseCmdLine() {
	parser = flags.NewParser(&opts, flags.HelpFlag)

	args, err := parser.Parse()
	if err != nil {
		usageError(err.Error())
	}

	if (len(args) == 0) {
		usage()
	}

	if (len(args) > 1) {
		usageError("Can only run one solution")
	}

	solution, err := strconv.Atoi(args[0])
	if err != nil {
		usageError("Invalid solution")
	}
	opts.Solution = solution
}

func runSolution() (err error) {
	if !opts.Benchmark {
		return solutions.RunSolution(opts.Solution, opts.ShowTime)
	} else {
		return solutions.BenchmarkSolution(opts.Solution, opts.BenchmarkRuns)
	}
}

func usage() {
	parser.WriteHelp(os.Stdout)
	os.Exit(0)
}

func usageError(msg string) {
	fmt.Println(msg)
	parser.WriteHelp(os.Stdout)
	os.Exit(1)
}
