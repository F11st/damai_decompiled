package cn.damai.issue.net;

import cn.damai.comment.bean.CommentGradeBean;
import cn.damai.comment.bean.CommentImageInfoBean;
import cn.damai.comment.bean.CommentsVideoBean;
import cn.damai.comment.bean.DmInfo;
import cn.damai.comment.bean.StoreInfo;
import cn.damai.commonbusiness.yymember.bean.PerformFilmVipDO;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class IssueResponse implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 1;
    private boolean canEnterActivity;
    private CommentsDOBean commentsDO;
    private List<JSONObject> hotScriptInfoList;
    private UserDOBeanX userDO;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public static class CommentsDOBean implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange = null;
        private static final long serialVersionUID = 1;
        private String commentId;
        private int commentType;
        private DmInfo dmInfo;
        private String gmtCreate;
        private long gmtCreateTime;
        private String gmtDisplay;
        private List<CommentGradeBean> gradeDOList;
        private List<CommentImageInfoBean> imageDOList;
        private boolean isOwner;
        private PraiseInfoBean praiseInfo;
        private int replyTotal;
        private StoreInfo storeInfo;
        private long targetId;
        private int targetType;
        private List<TextDOListBean> textDOList;
        private String url;
        private UserDOBean userDO;
        private CommentsVideoBean videoDO;

        /* compiled from: Taobao */
        /* loaded from: classes14.dex */
        public static class PraiseInfoBean implements Serializable {
            private static transient /* synthetic */ IpChange $ipChange = null;
            private static final long serialVersionUID = 1;
            private boolean hasPraised;
            private int praiseCount;

            public int getPraiseCount() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-379404467") ? ((Integer) ipChange.ipc$dispatch("-379404467", new Object[]{this})).intValue() : this.praiseCount;
            }

            public boolean isHasPraised() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-761964925") ? ((Boolean) ipChange.ipc$dispatch("-761964925", new Object[]{this})).booleanValue() : this.hasPraised;
            }

            public void setHasPraised(boolean z) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1450329295")) {
                    ipChange.ipc$dispatch("-1450329295", new Object[]{this, Boolean.valueOf(z)});
                } else {
                    this.hasPraised = z;
                }
            }

            public void setPraiseCount(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2043426909")) {
                    ipChange.ipc$dispatch("2043426909", new Object[]{this, Integer.valueOf(i)});
                } else {
                    this.praiseCount = i;
                }
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes14.dex */
        public static class TextDOListBean implements Serializable {
            private static transient /* synthetic */ IpChange $ipChange = null;
            private static final long serialVersionUID = 1;
            private int type;
            private String value;

            public int getType() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "1979668938") ? ((Integer) ipChange.ipc$dispatch("1979668938", new Object[]{this})).intValue() : this.type;
            }

            public String getValue() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "1983713688") ? (String) ipChange.ipc$dispatch("1983713688", new Object[]{this}) : this.value;
            }

            public void setType(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1151644952")) {
                    ipChange.ipc$dispatch("1151644952", new Object[]{this, Integer.valueOf(i)});
                } else {
                    this.type = i;
                }
            }

            public void setValue(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-438017570")) {
                    ipChange.ipc$dispatch("-438017570", new Object[]{this, str});
                } else {
                    this.value = str;
                }
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes14.dex */
        public static class UserDOBean implements Serializable {
            private static transient /* synthetic */ IpChange $ipChange = null;
            private static final long serialVersionUID = 1;
            private String havanaIdStr;
            private String headerImage;
            private String nickname;
            public PerformFilmVipDO performFilmVipDO;
            public boolean vip;

            public String getHavanaIdStr() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "906849030") ? (String) ipChange.ipc$dispatch("906849030", new Object[]{this}) : this.havanaIdStr;
            }

            public String getHeaderImage() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "896521493") ? (String) ipChange.ipc$dispatch("896521493", new Object[]{this}) : this.headerImage;
            }

            public String getNickname() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-2008090307") ? (String) ipChange.ipc$dispatch("-2008090307", new Object[]{this}) : this.nickname;
            }

            public void setHavanaIdStr(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "42564912")) {
                    ipChange.ipc$dispatch("42564912", new Object[]{this, str});
                } else {
                    this.havanaIdStr = str;
                }
            }

            public void setHeaderImage(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-277588735")) {
                    ipChange.ipc$dispatch("-277588735", new Object[]{this, str});
                } else {
                    this.headerImage = str;
                }
            }

            public void setNickname(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-2003585215")) {
                    ipChange.ipc$dispatch("-2003585215", new Object[]{this, str});
                } else {
                    this.nickname = str;
                }
            }
        }

        public String getCommentId() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-936853205") ? (String) ipChange.ipc$dispatch("-936853205", new Object[]{this}) : this.commentId;
        }

        public int getCommentType() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1732025033") ? ((Integer) ipChange.ipc$dispatch("1732025033", new Object[]{this})).intValue() : this.commentType;
        }

        public DmInfo getDmInfo() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1100891670") ? (DmInfo) ipChange.ipc$dispatch("1100891670", new Object[]{this}) : this.dmInfo;
        }

        public String getGmtCreate() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-853743557") ? (String) ipChange.ipc$dispatch("-853743557", new Object[]{this}) : this.gmtCreate;
        }

        public long getGmtCreateTime() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "464340204") ? ((Long) ipChange.ipc$dispatch("464340204", new Object[]{this})).longValue() : this.gmtCreateTime;
        }

        public String getGmtDisplay() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-196274023") ? (String) ipChange.ipc$dispatch("-196274023", new Object[]{this}) : this.gmtDisplay;
        }

        public List<CommentGradeBean> getGradeDOList() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1255482088") ? (List) ipChange.ipc$dispatch("-1255482088", new Object[]{this}) : this.gradeDOList;
        }

        public List<CommentImageInfoBean> getImageDOList() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1497463452") ? (List) ipChange.ipc$dispatch("1497463452", new Object[]{this}) : this.imageDOList;
        }

        public PraiseInfoBean getPraiseInfo() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "328467986") ? (PraiseInfoBean) ipChange.ipc$dispatch("328467986", new Object[]{this}) : this.praiseInfo;
        }

        public int getReplyTotal() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1978189620") ? ((Integer) ipChange.ipc$dispatch("1978189620", new Object[]{this})).intValue() : this.replyTotal;
        }

        public StoreInfo getStoreInfo() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1255885898") ? (StoreInfo) ipChange.ipc$dispatch("-1255885898", new Object[]{this}) : this.storeInfo;
        }

        public long getTargetId() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-174186653") ? ((Long) ipChange.ipc$dispatch("-174186653", new Object[]{this})).longValue() : this.targetId;
        }

        public int getTargetType() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1952418723") ? ((Integer) ipChange.ipc$dispatch("1952418723", new Object[]{this})).intValue() : this.targetType;
        }

        public List<TextDOListBean> getTextDOList() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "563941026") ? (List) ipChange.ipc$dispatch("563941026", new Object[]{this}) : this.textDOList;
        }

        public String getUrl() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1171679936") ? (String) ipChange.ipc$dispatch("1171679936", new Object[]{this}) : this.url;
        }

        public UserDOBean getUserDO() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "697787922") ? (UserDOBean) ipChange.ipc$dispatch("697787922", new Object[]{this}) : this.userDO;
        }

        public CommentsVideoBean getVideoDO() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-170936905") ? (CommentsVideoBean) ipChange.ipc$dispatch("-170936905", new Object[]{this}) : this.videoDO;
        }

        public boolean isIsOwner() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "599080502") ? ((Boolean) ipChange.ipc$dispatch("599080502", new Object[]{this})).booleanValue() : this.isOwner;
        }

        public void setCommentId(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-942883157")) {
                ipChange.ipc$dispatch("-942883157", new Object[]{this, str});
            } else {
                this.commentId = str;
            }
        }

        public void setCommentType(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1221735327")) {
                ipChange.ipc$dispatch("-1221735327", new Object[]{this, Integer.valueOf(i)});
            } else {
                this.commentType = i;
            }
        }

        public void setDmInfo(DmInfo dmInfo) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1635712700")) {
                ipChange.ipc$dispatch("1635712700", new Object[]{this, dmInfo});
            } else {
                this.dmInfo = dmInfo;
            }
        }

        public void setGmtCreate(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1633515931")) {
                ipChange.ipc$dispatch("1633515931", new Object[]{this, str});
            } else {
                this.gmtCreate = str;
            }
        }

        public void setGmtCreateTime(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "898751808")) {
                ipChange.ipc$dispatch("898751808", new Object[]{this, Long.valueOf(j)});
            } else {
                this.gmtCreateTime = j;
            }
        }

        public void setGmtDisplay(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "395556453")) {
                ipChange.ipc$dispatch("395556453", new Object[]{this, str});
            } else {
                this.gmtDisplay = str;
            }
        }

        public void setGradeDOList(List<CommentGradeBean> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1324897204")) {
                ipChange.ipc$dispatch("-1324897204", new Object[]{this, list});
            } else {
                this.gradeDOList = list;
            }
        }

        public void setImageDOList(List<CommentImageInfoBean> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1882931384")) {
                ipChange.ipc$dispatch("-1882931384", new Object[]{this, list});
            } else {
                this.imageDOList = list;
            }
        }

        public void setIsOwner(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1354241698")) {
                ipChange.ipc$dispatch("1354241698", new Object[]{this, Boolean.valueOf(z)});
            } else {
                this.isOwner = z;
            }
        }

        public void setPraiseInfo(PraiseInfoBean praiseInfoBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "207192882")) {
                ipChange.ipc$dispatch("207192882", new Object[]{this, praiseInfoBean});
            } else {
                this.praiseInfo = praiseInfoBean;
            }
        }

        public void setReplyTotal(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "254213102")) {
                ipChange.ipc$dispatch("254213102", new Object[]{this, Integer.valueOf(i)});
            } else {
                this.replyTotal = i;
            }
        }

        public void setStoreInfo(StoreInfo storeInfo) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1671316678")) {
                ipChange.ipc$dispatch("-1671316678", new Object[]{this, storeInfo});
            } else {
                this.storeInfo = storeInfo;
            }
        }

        public void setTargetId(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-194035647")) {
                ipChange.ipc$dispatch("-194035647", new Object[]{this, Long.valueOf(j)});
            } else {
                this.targetId = j;
            }
        }

        public void setTargetType(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-544684705")) {
                ipChange.ipc$dispatch("-544684705", new Object[]{this, Integer.valueOf(i)});
            } else {
                this.targetType = i;
            }
        }

        public void setTextDOList(List<TextDOListBean> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1325521514")) {
                ipChange.ipc$dispatch("1325521514", new Object[]{this, list});
            } else {
                this.textDOList = list;
            }
        }

        public void setUrl(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-914079562")) {
                ipChange.ipc$dispatch("-914079562", new Object[]{this, str});
            } else {
                this.url = str;
            }
        }

        public void setUserDO(UserDOBean userDOBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-768393062")) {
                ipChange.ipc$dispatch("-768393062", new Object[]{this, userDOBean});
            } else {
                this.userDO = userDOBean;
            }
        }

        public void setVideoDO(CommentsVideoBean commentsVideoBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-279786423")) {
                ipChange.ipc$dispatch("-279786423", new Object[]{this, commentsVideoBean});
            } else {
                this.videoDO = commentsVideoBean;
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public static class UserDOBeanX implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange = null;
        private static final long serialVersionUID = 1;
        private String havanaIdStr;
        private String headerImage;
        private String nickname;
        private PerformFilmVipDO performFilmVipDO;
        private boolean vip;
        private int vipLevel;
        private String vipLevelIcon;

        public String getHavanaIdStr() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1009040145") ? (String) ipChange.ipc$dispatch("-1009040145", new Object[]{this}) : this.havanaIdStr;
        }

        public String getHeaderImage() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1019367682") ? (String) ipChange.ipc$dispatch("-1019367682", new Object[]{this}) : this.headerImage;
        }

        public String getNickname() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1159426060") ? (String) ipChange.ipc$dispatch("-1159426060", new Object[]{this}) : this.nickname;
        }

        public PerformFilmVipDO getPerformFilmVipDO() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1279868600") ? (PerformFilmVipDO) ipChange.ipc$dispatch("1279868600", new Object[]{this}) : this.performFilmVipDO;
        }

        public int getVipLevel() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1117294970") ? ((Integer) ipChange.ipc$dispatch("-1117294970", new Object[]{this})).intValue() : this.vipLevel;
        }

        public String getVipLevelIcon() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "2046519174") ? (String) ipChange.ipc$dispatch("2046519174", new Object[]{this}) : this.vipLevelIcon;
        }

        public boolean isVip() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1272091807") ? ((Boolean) ipChange.ipc$dispatch("-1272091807", new Object[]{this})).booleanValue() : this.vip;
        }

        public void setHavanaIdStr(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "779542631")) {
                ipChange.ipc$dispatch("779542631", new Object[]{this, str});
            } else {
                this.havanaIdStr = str;
            }
        }

        public void setHeaderImage(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "459388984")) {
                ipChange.ipc$dispatch("459388984", new Object[]{this, str});
            } else {
                this.headerImage = str;
            }
        }

        public void setNickname(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1464797334")) {
                ipChange.ipc$dispatch("-1464797334", new Object[]{this, str});
            } else {
                this.nickname = str;
            }
        }

        public void setPerformFilmVipDO(PerformFilmVipDO performFilmVipDO) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1274980836")) {
                ipChange.ipc$dispatch("1274980836", new Object[]{this, performFilmVipDO});
            } else {
                this.performFilmVipDO = performFilmVipDO;
            }
        }

        public void setVip(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "82939253")) {
                ipChange.ipc$dispatch("82939253", new Object[]{this, Boolean.valueOf(z)});
            } else {
                this.vip = z;
            }
        }

        public void setVipLevel(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "634376668")) {
                ipChange.ipc$dispatch("634376668", new Object[]{this, Integer.valueOf(i)});
            } else {
                this.vipLevel = i;
            }
        }

        public void setVipLevelIcon(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-584533992")) {
                ipChange.ipc$dispatch("-584533992", new Object[]{this, str});
            } else {
                this.vipLevelIcon = str;
            }
        }
    }

    public CommentsDOBean getCommentsDO() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1203768482") ? (CommentsDOBean) ipChange.ipc$dispatch("-1203768482", new Object[]{this}) : this.commentsDO;
    }

    public List<JSONObject> getHotScriptInfoList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "117096905") ? (List) ipChange.ipc$dispatch("117096905", new Object[]{this}) : this.hotScriptInfoList;
    }

    public UserDOBeanX getUserDO() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1266654578") ? (UserDOBeanX) ipChange.ipc$dispatch("-1266654578", new Object[]{this}) : this.userDO;
    }

    public boolean isCanEnterActivity() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1253424527") ? ((Boolean) ipChange.ipc$dispatch("1253424527", new Object[]{this})).booleanValue() : this.canEnterActivity;
    }

    public void setCanEnterActivity(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1773347985")) {
            ipChange.ipc$dispatch("-1773347985", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.canEnterActivity = z;
        }
    }

    public void setCommentsDO(CommentsDOBean commentsDOBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1709532232")) {
            ipChange.ipc$dispatch("1709532232", new Object[]{this, commentsDOBean});
        } else {
            this.commentsDO = commentsDOBean;
        }
    }

    public void setHotScriptInfoList(List<JSONObject> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "522396859")) {
            ipChange.ipc$dispatch("522396859", new Object[]{this, list});
        } else {
            this.hotScriptInfoList = list;
        }
    }

    public void setUserDO(UserDOBeanX userDOBeanX) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1878240304")) {
            ipChange.ipc$dispatch("-1878240304", new Object[]{this, userDOBeanX});
        } else {
            this.userDO = userDOBeanX;
        }
    }
}
