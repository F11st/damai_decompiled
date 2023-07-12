package com.alibaba.pictures.share.ddshare;

import android.content.Context;
import com.alibaba.pictures.share.ShareManager;
import com.alibaba.pictures.share.common.share.ShareChannel;
import com.alibaba.pictures.share.common.share.ShareContent;
import com.alibaba.pictures.share.common.util.ShareUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.gl2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class DDApi$share$1 implements ShareManager.IApplyPermission.IPermissionListener {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ DDApi a;
    final /* synthetic */ Context b;
    final /* synthetic */ ShareContent c;
    final /* synthetic */ ShareChannel d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DDApi$share$1(DDApi dDApi, Context context, ShareContent shareContent, ShareChannel shareChannel) {
        this.a = dDApi;
        this.b = context;
        this.c = shareContent;
        this.d = shareChannel;
    }

    @Override // com.alibaba.pictures.share.ShareManager.IApplyPermission.IPermissionListener
    public void onPermissionDenied() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1666472555")) {
            ipChange.ipc$dispatch("-1666472555", new Object[]{this});
        } else {
            ShareUtil.n("保存图片异常，请授予存储权限");
        }
    }

    @Override // com.alibaba.pictures.share.ShareManager.IApplyPermission.IPermissionListener
    public void onPermissionGranted() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "955312799")) {
            ipChange.ipc$dispatch("955312799", new Object[]{this});
        } else {
            gl2.INSTANCE.b(new Runnable() { // from class: com.alibaba.pictures.share.ddshare.DDApi$share$1$onPermissionGranted$1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public final void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1216793643")) {
                        ipChange2.ipc$dispatch("1216793643", new Object[]{this});
                        return;
                    }
                    DDApi$share$1 dDApi$share$1 = DDApi$share$1.this;
                    dDApi$share$1.a.b(dDApi$share$1.b, dDApi$share$1.c, dDApi$share$1.d);
                }
            });
        }
    }
}
