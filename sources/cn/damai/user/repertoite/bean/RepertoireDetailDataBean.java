package cn.damai.user.repertoite.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class RepertoireDetailDataBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean favoriteFlag;
    private List<ProjectCardInfoBean> projectCardInfo;
    private RepertoireInfoBean repertoireInfo;

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public static class ProjectCardInfoBean implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange;
        private String cityId;
        private String cityName;
        private String priceRange;
        private String projectId;
        private String projectName;
        private String projectPic;
        private String recReason;
        private int recReasonType;
        public String schema;
        private String showTime;
        private List<String> tagList;
        private String venueCity;
        private int venueId;
        private String venueName;

        public String getCityId() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1000208518") ? (String) ipChange.ipc$dispatch("-1000208518", new Object[]{this}) : this.cityId;
        }

        public String getCityName() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "943171562") ? (String) ipChange.ipc$dispatch("943171562", new Object[]{this}) : this.cityName;
        }

        public String getPriceRange() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1183854984") ? (String) ipChange.ipc$dispatch("1183854984", new Object[]{this}) : this.priceRange;
        }

        public String getProjectId() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1486577546") ? (String) ipChange.ipc$dispatch("-1486577546", new Object[]{this}) : this.projectId;
        }

        public String getProjectName() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1693970918") ? (String) ipChange.ipc$dispatch("1693970918", new Object[]{this}) : this.projectName;
        }

        public String getProjectPic() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "973741893") ? (String) ipChange.ipc$dispatch("973741893", new Object[]{this}) : this.projectPic;
        }

        public String getRecReason() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "383322454") ? (String) ipChange.ipc$dispatch("383322454", new Object[]{this}) : this.recReason;
        }

        public int getRecReasonType() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "702694499") ? ((Integer) ipChange.ipc$dispatch("702694499", new Object[]{this})).intValue() : this.recReasonType;
        }

        public String getShowTime() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "871233214") ? (String) ipChange.ipc$dispatch("871233214", new Object[]{this}) : this.showTime;
        }

        public List<String> getTagList() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-622399071") ? (List) ipChange.ipc$dispatch("-622399071", new Object[]{this}) : this.tagList;
        }

        public String getVenueCity() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "811280348") ? (String) ipChange.ipc$dispatch("811280348", new Object[]{this}) : this.venueCity;
        }

        public int getVenueId() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-986371577") ? ((Integer) ipChange.ipc$dispatch("-986371577", new Object[]{this})).intValue() : this.venueId;
        }

        public String getVenueName() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "155465980") ? (String) ipChange.ipc$dispatch("155465980", new Object[]{this}) : this.venueName;
        }

        public void setCityId(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1958182308")) {
                ipChange.ipc$dispatch("1958182308", new Object[]{this, str});
            } else {
                this.cityId = str;
            }
        }

        public void setCityName(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-708780492")) {
                ipChange.ipc$dispatch("-708780492", new Object[]{this, str});
            } else {
                this.cityName = str;
            }
        }

        public void setPriceRange(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "229882710")) {
                ipChange.ipc$dispatch("229882710", new Object[]{this, str});
            } else {
                this.priceRange = str;
            }
        }

        public void setProjectId(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-804468544")) {
                ipChange.ipc$dispatch("-804468544", new Object[]{this, str});
            } else {
                this.projectId = str;
            }
        }

        public void setProjectName(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1326460336")) {
                ipChange.ipc$dispatch("-1326460336", new Object[]{this, str});
            } else {
                this.projectName = str;
            }
        }

        public void setProjectPic(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1988655815")) {
                ipChange.ipc$dispatch("-1988655815", new Object[]{this, str});
            } else {
                this.projectPic = str;
            }
        }

        public void setRecReason(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1327856608")) {
                ipChange.ipc$dispatch("1327856608", new Object[]{this, str});
            } else {
                this.recReason = str;
            }
        }

        public void setRecReasonType(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-302200569")) {
                ipChange.ipc$dispatch("-302200569", new Object[]{this, Integer.valueOf(i)});
            } else {
                this.recReasonType = i;
            }
        }

        public void setShowTime(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1356098016")) {
                ipChange.ipc$dispatch("1356098016", new Object[]{this, str});
            } else {
                this.showTime = str;
            }
        }

        public void setTagList(List<String> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1282412259")) {
                ipChange.ipc$dispatch("1282412259", new Object[]{this, list});
            } else {
                this.tagList = list;
            }
        }

        public void setVenueCity(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1709649434")) {
                ipChange.ipc$dispatch("1709649434", new Object[]{this, str});
            } else {
                this.venueCity = str;
            }
        }

        public void setVenueId(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2010513123")) {
                ipChange.ipc$dispatch("2010513123", new Object[]{this, Integer.valueOf(i)});
            } else {
                this.venueId = i;
            }
        }

        public void setVenueName(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1440726790")) {
                ipChange.ipc$dispatch("-1440726790", new Object[]{this, str});
            } else {
                this.venueName = str;
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public static class RepertoireInfoBean implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange;
        private String artsDesc;
        private Long childRepertoireType;
        private String childRepertoireTypeName;
        private String focusComment;
        private String repertoireId;
        private String repertoireName;
        private String repertoirePic;
        private int repertoireType;
        private String repertoireTypeName;
        private StoryPicsInfoBean storyPicsInfo;
        private String summary;

        /* compiled from: Taobao */
        /* loaded from: classes17.dex */
        public static class StoryPicsInfoBean implements Serializable {
            private static transient /* synthetic */ IpChange $ipChange;
            private List<PicInfosBean> picInfos;

            /* compiled from: Taobao */
            /* loaded from: classes17.dex */
            public static class PicInfosBean implements Serializable {
                private static transient /* synthetic */ IpChange $ipChange;
                private String height;
                private String picUrl;
                private String width;

                public String getHeight() {
                    IpChange ipChange = $ipChange;
                    return AndroidInstantRuntime.support(ipChange, "-1588456586") ? (String) ipChange.ipc$dispatch("-1588456586", new Object[]{this}) : this.height;
                }

                public String getPicUrl() {
                    IpChange ipChange = $ipChange;
                    return AndroidInstantRuntime.support(ipChange, "2110349012") ? (String) ipChange.ipc$dispatch("2110349012", new Object[]{this}) : this.picUrl;
                }

                public String getWidth() {
                    IpChange ipChange = $ipChange;
                    return AndroidInstantRuntime.support(ipChange, "-206060019") ? (String) ipChange.ipc$dispatch("-206060019", new Object[]{this}) : this.width;
                }

                public void setHeight(String str) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "902361384")) {
                        ipChange.ipc$dispatch("902361384", new Object[]{this, str});
                    } else {
                        this.height = str;
                    }
                }

                public void setPicUrl(String str) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-398782070")) {
                        ipChange.ipc$dispatch("-398782070", new Object[]{this, str});
                    } else {
                        this.picUrl = str;
                    }
                }

                public void setWidth(String str) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "398474249")) {
                        ipChange.ipc$dispatch("398474249", new Object[]{this, str});
                    } else {
                        this.width = str;
                    }
                }
            }

            public List<PicInfosBean> getPicInfos() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-772690196") ? (List) ipChange.ipc$dispatch("-772690196", new Object[]{this}) : this.picInfos;
            }

            public void setPicInfos(List<PicInfosBean> list) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1326862432")) {
                    ipChange.ipc$dispatch("1326862432", new Object[]{this, list});
                } else {
                    this.picInfos = list;
                }
            }
        }

        public String getArtsDesc() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-474784589") ? (String) ipChange.ipc$dispatch("-474784589", new Object[]{this}) : this.artsDesc;
        }

        public Long getChildRepertoireType() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-2138006618") ? (Long) ipChange.ipc$dispatch("-2138006618", new Object[]{this}) : this.childRepertoireType;
        }

        public String getChildRepertoireTypeName() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1718689564") ? (String) ipChange.ipc$dispatch("1718689564", new Object[]{this}) : this.childRepertoireTypeName;
        }

        public String getFocusComment() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-205683847") ? (String) ipChange.ipc$dispatch("-205683847", new Object[]{this}) : this.focusComment;
        }

        public String getRepertoireId() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1597664956") ? (String) ipChange.ipc$dispatch("-1597664956", new Object[]{this}) : this.repertoireId;
        }

        public String getRepertoireName() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1981814988") ? (String) ipChange.ipc$dispatch("-1981814988", new Object[]{this}) : this.repertoireName;
        }

        public String getRepertoirePic() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1824999479") ? (String) ipChange.ipc$dispatch("1824999479", new Object[]{this}) : this.repertoirePic;
        }

        public int getRepertoireType() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1006025680") ? ((Integer) ipChange.ipc$dispatch("1006025680", new Object[]{this})).intValue() : this.repertoireType;
        }

        public String getRepertoireTypeName() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-271667826") ? (String) ipChange.ipc$dispatch("-271667826", new Object[]{this}) : this.repertoireTypeName;
        }

        public StoryPicsInfoBean getStoryPicsInfo() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1354303136") ? (StoryPicsInfoBean) ipChange.ipc$dispatch("1354303136", new Object[]{this}) : this.storyPicsInfo;
        }

        public String getSummary() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1317940554") ? (String) ipChange.ipc$dispatch("1317940554", new Object[]{this}) : this.summary;
        }

        public void setArtsDesc(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1715748213")) {
                ipChange.ipc$dispatch("-1715748213", new Object[]{this, str});
            } else {
                this.artsDesc = str;
            }
        }

        public void setChildRepertoireType(Long l) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "449571802")) {
                ipChange.ipc$dispatch("449571802", new Object[]{this, l});
            } else {
                this.childRepertoireType = l;
            }
        }

        public void setChildRepertoireTypeName(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1909646886")) {
                ipChange.ipc$dispatch("-1909646886", new Object[]{this, str});
            } else {
                this.childRepertoireTypeName = str;
            }
        }

        public void setFocusComment(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1683350907")) {
                ipChange.ipc$dispatch("-1683350907", new Object[]{this, str});
            } else {
                this.focusComment = str;
            }
        }

        public void setRepertoireId(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1885092326")) {
                ipChange.ipc$dispatch("-1885092326", new Object[]{this, str});
            } else {
                this.repertoireId = str;
            }
        }

        public void setRepertoireName(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-423829206")) {
                ipChange.ipc$dispatch("-423829206", new Object[]{this, str});
            } else {
                this.repertoireName = str;
            }
        }

        public void setRepertoirePic(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1128254689")) {
                ipChange.ipc$dispatch("-1128254689", new Object[]{this, str});
            } else {
                this.repertoirePic = str;
            }
        }

        public void setRepertoireType(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-636701486")) {
                ipChange.ipc$dispatch("-636701486", new Object[]{this, Integer.valueOf(i)});
            } else {
                this.repertoireType = i;
            }
        }

        public void setRepertoireTypeName(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "126225424")) {
                ipChange.ipc$dispatch("126225424", new Object[]{this, str});
            } else {
                this.repertoireTypeName = str;
            }
        }

        public void setStoryPicsInfo(StoryPicsInfoBean storyPicsInfoBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1183808508")) {
                ipChange.ipc$dispatch("-1183808508", new Object[]{this, storyPicsInfoBean});
            } else {
                this.storyPicsInfo = storyPicsInfoBean;
            }
        }

        public void setSummary(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "585197932")) {
                ipChange.ipc$dispatch("585197932", new Object[]{this, str});
            } else {
                this.summary = str;
            }
        }
    }

    public List<ProjectCardInfoBean> getProjectCardInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1420640931") ? (List) ipChange.ipc$dispatch("1420640931", new Object[]{this}) : this.projectCardInfo;
    }

    public RepertoireInfoBean getRepertoireInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1761536334") ? (RepertoireInfoBean) ipChange.ipc$dispatch("-1761536334", new Object[]{this}) : this.repertoireInfo;
    }

    public boolean isFavoriteFlag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1162143735") ? ((Boolean) ipChange.ipc$dispatch("1162143735", new Object[]{this})).booleanValue() : this.favoriteFlag;
    }

    public void setFavoriteFlag(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-21508903")) {
            ipChange.ipc$dispatch("-21508903", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.favoriteFlag = z;
        }
    }

    public void setProjectCardInfo(List<ProjectCardInfoBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "127078945")) {
            ipChange.ipc$dispatch("127078945", new Object[]{this, list});
        } else {
            this.projectCardInfo = list;
        }
    }

    public void setRepertoireInfo(RepertoireInfoBean repertoireInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1400582598")) {
            ipChange.ipc$dispatch("-1400582598", new Object[]{this, repertoireInfoBean});
        } else {
            this.repertoireInfo = repertoireInfoBean;
        }
    }
}
