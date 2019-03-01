package com.karan.github.sdk;


import com.google.auto.value.AutoValue;
import com.karan.github.sdk.executor.PostExecutionThread;
import com.karan.github.sdk.executor.ThreadExecutor;

import io.reactivex.Observable;

public class GitHubRepositoryByUseCase extends UseCase<String> {

    Param param;

    GitHubRepositoryByUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
    }

    @Override
    public Observable<String> build() {
        return Observable.fromArray(new String[]{"hi","hello"});
    }

    @AutoValue
    public abstract static class Param {
        public abstract String username();

        public static Builder builder(){
            return new AutoValue_GitHubRepositoryByUseCase_Param.Builder();
        }

        @AutoValue.Builder
        public abstract static class Builder
        {
            public abstract Builder username (String username);

            public abstract Param build();
        }
    }
}
