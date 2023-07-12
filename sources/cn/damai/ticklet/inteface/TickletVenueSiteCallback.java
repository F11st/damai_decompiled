package cn.damai.ticklet.inteface;

import cn.damai.ticklet.bean.ExchangeSiteInfo;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public interface TickletVenueSiteCallback<T> {
    void addMapMarkData();

    void callNavi(String str, String str2, String str3);

    void getDataType(int i);

    void onFail(String str, String str2);

    void onServiceDataSuccess(int i, ArrayList<ExchangeSiteInfo> arrayList);

    void reloadData();

    void showMapMarkByItem(int i);

    void showPopIconUtil();
}
