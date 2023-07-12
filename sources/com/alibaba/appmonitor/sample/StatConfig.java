package com.alibaba.appmonitor.sample;

import com.alibaba.analytics.core.db.annotation.Column;
import com.alibaba.analytics.core.db.annotation.TableName;
import java.util.ArrayList;

/* compiled from: Taobao */
@TableName("ap_stat")
/* loaded from: classes6.dex */
public class StatConfig extends AMConifg {
    @Column("detail")
    public int detail;

    private boolean detail(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            String remove = arrayList.remove(0);
            if (isContains(remove)) {
                return ((StatConfig) getNext(remove)).detail(arrayList);
            }
            return isDetail();
        }
        return isDetail();
    }

    public boolean isDetail() {
        return this.detail == 1;
    }

    public boolean isDetail(String str, String str2) {
        ArrayList<String> arrayList = new ArrayList<>(2);
        arrayList.add(str);
        arrayList.add(str2);
        return detail(arrayList);
    }
}
