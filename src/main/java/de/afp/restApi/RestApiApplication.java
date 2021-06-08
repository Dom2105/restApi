/* 
OCA!
Eine Java Datei beginnt immer mit dem Package, wenn eins vorhanden ist.
Als zweites kommen die Imports, auch hier gilt wenn sie vorhanden sind.
Als drittes kommt der Klassenkopf, dieser MUSS vorhanden sein. Der Name der Klasse
muss mit dem Dateinamen(ohne die Endung) übereinstimmen. Die Konvention besagt,
das Klassen immer mit einem Großbuchstaben beginnen.
Der Klassen Körper beginnt mit "{" und endet "}". Der Gesammte Code der Klasse, muss in den
Klassen Körper. 

Die Klasse dessen Namen mit der Datei übereinstimmt MUSS Public sein. Public bedeutet für alle,
im Projekt sichtbar. 

Eine Java Datei, darf mehrere Klassen entahlten, diese dürfen nicht Public sein!! und sind nur von 
der Public Klasse, der Datei nutzbar. 
*/


package de.afp.restApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*
	Spring relevant nicht OCA!
 * @SpringBootApplication wird der Hauptklasse der Anwendung zugewiesen, die im
 * Top-Level-Paket liegen muss. Spring Boot wird dadurch alle Unterordner
 * scannen.
 * 
 * @SpringBootApplication kombiniert @Configuration, @EnableAutoConfiguration
 * und @ComponentScan.
 * 
 */
public class RestApiApplication {

	


	/*
	OCA!
	In Java gibt es zwei elementare Elemente. Diese sind "Fields and Methods" (Felder wie z.B. 
	Variablen oder Konstanten oder Methoden(Funktionen). Eine Konvention in Java ist es, das 
	Methoden und Variablen mit einem kleinbuchstaben beginnen. Erst einzweites wort hat einen Großen,
	ersten Buchstaben. Z.B. "name" oder "nameDerStraße
	*/
	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);

		/* 
		OCA!
		Eine Variabale wie hier besteht aus den initalisieren und dem deklarieren.
		Das Initalisieren besteht aus einem Datentyp und der benennung der Variable, also 
		in diesem fall der Datentyp "String" und dem Variablennamen "name". 
		Unter dem Variablenname können wir die Variable zu jederzeit, innerhalb der Klasse
		ansprechen. Variablennamen dürfen mit einem Buchstaben, einem Unterstrich oder einem 
		Dollerzeichen beginnen. Die obengenannte Konvention sollte aber trotzdem eingehalten werden.
		Z.B. "$name", "_name".

		Das Deklarieren, ist das zuweißen eines Wertes zu einer Variabel. Eingeleitet wird das zuweißen
		immer durch ein einfaches "=". Sprich immer wenn wir nur ein "=" sehen findet eine zuweißung statt!
		In diesem fall wir der Variable der wert "Dom" zugewisen.

		Das ende eines Befehls wird in Java immer mit einem ";" abgeschlossen.
		*/
		String name = "Dom";

		String[] namen = { "fanar", "Dominic", "Alex" };

		/* String[] nachnamen = new String[4]; */

		name(namen, name);

	}
	
	public static void name(String[] ka, String... ka2) {
		System.out.println(ka);
		System.out.println(ka2);
	}

}
