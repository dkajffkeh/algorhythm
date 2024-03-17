package collection;

import java.util.ArrayList;
import java.util.List;

public class FirstObjectTest {

    public static void main(String[] args) {
        List<A> as = new ArrayList<>();
        as.add(new A("1"));
        as.add(new A("2"));
        As asa = new As(as);
        System.out.println(asa);
        as.get(1).setaValue("test");
        System.out.println(asa);
    }

    public static class A {

        private String aValue;

        public A(String aValue) {
            this.aValue = aValue;
        }

        public void setaValue(String aValue) {
            this.aValue = aValue;
        }

        @Override
        public String toString() {
            return "A{" +
                    "aValue='" + aValue + '\'' +
                    '}';
        }
    }

    public static class As {

        private final List<A> as;

        public As(List<A> as) {
            this.as = as;
        }

        @Override
        public String toString() {
            return "As{" +
                    "as=" + as +
                    '}';
        }
    }

}
