package _18

import "project-euler/common/data"

var triangle [][]int

func Initialize() {
	triangle = data.ReadIntsMatrix()
}

func Solve() int64 {
	paths := triangle[len(triangle) - 1]

	for i := len(triangle) - 2; i >= 0; i-- {
		next_paths := []int{}
		for j := range triangle[i] {
			if paths[j] > paths[j + 1] {
				next_paths = append(next_paths, triangle[i][j] + paths[j])
			} else {
				next_paths = append(next_paths, triangle[i][j] + paths[j + 1])
			}
		}
		paths = next_paths
	}

	return int64(paths[0])
}
