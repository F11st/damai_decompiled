package com.taobao.phenix.loader.network;

import java.util.Map;
import java.util.concurrent.Future;
import tb.p22;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface HttpLoader {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface FinishCallback {
        void onError(Exception exc);

        void onFinished(p22 p22Var);
    }

    void connectTimeout(int i);

    Future<?> load(String str, Map<String, String> map, FinishCallback finishCallback);

    void readTimeout(int i);
}
