JC = javac
JV = java
CLASSES = com/marwilc/connection/Conexion.class com/marwilc/windows/Registro.class com/marwilc/windows/Login.class com/marwilc/controller/Principal.class
MAINCLASS = com/marwilc/controller/Principal
CP = ./lib/postgresql-42.0.0.jre6.jar:.

compile:
	$(JC) $(MAINCLASS).java
run:
	$(JV) -classpath $(CP) $(MAINCLASS)
clean:
	rm -rf $(CLASSES)
