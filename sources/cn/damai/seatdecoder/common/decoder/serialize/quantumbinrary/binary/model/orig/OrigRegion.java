package cn.damai.seatdecoder.common.decoder.serialize.quantumbinrary.binary.model.orig;

import cn.damai.seatdecoder.common.decoder.serialize.quantumbinrary.binary.model.Chair;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import tb.C9269io;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class OrigRegion {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<OrigChair> mChairList;
    private String mId;

    public OrigRegion() {
        this.mChairList = new ArrayList();
    }

    public int chairCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "918232079") ? ((Integer) ipChange.ipc$dispatch("918232079", new Object[]{this})).intValue() : this.mChairList.size();
    }

    public List<OrigChair> chairs() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2062289361") ? (List) ipChange.ipc$dispatch("-2062289361", new Object[]{this}) : this.mChairList;
    }

    public boolean equals(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1209951783")) {
            return ((Boolean) ipChange.ipc$dispatch("1209951783", new Object[]{this, obj})).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        OrigRegion origRegion = (OrigRegion) obj;
        if (this.mId.equals(origRegion.mId) && origRegion.chairs().size() == chairs().size()) {
            Collections.sort(origRegion.mChairList);
            Collections.sort(this.mChairList);
            for (int i = 0; i < chairs().size(); i++) {
                OrigChair origChair = chairs().get(i);
                OrigChair origChair2 = origRegion.chairs().get(i);
                if (!origChair.equals(origChair2)) {
                    C9269io.a("binary", "--------------------- verify: error chair -----------------------");
                    C9269io.a("binary", "[dest] this:" + origChair.toString());
                    C9269io.a("binary", "[ src] that:" + origChair2.toString());
                    return false;
                }
            }
            C9269io.a("binary", "region id:" + this.mId + "--------------------- verify: OK -----------------------");
            return true;
        }
        return false;
    }

    public int hashCode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1066301474") ? ((Integer) ipChange.ipc$dispatch("-1066301474", new Object[]{this})).intValue() : (this.mId.hashCode() * 31) + this.mChairList.hashCode();
    }

    public String id() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1924755541") ? (String) ipChange.ipc$dispatch("1924755541", new Object[]{this}) : this.mId;
    }

    public void init(String str, ArrayList<Chair> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "318066186")) {
            ipChange.ipc$dispatch("318066186", new Object[]{this, str, arrayList});
            return;
        }
        this.mId = str;
        this.mChairList.clear();
        Iterator<Chair> it = arrayList.iterator();
        while (it.hasNext()) {
            Chair next = it.next();
            OrigChair origChair = new OrigChair();
            origChair.setSid(next.sid);
            origChair.setX(next.x);
            origChair.setY(next.y);
            origChair.setFloorId(next.floorOrigin);
            origChair.setRowId(next.rowOrigin);
            origChair.setChairId(next.chairOrigin);
            origChair.setPriceId(next.priceId);
            origChair.setGroupId(next.groupId);
            origChair.setGroupPriceId(next.groupPriceId);
            origChair.setAngle(next.angle);
            origChair.setSecondIndex(next.secondIndex);
            this.mChairList.add(origChair);
        }
    }

    public void toXml(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "326350162")) {
            ipChange.ipc$dispatch("326350162", new Object[]{this, str});
        }
    }

    public OrigRegion(String str, List<OrigChair> list) {
        ArrayList arrayList = new ArrayList();
        this.mChairList = arrayList;
        this.mId = str;
        arrayList.clear();
        for (OrigChair origChair : list) {
            OrigChair origChair2 = new OrigChair();
            origChair2.setSid(origChair.getSid());
            origChair2.setX(origChair.getX());
            origChair2.setY(origChair.getY());
            origChair2.setFloorId(origChair.getFloorId());
            origChair2.setRowId(origChair.getRowId());
            origChair2.setChairId(origChair.getChairId());
            origChair2.setPriceId(origChair.getPriceId());
            origChair2.setGroupId(origChair.getGroupId());
            origChair2.setGroupPriceId(origChair.getGroupPriceId());
            origChair2.setAngle(origChair.getAngle());
            origChair2.setSecondIndex(origChair.getSecondIndex());
            this.mChairList.add(origChair2);
        }
    }
}
