package cn.damai.commonbusiness.share.generateimage;

import android.graphics.Bitmap;
import cn.damai.comment.bean.DmInfo;
import cn.damai.comment.bean.StoreInfo;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class DMShareMessage implements Serializable {
    public static final String KEY_ADS_BANNER = "adsBanner";
    public static final String KEY_EVALUATE_DMINFO = "dmInfo";
    public static final String KEY_EVALUATE_ITEM_TYPE = "itemType";
    public static final String KEY_EVALUATE_REMARK = "remarkValue";
    public static final String KEY_EVALUATE_STOREINFO = "storeInfo";
    public static final String KEY_EXTRA_MEDIA = "extraMedia";
    public static final String KEY_PROJECT_CITY = "projectCity";
    public static final String KEY_PROJECT_TIME = "projectTime";
    public static final String KEY_SHARE_FOOTER = "shareFooter";
    public static final String KEY_YYMEMBER_INTEGRATE = "yyMemberIntegrate";
    private static final long serialVersionUID = 1;
    public AdsBanner adsBanner;
    public String bgImageUrl;
    public Bitmap businessBitmap;
    public String commentType;
    public String currentPrice;
    public DmInfo dmInfo;
    public int evaluateGrade;
    public String evaluateGradeDesc;
    public String evaluateTime;
    public List<ExtraMedia> extraMedia;
    public String fromWhere;
    public String headUrl;
    public int itemType;
    public String memberFlag;
    public String originPrice;
    public String projectCity;
    public String projectId;
    public String projectTime;
    public QRCodeColor qrCodeColor;
    public String remarkValue;
    public int requestCode;
    public String shareContent;
    public String shareFooter;
    public String shareImageStyle;
    public String shareLink;
    public String sharePictureUrl;
    public String shareTitle;
    public String showtime;
    public StoreInfo storeInfo;
    public String tip;
    public String userHeaderIcon;
    public String userMessage;
    public String userNick;
    public boolean vip;
    public String vipLevelIcon;
    public YYMemberIntegrate vipScore;
    public String windowTitle;
    public String wxtitle;
    public String ycCode;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class AdsBanner implements Serializable {
        private static final long serialVersionUID = 1;
        public String subTitle;
        public String title;
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class ExtraMedia implements Serializable {
        private static final long serialVersionUID = 1;
        public String coverUrl;
        public boolean isVideo;
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class QRCodeColor implements Serializable {
        private static final long serialVersionUID = -985456821228750695L;
        public int radius;
        public String solidColor;
        public String strokeColor;
        public int strokeWidth;
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class YYMemberIntegrate implements Serializable {
        private static final long serialVersionUID = 1;
        public String id;
        public String memberFlag;
        public String oriScore;
    }
}
