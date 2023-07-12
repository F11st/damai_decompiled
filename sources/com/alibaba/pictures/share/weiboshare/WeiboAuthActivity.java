package com.alibaba.pictures.share.weiboshare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.alibaba.pictures.share.ShareManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.common.UiError;
import com.sina.weibo.sdk.openapi.IWBAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/alibaba/pictures/share/weiboshare/WeiboAuthActivity;", "Landroid/app/Activity;", "Lcom/sina/weibo/sdk/auth/WbAuthListener;", "<init>", "()V", "share_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes8.dex */
public final class WeiboAuthActivity extends Activity implements WbAuthListener {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, @Nullable Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "847271199")) {
            ipChange.ipc$dispatch("847271199", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        IWBAPI c = ShareManager.INSTANCE.c();
        if (c != null) {
            c.authorizeCallback(this, i, i2, intent);
        }
    }

    @Override // com.sina.weibo.sdk.auth.WbAuthListener
    public void onCancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1078683476")) {
            ipChange.ipc$dispatch("1078683476", new Object[]{this});
        } else {
            finish();
        }
    }

    @Override // com.sina.weibo.sdk.auth.WbAuthListener
    public void onComplete(@Nullable Oauth2AccessToken oauth2AccessToken) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "84174757")) {
            ipChange.ipc$dispatch("84174757", new Object[]{this, oauth2AccessToken});
        } else {
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1100170750")) {
            ipChange.ipc$dispatch("-1100170750", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        requestWindowFeature(1);
        IWBAPI c = ShareManager.INSTANCE.c();
        if (c != null) {
            c.authorize(this, this);
        }
    }

    @Override // com.sina.weibo.sdk.auth.WbAuthListener
    public void onError(@Nullable UiError uiError) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1535730313")) {
            ipChange.ipc$dispatch("1535730313", new Object[]{this, uiError});
        } else {
            finish();
        }
    }
}
