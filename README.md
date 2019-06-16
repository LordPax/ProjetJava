# projet java

### Installer javaFX
* [javaFx](https://openjfx.io/)

### Description
Projet

### Les commandes
* __commande avant compilation__
	```bash
	export PATH_TO_FX=/etc/javafx-sdk-11.0.2/lib/
	``` 

* __commande java :__
	```bash
	javac --module-path $PATH_TO_FX --add-modules javafx.controls \*.java
	java --module-path $PATH_TO_FX --add-modules javafx.controls Main
	```

* __commande git :__
	```bash
	git add \*.java diagrammes _(\*.java pour éviter d'ajouter les .class)_
	git commit -m "ton commantaire"
	git push origin master
	```

### Contributeur
* [Lucas Brossier](https://github.com/brolucas)