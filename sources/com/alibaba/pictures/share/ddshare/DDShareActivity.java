package com.alibaba.pictures.share.ddshare;

import android.app.Activity;
import android.os.Bundle;
import com.alibaba.pictures.share.ShareManager;
import com.alibaba.pictures.share.common.share.ShareChannel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.android.dingtalk.share.ddsharemodule.DDShareApiFactory;
import com.android.dingtalk.share.ddsharemodule.IDDAPIEventHandler;
import com.android.dingtalk.share.ddsharemodule.IDDShareApi;
import com.android.dingtalk.share.ddsharemodule.message.BaseReq;
import com.android.dingtalk.share.ddsharemodule.message.BaseResp;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.vf;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/alibaba/pictures/share/ddshare/DDShareActivity;", "Landroid/app/Activity;", "Lcom/android/dingtalk/share/ddsharemodule/IDDAPIEventHandler;", "<init>", "()V", "share_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes8.dex */
public final class DDShareActivity extends Activity implements IDDAPIEventHandler {
    private static transient /* synthetic */ IpChange $ipChange;
    private IDDShareApi a;

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-871677915")) {
            ipChange.ipc$dispatch("-871677915", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        try {
            IDDShareApi createDDShareApi = DDShareApiFactory.createDDShareApi(this, ShareManager.INSTANCE.b().g(), false);
            this.a = createDDShareApi;
            if (createDDShareApi != null) {
                createDDShareApi.handleIntent(getIntent(), this);
            }
        } catch (Exception unused) {
            finish();
        }
    }

    @Override // com.android.dingtalk.share.ddsharemodule.IDDAPIEventHandler
    public void onReq(@Nullable BaseReq baseReq) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1588633034")) {
            ipChange.ipc$dispatch("-1588633034", new Object[]{this, baseReq});
        }
    }

    @Override // com.android.dingtalk.share.ddsharemodule.IDDAPIEventHandler
    public void onResp(@NotNull BaseResp baseResp) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2013906574")) {
            ipChange.ipc$dispatch("-2013906574", new Object[]{this, baseResp});
            return;
        }
        b41.i(baseResp, "baseResp");
        int i = baseResp.mErrCode;
        if (i != 0) {
            vf.a(ShareChannel.DD, i);
        } else {
            vf.b(ShareChannel.DD);
        }
        finish();
    }
}
