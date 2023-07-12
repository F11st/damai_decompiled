package cn.damai.uikit.nodoubleclick;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class FactButton extends AppCompatButton {
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
            if (AndroidInstantRuntime.support(ipChange, "-593103657")) {
                ipChange.ipc$dispatch("-593103657", new Object[]{this});
            } else {
                FactButton.this.mIsSleep = false;
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "234734487")) {
                ipChange.ipc$dispatch("234734487", new Object[]{this, Long.valueOf(j)});
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
            if (AndroidInstantRuntime.support(ipChange, "-89077157")) {
                ipChange.ipc$dispatch("-89077157", new Object[]{this, view});
                return;
            }
            if (!FactButton.this.mIsSleep && FactButton.this.mOuterClickListener != null) {
                FactButton.this.mOuterClickListener.onClick(view);
            }
            FactButton.this.mIsSleep = true;
            FactButton.this.mClickTimer.cancel();
            FactButton.this.mClickTimer.start();
        }
    }

    public FactButton(Context context) {
        super(context);
        this.mOuterClickListener = null;
        this.mIsSleep = false;
        this.mClickTimer = new a(500L, 500L);
        this.mInternalClick = new b();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1626637425")) {
            ipChange.ipc$dispatch("1626637425", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        this.mIsSleep = false;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1502490408")) {
            ipChange.ipc$dispatch("-1502490408", new Object[]{this, onClickListener});
            return;
        }
        super.setOnClickListener(this.mInternalClick);
        this.mOuterClickListener = onClickListener;
    }

    public FactButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOuterClickListener = null;
        this.mIsSleep = false;
        this.mClickTimer = new a(500L, 500L);
        this.mInternalClick = new b();
    }

    public FactButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mOuterClickListener = null;
        this.mIsSleep = false;
        this.mClickTimer = new a(500L, 500L);
        this.mInternalClick = new b();
    }
}
