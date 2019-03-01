package com.karan.github.sdk;

import com.karan.github.sdk.executor.PostExecutionThread;
import com.karan.github.sdk.executor.ThreadExecutor;
import com.karan.github.sdk.helper.Preconditions;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public abstract class UseCase<T> {
    private final CompositeDisposable disposables;
    ThreadExecutor threadExecutor;
    PostExecutionThread postExecutionThread;

    UseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
        this.disposables = new CompositeDisposable();
    }

    public abstract Observable<T> build();
    

    public void dispose() {
        if (!disposables.isDisposed()) {
            disposables.dispose();
        }
    }

    public void execute(DisposableObserver<T> observer) {
        Preconditions.checkNotNull(observer);
        final Observable<T> observable = this.build()
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.getScheduler());
        addDisposable(observable.subscribeWith(observer));
    }

    private void addDisposable(Disposable disposable) {
        Preconditions.checkNotNull(disposable);
        Preconditions.checkNotNull(disposables);
        disposables.add(disposable);
    }
}
