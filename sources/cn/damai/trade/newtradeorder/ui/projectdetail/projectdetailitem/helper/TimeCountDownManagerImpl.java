package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper;

import android.os.CountDownTimer;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.xv1;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class TimeCountDownManagerImpl implements ITimeCountDownManager {
    private static transient /* synthetic */ IpChange $ipChange;
    private CountDownTimerC2276b a;
    private long b;
    private OnTimeCountDownListener c;
    private OnTimeCountDownCallback d = new C2275a();

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    private interface OnTimeCountDownCallback {
        void onCountDownFinished();

        void onCountDownTip(long j);
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.TimeCountDownManagerImpl$a */
    /* loaded from: classes8.dex */
    public class C2275a implements OnTimeCountDownCallback {
        private static transient /* synthetic */ IpChange $ipChange;

        C2275a() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.TimeCountDownManagerImpl.OnTimeCountDownCallback
        public void onCountDownFinished() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1435275481")) {
                ipChange.ipc$dispatch("1435275481", new Object[]{this});
            } else if (TimeCountDownManagerImpl.this.c != null) {
                TimeCountDownManagerImpl.this.c.onCountDownFinished(TimeCountDownManagerImpl.this.b);
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.TimeCountDownManagerImpl.OnTimeCountDownCallback
        public void onCountDownTip(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-846257376")) {
                ipChange.ipc$dispatch("-846257376", new Object[]{this, Long.valueOf(j)});
            } else if (TimeCountDownManagerImpl.this.c != null) {
                String[] a = xv1.a(j);
                TimeCountDownManagerImpl.this.c.onCountDownTip(j, !TextUtils.isEmpty(a[0]) ? a[0] : "00", a[1], a[2], a[3]);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.TimeCountDownManagerImpl$b */
    /* loaded from: classes16.dex */
    public static class CountDownTimerC2276b extends CountDownTimer {
        private static transient /* synthetic */ IpChange $ipChange;
        private long a;
        private OnTimeCountDownCallback b;

        public CountDownTimerC2276b(long j, long j2, OnTimeCountDownCallback onTimeCountDownCallback) {
            super(1000 * j, j2);
            this.a = j;
            this.b = onTimeCountDownCallback;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "122760044")) {
                ipChange.ipc$dispatch("122760044", new Object[]{this});
                return;
            }
            OnTimeCountDownCallback onTimeCountDownCallback = this.b;
            if (onTimeCountDownCallback != null) {
                onTimeCountDownCallback.onCountDownFinished();
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1920394850")) {
                ipChange.ipc$dispatch("1920394850", new Object[]{this, Long.valueOf(j)});
                return;
            }
            OnTimeCountDownCallback onTimeCountDownCallback = this.b;
            if (onTimeCountDownCallback != null) {
                onTimeCountDownCallback.onCountDownTip(this.a);
            }
            this.a--;
        }
    }

    private TimeCountDownManagerImpl(OnTimeCountDownListener onTimeCountDownListener) {
        this.c = onTimeCountDownListener;
    }

    public static TimeCountDownManagerImpl c(OnTimeCountDownListener onTimeCountDownListener) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1888735101") ? (TimeCountDownManagerImpl) ipChange.ipc$dispatch("1888735101", new Object[]{onTimeCountDownListener}) : new TimeCountDownManagerImpl(onTimeCountDownListener);
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.ITimeCountDownManager
    public void cancelCountDown() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1431636339")) {
            ipChange.ipc$dispatch("1431636339", new Object[]{this});
            return;
        }
        CountDownTimerC2276b countDownTimerC2276b = this.a;
        if (countDownTimerC2276b != null) {
            countDownTimerC2276b.cancel();
            this.a = null;
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.ITimeCountDownManager
    public void setCountDown(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "252854803")) {
            ipChange.ipc$dispatch("252854803", new Object[]{this, Long.valueOf(j)});
        } else {
            this.b = j;
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.ITimeCountDownManager
    public void startCountDown() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1595723793")) {
            ipChange.ipc$dispatch("1595723793", new Object[]{this});
            return;
        }
        cancelCountDown();
        if (this.a == null) {
            this.a = new CountDownTimerC2276b(this.b, 1000L, this.d);
        }
        this.a.start();
        if (this.c != null) {
            String[] a = xv1.a(this.b);
            this.c.onCountDownStart(!TextUtils.isEmpty(a[0]) ? a[0] : "00", a[1], a[2], a[3]);
        }
    }
}
