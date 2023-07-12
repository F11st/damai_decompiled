package cn.damai.category.discountticket.bean.biz;

import cn.damai.category.discountticket.bean.HeaderData;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class FirstPageData extends SubscribeEvent {
    public List data;
    public boolean hasMore;
    public HeaderData headerData;

    public FirstPageData(boolean z, String str, String str2) {
        super(z, str, str2);
    }
}
