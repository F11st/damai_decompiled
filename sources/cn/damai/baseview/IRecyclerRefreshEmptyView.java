package cn.damai.baseview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import cn.damai.uikit.R$layout;
import cn.damai.uikit.irecycler.RefreshTrigger;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class IRecyclerRefreshEmptyView extends LinearLayout implements RefreshTrigger {
    private static transient /* synthetic */ IpChange $ipChange;

    public IRecyclerRefreshEmptyView(Context context) {
        super(context);
        initView(context);
    }

    public void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1470731231")) {
            ipChange.ipc$dispatch("1470731231", new Object[]{this, context});
        } else {
            LayoutInflater.from(context).inflate(R$layout.layout_refresh_empty_view, this);
        }
    }

    @Override // cn.damai.uikit.irecycler.RefreshTrigger
    public void onComplete() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "156573318")) {
            ipChange.ipc$dispatch("156573318", new Object[]{this});
        }
    }

    @Override // cn.damai.uikit.irecycler.RefreshTrigger
    public void onMove(boolean z, boolean z2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "480905173")) {
            ipChange.ipc$dispatch("480905173", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.uikit.irecycler.RefreshTrigger
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1299650928")) {
            ipChange.ipc$dispatch("-1299650928", new Object[]{this});
        }
    }

    @Override // cn.damai.uikit.irecycler.RefreshTrigger
    public void onRelease() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1800024548")) {
            ipChange.ipc$dispatch("1800024548", new Object[]{this});
        }
    }

    @Override // cn.damai.uikit.irecycler.RefreshTrigger
    public void onReset() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1615058204")) {
            ipChange.ipc$dispatch("1615058204", new Object[]{this});
        }
    }

    @Override // cn.damai.uikit.irecycler.RefreshTrigger
    public void onStart(boolean z, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "926695531")) {
            ipChange.ipc$dispatch("926695531", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)});
        }
    }

    public IRecyclerRefreshEmptyView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }

    public IRecyclerRefreshEmptyView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }
}
