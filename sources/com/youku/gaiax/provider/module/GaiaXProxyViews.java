package com.youku.gaiax.provider.module;

import android.content.Context;
import android.view.View;
import androidx.annotation.Keep;
import com.youku.gaiax.api.proxy.IProxyViews;
import com.youku.gaiax.provider.module.views.GaiaXPicImageView;
import com.youku.gaiax.provider.module.views.GaiaXYKLottieAnimationView;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\n"}, d2 = {"Lcom/youku/gaiax/provider/module/GaiaXProxyViews;", "Lcom/youku/gaiax/api/proxy/IProxyViews;", "", "type", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroid/view/View;", "createView", "<init>", "()V", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GaiaXProxyViews implements IProxyViews {
    @Override // com.youku.gaiax.api.proxy.IProxyViews
    @Nullable
    public View createView(@NotNull String str, @NotNull Context context) {
        b41.i(str, "type");
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        if (b41.d(str, "image")) {
            return new GaiaXPicImageView(context);
        }
        if (b41.d(str, "lottie")) {
            return new GaiaXYKLottieAnimationView(context);
        }
        return null;
    }
}
