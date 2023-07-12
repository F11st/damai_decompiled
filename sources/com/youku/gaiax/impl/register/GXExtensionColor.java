package com.youku.gaiax.impl.register;

import android.content.Context;
import com.alibaba.gaiax.GXRegisterCenter;
import com.youku.gaiax.api.proxy.IProxyDesignToken;
import com.youku.gaiax.impl.GaiaXProxy;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ#\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/youku/gaiax/impl/register/GXExtensionColor;", "Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionColor;", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "", "value", "", "convert", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Integer;", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GXExtensionColor implements GXRegisterCenter.GXIExtensionColor {
    @Override // com.alibaba.gaiax.GXRegisterCenter.GXIExtensionColor
    @Nullable
    public Integer convert(@Nullable Context context, @NotNull String str) {
        b41.i(str, "value");
        IProxyDesignToken designToken = GaiaXProxy.Companion.getInstance().getDesignToken();
        if (designToken == null) {
            return null;
        }
        return designToken.designTokenColor(context, str);
    }
}
