# OpenJDK 1.8

FILE = ParallelMergeSort
DEPS = *.java

parallel: $(FILE).class sort

$(FILE).class: $(DEPS)
	javac $(FILE).java

sort: $(FILE).class
	java $(FILE)

