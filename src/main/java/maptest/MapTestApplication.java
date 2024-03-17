package maptest;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MapTestApplication {

    public static void main(String[] args) {

        Map<Cash, String> map = new HashMap<>();
        Cash five = new Cash(5);
        Cash ten = new Cash(10);
        Cash seven = new Cash(5);
        map.put(five,"five");
        map.put(ten,"ten");
        map.put(seven,"seven");
        System.out.println(map);
    }

    public static class Cash {
        private int dollars;

        public Cash(int dlr) {
            this.dollars = dlr;
        }

        public void setDollars(int dollars) {
            this.dollars = dollars;
        }

        public int getDollars() {
            return dollars;
        }

        public void mul(int factor) {
            this.dollars *= factor;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Cash cash = (Cash) o;
            return dollars == cash.dollars;
        }

        @Override
        public int hashCode() {
            return Objects.hash(dollars);
        }

        @Override
        public String toString() {
            return "Cash{" +
                    "dollars=" + dollars +
                    '}';
        }
    }

}
