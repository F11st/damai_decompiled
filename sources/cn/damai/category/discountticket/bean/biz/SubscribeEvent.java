package cn.damai.category.discountticket.bean.biz;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class SubscribeEvent {
    public final String code;
    public final String msg;
    public final boolean success;

    public SubscribeEvent(boolean z, String str, String str2) {
        this.success = z;
        this.code = str;
        this.msg = str2;
    }
}
