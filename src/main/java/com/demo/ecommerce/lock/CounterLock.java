package com.demo.ecommerce.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CounterLock {

    private long count = 0;

    private Lock lock = new ReentrantLock();

    public void inc(){
        try{
            // HACE EL BLOQUEO Y SUMA EL CONTADOR
            lock.lock();

            this.count ++;
        }finally {
            //EL DESBLOQUEO SE HACE EN UN "finally" POR QUE SI LLEGA
            //A SALTAR UNA EXCEPCION SE PUEDE DESBLOQUEAR
            //Y NO DEJAR EL PROCESO PERMANENTEMENTE BLOQUEADO
            //CUANDO FINALIZA SE DESBLOQUEA
            lock.unlock();
        }
    }

    // ACA HACEMOS LO MISMO, CUANDO LO LLAMAMOS
    //SE BLOQUEA, SE SUMA AL CONTADOR Y SE VUELVE A DESBLOQUEAR
    public long getCount(){
        try{
            lock.lock();
            return this.count;
        }finally {

            lock.unlock();
        }
    }
}
