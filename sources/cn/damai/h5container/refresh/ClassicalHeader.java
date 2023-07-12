package cn.damai.h5container.refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.uikit.view.refresh.DmRefreshHeader;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ClassicalHeader extends FrameLayout implements JRefreshHeader {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "ClassicalHeader";
    boolean attain;
    DmRefreshHeader header;
    boolean isReset;

    public ClassicalHeader(@NonNull Context context) {
        this(context, null);
    }

    public int dp2px(Context context, float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1251319538") ? ((Integer) ipChange.ipc$dispatch("1251319538", new Object[]{this, context, Float.valueOf(f)})).intValue() : (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // cn.damai.h5container.refresh.JRefreshHeader
    public long failingRetention() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1623603217")) {
            return ((Long) ipChange.ipc$dispatch("-1623603217", new Object[]{this})).longValue();
        }
        return 0L;
    }

    @Override // cn.damai.h5container.refresh.JRefreshHeader
    public int maxOffsetHeight() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "426071370") ? ((Integer) ipChange.ipc$dispatch("426071370", new Object[]{this})).intValue() : getHeight() * 4;
    }

    @Override // cn.damai.h5container.refresh.JRefreshHeader
    public void onComplete(JRefreshLayout jRefreshLayout, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-635490731")) {
            ipChange.ipc$dispatch("-635490731", new Object[]{this, jRefreshLayout, Boolean.valueOf(z)});
            return;
        }
        Log.e(TAG, "----------------> onComplete");
        this.header.complete();
    }

    @Override // cn.damai.h5container.refresh.JRefreshHeader
    public void onPrepare(JRefreshLayout jRefreshLayout) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "53423823")) {
            ipChange.ipc$dispatch("53423823", new Object[]{this, jRefreshLayout});
        } else {
            Log.e(TAG, "----------------> onPrepare");
        }
    }

    @Override // cn.damai.h5container.refresh.JRefreshHeader
    public void onRefresh(JRefreshLayout jRefreshLayout) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-372163421")) {
            ipChange.ipc$dispatch("-372163421", new Object[]{this, jRefreshLayout});
            return;
        }
        Log.e(TAG, "----------------> onRefresh");
        this.isReset = false;
        this.header.refreshing();
    }

    @Override // cn.damai.h5container.refresh.JRefreshHeader
    public void onReset(JRefreshLayout jRefreshLayout) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1636469929")) {
            ipChange.ipc$dispatch("-1636469929", new Object[]{this, jRefreshLayout});
            return;
        }
        Log.e(TAG, "----------------> onReset");
        this.isReset = true;
        this.header.reset();
    }

    @Override // cn.damai.h5container.refresh.JRefreshHeader
    public void onScroll(JRefreshLayout jRefreshLayout, int i, float f, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1948266812")) {
            ipChange.ipc$dispatch("-1948266812", new Object[]{this, jRefreshLayout, Integer.valueOf(i), Float.valueOf(f), Boolean.valueOf(z)});
            return;
        }
        Log.e(TAG, "----------------> onScroll  " + f);
        if (z || !this.isReset) {
            return;
        }
        if (f >= 1.0f && !this.attain) {
            this.attain = true;
        } else if (f >= 1.0f || !this.attain) {
        } else {
            this.attain = false;
        }
    }

    @Override // cn.damai.h5container.refresh.JRefreshHeader
    public int refreshHeight() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1395001862") ? ((Integer) ipChange.ipc$dispatch("1395001862", new Object[]{this})).intValue() : getHeight();
    }

    @Override // cn.damai.h5container.refresh.JRefreshHeader
    public long succeedRetention() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1986499885")) {
            return ((Long) ipChange.ipc$dispatch("1986499885", new Object[]{this})).longValue();
        }
        return 200L;
    }

    public ClassicalHeader(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ClassicalHeader(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        this.isReset = true;
        this.attain = false;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        addView(linearLayout, -1, -2);
        ((FrameLayout.LayoutParams) linearLayout.getLayoutParams()).gravity = 17;
        this.header = new DmRefreshHeader(context);
        linearLayout.addView(this.header, new LinearLayout.LayoutParams(-1, dp2px(context, 70.0f)));
    }
}
