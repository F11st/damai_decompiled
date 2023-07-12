package cn.damai.uikit.nodoubleclick;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class FactTextView extends AppCompatTextView {
    private static transient /* synthetic */ IpChange $ipChange;
    private CountDownTimer mClickTimer;
    private View.OnClickListener mInternalClick;
    private boolean mIsSleep;
    private View.OnClickListener mOuterClickListener;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.uikit.nodoubleclick.FactTextView$a */
    /* loaded from: classes8.dex */
    public class CountDownTimerC2525a extends CountDownTimer {
        private static transient /* synthetic */ IpChange $ipChange;

        CountDownTimerC2525a(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-840663337")) {
                ipChange.ipc$dispatch("-840663337", new Object[]{this});
            } else {
                FactTextView.this.mIsSleep = false;
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "365296023")) {
                ipChange.ipc$dispatch("365296023", new Object[]{this, Long.valueOf(j)});
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.uikit.nodoubleclick.FactTextView$b */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC2526b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2526b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "824235099")) {
                ipChange.ipc$dispatch("824235099", new Object[]{this, view});
                return;
            }
            if (!FactTextView.this.mIsSleep && FactTextView.this.mOuterClickListener != null) {
                FactTextView.this.mOuterClickListener.onClick(view);
            }
            FactTextView.this.mIsSleep = true;
            FactTextView.this.mClickTimer.cancel();
            FactTextView.this.mClickTimer.start();
        }
    }

    public FactTextView(Context context) {
        super(context);
        this.mOuterClickListener = null;
        this.mIsSleep = false;
        this.mClickTimer = new CountDownTimerC2525a(500L, 500L);
        this.mInternalClick = new View$OnClickListenerC2526b();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1525772687")) {
            ipChange.ipc$dispatch("-1525772687", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        this.mIsSleep = false;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "188810968")) {
            ipChange.ipc$dispatch("188810968", new Object[]{this, onClickListener});
            return;
        }
        super.setOnClickListener(this.mInternalClick);
        this.mOuterClickListener = onClickListener;
    }

    public FactTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOuterClickListener = null;
        this.mIsSleep = false;
        this.mClickTimer = new CountDownTimerC2525a(500L, 500L);
        this.mInternalClick = new View$OnClickListenerC2526b();
    }

    public FactTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mOuterClickListener = null;
        this.mIsSleep = false;
        this.mClickTimer = new CountDownTimerC2525a(500L, 500L);
        this.mInternalClick = new View$OnClickListenerC2526b();
    }
}
