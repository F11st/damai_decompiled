package com.alibaba.pictures.share.apshare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.alibaba.pictures.share.ShareManager;
import com.alibaba.pictures.share.common.share.ShareChannel;
import com.alipay.share.sdk.openapi.APAPIFactory;
import com.alipay.share.sdk.openapi.BaseReq;
import com.alipay.share.sdk.openapi.BaseResp;
import com.alipay.share.sdk.openapi.IAPAPIEventHandler;
import com.alipay.share.sdk.openapi.IAPApi;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.support.api.entity.core.CommonCode;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.sb2;
import tb.vf;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/alibaba/pictures/share/apshare/ShareEntryActivity;", "Landroid/app/Activity;", "Lcom/alipay/share/sdk/openapi/IAPAPIEventHandler;", "<init>", "()V", "share_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes8.dex */
public final class ShareEntryActivity extends Activity implements IAPAPIEventHandler {
    private static transient /* synthetic */ IpChange $ipChange;
    private IAPApi a;
    private final String b = "ShareEntryActivity";

    private final void a(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1027629542")) {
            ipChange.ipc$dispatch("1027629542", new Object[]{this, intent});
            return;
        }
        try {
            IAPApi iAPApi = this.a;
            if (iAPApi != null) {
                iAPApi.handleIntent(intent, this);
            }
        } catch (Exception e) {
            sb2.a(this.b, e);
            try {
                super.finish();
            } catch (Exception e2) {
                sb2.a(this.b, e2);
            }
        }
    }

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1653762008")) {
            ipChange.ipc$dispatch("-1653762008", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        this.a = APAPIFactory.createZFBApi(getApplicationContext(), ShareManager.INSTANCE.b().a(), false);
        Intent intent = getIntent();
        b41.h(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
        a(intent);
    }

    @Override // android.app.Activity
    protected void onNewIntent(@NotNull Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "426795587")) {
            ipChange.ipc$dispatch("426795587", new Object[]{this, intent});
            return;
        }
        b41.i(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
        super.onNewIntent(intent);
        setIntent(intent);
        a(intent);
    }

    @Override // com.alipay.share.sdk.openapi.IAPAPIEventHandler
    public void onReq(@Nullable BaseReq baseReq) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "854850113")) {
            ipChange.ipc$dispatch("854850113", new Object[]{this, baseReq});
        } else {
            sb2.g("ShareEntryActivity", "onReq");
        }
    }

    @Override // com.alipay.share.sdk.openapi.IAPAPIEventHandler
    public void onResp(@NotNull BaseResp baseResp) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1678176429")) {
            ipChange.ipc$dispatch("1678176429", new Object[]{this, baseResp});
            return;
        }
        b41.i(baseResp, "baseResp");
        int i = baseResp.errCode;
        if (i == -4) {
            vf.a(ShareChannel.ALIPAY, 1002);
        } else if (i == -2) {
            vf.a(ShareChannel.ALIPAY, 1001);
        } else if (i != 0) {
            vf.a(ShareChannel.ALIPAY, 1003);
        } else {
            vf.b(ShareChannel.ALIPAY);
        }
        finish();
    }
}
