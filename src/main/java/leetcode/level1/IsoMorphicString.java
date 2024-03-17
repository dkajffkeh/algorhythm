package leetcode.level1;

import common.QuestionExecutor;
import common.trigger.TestCaseInjectionTrigger;

import java.util.HashMap;
import java.util.Map;

public class IsoMorphicString implements TestCaseInjectionTrigger {

    @Override
    public void trigger() {
        System.out.println(isIsomorphic("egg","add"));
        System.out.println(isIsomorphic("foo","bar"));
        System.out.println(isIsomorphic("paper","title"));
    }

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> isomorphicStringMap = new HashMap<>();
        char [] sChars = s.toCharArray();
        char [] tChars = t.toCharArray();

        for(int i = 0; i<s.length(); i++){

            if(isomorphicStringMap.containsKey(sChars[i])) {
                if(isomorphicStringMap.get(sChars[i]) != tChars[i]) return false;
            }

            if(isomorphicStringMap.containsValue(tChars[i])) {
                if(!isomorphicStringMap.containsKey(sChars[i])) return false;
            }

            isomorphicStringMap.put(sChars[i],tChars[i]);
        }
        return true;
    }
}
