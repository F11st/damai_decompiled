package com.youku.gaiax.provider.module.js;

import android.app.Activity;
import android.content.DialogInterface;
import com.alibaba.fastjson.JSONObject;
import com.alient.oneservice.appconfig.AppConfigProviderProxy;
import com.taobao.android.purchase.core.utils.PurchaseConstants;
import com.youku.gaiax.js.api.IGaiaXCallback;
import com.youku.gaiax.provider.module.proxy.PictureGaiaXProviderProxy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.b41;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Ltb/wt2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes2.dex */
final class GaiaXBuildInProviderModule$showAlert$1 extends Lambda implements Function0<wt2> {
    final /* synthetic */ IGaiaXCallback $callback;
    final /* synthetic */ String $message;
    final /* synthetic */ String $title;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GaiaXBuildInProviderModule$showAlert$1(String str, String str2, IGaiaXCallback iGaiaXCallback) {
        super(0);
        this.$title = str;
        this.$message = str2;
        this.$callback = iGaiaXCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-4$lambda-1  reason: not valid java name */
    public static final void m1264invoke$lambda4$lambda1(IGaiaXCallback iGaiaXCallback, DialogInterface dialogInterface, int i) {
        b41.i(iGaiaXCallback, "$callback");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put((JSONObject) "canceled", (String) Boolean.FALSE);
        wt2 wt2Var = wt2.INSTANCE;
        iGaiaXCallback.invoke(jSONObject);
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-4$lambda-3  reason: not valid java name */
    public static final void m1265invoke$lambda4$lambda3(IGaiaXCallback iGaiaXCallback, DialogInterface dialogInterface, int i) {
        b41.i(iGaiaXCallback, "$callback");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put((JSONObject) "canceled", (String) Boolean.TRUE);
        wt2 wt2Var = wt2.INSTANCE;
        iGaiaXCallback.invoke(jSONObject);
        dialogInterface.dismiss();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ wt2 invoke() {
        invoke2();
        return wt2.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Activity activity = AppConfigProviderProxy.topActivity();
        if (activity == null) {
            return;
        }
        String str = this.$title;
        String str2 = this.$message;
        final IGaiaXCallback iGaiaXCallback = this.$callback;
        PictureGaiaXProviderProxy.Companion.getMiddleProvider().PictureCommonDialog(activity, str, str2, "取消", PurchaseConstants.CONFIRM, new DialogInterface.OnClickListener() { // from class: com.youku.gaiax.provider.module.js.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                GaiaXBuildInProviderModule$showAlert$1.m1264invoke$lambda4$lambda1(IGaiaXCallback.this, dialogInterface, i);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.youku.gaiax.provider.module.js.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                GaiaXBuildInProviderModule$showAlert$1.m1265invoke$lambda4$lambda3(IGaiaXCallback.this, dialogInterface, i);
            }
        }).show();
    }
}
