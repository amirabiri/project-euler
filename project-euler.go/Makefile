SOURCE_FILES   := $(shell find . -name '*.go')
SOLUTION_FILES := $(wildcard solutions/_*/*.go)
DATA_FILES     := $(shell find solutions -name '*.txt')

all: register_solutions bin/project-euler data

bin/project-euler: $(SOURCE_FILES) .gopmfile
	@mkdir -p bin
	@gopm build
	@mv project-euler.go bin/project-euler

register_solutions: $(SOLUTION_FILES)
	@./register-solutions.sh

data: $(DATA_FILES)
	@./cp-txt.sh bin

clean:
	@rm bin/*

.PHONY: all register_solutions data clean
