package luck;

import org.junit.jupiter.api.Test;

public class LuckCalculator {

    @Test
    void safeCalculator() {
        double interestRate = 0.08;
        double money = 1000;
        for (int i = 1; i <= 80; i ++) {
            money = money + (money * interestRate);
            money += 100;
        }

        System.out.println(money);
    }

    @Test
    void damageTest() {
        double money = 100000;
        double moneyGun = 0.0077;

        System.out.println(money * moneyGun);
    }
}
