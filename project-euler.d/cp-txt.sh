#!/bin/bash

for src in $(find source -name '*.txt'); do
	dst=$1/$(basename $src | sed "s/^_*//")
	if [ ! -e $dst ] || [ $src -nt $dst ] ; then
		cp $src $dst
	fi
done