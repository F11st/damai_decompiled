package cn.damai.uikit.nodoubleclick;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class FactFrameLayout extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private CountDownTimer mClickTimer;
    private View.OnClickListener mInternalClick;
    private boolean mIsSleep;
    private View.OnClickListener mOuterClickListener;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.uikit.nodoubleclick.FactFrameLayout$a */
    /* loaded from: classes8.dex */
    public class CountDownTimerC2519a extends CountDownTimer {
        private static transient /* synthetic */ IpChange $ipChange;

        CountDownTimerC2519a(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-166130694")) {
                ipChange.ipc$dispatch("-166130694", new Object[]{this});
            } else {
                FactFrameLayout.this.mIsSleep = false;
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-167134188")) {
                ipChange.ipc$dispatch("-167134188", new Object[]{this, Long.valueOf(j)});
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.uikit.nodoubleclick.FactFrameLayout$b */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC2520b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2520b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "712474302")) {
                ipChange.ipc$dispatch("712474302", new Object[]{this, view});
                return;
            }
            if (!FactFrameLayout.this.mIsSleep && FactFrameLayout.this.mOuterClickListener != null) {
                FactFrameLayout.this.mOuterClickListener.onClick(view);
            }
            FactFrameLayout.this.mIsSleep = true;
            FactFrameLayout.this.mClickTimer.cancel();
            FactFrameLayout.this.mClickTimer.start();
        }
    }

    public FactFrameLayout(Context context) {
        super(context);
        this.mOuterClickListener = null;
        this.mIsSleep = false;
        this.mClickTimer = new CountDownTimerC2519a(500L, 500L);
        this.mInternalClick = new View$OnClickListenerC2520b();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1845185492")) {
            ipChange.ipc$dispatch("1845185492", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        this.mIsSleep = false;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "652788181")) {
            ipChange.ipc$dispatch("652788181", new Object[]{this, onClickListener});
            return;
        }
        super.setOnClickListener(this.mInternalClick);
        this.mOuterClickListener = onClickListener;
    }

    public FactFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOuterClickListener = null;
        this.mIsSleep = false;
        this.mClickTimer = new CountDownTimerC2519a(500L, 500L);
        this.mInternalClick = new View$OnClickListenerC2520b();
    }

    public FactFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mOuterClickListener = null;
        this.mIsSleep = false;
        this.mClickTimer = new CountDownTimerC2519a(500L, 500L);
        this.mInternalClick = new View$OnClickListenerC2520b();
    }
}
