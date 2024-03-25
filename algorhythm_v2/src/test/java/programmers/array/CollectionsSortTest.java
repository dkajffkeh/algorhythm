package programmers.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;


public class CollectionsSortTest {

    @Test
    void integersSort() {
        List<Integer> integers = new ArrayList<>();
        integers.add(5);
        integers.add(4);
        integers.add(3);
        integers.add(2);
        integers.add(1);
        System.out.println(integers);
        Collections.sort(integers);
        System.out.println(integers);
    }

    @Test
    void StringSort() {
        List<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("a");
        strings.add("apeter");
        strings.add("cheers");
        strings.add("aaa");
        strings.add("vector");
        System.out.println(strings);
        Collections.sort(strings);
        System.out.println(strings);

    }

    @Test
    void ObjectSort() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("가가가",11));
        persons.add(new Person("가니니",21));
        persons.add(new Person("나나나",13));
        persons.add(new Person("다다다",14));
        persons.add(new Person("마마마",15));
        persons.add(new Person("라라라",15));
        System.out.println(persons);
        Collections.sort(persons);
        System.out.println(persons);
    }


    private static class Person implements Comparable<Person> {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return  "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        public int compareTo(Person otherPerson) {
            int ageComparison = Integer.compare(this.age, otherPerson.age);

            if (ageComparison != 0) {
                return ageComparison;
            }

            return this.name.compareTo(otherPerson.name);
        }
    }
}
