package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class SmartScrollView extends ScrollView {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isScrolledToBottom;
    private boolean isScrolledToTop;
    private ISmartScrollChangedListener mSmartScrollChangedListener;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public interface ISmartScrollChangedListener {
        void onScrolledToBottom();

        void onScrolledToTop();
    }

    public SmartScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isScrolledToTop = true;
        this.isScrolledToBottom = false;
    }

    private void notifyScrollChangedListeners() {
        ISmartScrollChangedListener iSmartScrollChangedListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "996780865")) {
            ipChange.ipc$dispatch("996780865", new Object[]{this});
        } else if (this.isScrolledToTop) {
            ISmartScrollChangedListener iSmartScrollChangedListener2 = this.mSmartScrollChangedListener;
            if (iSmartScrollChangedListener2 != null) {
                iSmartScrollChangedListener2.onScrolledToTop();
            }
        } else if (!this.isScrolledToBottom || (iSmartScrollChangedListener = this.mSmartScrollChangedListener) == null) {
        } else {
            iSmartScrollChangedListener.onScrolledToBottom();
        }
    }

    public boolean isScrolledToBottom() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2138029814") ? ((Boolean) ipChange.ipc$dispatch("-2138029814", new Object[]{this})).booleanValue() : this.isScrolledToBottom;
    }

    public boolean isScrolledToTop() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1292111896") ? ((Boolean) ipChange.ipc$dispatch("-1292111896", new Object[]{this})).booleanValue() : this.isScrolledToTop;
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-743067773")) {
            ipChange.ipc$dispatch("-743067773", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)});
            return;
        }
        super.onOverScrolled(i, i2, z, z2);
        if (i2 == 0) {
            this.isScrolledToTop = z2;
            this.isScrolledToBottom = false;
        } else {
            this.isScrolledToTop = false;
            this.isScrolledToBottom = z2;
        }
        notifyScrollChangedListeners();
    }

    public void setScanScrollChangedListener(ISmartScrollChangedListener iSmartScrollChangedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-665529985")) {
            ipChange.ipc$dispatch("-665529985", new Object[]{this, iSmartScrollChangedListener});
        } else {
            this.mSmartScrollChangedListener = iSmartScrollChangedListener;
        }
    }
}
