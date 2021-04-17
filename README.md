# Beispiele zur Vorlesung

## Design-Muster und ihre Anwendung in funktionalen Sprachen

### Verzeichnis "fp-pattern"

Installiere:
* jdk version: 12 <= myVersion <= 15
* scalaVersion := "2.13.5"
* sbtVersion := "1.4.9"

Test:
```bash
sbt clean test
```

Ansonsten empfehle ich entweder:
* IntelliJ mit Scala Plugin zu verwenden
* oder ScalaIDE (Eclipse)


## Einführung in EMF Model-Transformationen mit Henshin 

### Verzeichnis "henshin"

Installiere:
* https://www.eclipse.org/downloads/packages/   Eclipse Modeling Tools (neuste, Eclipse IDE 2021-03)
* https://www.eclipse.org/henshin/install.php (Henshin Version 1.6.0, kann auch einfach über Eclipse MarketPlace installiert werden)
* https://www.eclipse.org/emfatic/download/ (Optional, Stable Version, über Eclipse Update-Site)

Im 'henshin'-Verzeichnis befinden sich verschiedene Versionsstände unserer Transformationsregeln in Unterordnern (chronologisch geordnet).

#### Ausprobieren:

1. Eclipse Projekt anlegen und henshin Verzeichnis reinkopieren 
2. Die Henshin-Diagramm-Datei mit dem entsprechenden Henshin Editor öffnen
3. Apply Transformation (über rechte Maustaste, im Diagramm oder Henshin-Regel-Datei)
4. '.ecore' welches transformiert werden soll wählen (neues transformiertes Ecore wird erstellt)
5. Optional: Transformiertes '.ecore' kann mit Rechter-Maustaste in '.emf' Format überführt werden (EMFatic) 

#### Übung: Verbessert das "PullUp Attribute" TS 

1. Nur Attribute die in ALLEN Klassen vorhanden sind sollen hochgezogen werden.
2. Alle Attribute die hochgezogen werden müssen den gleichen Datentyp haben.
3. Das Refactoring soll bei einer beliebigen Anzahl von Unterklassen funktionieren.

Hinweis: Ihr könnt das Henshin-„Trace“ Metamodel importieren, und Hilfsmarker setzen!
