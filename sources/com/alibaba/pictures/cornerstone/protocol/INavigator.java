package com.alibaba.pictures.cornerstone.protocol;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0013J2\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006H&J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J2\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006H&J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH&J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H&¨\u0006\u0014"}, d2 = {"Lcom/alibaba/pictures/cornerstone/protocol/INavigator;", "", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "", "url", "", "extralParams", "Ltb/wt2;", "handleUrl", "Landroid/os/Bundle;", "bundle", "Landroid/net/Uri;", "uri", "", "priority", "Lcom/alibaba/pictures/cornerstone/protocol/INavigator$INavigatorInterceptor;", "interceptor", "registerNavigatorInterceptor", "INavigatorInterceptor", "cornerstone_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public interface INavigator {

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¨\u0006\n"}, d2 = {"Lcom/alibaba/pictures/cornerstone/protocol/INavigator$INavigatorInterceptor;", "", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroid/net/Uri;", "uri", "Landroid/os/Bundle;", "bundle", "", "shouldInterceptor", "cornerstone_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes7.dex */
    public interface INavigatorInterceptor {
        boolean shouldInterceptor(@NotNull Context context, @NotNull Uri uri, @NotNull Bundle bundle);
    }

    void handleUrl(@NotNull Context context, @Nullable Uri uri);

    void handleUrl(@NotNull Context context, @Nullable Uri uri, @Nullable Bundle bundle);

    void handleUrl(@NotNull Context context, @Nullable Uri uri, @Nullable Map<String, Object> map);

    void handleUrl(@NotNull Context context, @Nullable String str);

    void handleUrl(@NotNull Context context, @Nullable String str, @Nullable Bundle bundle);

    void handleUrl(@NotNull Context context, @Nullable String str, @Nullable Map<String, Object> map);

    void registerNavigatorInterceptor(int i, @NotNull INavigatorInterceptor iNavigatorInterceptor);
}
