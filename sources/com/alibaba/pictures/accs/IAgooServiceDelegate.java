package com.alibaba.pictures.accs;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.taobao.tao.log.statistics.TLogEventConst;
import com.uc.webview.export.media.MessageID;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u001a\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&J.\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H&¨\u0006\u0011"}, d2 = {"Lcom/alibaba/pictures/accs/IAgooServiceDelegate;", "", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "", "s", "Ltb/wt2;", MessageID.onError, "onRegistered", "onUnregistered", "Landroid/content/Intent;", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "onOriDataReceiver", RemoteMessageConst.MSGID, TLogEventConst.PARAM_TASK_ID, "msgBody", "onDataReceiver", "accs_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public interface IAgooServiceDelegate {
    void onDataReceiver(@NotNull Context context, @Nullable String str, @Nullable String str2, @Nullable String str3);

    void onError(@NotNull Context context, @NotNull String str);

    void onOriDataReceiver(@NotNull Context context, @Nullable Intent intent);

    void onRegistered(@NotNull Context context, @NotNull String str);

    void onUnregistered(@NotNull Context context, @NotNull String str);
}
