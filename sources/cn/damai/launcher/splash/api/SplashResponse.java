package cn.damai.launcher.splash.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.jm1;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class SplashResponse implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final Parcelable.Creator<SplashResponse> CREATOR = new Parcelable.Creator<SplashResponse>() { // from class: cn.damai.launcher.splash.api.SplashResponse.1
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SplashResponse createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-956104287") ? (SplashResponse) ipChange.ipc$dispatch("-956104287", new Object[]{this, parcel}) : new SplashResponse(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SplashResponse[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-379485008") ? (SplashResponse[]) ipChange.ipc$dispatch("-379485008", new Object[]{this, Integer.valueOf(i)}) : new SplashResponse[i];
        }
    };
    public static final int DEFAULT_DURATION = 3;
    public static final int LABEL_HIDE = 0;
    public static final int LABEL_SHOW = 1;
    public static final int SKIPPABLE_DISABLE = 0;
    public static final int SKIPPABLE_ENABLE = 1;
    private String clickJumpDescription;
    public String comboDispatchId;
    public String comboDispatchSystem;
    private String diffCityId;
    private String displayDuration;
    private String endTime;
    private boolean isAdSupportUseCache;
    private String os;
    private String pic;
    private String pic2;
    private String schema;
    private String scm;
    private String showLabel;
    private String skippable;
    private String startTime;

    protected SplashResponse(Parcel parcel) {
        this.isAdSupportUseCache = true;
        this.schema = parcel.readString();
        this.os = parcel.readString();
        this.pic = parcel.readString();
        this.scm = parcel.readString();
        this.pic2 = parcel.readString();
        this.skippable = parcel.readString();
        this.displayDuration = parcel.readString();
        this.showLabel = parcel.readString();
        this.clickJumpDescription = parcel.readString();
        this.startTime = parcel.readString();
        this.endTime = parcel.readString();
        this.isAdSupportUseCache = parcel.readByte() != 0;
        this.comboDispatchSystem = parcel.readString();
        this.comboDispatchId = parcel.readString();
        this.diffCityId = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1718859868")) {
            return ((Integer) ipChange.ipc$dispatch("1718859868", new Object[]{this})).intValue();
        }
        return 0;
    }

    public String getClickJumpDescription() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1396338592") ? (String) ipChange.ipc$dispatch("1396338592", new Object[]{this}) : this.clickJumpDescription;
    }

    public String getDiffCityId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1553119771") ? (String) ipChange.ipc$dispatch("-1553119771", new Object[]{this}) : this.diffCityId;
    }

    public String getDisplayDuration() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1556960942") ? (String) ipChange.ipc$dispatch("-1556960942", new Object[]{this}) : this.displayDuration;
    }

    public int getDisplayDurationInt() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "33780992")) {
            return ((Integer) ipChange.ipc$dispatch("33780992", new Object[]{this})).intValue();
        }
        if (wh2.j(this.displayDuration)) {
            return 3;
        }
        try {
            int intValue = Integer.valueOf(this.displayDuration).intValue();
            if (intValue <= 0) {
                return 3;
            }
            return intValue;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 3;
        }
    }

    public String getEndTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1805168420") ? (String) ipChange.ipc$dispatch("1805168420", new Object[]{this}) : this.endTime;
    }

    public String getOs() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "747452414") ? (String) ipChange.ipc$dispatch("747452414", new Object[]{this}) : this.os;
    }

    public String getPic() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1158352410") ? (String) ipChange.ipc$dispatch("-1158352410", new Object[]{this}) : this.pic;
    }

    public String getPic2() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2025510846") ? (String) ipChange.ipc$dispatch("-2025510846", new Object[]{this}) : this.pic2;
    }

    public String getSchema() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "793927611") ? (String) ipChange.ipc$dispatch("793927611", new Object[]{this}) : this.schema;
    }

    public String getScm() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-262081287") ? (String) ipChange.ipc$dispatch("-262081287", new Object[]{this}) : this.scm;
    }

    public String getShowLabel() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1350885101") ? (String) ipChange.ipc$dispatch("-1350885101", new Object[]{this}) : this.showLabel;
    }

    public int getShowLabelInt() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1049746815")) {
            return ((Integer) ipChange.ipc$dispatch("-1049746815", new Object[]{this})).intValue();
        }
        if (wh2.j(this.showLabel)) {
            return 1;
        }
        try {
            int intValue = Integer.valueOf(this.showLabel).intValue();
            if (intValue != 0) {
                return 1;
            }
            return intValue;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 1;
        }
    }

    public String getSkippable() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "156943559") ? (String) ipChange.ipc$dispatch("156943559", new Object[]{this}) : this.skippable;
    }

    public int getSkippableInt() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-283143883")) {
            return ((Integer) ipChange.ipc$dispatch("-283143883", new Object[]{this})).intValue();
        }
        if (wh2.j(this.skippable)) {
            return 1;
        }
        try {
            int intValue = Integer.valueOf(this.skippable).intValue();
            if (intValue != 0) {
                return 1;
            }
            return intValue;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 1;
        }
    }

    public String getStartTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1939077781") ? (String) ipChange.ipc$dispatch("-1939077781", new Object[]{this}) : this.startTime;
    }

    public boolean isAdEndTimeOverCurrentTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "77995163") ? ((Boolean) ipChange.ipc$dispatch("77995163", new Object[]{this})).booleanValue() : TextUtils.isEmpty(this.endTime) || System.currentTimeMillis() >= jm1.k(this.endTime, -1L);
    }

    public boolean isAdSupportUseCache() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "970780963") ? ((Boolean) ipChange.ipc$dispatch("970780963", new Object[]{this})).booleanValue() : this.isAdSupportUseCache;
    }

    public boolean isPicUrlValid() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1207421709") ? ((Boolean) ipChange.ipc$dispatch("-1207421709", new Object[]{this})).booleanValue() : !wh2.j(this.pic);
    }

    public void setAdSupportUseCache(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1832329547")) {
            ipChange.ipc$dispatch("1832329547", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isAdSupportUseCache = z;
        }
    }

    public void setClickJumpDescription(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-605487298")) {
            ipChange.ipc$dispatch("-605487298", new Object[]{this, str});
        } else {
            this.clickJumpDescription = str;
        }
    }

    public void setDiffCityId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1283011225")) {
            ipChange.ipc$dispatch("1283011225", new Object[]{this, str});
        } else {
            this.diffCityId = str;
        }
    }

    public void setDisplayDuration(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-739335580")) {
            ipChange.ipc$dispatch("-739335580", new Object[]{this, str});
        } else {
            this.displayDuration = str;
        }
    }

    public void setEndTime(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1490607406")) {
            ipChange.ipc$dispatch("-1490607406", new Object[]{this, str});
        } else {
            this.endTime = str;
        }
    }

    public void setOs(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "537540512")) {
            ipChange.ipc$dispatch("537540512", new Object[]{this, str});
        } else {
            this.os = str;
        }
    }

    public void setPic(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-130638256")) {
            ipChange.ipc$dispatch("-130638256", new Object[]{this, str});
        } else {
            this.pic = str;
        }
    }

    public void setPic2(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1340916444")) {
            ipChange.ipc$dispatch("1340916444", new Object[]{this, str});
        } else {
            this.pic2 = str;
        }
    }

    public void setSchema(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1741827459")) {
            ipChange.ipc$dispatch("1741827459", new Object[]{this, str});
        } else {
            this.schema = str;
        }
    }

    public void setScm(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1883962781")) {
            ipChange.ipc$dispatch("1883962781", new Object[]{this, str});
        } else {
            this.scm = str;
        }
    }

    public void setShowLabel(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-892970045")) {
            ipChange.ipc$dispatch("-892970045", new Object[]{this, str});
        } else {
            this.showLabel = str;
        }
    }

    public void setSkippable(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1394921841")) {
            ipChange.ipc$dispatch("-1394921841", new Object[]{this, str});
        } else {
            this.skippable = str;
        }
    }

    public void setStartTime(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1947073941")) {
            ipChange.ipc$dispatch("-1947073941", new Object[]{this, str});
        } else {
            this.startTime = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1919733743")) {
            ipChange.ipc$dispatch("1919733743", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.schema);
        parcel.writeString(this.os);
        parcel.writeString(this.pic);
        parcel.writeString(this.scm);
        parcel.writeString(this.pic2);
        parcel.writeString(this.skippable);
        parcel.writeString(this.displayDuration);
        parcel.writeString(this.showLabel);
        parcel.writeString(this.clickJumpDescription);
        parcel.writeString(this.startTime);
        parcel.writeString(this.endTime);
        parcel.writeByte(this.isAdSupportUseCache ? (byte) 1 : (byte) 0);
        parcel.writeString(this.comboDispatchSystem);
        parcel.writeString(this.comboDispatchId);
        parcel.writeString(this.diffCityId);
    }

    public SplashResponse() {
        this.isAdSupportUseCache = true;
    }
}
