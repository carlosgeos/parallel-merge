# OpenJDK 1.8

FILE = ParallelMergeSort
FILE2 = MergeSort
DEPS = *.java

parallel: $(FILE).class sort

sequential: $(FILE2).class seq_sort

$(FILE).class: $(FILE).java
	javac $<

$(FILE2).class: $(FILE2).java
	javac $<

sort: $(FILE).class
	java $(FILE)

seq_sort: $(FILE2).java
	java $(FILE2)
