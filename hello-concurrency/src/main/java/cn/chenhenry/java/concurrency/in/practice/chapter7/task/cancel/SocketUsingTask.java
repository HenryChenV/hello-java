package cn.chenhenry.java.concurrency.in.practice.chapter7.task.cancel;


import jdk.nashorn.internal.codegen.CompilerConstants;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.*;
import java.util.logging.SocketHandler;

interface CancellableTask<T> extends Callable<T> {
    void cancel();
    RunnableFuture<T> newTask();
}


class CancellingExecutor extends ThreadPoolExecutor {

    public CancellingExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        if (callable instanceof CancellableTask) {
            return ((CancellableTask<T>) callable).newTask();
        }
        return super.newTaskFor(callable);
    }
}


public abstract class SocketUsingTask<T> implements CancellableTask<T> {

    private Socket socket;

    protected synchronized void setSocket(Socket s) {
        socket = s;
    }

    @Override
    public synchronized void cancel() {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException ignored) {
            }
        }
    }

    @Override
    public RunnableFuture<T> newTask() {
        return new FutureTask<T>(this) {
            @Override
            public boolean cancel(boolean mayInterruptIfRunning) {
                SocketUsingTask.this.cancel();
                return super.cancel(mayInterruptIfRunning);
            }
        };
    }
}
