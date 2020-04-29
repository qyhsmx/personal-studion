package qyy.test.rxjava;

import io.reactivex.rxjava3.core.*;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * @description: 这是代码里唯一的注释
 * @author: QinYong
 * @create: 2019-12-31 09:18
 **/
public class TestRx {

    @Test
    public void test1(){
        Observable.create(observableEmitter -> {
            while (!observableEmitter.isDisposed()){
                try {
                    TimeUnit.SECONDS.sleep(2);
                }catch (Exception e){
                    e.printStackTrace();
                }
                long millis = System.currentTimeMillis();
                observableEmitter.onNext(millis);
                if(millis%2!=0){
                    //observableEmitter.onError(new IllegalStateException("odd millisecond"));
                    observableEmitter.onNext("odd time");
                }
            }
        }).subscribe(System.out::println,Throwable::printStackTrace);

    }
    @Test
    public void test2()throws Exception{
        Flowable.fromCallable(()->{
            TimeUnit.SECONDS.sleep(2);
            return "success";
        }).subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(System.out::println,Throwable::printStackTrace);
        TimeUnit.SECONDS.sleep(3);

    }
    @Test
    public void test3()throws Exception{

        Flowable.range(1,10)
                .flatMap(v-> Flowable.just(v).subscribeOn(Schedulers.computation()).map(val -> Math.pow(val,3)))
                .sorted(Double::compareTo)
                .blockingSubscribe(System.out::println);

    }
    @Test
    public void test4()throws Exception{
        Flowable.range(1,10)
                .parallel()
                .runOn(Schedulers.computation())
                .map(v->v*v)
                .sequential()
                .sorted()
                .blockingSubscribe(System.out::println);

    }
    @Test
    public void test5()throws Exception{
       String[] arr = {"Hello","World"};
//        List<String[]> collect = Arrays.stream(arr).map(v -> v.split(""))
//                .collect(Collectors.toList());

        Stream.of("hello", "word")
                .map(v -> v.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .sorted()
                .forEach(System.out::print);

    }
    @Test
    public void test6()throws Exception{
       String[] arr = {"Hello","World"};
       Flowable.fromArray(arr)
               .map(s -> s.split(""))
               .flatMap(Flowable::fromArray)
               .distinct()
               .forEach(System.out::print);
    }
    @Test
    public void test7()throws Exception{
        AtomicInteger count = new AtomicInteger();

        Observable.range(1, 10)
                .doOnNext(ignored -> count.incrementAndGet())
                .ignoreElements()
                //.andThen(Single.defer(()->Single.just(count.get())))
                .andThen(Single.fromCallable(count::get))
                .subscribe(System.out::println);
    }
    @Test
    public void test111(){
        System.out.println( LocalDate.parse("2020-04-03").plusDays(-7));
    }




}
