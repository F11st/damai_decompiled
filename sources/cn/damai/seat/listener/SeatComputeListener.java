package cn.damai.seat.listener;

import androidx.annotation.Nullable;
import cn.damai.seat.bean.ItemSeatV2;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface SeatComputeListener extends OnPriceBarListener {
    void doNetWork(boolean z);

    void onSeatListChanged(@Nullable List<ItemSeatV2> list);
}
