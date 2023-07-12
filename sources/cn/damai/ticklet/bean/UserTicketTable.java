package cn.damai.ticklet.bean;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import cn.damai.common.db.db.annotation.Column;
import cn.damai.common.db.db.annotation.Table;
import cn.damai.ticklet.ui.fragment.TicketDetailExtFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import tb.j61;
import tb.m61;
import tb.qn1;
import tb.wh2;

/* compiled from: Taobao */
@Table(name = "ticket")
/* loaded from: classes16.dex */
public class UserTicketTable implements Serializable, Comparable<UserTicketTable>, Cloneable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String CHECK_OVER = "2";
    public static final String COUPON_TICKET = "41";
    public static final String DYNAMIC_TICKET = "1";
    public static final String FOREIGNERLIVING = "8";
    public static final String HONGKONGLIVINGCERT = "7";
    public static final String HONGKONGMACAU = "3";
    public static final String IDCARD = "1";
    public static final String INVAILD_TICKET = "5";
    public static final String LIVE_TICKET = "31";
    public static final String NUMBER_CODE_TICKET = "5";
    public static final String PAPER_TICKET = "4";
    public static final String PASSPORT = "2";
    public static final String PDF_TICKET = "21";
    public static final String REAL_NAMR = "3";
    public static final String REFUND_OVER = "4";
    public static final String STATIC_NUM_TICKET = "6";
    public static final String STATIC_TICKET = "2";
    public static final String TAIWAN = "4";
    public static final String TAKE_OVER = "3";
    public static final String TICKET_VOUCHER_SUB_TYPE = "1";
    public static final String TICKLET_BIND_FACE = "1";
    public static final String TIRNSFER_SELLING = "8";
    public static final String TIRNSFER_SOLD = "9";
    public static final String TRANSFER_OVER = "7";
    public static final String TRANSFER_RUNNING = "6";
    public static final String UNUSED = "1";
    public static final String USING = "20";
    private static final long serialVersionUID = 1;
    public TicketEventCodeBean activityCodeInfoVO;
    @Column(name = "checkCountDown")
    public String checkCountDown;
    @Column(name = "checkDirection")
    public String checkDirection;
    @Column(name = "ecertState")
    public String ecertState;
    @Column(name = "exchangeCode")
    public String exchangeCode;
    private TicketExtAttr extAttr;
    @Column(isId = true, name = "id")
    public int id;
    public String isForgotCardEntrance;
    @Column(name = "localExtAttr")
    private String localExtAttr;
    @Column(name = "localStandPortal")
    private String localStandPortal;
    private ArrayList<PerformOpModule> opTypeList;
    @Column(name = "opTypeListLocal")
    private String opTypeListLocal;
    @Column(name = "orderby")
    public int orderby;
    @Column(name = TicketDetailExtFragment.PERFORM_ID)
    public String performId;
    @Column(name = "price")
    public String price;
    @Column(name = TicketDetailExtFragment.PRODUCT_SYSTEM_ID)
    public String productSystemId;
    @Column(name = "productSystemVoucherId")
    public String productSystemVoucherId;
    @Column(name = "productSystemVoucherIdWithPre")
    public String productSystemVoucherIdWithPre;
    @Column(name = "pubKey")
    public String pubKey;
    @Column(name = "realNameTicketQrCodeType")
    public String realNameTicketQrCodeType;
    @Column(name = "realNameTicketShowMode")
    public String realNameTicketShowMode;
    @Column(name = "recvUserMobile")
    public String recvUserMobile;
    @Column(name = "recvUserNick")
    public String recvUserNick;
    @Column(name = "seatInfo")
    public String seatInfo;
    private TicketStandPortal standPortal;
    @Column(name = "staticUrl")
    public String staticUrl;
    private ArrayList<SubCouponNumBean> subTicketList;
    @Column(name = "subTicketListLocal")
    public String subTicketListLocal;
    @Column(name = "tips")
    public String tips;
    @Column(name = "tradeOrderId")
    public String tradeOrderId;
    @Column(name = "transferState")
    private String transferState;
    @Column(name = "useTips")
    public String useTips;
    @Column(name = "userCode")
    public String userCode;
    @Column(name = "verifyCode")
    public String verifyCode;
    @Column(name = "voucherCertName")
    public String voucherCertName;
    @Column(name = "voucherCertNo")
    public String voucherCertNo;
    @Column(name = "voucherCertType")
    public String voucherCertType;
    @Column(name = "voucherState")
    public String voucherState;
    @Column(name = "voucherSubType")
    private String voucherSubType;
    @Column(name = "voucherType")
    public String voucherType;
    @Column(name = "voucherUniqueKey")
    public String voucherUniqueKey;

    public Object clone() throws CloneNotSupportedException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "903214790")) {
            return ipChange.ipc$dispatch("903214790", new Object[]{this});
        }
        try {
            return (UserTicketTable) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.toString());
            return null;
        }
    }

    public String getCheckCountDown() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-17134858") ? (String) ipChange.ipc$dispatch("-17134858", new Object[]{this}) : this.checkCountDown;
    }

    public String getCheckDirection() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1317758244") ? (String) ipChange.ipc$dispatch("1317758244", new Object[]{this}) : this.checkDirection;
    }

    public String getExchangeCode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2049323645") ? (String) ipChange.ipc$dispatch("2049323645", new Object[]{this}) : this.exchangeCode;
    }

    public TicketExtAttr getExtAttr() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2101200931")) {
            return (TicketExtAttr) ipChange.ipc$dispatch("2101200931", new Object[]{this});
        }
        if (this.extAttr == null && !TextUtils.isEmpty(this.localExtAttr)) {
            this.extAttr = (TicketExtAttr) m61.a(getLocalExtAttr(), TicketExtAttr.class);
        }
        return this.extAttr;
    }

    public int getId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-261772373") ? ((Integer) ipChange.ipc$dispatch("-261772373", new Object[]{this})).intValue() : this.id;
    }

    public String getLocalExtAttr() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-428780524") ? (String) ipChange.ipc$dispatch("-428780524", new Object[]{this}) : this.localExtAttr;
    }

    public String getLocalStandPortal() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1920313148") ? (String) ipChange.ipc$dispatch("-1920313148", new Object[]{this}) : this.localStandPortal;
    }

    public ArrayList<PerformOpModule> getOpTypeList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "585470196")) {
            return (ArrayList) ipChange.ipc$dispatch("585470196", new Object[]{this});
        }
        if (wh2.e(this.opTypeList) == 0 && !TextUtils.isEmpty(this.opTypeListLocal)) {
            this.opTypeList = j61.a(this.opTypeListLocal, PerformOpModule.class);
        }
        return this.opTypeList;
    }

    public String getOpTypeListLocal() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-507324805") ? (String) ipChange.ipc$dispatch("-507324805", new Object[]{this}) : this.opTypeListLocal;
    }

    public int getOrderby() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1459639461") ? ((Integer) ipChange.ipc$dispatch("1459639461", new Object[]{this})).intValue() : this.orderby;
    }

    public String getPerformId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "536642917") ? (String) ipChange.ipc$dispatch("536642917", new Object[]{this}) : this.performId;
    }

    public String getPrice() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-320589614") ? (String) ipChange.ipc$dispatch("-320589614", new Object[]{this}) : this.price;
    }

    public String getProductSystemId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "277262274") ? (String) ipChange.ipc$dispatch("277262274", new Object[]{this}) : this.productSystemId;
    }

    public String getProductSystemVoucherIdWithPre() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2147148411") ? (String) ipChange.ipc$dispatch("2147148411", new Object[]{this}) : this.productSystemVoucherIdWithPre;
    }

    public String getPubKey() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-980844945") ? (String) ipChange.ipc$dispatch("-980844945", new Object[]{this}) : this.pubKey;
    }

    public String getRealNameTicketQrCodeType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1267001366") ? (String) ipChange.ipc$dispatch("-1267001366", new Object[]{this}) : this.realNameTicketQrCodeType;
    }

    public String getRealNameTicketShowMode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-466193438") ? (String) ipChange.ipc$dispatch("-466193438", new Object[]{this}) : this.realNameTicketShowMode;
    }

    public String getRecvUserMobile() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-215148896") ? (String) ipChange.ipc$dispatch("-215148896", new Object[]{this}) : this.recvUserMobile;
    }

    public String getRecvUserNick() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2100487073") ? (String) ipChange.ipc$dispatch("2100487073", new Object[]{this}) : this.recvUserNick;
    }

    public TicketStandPortal getStandPortal() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-783973949")) {
            return (TicketStandPortal) ipChange.ipc$dispatch("-783973949", new Object[]{this});
        }
        if (this.standPortal == null && !TextUtils.isEmpty(this.localStandPortal)) {
            this.standPortal = (TicketStandPortal) m61.a(getLocalStandPortal(), TicketStandPortal.class);
        }
        return this.standPortal;
    }

    public String getStaticUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "570365098") ? (String) ipChange.ipc$dispatch("570365098", new Object[]{this}) : this.staticUrl;
    }

    public ArrayList<SubCouponNumBean> getSubTicketList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1169477735")) {
            return (ArrayList) ipChange.ipc$dispatch("1169477735", new Object[]{this});
        }
        if (wh2.e(this.subTicketList) == 0 && !TextUtils.isEmpty(this.subTicketListLocal)) {
            this.subTicketList = j61.a(this.subTicketListLocal, SubCouponNumBean.class);
        }
        return this.subTicketList;
    }

    public String getSubTicketListLocal() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1916795602") ? (String) ipChange.ipc$dispatch("-1916795602", new Object[]{this}) : this.subTicketListLocal;
    }

    public String getTips() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1639174907") ? (String) ipChange.ipc$dispatch("-1639174907", new Object[]{this}) : this.tips;
    }

    public String getTransferState() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1916569711") ? (String) ipChange.ipc$dispatch("1916569711", new Object[]{this}) : this.transferState;
    }

    public String getUseTips() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-206769560") ? (String) ipChange.ipc$dispatch("-206769560", new Object[]{this}) : this.useTips;
    }

    public String getUserCode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-781424347") ? (String) ipChange.ipc$dispatch("-781424347", new Object[]{this}) : this.userCode;
    }

    public String getVerifyCode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "762422099") ? (String) ipChange.ipc$dispatch("762422099", new Object[]{this}) : this.verifyCode;
    }

    public String getVoucherCertName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "464683942") ? (String) ipChange.ipc$dispatch("464683942", new Object[]{this}) : this.voucherCertName;
    }

    public String getVoucherCertNo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1505242148") ? (String) ipChange.ipc$dispatch("-1505242148", new Object[]{this}) : this.voucherCertNo;
    }

    public String getVoucherCertType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1946981675") ? (String) ipChange.ipc$dispatch("-1946981675", new Object[]{this}) : this.voucherCertType;
    }

    public String getVoucherState() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-142580016") ? (String) ipChange.ipc$dispatch("-142580016", new Object[]{this}) : this.voucherState;
    }

    public String getVoucherSubType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1964079193") ? (String) ipChange.ipc$dispatch("1964079193", new Object[]{this}) : this.voucherSubType;
    }

    public String getVoucherType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1597239663") ? (String) ipChange.ipc$dispatch("-1597239663", new Object[]{this}) : this.voucherType;
    }

    public String getVoucherUniqueKey() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1258505357") ? (String) ipChange.ipc$dispatch("1258505357", new Object[]{this}) : this.voucherUniqueKey;
    }

    public boolean hasAvailableTicket() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1347347434") ? ((Boolean) ipChange.ipc$dispatch("1347347434", new Object[]{this})).booleanValue() : "1".equals(getVoucherState()) || "20".equals(getVoucherState());
    }

    public boolean isCertCardTicket() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-907782533") ? ((Boolean) ipChange.ipc$dispatch("-907782533", new Object[]{this})).booleanValue() : "3".equals(getVoucherType());
    }

    public boolean isCertETicketShowMode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1039257770") ? ((Boolean) ipChange.ipc$dispatch("1039257770", new Object[]{this})).booleanValue() : "2".equals(getRealNameTicketShowMode());
    }

    public boolean isCertShowMode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-76758153") ? ((Boolean) ipChange.ipc$dispatch("-76758153", new Object[]{this})).booleanValue() : "1".equals(getRealNameTicketShowMode());
    }

    public boolean isCouponTicket() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1323840919") ? ((Boolean) ipChange.ipc$dispatch("-1323840919", new Object[]{this})).booleanValue() : COUPON_TICKET.equals(getVoucherType());
    }

    public boolean isDynamicQrcode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1600485142") ? ((Boolean) ipChange.ipc$dispatch("-1600485142", new Object[]{this})).booleanValue() : isDynamicTicket() || (isCertCardTicket() && isCertETicketShowMode() && "2".equals(getRealNameTicketQrCodeType()));
    }

    public boolean isDynamicTicket() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1346451284") ? ((Boolean) ipChange.ipc$dispatch("-1346451284", new Object[]{this})).booleanValue() : "1".equals(getVoucherType());
    }

    public boolean isLiveTicket() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "311249123") ? ((Boolean) ipChange.ipc$dispatch("311249123", new Object[]{this})).booleanValue() : "31".equals(getVoucherType());
    }

    public boolean isNftTicket() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-858445105") ? ((Boolean) ipChange.ipc$dispatch("-858445105", new Object[]{this})).booleanValue() : "1".equals(getVoucherSubType());
    }

    public boolean isNumCodeTicket() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1380576472") ? ((Boolean) ipChange.ipc$dispatch("1380576472", new Object[]{this})).booleanValue() : "5".equals(getVoucherType());
    }

    public boolean isPaperTicket() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1827698047") ? ((Boolean) ipChange.ipc$dispatch("1827698047", new Object[]{this})).booleanValue() : "4".equals(getVoucherType());
    }

    public boolean isPdfTicket() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1449844825") ? ((Boolean) ipChange.ipc$dispatch("1449844825", new Object[]{this})).booleanValue() : "21".equals(getVoucherType());
    }

    public boolean isShowStandPortal() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1774564978") ? ((Boolean) ipChange.ipc$dispatch("1774564978", new Object[]{this})).booleanValue() : (getStandPortal() == null || TextUtils.isEmpty(getStandPortal().desc)) ? false : true;
    }

    public boolean isStaticQrcode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "688203103") ? ((Boolean) ipChange.ipc$dispatch("688203103", new Object[]{this})).booleanValue() : isStaticTicket() || isThirdStaticNumTicket() || isCouponTicket() || (isCertCardTicket() && isCertETicketShowMode() && "1".equals(getRealNameTicketQrCodeType()));
    }

    public boolean isStaticTicket() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "942236961") ? ((Boolean) ipChange.ipc$dispatch("942236961", new Object[]{this})).booleanValue() : "2".equals(getVoucherType());
    }

    public boolean isThirdStaticNumTicket() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1705712546") ? ((Boolean) ipChange.ipc$dispatch("-1705712546", new Object[]{this})).booleanValue() : "6".equals(getVoucherType());
    }

    public boolean isTicketGetModelMark() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-998211217") ? ((Boolean) ipChange.ipc$dispatch("-998211217", new Object[]{this})).booleanValue() : (getExtAttr() == null || TextUtils.isEmpty(getExtAttr().ticketGetModelMark)) ? false : true;
    }

    public boolean isTransferStateEnable() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-100555506") ? ((Boolean) ipChange.ipc$dispatch("-100555506", new Object[]{this})).booleanValue() : "1".equals(this.transferState);
    }

    public void setCheckCountDown(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "351712680")) {
            ipChange.ipc$dispatch("351712680", new Object[]{this, str});
        } else {
            this.checkCountDown = str;
        }
    }

    public void setCheckDirection(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1216274118")) {
            ipChange.ipc$dispatch("-1216274118", new Object[]{this, str});
        } else {
            this.checkDirection = str;
        }
    }

    public void setExchangeCode(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-497595391")) {
            ipChange.ipc$dispatch("-497595391", new Object[]{this, str});
        } else {
            this.exchangeCode = str;
        }
    }

    public void setExtAttr(TicketExtAttr ticketExtAttr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1927881213")) {
            ipChange.ipc$dispatch("1927881213", new Object[]{this, ticketExtAttr});
        } else {
            this.extAttr = ticketExtAttr;
        }
    }

    public void setId(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "260403799")) {
            ipChange.ipc$dispatch("260403799", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.id = i;
        }
    }

    public void setLocalExtAttr(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-9413302")) {
            ipChange.ipc$dispatch("-9413302", new Object[]{this, str});
        } else {
            this.localExtAttr = str;
        }
    }

    public void setLocalStandPortal(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-571960166")) {
            ipChange.ipc$dispatch("-571960166", new Object[]{this, str});
        } else {
            this.localStandPortal = str;
        }
    }

    public void setOpTypeList(ArrayList<PerformOpModule> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1321564636")) {
            ipChange.ipc$dispatch("1321564636", new Object[]{this, arrayList});
        } else {
            this.opTypeList = arrayList;
        }
    }

    public void setOpTypeListLocal(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1734613595")) {
            ipChange.ipc$dispatch("1734613595", new Object[]{this, str});
        } else {
            this.opTypeListLocal = str;
        }
    }

    public void setOrderby(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "527443973")) {
            ipChange.ipc$dispatch("527443973", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.orderby = i;
        }
    }

    public void setPerformId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1785823665")) {
            ipChange.ipc$dispatch("1785823665", new Object[]{this, str});
        } else {
            this.performId = str;
        }
    }

    public void setPrice(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1143024100")) {
            ipChange.ipc$dispatch("1143024100", new Object[]{this, str});
        } else {
            this.price = str;
        }
    }

    public void setProductSystemId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "287009268")) {
            ipChange.ipc$dispatch("287009268", new Object[]{this, str});
        } else {
            this.productSystemId = str;
        }
    }

    public void setProductSystemVoucherIdWithPre(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1025357477")) {
            ipChange.ipc$dispatch("-1025357477", new Object[]{this, str});
        } else {
            this.productSystemVoucherIdWithPre = str;
        }
    }

    public void setPubKey(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1736514225")) {
            ipChange.ipc$dispatch("-1736514225", new Object[]{this, str});
        } else {
            this.pubKey = str;
        }
    }

    public void setRealNameTicketQrCodeType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "891815476")) {
            ipChange.ipc$dispatch("891815476", new Object[]{this, str});
        } else {
            this.realNameTicketQrCodeType = str;
        }
    }

    public void setRealNameTicketShowMode(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-118278596")) {
            ipChange.ipc$dispatch("-118278596", new Object[]{this, str});
        } else {
            this.realNameTicketShowMode = str;
        }
    }

    public void setRecvUserMobile(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1491755202")) {
            ipChange.ipc$dispatch("-1491755202", new Object[]{this, str});
        } else {
            this.recvUserMobile = str;
        }
    }

    public void setRecvUserNick(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1088470877")) {
            ipChange.ipc$dispatch("1088470877", new Object[]{this, str});
        } else {
            this.recvUserNick = str;
        }
    }

    public void setStandPortal(TicketStandPortal ticketStandPortal) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1255762051")) {
            ipChange.ipc$dispatch("-1255762051", new Object[]{this, ticketStandPortal});
        } else {
            this.standPortal = ticketStandPortal;
        }
    }

    public void setStaticUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1463756020")) {
            ipChange.ipc$dispatch("-1463756020", new Object[]{this, str});
        } else {
            this.staticUrl = str;
        }
    }

    public void setSubTicketList(ArrayList<SubCouponNumBean> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1352169167")) {
            ipChange.ipc$dispatch("-1352169167", new Object[]{this, arrayList});
        } else {
            this.subTicketList = arrayList;
        }
    }

    public void setSubTicketListLocal(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "666871920")) {
            ipChange.ipc$dispatch("666871920", new Object[]{this, str});
        } else {
            this.subTicketListLocal = str;
        }
    }

    public void setTips(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "432428665")) {
            ipChange.ipc$dispatch("432428665", new Object[]{this, str});
        } else {
            this.tips = str;
        }
    }

    public void setTransferState(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1710422503")) {
            ipChange.ipc$dispatch("1710422503", new Object[]{this, str});
        } else {
            this.transferState = str;
        }
    }

    public void setUseTips(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "563824654")) {
            ipChange.ipc$dispatch("563824654", new Object[]{this, str});
        } else {
            this.useTips = str;
        }
    }

    public void setUserCode(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1663321177")) {
            ipChange.ipc$dispatch("1663321177", new Object[]{this, str});
        } else {
            this.userCode = str;
        }
    }

    public void setVerifyCode(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "50365163")) {
            ipChange.ipc$dispatch("50365163", new Object[]{this, str});
        } else {
            this.verifyCode = str;
        }
    }

    public void setVoucherCertName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1802113680")) {
            ipChange.ipc$dispatch("1802113680", new Object[]{this, str});
        } else {
            this.voucherCertName = str;
        }
    }

    public void setVoucherCertNo(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1286530022")) {
            ipChange.ipc$dispatch("-1286530022", new Object[]{this, str});
        } else {
            this.voucherCertNo = str;
        }
    }

    public void setVoucherCertType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "54923585")) {
            ipChange.ipc$dispatch("54923585", new Object[]{this, str});
        } else {
            this.voucherCertType = str;
        }
    }

    public void setVoucherState(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "272867854")) {
            ipChange.ipc$dispatch("272867854", new Object[]{this, str});
        } else {
            this.voucherState = str;
        }
    }

    public void setVoucherSubType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1639806117")) {
            ipChange.ipc$dispatch("1639806117", new Object[]{this, str});
        } else {
            this.voucherSubType = str;
        }
    }

    public void setVoucherType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-274773243")) {
            ipChange.ipc$dispatch("-274773243", new Object[]{this, str});
        } else {
            this.voucherType = str;
        }
    }

    public void setVoucherUniqueKey(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-812834319")) {
            ipChange.ipc$dispatch("-812834319", new Object[]{this, str});
        } else {
            this.voucherUniqueKey = str;
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull UserTicketTable userTicketTable) {
        String str;
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1524220455")) {
            return ((Integer) ipChange.ipc$dispatch("1524220455", new Object[]{this, userTicketTable})).intValue();
        }
        int a = qn1.a(this) - qn1.a(userTicketTable);
        if (a == 0) {
            if (isCertCardTicket() && userTicketTable.isCertCardTicket() && getVoucherCertNo() != null && userTicketTable.getVoucherCertNo() != null) {
                return getVoucherCertNo().compareTo(userTicketTable.getVoucherCertNo());
            }
            if (isNumCodeTicket() && userTicketTable.isNumCodeTicket() && getExchangeCode() != null && userTicketTable.getExchangeCode() != null) {
                return getExchangeCode().compareTo(userTicketTable.getExchangeCode());
            }
            if (isCouponTicket() && userTicketTable.isCouponTicket() && (str = this.productSystemVoucherId) != null && (str2 = userTicketTable.productSystemVoucherId) != null) {
                return str.compareTo(str2);
            }
        }
        return a;
    }
}
