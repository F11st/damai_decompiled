package cn.damai.seat.bean;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.SeatNew;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import tb.cb2;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class SeatGroup {
    private static transient /* synthetic */ IpChange $ipChange;
    private String equals;
    public final boolean isPackage;
    public final String kanTaiId;
    public List<SeatNew> packageList;
    public final long priceId;
    private String sids;
    public SeatNew single;

    public SeatGroup(SeatNew seatNew) {
        this.isPackage = false;
        this.priceId = seatNew.priceLevel;
        this.kanTaiId = seatNew.kanTaiId;
        this.single = seatNew;
        this.sids = seatNew.sid + "";
        this.equals = get();
    }

    public static SeatGroup makePackage(List<SeatNew> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2046745545")) {
            return (SeatGroup) ipChange.ipc$dispatch("-2046745545", new Object[]{list});
        }
        if (cb2.d(list)) {
            return null;
        }
        return new SeatGroup(list);
    }

    public static SeatGroup makeSingle(SeatNew seatNew) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-27990257")) {
            return (SeatGroup) ipChange.ipc$dispatch("-27990257", new Object[]{seatNew});
        }
        if (seatNew == null) {
            return null;
        }
        return new SeatGroup(seatNew);
    }

    public boolean equals(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-792218016")) {
            return ((Boolean) ipChange.ipc$dispatch("-792218016", new Object[]{this, obj})).booleanValue();
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof SeatGroup) {
            return TextUtils.equals(((SeatGroup) obj).equals, this.equals);
        }
        return false;
    }

    public String get() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-630808629")) {
            return (String) ipChange.ipc$dispatch("-630808629", new Object[]{this});
        }
        return this.priceId + "" + this.isPackage + "" + this.sids;
    }

    public String getKanTaiName() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-691427910")) {
            return (String) ipChange.ipc$dispatch("-691427910", new Object[]{this});
        }
        if (this.isPackage) {
            if (cb2.d(this.packageList)) {
                return null;
            }
            return this.packageList.get(0).kanTaiName;
        }
        SeatNew seatNew = this.single;
        if (seatNew != null) {
            return seatNew.kanTaiName;
        }
        return null;
    }

    public SeatGroup(@NonNull List<SeatNew> list) {
        this.isPackage = true;
        ArrayList arrayList = new ArrayList(list);
        this.packageList = arrayList;
        Collections.sort(arrayList, new Comparator<SeatNew>() { // from class: cn.damai.seat.bean.SeatGroup.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.util.Comparator
            public int compare(SeatNew seatNew, SeatNew seatNew2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1718855724")) {
                    return ((Integer) ipChange.ipc$dispatch("1718855724", new Object[]{this, seatNew, seatNew2})).intValue();
                }
                return (seatNew.sid + "").compareTo(seatNew2.sid + "");
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.packageList.size(); i++) {
            sb.append(this.packageList.get(i).sid);
        }
        this.sids = sb.toString();
        SeatNew seatNew = this.packageList.get(0);
        this.priceId = seatNew.packagedPriceIndexId;
        this.kanTaiId = seatNew.kanTaiId;
        this.equals = get();
    }
}
