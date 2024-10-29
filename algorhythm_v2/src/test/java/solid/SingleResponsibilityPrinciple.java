package solid;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


public class SingleResponsibilityPrinciple {

    @Test
    @DisplayName("하나의 소스파일, 메서드, 클래스는 오직 하나의 액터에 대해서만 책임져야 한다.")
    void srpViolationCase() {

        Employee cfo = new Employee();
        Employee coo = new Employee();
        Employee cto = new Employee();

    }

    static class Employee {

        public int calculatePay() {
            return 1;
        }

        public void reportHours() {

        }

        public void save() {

        }
    }
}
