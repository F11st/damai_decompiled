package com.youku.arch.beast;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.beast.messenger.Messenger;
import com.youku.arch.beast.messenger.MessengerImpl;
import com.youku.arch.beast.threading.WorkerFactory;
import com.youku.arch.beast.threading.WorkerThread;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class BeastZygote {
    private static transient /* synthetic */ IpChange $ipChange;
    private volatile Context mContext;
    private Messenger mMessenger;
    WorkerThread mThread;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    private static class SingletonInstance {
        private static final BeastZygote INSTANCE = new BeastZygote();

        private SingletonInstance() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public enum Type {
        VOD,
        LIVE
    }

    public static BeastZygote getInstance() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "824318747") ? (BeastZygote) ipChange.ipc$dispatch("824318747", new Object[0]) : SingletonInstance.INSTANCE;
    }

    public Messenger getMessenger() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1636024809") ? (Messenger) ipChange.ipc$dispatch("1636024809", new Object[]{this}) : this.mMessenger;
    }

    public void init(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "838235457")) {
            ipChange.ipc$dispatch("838235457", new Object[]{this, context});
            return;
        }
        this.mContext = context.getApplicationContext();
        this.mMessenger = new MessengerImpl(this.mContext);
        WorkerThread workerThread = WorkerFactory.get();
        this.mThread = workerThread;
        workerThread.setCorrespondingZygote(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setThread(WorkerThread workerThread) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1673497562")) {
            ipChange.ipc$dispatch("-1673497562", new Object[]{this, workerThread});
            return;
        }
        this.mThread = workerThread;
        workerThread.setCorrespondingZygote(this);
    }
}
