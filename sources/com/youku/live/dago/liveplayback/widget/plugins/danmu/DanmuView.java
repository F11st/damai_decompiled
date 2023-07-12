package com.youku.live.dago.liveplayback.widget.plugins.danmu;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplugin.layer.ILMLayerManager;
import com.youku.alixplugin.view.LazyInflatedView;
import com.youku.live.dago.liveplayback.R;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DanmuView extends LazyInflatedView {
    private static transient /* synthetic */ IpChange $ipChange;

    public DanmuView(Context context, ILMLayerManager<ViewGroup> iLMLayerManager, String str) {
        super(context, iLMLayerManager, str, R.C7935layout.dago_danmu_view);
    }

    @Override // com.youku.alixplugin.view.LazyInflatedView
    protected void onInflate(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1115104008")) {
            ipChange.ipc$dispatch("1115104008", new Object[]{this, view});
        }
    }
}
