## IntervalMerger
Dieses Java-Projekt enthält eine Funktion "MergeInterval", die Intervalle merged.
- **Zeitaufwand**: ~2 Stunden
- **Laufzeit**: O(n log(n))
- **Speicher**: O(n)

##### Algorithmus
1. Sortieren
2. Den 1. Wert in den Ergebnis-Stack einfügen
3. Für jedes weitere Intervall-Element:
    - Wenn das Element nicht mit dem obersten Element des Ergebnis-Stacks überlappt, push auf den Stack
    - Wenn das Element mit dem obersten Element des Ergebnis-Stacks überlappt aktualisiere den Start- und End-Wert des obersten Elements des Ergebnis Stacks

### Build
WorkingDirectory = ProjectRoot/src
- `javac com/coding/task/Interval.java com/coding/task/MergeIntervals.java `

### Start
- `java com.coding.task.MergeIntervals`

### Test
Tests in `src/com/coding/task/mergeIntervalsTests.java`

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
