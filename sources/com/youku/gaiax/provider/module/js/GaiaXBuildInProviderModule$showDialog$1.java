package com.youku.gaiax.provider.module.js;

import android.app.Activity;
import android.content.DialogInterface;
import com.alient.oneservice.appconfig.AppConfigProviderProxy;
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
final class GaiaXBuildInProviderModule$showDialog$1 extends Lambda implements Function0<wt2> {
    final /* synthetic */ IGaiaXCallback $callback;
    final /* synthetic */ String $cancelText;
    final /* synthetic */ String $confirmText;
    final /* synthetic */ String $content;
    final /* synthetic */ String $title;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GaiaXBuildInProviderModule$showDialog$1(String str, String str2, String str3, String str4, IGaiaXCallback iGaiaXCallback) {
        super(0);
        this.$title = str;
        this.$content = str2;
        this.$cancelText = str3;
        this.$confirmText = str4;
        this.$callback = iGaiaXCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-2$lambda-0  reason: not valid java name */
    public static final void m1266invoke$lambda2$lambda0(IGaiaXCallback iGaiaXCallback, DialogInterface dialogInterface, int i) {
        b41.i(iGaiaXCallback, "$callback");
        dialogInterface.dismiss();
        IGaiaXCallback.DefaultImpls.invoke$default(iGaiaXCallback, null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-2$lambda-1  reason: not valid java name */
    public static final void m1267invoke$lambda2$lambda1(IGaiaXCallback iGaiaXCallback, DialogInterface dialogInterface, int i) {
        b41.i(iGaiaXCallback, "$callback");
        dialogInterface.dismiss();
        IGaiaXCallback.DefaultImpls.invoke$default(iGaiaXCallback, null, 1, null);
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
        String str2 = this.$content;
        String str3 = this.$cancelText;
        String str4 = this.$confirmText;
        final IGaiaXCallback iGaiaXCallback = this.$callback;
        PictureGaiaXProviderProxy.Companion.getMiddleProvider().PictureCommonDialog(activity, str, str2, str3, str4, new DialogInterface.OnClickListener() { // from class: com.youku.gaiax.provider.module.js.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                GaiaXBuildInProviderModule$showDialog$1.m1266invoke$lambda2$lambda0(IGaiaXCallback.this, dialogInterface, i);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.youku.gaiax.provider.module.js.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                GaiaXBuildInProviderModule$showDialog$1.m1267invoke$lambda2$lambda1(IGaiaXCallback.this, dialogInterface, i);
            }
        }).show();
    }
}
