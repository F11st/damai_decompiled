package cn.damai.common.soloader;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class SoFileInfo implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<SoFileInfo> CREATOR = new a();
    private int downType;
    private String fileMD5;
    private boolean force;
    private String md5;
    private String name;
    private long size;
    private SoFileState state;
    private int type;
    private String url;

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public enum SoFileState {
        START,
        LOADING,
        END
    }

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public class a implements Parcelable.Creator<SoFileInfo> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SoFileInfo createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-739394871") ? (SoFileInfo) ipChange.ipc$dispatch("-739394871", new Object[]{this, parcel}) : new SoFileInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SoFileInfo[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1981199152") ? (SoFileInfo[]) ipChange.ipc$dispatch("1981199152", new Object[]{this, Integer.valueOf(i)}) : new SoFileInfo[i];
        }
    }

    public SoFileInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-246389688")) {
            return ((Integer) ipChange.ipc$dispatch("-246389688", new Object[]{this})).intValue();
        }
        return 0;
    }

    public int getDownType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1124311919") ? ((Integer) ipChange.ipc$dispatch("-1124311919", new Object[]{this})).intValue() : this.downType;
    }

    public String getFileMD5() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2002698510") ? (String) ipChange.ipc$dispatch("-2002698510", new Object[]{this}) : this.fileMD5;
    }

    public String getMd5() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-361122194") ? (String) ipChange.ipc$dispatch("-361122194", new Object[]{this}) : this.md5;
    }

    public String getName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1434415953") ? (String) ipChange.ipc$dispatch("1434415953", new Object[]{this}) : this.name;
    }

    public long getSize() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1237400595") ? ((Long) ipChange.ipc$dispatch("-1237400595", new Object[]{this})).longValue() : this.size;
    }

    public SoFileState getState() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1328373694") ? (SoFileState) ipChange.ipc$dispatch("1328373694", new Object[]{this}) : this.state;
    }

    public int getType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "98934291") ? ((Integer) ipChange.ipc$dispatch("98934291", new Object[]{this})).intValue() : this.type;
    }

    public String getUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1278440415") ? (String) ipChange.ipc$dispatch("1278440415", new Object[]{this}) : this.url;
    }

    public boolean isForce() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-413162413") ? ((Boolean) ipChange.ipc$dispatch("-413162413", new Object[]{this})).booleanValue() : this.force;
    }

    public void setDownType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "416851249")) {
            ipChange.ipc$dispatch("416851249", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.downType = i;
        }
    }

    public void setFileMD5(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "724602052")) {
            ipChange.ipc$dispatch("724602052", new Object[]{this, str});
        } else {
            this.fileMD5 = str;
        }
    }

    public void setForce(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1099005245")) {
            ipChange.ipc$dispatch("-1099005245", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.force = z;
        }
    }

    public void setMd5(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1186305336")) {
            ipChange.ipc$dispatch("-1186305336", new Object[]{this, str});
        } else {
            this.md5 = str;
        }
    }

    public void setName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1224464813")) {
            ipChange.ipc$dispatch("1224464813", new Object[]{this, str});
        } else {
            this.name = str;
        }
    }

    public void setSize(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "206738167")) {
            ipChange.ipc$dispatch("206738167", new Object[]{this, Long.valueOf(j)});
        } else {
            this.size = j;
        }
    }

    public void setState(SoFileState soFileState) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-523100508")) {
            ipChange.ipc$dispatch("-523100508", new Object[]{this, soFileState});
        } else {
            this.state = soFileState;
        }
    }

    public void setType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1316554257")) {
            ipChange.ipc$dispatch("-1316554257", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.type = i;
        }
    }

    public void setUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1899472009")) {
            ipChange.ipc$dispatch("-1899472009", new Object[]{this, str});
        } else {
            this.url = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "597162371")) {
            ipChange.ipc$dispatch("597162371", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.url);
        parcel.writeInt(this.type);
        parcel.writeString(this.md5);
        parcel.writeString(this.name);
        parcel.writeLong(this.size);
        parcel.writeInt(this.downType);
    }

    protected SoFileInfo(Parcel parcel) {
        this.url = parcel.readString();
        this.type = parcel.readInt();
        this.md5 = parcel.readString();
        this.name = parcel.readString();
        this.size = parcel.readLong();
        this.downType = parcel.readInt();
    }
}
