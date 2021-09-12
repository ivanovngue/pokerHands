# Poker hand

The goal is to compare several pairs of poker hands and to indicate which, if either, has a higher rank.

### Configuration

Before running, you have to set your poker hands by using hands.txt located in src/main/resources folder. Below an
example :

```
2H 3D 5S 9C KD 2C 3H 4S 8C AH
2H 4S 4C 2D 4H 2S 8S AS QS 3S
2H 3D 5S 9C KD 2C 3H 4S 8C KH
2H 3D 5S 9C KD 2D 3H 5C 9S KH
```

Above example has 4 rows consider as 4 games, and each row has 2 hands of 5 cards. For each row, Black player represent
first 5 cards and White player is 5 last cards.

### Run class

To run it, you can just execute the main : class com.iv.kata.pk.application.PokerHands.

### Run Jar file

Use maven command line to create an executable jar : poker-hand-1.0-SNAPSHOT-jar-with-dependencies.jar

```bash
mvn clean install
```

Once jar generated you can use windows command line to run it :

```bash
java -jar poker-hand-1.0-SNAPSHOT-jar-with-dependencies.jar
```