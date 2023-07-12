package com.alibaba.aliweex.adapter.component;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.alibaba.aliweex.adapter.view.NearlyAround;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXVContainer;
import com.taobao.weex.utils.WXLogUtils;
import tb.jj1;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class WXLatestVisitView extends WXComponent {
    private NearlyAround mNearlyAround;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.aliweex.adapter.component.WXLatestVisitView$a */
    /* loaded from: classes5.dex */
    class C3028a implements NearlyAround.OnNearlyItemClickListener {
        C3028a(WXLatestVisitView wXLatestVisitView) {
        }

        @Override // com.alibaba.aliweex.adapter.view.NearlyAround.OnNearlyItemClickListener
        public void OnNearlyItemClick(jj1 jj1Var) {
            if (jj1Var == null || jj1Var.b() == null || !WXEnvironment.isApkDebugable()) {
                return;
            }
            WXLogUtils.d("openUrl:" + jj1Var.b());
        }
    }

    public WXLatestVisitView(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected View initComponentHostView(@NonNull Context context) {
        NearlyAround nearlyAround = new NearlyAround(context);
        this.mNearlyAround = nearlyAround;
        nearlyAround.e();
        this.mNearlyAround.d(new C3028a(this));
        return this.mNearlyAround.b();
    }

    @Override // com.taobao.weex.ui.component.WXComponent, com.taobao.weex.IWXActivityStateListener
    public void onActivityResume() {
        super.onActivityResume();
        NearlyAround nearlyAround = this.mNearlyAround;
        if (nearlyAround != null) {
            nearlyAround.e();
        }
    }
}
