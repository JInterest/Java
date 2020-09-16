package leetcode.hash;

import java.util.*;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/07/25  11:14
 * @Description:字母异位词分组，给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串
 */
public class groupAnagrams {
    /**
     * 先排序然后比较是否存在
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length==0) return new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for (String s:strs
             ) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key= String.valueOf(chars);
            //map集合允许value为null 所以不应该用get方法判断key是否存在。
            if (!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }

    /**
     * 将每个字符串的字符与质数相乘作为key
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        //ascii: a:97 z:122
        List<List<String>> result = new ArrayList<>();
        if (strs.length == 0) return result;
        List<String> item;
        Map<Integer, List<String>> groups = new HashMap<>();
        int hash=0;

        for (String str : strs) {
            hash = getHash(str);
			//getOrDefault 如果存在就取对应value，不存在就取后面输入的那个值
            item = groups.getOrDefault(hash, new ArrayList<>());
            if (item.size() == 0) {
                groups.put(hash, item);
                result.add(item);
            }
            item.add(str);
        }

        return result;
    }

    private int getHash(String s) {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};// 26 primes
        int hash = 1;
        for (char c : s.toCharArray()) {
            hash *= primes[c - 'a'];
        }
        return hash;
    }
}
