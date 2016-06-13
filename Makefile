# OpenJDK 1.8

FILE = ParallelMergeSort

.PHONY: sort clean

parallel: sort

%.class: %.java
	javac $<

sort: $(FILE).class
	java $(FILE)

clean:
	rm *.class
