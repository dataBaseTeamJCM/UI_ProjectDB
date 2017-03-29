JC = javac
JV = java
CLASSES = src/com/marwilc/windows/Login.class src/com/marwilc/connection/Conexion.class  
MAINCLASS = src/com/marwilc/windows/Login
CP = ./lib/postgresql-9.2-1004.jdbc4.jar:.

compile:
	$(JC) $(MAINCLASS).java
run:
	$(JV) -classpath $(CP) $(MAINCLASS)
clean:
	rm -rf $(CLASSES)
