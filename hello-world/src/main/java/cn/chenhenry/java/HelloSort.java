package cn.chenhenry.java;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HelloSort {
}


class Entry {
    private int value;

    public Entry(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Entry of(int value) {
        return new Entry(value);
    }

    @Override
    public String toString() {
        return "Entry(" + value + ")";
    }
}


/**
 * stream + lambda的方式
 */
class StreamWithLambda {
    public static void main(String[] args) {
        List<Entry> entries = Stream.of(1, 6, 2, 2, 7, 9, 2).map(Entry::of).collect(Collectors.toList());
        System.out.println(entries);

        System.out.println(entries.stream().sorted((a, b) -> a.getValue() - b.getValue()).collect(Collectors.toList()));
    }
}

/**
 * 使用Collections
 */
class CollectionsWithLambda {
    public static void main(String[] args) {
        List<Entry> entries = Stream.of(1, 6, 2, 2, 7, 9, 2).map(Entry::of).collect(Collectors.toList());
        System.out.println(entries);

        Collections.sort(entries, (a, b) -> a.getValue() - b.getValue());
        System.out.println(entries);
    }
}

/**
 * 如果规则很复杂, 涉及到了多个条件, 建议还是写个单独的comparator专门维护排序规则吧
 */
class WithComparator {
    private static Comparator<Entry> comparator = new Comparator<Entry>() {
        @Override
        public int compare(Entry o1, Entry o2) {
            return o1.getValue() - o2.getValue();
        }
    };
    public static void main(String[] args) {
        List<Entry> entries = Stream.of(1, 6, 2, 2, 7, 9, 2).map(Entry::of).collect(Collectors.toList());
        System.out.println(entries);

        System.out.println(entries.stream().sorted(comparator).collect(Collectors.toList()));
    }
}


/**
 * 多个条件排序也可以用Comparator.comparing.thenComparing的形式
 */
class MultiField {
    private static class BiEntry {
        private int value1;
        private int value2;

        BiEntry(int v1, int v2) {
            value1 = v1;
            value2 = v2;
        }

        public int getValue1() {
            return value1;
        }

        public int getValue2() {
            return value2;
        }

        static BiEntry of(int v1, int v2) {
            return new BiEntry(v1, v2);
        }

        @Override
        public String toString() {
            return "BiEntry(" + value1 + "," + value2 + ")";
        }
    }

    public static void main(String[] args) {
        List<BiEntry> biEntries = Stream.of(
                BiEntry.of(1, 4), BiEntry.of(3, 1), BiEntry.of(1, 5),
                BiEntry.of(3, 2), BiEntry.of(1, 9), BiEntry.of(3, 0))
                .collect(Collectors.toList());
        System.out.println(biEntries);

        System.out.println(
                biEntries.stream().sorted(
                        Comparator.comparing(BiEntry::getValue1)
                                .thenComparing(BiEntry::getValue2))
                        .collect(Collectors.toList()
        ));
    }
}
