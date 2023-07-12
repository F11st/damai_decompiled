package com.taobao.update.adapter;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface ThreadExecutor {
    void delayExecute(Runnable runnable, int i);

    void execute(Runnable runnable);
}
