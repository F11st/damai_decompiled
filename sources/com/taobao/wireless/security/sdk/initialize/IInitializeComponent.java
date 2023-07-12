package com.taobao.wireless.security.sdk.initialize;

import android.content.Context;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface IInitializeComponent {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface IInitFinishListener {
        void onError();

        void onSuccess();
    }

    int initialize(Context context);

    void initializeAsync(Context context);

    boolean isSoValid(Context context);

    void loadLibraryAsync(Context context);

    void loadLibraryAsync(Context context, String str);

    int loadLibrarySync(Context context);

    int loadLibrarySync(Context context, String str);

    void registerInitFinishListener(IInitFinishListener iInitFinishListener);

    void unregisterInitFinishListener(IInitFinishListener iInitFinishListener);
}
