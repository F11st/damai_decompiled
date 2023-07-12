package cn.damai.uikit.nodoubleclick;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class FactView extends View {
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
            if (AndroidInstantRuntime.support(ipChange, "960050826")) {
                ipChange.ipc$dispatch("960050826", new Object[]{this});
            } else {
                FactView.this.mIsSleep = false;
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-269353084")) {
                ipChange.ipc$dispatch("-269353084", new Object[]{this, Long.valueOf(j)});
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
            if (AndroidInstantRuntime.support(ipChange, "-1988614834")) {
                ipChange.ipc$dispatch("-1988614834", new Object[]{this, view});
                return;
            }
            if (!FactView.this.mIsSleep && FactView.this.mOuterClickListener != null) {
                FactView.this.mOuterClickListener.onClick(view);
            }
            FactView.this.mIsSleep = true;
            FactView.this.mClickTimer.cancel();
            FactView.this.mClickTimer.start();
        }
    }

    public FactView(Context context) {
        super(context);
        this.mOuterClickListener = null;
        this.mIsSleep = false;
        this.mClickTimer = new a(500L, 500L);
        this.mInternalClick = new b();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1894546844")) {
            ipChange.ipc$dispatch("-1894546844", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        this.mIsSleep = false;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1643274939")) {
            ipChange.ipc$dispatch("-1643274939", new Object[]{this, onClickListener});
            return;
        }
        super.setOnClickListener(this.mInternalClick);
        this.mOuterClickListener = onClickListener;
    }

    public FactView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOuterClickListener = null;
        this.mIsSleep = false;
        this.mClickTimer = new a(500L, 500L);
        this.mInternalClick = new b();
    }

    public FactView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mOuterClickListener = null;
        this.mIsSleep = false;
        this.mClickTimer = new a(500L, 500L);
        this.mInternalClick = new b();
    }
}
