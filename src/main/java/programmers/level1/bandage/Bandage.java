package programmers.level1.bandage;

import common.trigger.TestCaseInjectionTrigger;
import java.util.HashMap;
import java.util.Map;

public class Bandage implements TestCaseInjectionTrigger {

    @Override
    public void trigger() {
//        int result = solution(
//                new int[]{5, 1, 5},
//                30,
//                new int[][]{new int[]{2,10}, new int[]{9,15}, new int[]{10,5}, new int[]{11,5}}
//        );
//        System.out.println(result);
//        int result2 = solution(
//                new int[]{4, 2, 7},
//                20,
//                new int[][]{new int[]{1,15}, new int[]{5,16}, new int[]{8,6}}
//        );
//        System.out.println(result2);
        int result4 = solution(
                new int[]{1, 1, 1},
                5,
                new int[][]{new int[]{1, 2}, new int[]{3, 2}}
        );
        System.out.println(result4);
    }

    public int solution(int[] bandage, int health, int[][] attacks) {
        BandageEffect bandageEffect = new BandageEffect(bandage[0], bandage[1], bandage[2]);
        Character character = new Character(health, health);
        Attack attack = new Attack(attacks);
        int lastTurn = attacks[attacks.length - 1][0];

        for (int turn = 1; turn <= lastTurn; turn++) {

            if (attack.isMonsterAttack(turn)) {
                character.attacked(attack.damageByTurn(turn));
                bandageEffect.resetTurn();
            }

            if (character.isCharacterDead()) {
                return -1;
            }

            if (!attack.isMonsterAttack(turn)) {
                bandageEffect.heal(character);
            }

        }
        return character.currentHealth;
    }

    private static class Attack {

        private final Map<Integer, Integer> attackMap = new HashMap<>();

        public Attack(int[][] attacks) {
            for (int[] attack : attacks) {
                attackMap.put(attack[0], attack[1]);
            }
        }

        public boolean isMonsterAttack(int turn) {
            return attackMap.containsKey(turn);
        }

        public int damageByTurn(int turn) {
            return attackMap.getOrDefault(turn, 0);
        }
    }

    private static class Character {

        int maxHealth;
        int currentHealth;

        public Character(int maxHealth, int currentHealth) {
            this.maxHealth = maxHealth;
            this.currentHealth = currentHealth;
        }

        public void attacked(int damage) {
            this.currentHealth -= damage;
        }

        public void healed(int healCount) {
            if (isMaxCure(healCount)) {
                this.currentHealth = this.maxHealth;
                return;
            }
            this.currentHealth += healCount;
        }

        private boolean isMaxCure(int healCount) {
            return this.currentHealth + healCount >= this.maxHealth;
        }

        public boolean isCharacterDead() {
            return currentHealth <= 0;
        }
    }

    private static class BandageEffect {

        private int castingTime;
        private int recoveryCount;
        private int extraRecovery;

        private int turn;

        public BandageEffect(int castingTime, int recoveryCount, int extraRecovery) {
            this.castingTime = castingTime;
            this.recoveryCount = recoveryCount;
            this.extraRecovery = extraRecovery;
        }

        public void turnContinue() {
            this.turn++;
        }

        public void resetTurn() {
            this.turn = 0;
        }

        public void heal(Character character) {
            turnContinue();
            if (this.turn == this.castingTime) {
                character.healed(extraRecovery + recoveryCount);
                resetTurn();
            } else {
                character.healed(recoveryCount);
            }
        }
    }

}
