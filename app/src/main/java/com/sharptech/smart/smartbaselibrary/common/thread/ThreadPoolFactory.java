package com.sharptech.smart.smartbaselibrary.common.thread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @创建者 CSDN_LQR
 * @描述 线程池工厂
 */
public class ThreadPoolFactory {

    static ThreadPoolProxy mNormalPool;
    static ThreadPoolProxy mDownLoadPool;

    /**
     * 得到一个普通的线程池
     *
     * @return
     */
    public static ThreadPoolProxy getNormalPool() {
        if (mNormalPool == null) {
            synchronized (ThreadPoolFactory.class) {
                if (mNormalPool == null) {
                    mNormalPool = new ThreadPoolProxy(5, 5, 3000);
                }
            }
        }
        return mNormalPool;
    }

    /**
     * 得到一个下载的线程池
     *
     * @return
     */
    public static ThreadPoolProxy getDownLoadPool() {
        if (mDownLoadPool == null) {
            synchronized (ThreadPoolFactory.class) {
                if (mDownLoadPool == null) {
                    mDownLoadPool = new ThreadPoolProxy(3, 3, 3000);
                }
            }
        }
        return mDownLoadPool;
    }
    /**************************************默认线程池**********************************************/
    /**
     * 作用：该方法返回一个固定线程数量的线程池，该线程池中的线程数量始终不变，即不会再创建新的线程，
     * 也不会销毁已经创建好的线程，自始自终都是那几个固定的线程在工作，所以该线程池可以控制线程的最大并发数。
     *
     * @return
     */
    private static ExecutorService getFixedThreadPool(int nThread) {
        return Executors.newFixedThreadPool(nThread);
    }

    /**
     * 作用：该方法返回一个可以根据实际情况调整线程池中线程的数量的线程池。
     * 即该线程池中的线程数量不确定，是根据实际情况动态调整的。
     *
     * @return
     */
    private static ExecutorService getCachedThreadPool() {
        return Executors.newCachedThreadPool();
    }

    /**
     * 作用：该方法返回一个只有一个线程的线程池，即每次只能执行一个线程任务，
     * 多余的任务会保存到一个任务队列中，等待这一个线程空闲，
     * 当这个线程空闲了再按FIFO方式顺序执行任务队列中的任务。
     *
     * @return
     */
    private static ExecutorService getSingleThreadExecutor() {
        return Executors.newSingleThreadExecutor();
    }

    /**
     * 作用：该方法返回一个可以控制线程池内线程定时或周期性执行某任务的线程池。
     *
     * @return
     */
    private static ScheduledExecutorService getScheduledThreadPool(int corePoolSize) {
        return Executors.newScheduledThreadPool(corePoolSize);
    }

    /**
     * 作用：该方法返回一个可以控制线程池内线程定时或周期性执行某任务的线程池。
     * 只不过和上面的区别是该线程池大小为1，而上面的可以指定线程池的大小。
     *
     * @return
     */
    private static ScheduledExecutorService getSingleThreadScheduledExecutor() {
        return Executors.newSingleThreadScheduledExecutor();
    }


}
