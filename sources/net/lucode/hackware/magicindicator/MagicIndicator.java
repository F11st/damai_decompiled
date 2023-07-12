package net.lucode.hackware.magicindicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import net.lucode.hackware.magicindicator.abs.IPagerNavigator;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class MagicIndicator extends FrameLayout {
    private IPagerNavigator mNavigator;

    public MagicIndicator(Context context) {
        super(context);
    }

    public IPagerNavigator getNavigator() {
        return this.mNavigator;
    }

    public void onPageScrollStateChanged(int i) {
        IPagerNavigator iPagerNavigator = this.mNavigator;
        if (iPagerNavigator != null) {
            iPagerNavigator.onPageScrollStateChanged(i);
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        IPagerNavigator iPagerNavigator = this.mNavigator;
        if (iPagerNavigator != null) {
            iPagerNavigator.onPageScrolled(i, f, i2);
        }
    }

    public void onPageSelected(int i) {
        IPagerNavigator iPagerNavigator = this.mNavigator;
        if (iPagerNavigator != null) {
            iPagerNavigator.onPageSelected(i);
        }
    }

    public void setNavigator(IPagerNavigator iPagerNavigator) {
        IPagerNavigator iPagerNavigator2 = this.mNavigator;
        if (iPagerNavigator2 == iPagerNavigator) {
            return;
        }
        if (iPagerNavigator2 != null) {
            iPagerNavigator2.onDetachFromMagicIndicator();
        }
        this.mNavigator = iPagerNavigator;
        removeAllViews();
        if (this.mNavigator instanceof View) {
            addView((View) this.mNavigator, new FrameLayout.LayoutParams(-1, -1));
            this.mNavigator.onAttachToMagicIndicator();
        }
    }

    public MagicIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
