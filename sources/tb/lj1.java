package tb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.bricks.bean.NestedBannerBean;
import com.alibaba.pictures.bricks.component.home.NestedBannerViewHolder;
import com.alibaba.pictures.bricks.component.home.OnBannerListener;
import com.alibaba.pictures.bricks.view.BannerViewBinder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class lj1 implements BannerViewBinder {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final a Companion = new a(null);
    public static final int TYPE_NORMAL_BANNER_FRAME = 1;
    public static final int TYPE_SUPER_BANNER_FRAME = 2;
    @NotNull
    private final OnBannerListener a;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }
    }

    public lj1(@NotNull OnBannerListener onBannerListener) {
        b41.i(onBannerListener, "mListener");
        this.a = onBannerListener;
    }

    @Override // com.alibaba.pictures.bricks.view.BannerViewBinder
    @NotNull
    public View getView(int i, int i2, @Nullable Object obj, @Nullable View view, @NotNull ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1613828847")) {
            return (View) ipChange.ipc$dispatch("-1613828847", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), obj, view, viewGroup});
        }
        b41.i(viewGroup, "container");
        Context context = viewGroup.getContext() != null ? viewGroup.getContext() : AppInfoProviderProxy.getApplication();
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R$layout.bricks_nested_banner_item_super_frame, viewGroup, false);
            b41.h(view, "from(context).inflate(\n …iner, false\n            )");
        }
        b41.g(obj, "null cannot be cast to non-null type com.alibaba.pictures.bricks.bean.NestedBannerBean");
        NestedBannerBean nestedBannerBean = (NestedBannerBean) obj;
        Object tag = view.getTag();
        (tag instanceof NestedBannerViewHolder ? (NestedBannerViewHolder) tag : new NestedBannerViewHolder(view, this.a)).c(nestedBannerBean, i2);
        return view;
    }

    @Override // com.alibaba.pictures.bricks.view.BannerViewBinder
    public int getViewType(@Nullable Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1743124293")) {
            return ((Integer) ipChange.ipc$dispatch("-1743124293", new Object[]{this, obj})).intValue();
        }
        if (obj instanceof NestedBannerBean) {
            return ((NestedBannerBean) obj).isSuperFrameBanner() ? 2 : 1;
        }
        return -1;
    }
}
