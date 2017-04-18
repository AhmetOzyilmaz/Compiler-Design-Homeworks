#
# Filename:    Makefile
# Author:      Ahmet özyılmaz
# Datred:      27/03/2017
# Decription:  Makefile for parser
#


SHELL := /bin/sh
MAKE  := make
JC = javac
JAR     := jar
JFLAGS = -g
JC = javac
.SUFFIXES: .java .class



usage:
	@echo ""
	@echo "Master Makefile for A02_AHMET_OZYILMAZ_111044014."
	@echo ""
	@echo "Usage:"
	@echo "	make all        # Compile everything"
	@echo "	make clean      # Remove all object files"
	@echo "	make clean_all  # Remove all object files and the binary"
	@echo ""


.java.class:
		$(JC) $(JFLAGS) $*.java

CLASSES = Lexical.java Semantic.java A02_AHMET_OZYILMAZ_111044014.java  CodeGen.java

all: jarfile

jarfile: classes
		jar cmfv manifest.txt parser.jar $(CLASSES:.java=.class)

classes: $(CLASSES:.java=.class)

clean:
		$(RM) *.class
clean_all:
	$(RM) $(OBJS) parser.jar *.class