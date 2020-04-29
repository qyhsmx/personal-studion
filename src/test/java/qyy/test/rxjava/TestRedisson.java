package qyy.test.rxjava;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.*;

/**
 * @description: 这是代码里唯一的注释
 * @author: QinYong
 * @create: 2020-04-28 14:17
 **/
public class TestRedisson {

    @Test
    public void test(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService1 = Executors.newFixedThreadPool(10);
        ScheduledExecutorService executorService2 = Executors.newScheduledThreadPool(3);
        ExecutorService executorService3 = Executors.newSingleThreadExecutor();
    }
    @Test
    public void test1(){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                10
                , 100
                , 100L
                , TimeUnit.SECONDS
                , new SynchronousQueue<>()
                , r -> new Thread(r)
                , new ThreadPoolExecutor.CallerRunsPolicy());
    }

    @Test
    public void test2(){
        SynchronousQueue<Object> objects = new SynchronousQueue<>();
        LinkedBlockingDeque<Object> objects1 = new LinkedBlockingDeque<>();
        ArrayBlockingQueue<Object> objects2 = new ArrayBlockingQueue<>(10);

    }

    @Test
    public void test3(){
        List<Integer> coins = new ArrayList<>();
        coins.add(3);
        coins.add(1);
        coins.add(5);
        int amount = 10;
        System.out.println(dp(coins,amount));

    }
    public int dp(List<Integer> coins,int sum){
        if(sum == 0)return 0;
        if(sum < 0)return -1;
        int min = Integer.MAX_VALUE;
        for (int coin:coins){
            int dp = dp(coins, sum - coin);
            if(dp==-1)continue;
            min = Math.min(min,1+dp);
        }
        return min;
    }

    @Test
    public void test11(){
        char[] arr = {'h','e','l','l','o'};
        Stack<Character> stack = new Stack<>();
        for(char c : arr){
            stack.push(c);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void test12(){
        String S = "aabcccccaa";
        Map<Character,Integer> map = new LinkedHashMap<>();
        for(int i=0;i<S.length();i++)
        {
            char c = S.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character,Integer> t:map.entrySet())
        {
            sb.append(t.getKey());
            sb.append(t.getValue());
        }
        System.out.println(sb.toString());
    }

    @Test
    public void test_1(){

    }
    @Test
    public void test_2(){
        String word = "you are very beautiful";
        String[] split = word.split(" ");
        int i = 0;
        int j = split.length-1;
        while (i < j){
            String temp = split[i];
            split[i++] = split[j];
            split[j--] = temp;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : split){
            sb.append(str).append(" ");
        }
        System.out.println(sb.toString().trim());

    }
    @Test
    public void test_3(){
        String str = "abcvdfasdddee";
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray())
        {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int max = 0;
        char tmp = 'c';
        for (Map.Entry<Character,Integer> entry:map.entrySet())
        {
            if(max<entry.getValue()){
                max = entry.getValue();
                tmp = entry.getKey();
            }
        }
        System.out.println(tmp+" "+max);
    }

    @Test
    public void test_4(){
        int a = 66;
        int b = 56;
        String num1 = "16";
        String num2 = "11";
        a = toRDecimal(num1);
        b = toRDecimal(num2);
        System.out.println(toDecimal(a+b));

    }
    public int toRDecimal(String num){
        int res = 0;
        int len = num.length();
        String[] arr = num.split("");
        for (int i=0;i<num.length();i++)
        {
            res += Math.pow(7, len - i - 1)*Integer.parseInt(arr[i]);
        }
        return res;
    }
    public int toDecimal(int a){
        int t = a;
        StringBuilder sb = new StringBuilder();
        while (t>0){
            sb.append(t%7);
            t = t/7;
        }
        return Integer.parseInt(sb.reverse().toString());
    }

    @Test
    public void test_5(){
        String s = convertToBase7(21);
        System.out.println(s);
        System.out.println((char)('0'+0));
    }
    public String convertToBase7(int num) {
        String ans = "";
        if (num < 0) {
            num = -num;
            ans += "-";
        };
        StringBuilder sb = new StringBuilder();
        do {
            int mod = num % 7;
            sb.append((char)('0'+mod));
            num = num / 7;
        } while (num > 0);
        ans += sb.reverse().toString();
        return ans;

    }

    @Test
    public void test_6(){
        String str = "423234";
        String str1 = "123412";
        String s = "sadasdaaddee";
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if(window.containsKey(s.charAt(i))){
                left = Math.max(left,window.get(s.charAt(i))+1);
            }
            window.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        System.out.println(max);
        System.out.println(left);

    }
    @Test
    public void test_7(){
        String str1 = "423234";
        String str = "23234412";
        Stack<Integer> stack = new Stack<>();
        String[] array = str.split("");
        for (int i=0;i<str.length();i++)
        {
            int tmp = Integer.parseInt(array[i]);
            if(stack.isEmpty() || !stack.contains(tmp))
            {
                stack.push(tmp);
            }
            else {
                if(stack.peek()<tmp && str.substring(i).contains(stack.peek().toString())) stack.pop();
            }

        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop());
        System.out.println(sb.reverse().toString());
    }

    @Test
    public void test_8(){
        // a = 1
    }


}
