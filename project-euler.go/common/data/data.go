package data

import (
	"os"
	"path"
	"bufio"
	"bytes"
	"strings"
	"strconv"
)

var currentFilename string

func SetCurrentDataFilename(filename string) {
	currentFilename = filename
}

func GetCurrentDataFilename() string {
	var basePath string
	if path.IsAbs(os.Args[0]) {
		basePath = path.Dir(os.Args[0])
	} else {
		cwd,_ := os.Getwd()
		basePath = path.Dir(path.Join(cwd, os.Args[0]))
	}
	basePath = path.Clean(basePath)
	return path.Join(basePath, currentFilename)
}

func ReadLines() []string {
	file, err := os.Open(GetCurrentDataFilename())
	if err != nil {
		panic(err)
	}

	defer file.Close()

	scanner := bufio.NewScanner(file)

	lines := []string{}
	for scanner.Scan() {
		lines = append(lines, scanner.Text())
	}

	return lines
}

func ReadNoNewLines() string {
	file, err := os.Open(GetCurrentDataFilename())
	if err != nil {
		panic(err)
	}

	defer file.Close()

	scanner := bufio.NewScanner(file)

	var buffer bytes.Buffer
	for scanner.Scan() {
		buffer.Write(scanner.Bytes())
	}

	return buffer.String()
}

func ReadIntsMatrix() [][]int {
	file, err := os.Open(GetCurrentDataFilename())
	if err != nil {
		panic(err)
	}

	defer file.Close()

	scanner := bufio.NewScanner(file)

	ret := [][]int{}
	for scanner.Scan() {
		row := []int{}
		for _,num := range strings.Split(scanner.Text(), " ") {
			numInt, _ := strconv.ParseInt(num, 10, 64)
			row = append(row, int(numInt))
		}
		ret = append(ret, row)
	}

	return ret
}
