JC = javac
JV = java
CLASSES = com/marwilc/windows/*.java com/marwilc/connection/*.java  
MAINCLASS = com/marwilc/windows/Principal
CP = ./lib/postgresql-9.2-1004.jdbc4.jar:.

compile:
	$(JC) $(CLASSES)
run:
	$(JV) -classpath $(CP) $(MAINCLASS)
clean:
	rm -rf com/marwilc/windows/*.class
