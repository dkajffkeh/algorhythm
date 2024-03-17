package stream;

import java.util.Arrays;
import java.util.List;

public class StreamTest {

    public static void main(String[] args) {
        List<TestClass> testClasses = Arrays.asList(new TestClass("a"), new TestClass("b"));
        for (TestClass testClass : testClasses) {
            testClass = new TestClass("d");
        }
        System.out.println(testClasses);
    }

    public static <T> void  collectionUtil(List<T> list, T object) {
        list.add(object);
    }

    public static void updateTestA(TestClass testClass) {
        testClass = new TestClass("bbb");
    }

    public static class TestClass {
        private String a;

        public TestClass(String a) {
            this.a = a;
        }

        public void setA(String a) {
            this.a = a;
        }

        public String getA() {
            return a;
        }
    }

}
