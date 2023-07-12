package cn.damai.search.v2.bean;

import android.text.TextUtils;
import cn.damai.search.bean.IRankWordBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class RankWordBean implements IRankWordBean, Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String id;
    public int index;
    public String keyword;
    public String tagType;
    public String trend;
    public String type;
    public String url;

    private boolean isEquals(String str, String str2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2047072386") ? ((Boolean) ipChange.ipc$dispatch("2047072386", new Object[]{this, str, str2})).booleanValue() : TextUtils.equals(str, str2);
    }

    @Override // cn.damai.search.bean.IRankWordBean
    public String getRankWord() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1545143989") ? (String) ipChange.ipc$dispatch("1545143989", new Object[]{this}) : this.keyword;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004c, code lost:
        if (r0.equals("1") == false) goto L11;
     */
    @Override // cn.damai.search.bean.IRankWordBean
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String getTag4Ut() {
        /*
            r6 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.search.v2.bean.RankWordBean.$ipChange
            java.lang.String r1 = "-1252607240"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L17
            java.lang.Object[] r2 = new java.lang.Object[r4]
            r2[r3] = r6
            java.lang.Object r0 = r0.ipc$dispatch(r1, r2)
            java.lang.String r0 = (java.lang.String) r0
            return r0
        L17:
            java.lang.String r0 = r6.tagType
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 0
            if (r0 == 0) goto L21
            return r1
        L21:
            java.lang.String r0 = r6.tagType
            r0.hashCode()
            r2 = -1
            int r5 = r0.hashCode()
            switch(r5) {
                case 49: goto L46;
                case 50: goto L3b;
                case 51: goto L30;
                default: goto L2e;
            }
        L2e:
            r3 = -1
            goto L4f
        L30:
            java.lang.String r3 = "3"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L39
            goto L2e
        L39:
            r3 = 2
            goto L4f
        L3b:
            java.lang.String r3 = "2"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L44
            goto L2e
        L44:
            r3 = 1
            goto L4f
        L46:
            java.lang.String r4 = "1"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L4f
            goto L2e
        L4f:
            switch(r3) {
                case 0: goto L59;
                case 1: goto L56;
                case 2: goto L53;
                default: goto L52;
            }
        L52:
            return r1
        L53:
            java.lang.String r0 = "爆"
            return r0
        L56:
            java.lang.String r0 = "热"
            return r0
        L59:
            java.lang.String r0 = "新"
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.search.v2.bean.RankWordBean.getTag4Ut():java.lang.String");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0037, code lost:
        if (r0.equals("3") != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int getTagDrawableRid() {
        /*
            r5 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.search.v2.bean.RankWordBean.$ipChange
            java.lang.String r1 = "-465057377"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L1b
            java.lang.Object[] r2 = new java.lang.Object[r4]
            r2[r3] = r5
            java.lang.Object r0 = r0.ipc$dispatch(r1, r2)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            return r0
        L1b:
            java.lang.String r0 = r5.tagType
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L26
            int r0 = cn.damai.homepage.R$drawable.icon_new
            return r0
        L26:
            java.lang.String r0 = r5.tagType
            r1 = -1
            int r2 = r0.hashCode()
            switch(r2) {
                case 49: goto L44;
                case 50: goto L3a;
                case 51: goto L31;
                default: goto L30;
            }
        L30:
            goto L4e
        L31:
            java.lang.String r2 = "3"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L4e
            goto L4f
        L3a:
            java.lang.String r2 = "2"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L4e
            r3 = 1
            goto L4f
        L44:
            java.lang.String r2 = "1"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L4e
            r3 = 2
            goto L4f
        L4e:
            r3 = -1
        L4f:
            if (r3 == 0) goto L59
            if (r3 == r4) goto L56
            int r0 = cn.damai.homepage.R$drawable.icon_new
            return r0
        L56:
            int r0 = cn.damai.homepage.R$drawable.icon_hot
            return r0
        L59:
            int r0 = cn.damai.homepage.R$drawable.icon_bao
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.search.v2.bean.RankWordBean.getTagDrawableRid():int");
    }

    @Override // cn.damai.search.bean.IRankWordBean
    public String getTrend4Ut() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-954642283") ? (String) ipChange.ipc$dispatch("-954642283", new Object[]{this}) : TextUtils.isEmpty(this.trend) ? "-99" : this.trend;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x004a, code lost:
        if (r0.equals("1") != false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int getTrendDrawableRid() {
        /*
            r6 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.search.v2.bean.RankWordBean.$ipChange
            java.lang.String r1 = "-803078302"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L1b
            java.lang.Object[] r2 = new java.lang.Object[r4]
            r2[r3] = r6
            java.lang.Object r0 = r0.ipc$dispatch(r1, r2)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            return r0
        L1b:
            java.lang.String r0 = r6.trend
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L26
            int r0 = cn.damai.homepage.R$drawable.trend_normal
            return r0
        L26:
            java.lang.String r0 = r6.trend
            r1 = -1
            int r2 = r0.hashCode()
            r5 = 48
            if (r2 == r5) goto L4d
            r5 = 49
            if (r2 == r5) goto L44
            r3 = 1444(0x5a4, float:2.023E-42)
            if (r2 == r3) goto L3a
            goto L57
        L3a:
            java.lang.String r2 = "-1"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L57
            r3 = 1
            goto L58
        L44:
            java.lang.String r2 = "1"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L57
            goto L58
        L4d:
            java.lang.String r2 = "0"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L57
            r3 = 2
            goto L58
        L57:
            r3 = -1
        L58:
            if (r3 == 0) goto L62
            if (r3 == r4) goto L5f
            int r0 = cn.damai.homepage.R$drawable.trend_normal
            return r0
        L5f:
            int r0 = cn.damai.homepage.R$drawable.trend_down
            return r0
        L62:
            int r0 = cn.damai.homepage.R$drawable.trend_up
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.search.v2.bean.RankWordBean.getTrendDrawableRid():int");
    }

    @Override // cn.damai.search.bean.IRankWordBean
    public String getType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2118751385") ? (String) ipChange.ipc$dispatch("2118751385", new Object[]{this}) : this.type;
    }

    public boolean isShowTag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1128264808") ? ((Boolean) ipChange.ipc$dispatch("1128264808", new Object[]{this})).booleanValue() : isEquals(this.tagType, "1") || isEquals(this.tagType, "2") || isEquals(this.tagType, "3");
    }

    public boolean isShowTrend() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-152485563") ? ((Boolean) ipChange.ipc$dispatch("-152485563", new Object[]{this})).booleanValue() : isEquals(this.trend, "-1") || isEquals(this.trend, "1") || isEquals(this.trend, "0");
    }
}
