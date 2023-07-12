package com.alibaba.android.ultron.vfw.web;

import com.taobao.vessel.VesselView;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
class WebLoadListener$1 implements Runnable {
    final /* synthetic */ b this$0;
    final /* synthetic */ VesselView val$mVesselView;

    WebLoadListener$1(b bVar, VesselView vesselView) {
        this.this$0 = bVar;
        this.val$mVesselView = vesselView;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        String str3;
        this.val$mVesselView.removeAllViews();
        VesselView vesselView = this.val$mVesselView;
        str = this.this$0.a;
        WebMaskView webMaskView = new WebMaskView(vesselView, str);
        VesselView vesselView2 = this.val$mVesselView;
        str2 = this.this$0.a;
        str3 = this.this$0.b;
        vesselView2.setOnLoadListener(new b(webMaskView, str2, str3));
        webMaskView.setErrorTextVisible(true);
    }
}
