package qyy.test.rxjava;

import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @description: 这是代码里唯一的注释
 * @author: QinYong
 * @create: 2020-04-22 14:23
 **/
public class TestSlidingWindow {

    @Test
    public void test1(){
        String s = "AD0BFRSACABC";
        String t = "RA";

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        char[] array = s.toCharArray();
        for (char c:t.toCharArray())
            need.put(c,need.getOrDefault(c,0)+1);
        int left=0,right=0;
        int valid = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;
        while (right<s.length()){
            char tmp = array[right++];
            if(need.containsKey(tmp)){
                window.put(tmp, window.getOrDefault(tmp, 0) + 1);
                if(need.get(tmp).equals(window.get(tmp)))valid++;
            }
            while (valid == need.size()){
                if(right-left<len){
                    start = left;
                    len = right-left;
                }
                char ss = array[left++];
                if(need.containsKey(ss)){
                    if(need.get(ss).equals(window.get(ss))){
                        valid--;
                    }
                    window.computeIfPresent(ss,(character, integer) -> --integer);
                }
            }
        }
        System.out.println(len==Integer.MAX_VALUE?"":s.substring(start,start+len));
    }
    @Test
    public void test4(){
        String str = "sadfadacdswery";
        String tar = "yc";
        System.out.println(test5(str,tar));
    }

    public boolean test5(String str,String tar){

        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();
        for(char ch:tar.toCharArray())need.put(ch,need.getOrDefault(ch,0)+1);
        int left = 0 ;
        int right = 0 ;
        int start = 0 ;
        int valid = 0 ;
        int len = str.length();
        while (right < len){
            char tmp = str.charAt(right++);
            if(need.containsKey(tmp)){
                window.put(tmp,window.getOrDefault(tmp,0)+1);
                if(need.get(tmp).equals(window.get(tmp)))valid++;
            }
            while (right-left>=tar.length()){
                if(valid==need.size()){
                    return true;
                }
                char c = str.charAt(left++);
                if(need.containsKey(c)){
                    if(window.get(c).equals(need.get(c)))valid--;
                    window.computeIfPresent(c,(character, integer) -> --integer);
                }
            }
        }
        return false;
    }
    @Test
    public void test2(){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("java",20);
        map.put("c++",10);
        map.put("c#",30);
        System.out.println(map);
        map.computeIfPresent("java", (a, b) -> --b);
        map.computeIfAbsent("rust", String::length);
        System.out.println(map);
    }

    @Test
    public void test(){
        System.out.println(LocalDateTime.now());
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
    }

    @Test
    public void test10(){
        String str = "bbbbbCbbb";
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int res_len = 0;

        while (right<str.length()){
            char c = str.charAt(right++);
            window.put(c, window.getOrDefault(c, 0) + 1);
            while (window.get(c)>1){
                char at = str.charAt(left++);
                window.computeIfPresent(at, (character, integer) -> --integer);
            }
            res_len = Integer.max(res_len, right - left);
        }
        System.out.println("the max value is -> "+res_len);

    }

    @Test
    public void test212(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:00:00");
        String start = now.format(formatter);
        String end = now.plusHours(12).format(formatter);
        //LocalDateTime plus = now.plus(12, ChronoUnit.HOURS);
        System.out.println(start);
        System.out.println(end);
    }

    @Test
    public void  _test(){
        //nodes that waited for expanding
        Queue<Integer> queue = new LinkedList<>();
        //nodes that has visited
        Set<Integer> visited = new HashSet<>();
        int step = 1;
        while (!queue.isEmpty()){
            for (int i=0;i<queue.size();i++){
                if(queue.poll()==0){
                    //if poll node is target,then return step
                    //return step;
                }
                //add neighbor node
            }
            step++;
        }
        //return step;

    }

}
