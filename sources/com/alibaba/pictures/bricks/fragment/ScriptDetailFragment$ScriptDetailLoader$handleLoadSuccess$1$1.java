package com.alibaba.pictures.bricks.fragment;

import android.view.View;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.pictures.R$color;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.fragment.ScriptDetailFragment$ScriptDetailLoader$handleLoadSuccess$1$1;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ScriptDetailFragment$ScriptDetailLoader$handleLoadSuccess$1$1 extends Lambda implements Function0<FrameLayout> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ FragmentActivity $it;
    final /* synthetic */ ScriptDetailFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScriptDetailFragment$ScriptDetailLoader$handleLoadSuccess$1$1(ScriptDetailFragment scriptDetailFragment, FragmentActivity fragmentActivity) {
        super(0);
        this.this$0 = scriptDetailFragment;
        this.$it = fragmentActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-1$lambda-0  reason: not valid java name */
    public static final void m179invoke$lambda1$lambda0(FrameLayout frameLayout, FragmentActivity fragmentActivity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1372810431")) {
            ipChange.ipc$dispatch("-1372810431", new Object[]{frameLayout, fragmentActivity});
            return;
        }
        b41.i(frameLayout, "$this_apply");
        b41.i(fragmentActivity, "$it");
        frameLayout.setBackgroundColor(ContextCompat.getColor(fragmentActivity, R$color.transparent));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final FrameLayout invoke() {
        final FrameLayout frameLayout;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1573636997")) {
            return (FrameLayout) ipChange.ipc$dispatch("1573636997", new Object[]{this});
        }
        ScriptDetailFragment scriptDetailFragment = this.this$0;
        scriptDetailFragment.hideLoadingDialog(scriptDetailFragment.getActivity());
        View realView = this.this$0.getRealView();
        if (realView == null || (frameLayout = (FrameLayout) realView.findViewById(R$id.content_container)) == null) {
            return null;
        }
        final FragmentActivity fragmentActivity = this.$it;
        frameLayout.postDelayed(new Runnable() { // from class: tb.z62
            @Override // java.lang.Runnable
            public final void run() {
                ScriptDetailFragment$ScriptDetailLoader$handleLoadSuccess$1$1.m179invoke$lambda1$lambda0(frameLayout, fragmentActivity);
            }
        }, 200L);
        return frameLayout;
    }
}
