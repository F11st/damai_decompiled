package com.alibaba.pictures.accs;

import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.common.Constants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J$\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J(\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&JA\u0010\u000f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0013\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H&J\u0012\u0010\u0014\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H&J\u001a\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J8\u0010\u001b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0019\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006H&¨\u0006\u001c"}, d2 = {"Lcom/alibaba/pictures/accs/IAccsServiceDelegate;", "", "", "serviceId", "", "errorCode", "Lcom/taobao/accs/base/TaoBaseService$ExtraInfo;", "info", "Ltb/wt2;", "onBind", "onUnbind", Constants.KEY_DATA_ID, "onSendData", "", "response", "onResponse", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;[BLcom/taobao/accs/base/TaoBaseService$ExtraInfo;)V", "Lcom/taobao/accs/base/TaoBaseService$ConnectInfo;", "conninfo", "onConnected", "onDisconnected", "", "ret", "onAntiBrush", "userId", "msg", "extraInfo", "onDataReceive", "accs_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public interface IAccsServiceDelegate {
    void onAntiBrush(boolean z, @Nullable TaoBaseService.ExtraInfo extraInfo);

    void onBind(@Nullable String str, int i, @Nullable TaoBaseService.ExtraInfo extraInfo);

    void onConnected(@Nullable TaoBaseService.ConnectInfo connectInfo);

    void onDataReceive(@Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull String str4, @Nullable TaoBaseService.ExtraInfo extraInfo);

    void onDisconnected(@Nullable TaoBaseService.ConnectInfo connectInfo);

    void onResponse(@Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable byte[] bArr, @Nullable TaoBaseService.ExtraInfo extraInfo);

    void onSendData(@NotNull String str, @NotNull String str2, int i, @NotNull TaoBaseService.ExtraInfo extraInfo);

    void onUnbind(@Nullable String str, int i, @Nullable TaoBaseService.ExtraInfo extraInfo);
}
