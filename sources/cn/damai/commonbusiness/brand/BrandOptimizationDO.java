package cn.damai.commonbusiness.brand;

import cn.damai.uikit.view.DMPosterView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class BrandOptimizationDO implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TYPE_COMING_PERFORMANCE = "3";
    private static final String TYPE_MOST_HOT = "1";
    private static final String TYPE_NEW_SALE = "2";
    public static final long serialVersionUID = 6813053541929103067L;
    public String city;
    public String cover;
    public String id;
    public String itemName;
    public String lable;
    public boolean local;
    public String schema;
    public String tagUrl;
    public String type;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0037, code lost:
        if (r0.equals("2") == false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private cn.damai.uikit.view.DMLabelType getDMLabelType() {
        /*
            r5 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.commonbusiness.brand.BrandOptimizationDO.$ipChange
            java.lang.String r1 = "1883753418"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L17
            java.lang.Object[] r2 = new java.lang.Object[r3]
            r2[r4] = r5
            java.lang.Object r0 = r0.ipc$dispatch(r1, r2)
            cn.damai.uikit.view.DMLabelType r0 = (cn.damai.uikit.view.DMLabelType) r0
            return r0
        L17:
            java.lang.String r0 = r5.type
            r0.hashCode()
            r1 = -1
            int r2 = r0.hashCode()
            switch(r2) {
                case 49: goto L3a;
                case 50: goto L31;
                case 51: goto L26;
                default: goto L24;
            }
        L24:
            r3 = -1
            goto L44
        L26:
            java.lang.String r2 = "3"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L2f
            goto L24
        L2f:
            r3 = 2
            goto L44
        L31:
            java.lang.String r2 = "2"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L44
            goto L24
        L3a:
            java.lang.String r2 = "1"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L43
            goto L24
        L43:
            r3 = 0
        L44:
            switch(r3) {
                case 0: goto L4f;
                case 1: goto L4c;
                case 2: goto L49;
                default: goto L47;
            }
        L47:
            r0 = 0
            return r0
        L49:
            cn.damai.uikit.view.DMLabelType r0 = cn.damai.uikit.view.DMLabelType.LABEL_TYPE_UPCOMING_PERFORMANCE
            return r0
        L4c:
            cn.damai.uikit.view.DMLabelType r0 = cn.damai.uikit.view.DMLabelType.LABEL_TYPE_NEW_SALE
            return r0
        L4f:
            cn.damai.uikit.view.DMLabelType r0 = cn.damai.uikit.view.DMLabelType.LABEL_TYPE_HIGHEST_HOT
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.commonbusiness.brand.BrandOptimizationDO.getDMLabelType():cn.damai.uikit.view.DMLabelType");
    }

    public void updatePosterView(DMPosterView dMPosterView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1408890430")) {
            ipChange.ipc$dispatch("-1408890430", new Object[]{this, dMPosterView});
        } else if (dMPosterView == null) {
        } else {
            dMPosterView.setImageUrl(this.cover);
            dMPosterView.setCategoryTagName(this.city);
            dMPosterView.setLabelType(getDMLabelType());
        }
    }
}
