package cn.damai.mine.relationship.bean;

import cn.damai.commonbusiness.yymember.bean.PerformFilmVipDO;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;
import tb.k23;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class RelationItemData implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private long createTime;
    private int dynamicNum;
    private int fansNum;
    private String from;
    private String objectDesc;
    private String objectIdStr;
    private String objectImg;
    private String objectName;
    private int objectType;
    private PerformFilmVipDO performFilmVipDO;
    private List<RecentShowProject> recentShowProject;
    private int recentShowTotalNum;
    private String schema;
    private Integer sex;
    private int status;
    private String tag;
    private boolean vip;
    private String vipLevel;
    private String vipLevelIcon;
    private int vtag;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static class RecentShowProject {
        private static transient /* synthetic */ IpChange $ipChange;
        private String formattedPriceStr;
        private long id;
        private String name;
        private String priceHigh;
        private String priceLow;
        private String priceStr;
        private List<String> promotionTags;
        private String showTime;
        private String subTitle;
        private List<String> tourProjects;
        private String type;
        private String venueCity;
        private String venueName;
        private String verticalPic;

        public String getFormattedPriceStr() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1847868314") ? (String) ipChange.ipc$dispatch("1847868314", new Object[]{this}) : this.formattedPriceStr;
        }

        public long getId() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "509458233") ? ((Long) ipChange.ipc$dispatch("509458233", new Object[]{this})).longValue() : this.id;
        }

        public String getName() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "136877099") ? (String) ipChange.ipc$dispatch("136877099", new Object[]{this}) : this.name;
        }

        public String getPriceHigh() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1144694433") ? (String) ipChange.ipc$dispatch("1144694433", new Object[]{this}) : this.priceHigh;
        }

        public String getPriceLow() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1551134613") ? (String) ipChange.ipc$dispatch("-1551134613", new Object[]{this}) : this.priceLow;
        }

        public String getPriceStr() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "210148040") ? (String) ipChange.ipc$dispatch("210148040", new Object[]{this}) : this.priceStr;
        }

        public List<String> getPromotionTags() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "413271449") ? (List) ipChange.ipc$dispatch("413271449", new Object[]{this}) : this.promotionTags;
        }

        public String getShowTime() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1399397642") ? (String) ipChange.ipc$dispatch("1399397642", new Object[]{this}) : this.showTime;
        }

        public String getSubTitle() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1738525336") ? (String) ipChange.ipc$dispatch("1738525336", new Object[]{this}) : this.subTitle;
        }

        public List<String> getTourProjects() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "117988409") ? (List) ipChange.ipc$dispatch("117988409", new Object[]{this}) : this.tourProjects;
        }

        public String getType() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "2020178778") ? (String) ipChange.ipc$dispatch("2020178778", new Object[]{this}) : this.type;
        }

        public String getVenueCity() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "4508432") ? (String) ipChange.ipc$dispatch("4508432", new Object[]{this}) : this.venueCity;
        }

        public String getVenueName() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-651305936") ? (String) ipChange.ipc$dispatch("-651305936", new Object[]{this}) : this.venueName;
        }

        public String getVerticalPic() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1223110390") ? (String) ipChange.ipc$dispatch("-1223110390", new Object[]{this}) : this.verticalPic;
        }

        public void setFormattedPriceStr(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1834629604")) {
                ipChange.ipc$dispatch("-1834629604", new Object[]{this, str});
            } else {
                this.formattedPriceStr = str;
            }
        }

        public void setId(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1601250261")) {
                ipChange.ipc$dispatch("-1601250261", new Object[]{this, Long.valueOf(j)});
            } else {
                this.id = j;
            }
        }

        public void setName(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-344533997")) {
                ipChange.ipc$dispatch("-344533997", new Object[]{this, str});
            } else {
                this.name = str;
            }
        }

        public void setPriceHigh(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-839415819")) {
                ipChange.ipc$dispatch("-839415819", new Object[]{this, str});
            } else {
                this.priceHigh = str;
            }
        }

        public void setPriceLow(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-722860589")) {
                ipChange.ipc$dispatch("-722860589", new Object[]{this, str});
            } else {
                this.priceLow = str;
            }
        }

        public void setPriceStr(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1957673194")) {
                ipChange.ipc$dispatch("-1957673194", new Object[]{this, str});
            } else {
                this.priceStr = str;
            }
        }

        public void setPromotionTags(List<String> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1467891477")) {
                ipChange.ipc$dispatch("-1467891477", new Object[]{this, list});
            } else {
                this.promotionTags = list;
            }
        }

        public void setShowTime(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "549326100")) {
                ipChange.ipc$dispatch("549326100", new Object[]{this, str});
            } else {
                this.showTime = str;
            }
        }

        public void setSubTitle(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1822617274")) {
                ipChange.ipc$dispatch("-1822617274", new Object[]{this, str});
            } else {
                this.subTitle = str;
            }
        }

        public void setTourProjects(List<String> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1841663309")) {
                ipChange.ipc$dispatch("-1841663309", new Object[]{this, list});
            } else {
                this.tourProjects = list;
            }
        }

        public void setType(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2091724092")) {
                ipChange.ipc$dispatch("-2091724092", new Object[]{this, str});
            } else {
                this.type = str;
            }
        }

        public void setVenueCity(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1825443482")) {
                ipChange.ipc$dispatch("-1825443482", new Object[]{this, str});
            } else {
                this.venueCity = str;
            }
        }

        public void setVenueName(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-680852410")) {
                ipChange.ipc$dispatch("-680852410", new Object[]{this, str});
            } else {
                this.venueName = str;
            }
        }

        public void setVerticalPic(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1561667668")) {
                ipChange.ipc$dispatch("-1561667668", new Object[]{this, str});
            } else {
                this.verticalPic = str;
            }
        }
    }

    public long getCreateTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1467035512") ? ((Long) ipChange.ipc$dispatch("-1467035512", new Object[]{this})).longValue() : this.createTime;
    }

    public int getDynamicNum() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2038673687") ? ((Integer) ipChange.ipc$dispatch("-2038673687", new Object[]{this})).intValue() : this.dynamicNum;
    }

    public int getFansNum() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "66542426") ? ((Integer) ipChange.ipc$dispatch("66542426", new Object[]{this})).intValue() : this.fansNum;
    }

    public String getFrom() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-622468147") ? (String) ipChange.ipc$dispatch("-622468147", new Object[]{this}) : this.from;
    }

    public String getObjectDesc() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "191244691") ? (String) ipChange.ipc$dispatch("191244691", new Object[]{this}) : this.objectDesc;
    }

    public String getObjectIdStr() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1395231478") ? (String) ipChange.ipc$dispatch("-1395231478", new Object[]{this}) : this.objectIdStr;
    }

    public String getObjectImg() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1895189367") ? (String) ipChange.ipc$dispatch("1895189367", new Object[]{this}) : this.objectImg;
    }

    public String getObjectName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1396775795") ? (String) ipChange.ipc$dispatch("-1396775795", new Object[]{this}) : this.objectName;
    }

    public int getObjectType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1851006295") ? ((Integer) ipChange.ipc$dispatch("1851006295", new Object[]{this})).intValue() : this.objectType;
    }

    public PerformFilmVipDO getPerformFilmVipDO() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "778347157") ? (PerformFilmVipDO) ipChange.ipc$dispatch("778347157", new Object[]{this}) : this.performFilmVipDO;
    }

    public List<RecentShowProject> getRecentShowProject() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-810028645") ? (List) ipChange.ipc$dispatch("-810028645", new Object[]{this}) : this.recentShowProject;
    }

    public int getRecentShowTotalNum() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2029262614") ? ((Integer) ipChange.ipc$dispatch("2029262614", new Object[]{this})).intValue() : this.recentShowTotalNum;
    }

    public String getSchema() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1594103228") ? (String) ipChange.ipc$dispatch("-1594103228", new Object[]{this}) : this.schema;
    }

    public Integer getSex() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1991673330") ? (Integer) ipChange.ipc$dispatch("-1991673330", new Object[]{this}) : this.sex;
    }

    public int getStatus() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1886385630") ? ((Integer) ipChange.ipc$dispatch("1886385630", new Object[]{this})).intValue() : this.status;
    }

    public String getTag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-593886707") ? (String) ipChange.ipc$dispatch("-593886707", new Object[]{this}) : this.tag;
    }

    public String getVipLevel() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-219968246") ? (String) ipChange.ipc$dispatch("-219968246", new Object[]{this}) : this.vipLevel;
    }

    public String getVipLevelIcon() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1559969699") ? (String) ipChange.ipc$dispatch("1559969699", new Object[]{this}) : this.vipLevelIcon;
    }

    public int getVtag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1694179116") ? ((Integer) ipChange.ipc$dispatch("1694179116", new Object[]{this})).intValue() : this.vtag;
    }

    public boolean isPerformFilmVip() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-160039175")) {
            return ((Boolean) ipChange.ipc$dispatch("-160039175", new Object[]{this})).booleanValue();
        }
        PerformFilmVipDO performFilmVipDO = this.performFilmVipDO;
        return performFilmVipDO != null && k23.d(performFilmVipDO.memberFlag);
    }

    public boolean isVip() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1220667748") ? ((Boolean) ipChange.ipc$dispatch("1220667748", new Object[]{this})).booleanValue() : this.vip;
    }

    public void setCreateTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "826417340")) {
            ipChange.ipc$dispatch("826417340", new Object[]{this, Long.valueOf(j)});
        } else {
            this.createTime = j;
        }
    }

    public void setDynamicNum(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "285502169")) {
            ipChange.ipc$dispatch("285502169", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.dynamicNum = i;
        }
    }

    public void setFansNum(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "291108848")) {
            ipChange.ipc$dispatch("291108848", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.fansNum = i;
        }
    }

    public void setFrom(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1885567153")) {
            ipChange.ipc$dispatch("1885567153", new Object[]{this, str});
        } else {
            this.from = str;
        }
    }

    public void setObjectDesc(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-476265301")) {
            ipChange.ipc$dispatch("-476265301", new Object[]{this, str});
        } else {
            this.objectDesc = str;
        }
    }

    public void setObjectIdStr(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1692513196")) {
            ipChange.ipc$dispatch("1692513196", new Object[]{this, str});
        } else {
            this.objectIdStr = str;
        }
    }

    public void setObjectImg(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "951090655")) {
            ipChange.ipc$dispatch("951090655", new Object[]{this, str});
        } else {
            this.objectImg = str;
        }
    }

    public void setObjectName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1834707185")) {
            ipChange.ipc$dispatch("1834707185", new Object[]{this, str});
        } else {
            this.objectName = str;
        }
    }

    public void setObjectType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "606497323")) {
            ipChange.ipc$dispatch("606497323", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.objectType = i;
        }
    }

    public void setPerformFilmVipDO(PerformFilmVipDO performFilmVipDO) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1387282009")) {
            ipChange.ipc$dispatch("-1387282009", new Object[]{this, performFilmVipDO});
        } else {
            this.performFilmVipDO = performFilmVipDO;
        }
    }

    public void setRecentShowProject(List<RecentShowProject> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1846275881")) {
            ipChange.ipc$dispatch("1846275881", new Object[]{this, list});
        } else {
            this.recentShowProject = list;
        }
    }

    public void setRecentShowTotalNum(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-674046900")) {
            ipChange.ipc$dispatch("-674046900", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.recentShowTotalNum = i;
        }
    }

    public void setSchema(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "727315482")) {
            ipChange.ipc$dispatch("727315482", new Object[]{this, str});
        } else {
            this.schema = str;
        }
    }

    public void setSex(Integer num) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1608813340")) {
            ipChange.ipc$dispatch("-1608813340", new Object[]{this, num});
        } else {
            this.sex = num;
        }
    }

    public void setStatus(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-877426556")) {
            ipChange.ipc$dispatch("-877426556", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.status = i;
        }
    }

    public void setTag(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "187929353")) {
            ipChange.ipc$dispatch("187929353", new Object[]{this, str});
        } else {
            this.tag = str;
        }
    }

    public void setVip(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-966879560")) {
            ipChange.ipc$dispatch("-966879560", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.vip = z;
        }
    }

    public void setVipLevel(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1888591124")) {
            ipChange.ipc$dispatch("1888591124", new Object[]{this, str});
        } else {
            this.vipLevel = str;
        }
    }

    public void setVipLevelIcon(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1512301467")) {
            ipChange.ipc$dispatch("1512301467", new Object[]{this, str});
        } else {
            this.vipLevelIcon = str;
        }
    }

    public void setVtag(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "891395062")) {
            ipChange.ipc$dispatch("891395062", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.vtag = i;
        }
    }
}
