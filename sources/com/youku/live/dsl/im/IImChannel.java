package com.youku.live.dsl.im;

import android.app.Activity;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface IImChannel {
    void checkRedPointWithSomeOne(String str, RedPointCallBack redPointCallBack);

    void registerListener(Activity activity, RedPointCallBack redPointCallBack);

    void unRegisterListener();
}
