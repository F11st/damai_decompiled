package com.alibaba.pictures.accs;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&J)\u0010\u000e\u001a\u00020\u00042\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/alibaba/pictures/accs/INotifyActionHandler;", "", "Lcom/alibaba/pictures/accs/AgooMessage;", "agooMsg", "Ltb/wt2;", "onNotifyCLick", "onNotifyDelete", "", "onInterceptAlarmMsg", "", "", "urls", "Lcom/alibaba/pictures/accs/DecodeOverListener;", "decodeOverListener", "onNotifyImgResDecode", "([Ljava/lang/String;Lcom/alibaba/pictures/accs/DecodeOverListener;)V", "accs_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public interface INotifyActionHandler {
    boolean onInterceptAlarmMsg(@NotNull AgooMessage agooMessage);

    void onNotifyCLick(@NotNull AgooMessage agooMessage);

    void onNotifyDelete(@NotNull AgooMessage agooMessage);

    void onNotifyImgResDecode(@Nullable String[] strArr, @NotNull DecodeOverListener decodeOverListener);
}
