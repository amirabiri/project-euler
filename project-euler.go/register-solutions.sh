#!/bin/bash

for sln in `ls -1d solutions/_* | sort -t/ -n -k2.2`; do
	if [ ! -d $sln ]; then
		continue
	fi

	num=$(basename $sln)
	num=${num:1}

	IMPORT="$IMPORT"$'\t'"\"project-euler\\/solutions\\/_$num\"\\"$'\n'

	has_init=$(grep -c 'func Initialize()' solutions/_$num/$num.go)
	if [ $has_init -eq 1 ]; then
		REG=$REG$(printf "\t%-15s = _%d.Initialize\\\\" "initialize[$num]" $num)$'\n'
	fi

	REG=$REG$(printf "\t%-15s = _%d.Solve\\\\" "solve[$num]" $num)$'\n'
done

cat solutions/_register_solutions.go.tpl | sed "s/@@IMPORT@@/$IMPORT/" | sed "s/@@REGISTER@@/$REG/" > solutions/register_solutions.go
