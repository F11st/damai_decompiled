package cn.damai.user.repertoite.bean.comment;

import android.os.Parcel;
import android.os.Parcelable;
import cn.damai.comment.bean.CommentsItemBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class RepertoireDetailCommentBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<RepertoireDetailCommentBean> CREATOR = new Parcelable.Creator<RepertoireDetailCommentBean>() { // from class: cn.damai.user.repertoite.bean.comment.RepertoireDetailCommentBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RepertoireDetailCommentBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-579267663") ? (RepertoireDetailCommentBean) ipChange.ipc$dispatch("-579267663", new Object[]{this, parcel}) : new RepertoireDetailCommentBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RepertoireDetailCommentBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-456383440") ? (RepertoireDetailCommentBean[]) ipChange.ipc$dispatch("-456383440", new Object[]{this, Integer.valueOf(i)}) : new RepertoireDetailCommentBean[i];
        }
    };
    private RepertoireDetailCommentConfigureBean config;
    private List<CommentsItemBean> hotComments;
    private List<CommentsItemBean> moduleComments;
    private String total;
    private List<CommentsItemBean> userComments;

    public RepertoireDetailCommentBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1415789876")) {
            return ((Integer) ipChange.ipc$dispatch("1415789876", new Object[]{this})).intValue();
        }
        return 0;
    }

    public RepertoireDetailCommentConfigureBean getConfig() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1046572324") ? (RepertoireDetailCommentConfigureBean) ipChange.ipc$dispatch("-1046572324", new Object[]{this}) : this.config;
    }

    public List<CommentsItemBean> getHotComments() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1431568972") ? (List) ipChange.ipc$dispatch("1431568972", new Object[]{this}) : this.hotComments;
    }

    public List<CommentsItemBean> getModuleComments() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-89502951") ? (List) ipChange.ipc$dispatch("-89502951", new Object[]{this}) : this.moduleComments;
    }

    public String getTotal() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "58902664") ? (String) ipChange.ipc$dispatch("58902664", new Object[]{this}) : this.total;
    }

    public List<CommentsItemBean> getUserComments() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-594709128") ? (List) ipChange.ipc$dispatch("-594709128", new Object[]{this}) : this.userComments;
    }

    public void setConfig(RepertoireDetailCommentConfigureBean repertoireDetailCommentConfigureBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1371999378")) {
            ipChange.ipc$dispatch("1371999378", new Object[]{this, repertoireDetailCommentConfigureBean});
        } else {
            this.config = repertoireDetailCommentConfigureBean;
        }
    }

    public void setHotComments(List<CommentsItemBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "369307032")) {
            ipChange.ipc$dispatch("369307032", new Object[]{this, list});
        } else {
            this.hotComments = list;
        }
    }

    public void setModuleComments(List<CommentsItemBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1471163693")) {
            ipChange.ipc$dispatch("-1471163693", new Object[]{this, list});
        } else {
            this.moduleComments = list;
        }
    }

    public void setTotal(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "22382830")) {
            ipChange.ipc$dispatch("22382830", new Object[]{this, str});
        } else {
            this.total = str;
        }
    }

    public void setUserComments(List<CommentsItemBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1834516820")) {
            ipChange.ipc$dispatch("1834516820", new Object[]{this, list});
        } else {
            this.userComments = list;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1410110999")) {
            ipChange.ipc$dispatch("1410110999", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeParcelable(this.config, i);
        parcel.writeTypedList(this.userComments);
        parcel.writeTypedList(this.moduleComments);
        parcel.writeTypedList(this.hotComments);
        parcel.writeString(this.total);
    }

    protected RepertoireDetailCommentBean(Parcel parcel) {
        this.config = (RepertoireDetailCommentConfigureBean) parcel.readParcelable(RepertoireDetailCommentConfigureBean.class.getClassLoader());
        Parcelable.Creator<CommentsItemBean> creator = CommentsItemBean.CREATOR;
        this.userComments = parcel.createTypedArrayList(creator);
        this.moduleComments = parcel.createTypedArrayList(creator);
        this.hotComments = parcel.createTypedArrayList(creator);
        this.total = parcel.readString();
    }
}
