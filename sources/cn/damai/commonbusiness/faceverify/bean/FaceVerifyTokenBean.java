package cn.damai.commonbusiness.faceverify.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class FaceVerifyTokenBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<FaceVerifyTokenBean> CREATOR = new Parcelable.Creator<FaceVerifyTokenBean>() { // from class: cn.damai.commonbusiness.faceverify.bean.FaceVerifyTokenBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FaceVerifyTokenBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1380476731") ? (FaceVerifyTokenBean) ipChange.ipc$dispatch("1380476731", new Object[]{this, parcel}) : new FaceVerifyTokenBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FaceVerifyTokenBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1381664304") ? (FaceVerifyTokenBean[]) ipChange.ipc$dispatch("-1381664304", new Object[]{this, Integer.valueOf(i)}) : new FaceVerifyTokenBean[i];
        }
    };
    private String faceVerifyStatus;
    private String resultToken;
    private String verifyToken;

    public FaceVerifyTokenBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-751747121")) {
            return ((Integer) ipChange.ipc$dispatch("-751747121", new Object[]{this})).intValue();
        }
        return 0;
    }

    public String getFaceVerifyStatus() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2121283221") ? (String) ipChange.ipc$dispatch("2121283221", new Object[]{this}) : this.faceVerifyStatus;
    }

    public String getResultToken() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1619432037") ? (String) ipChange.ipc$dispatch("1619432037", new Object[]{this}) : this.resultToken;
    }

    public String getVerifyToken() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-228216439") ? (String) ipChange.ipc$dispatch("-228216439", new Object[]{this}) : this.verifyToken;
    }

    public void setFaceVerifyStatus(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "163475689")) {
            ipChange.ipc$dispatch("163475689", new Object[]{this, str});
        } else {
            this.faceVerifyStatus = str;
        }
    }

    public void setResultToken(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "657801649")) {
            ipChange.ipc$dispatch("657801649", new Object[]{this, str});
        } else {
            this.resultToken = str;
        }
    }

    public void setVerifyToken(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-784726259")) {
            ipChange.ipc$dispatch("-784726259", new Object[]{this, str});
        } else {
            this.verifyToken = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1290355492")) {
            ipChange.ipc$dispatch("-1290355492", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.faceVerifyStatus);
        parcel.writeString(this.verifyToken);
        parcel.writeString(this.resultToken);
    }

    protected FaceVerifyTokenBean(Parcel parcel) {
        this.faceVerifyStatus = parcel.readString();
        this.verifyToken = parcel.readString();
        this.resultToken = parcel.readString();
    }
}
