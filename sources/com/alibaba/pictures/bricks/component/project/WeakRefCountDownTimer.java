package com.alibaba.pictures.bricks.component.project;

import android.os.CountDownTimer;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class WeakRefCountDownTimer extends CountDownTimer {
    private static transient /* synthetic */ IpChange $ipChange;
    private WeakReference<OnTickListener> a;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface OnTickListener {
        void onFinish();

        void onTick(long j);
    }

    public WeakRefCountDownTimer(long j, long j2, OnTickListener onTickListener) {
        super(j, j2);
        this.a = new WeakReference<>(onTickListener);
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1629305198")) {
            ipChange.ipc$dispatch("1629305198", new Object[]{this});
            return;
        }
        OnTickListener onTickListener = this.a.get();
        if (onTickListener != null) {
            onTickListener.onFinish();
        }
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1137709088")) {
            ipChange.ipc$dispatch("1137709088", new Object[]{this, Long.valueOf(j)});
            return;
        }
        OnTickListener onTickListener = this.a.get();
        if (onTickListener != null) {
            onTickListener.onTick(j);
        } else {
            cancel();
        }
    }
}
