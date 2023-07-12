package cn.damai.launcher.splash;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class TopBottomScrollView extends ScrollView {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isScrolledToBottom;
    private boolean isScrolledToTop;
    private IChangedListener mSmartScrollChangedListener;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface IChangedListener {
        void onScrolled();

        void onScrolledToBottom();

        void onScrolledToTop();
    }

    public TopBottomScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isScrolledToTop = true;
        this.isScrolledToBottom = false;
    }

    private void notifyScrollChangedListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1141599506")) {
            ipChange.ipc$dispatch("1141599506", new Object[]{this});
        } else if (this.isScrolledToTop) {
            IChangedListener iChangedListener = this.mSmartScrollChangedListener;
            if (iChangedListener != null) {
                iChangedListener.onScrolledToTop();
            }
        } else if (this.isScrolledToBottom) {
            IChangedListener iChangedListener2 = this.mSmartScrollChangedListener;
            if (iChangedListener2 != null) {
                iChangedListener2.onScrolledToBottom();
            }
        } else {
            IChangedListener iChangedListener3 = this.mSmartScrollChangedListener;
            if (iChangedListener3 != null) {
                iChangedListener3.onScrolled();
            }
        }
    }

    public boolean isScrolledToBottom() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-311303141") ? ((Boolean) ipChange.ipc$dispatch("-311303141", new Object[]{this})).booleanValue() : this.isScrolledToBottom;
    }

    public boolean isScrolledToTop() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1894682231") ? ((Boolean) ipChange.ipc$dispatch("1894682231", new Object[]{this})).booleanValue() : this.isScrolledToTop;
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1083658900")) {
            ipChange.ipc$dispatch("1083658900", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)});
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

    public void setChangedListener(IChangedListener iChangedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1906565839")) {
            ipChange.ipc$dispatch("1906565839", new Object[]{this, iChangedListener});
        } else {
            this.mSmartScrollChangedListener = iChangedListener;
        }
    }
}
