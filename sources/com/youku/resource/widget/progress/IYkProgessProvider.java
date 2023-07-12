package com.youku.resource.widget.progress;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface IYkProgessProvider {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface ProgressListener {
        void onComplete();

        void onFailed(String str);

        void updateProgress(int i);
    }

    void start(ProgressListener progressListener);
}
