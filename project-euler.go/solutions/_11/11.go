package _11

import "project-euler/common/data"

type Dir struct {
	x int
	y int
}

var matrix     [][]int
var directions []Dir

func Initialize() {
	matrix     = data.ReadIntsMatrix()
	directions = []Dir{ Dir{1, 0}, Dir{0, 1}, Dir{1, 1}, Dir{1, -1} }
}

func Solve() int64 {
	var max int

	for y := 0; y < 20; y++ {
		for x := 0; x < 17; x++ {
			for _,dir := range directions {
				if dir.y == -1 && y < 3 {
					continue
				}
				if dir.y == 1  && y > 16 {
					continue
				}

				p := check(x, y, dir.x, dir.y)
				if p > max {
					max = p
				}
			}
		}
	}

	return int64(max)
}

func check(x, y, xDir, yDir int) int {
	product := 1
	for i := 0; i < 4; i++ {
		product *= matrix[y][x]
		x += xDir
		y += yDir
	}
	return product
}
