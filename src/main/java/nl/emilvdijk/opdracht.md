## Constructors en Overloading: Opdracht
Maak een class Rectangle met de variabelen “int length” en “int width”, en een constructor
1. Wanneer er geen parameters aan de constructor worden meegegeven, dan is de
   standaardwaarde van “length” 4 en van “width” 2.
2. Wanneer er één int parameter aan de constructor wordt meegegeven dan is dat zowel
   de “length” als “width”.
3. Wanneer er twee int parameters aan de constructor worden meegegeven dan is één
   daarvan de “length” en de ander de “width”.
4. Maak een methode die aan de hand van de properties “length” en “width” de oppervlakte berekent.
5. Maak een methode die aan de hand van de properties “length” en “width” de omtrek berekent.
6. Maak overloaded versies van de methoden van 4. en 5. die aan de hand van de
   parameters “length” en “width” dezelfde berekeningen uitvoeren.
7. Maak een methode die uitrekent hoe vaak een ander object van Rectangle past in de
   huidige Rectangle en de uitkomst terug geeft.
8. Overload de methode van 7. met een variant die het zelfde berekent maar dan aan de
   hand van de parameters “int width” en “int length” afkomstig van het andere vierkant.

Maak een class Circle met de variabel “double radius”, en een constructor
1. Wanneer er geen parameters aan de constructor worden meegegeven, dan is de
   standaardwaarde van “radius” 8.
2. Maak een methode die de diameter uitrekent aan de hand van de radius.
3. Overload de methode van 2. met een variant die radius als parameter verwacht.
4. Maak een methode die de radius verandert aan de hand van een parameter, deze
   parameter is de nieuwe diameter van de cirkel.
5. Maak een methode die de omtrek van de cirkel berekent.
6. Maak een methode die de oppervlakte van de cirkel berekent.
7. Maak overloaded varianten van de methoden van 5. en 6. die een radius als parameter
   verwachten.

De bovenstaande classes worden ingezet voor een bedrijf dat hekken neerzet. Voeg aan beide classes toe:
1. Een methode die het aantal palen verwacht als parameter (int) en die berekent aan de
   hand van de omtrek om de hoeveel meter een paal moet worden geslagen.
2. Een methode die het aantal meter tussen de palen als parameter verwacht (double) en
   berekent aan de hand van de omtrek hoeveel palen er geslagen moeten worden.

Maak hier een programmatje van waar de gebruiker de keuze heeft om een vierkant of een cirkel te maken
en de bijbehorende waardes in te vullen. De gebruiker kan vervolgens de omtrek en oppervlakte van het
object berekenen en het aantal palen (of aantal meters tussen de palen) berekenen.