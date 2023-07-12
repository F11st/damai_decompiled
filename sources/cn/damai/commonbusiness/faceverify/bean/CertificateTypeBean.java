package cn.damai.commonbusiness.faceverify.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class CertificateTypeBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<CertificateTypeBean> CREATOR = new Parcelable.Creator<CertificateTypeBean>() { // from class: cn.damai.commonbusiness.faceverify.bean.CertificateTypeBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CertificateTypeBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1169671455") ? (CertificateTypeBean) ipChange.ipc$dispatch("1169671455", new Object[]{this, parcel}) : new CertificateTypeBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CertificateTypeBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1876810512") ? (CertificateTypeBean[]) ipChange.ipc$dispatch("1876810512", new Object[]{this, Integer.valueOf(i)}) : new CertificateTypeBean[i];
        }
    };
    private List<ResultBean> result;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public static class ResultBean implements Parcelable {
        private static transient /* synthetic */ IpChange $ipChange;
        public static final Parcelable.Creator<ResultBean> CREATOR = new Parcelable.Creator<ResultBean>() { // from class: cn.damai.commonbusiness.faceverify.bean.CertificateTypeBean.ResultBean.1
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ResultBean createFromParcel(Parcel parcel) {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "637021035") ? (ResultBean) ipChange.ipc$dispatch("637021035", new Object[]{this, parcel}) : new ResultBean(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ResultBean[] newArray(int i) {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "2062588656") ? (ResultBean[]) ipChange.ipc$dispatch("2062588656", new Object[]{this, Integer.valueOf(i)}) : new ResultBean[i];
            }
        };
        private String identifyCode;
        private String identufyName;

        public ResultBean() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "953527298")) {
                return ((Integer) ipChange.ipc$dispatch("953527298", new Object[]{this})).intValue();
            }
            return 0;
        }

        public String getIdentifyCode() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "100153753") ? (String) ipChange.ipc$dispatch("100153753", new Object[]{this}) : this.identifyCode;
        }

        public String getIdentufyName() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "903042115") ? (String) ipChange.ipc$dispatch("903042115", new Object[]{this}) : this.identufyName;
        }

        public void setIdentifyCode(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-792319899")) {
                ipChange.ipc$dispatch("-792319899", new Object[]{this, str});
            } else {
                this.identifyCode = str;
            }
        }

        public void setIdentufyName(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1672584453")) {
                ipChange.ipc$dispatch("-1672584453", new Object[]{this, str});
            } else {
                this.identufyName = str;
            }
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2120736009")) {
                ipChange.ipc$dispatch("2120736009", new Object[]{this, parcel, Integer.valueOf(i)});
                return;
            }
            parcel.writeString(this.identifyCode);
            parcel.writeString(this.identufyName);
        }

        protected ResultBean(Parcel parcel) {
            this.identifyCode = parcel.readString();
            this.identufyName = parcel.readString();
        }
    }

    public CertificateTypeBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1399045795")) {
            return ((Integer) ipChange.ipc$dispatch("-1399045795", new Object[]{this})).intValue();
        }
        return 0;
    }

    public List<ResultBean> getResult() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-68441185") ? (List) ipChange.ipc$dispatch("-68441185", new Object[]{this}) : this.result;
    }

    public void setResult(List<ResultBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1508886771")) {
            ipChange.ipc$dispatch("-1508886771", new Object[]{this, list});
        } else {
            this.result = list;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "400115982")) {
            ipChange.ipc$dispatch("400115982", new Object[]{this, parcel, Integer.valueOf(i)});
        } else {
            parcel.writeList(this.result);
        }
    }

    protected CertificateTypeBean(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        this.result = arrayList;
        parcel.readList(arrayList, ResultBean.class.getClassLoader());
    }
}
