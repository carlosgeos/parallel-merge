# OpenJDK 1.8

FILE = ParallelMergeSort
FILE2 = MergeSort
DEPS = *.java

all: $(FILE).class sort

$(FILE).class: $(FILE).java
	javac $<

$(FILE2).class: $(FILE).java
	javac $<

sort: $(FILE).class
	java $(FILE)
