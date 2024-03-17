package hash;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class EqualsAndHashcodeTestClass {

    public static void main(String[] args) {

        final Person person1 = new Person(1L,"김종구",33L);
        final Person person2 = new Person(1L,"홍지운",31L);

        final String str1 = "test";
        final String str2 = "test";

        Set<Person> personSet = new HashSet<>();
        personSet.add(person1);
        personSet.add(person2);
        System.out.println(personSet.size());

    }

    public static class Person {
        private Long id;
        private String name;
        private Long age;

        public Person() {
        }

        public Person(Long id, String name, Long age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public Long getAge() {
            return age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person)) return false;
            Person person = (Person) o;
            return id.equals(person.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }
}