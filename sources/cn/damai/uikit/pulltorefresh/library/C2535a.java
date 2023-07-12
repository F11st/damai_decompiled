package cn.damai.uikit.pulltorefresh.library;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import cn.damai.uikit.pulltorefresh.library.internal.LoadingLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: Taobao */
/* renamed from: cn.damai.uikit.pulltorefresh.library.a */
/* loaded from: classes8.dex */
public class C2535a implements ILoadingLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private final HashSet<LoadingLayout> a = new HashSet<>();

    public void a(LoadingLayout loadingLayout) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "111116083")) {
            ipChange.ipc$dispatch("111116083", new Object[]{this, loadingLayout});
        } else if (loadingLayout != null) {
            this.a.add(loadingLayout);
        }
    }

    @Override // cn.damai.uikit.pulltorefresh.library.ILoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-482328312")) {
            ipChange.ipc$dispatch("-482328312", new Object[]{this, charSequence});
            return;
        }
        Iterator<LoadingLayout> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().setLastUpdatedLabel(charSequence);
        }
    }

    @Override // cn.damai.uikit.pulltorefresh.library.ILoadingLayout
    public void setLoadingDrawable(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-12777439")) {
            ipChange.ipc$dispatch("-12777439", new Object[]{this, drawable});
            return;
        }
        Iterator<LoadingLayout> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().setLoadingDrawable(drawable);
        }
    }

    @Override // cn.damai.uikit.pulltorefresh.library.ILoadingLayout
    public void setPullLabel(CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1031056436")) {
            ipChange.ipc$dispatch("-1031056436", new Object[]{this, charSequence});
            return;
        }
        Iterator<LoadingLayout> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().setPullLabel(charSequence);
        }
    }

    @Override // cn.damai.uikit.pulltorefresh.library.ILoadingLayout
    public void setRefreshingLabel(CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "440178478")) {
            ipChange.ipc$dispatch("440178478", new Object[]{this, charSequence});
            return;
        }
        Iterator<LoadingLayout> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().setRefreshingLabel(charSequence);
        }
    }

    @Override // cn.damai.uikit.pulltorefresh.library.ILoadingLayout
    public void setReleaseLabel(CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1684037942")) {
            ipChange.ipc$dispatch("-1684037942", new Object[]{this, charSequence});
            return;
        }
        Iterator<LoadingLayout> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().setReleaseLabel(charSequence);
        }
    }

    @Override // cn.damai.uikit.pulltorefresh.library.ILoadingLayout
    public void setTextTypeface(Typeface typeface) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "965317655")) {
            ipChange.ipc$dispatch("965317655", new Object[]{this, typeface});
            return;
        }
        Iterator<LoadingLayout> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().setTextTypeface(typeface);
        }
    }
}
