package cn.damai.uikit.nodoubleclick;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class FactRelativeLayout extends RelativeLayout {
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
            if (AndroidInstantRuntime.support(ipChange, "2068704699")) {
                ipChange.ipc$dispatch("2068704699", new Object[]{this});
            } else {
                FactRelativeLayout.this.mIsSleep = false;
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1480516045")) {
                ipChange.ipc$dispatch("-1480516045", new Object[]{this, Long.valueOf(j)});
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
            if (AndroidInstantRuntime.support(ipChange, "403296831")) {
                ipChange.ipc$dispatch("403296831", new Object[]{this, view});
                return;
            }
            if (!FactRelativeLayout.this.mIsSleep && FactRelativeLayout.this.mOuterClickListener != null) {
                FactRelativeLayout.this.mOuterClickListener.onClick(view);
            }
            FactRelativeLayout.this.mIsSleep = true;
            FactRelativeLayout.this.mClickTimer.cancel();
            FactRelativeLayout.this.mClickTimer.start();
        }
    }

    public FactRelativeLayout(Context context) {
        super(context);
        this.mOuterClickListener = null;
        this.mIsSleep = false;
        this.mClickTimer = new a(500L, 500L);
        this.mInternalClick = new b();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1135980629")) {
            ipChange.ipc$dispatch("1135980629", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        this.mIsSleep = false;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1509117580")) {
            ipChange.ipc$dispatch("-1509117580", new Object[]{this, onClickListener});
            return;
        }
        super.setOnClickListener(this.mInternalClick);
        this.mOuterClickListener = onClickListener;
    }

    public FactRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOuterClickListener = null;
        this.mIsSleep = false;
        this.mClickTimer = new a(500L, 500L);
        this.mInternalClick = new b();
    }

    public FactRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mOuterClickListener = null;
        this.mIsSleep = false;
        this.mClickTimer = new a(500L, 500L);
        this.mInternalClick = new b();
    }
}
