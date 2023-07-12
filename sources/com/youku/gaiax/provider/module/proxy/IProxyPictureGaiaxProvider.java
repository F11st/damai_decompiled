package com.youku.gaiax.provider.module.proxy;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J@\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH&¨\u0006\u000e"}, d2 = {"Lcom/youku/gaiax/provider/module/proxy/IProxyPictureGaiaxProvider;", "", "Landroid/app/Activity;", "activity", "", "title", "message", "negative", "positive", "Landroid/content/DialogInterface$OnClickListener;", "positiveListener", "negativeListener", "Landroid/app/Dialog;", "PictureCommonDialog", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface IProxyPictureGaiaxProvider {
    @NotNull
    Dialog PictureCommonDialog(@NotNull Activity activity, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull DialogInterface.OnClickListener onClickListener, @NotNull DialogInterface.OnClickListener onClickListener2);
}
