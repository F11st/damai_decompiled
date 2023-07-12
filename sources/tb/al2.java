package tb;

import android.taobao.windvane.standardmodal.WVStandardEventCenter;
import android.taobao.windvane.webview.IWVWebView;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class al2 {
    @NotNull
    public static final al2 INSTANCE = new al2();

    private al2() {
    }

    @JvmStatic
    public static final void a(@Nullable IWVWebView iWVWebView, @Nullable String str, @Nullable String str2) {
        WVStandardEventCenter.postNotificationToJS(iWVWebView, str, str2);
    }

    @JvmStatic
    public static final void b(@Nullable String str, @Nullable String str2) {
        WVStandardEventCenter.postNotificationToJS(str, str2);
    }
}
