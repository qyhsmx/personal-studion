package com.qyy.test;

import com.qyy.test.util.CacheUtil;
import com.qyy.test.util.RedissonUtil;
import lombok.SneakyThrows;
import org.redisson.api.*;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @description: 这是代码里唯一的注释
 * @author: QinYong
 * @create: 2019-12-30 16:38
 **/
public class TestRedisson {

    private static int i = 0;

    public static void main1(String[] args) throws IOException {
        RedissonClient client = RedissonUtil.instance();
        RList<String> list = client.getList("list");
        list.add("11");
        list.add("11");
        list.add("11");
        System.out.println(list);
        RBucket<Map<String, String>> map = client.getBucket("testMap");
        map.set(new HashMap<>());
        RBinaryStream stream = client.getBinaryStream("ioStream");
        OutputStream outputStream = stream.getOutputStream();
        

    }

    public static void main11(String[] args) throws Exception{

        RedissonClient client = RedissonUtil.instance();

        RLock lock = client.getLock("concurrentLock");

        for (int j = 0; j < 10; j++) {
            new Thread(()->{
                while (true) {
                    boolean flag = lock.tryLock();
                    if (flag) {
                        System.out.println("获取锁的线程" + Thread.currentThread().getName());
                        try {
                            i++;
                            System.out.println(Thread.currentThread().getName()+" 正在干活");
                            TimeUnit.MILLISECONDS.sleep(100);
                            break;
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            System.out.println(Thread.currentThread().getName() + "已释放");
                            lock.unlock();
                        }
                    } else {
                        //System.out.println("当前已经被锁定，-> holdCount" + lock.getHoldCount());
                    }
                }
            }).start();
        }


    }


    private static CountDownLatch latch = new CountDownLatch(10);
    @SneakyThrows
    public static void main(String[] args) {
        RedissonClient client = RedissonUtil.instance();
        RSemaphore semaphore = client.getSemaphore("my");
        //RPermitExpirableSemaphore semaphore = client.getPermitExpirableSemaphore("test");
        //semaphore.addPermits(10);
        boolean b = semaphore.trySetPermits(5);
        System.out.println("outcome of trying to set permit -> "+b);
        ExecutorService service = Executors.newFixedThreadPool(10);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int j = 0; j < 10; j++) {
            service.execute(()->{
                askForResource(Thread.currentThread().getName(),semaphore);
                latch.countDown();
            });
        }
        latch.await();
        client.shutdown();
    }
    public static void askForResource(String thread,RSemaphore semaphore){
        if(semaphore.tryAcquire()){
            System.out.println("now "+ thread +" is  doing io , "+ semaphore.availablePermits() +" are available ");
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                semaphore.release();
            }
        }
        else {
            System.out.println("here we have too much request waiting for dealing, wait milliseconds ");
        }
    }
}
