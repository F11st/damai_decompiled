package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class RealNameVerifyResultBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<RealNameVerifyResultBean> CREATOR = new Parcelable.Creator<RealNameVerifyResultBean>() { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.RealNameVerifyResultBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RealNameVerifyResultBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "2070606645") ? (RealNameVerifyResultBean) ipChange.ipc$dispatch("2070606645", new Object[]{this, parcel}) : new RealNameVerifyResultBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RealNameVerifyResultBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1775888144") ? (RealNameVerifyResultBean[]) ipChange.ipc$dispatch("-1775888144", new Object[]{this, Integer.valueOf(i)}) : new RealNameVerifyResultBean[i];
        }
    };
    public String accountVerifyCode;
    public String accountVerifyMsg;
    public String faceVerifyCode;
    public String faceVerifyEnable;
    public String faceVerifyMsg;
    public List<RealNameVerifyRiskBean> materialDetail;
    public String mobile;
    public String verification;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public static class RealNameVerifyRiskBean implements Parcelable {
        private static transient /* synthetic */ IpChange $ipChange;
        public static final Parcelable.Creator<RealNameVerifyRiskBean> CREATOR = new Parcelable.Creator<RealNameVerifyRiskBean>() { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.RealNameVerifyResultBean.RealNameVerifyRiskBean.1
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RealNameVerifyRiskBean createFromParcel(Parcel parcel) {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-1085272053") ? (RealNameVerifyRiskBean) ipChange.ipc$dispatch("-1085272053", new Object[]{this, parcel}) : new RealNameVerifyRiskBean(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RealNameVerifyRiskBean[] newArray(int i) {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-1308804366") ? (RealNameVerifyRiskBean[]) ipChange.ipc$dispatch("-1308804366", new Object[]{this, Integer.valueOf(i)}) : new RealNameVerifyRiskBean[i];
            }
        };
        public String code;
        public String display;
        public String intercept;
        public String materialType;
        public String security;
        public String suggestion;
        public String text;
        public String type;

        public RealNameVerifyRiskBean() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-363183039")) {
                return ((Integer) ipChange.ipc$dispatch("-363183039", new Object[]{this})).intValue();
            }
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2087916886")) {
                ipChange.ipc$dispatch("-2087916886", new Object[]{this, parcel, Integer.valueOf(i)});
                return;
            }
            parcel.writeString(this.code);
            parcel.writeString(this.display);
            parcel.writeString(this.intercept);
            parcel.writeString(this.materialType);
            parcel.writeString(this.security);
            parcel.writeString(this.suggestion);
            parcel.writeString(this.text);
            parcel.writeString(this.type);
        }

        protected RealNameVerifyRiskBean(Parcel parcel) {
            this.code = parcel.readString();
            this.display = parcel.readString();
            this.intercept = parcel.readString();
            this.materialType = parcel.readString();
            this.security = parcel.readString();
            this.suggestion = parcel.readString();
            this.text = parcel.readString();
            this.type = parcel.readString();
        }
    }

    public RealNameVerifyResultBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1706910834")) {
            return ((Integer) ipChange.ipc$dispatch("1706910834", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1229319527")) {
            ipChange.ipc$dispatch("-1229319527", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.accountVerifyCode);
        parcel.writeString(this.accountVerifyMsg);
        parcel.writeString(this.faceVerifyCode);
        parcel.writeString(this.faceVerifyEnable);
        parcel.writeString(this.faceVerifyMsg);
        parcel.writeString(this.mobile);
        parcel.writeString(this.verification);
        parcel.writeTypedList(this.materialDetail);
    }

    protected RealNameVerifyResultBean(Parcel parcel) {
        this.accountVerifyCode = parcel.readString();
        this.accountVerifyMsg = parcel.readString();
        this.faceVerifyCode = parcel.readString();
        this.faceVerifyEnable = parcel.readString();
        this.faceVerifyMsg = parcel.readString();
        this.mobile = parcel.readString();
        this.verification = parcel.readString();
        this.materialDetail = parcel.createTypedArrayList(RealNameVerifyRiskBean.CREATOR);
    }
}
