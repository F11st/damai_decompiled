package com.alient.gaiax.container.util;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.alient.oneservice.appconfig.AppConfigProviderProxy;
import com.taobao.weex.adapter.URIAdapter;
import com.youku.live.livesdk.preloader.Preloader;
import com.youku.middlewareservice.provider.kvdata.SPProviderProxy;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\u000b\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\"\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0002J/\u0010\u0015\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016J-\u0010\u0019\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0013¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/alient/gaiax/container/util/Utils;", "", "", "name", "getString", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "", "dipValue", "", "dip2px", "screenWidth", URIAdapter.LINK, "tip", "Ltb/wt2;", "copyAction", "T", "Lcom/alibaba/fastjson/JSON;", Preloader.KEY_JSON, "Ljava/lang/Class;", "classOfT", "toJavaObject", "(Lcom/alibaba/fastjson/JSON;Ljava/lang/Class;)Ljava/lang/Object;", "src", "clazz", "parseObject", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "<init>", "()V", "gaiax-container_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes12.dex */
public final class Utils {
    @NotNull
    public static final Utils INSTANCE = new Utils();

    private Utils() {
    }

    public final void copyAction(@NotNull Context context, @Nullable String str, @Nullable String str2) {
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        try {
            Object systemService = context.getSystemService("clipboard");
            if (systemService != null) {
                ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("text", str));
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                AppConfigProviderProxy.showToast((Activity) context, str2, 0);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.content.ClipboardManager");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final int dip2px(@Nullable Context context, float f) {
        if (context == null || context.getResources() == null) {
            return 1;
        }
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Nullable
    public final String getString(@NotNull String str) {
        b41.i(str, "name");
        return SPProviderProxy.getPreferenceString(str);
    }

    public final <T> T parseObject(@Nullable String str, @Nullable Class<T> cls) {
        return (T) JSON.parseObject(str, cls);
    }

    public final int screenWidth(@Nullable Context context) {
        if (context == null || context.getResources() == null) {
            return 0;
        }
        return DisplayMetrics.getwidthPixels(context.getResources().getDisplayMetrics());
    }

    @Nullable
    public final <T> T toJavaObject(@Nullable JSON json, @Nullable Class<T> cls) {
        if (json == null) {
            return null;
        }
        try {
            return (T) INSTANCE.parseObject(json.toJSONString(), cls);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
