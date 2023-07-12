package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.dataholder;

import android.text.SpannableString;
import cn.damai.comment.bean.CommentsItemBean;
import cn.damai.commonbusiness.imagebrowse.bean.PicInfo;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.servicenotice.TicketNote;
import cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.HtmlParserManager;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.BrandAndArtists;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.InFieldCommentsBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectFreeTicketBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public final class ProjectDataHolder implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 7716181784824462662L;
    public List<BrandAndArtists> brandAndArtistsList;
    public String brandAndArtistsTitle;
    public BrandAndArtists brandOrArtists;
    private int commentNum;
    private int commentPosition;
    private int commentTotalNum;
    private List<String> commonProblems;
    private HtmlParserManager.a convertedItem;
    private int convertedItemPosition;
    private int convertedItemSize;
    private SpannableString discussionContent;
    private String discussionTips;
    private boolean hasShowLineup;
    private String highLightContent;
    private String highLightTitle;
    private CommentsItemBean hotComment;
    public List<InFieldCommentsBean> inFieldComments;
    private boolean isModuleDataBind;
    private boolean isShowLine;
    public boolean isTheater;
    private String mBannerPicUrl;
    private String mBannerRedirectUrl;
    private String mProjectId;
    private String mTheaterValue;
    private CommentsItemBean moduleComment;
    private int moduleType;
    private ArrayList<PicInfo> momentsInfo;
    private String moreContent;
    private int morePosition;
    private int moreType;
    private ProjectFreeTicketBean recommendFreeTicketItem;
    private ProjectItemBean recommendItem;
    private int recommendItemPosition;
    private int recommendListSize;
    private int richType;
    private String sectionTitleContent;
    private int sectionTitleType;
    private List<HtmlParserManager.a> shrinkConvertedItem;
    private int shrinkRichType;
    private int subTitlePosition;
    private TicketNote ticketNote;
    private TicketNote ticketNote2rd;
    private boolean ticketNoteEndPos;
    private CommentsItemBean userCommentItemBean;
    private ArrayList<VideoInfo> videoInfoList;

    public ProjectDataHolder(int i) {
        this.moduleType = i;
    }

    public String getBannerPicUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1853791217") ? (String) ipChange.ipc$dispatch("-1853791217", new Object[]{this}) : this.mBannerPicUrl;
    }

    public String getBannerRedirectUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1265978785") ? (String) ipChange.ipc$dispatch("-1265978785", new Object[]{this}) : this.mBannerRedirectUrl;
    }

    public int getCommentNum() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-536308402") ? ((Integer) ipChange.ipc$dispatch("-536308402", new Object[]{this})).intValue() : this.commentNum;
    }

    public int getCommentPosition() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1302624781") ? ((Integer) ipChange.ipc$dispatch("-1302624781", new Object[]{this})).intValue() : this.commentPosition;
    }

    public int getCommentTotalNum() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2043101478") ? ((Integer) ipChange.ipc$dispatch("-2043101478", new Object[]{this})).intValue() : this.commentTotalNum;
    }

    public List<String> getCommonProblems() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1955036124") ? (List) ipChange.ipc$dispatch("-1955036124", new Object[]{this}) : this.commonProblems;
    }

    public HtmlParserManager.a getConvertedItem() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-672116114") ? (HtmlParserManager.a) ipChange.ipc$dispatch("-672116114", new Object[]{this}) : this.convertedItem;
    }

    public int getConvertedItemPosition() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1029777037") ? ((Integer) ipChange.ipc$dispatch("1029777037", new Object[]{this})).intValue() : this.convertedItemPosition;
    }

    public int getConvertedItemSize() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-72091723") ? ((Integer) ipChange.ipc$dispatch("-72091723", new Object[]{this})).intValue() : this.convertedItemSize;
    }

    public SpannableString getDiscussionContent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "170124513") ? (SpannableString) ipChange.ipc$dispatch("170124513", new Object[]{this}) : this.discussionContent;
    }

    public String getDiscussionTips() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1445879678") ? (String) ipChange.ipc$dispatch("1445879678", new Object[]{this}) : this.discussionTips;
    }

    public String getHighLightContent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "276299779") ? (String) ipChange.ipc$dispatch("276299779", new Object[]{this}) : this.highLightContent;
    }

    public String getHighLightTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1019786206") ? (String) ipChange.ipc$dispatch("-1019786206", new Object[]{this}) : this.highLightTitle;
    }

    public CommentsItemBean getHotComment() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-894714518") ? (CommentsItemBean) ipChange.ipc$dispatch("-894714518", new Object[]{this}) : this.hotComment;
    }

    public CommentsItemBean getModuleComment() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "57194853") ? (CommentsItemBean) ipChange.ipc$dispatch("57194853", new Object[]{this}) : this.moduleComment;
    }

    public int getModuleType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1431605809") ? ((Integer) ipChange.ipc$dispatch("-1431605809", new Object[]{this})).intValue() : this.moduleType;
    }

    public ArrayList<PicInfo> getMomentsInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1167620575") ? (ArrayList) ipChange.ipc$dispatch("-1167620575", new Object[]{this}) : this.momentsInfo;
    }

    public String getMoreContent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-431517220") ? (String) ipChange.ipc$dispatch("-431517220", new Object[]{this}) : this.moreContent;
    }

    public int getMorePosition() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-736331849") ? ((Integer) ipChange.ipc$dispatch("-736331849", new Object[]{this})).intValue() : this.morePosition;
    }

    public int getMoreType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1678686202") ? ((Integer) ipChange.ipc$dispatch("-1678686202", new Object[]{this})).intValue() : this.moreType;
    }

    public String getProjectId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2059666484") ? (String) ipChange.ipc$dispatch("-2059666484", new Object[]{this}) : this.mProjectId;
    }

    public ProjectFreeTicketBean getRecommendFreeTicketItem() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1898825157") ? (ProjectFreeTicketBean) ipChange.ipc$dispatch("-1898825157", new Object[]{this}) : this.recommendFreeTicketItem;
    }

    public ProjectItemBean getRecommendItem() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1387732337") ? (ProjectItemBean) ipChange.ipc$dispatch("-1387732337", new Object[]{this}) : this.recommendItem;
    }

    public int getRecommendItemPosition() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2050873821") ? ((Integer) ipChange.ipc$dispatch("-2050873821", new Object[]{this})).intValue() : this.recommendItemPosition;
    }

    public int getRecommendListSize() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2098415008") ? ((Integer) ipChange.ipc$dispatch("-2098415008", new Object[]{this})).intValue() : this.recommendListSize;
    }

    public int getRichType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1381049503") ? ((Integer) ipChange.ipc$dispatch("1381049503", new Object[]{this})).intValue() : this.richType;
    }

    public String getSectionTitleContent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1896420094") ? (String) ipChange.ipc$dispatch("1896420094", new Object[]{this}) : this.sectionTitleContent;
    }

    public int getSectionTitleType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1934700072") ? ((Integer) ipChange.ipc$dispatch("1934700072", new Object[]{this})).intValue() : this.sectionTitleType;
    }

    public List<HtmlParserManager.a> getShrinkConvertedItem() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2135698341") ? (List) ipChange.ipc$dispatch("-2135698341", new Object[]{this}) : this.shrinkConvertedItem;
    }

    public int getShrinkRichType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1687011606") ? ((Integer) ipChange.ipc$dispatch("1687011606", new Object[]{this})).intValue() : this.shrinkRichType;
    }

    public int getSubTitlePosition() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "666076340") ? ((Integer) ipChange.ipc$dispatch("666076340", new Object[]{this})).intValue() : this.subTitlePosition;
    }

    public String getTheaterValue() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "677363870") ? (String) ipChange.ipc$dispatch("677363870", new Object[]{this}) : this.mTheaterValue;
    }

    public TicketNote getTicketNote() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1951298424") ? (TicketNote) ipChange.ipc$dispatch("1951298424", new Object[]{this}) : this.ticketNote;
    }

    public TicketNote getTicketNote2rd() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-963118566") ? (TicketNote) ipChange.ipc$dispatch("-963118566", new Object[]{this}) : this.ticketNote2rd;
    }

    public CommentsItemBean getUserCommentItemBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "894124521") ? (CommentsItemBean) ipChange.ipc$dispatch("894124521", new Object[]{this}) : this.userCommentItemBean;
    }

    public ArrayList<VideoInfo> getVideoInfoList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-661689253") ? (ArrayList) ipChange.ipc$dispatch("-661689253", new Object[]{this}) : this.videoInfoList;
    }

    public boolean hasShowLineup() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1192389686") ? ((Boolean) ipChange.ipc$dispatch("1192389686", new Object[]{this})).booleanValue() : this.hasShowLineup;
    }

    public boolean isModuleDataBind() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "117795449") ? ((Boolean) ipChange.ipc$dispatch("117795449", new Object[]{this})).booleanValue() : this.isModuleDataBind;
    }

    public boolean isShowLine() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "574110971") ? ((Boolean) ipChange.ipc$dispatch("574110971", new Object[]{this})).booleanValue() : this.isShowLine;
    }

    public boolean isTicketNoteEndPos() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "692904597") ? ((Boolean) ipChange.ipc$dispatch("692904597", new Object[]{this})).booleanValue() : this.ticketNoteEndPos;
    }

    public void setBannerPicUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1235071825")) {
            ipChange.ipc$dispatch("-1235071825", new Object[]{this, str});
        } else {
            this.mBannerPicUrl = str;
        }
    }

    public void setBannerRedirectUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "420358135")) {
            ipChange.ipc$dispatch("420358135", new Object[]{this, str});
        } else {
            this.mBannerRedirectUrl = str;
        }
    }

    public void setCommentNum(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-385814252")) {
            ipChange.ipc$dispatch("-385814252", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.commentNum = i;
        }
    }

    public void setCommentPosition(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-413504393")) {
            ipChange.ipc$dispatch("-413504393", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.commentPosition = i;
        }
    }

    public void setCommentTotalNum(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1893445520")) {
            ipChange.ipc$dispatch("-1893445520", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.commentTotalNum = i;
        }
    }

    public void setCommonProblems(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "826850088")) {
            ipChange.ipc$dispatch("826850088", new Object[]{this, list});
        } else {
            this.commonProblems = list;
        }
    }

    public void setConvertedItem(HtmlParserManager.a aVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "601282122")) {
            ipChange.ipc$dispatch("601282122", new Object[]{this, aVar});
        } else {
            this.convertedItem = aVar;
        }
    }

    public void setConvertedItemPosition(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1198491619")) {
            ipChange.ipc$dispatch("-1198491619", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.convertedItemPosition = i;
        }
    }

    public void setConvertedItemSize(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1256072693")) {
            ipChange.ipc$dispatch("1256072693", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.convertedItemSize = i;
        }
    }

    public void setDiscussionContent(SpannableString spannableString) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-106880731")) {
            ipChange.ipc$dispatch("-106880731", new Object[]{this, spannableString});
        } else {
            this.discussionContent = spannableString;
        }
    }

    public void setDiscussionTips(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1539476960")) {
            ipChange.ipc$dispatch("-1539476960", new Object[]{this, str});
        } else {
            this.discussionTips = str;
        }
    }

    public void setHasShowLineup(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1414787590")) {
            ipChange.ipc$dispatch("1414787590", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.hasShowLineup = z;
        }
    }

    public void setHighLightContent(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1196436165")) {
            ipChange.ipc$dispatch("-1196436165", new Object[]{this, str});
        } else {
            this.highLightContent = str;
        }
    }

    public void setHighLightTitle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-665708036")) {
            ipChange.ipc$dispatch("-665708036", new Object[]{this, str});
        } else {
            this.highLightTitle = str;
        }
    }

    public void setHotComment(CommentsItemBean commentsItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "188630632")) {
            ipChange.ipc$dispatch("188630632", new Object[]{this, commentsItemBean});
        } else {
            this.hotComment = commentsItemBean;
        }
    }

    public void setModuleComment(CommentsItemBean commentsItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1541767067")) {
            ipChange.ipc$dispatch("-1541767067", new Object[]{this, commentsItemBean});
        } else {
            this.moduleComment = commentsItemBean;
        }
    }

    public void setModuleDataBind(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1535488081")) {
            ipChange.ipc$dispatch("1535488081", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isModuleDataBind = z;
        }
    }

    public void setModuleType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1924737203")) {
            ipChange.ipc$dispatch("1924737203", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.moduleType = i;
        }
    }

    public void setMomentsInfo(ArrayList<PicInfo> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1266915255")) {
            ipChange.ipc$dispatch("1266915255", new Object[]{this, arrayList});
        } else {
            this.momentsInfo = arrayList;
        }
    }

    public void setMoreContent(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1502884122")) {
            ipChange.ipc$dispatch("1502884122", new Object[]{this, str});
        } else {
            this.moreContent = str;
        }
    }

    public void setMorePosition(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1399818443")) {
            ipChange.ipc$dispatch("1399818443", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.morePosition = i;
        }
    }

    public void setMoreType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "411117660")) {
            ipChange.ipc$dispatch("411117660", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.moreType = i;
        }
    }

    public void setProjectId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1390356438")) {
            ipChange.ipc$dispatch("-1390356438", new Object[]{this, str});
        } else {
            this.mProjectId = str;
        }
    }

    public void setRecommendFreeTicketItem(ProjectFreeTicketBean projectFreeTicketBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1306258579")) {
            ipChange.ipc$dispatch("1306258579", new Object[]{this, projectFreeTicketBean});
        } else {
            this.recommendFreeTicketItem = projectFreeTicketBean;
        }
    }

    public void setRecommendItem(ProjectItemBean projectItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "892962753")) {
            ipChange.ipc$dispatch("892962753", new Object[]{this, projectItemBean});
        } else {
            this.recommendItem = projectItemBean;
        }
    }

    public void setRecommendItemPosition(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2085579591")) {
            ipChange.ipc$dispatch("2085579591", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.recommendItemPosition = i;
        }
    }

    public void setRecommendListSize(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1430406998")) {
            ipChange.ipc$dispatch("-1430406998", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.recommendListSize = i;
        }
    }

    public void setRichType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "773644003")) {
            ipChange.ipc$dispatch("773644003", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.richType = i;
        }
    }

    public void setSectionTitleContent(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "334170168")) {
            ipChange.ipc$dispatch("334170168", new Object[]{this, str});
        } else {
            this.sectionTitleContent = str;
        }
    }

    public void setSectionTitleType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1898461818")) {
            ipChange.ipc$dispatch("1898461818", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.sectionTitleType = i;
        }
    }

    public void setShowLine(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "864490383")) {
            ipChange.ipc$dispatch("864490383", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isShowLine = z;
        }
    }

    public void setShrinkConvertedItem(List<HtmlParserManager.a> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "134402409")) {
            ipChange.ipc$dispatch("134402409", new Object[]{this, list});
        } else {
            this.shrinkConvertedItem = list;
        }
    }

    public void setShrinkRichType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1000974260")) {
            ipChange.ipc$dispatch("-1000974260", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.shrinkRichType = i;
        }
    }

    public void setSubTitlePosition(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1225831790")) {
            ipChange.ipc$dispatch("1225831790", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.subTitlePosition = i;
        }
    }

    public void setTheaterValue(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-78675456")) {
            ipChange.ipc$dispatch("-78675456", new Object[]{this, str});
        } else {
            this.mTheaterValue = str;
        }
    }

    public void setTicketNote(TicketNote ticketNote) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1004441758")) {
            ipChange.ipc$dispatch("1004441758", new Object[]{this, ticketNote});
        } else {
            this.ticketNote = ticketNote;
        }
    }

    public void setTicketNote2rd(TicketNote ticketNote) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2007091500")) {
            ipChange.ipc$dispatch("-2007091500", new Object[]{this, ticketNote});
        } else {
            this.ticketNote2rd = ticketNote;
        }
    }

    public void setTicketNotePosition(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "36279717")) {
            ipChange.ipc$dispatch("36279717", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.ticketNoteEndPos = z;
        }
    }

    public void setUserCommentItemBean(CommentsItemBean commentsItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1963126943")) {
            ipChange.ipc$dispatch("-1963126943", new Object[]{this, commentsItemBean});
        } else {
            this.userCommentItemBean = commentsItemBean;
        }
    }

    public void setVideoInfoList(ArrayList<VideoInfo> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2011196349")) {
            ipChange.ipc$dispatch("2011196349", new Object[]{this, arrayList});
        } else {
            this.videoInfoList = arrayList;
        }
    }
}
