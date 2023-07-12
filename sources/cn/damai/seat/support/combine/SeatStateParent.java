package cn.damai.seat.support.combine;

import androidx.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public interface SeatStateParent {
    @Nullable
    SeatStateChild getChild(String str);

    boolean isCompress();
}
