package com.alibaba.android.onescheduler;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public interface OneDependentTask extends OneCommonTask {
    void after(OneDependentTask oneDependentTask);

    void removePredecessor(OneDependentTask oneDependentTask);

    void removeSuccessor(OneDependentTask oneDependentTask);
}
