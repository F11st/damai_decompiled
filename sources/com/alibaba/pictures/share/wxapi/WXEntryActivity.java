package com.alibaba.pictures.share.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.alibaba.pictures.share.ShareManager;
import com.alibaba.pictures.share.common.share.ShareChannel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.sb2;
import tb.vf;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/alibaba/pictures/share/wxapi/WXEntryActivity;", "Landroid/app/Activity;", "Lcom/tencent/mm/opensdk/openapi/IWXAPIEventHandler;", "<init>", "()V", "GetWeixinUserPicListener", "share_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes8.dex */
public final class WXEntryActivity extends Activity implements IWXAPIEventHandler {
    private static transient /* synthetic */ IpChange $ipChange;
    private IWXAPI a;
    private final String b = "WXEntryActivity";

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&¨\u0006\u0007"}, d2 = {"Lcom/alibaba/pictures/share/wxapi/WXEntryActivity$GetWeixinUserPicListener;", "", "", "picUrl", "Ltb/wt2;", "onSuccess", "onFail", "share_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes8.dex */
    public interface GetWeixinUserPicListener {
        void onFail();

        void onSuccess(@Nullable String str);
    }

    private final void a(BaseResp baseResp) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-650033736")) {
            ipChange.ipc$dispatch("-650033736", new Object[]{this, baseResp});
            return;
        }
        String str = this.b;
        sb2.g(str, "handleShare resp = " + baseResp);
        int i = baseResp.errCode;
        if (i == -4) {
            vf.a(ShareChannel.WEIXIN, 1002);
        } else if (i == -2) {
            vf.a(ShareChannel.WEIXIN, 1001);
        } else if (i != 0) {
            vf.a(ShareChannel.WEIXIN, 1003);
        } else {
            vf.b(ShareChannel.WEIXIN);
        }
    }

    private final void b(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "167103321")) {
            ipChange.ipc$dispatch("167103321", new Object[]{this, intent});
            return;
        }
        try {
            IWXAPI iwxapi = this.a;
            if (iwxapi != null) {
                iwxapi.registerApp(ShareManager.INSTANCE.b().w());
            }
            IWXAPI iwxapi2 = this.a;
            if (iwxapi2 != null) {
                iwxapi2.handleIntent(intent, this);
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
        if (AndroidInstantRuntime.support(ipChange, "-1024903207")) {
            ipChange.ipc$dispatch("-1024903207", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        this.a = WXAPIFactory.createWXAPI(this, ShareManager.INSTANCE.b().w(), false);
        Intent intent = getIntent();
        b41.h(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
        b(intent);
    }

    @Override // android.app.Activity
    protected void onNewIntent(@NotNull Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1741831948")) {
            ipChange.ipc$dispatch("-1741831948", new Object[]{this, intent});
            return;
        }
        b41.i(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
        super.onNewIntent(intent);
        setIntent(intent);
        b(intent);
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onReq(@Nullable BaseReq baseReq) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1965674174")) {
            ipChange.ipc$dispatch("-1965674174", new Object[]{this, baseReq});
        } else {
            sb2.g("WXEntryActivity", "onReq");
        }
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onResp(@Nullable BaseResp baseResp) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1711378482")) {
            ipChange.ipc$dispatch("-1711378482", new Object[]{this, baseResp});
            return;
        }
        if (baseResp != null) {
            String str = this.b;
            sb2.g(str, "resp = " + baseResp.errCode);
            a(baseResp);
        }
        finish();
    }
}
