package com.youku.gaiax.impl.register;

import android.text.TextUtils;
import com.alibaba.gaiax.GXRegisterCenter;
import com.taobao.weex.utils.TypefaceUtil;
import com.youku.gaiax.api.proxy.IProxyFeatures;
import com.youku.gaiax.impl.GaiaXProxy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"Lcom/youku/gaiax/impl/register/GXExtensionStaticProperty;", "Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionStaticProperty;", "Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionStaticProperty$a;", "params", "", "convert", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GXExtensionStaticProperty implements GXRegisterCenter.GXIExtensionStaticProperty {
    @Override // com.alibaba.gaiax.GXRegisterCenter.GXIExtensionStaticProperty
    @Nullable
    public Object convert(@NotNull GXRegisterCenter.GXIExtensionStaticProperty.C3332a c3332a) {
        IProxyFeatures features;
        b41.i(c3332a, "params");
        if (b41.d(c3332a.a(), "text-overflow") && b41.d(c3332a.b(), "clip")) {
            return TextUtils.TruncateAt.END;
        }
        if (!b41.d(c3332a.a(), TypefaceUtil.FONT_CACHE_DIR_NAME) || (features = GaiaXProxy.Companion.getInstance().getFeatures()) == null) {
            return null;
        }
        return features.createFontFamily(c3332a.b().toString());
    }
}
