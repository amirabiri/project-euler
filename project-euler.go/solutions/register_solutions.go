package solutions

import (
	"project-euler/solutions/_1"
	"project-euler/solutions/_2"
	"project-euler/solutions/_3"
	"project-euler/solutions/_4"
	"project-euler/solutions/_5"
	"project-euler/solutions/_6"
	"project-euler/solutions/_7"
	"project-euler/solutions/_8"
	"project-euler/solutions/_9"
	"project-euler/solutions/_10"
	"project-euler/solutions/_11"
	"project-euler/solutions/_12"
	"project-euler/solutions/_13"
	"project-euler/solutions/_14"
	"project-euler/solutions/_15"
	"project-euler/solutions/_16"
	"project-euler/solutions/_17"
	"project-euler/solutions/_18"
	"project-euler/solutions/_19"
	"project-euler/solutions/_20"
	"project-euler/solutions/_21"
	"project-euler/solutions/_22"
	"project-euler/solutions/_23"
	"project-euler/solutions/_24"
	"project-euler/solutions/_25"
	"project-euler/solutions/_26"
)

func init() {
	initialize = map[int]func(){}
	solve      = map[int]func()int64{}

	solve[1]        = _1.Solve
	solve[2]        = _2.Solve
	solve[3]        = _3.Solve
	solve[4]        = _4.Solve
	solve[5]        = _5.Solve
	solve[6]        = _6.Solve
	solve[7]        = _7.Solve
	initialize[8]   = _8.Initialize
	solve[8]        = _8.Solve
	solve[9]        = _9.Solve
	solve[10]       = _10.Solve
	initialize[11]  = _11.Initialize
	solve[11]       = _11.Solve
	solve[12]       = _12.Solve
	initialize[13]  = _13.Initialize
	solve[13]       = _13.Solve
	solve[14]       = _14.Solve
	solve[15]       = _15.Solve
	solve[16]       = _16.Solve
	solve[17]       = _17.Solve
	initialize[18]  = _18.Initialize
	solve[18]       = _18.Solve
	solve[19]       = _19.Solve
	solve[20]       = _20.Solve
	solve[21]       = _21.Solve
	initialize[22]  = _22.Initialize
	solve[22]       = _22.Solve
	solve[23]       = _23.Solve
	solve[24]       = _24.Solve
	solve[25]       = _25.Solve
	solve[26]       = _26.Solve
}
