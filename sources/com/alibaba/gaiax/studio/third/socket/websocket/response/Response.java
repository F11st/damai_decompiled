package com.alibaba.gaiax.studio.third.socket.websocket.response;

import com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.IResponseDispatcher;
import com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.ResponseDelivery;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public interface Response<T> {
    T getResponseData();

    void onResponse(IResponseDispatcher iResponseDispatcher, ResponseDelivery responseDelivery);

    void release();

    void setResponseData(T t);
}
