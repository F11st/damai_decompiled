package cn.damai.category.discountticket.bean.biz;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ApplyResult {
    public String toastMsg;
    public boolean updateApplicable;
    public String updateUnapplicableCode;

    public ApplyResult(boolean z, String str, String str2) {
        this.updateApplicable = z;
        this.updateUnapplicableCode = str;
        this.toastMsg = str2;
    }
}
