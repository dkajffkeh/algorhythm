package solid;

import org.junit.jupiter.api.Test;

public class DependencyInversionCase {

    @Test
    void dependencyInversion() {

    }


    // 식당이 햄버거요리사를 의존한다.
    static class Restaurant {

        private final HamburgerChef chef;

        public Restaurant(HamburgerChef chef) {
            this.chef = chef;
        }

    }

    static class HamburgerChef implements Chef {


    }

    // 식당의 의존성 역전 원칙
    class RestaurantInversion {
        private final Chef chef;

        public RestaurantInversion(Chef chef) {
            this.chef = chef;
        }
    }


    interface Chef {

    }
}
