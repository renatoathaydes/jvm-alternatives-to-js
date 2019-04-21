all: swing.jar.js

swing.jar:
	cd cheerpjswing && mvn package
	cp cheerpjswing/target/cheerpj-swing-1.0-SNAPSHOT.jar swing.jar

swing.jar.js: swing.jar
	~/cheerpj_1.3/cheerpjfy.py swing.jar

clean:
	cd cheerpjswing && mvn clean
	rm -rf swing.jar swing.jar.js