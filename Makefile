MF = /tmp/beefsGuiManifest

BEEFS = ./beefs.jar
BEEFSGUI = beefsgui.jar
SRCDIR = beefsgui

JFLAGS = -g
JAVAC = javac -cp $(BEEFS):./$(SRCDIR):${CLASSPATH}

.SUFFIXES: .java .class
.java.class:
	$(JAVAC) $(JFLAGS) $<

BEEFSGUI = beefsgui.jar

_BEEFSGUI_SRC = BeefsGuiFrame.java \
	BeefsGuiApplet.java \
	BeefsGuiPanel.java \
	BeefsGui.java

BEEFSGUI_SRC = $(_BEEFSGUI_SRC:%=$(SRCDIR)/%)

BEEFSGUI_CLASSES = $(BEEFSGUI_SRC:.java=.class)

$(BEEFSGUI): $(BEEFSGUI_SRC) $(BEEFSGUI_CLASSES)
	rm -f $(MF)
	echo "Main-Class: $(SRCDIR)/BeefsGuiFrame" > $(MF)
	echo "Class-Path: $(BEEFS)" >> $(MF)
	jar cmf $(MF) $@ $(SRCDIR)/*.class
	rm -f $(MF)

clean:
	rm -f $(BEEFSGUI) $(SRCDIR)/*.class
