package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.autofittext;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.autofittext.AutoFitHelper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class AutoFitTextView extends TextView implements AutoFitHelper.OnTextSizeChangeListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private AutoFitHelper mHelper;

    public AutoFitTextView(Context context) {
        super(context);
        init(context, null, 0);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-612343438")) {
            ipChange.ipc$dispatch("-612343438", new Object[]{this, context, attributeSet, Integer.valueOf(i)});
        } else {
            this.mHelper = AutoFitHelper.f(this, attributeSet, i).b(this);
        }
    }

    public AutoFitHelper getAutofitHelper() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1599717144") ? (AutoFitHelper) ipChange.ipc$dispatch("1599717144", new Object[]{this}) : this.mHelper;
    }

    public float getMaxTextSize() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1107692849") ? ((Float) ipChange.ipc$dispatch("-1107692849", new Object[]{this})).floatValue() : this.mHelper.j();
    }

    public float getMinTextSize() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-450776799") ? ((Float) ipChange.ipc$dispatch("-450776799", new Object[]{this})).floatValue() : this.mHelper.k();
    }

    public float getPrecision() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1929113123") ? ((Float) ipChange.ipc$dispatch("1929113123", new Object[]{this})).floatValue() : this.mHelper.l();
    }

    public boolean isSizeToFit() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1193012040")) {
            return ((Boolean) ipChange.ipc$dispatch("1193012040", new Object[]{this})).booleanValue();
        }
        AutoFitHelper autoFitHelper = this.mHelper;
        if (autoFitHelper != null) {
            return autoFitHelper.m();
        }
        return false;
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.autofittext.AutoFitHelper.OnTextSizeChangeListener
    public void onTextSizeChange(float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1548766590")) {
            ipChange.ipc$dispatch("1548766590", new Object[]{this, Float.valueOf(f), Float.valueOf(f2)});
        }
    }

    @Override // android.widget.TextView
    public void setLines(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-948871259")) {
            ipChange.ipc$dispatch("-948871259", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        super.setLines(i);
        AutoFitHelper autoFitHelper = this.mHelper;
        if (autoFitHelper != null) {
            autoFitHelper.p(i);
        }
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1863582641")) {
            ipChange.ipc$dispatch("1863582641", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        super.setMaxLines(i);
        AutoFitHelper autoFitHelper = this.mHelper;
        if (autoFitHelper != null) {
            autoFitHelper.p(i);
        }
    }

    public void setMaxTextSize(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "941320757")) {
            ipChange.ipc$dispatch("941320757", new Object[]{this, Float.valueOf(f)});
        } else {
            this.mHelper.q(f);
        }
    }

    public void setMinTextSize(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-169115290")) {
            ipChange.ipc$dispatch("-169115290", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mHelper.s(1, i);
        }
    }

    public void setPrecision(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2136516193")) {
            ipChange.ipc$dispatch("2136516193", new Object[]{this, Float.valueOf(f)});
        } else {
            this.mHelper.t(f);
        }
    }

    public void setSizeToFit() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "566340168")) {
            ipChange.ipc$dispatch("566340168", new Object[]{this});
        } else {
            setSizeToFit(true);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1124474052")) {
            ipChange.ipc$dispatch("-1124474052", new Object[]{this, Integer.valueOf(i), Float.valueOf(f)});
            return;
        }
        super.setTextSize(i, f);
        AutoFitHelper autoFitHelper = this.mHelper;
        if (autoFitHelper != null) {
            autoFitHelper.x(i, f);
        }
    }

    public void setMaxTextSize(int i, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-883711672")) {
            ipChange.ipc$dispatch("-883711672", new Object[]{this, Integer.valueOf(i), Float.valueOf(f)});
        } else {
            this.mHelper.r(i, f);
        }
    }

    public void setMinTextSize(int i, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-947580134")) {
            ipChange.ipc$dispatch("-947580134", new Object[]{this, Integer.valueOf(i), Float.valueOf(f)});
        } else {
            this.mHelper.s(i, f);
        }
    }

    public void setSizeToFit(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "376721804")) {
            ipChange.ipc$dispatch("376721804", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        AutoFitHelper autoFitHelper = this.mHelper;
        if (autoFitHelper != null) {
            autoFitHelper.o(z);
        }
    }

    public AutoFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet, 0);
    }

    public AutoFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet, i);
    }
}
