package cn.damai.commonbusiness.photoselect.imageselected.entry;

import android.content.Context;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$string;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class Image implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String ADD_IMAGE = "1";
    public static final String ADD_VIDEO = "2";
    public static final Parcelable.Creator<Image> CREATOR = new a();
    public static final String TAKE_PICTURE = "3";
    private long addDate;
    private String bucketId;
    private String bucketName;
    private long duration;
    private String durationShow;
    private boolean isLimitDur;
    private boolean isLimitSize;
    private boolean isNetImage;
    private String name;
    private String path;
    private int showNum;
    private long size;
    private String sizeShow;
    private String suffixType;
    private String thumbnail;
    private long time;
    private String title;
    private String type;
    public Uri uri;

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class a implements Parcelable.Creator<Image> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Image createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-208463027") ? (Image) ipChange.ipc$dispatch("-208463027", new Object[]{this, parcel}) : new Image(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public Image[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1685741712") ? (Image[]) ipChange.ipc$dispatch("-1685741712", new Object[]{this, Integer.valueOf(i)}) : new Image[i];
        }
    }

    public Image() {
        this.type = "1";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1484592154")) {
            return ((Integer) ipChange.ipc$dispatch("-1484592154", new Object[]{this})).intValue();
        }
        return 0;
    }

    public long getAddDate() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2015138035") ? ((Long) ipChange.ipc$dispatch("2015138035", new Object[]{this})).longValue() : this.addDate;
    }

    public String getBucketId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "778812809") ? (String) ipChange.ipc$dispatch("778812809", new Object[]{this}) : this.bucketId;
    }

    public String getBucketName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1185683001") ? (String) ipChange.ipc$dispatch("1185683001", new Object[]{this}) : this.bucketName;
    }

    public long getDuration() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1044520092") ? ((Long) ipChange.ipc$dispatch("1044520092", new Object[]{this})).longValue() : this.duration;
    }

    public String getDurationShow() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1885733611") ? (String) ipChange.ipc$dispatch("-1885733611", new Object[]{this}) : this.durationShow;
    }

    public String getName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1383562479") ? (String) ipChange.ipc$dispatch("1383562479", new Object[]{this}) : this.name;
    }

    public String getPath() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "502109577") ? (String) ipChange.ipc$dispatch("502109577", new Object[]{this}) : this.path;
    }

    public int getShowNum() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-695688360") ? ((Integer) ipChange.ipc$dispatch("-695688360", new Object[]{this})).intValue() : this.showNum;
    }

    public long getSize() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-11693425") ? ((Long) ipChange.ipc$dispatch("-11693425", new Object[]{this})).longValue() : this.size;
    }

    public String getSizeShow() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1118424322") ? (String) ipChange.ipc$dispatch("1118424322", new Object[]{this}) : this.sizeShow;
    }

    public String getSuffixType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1905744433") ? (String) ipChange.ipc$dispatch("-1905744433", new Object[]{this}) : this.suffixType;
    }

    public String getThumbnail() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "912177214") ? (String) ipChange.ipc$dispatch("912177214", new Object[]{this}) : this.thumbnail;
    }

    public long getTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "863804483") ? ((Long) ipChange.ipc$dispatch("863804483", new Object[]{this})).longValue() : this.time;
    }

    public String getTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "280917802") ? (String) ipChange.ipc$dispatch("280917802", new Object[]{this}) : this.title;
    }

    public String getType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1028103138") ? (String) ipChange.ipc$dispatch("-1028103138", new Object[]{this}) : this.type;
    }

    public boolean isImageLimit(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "46369054")) {
            return ((Boolean) ipChange.ipc$dispatch("46369054", new Object[]{this, context})).booleanValue();
        }
        if ((context != null && "2".equals(getType()) && isLimitDur()) || isLimitSize()) {
            if (isLimitDur()) {
                ToastUtil.a().e(context, context.getString(R$string.damai_video_dur_limit_tip));
            } else if (isLimitSize()) {
                ToastUtil.a().e(context, context.getString(R$string.damai_video_size_limit_tip));
            }
            return true;
        }
        return false;
    }

    public boolean isLimitDur() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1608007220") ? ((Boolean) ipChange.ipc$dispatch("-1608007220", new Object[]{this})).booleanValue() : this.isLimitDur;
    }

    public boolean isLimitSize() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1784690276") ? ((Boolean) ipChange.ipc$dispatch("1784690276", new Object[]{this})).booleanValue() : this.isLimitSize;
    }

    public boolean isNetImage() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-924153516") ? ((Boolean) ipChange.ipc$dispatch("-924153516", new Object[]{this})).booleanValue() : this.isNetImage;
    }

    public void setAddDate(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "568031513")) {
            ipChange.ipc$dispatch("568031513", new Object[]{this, Long.valueOf(j)});
        } else {
            this.addDate = j;
        }
    }

    public void setBucketId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1508934539")) {
            ipChange.ipc$dispatch("-1508934539", new Object[]{this, str});
        } else {
            this.bucketId = str;
        }
    }

    public void setBucketName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "286551237")) {
            ipChange.ipc$dispatch("286551237", new Object[]{this, str});
        } else {
            this.bucketName = str;
        }
    }

    public void setDuration(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1068832216")) {
            ipChange.ipc$dispatch("-1068832216", new Object[]{this, Long.valueOf(j)});
        } else {
            this.duration = j;
        }
    }

    public void setDurationShow(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2069681257")) {
            ipChange.ipc$dispatch("2069681257", new Object[]{this, str});
        } else {
            this.durationShow = str;
        }
    }

    public void setLimitDur(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1157829610")) {
            ipChange.ipc$dispatch("1157829610", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isLimitDur = z;
        }
    }

    public void setLimitSize(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "129145430")) {
            ipChange.ipc$dispatch("129145430", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isLimitSize = z;
        }
    }

    public void setName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-351992881")) {
            ipChange.ipc$dispatch("-351992881", new Object[]{this, str});
        } else {
            this.name = str;
        }
    }

    public void setNetImage(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "882457954")) {
            ipChange.ipc$dispatch("882457954", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isNetImage = z;
        }
    }

    public void setPath(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1907229067")) {
            ipChange.ipc$dispatch("-1907229067", new Object[]{this, str});
        } else {
            this.path = str;
        }
    }

    public void setShowNum(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1863209038")) {
            ipChange.ipc$dispatch("-1863209038", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.showNum = i;
        }
    }

    public void setSize(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-451045227")) {
            ipChange.ipc$dispatch("-451045227", new Object[]{this, Long.valueOf(j)});
        } else {
            this.size = j;
        }
    }

    public void setSizeShow(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "429087772")) {
            ipChange.ipc$dispatch("429087772", new Object[]{this, str});
        } else {
            this.sizeShow = str;
        }
    }

    public void setSuffixType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1058418705")) {
            ipChange.ipc$dispatch("-1058418705", new Object[]{this, str});
        } else {
            this.suffixType = str;
        }
    }

    public void setThumbnail(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "542484984")) {
            ipChange.ipc$dispatch("542484984", new Object[]{this, str});
        } else {
            this.thumbnail = str;
        }
    }

    public void setTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "919586145")) {
            ipChange.ipc$dispatch("919586145", new Object[]{this, Long.valueOf(j)});
        } else {
            this.time = j;
        }
    }

    public void setTitle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1685082484")) {
            ipChange.ipc$dispatch("-1685082484", new Object[]{this, str});
        } else {
            this.title = str;
        }
    }

    public void setType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2099182976")) {
            ipChange.ipc$dispatch("-2099182976", new Object[]{this, str});
        } else {
            this.type = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1746017883")) {
            ipChange.ipc$dispatch("-1746017883", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.path);
        parcel.writeLong(this.time);
        parcel.writeInt(this.showNum);
        parcel.writeByte(this.isNetImage ? (byte) 1 : (byte) 0);
        parcel.writeString(this.title);
        parcel.writeString(this.name);
        parcel.writeString(this.type);
        parcel.writeString(this.suffixType);
        parcel.writeString(this.thumbnail);
        parcel.writeLong(this.addDate);
        parcel.writeLong(this.duration);
        parcel.writeString(this.durationShow);
        parcel.writeLong(this.size);
        parcel.writeString(this.sizeShow);
        parcel.writeString(this.bucketId);
        parcel.writeString(this.bucketName);
        parcel.writeByte(this.isLimitDur ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isLimitSize ? (byte) 1 : (byte) 0);
    }

    public Image(String str, long j, String str2) {
        this.type = "1";
        this.path = str;
        this.time = j;
    }

    public Image(String str, long j, String str2, boolean z) {
        this.type = "1";
        this.path = str;
        this.time = j;
        this.isNetImage = z;
    }

    protected Image(Parcel parcel) {
        this.type = "1";
        this.path = parcel.readString();
        this.time = parcel.readLong();
        this.showNum = parcel.readInt();
        this.isNetImage = parcel.readByte() != 0;
        this.title = parcel.readString();
        this.name = parcel.readString();
        this.type = parcel.readString();
        this.suffixType = parcel.readString();
        this.thumbnail = parcel.readString();
        this.addDate = parcel.readLong();
        this.duration = parcel.readLong();
        this.durationShow = parcel.readString();
        this.size = parcel.readLong();
        this.sizeShow = parcel.readString();
        this.bucketId = parcel.readString();
        this.bucketName = parcel.readString();
        this.isLimitDur = parcel.readByte() != 0;
        this.isLimitSize = parcel.readByte() != 0;
    }
}
