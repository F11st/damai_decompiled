package cn.damai.ticklet.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class TickletDetailCompViewBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String AD_BOTTOM_IMG = "AD_BOTTOM_IMG";
    public static final String AD_RESOURCE = "AD_RESOURCE";
    public static final String CAOCAO_RESOURCE = "CAOCAO_RESOURCE";
    public static final int COMPVIEW_MODULE_AD_TYPE = 2;
    public static final int COMPVIEW_MODULE_DEFULT_TYPE = 0;
    public static final int COMPVIEW_MODULE_MAP_TYPE = 1;
    public static final int COMPVIEW_MODULE_SEP_BLOCK = 6;
    public static final int COMPVIEW_MODULE_SEP_BLOCK_ZERO = 7;
    public static final int COMPVIEW_MODULE_SEP_LINE = 5;
    public static final int COMPVIEW_MODULE_SERVICE_TYPE = 3;
    public static final int COMPVIEW_MODULE_TICKET_PERFORM = 9;
    public static final int COMPVIEW_MODULE_VENUE_GUIDE_SERVICE_LIST_TYPE = 8;
    public static final String E_SOUVENIR_RESOURCE = "E_SOUVENIR_RESOURCE";
    public static final String GETTICKET_RESOURCE = "GETTICKET_RESOURCE";
    public static final String GOTO_PAGE_APP_TYPE = "2";
    public static final String GOTO_PAGE_H5_TYPE = "1";
    public static final String GOTO_PAGE_NONE_TYPE = "0";
    public static final String GOTO_PAGE_SDK_TYPE = "3";
    public static final String IDST_RESOURCE = "IDST_RESOURCE";
    public static final String MAP_RESOURCE = "MAP_RESOURCE";
    public static final int MODULE_TYPE_SEP = 4;
    public static final String NEAR_RESOURCE = "NEAR_RESOURCE";
    public static final String NOTICE_RESOURCE = "NOTICE_RESOURCE";
    public static final String ORDER_RESOURCE = "ORDER_RESOURCE";
    public static final String SERVICE_RESOURCE = "SERVICE_RESOURCE";
    public static final String SOUVENIR_RESOURCE = "SOUVENIR_RESOURCE";
    public static final String VENUE_GUIDE_MAIN = "VENUE_GUIDE_MAIN";
    public static final String VENUE_GUIDE_SERVICE_LIST = "VENUE_GUIDE_SERVICE_LIST";
    private static final long serialVersionUID = 1;
    public String appProcess;
    public BizData bizData;
    public String contentType;
    public boolean isFirstPos;
    public boolean isLastPos;
    public String key;
    public String note;
    public TicketDeatilResult ticketDeatilResult;
    public String title;
    public String type;
    public String url;
    public int viewType;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public static class BizData implements Serializable {
        private static final long serialVersionUID = 1;
        public String h5Url;
        public String iconUrl;
        public String itemId;
        public String lat;
        public String link;
        public String lng;
        public ArrayList<String> normalQuestionList;
        public String note;
        public OrderInfo orderInfo;
        public String pdfVoucher;
        public String picUrl;
        public ArrayList<VenueServiceBean> serviceList;
        public String title;
    }

    public boolean isNoAllowGoto() {
        BizData bizData;
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1837136688") ? ((Boolean) ipChange.ipc$dispatch("-1837136688", new Object[]{this})).booleanValue() : "0".equals(this.type) || ("1".equals(this.type) && TextUtils.isEmpty(this.url)) || ((bizData = this.bizData) != null && "1".equals(bizData.pdfVoucher));
    }
}
