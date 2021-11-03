package com.example.rxjavaobservable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import io.reactivex.rxjava3.subjects.AsyncSubject;
import io.reactivex.rxjava3.subjects.BehaviorSubject;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.ReplaySubject;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


         coledObservable();
         connectableobservable();
         publishSubject();
         behaviorSubject();
         replaySubject();
         asyncSubject();

    }


     //cold observable example
    private void coledObservable(){
        Observable<Long> cold = Observable.intervalRange(0 , 5 , 0 , 1 , TimeUnit.SECONDS);
        cold.subscribe(i-> Log.d(TAG, "onCreate: student A "+i));
        sleep();
        cold.subscribe(i-> Log.d(TAG, "onCreate: student B "+i));
    }

    // connectable observable example
    //chenage cold observable to Hot observable(connectable observable)
    private void connectableobservable(){
        ConnectableObservable<Long> cold = ConnectableObservable.intervalRange(0 , 5 , 0 , 1 , TimeUnit.SECONDS).publish();
        cold.connect();
        cold.subscribe(i-> Log.d(TAG, "onCreate: student A "+i));
        sleep();
        cold.subscribe(i-> Log.d(TAG, "onCreate: student B "+i));
    }

    private void sleep(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
// it's observer takes care of the first information after his arrival
    private void publishSubject(){

        PublishSubject<String> subject = PublishSubject.create();
        subject.subscribe(i-> Log.d(TAG, "publishSubject: Student First "+i));
        subject.onNext("A");
        sleep(1000);
        subject.onNext("B");
        sleep(1000);
        subject.onNext("C");
        sleep(1000);
        subject.onNext("D");
        sleep(1000);
        subject.subscribe(i-> Log.d(TAG, "publishSubject: Student Second "+i));
        subject.onNext("E");
        sleep(1000);
        subject.onNext("F");
        sleep(1000);
        subject.onNext("G");
        sleep(1000);
        subject.onNext("H");
        sleep(1000);
    }
// it's observer takes care of the last single information befor his arrival
    private void behaviorSubject(){

        BehaviorSubject<String> subject = BehaviorSubject.create();
            subject.subscribe(i-> Log.d(TAG, "publishSubject: Student First "+i));
            subject.onNext("A");
            sleep(1000);
            subject.onNext("B");
            sleep(1000);
            subject.onNext("C");
            sleep(1000);
            subject.onNext("D");
            sleep(1000);
            subject.subscribe(i-> Log.d(TAG, "publishSubject: Student Second "+i));
            subject.onNext("E");
            sleep(1000);
            subject.onNext("F");
            sleep(1000);
            subject.onNext("G");
            sleep(1000);
            subject.onNext("H");
            sleep(1000);
    }
// it's observer takes care all of stream
    private void replaySubject(){

        ReplaySubject<String> subject = ReplaySubject.create();
        subject.subscribe(i-> Log.d(TAG, "publishSubject: Student First "+i));
        subject.onNext("A");
        sleep(1000);
        subject.onNext("B");
        sleep(1000);
        subject.onNext("C");
        sleep(1000);
        subject.onNext("D");
        sleep(1000);
        subject.subscribe(i-> Log.d(TAG, "publishSubject: Student Second "+i));
        subject.onNext("E");
        sleep(1000);
        subject.onNext("F");
        sleep(1000);
        subject.onNext("G");
        sleep(1000);
        subject.onNext("H");
        sleep(1000);
    }
// it's observer takes care of the last single information in stream
    private void asyncSubject(){

        AsyncSubject<String> subject = AsyncSubject.create();
        subject.subscribe(i-> Log.d(TAG, "publishSubject: Student First "+i));
        subject.onNext("A");
        sleep(1000);
        subject.onNext("B");
        sleep(1000);
        subject.onNext("C");
        sleep(1000);
        subject.onNext("D");
        sleep(1000);
        subject.subscribe(i-> Log.d(TAG, "publishSubject: Student Second "+i));
        subject.onNext("E");
        sleep(1000);
        subject.onNext("F");
        sleep(1000);
        subject.onNext("G");
        sleep(1000);
        subject.onNext("H");
        sleep(1000);
        subject.onComplete();
    }

    private void sleep(int i){
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}