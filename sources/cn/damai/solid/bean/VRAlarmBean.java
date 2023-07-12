package cn.damai.solid.bean;

import android.os.Parcel;
import android.os.Parcelable;
import cn.damai.ticklet.ui.fragment.TicketDetailExtFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class VRAlarmBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final Parcelable.Creator<VRAlarmBean> CREATOR = new Parcelable.Creator<VRAlarmBean>() { // from class: cn.damai.solid.bean.VRAlarmBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VRAlarmBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "188919673") ? (VRAlarmBean) ipChange.ipc$dispatch("188919673", new Object[]{this, parcel}) : new VRAlarmBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VRAlarmBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-379909840") ? (VRAlarmBean[]) ipChange.ipc$dispatch("-379909840", new Object[]{this, Integer.valueOf(i)}) : new VRAlarmBean[i];
        }
    };
    public static final String VR_ALARM_KEY = "VR_ALARM_KEY";
    public String itemId;
    public String performId;

    public VRAlarmBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "826133936")) {
            return ((Integer) ipChange.ipc$dispatch("826133936", new Object[]{this})).intValue();
        }
        return 0;
    }

    public Map<String, String> toMap() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1545054308")) {
            return (Map) ipChange.ipc$dispatch("-1545054308", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("itemId", this.itemId);
        hashMap.put(TicketDetailExtFragment.PERFORM_ID, this.performId);
        return hashMap;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-867332837")) {
            ipChange.ipc$dispatch("-867332837", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.itemId);
        parcel.writeString(this.performId);
    }

    public VRAlarmBean(String str, String str2) {
        this.itemId = str;
        this.performId = str2;
    }

    protected VRAlarmBean(Parcel parcel) {
        this.itemId = parcel.readString();
        this.performId = parcel.readString();
    }
}
