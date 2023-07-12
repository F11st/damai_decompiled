package cn.damai.uikit.nodoubleclick;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class FactLinearLayout extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private CountDownTimer mClickTimer;
    private View.OnClickListener mInternalClick;
    private boolean mIsSleep;
    private View.OnClickListener mOuterClickListener;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class a extends CountDownTimer {
        private static transient /* synthetic */ IpChange $ipChange;

        a(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-204145260")) {
                ipChange.ipc$dispatch("-204145260", new Object[]{this});
            } else {
                FactLinearLayout.this.mIsSleep = false;
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1969475782")) {
                ipChange.ipc$dispatch("-1969475782", new Object[]{this, Long.valueOf(j)});
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1844968920")) {
                ipChange.ipc$dispatch("1844968920", new Object[]{this, view});
                return;
            }
            if (!FactLinearLayout.this.mIsSleep && FactLinearLayout.this.mOuterClickListener != null) {
                FactLinearLayout.this.mOuterClickListener.onClick(view);
            }
            FactLinearLayout.this.mIsSleep = true;
            FactLinearLayout.this.mClickTimer.cancel();
            FactLinearLayout.this.mClickTimer.start();
        }
    }

    public FactLinearLayout(Context context) {
        super(context);
        this.mOuterClickListener = null;
        this.mIsSleep = false;
        this.mClickTimer = new a(500L, 500L);
        this.mInternalClick = new b();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1680767762")) {
            ipChange.ipc$dispatch("-1680767762", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        this.mIsSleep = false;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-742943749")) {
            ipChange.ipc$dispatch("-742943749", new Object[]{this, onClickListener});
            return;
        }
        super.setOnClickListener(this.mInternalClick);
        this.mOuterClickListener = onClickListener;
    }

    public FactLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOuterClickListener = null;
        this.mIsSleep = false;
        this.mClickTimer = new a(500L, 500L);
        this.mInternalClick = new b();
    }

    public FactLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mOuterClickListener = null;
        this.mIsSleep = false;
        this.mClickTimer = new a(500L, 500L);
        this.mInternalClick = new b();
    }
}
