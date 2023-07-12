package cn.damai.issue.net;

import android.os.Parcel;
import android.os.Parcelable;
import cn.damai.comment.bean.DmInfo;
import cn.damai.comment.bean.StoreInfo;
import cn.damai.commonbusiness.scriptmurder.bean.ScriptBean;
import cn.damai.tetris.component.brand.bean.ProjectDO;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class IssueRenderResponse implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<IssueRenderResponse> CREATOR = new Parcelable.Creator<IssueRenderResponse>() { // from class: cn.damai.issue.net.IssueRenderResponse.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IssueRenderResponse createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "663607723") ? (IssueRenderResponse) ipChange.ipc$dispatch("663607723", new Object[]{this, parcel}) : new IssueRenderResponse(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IssueRenderResponse[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1771136556") ? (IssueRenderResponse[]) ipChange.ipc$dispatch("-1771136556", new Object[]{this, Integer.valueOf(i)}) : new IssueRenderResponse[i];
        }
    };
    List<String> IconTitle;
    public String associatedScriptNum;
    public String associatedStoreNum;
    private List<String> categoryTags;
    private ArrayList<CommentGradeText> commentGradeTexts;
    List<DmInfo> dmInfoList;
    private List<CommentGradeTagBean> gradeTags;
    String itemType;
    private NoticeInfo noticeInfo;
    public ProjectDO projectDO;
    public ScriptBean scriptInfo;
    StoreInfo storeInfo;

    public IssueRenderResponse() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "55281872")) {
            return ((Integer) ipChange.ipc$dispatch("55281872", new Object[]{this})).intValue();
        }
        return 0;
    }

    public List<String> getCategoryTags() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-239624852") ? (List) ipChange.ipc$dispatch("-239624852", new Object[]{this}) : this.categoryTags;
    }

    public ArrayList<CommentGradeText> getCommentGradeTexts() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "967365892") ? (ArrayList) ipChange.ipc$dispatch("967365892", new Object[]{this}) : this.commentGradeTexts;
    }

    public List<DmInfo> getDmInfoList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1035770506") ? (List) ipChange.ipc$dispatch("1035770506", new Object[]{this}) : this.dmInfoList;
    }

    public List<CommentGradeTagBean> getGradeTags() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-908065") ? (List) ipChange.ipc$dispatch("-908065", new Object[]{this}) : this.gradeTags;
    }

    public List<String> getIconTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1150589970") ? (List) ipChange.ipc$dispatch("-1150589970", new Object[]{this}) : this.IconTitle;
    }

    public String getItemType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1539468357") ? (String) ipChange.ipc$dispatch("-1539468357", new Object[]{this}) : this.itemType;
    }

    public NoticeInfo getNoticeInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "415739700") ? (NoticeInfo) ipChange.ipc$dispatch("415739700", new Object[]{this}) : this.noticeInfo;
    }

    public StoreInfo getStoreInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "45575295") ? (StoreInfo) ipChange.ipc$dispatch("45575295", new Object[]{this}) : this.storeInfo;
    }

    public void readFromParcel(Parcel parcel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1208429876")) {
            ipChange.ipc$dispatch("1208429876", new Object[]{this, parcel});
            return;
        }
        this.categoryTags = parcel.createStringArrayList();
        this.gradeTags = parcel.createTypedArrayList(CommentGradeTagBean.CREATOR);
        this.noticeInfo = (NoticeInfo) parcel.readParcelable(NoticeInfo.class.getClassLoader());
        this.commentGradeTexts = parcel.createTypedArrayList(CommentGradeText.CREATOR);
        this.itemType = (String) parcel.readValue(String.class.getClassLoader());
        this.storeInfo = (StoreInfo) parcel.readSerializable();
        ArrayList arrayList = new ArrayList();
        this.dmInfoList = arrayList;
        parcel.readList(arrayList, DmInfo.class.getClassLoader());
        this.IconTitle = parcel.createStringArrayList();
    }

    public void setCategoryTags(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-42772512")) {
            ipChange.ipc$dispatch("-42772512", new Object[]{this, list});
        } else {
            this.categoryTags = list;
        }
    }

    public void setCommentGradeTexts(ArrayList<CommentGradeText> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1201782324")) {
            ipChange.ipc$dispatch("1201782324", new Object[]{this, arrayList});
        } else {
            this.commentGradeTexts = arrayList;
        }
    }

    public void setDmInfoList(List<DmInfo> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1227633790")) {
            ipChange.ipc$dispatch("-1227633790", new Object[]{this, list});
        } else {
            this.dmInfoList = list;
        }
    }

    public void setGradeTags(List<CommentGradeTagBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-738856859")) {
            ipChange.ipc$dispatch("-738856859", new Object[]{this, list});
        } else {
            this.gradeTags = list;
        }
    }

    public void setIconTitle(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2019257546")) {
            ipChange.ipc$dispatch("-2019257546", new Object[]{this, list});
        } else {
            this.IconTitle = list;
        }
    }

    public void setItemType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-361206653")) {
            ipChange.ipc$dispatch("-361206653", new Object[]{this, str});
        } else {
            this.itemType = str;
        }
    }

    public void setNoticeInfo(NoticeInfo noticeInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-34834824")) {
            ipChange.ipc$dispatch("-34834824", new Object[]{this, noticeInfo});
        } else {
            this.noticeInfo = noticeInfo;
        }
    }

    public void setStoreInfo(StoreInfo storeInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "19274641")) {
            ipChange.ipc$dispatch("19274641", new Object[]{this, storeInfo});
        } else {
            this.storeInfo = storeInfo;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-666274309")) {
            ipChange.ipc$dispatch("-666274309", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeStringList(this.categoryTags);
        parcel.writeTypedList(this.gradeTags);
        parcel.writeParcelable(this.noticeInfo, i);
        parcel.writeTypedList(this.commentGradeTexts);
        parcel.writeValue(this.itemType);
        parcel.writeSerializable(this.storeInfo);
        parcel.writeList(this.dmInfoList);
        parcel.writeStringList(this.IconTitle);
    }

    protected IssueRenderResponse(Parcel parcel) {
        this.categoryTags = parcel.createStringArrayList();
        this.gradeTags = parcel.createTypedArrayList(CommentGradeTagBean.CREATOR);
        this.noticeInfo = (NoticeInfo) parcel.readParcelable(NoticeInfo.class.getClassLoader());
        this.commentGradeTexts = parcel.createTypedArrayList(CommentGradeText.CREATOR);
        this.itemType = (String) parcel.readValue(String.class.getClassLoader());
        this.storeInfo = (StoreInfo) parcel.readSerializable();
        ArrayList arrayList = new ArrayList();
        this.dmInfoList = arrayList;
        parcel.readList(arrayList, DmInfo.class.getClassLoader());
        this.IconTitle = parcel.createStringArrayList();
    }
}
