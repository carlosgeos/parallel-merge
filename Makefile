# OpenJDK 1.8

FILE = ParallelMerge
DEPS = *.java

all: $(FILE).class execute

$(FILE).class: $(DEPS)
	javac $<

execute: $(FILE).class
	java $(FILE)
