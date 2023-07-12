package com.alibaba.pictures.accs;

import android.content.Context;
import com.taobao.android.launcher.common.Constants;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0004H&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\u000b\u001a\u00020\nH&J\b\u0010\f\u001a\u00020\u0004H&J\n\u0010\r\u001a\u0004\u0018\u00010\u0004H&J\u0016\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eH&J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0004H&J\u0011\u0010\u0012\u001a\u0004\u0018\u00010\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0014\u001a\u0004\u0018\u00010\u0011H&¢\u0006\u0004\b\u0014\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/alibaba/pictures/accs/IACCSConfigProvider;", "", "Landroid/content/Context;", "getContext", "", "getAppKey", "getInAppHost", "getChannelHost", "", Constants.PARAMETER_IS_DEBUGGABLE, "Lcom/alibaba/pictures/accs/ACCSEnvMode;", "getEnvMode", "getTTid", "getAgooMsgReceiveServiceName", "Ljava/util/HashMap;", "getAccsServiceMap", "getUserId", "", "getAppIconRes", "()Ljava/lang/Integer;", "getAppTinyIconRes", "accs_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public interface IACCSConfigProvider {
    @Nullable
    HashMap<String, String> getAccsServiceMap();

    @Nullable
    String getAgooMsgReceiveServiceName();

    @Nullable
    Integer getAppIconRes();

    @NotNull
    String getAppKey();

    @Nullable
    Integer getAppTinyIconRes();

    @NotNull
    String getChannelHost();

    @NotNull
    Context getContext();

    @NotNull
    ACCSEnvMode getEnvMode();

    @NotNull
    String getInAppHost();

    @NotNull
    String getTTid();

    @Nullable
    String getUserId();

    boolean isDebuggable();
}
