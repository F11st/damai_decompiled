package androidx.core.text;

import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.taobao.weex.common.WXConfig;
import com.taobao.weex.ui.module.WXDomModule;
import java.util.Locale;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\"\u0018\u0010\u0004\u001a\u00020\u0001*\u00020\u00008Ç\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Ljava/util/Locale;", "", WXDomModule.GET_COMPONENT_DIRECTION, "(Ljava/util/Locale;)I", WXConfig.layoutDirection, "core-ktx_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LocaleKt {
    @RequiresApi(17)
    public static final int getLayoutDirection(@NotNull Locale locale) {
        b41.i(locale, "<this>");
        return TextUtils.getLayoutDirectionFromLocale(locale);
    }
}
