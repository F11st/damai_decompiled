package com.alibaba.pictures.bricks.channel.component;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import cn.damai.projectfiltercopy.listener.RequestParamProvider;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.channel.component.ProjectFilterComponent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.IContext;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.component.GenericComponent;
import com.youku.arch.v3.page.GenericFragment;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ProjectFilterComponent extends GenericComponent<ComponentValue> {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final IContext context;
    @Nullable
    private View mFloatLayout;
    @Nullable
    private RequestParamProvider requestParamProvider;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProjectFilterComponent(@NotNull IContext iContext, @NotNull Node node) {
        super(iContext, node);
        b41.i(iContext, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(node, Constants.CONFIG);
        this.context = iContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onRemove$lambda-2  reason: not valid java name */
    public static final void m111onRemove$lambda2(ProjectFilterComponent projectFilterComponent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1642161755")) {
            ipChange.ipc$dispatch("1642161755", new Object[]{projectFilterComponent});
            return;
        }
        b41.i(projectFilterComponent, "this$0");
        View view = projectFilterComponent.mFloatLayout;
        if (view == null || !(view.getParent() instanceof ViewGroup)) {
            return;
        }
        ViewParent parent = view.getParent();
        b41.g(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) parent).removeView(view);
    }

    public final void addView2RecyclerViewContainer(@NotNull ViewGroup viewGroup) {
        View view;
        ViewGroup viewGroup2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1221966485")) {
            ipChange.ipc$dispatch("1221966485", new Object[]{this, viewGroup});
            return;
        }
        b41.i(viewGroup, "floatLayout");
        this.mFloatLayout = viewGroup;
        GenericFragment fragment = this.context.getFragment();
        if (fragment == null || (view = fragment.getView()) == null || (viewGroup2 = (ViewGroup) view.findViewById(R$id.one_arch_recyclerView_container)) == null || viewGroup.getParent() != null) {
            return;
        }
        viewGroup2.addView(viewGroup, -1, -1);
    }

    @NotNull
    public final IContext getContext() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-647520782") ? (IContext) ipChange.ipc$dispatch("-647520782", new Object[]{this}) : this.context;
    }

    @Nullable
    public final RequestParamProvider getRequestParamProvider() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1575025245") ? (RequestParamProvider) ipChange.ipc$dispatch("1575025245", new Object[]{this}) : this.requestParamProvider;
    }

    @Override // com.youku.arch.v3.core.component.GenericComponent, com.youku.arch.v3.DomainObject
    public void onAdd() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1814124251")) {
            ipChange.ipc$dispatch("-1814124251", new Object[]{this});
        } else {
            super.onAdd();
        }
    }

    @Override // com.youku.arch.v3.core.component.GenericComponent, com.youku.arch.v3.DomainObject
    public void onRemove() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1580645600")) {
            ipChange.ipc$dispatch("1580645600", new Object[]{this});
            return;
        }
        super.onRemove();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: tb.zv1
            @Override // java.lang.Runnable
            public final void run() {
                ProjectFilterComponent.m111onRemove$lambda2(ProjectFilterComponent.this);
            }
        });
    }

    public final void setRequestParamProvider(@Nullable RequestParamProvider requestParamProvider) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1302668545")) {
            ipChange.ipc$dispatch("-1302668545", new Object[]{this, requestParamProvider});
        } else {
            this.requestParamProvider = requestParamProvider;
        }
    }
}
