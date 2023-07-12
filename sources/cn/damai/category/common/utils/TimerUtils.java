package cn.damai.category.common.utils;

import android.os.Handler;
import android.os.SystemClock;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class TimerUtils implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = -8016485049514819227L;
    private RecyclerView.Adapter mAdapter;
    private Handler mHandler;
    public long serverTime = 0;
    public long diffTime = 0;
    public int second = 0;
    private Runnable mRunnable = new Runnable() { // from class: cn.damai.category.common.utils.TimerUtils.1
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // java.lang.Runnable
        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1517528899")) {
                ipChange.ipc$dispatch("-1517528899", new Object[]{this});
            } else if (TimerUtils.this.mHandler == null || TimerUtils.this.mAdapter == null) {
            } else {
                TimerUtils.this.mHandler.postDelayed(this, 1000L);
                TimerUtils timerUtils = TimerUtils.this;
                timerUtils.second++;
                timerUtils.mAdapter.notifyDataSetChanged();
            }
        }
    };

    public void setServiceTimeAndDiff(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2020293195")) {
            ipChange.ipc$dispatch("2020293195", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.serverTime = j;
        this.diffTime = j - SystemClock.elapsedRealtime();
    }

    public void startTimer(RecyclerView.Adapter adapter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "849829850")) {
            ipChange.ipc$dispatch("849829850", new Object[]{this, adapter});
        } else if (adapter == null) {
        } else {
            stopTimer();
            if (this.mHandler == null) {
                this.mAdapter = adapter;
                Handler handler = new Handler();
                this.mHandler = handler;
                handler.postDelayed(this.mRunnable, 0L);
            }
        }
    }

    public void stopTimer() {
        Runnable runnable;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1343647442")) {
            ipChange.ipc$dispatch("1343647442", new Object[]{this});
            return;
        }
        Handler handler = this.mHandler;
        if (handler == null || (runnable = this.mRunnable) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
        this.mHandler = null;
        this.second = 0;
    }
}
