package com.alibaba.pictures.bricks.component.project.bean;

import android.os.Handler;
import android.os.SystemClock;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class Daojishi implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = -8016485049514819227L;
    private boolean autoStart;
    public long diffTime;
    private boolean isStarted;
    private Handler mHandler;
    private List<DaojishiListener> mListener;
    private Runnable mRunnable;
    public long serverTime;

    public Daojishi() {
        this.serverTime = 0L;
        this.diffTime = 0L;
        this.isStarted = false;
        this.autoStart = false;
        this.mListener = new ArrayList();
        this.mRunnable = new Runnable() { // from class: com.alibaba.pictures.bricks.component.project.bean.Daojishi.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-716044961")) {
                    ipChange.ipc$dispatch("-716044961", new Object[]{this});
                } else if (Daojishi.this.mHandler != null && Daojishi.this.mListener != null) {
                    Daojishi.this.mHandler.postDelayed(this, 1000L);
                    for (int i = 0; i < Daojishi.this.mListener.size(); i++) {
                        if (Daojishi.this.mListener.get(i) != null) {
                            ((DaojishiListener) Daojishi.this.mListener.get(i)).updateView();
                        }
                    }
                }
            }
        };
    }

    public void addTimer(DaojishiListener daojishiListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1370777800")) {
            ipChange.ipc$dispatch("1370777800", new Object[]{this, daojishiListener});
            return;
        }
        if (this.mListener == null) {
            this.mListener = new ArrayList();
        }
        if (!this.mListener.contains(daojishiListener)) {
            this.mListener.add(daojishiListener);
        }
        if (this.autoStart) {
            autoStartAndStop();
        }
    }

    public void autoStartAndStop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1655909843")) {
            ipChange.ipc$dispatch("-1655909843", new Object[]{this});
            return;
        }
        List<DaojishiListener> list = this.mListener;
        if (list != null && !list.isEmpty()) {
            startTimer();
        } else {
            stopTimer();
        }
    }

    public boolean isStarted() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2075662948") ? ((Boolean) ipChange.ipc$dispatch("2075662948", new Object[]{this})).booleanValue() : this.isStarted;
    }

    public void removeTimer(DaojishiListener daojishiListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-374910975")) {
            ipChange.ipc$dispatch("-374910975", new Object[]{this, daojishiListener});
            return;
        }
        List<DaojishiListener> list = this.mListener;
        if (list != null && daojishiListener != null) {
            list.remove(daojishiListener);
        }
        autoStartAndStop();
    }

    public void setServiceTimeAndDiff(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1820056087")) {
            ipChange.ipc$dispatch("-1820056087", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.serverTime = j;
        this.diffTime = j - SystemClock.elapsedRealtime();
        this.mListener.clear();
    }

    public void startTimer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "749527696")) {
            ipChange.ipc$dispatch("749527696", new Object[]{this});
        } else if (this.isStarted) {
        } else {
            stopTimer();
            if (this.mHandler == null) {
                Handler handler = new Handler();
                this.mHandler = handler;
                handler.postDelayed(this.mRunnable, 0L);
            }
            this.isStarted = true;
        }
    }

    public void stopTimer() {
        Runnable runnable;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1777272204")) {
            ipChange.ipc$dispatch("-1777272204", new Object[]{this});
            return;
        }
        Handler handler = this.mHandler;
        if (handler != null && (runnable = this.mRunnable) != null) {
            handler.removeCallbacks(runnable);
            this.mHandler = null;
        }
        this.isStarted = false;
    }

    public void setServiceTimeAndDiff(long j, long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-587133445")) {
            ipChange.ipc$dispatch("-587133445", new Object[]{this, Long.valueOf(j), Long.valueOf(j2)});
            return;
        }
        this.serverTime = j;
        this.diffTime = j2;
        this.mListener.clear();
    }

    public Daojishi(boolean z) {
        this.serverTime = 0L;
        this.diffTime = 0L;
        this.isStarted = false;
        this.autoStart = false;
        this.mListener = new ArrayList();
        this.mRunnable = new Runnable() { // from class: com.alibaba.pictures.bricks.component.project.bean.Daojishi.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-716044961")) {
                    ipChange.ipc$dispatch("-716044961", new Object[]{this});
                } else if (Daojishi.this.mHandler != null && Daojishi.this.mListener != null) {
                    Daojishi.this.mHandler.postDelayed(this, 1000L);
                    for (int i = 0; i < Daojishi.this.mListener.size(); i++) {
                        if (Daojishi.this.mListener.get(i) != null) {
                            ((DaojishiListener) Daojishi.this.mListener.get(i)).updateView();
                        }
                    }
                }
            }
        };
        this.autoStart = z;
    }
}
