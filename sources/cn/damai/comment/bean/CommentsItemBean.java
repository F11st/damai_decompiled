package cn.damai.comment.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import cn.damai.commonbusiness.scriptmurder.bean.ScriptBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class CommentsItemBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<CommentsItemBean> CREATOR = new Parcelable.Creator<CommentsItemBean>() { // from class: cn.damai.comment.bean.CommentsItemBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CommentsItemBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "774825451") ? (CommentsItemBean) ipChange.ipc$dispatch("774825451", new Object[]{this, parcel}) : new CommentsItemBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CommentsItemBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1953511256") ? (CommentsItemBean[]) ipChange.ipc$dispatch("1953511256", new Object[]{this, Integer.valueOf(i)}) : new CommentsItemBean[i];
        }
    };
    List<DmInfo> allDmInfo;
    private List<CommentsItemBean> appendComments;
    String associatedScriptNum;
    String associatedStoreNum;
    private String cityName;
    private String commentId;
    private String commentType;
    DmInfo dmInfo;
    private String extraInfo;
    private boolean feature;
    private String gmtCreate;
    private String gmtCreateTime;
    private String gmtDisplay;
    private String gmtModified;
    private List<CommentGradeBean> gradeDOList;
    private String hasAppend;
    public boolean hasPlayed;
    boolean hideInteraction;
    List<String> iconTitle;
    private List<CommentImageInfoBean> imageDOList;
    private boolean isBrilliant;
    private String isOwner;
    private int itemIndex;
    int itemType;
    private boolean onTop;
    private CommentPraiseInfoBean praiseInfo;
    boolean prohibitEditing;
    public String publishCityName;
    private String replyTotal;
    ScriptBean scriptInfo;
    boolean spoilerType;
    StoreInfo storeInfo;
    private List<CommentSyncCircleBean> syncCircle;
    private String syncStatus;
    private CommentTargetDataBean targetDataDO;
    private String targetId;
    private String targetType;
    private List<CommentTextDoBean> textDOList;
    private String url;
    private CommentUserDoBean userDO;
    private CommentsVideoBean videoDO;

    public CommentsItemBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "317796430")) {
            return ((Integer) ipChange.ipc$dispatch("317796430", new Object[]{this})).intValue();
        }
        return 0;
    }

    public List<DmInfo> getAllDmInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1381532183") ? (List) ipChange.ipc$dispatch("-1381532183", new Object[]{this}) : this.allDmInfo;
    }

    public List<CommentsItemBean> getAppendComments() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1011045729") ? (List) ipChange.ipc$dispatch("1011045729", new Object[]{this}) : this.appendComments;
    }

    public String getAssociatedScriptNum() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "769761023") ? (String) ipChange.ipc$dispatch("769761023", new Object[]{this}) : this.associatedScriptNum;
    }

    public String getAssociatedStoreNum() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1138327785") ? (String) ipChange.ipc$dispatch("-1138327785", new Object[]{this}) : this.associatedStoreNum;
    }

    public String getCityName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "75144546") ? (String) ipChange.ipc$dispatch("75144546", new Object[]{this}) : this.cityName;
    }

    public String getCommentId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-554064700") ? (String) ipChange.ipc$dispatch("-554064700", new Object[]{this}) : this.commentId;
    }

    public String getCommentType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2073952739") ? (String) ipChange.ipc$dispatch("2073952739", new Object[]{this}) : this.commentType;
    }

    public String getDateAndPublishCity() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-63727075")) {
            return (String) ipChange.ipc$dispatch("-63727075", new Object[]{this});
        }
        if (TextUtils.isEmpty(this.publishCityName)) {
            return this.gmtDisplay;
        }
        return this.gmtDisplay + " " + this.publishCityName;
    }

    public DmInfo getDmInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-201236835") ? (DmInfo) ipChange.ipc$dispatch("-201236835", new Object[]{this}) : this.dmInfo;
    }

    public String getExtraInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-788724792") ? (String) ipChange.ipc$dispatch("-788724792", new Object[]{this}) : this.extraInfo;
    }

    public String getGmtCreate() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-470955052") ? (String) ipChange.ipc$dispatch("-470955052", new Object[]{this}) : this.gmtCreate;
    }

    public String getGmtCreateTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1084468673") ? (String) ipChange.ipc$dispatch("1084468673", new Object[]{this}) : this.gmtCreateTime;
    }

    public String getGmtDisplay() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1214732256") ? (String) ipChange.ipc$dispatch("-1214732256", new Object[]{this}) : this.gmtDisplay;
    }

    public String getGmtModified() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1841646111") ? (String) ipChange.ipc$dispatch("-1841646111", new Object[]{this}) : this.gmtModified;
    }

    public List<CommentGradeBean> getGradeDOList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-872693583") ? (List) ipChange.ipc$dispatch("-872693583", new Object[]{this}) : this.gradeDOList;
    }

    public String getHasAppend() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1193884222") ? (String) ipChange.ipc$dispatch("1193884222", new Object[]{this}) : this.hasAppend;
    }

    public List<String> getIconTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1896431184") ? (List) ipChange.ipc$dispatch("-1896431184", new Object[]{this}) : this.iconTitle;
    }

    public List<CommentImageInfoBean> getImageDOList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1880251957") ? (List) ipChange.ipc$dispatch("1880251957", new Object[]{this}) : this.imageDOList;
    }

    public String getIsOwner() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1176168147") ? (String) ipChange.ipc$dispatch("1176168147", new Object[]{this}) : this.isOwner;
    }

    public int getItemIndex() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1449983882") ? ((Integer) ipChange.ipc$dispatch("1449983882", new Object[]{this})).intValue() : this.itemIndex;
    }

    public int getItemType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1268211002") ? ((Integer) ipChange.ipc$dispatch("1268211002", new Object[]{this})).intValue() : this.itemType;
    }

    public CommentPraiseInfoBean getPraiseInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-160256202") ? (CommentPraiseInfoBean) ipChange.ipc$dispatch("-160256202", new Object[]{this}) : this.praiseInfo;
    }

    public String getReplyTotal() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1936590598") ? (String) ipChange.ipc$dispatch("1936590598", new Object[]{this}) : this.replyTotal;
    }

    public ScriptBean getScriptInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1572062492") ? (ScriptBean) ipChange.ipc$dispatch("-1572062492", new Object[]{this}) : this.scriptInfo;
    }

    public StoreInfo getStoreInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1279199997") ? (StoreInfo) ipChange.ipc$dispatch("1279199997", new Object[]{this}) : this.storeInfo;
    }

    public List<CommentSyncCircleBean> getSyncCircle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1450843326") ? (List) ipChange.ipc$dispatch("1450843326", new Object[]{this}) : this.syncCircle;
    }

    public String getSyncStatus() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "456108921") ? (String) ipChange.ipc$dispatch("456108921", new Object[]{this}) : this.syncStatus;
    }

    public CommentTargetDataBean getTargetDataDO() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1618007127") ? (CommentTargetDataBean) ipChange.ipc$dispatch("-1618007127", new Object[]{this}) : this.targetDataDO;
    }

    public String getTargetId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "388400728") ? (String) ipChange.ipc$dispatch("388400728", new Object[]{this}) : this.targetId;
    }

    public String getTargetType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1545129591") ? (String) ipChange.ipc$dispatch("1545129591", new Object[]{this}) : this.targetType;
    }

    public List<CommentTextDoBean> getTextDOList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-809184279") ? (List) ipChange.ipc$dispatch("-809184279", new Object[]{this}) : this.textDOList;
    }

    public String getUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-174312167") ? (String) ipChange.ipc$dispatch("-174312167", new Object[]{this}) : this.url;
    }

    public CommentUserDoBean getUserDO() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "762145406") ? (CommentUserDoBean) ipChange.ipc$dispatch("762145406", new Object[]{this}) : this.userDO;
    }

    public CommentsVideoBean getVideoDO() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "996621246") ? (CommentsVideoBean) ipChange.ipc$dispatch("996621246", new Object[]{this}) : this.videoDO;
    }

    public boolean isBrilliant() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-954544191") ? ((Boolean) ipChange.ipc$dispatch("-954544191", new Object[]{this})).booleanValue() : this.isBrilliant;
    }

    public boolean isFeature() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1462080030") ? ((Boolean) ipChange.ipc$dispatch("-1462080030", new Object[]{this})).booleanValue() : this.feature;
    }

    public boolean isHideInteraction() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1503441960") ? ((Boolean) ipChange.ipc$dispatch("1503441960", new Object[]{this})).booleanValue() : this.hideInteraction;
    }

    public boolean isOnTop() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1823004254") ? ((Boolean) ipChange.ipc$dispatch("-1823004254", new Object[]{this})).booleanValue() : this.onTop;
    }

    public boolean isProhibitEditing() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1066479553") ? ((Boolean) ipChange.ipc$dispatch("-1066479553", new Object[]{this})).booleanValue() : this.prohibitEditing;
    }

    public boolean isSpoilerType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1072669564") ? ((Boolean) ipChange.ipc$dispatch("1072669564", new Object[]{this})).booleanValue() : this.spoilerType;
    }

    public void readFromParcel(Parcel parcel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1051610762")) {
            ipChange.ipc$dispatch("-1051610762", new Object[]{this, parcel});
            return;
        }
        this.itemIndex = parcel.readInt();
        this.isBrilliant = parcel.readByte() != 0;
        this.url = parcel.readString();
        this.commentId = parcel.readString();
        this.commentType = parcel.readString();
        this.gmtCreate = parcel.readString();
        this.gmtCreateTime = parcel.readString();
        this.gmtModified = parcel.readString();
        this.gmtDisplay = parcel.readString();
        this.replyTotal = parcel.readString();
        this.targetId = parcel.readString();
        this.extraInfo = parcel.readString();
        this.onTop = parcel.readByte() != 0;
        this.feature = parcel.readByte() != 0;
        this.targetType = parcel.readString();
        this.hasAppend = parcel.readString();
        this.isOwner = parcel.readString();
        this.userDO = (CommentUserDoBean) parcel.readParcelable(CommentUserDoBean.class.getClassLoader());
        this.textDOList = parcel.createTypedArrayList(CommentTextDoBean.CREATOR);
        this.imageDOList = parcel.createTypedArrayList(CommentImageInfoBean.CREATOR);
        this.gradeDOList = parcel.createTypedArrayList(CommentGradeBean.CREATOR);
        this.appendComments = parcel.createTypedArrayList(CREATOR);
        this.cityName = parcel.readString();
        this.praiseInfo = (CommentPraiseInfoBean) parcel.readParcelable(CommentPraiseInfoBean.class.getClassLoader());
        this.syncCircle = parcel.createTypedArrayList(CommentSyncCircleBean.CREATOR);
        this.syncStatus = parcel.readString();
        this.videoDO = (CommentsVideoBean) parcel.readParcelable(CommentsVideoBean.class.getClassLoader());
        this.targetDataDO = (CommentTargetDataBean) parcel.readParcelable(CommentTargetDataBean.class.getClassLoader());
        this.dmInfo = (DmInfo) parcel.readSerializable();
        ArrayList arrayList = new ArrayList();
        this.allDmInfo = arrayList;
        parcel.readList(arrayList, DmInfo.class.getClassLoader());
        this.storeInfo = (StoreInfo) parcel.readSerializable();
        this.itemType = parcel.readInt();
        this.spoilerType = parcel.readByte() != 0;
        this.hideInteraction = parcel.readByte() != 0;
        this.prohibitEditing = parcel.readByte() != 0;
        this.iconTitle = parcel.createStringArrayList();
        this.associatedStoreNum = parcel.readString();
        this.associatedScriptNum = parcel.readString();
        this.publishCityName = parcel.readString();
    }

    public void setAllDmInfo(List<DmInfo> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-588531557")) {
            ipChange.ipc$dispatch("-588531557", new Object[]{this, list});
        } else {
            this.allDmInfo = list;
        }
    }

    public void setAppendComments(List<CommentsItemBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1713892981")) {
            ipChange.ipc$dispatch("-1713892981", new Object[]{this, list});
        } else {
            this.appendComments = list;
        }
    }

    public void setAssociatedScriptNum(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-232522665")) {
            ipChange.ipc$dispatch("-232522665", new Object[]{this, str});
        } else {
            this.associatedScriptNum = str;
        }
    }

    public void setAssociatedStoreNum(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-970429529")) {
            ipChange.ipc$dispatch("-970429529", new Object[]{this, str});
        } else {
            this.associatedStoreNum = str;
        }
    }

    public void setBrilliant(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2101294903")) {
            ipChange.ipc$dispatch("-2101294903", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isBrilliant = z;
        }
    }

    public void setCityName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1847814212")) {
            ipChange.ipc$dispatch("-1847814212", new Object[]{this, str});
        } else {
            this.cityName = str;
        }
    }

    public void setCommentId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1961341390")) {
            ipChange.ipc$dispatch("-1961341390", new Object[]{this, str});
        } else {
            this.commentId = str;
        }
    }

    public void setCommentType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1863041523")) {
            ipChange.ipc$dispatch("1863041523", new Object[]{this, str});
        } else {
            this.commentType = str;
        }
    }

    public void setDmInfo(DmInfo dmInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-75565291")) {
            ipChange.ipc$dispatch("-75565291", new Object[]{this, dmInfo});
        } else {
            this.dmInfo = dmInfo;
        }
    }

    public void setExtraInfo(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-645869650")) {
            ipChange.ipc$dispatch("-645869650", new Object[]{this, str});
        } else {
            this.extraInfo = str;
        }
    }

    public void setFeature(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "505236296")) {
            ipChange.ipc$dispatch("505236296", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.feature = z;
        }
    }

    public void setGmtCreate(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "615057698")) {
            ipChange.ipc$dispatch("615057698", new Object[]{this, str});
        } else {
            this.gmtCreate = str;
        }
    }

    public void setGmtCreateTime(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1685094101")) {
            ipChange.ipc$dispatch("1685094101", new Object[]{this, str});
        } else {
            this.gmtCreateTime = str;
        }
    }

    public void setGmtDisplay(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1111877698")) {
            ipChange.ipc$dispatch("-1111877698", new Object[]{this, str});
        } else {
            this.gmtDisplay = str;
        }
    }

    public void setGmtModified(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "738561461")) {
            ipChange.ipc$dispatch("738561461", new Object[]{this, str});
        } else {
            this.gmtModified = str;
        }
    }

    public void setGradeDOList(List<CommentGradeBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1951611859")) {
            ipChange.ipc$dispatch("1951611859", new Object[]{this, list});
        } else {
            this.gradeDOList = list;
        }
    }

    public void setHasAppend(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "685467640")) {
            ipChange.ipc$dispatch("685467640", new Object[]{this, str});
        } else {
            this.hasAppend = str;
        }
    }

    public void setHideInteraction(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "599858114")) {
            ipChange.ipc$dispatch("599858114", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.hideInteraction = z;
        }
    }

    public void setIconTitle(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "629468596")) {
            ipChange.ipc$dispatch("629468596", new Object[]{this, list});
        } else {
            this.iconTitle = list;
        }
    }

    public void setImageDOList(List<CommentImageInfoBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1393577679")) {
            ipChange.ipc$dispatch("1393577679", new Object[]{this, list});
        } else {
            this.imageDOList = list;
        }
    }

    public void setIsOwner(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "485220611")) {
            ipChange.ipc$dispatch("485220611", new Object[]{this, str});
        } else {
            this.isOwner = str;
        }
    }

    public void setItemIndex(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "168414400")) {
            ipChange.ipc$dispatch("168414400", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.itemIndex = i;
        }
    }

    public void setItemType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1570617768")) {
            ipChange.ipc$dispatch("1570617768", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.itemType = i;
        }
    }

    public void setOnTop(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1748139000")) {
            ipChange.ipc$dispatch("-1748139000", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.onTop = z;
        }
    }

    public void setPraiseInfo(CommentPraiseInfoBean commentPraiseInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "796302014")) {
            ipChange.ipc$dispatch("796302014", new Object[]{this, commentPraiseInfoBean});
        } else {
            this.praiseInfo = commentPraiseInfoBean;
        }
    }

    public void setProhibitEditing(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1758297461")) {
            ipChange.ipc$dispatch("-1758297461", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.prohibitEditing = z;
        }
    }

    public void setReplyTotal(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2089850264")) {
            ipChange.ipc$dispatch("2089850264", new Object[]{this, str});
        } else {
            this.replyTotal = str;
        }
    }

    public void setScriptInfo(ScriptBean scriptBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "934099416")) {
            ipChange.ipc$dispatch("934099416", new Object[]{this, scriptBean});
        } else {
            this.scriptInfo = scriptBean;
        }
    }

    public void setSpoilerType(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2013057042")) {
            ipChange.ipc$dispatch("-2013057042", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.spoilerType = z;
        }
    }

    public void setStoreInfo(StoreInfo storeInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-393065261")) {
            ipChange.ipc$dispatch("-393065261", new Object[]{this, storeInfo});
        } else {
            this.storeInfo = storeInfo;
        }
    }

    public void setSyncCircle(List<CommentSyncCircleBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1245278258")) {
            ipChange.ipc$dispatch("-1245278258", new Object[]{this, list});
        } else {
            this.syncCircle = list;
        }
    }

    public void setSyncStatus(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-855408763")) {
            ipChange.ipc$dispatch("-855408763", new Object[]{this, str});
        } else {
            this.syncStatus = str;
        }
    }

    public void setTargetDataDO(CommentTargetDataBean commentTargetDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-595674071")) {
            ipChange.ipc$dispatch("-595674071", new Object[]{this, commentTargetDataBean});
        } else {
            this.targetDataDO = commentTargetDataBean;
        }
    }

    public void setTargetId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-726807162")) {
            ipChange.ipc$dispatch("-726807162", new Object[]{this, str});
        } else {
            this.targetId = str;
        }
    }

    public void setTargetType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1455506361")) {
            ipChange.ipc$dispatch("-1455506361", new Object[]{this, str});
        } else {
            this.targetType = str;
        }
    }

    public void setTextDOList(List<CommentTextDoBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1708310019")) {
            ipChange.ipc$dispatch("1708310019", new Object[]{this, list});
        } else {
            this.textDOList = list;
        }
    }

    public void setUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "309838205")) {
            ipChange.ipc$dispatch("309838205", new Object[]{this, str});
        } else {
            this.url = str;
        }
    }

    public void setUserDO(CommentUserDoBean commentUserDoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "178109854")) {
            ipChange.ipc$dispatch("178109854", new Object[]{this, commentUserDoBean});
        } else {
            this.userDO = commentUserDoBean;
        }
    }

    public void setVideoDO(CommentsVideoBean commentsVideoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1554777890")) {
            ipChange.ipc$dispatch("1554777890", new Object[]{this, commentsVideoBean});
        } else {
            this.videoDO = commentsVideoBean;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1368652349")) {
            ipChange.ipc$dispatch("1368652349", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeInt(this.itemIndex);
        parcel.writeByte(this.isBrilliant ? (byte) 1 : (byte) 0);
        parcel.writeString(this.url);
        parcel.writeString(this.commentId);
        parcel.writeString(this.commentType);
        parcel.writeString(this.gmtCreate);
        parcel.writeString(this.gmtCreateTime);
        parcel.writeString(this.gmtModified);
        parcel.writeString(this.gmtDisplay);
        parcel.writeString(this.replyTotal);
        parcel.writeString(this.targetId);
        parcel.writeString(this.extraInfo);
        parcel.writeByte(this.onTop ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.feature ? (byte) 1 : (byte) 0);
        parcel.writeString(this.targetType);
        parcel.writeString(this.hasAppend);
        parcel.writeString(this.isOwner);
        parcel.writeParcelable(this.userDO, i);
        parcel.writeTypedList(this.textDOList);
        parcel.writeTypedList(this.imageDOList);
        parcel.writeTypedList(this.gradeDOList);
        parcel.writeTypedList(this.appendComments);
        parcel.writeString(this.cityName);
        parcel.writeParcelable(this.praiseInfo, i);
        parcel.writeTypedList(this.syncCircle);
        parcel.writeString(this.syncStatus);
        parcel.writeParcelable(this.videoDO, i);
        parcel.writeParcelable(this.targetDataDO, i);
        parcel.writeSerializable(this.dmInfo);
        parcel.writeList(this.allDmInfo);
        parcel.writeSerializable(this.storeInfo);
        parcel.writeInt(this.itemType);
        parcel.writeSerializable(this.scriptInfo);
        parcel.writeByte(this.spoilerType ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.hideInteraction ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.prohibitEditing ? (byte) 1 : (byte) 0);
        parcel.writeStringList(this.iconTitle);
        parcel.writeString(this.associatedStoreNum);
        parcel.writeString(this.associatedScriptNum);
        parcel.writeString(this.publishCityName);
    }

    protected CommentsItemBean(Parcel parcel) {
        this.itemIndex = parcel.readInt();
        this.isBrilliant = parcel.readByte() != 0;
        this.url = parcel.readString();
        this.commentId = parcel.readString();
        this.commentType = parcel.readString();
        this.gmtCreate = parcel.readString();
        this.gmtCreateTime = parcel.readString();
        this.gmtModified = parcel.readString();
        this.gmtDisplay = parcel.readString();
        this.replyTotal = parcel.readString();
        this.targetId = parcel.readString();
        this.extraInfo = parcel.readString();
        this.onTop = parcel.readByte() != 0;
        this.feature = parcel.readByte() != 0;
        this.targetType = parcel.readString();
        this.hasAppend = parcel.readString();
        this.isOwner = parcel.readString();
        this.userDO = (CommentUserDoBean) parcel.readParcelable(CommentUserDoBean.class.getClassLoader());
        this.textDOList = parcel.createTypedArrayList(CommentTextDoBean.CREATOR);
        this.imageDOList = parcel.createTypedArrayList(CommentImageInfoBean.CREATOR);
        this.gradeDOList = parcel.createTypedArrayList(CommentGradeBean.CREATOR);
        this.appendComments = parcel.createTypedArrayList(CREATOR);
        this.cityName = parcel.readString();
        this.praiseInfo = (CommentPraiseInfoBean) parcel.readParcelable(CommentPraiseInfoBean.class.getClassLoader());
        this.syncCircle = parcel.createTypedArrayList(CommentSyncCircleBean.CREATOR);
        this.syncStatus = parcel.readString();
        this.videoDO = (CommentsVideoBean) parcel.readParcelable(CommentsVideoBean.class.getClassLoader());
        this.targetDataDO = (CommentTargetDataBean) parcel.readParcelable(CommentTargetDataBean.class.getClassLoader());
        this.dmInfo = (DmInfo) parcel.readSerializable();
        ArrayList arrayList = new ArrayList();
        this.allDmInfo = arrayList;
        parcel.readList(arrayList, DmInfo.class.getClassLoader());
        this.storeInfo = (StoreInfo) parcel.readSerializable();
        this.itemType = parcel.readInt();
        this.scriptInfo = (ScriptBean) parcel.readSerializable();
        this.spoilerType = parcel.readByte() != 0;
        this.hideInteraction = parcel.readByte() != 0;
        this.prohibitEditing = parcel.readByte() != 0;
        this.iconTitle = parcel.createStringArrayList();
        this.associatedStoreNum = parcel.readString();
        this.associatedScriptNum = parcel.readString();
        this.publishCityName = parcel.readString();
    }
}
