## IntervalMerger
Dieses Java-Projekt enthält eine Funktion "MergeInterval", die Intervalle merged.
- **Zeitaufwand**: ~2 Stunden
- **Laufzeit**: O(n log(n))
- **Speicher**: O(n)
- **Robustheit** bei einer großen Intervall-Liste: Hier könnte es Sinn machen, die Intervall-Liste zu splitten und die einzelnen Teile von externen Microservices mergen zu lassen.

## Lösungsansatz:
Es gibt 3 Möglichkeiten
1. Intervall überlappt nicht -> Weiter zum nächsten
2. Intervall überlappt -> merge beide Intervalle : start = kleinster Wert, ende = größter Wert
3. Intervall ist eingeschlossen -> der eingeschlossene Intervall wir ignoriert

##### Algorithmus
1. Sortieren
2. Den 1. Wert in den Ergebnis-Stack einfügen
3. Für jedes Intervall-Element:
    - Wenn das Element nicht mit dem obersten Element des Ergebnis-Stacks überlappt, push auf den Stack
    - Wenn das Element mit dem obersten Element des Ergebnis-Stacks überlappt aktualisiere den Start- und End-Wert des obersten Elements des Ergebnis Stacks

### Build

- `javac Interval.java Main.java `

### Start
- `java com.coding.task.Main`

### Beispiel
``` java
    List<Interval> intervals = Arrays.asList(
                new Interval(25, 30),
                new Interval(2, 19),
                new Interval(14, 23),
                new Interval(4, 8)
    );
    List<Interval> mergedIntervals = MergeIntervals(intervals);
    // will return [2,23][25,30]
```

### Lizenz
[MIT](https://choosealicense.com/licenses/mit/)
