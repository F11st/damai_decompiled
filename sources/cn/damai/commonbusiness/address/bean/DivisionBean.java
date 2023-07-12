package cn.damai.commonbusiness.address.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class DivisionBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<DivisionBean> CREATOR = new Parcelable.Creator<DivisionBean>() { // from class: cn.damai.commonbusiness.address.bean.DivisionBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DivisionBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "535853139") ? (DivisionBean) ipChange.ipc$dispatch("535853139", new Object[]{this, parcel}) : new DivisionBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DivisionBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-2093323632") ? (DivisionBean[]) ipChange.ipc$dispatch("-2093323632", new Object[]{this, Integer.valueOf(i)}) : new DivisionBean[i];
        }
    };
    private String damaiDivisionId;
    private String damaiDivisionName;
    private String divisionAbbName;
    private String divisionId;
    private String divisionLevel;
    private String divisionName;
    private String divisionZip;
    private String handTag;
    private String parentId;
    private String pinyin;

    public DivisionBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2027308227")) {
            return ((Integer) ipChange.ipc$dispatch("2027308227", new Object[]{this})).intValue();
        }
        return 0;
    }

    public String getDamaiDivisionId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-465514347") ? (String) ipChange.ipc$dispatch("-465514347", new Object[]{this}) : this.damaiDivisionId;
    }

    public String getDamaiDivisionName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-611805627") ? (String) ipChange.ipc$dispatch("-611805627", new Object[]{this}) : this.damaiDivisionName;
    }

    public String getDivisionAbbName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-604106828") ? (String) ipChange.ipc$dispatch("-604106828", new Object[]{this}) : this.divisionAbbName;
    }

    public String getDivisionId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-45322263") ? (String) ipChange.ipc$dispatch("-45322263", new Object[]{this}) : this.divisionId;
    }

    public String getDivisionLevel() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1723065324") ? (String) ipChange.ipc$dispatch("1723065324", new Object[]{this}) : this.divisionLevel;
    }

    public String getDivisionName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-534138727") ? (String) ipChange.ipc$dispatch("-534138727", new Object[]{this}) : this.divisionName;
    }

    public String getDivisionZip() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "718320201") ? (String) ipChange.ipc$dispatch("718320201", new Object[]{this}) : this.divisionZip;
    }

    public String getHandTag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-643715264") ? (String) ipChange.ipc$dispatch("-643715264", new Object[]{this}) : this.handTag;
    }

    public String getParentId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "475586982") ? (String) ipChange.ipc$dispatch("475586982", new Object[]{this}) : this.parentId;
    }

    public String getPinyin() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2049346410") ? (String) ipChange.ipc$dispatch("2049346410", new Object[]{this}) : this.pinyin;
    }

    public void setDamaiDivisionId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1264229503")) {
            ipChange.ipc$dispatch("-1264229503", new Object[]{this, str});
        } else {
            this.damaiDivisionId = str;
        }
    }

    public void setDamaiDivisionName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-775110447")) {
            ipChange.ipc$dispatch("-775110447", new Object[]{this, str});
        } else {
            this.damaiDivisionName = str;
        }
    }

    public void setDivisionAbbName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1265629118")) {
            ipChange.ipc$dispatch("-1265629118", new Object[]{this, str});
        } else {
            this.divisionAbbName = str;
        }
    }

    public void setDivisionId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "780093717")) {
            ipChange.ipc$dispatch("780093717", new Object[]{this, str});
        } else {
            this.divisionId = str;
        }
    }

    public void setDivisionLevel(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "6753802")) {
            ipChange.ipc$dispatch("6753802", new Object[]{this, str});
        } else {
            this.divisionLevel = str;
        }
    }

    public void setDivisionName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1019449701")) {
            ipChange.ipc$dispatch("1019449701", new Object[]{this, str});
        } else {
            this.divisionName = str;
        }
    }

    public void setDivisionZip(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1506861491")) {
            ipChange.ipc$dispatch("-1506861491", new Object[]{this, str});
        } else {
            this.divisionZip = str;
        }
    }

    public void setHandTag(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-96590282")) {
            ipChange.ipc$dispatch("-96590282", new Object[]{this, str});
        } else {
            this.handTag = str;
        }
    }

    public void setParentId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1975966712")) {
            ipChange.ipc$dispatch("1975966712", new Object[]{this, str});
        } else {
            this.parentId = str;
        }
    }

    public void setPinyin(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2005104564")) {
            ipChange.ipc$dispatch("2005104564", new Object[]{this, str});
        } else {
            this.pinyin = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "245743208")) {
            ipChange.ipc$dispatch("245743208", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.damaiDivisionId);
        parcel.writeString(this.damaiDivisionName);
        parcel.writeString(this.divisionAbbName);
        parcel.writeString(this.divisionId);
        parcel.writeString(this.divisionLevel);
        parcel.writeString(this.divisionName);
        parcel.writeString(this.divisionZip);
        parcel.writeString(this.handTag);
        parcel.writeString(this.parentId);
        parcel.writeString(this.pinyin);
    }

    protected DivisionBean(Parcel parcel) {
        this.damaiDivisionId = parcel.readString();
        this.damaiDivisionName = parcel.readString();
        this.divisionAbbName = parcel.readString();
        this.divisionId = parcel.readString();
        this.divisionLevel = parcel.readString();
        this.divisionName = parcel.readString();
        this.divisionZip = parcel.readString();
        this.handTag = parcel.readString();
        this.parentId = parcel.readString();
        this.pinyin = parcel.readString();
    }
}
