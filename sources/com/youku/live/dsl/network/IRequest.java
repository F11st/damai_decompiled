package com.youku.live.dsl.network;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface IRequest {

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface Scheduler {
        public static final String ASYNC_SCHEDULER = "ASYNC_SCHEDULER";
        public static final String MAIN_SCHEDULER = "MAIN_SCHEDULER";
    }

    IRequest async(IRequestCallback iRequestCallback);

    IRequest async(IRequestCallback iRequestCallback, IRequestCallback iRequestCallback2);

    <Model extends Serializable> IRequest async(IRequestModelCallback<Model> iRequestModelCallback);

    <Model extends Serializable> IRequest async(IRequestModelCallback<Model> iRequestModelCallback, IRequestModelCallback<Model> iRequestModelCallback2);

    void cancel();

    IRequest postCallbackOn(String str);

    IRequest sync(IRequestCallback iRequestCallback);

    IRequest sync(IRequestCallback iRequestCallback, IRequestCallback iRequestCallback2);
}
