package cn.damai.ticklet.inteface;

import cn.damai.ticklet.bean.TickletStatusNotice;
import cn.damai.ticklet.view.TickletDetailViewPager;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public interface TickletPerformCallBack<T> {
    void closeNotice();

    void performCancel(boolean z);

    void setDetailViewPager(TickletDetailViewPager tickletDetailViewPager);

    void showNotice(TickletStatusNotice tickletStatusNotice);
}
