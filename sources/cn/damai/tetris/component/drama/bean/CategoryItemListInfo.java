package cn.damai.tetris.component.drama.bean;

import androidx.annotation.NonNull;
import cn.damai.tetris.v2.structure.section.ISection;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import tb.m61;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class CategoryItemListInfo implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int PAGE_SIZE = 15;
    private static final long serialVersionUID = 2566111111706503L;
    public int currentCitySize;
    public boolean findComponent;
    public int nearByCitySize;
    public String targetLayerId;
    public String targetSectionId;
    public int total;

    public CategoryItemListInfo() {
    }

    public static CategoryItemListInfo defaultItem() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "70651612") ? (CategoryItemListInfo) ipChange.ipc$dispatch("70651612", new Object[0]) : new CategoryItemListInfo(0, 0, 0, false);
    }

    @NonNull
    public static CategoryItemListInfo obtainFromSection(ISection iSection, CategoryItemListInfo categoryItemListInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "456548045")) {
            return (CategoryItemListInfo) ipChange.ipc$dispatch("456548045", new Object[]{iSection, categoryItemListInfo});
        }
        CategoryItemListInfo categoryItemListInfo2 = null;
        if (iSection != null) {
            try {
                if (iSection.getItem() != null) {
                    categoryItemListInfo2 = (CategoryItemListInfo) m61.d(iSection.getItem().getJSONObject("itemInfo"), CategoryItemListInfo.class);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return categoryItemListInfo2 == null ? categoryItemListInfo : categoryItemListInfo2;
    }

    public int getCurAndNearCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "731495453") ? ((Integer) ipChange.ipc$dispatch("731495453", new Object[]{this})).intValue() : this.currentCitySize + this.nearByCitySize;
    }

    public boolean hasListSize() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1525509233") ? ((Boolean) ipChange.ipc$dispatch("1525509233", new Object[]{this})).booleanValue() : getCurAndNearCount() > 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:
        if (r6.nearByCitySize >= 15) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003f, code lost:
        if (r6.nearByCitySize >= 15) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
        r4 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean isCanRequestNextPage(boolean r7, int r8) {
        /*
            r6 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.tetris.component.drama.bean.CategoryItemListInfo.$ipChange
            java.lang.String r1 = "-1018720148"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 3
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L29
            java.lang.Object[] r2 = new java.lang.Object[r3]
            r2[r4] = r6
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            r2[r5] = r7
            r7 = 2
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r2[r7] = r8
            java.lang.Object r7 = r0.ipc$dispatch(r1, r2)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            return r7
        L29:
            boolean r0 = r6.findComponent
            if (r0 != 0) goto L2e
            return r4
        L2e:
            r0 = 15
            if (r7 == 0) goto L3d
            if (r8 > r5) goto L43
            int r7 = r6.currentCitySize
            if (r7 > r3) goto L43
            int r7 = r6.nearByCitySize
            if (r7 < r0) goto L42
            goto L41
        L3d:
            int r7 = r6.nearByCitySize
            if (r7 < r0) goto L42
        L41:
            r4 = 1
        L42:
            r5 = r4
        L43:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.tetris.component.drama.bean.CategoryItemListInfo.isCanRequestNextPage(boolean, int):boolean");
    }

    public boolean isCurrentCityEnd(int i) {
        int i2;
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "722915972") ? ((Boolean) ipChange.ipc$dispatch("722915972", new Object[]{this, Integer.valueOf(i)})).booleanValue() : !this.findComponent || (i2 = this.currentCitySize) <= 0 || i + i2 >= this.total;
    }

    public CategoryItemListInfo(int i, int i2, int i3, boolean z) {
        this.total = i;
        this.currentCitySize = i2;
        this.nearByCitySize = i3;
        this.findComponent = z;
    }
}
