package cn.damai.trade.oldtradeorder.ui.orderdetail.detail.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import cn.damai.baseview.abcpullrefresh.actionbarcompat.PullToRefreshLayout;
import cn.damai.baseview.abcpullrefresh.library.listeners.OnRefreshListener;
import cn.damai.common.DamaiConstants;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener;
import cn.damai.common.util.ACache;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.address.bean.AddressBean;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.seatbiz.orderdetail.bean.OrderDetail;
import cn.damai.commonbusiness.seatbiz.orderdetail.bean.OrderDetailInvoice;
import cn.damai.commonbusiness.seatbiz.orderdetail.bean.PayInfo;
import cn.damai.commonbusiness.seatbiz.orderdetail.bean.SeatItem;
import cn.damai.commonbusiness.seatbiz.orderdetail.bean.SuperTickt;
import cn.damai.commonbusiness.seatbiz.orderdetail.bean.TrackInfo;
import cn.damai.commonbusiness.seatbiz.orderdetail.bean.YPYZInfo;
import cn.damai.commonbusiness.seatbiz.orderdetail.bean.jinPai;
import cn.damai.commonbusiness.seatbiz.seat.wolf.oldtradeorder.model.jinPaiEntity;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.im.AliMeUtil;
import cn.damai.net.DamaiDataAccessApi;
import cn.damai.pay.AliPayActivity;
import cn.damai.pay.UnionPayActivity;
import cn.damai.pay.WapPayActivity;
import cn.damai.trade.R$color;
import cn.damai.trade.R$drawable;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.R$string;
import cn.damai.trade.fab.FloatingActionButton;
import cn.damai.trade.fab.ObservableScrollView;
import cn.damai.trade.fab.ScrollDirectionListener;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.activity.OrderInvoiceActivity;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.activity.OrderInvoiceDetailActivity;
import cn.damai.trade.newtradeorder.ui.orderlist.ui.activity.OrderListActivity;
import cn.damai.trade.oldtradeorder.ui.orderdetail.detail.SuperTicketAdapter;
import cn.damai.trade.oldtradeorder.ui.orderdetail.detail.helper.MainListView;
import cn.damai.trade.oldtradeorder.ui.orderdetail.detail.model.OrderCancelResult;
import cn.damai.trade.oldtradeorder.ui.orderdetail.detail.model.OrderParmasResult;
import cn.damai.trade.oldtradeorder.ui.orderdetail.detail.model.OrderredBox;
import cn.damai.trade.oldtradeorder.ui.orderdetail.detail.request.ZLOrderDetailCancelRequest;
import cn.damai.trade.oldtradeorder.ui.orderdetail.detail.request.ZLOrderDetailOtherRequest;
import cn.damai.trade.oldtradeorder.ui.orderdetail.detail.request.ZLOrderDetailPayRequest;
import cn.damai.trade.oldtradeorder.ui.orderdetail.detail.request.ZLOrderDetailRequest;
import cn.damai.wxapi.DamaiWXPayActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.uplayer.AliMediaPlayer;
import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import tb.cg1;
import tb.cm2;
import tb.cs;
import tb.ir1;
import tb.j11;
import tb.jn1;
import tb.mo1;
import tb.mr1;
import tb.mu0;
import tb.pp2;
import tb.r30;
import tb.so1;
import tb.w2;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class OrderDetailNewActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    static int height;
    static int width;
    View baoxian_price_view;
    Button btn_cancel;
    private LinearLayout btn_kefu;
    Button btn_submit;
    private Button choose_zuowei_btn;
    private View choose_zuowei_view;
    TextView createtime_text;
    TextView dayText;
    TextView deliver_address_text;
    TextView deliver_descript_text;
    TextView deliver_email_text;
    TextView deliver_method_text;
    TextView deliver_name_text;
    TextView deliver_phone_text;
    private Drawable[] drawableArray;
    boolean hasSetFirstWay;
    View has_seat_line_view;
    TextView hourText;
    ImageView iv_deliverway_icon;
    private ImageView iv_header_right_icon;
    FloatingActionButton iv_lingqian;
    TextView lastLine;
    LinearLayout ll_btn;
    private LinearLayout ll_ok_cancel;
    private LinearLayout ll_ok_replenishment;
    LinearLayout ll_pay_method;
    LinearLayout ll_pay_method_tip;
    private View ll_paydetail;
    private LinearLayout ll_project_info;
    LinearLayout ll_projectimage;
    LinearLayout ll_tip;
    LinearLayout ll_trace;
    LinearLayout ll_trace_info;
    private LinearLayout mAddInvoiceGoLayout;
    private LinearLayout mAddInvoiceLayout;
    private LinearLayout mAddInvoiceTipLayout;
    private TextView mAddInvoiceTipTv;
    TextView mBtnModifyAddress;
    private DMDialog mCancelOrderDialog;
    private View mContentView;
    private String mImageUrl;
    private DMDialog mOrderAddressDialog;
    private OrderDetail mOrderDetail;
    private PayInfo mPayInfo;
    private LinearLayout mPushDeliveryTipLayout;
    private TextView mPushDeliveryTipTv;
    private ObservableScrollView mScrollView;
    private TextView mTvReplenishment;
    TextView minText;
    Date nowDate;
    String nowTimeString;
    TextView num_ticket_text;
    private RelativeLayout order_detail_price_rlyt;
    private LinearLayout order_detail_send_llyt;
    private MainListView order_new_detail_listview;
    TextView order_num;
    TextView orderno_text;
    OrderredBox orderredBox;
    int payMethodId;
    TextView pay_desc_text;
    TextView price_ticket_text;
    private String projectId;
    ImageView project_image;
    TextView projectaddress_text;
    TextView projectname_text;
    TextView projecttime_text;
    PullToRefreshLayout pull_down_view;
    private LinearLayout ray_detail;
    private ImageView ray_image;
    private LinearLayout ray_image_line;
    private TextView ray_text;
    RelativeLayout rl_jifen;
    TextView rl_jifen_line;
    RelativeLayout rl_youhui;
    TextView rl_youhui_line;
    RelativeLayout rl_youhuizc;
    TextView rl_youhuizc_line;
    RelativeLayout rl_yunfei;
    TextView rl_yunfei_line;
    LinearLayout seat_add_view;
    TextView secondText;
    View show_more_seat_view;
    String startTimeString;
    TextView status_text;
    private SuperTicketAdapter superTicketAdapter;
    Thread t;
    View take_photo_view;
    TextView timeText;
    private View timeView;
    private Timer timer;
    private TimerTask timerTask;
    TextView tv_baoxian_price;
    private TextView tv_delivery_money;
    private TextView tv_line_tip;
    private TextView tv_minute_0;
    private TextView tv_minute_1;
    TextView tv_order_price;
    TextView tv_product_price;
    private TextView tv_replenishment;
    private TextView tv_second_0;
    private TextView tv_second_1;
    TextView tv_ticket_price;
    private TextView tv_ticket_score;
    private TextView tv_ticket_total_money;
    private TextView tv_ticket_yhzc;
    private TextView tv_time_message;
    private TextView tv_total_money;
    TextView tv_yunfei_price;
    private View v_line_1;
    private LinearLayout ypyz_add_show_view;
    private LinearLayout ypyz_add_view;
    private ImageView ypyz_seat_image_btn;
    private View ypyz_show_more_seat_view;
    private final int FROM_ORDER_LIST = 0;
    private final int FROM_PUSH = 1;
    private final int BACK_FROM_PAGE = 2;
    private int mFromPage = 0;
    private View.OnClickListener mModifyListener = new w();
    private Handler timeHandler = new b();
    boolean isUsing = false;
    int times = 0;
    String days = "00";
    String hours = "00";
    String mins = "00";
    String seconds = "00";
    Handler timeThread = new d();
    ArrayList<View> seatMoreView = new ArrayList<>();
    ArrayList<View> ypyzView = new ArrayList<>();
    boolean hasNoPayMethod = false;
    private String orderId = "";
    private boolean mHasModifyAddress = false;
    private final int REQUEST_CODR_INVOICE = 8008;
    String sharebitmap = "";

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class a implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "73970551")) {
                ipChange.ipc$dispatch("73970551", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            dialogInterface.dismiss();
            OrderDetailNewActivity orderDetailNewActivity = OrderDetailNewActivity.this;
            orderDetailNewActivity.times = 0;
            orderDetailNewActivity.cancelTimer();
            OrderDetailNewActivity.this.requestOrderDetail();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class b extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i;
            int i2;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "443106486")) {
                ipChange.ipc$dispatch("443106486", new Object[]{this, message});
                return;
            }
            try {
                if (OrderDetailNewActivity.this.mOrderDetail == null) {
                    return;
                }
                if (OrderDetailNewActivity.this.mOrderDetail == null || OrderDetailNewActivity.this.mOrderDetail.PayTime < 3600) {
                    i = OrderDetailNewActivity.this.mOrderDetail.PayTime / 60;
                    i2 = OrderDetailNewActivity.this.mOrderDetail.PayTime % 60;
                } else {
                    int i3 = OrderDetailNewActivity.this.mOrderDetail.PayTime - ((OrderDetailNewActivity.this.mOrderDetail.PayTime / ACache.TIME_HOUR) * ACache.TIME_HOUR);
                    i = i3 / 60;
                    i2 = i3 % 60;
                }
                if (OrderDetailNewActivity.this.drawableArray == null || OrderDetailNewActivity.this.drawableArray.length < 10) {
                    OrderDetailNewActivity.this.initTenDrawable();
                }
                if (OrderDetailNewActivity.this.tv_minute_0 == null) {
                    return;
                }
                OrderDetailNewActivity.this.tv_minute_0.setBackgroundDrawable(OrderDetailNewActivity.this.drawableArray[i / 10]);
                OrderDetailNewActivity.this.tv_minute_1.setBackgroundDrawable(OrderDetailNewActivity.this.drawableArray[i % 10]);
                OrderDetailNewActivity.this.tv_second_0.setBackgroundDrawable(OrderDetailNewActivity.this.drawableArray[i2 / 10]);
                OrderDetailNewActivity.this.tv_second_1.setBackgroundDrawable(OrderDetailNewActivity.this.drawableArray[i2 % 10]);
                OrderDetailNewActivity.this.mOrderDetail.PayTime--;
                if (OrderDetailNewActivity.this.mOrderDetail.PayTime == -1) {
                    String a = so1.a(OrderDetailNewActivity.this, "交易关闭");
                    if (!TextUtils.isEmpty(a)) {
                        OrderDetailNewActivity.this.status_text.setTextColor(Color.parseColor(a));
                    }
                    OrderDetailNewActivity.this.status_text.setText("交易关闭");
                    OrderDetailNewActivity.this.timer.cancel();
                    OrderDetailNewActivity.this.ll_btn.setVisibility(8);
                    OrderDetailNewActivity.this.ll_tip.setVisibility(8);
                    OrderDetailNewActivity.this.ll_pay_method.setVisibility(8);
                    OrderDetailNewActivity.this.ll_pay_method_tip.setVisibility(8);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c(OrderDetailNewActivity orderDetailNewActivity) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1371523590")) {
                ipChange.ipc$dispatch("-1371523590", new Object[]{this, view});
            } else {
                ToastUtil.a().j(mu0.a(), "项目已不支持跳转");
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class d extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "532879187")) {
                ipChange.ipc$dispatch("532879187", new Object[]{this, message});
                return;
            }
            super.handleMessage(message);
            if (message.what == 100) {
                Timer unused = OrderDetailNewActivity.this.timer;
                OrderDetailNewActivity orderDetailNewActivity = OrderDetailNewActivity.this;
                orderDetailNewActivity.isUsing = false;
                Thread thread = orderDetailNewActivity.t;
                if (thread != null) {
                    thread.interrupt();
                    OrderDetailNewActivity.this.t = null;
                }
                OrderDetailNewActivity orderDetailNewActivity2 = OrderDetailNewActivity.this;
                orderDetailNewActivity2.nowDate = null;
                if (!orderDetailNewActivity2.isFinishing()) {
                    OrderDetailNewActivity.this.requestOrderDetail();
                }
            }
            if (message.what == 101) {
                OrderDetailNewActivity.this.requestOrderDetail();
            }
            if (message.what == 0) {
                OrderDetailNewActivity orderDetailNewActivity3 = OrderDetailNewActivity.this;
                orderDetailNewActivity3.dayText.setText(orderDetailNewActivity3.days);
                OrderDetailNewActivity orderDetailNewActivity4 = OrderDetailNewActivity.this;
                orderDetailNewActivity4.hourText.setText(orderDetailNewActivity4.hours);
                OrderDetailNewActivity orderDetailNewActivity5 = OrderDetailNewActivity.this;
                orderDetailNewActivity5.minText.setText(orderDetailNewActivity5.mins);
                OrderDetailNewActivity orderDetailNewActivity6 = OrderDetailNewActivity.this;
                orderDetailNewActivity6.secondText.setText(orderDetailNewActivity6.seconds);
                TextView textView = OrderDetailNewActivity.this.timeText;
                textView.setText(cm2.b(OrderDetailNewActivity.this, R$string.damai_orderdetailnew_grab_seat_start_time) + OrderDetailNewActivity.this.startTimeString);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class e implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1516296706")) {
                ipChange.ipc$dispatch("-1516296706", new Object[]{this, view});
                return;
            }
            for (int i = 0; i < OrderDetailNewActivity.this.seatMoreView.size(); i++) {
                if (OrderDetailNewActivity.this.seatMoreView.get(i).getVisibility() == 0) {
                    OrderDetailNewActivity.this.seatMoreView.get(i).setVisibility(8);
                    ((ImageView) OrderDetailNewActivity.this.findViewById(R$id.seat_image_btn)).setImageResource(R$drawable.dd_more_pic);
                } else {
                    OrderDetailNewActivity.this.seatMoreView.get(i).setVisibility(0);
                    ((ImageView) OrderDetailNewActivity.this.findViewById(R$id.seat_image_btn)).setImageResource(R$drawable.dd_more1_pic);
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class f implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "594993663")) {
                ipChange.ipc$dispatch("594993663", new Object[]{this, view});
                return;
            }
            Iterator<View> it = OrderDetailNewActivity.this.ypyzView.iterator();
            while (it.hasNext()) {
                View next = it.next();
                if (next.getVisibility() == 0) {
                    next.setVisibility(8);
                    OrderDetailNewActivity.this.ypyz_seat_image_btn.setImageResource(R$drawable.dd_more_pic);
                } else {
                    next.setVisibility(0);
                    OrderDetailNewActivity.this.ypyz_seat_image_btn.setImageResource(R$drawable.dd_more1_pic);
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class g implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1588683264")) {
                ipChange.ipc$dispatch("-1588683264", new Object[]{this, view});
                return;
            }
            PayInfo payInfo = (PayInfo) view.getTag();
            OrderDetailNewActivity orderDetailNewActivity = OrderDetailNewActivity.this;
            orderDetailNewActivity.payMethodId = payInfo.payId;
            orderDetailNewActivity.mPayInfo = payInfo;
            OrderDetailNewActivity orderDetailNewActivity2 = OrderDetailNewActivity.this;
            orderDetailNewActivity2.changePayMethodState(orderDetailNewActivity2.payMethodId);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class h implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "522607105")) {
                ipChange.ipc$dispatch("522607105", new Object[]{this, view});
            } else {
                OrderDetailNewActivity.this.onPaySubmit();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class i implements ScrollDirectionListener {
        private static transient /* synthetic */ IpChange $ipChange;

        i(OrderDetailNewActivity orderDetailNewActivity) {
        }

        @Override // cn.damai.trade.fab.ScrollDirectionListener
        public void onScrollDown() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1795739283")) {
                ipChange.ipc$dispatch("-1795739283", new Object[]{this});
            }
        }

        @Override // cn.damai.trade.fab.ScrollDirectionListener
        public void onScrollUp() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "201492308")) {
                ipChange.ipc$dispatch("201492308", new Object[]{this});
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class j implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-273645033")) {
                ipChange.ipc$dispatch("-273645033", new Object[]{this, view});
                return;
            }
            cn.damai.common.user.c.e().x(pp2.u().A(OrderDetailNewActivity.this.mOrderDetail != null ? String.valueOf(OrderDetailNewActivity.this.mOrderDetail.ProjectID) : OrderDetailNewActivity.this.projectId, OrderDetailNewActivity.this.orderId, true));
            OrderDetailNewActivity.this.startCouponDialog();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class k implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1837645336")) {
                ipChange.ipc$dispatch("1837645336", new Object[]{this, view});
                return;
            }
            String valueOf = OrderDetailNewActivity.this.mOrderDetail != null ? String.valueOf(OrderDetailNewActivity.this.mOrderDetail.ProjectID) : OrderDetailNewActivity.this.projectId;
            cn.damai.common.user.c.e().x(pp2.u().M(valueOf, OrderDetailNewActivity.this.orderId));
            cn.damai.common.user.c.e().A(pp2.u().O(valueOf, OrderDetailNewActivity.this.orderId), pp2.CUSTOM_ORDER, pp2.ORDER_DETAL_PAGE);
            OrderDetailNewActivity.this.onPaySubmit();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class l implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-346031591")) {
                ipChange.ipc$dispatch("-346031591", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("orderId", OrderDetailNewActivity.this.orderId);
            bundle.putLong("projectId", OrderDetailNewActivity.this.mOrderDetail.ProjectID);
            DMNav.from(OrderDetailNewActivity.this).withExtras(bundle).toUri(NavUri.b("member_ticketwalletinfo"));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class m implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        m() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-350432012")) {
                ipChange.ipc$dispatch("-350432012", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            OrderDetailNewActivity.this.startActivity(new Intent(OrderDetailNewActivity.this.mContext, OrderListActivity.class));
            OrderDetailNewActivity.this.setResult(1000);
            if (OrderDetailNewActivity.this.mFromPage == 1 || OrderDetailNewActivity.this.mFromPage == 2) {
                return;
            }
            OrderDetailNewActivity.this.finish();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class n implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1620485662")) {
                ipChange.ipc$dispatch("1620485662", new Object[]{this, view});
                return;
            }
            OrderDetailNewActivity.this.ray_detail.setVisibility(8);
            mu0.g = true;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class o implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-563191265")) {
                ipChange.ipc$dispatch("-563191265", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("title", OrderDetailNewActivity.this.orderredBox.Title);
            bundle.putString("message", OrderDetailNewActivity.this.orderredBox.Content);
            bundle.putString("imageurl", OrderDetailNewActivity.this.orderredBox.ShareImg);
            bundle.putString("producturl", OrderDetailNewActivity.this.orderredBox.Url + OrderDetailNewActivity.this.orderId);
            bundle.putString("fromWhere", "orderDetail2");
            bundle.putString("sinaSharePath", OrderDetailNewActivity.this.sharebitmap);
            ShareManager.E().O(OrderDetailNewActivity.this, bundle, R$layout.order_detail_activity);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class p implements ObservableScrollView.OnScrollChangedListener {
        private static transient /* synthetic */ IpChange $ipChange;

        p(OrderDetailNewActivity orderDetailNewActivity) {
        }

        @Override // cn.damai.trade.fab.ObservableScrollView.OnScrollChangedListener
        public void onScrollChanged(ScrollView scrollView, int i, int i2, int i3, int i4) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1081601954")) {
                ipChange.ipc$dispatch("-1081601954", new Object[]{this, scrollView, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class q implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        q(OrderDetailNewActivity orderDetailNewActivity) {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1238272408")) {
                ipChange.ipc$dispatch("-1238272408", new Object[]{this, dVar});
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class r implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;

        r() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "980220413")) {
                ipChange.ipc$dispatch("980220413", new Object[]{this, eVar});
            } else if (eVar == null || eVar.a == null) {
            } else {
                try {
                    if (ir1.i(mr1.STORAGE)) {
                        Bitmap drawableToBitmap = OrderDetailNewActivity.this.drawableToBitmap(eVar.a);
                        OrderDetailNewActivity orderDetailNewActivity = OrderDetailNewActivity.this;
                        orderDetailNewActivity.sharebitmap = j11.d(orderDetailNewActivity.mImageUrl, drawableToBitmap, OrderDetailNewActivity.this.mContext);
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class s implements OnRefreshListener {
        private static transient /* synthetic */ IpChange $ipChange;

        s() {
        }

        @Override // cn.damai.baseview.abcpullrefresh.library.listeners.OnRefreshListener
        public void onRefreshStarted(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-647417638")) {
                ipChange.ipc$dispatch("-647417638", new Object[]{this, view});
                return;
            }
            OrderDetailNewActivity orderDetailNewActivity = OrderDetailNewActivity.this;
            orderDetailNewActivity.times = 0;
            orderDetailNewActivity.cancelTimer();
            OrderDetailNewActivity.this.requestOrderDetail();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class t implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        t() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-815362065")) {
                ipChange.ipc$dispatch("-815362065", new Object[]{this, view});
            } else {
                AliMeUtil.k(OrderDetailNewActivity.this, AliMeUtil.FROM_ORDER_DETAILS);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class u implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        u() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            OrderDetailInvoice orderDetailInvoice;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1295928304")) {
                ipChange.ipc$dispatch("1295928304", new Object[]{this, view});
            } else if (OrderDetailNewActivity.this.mOrderDetail == null || (orderDetailInvoice = OrderDetailNewActivity.this.mOrderDetail.invoice) == null) {
            } else {
                if ("1".equals(orderDetailInvoice.invoicesType)) {
                    Intent intent = new Intent(OrderDetailNewActivity.this, OrderInvoiceActivity.class);
                    intent.putExtra("orderId", OrderDetailNewActivity.this.orderId);
                    intent.putExtra("projectId", String.valueOf(OrderDetailNewActivity.this.mOrderDetail.ProjectID));
                    OrderDetailNewActivity.this.startActivityForResult(intent, 8008);
                } else if ("2".equals(orderDetailInvoice.invoicesType)) {
                    Intent intent2 = new Intent(OrderDetailNewActivity.this, OrderInvoiceDetailActivity.class);
                    intent2.putExtra("orderId", OrderDetailNewActivity.this.orderId);
                    OrderDetailNewActivity.this.startActivity(intent2);
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class v implements ViewTreeObserver.OnPreDrawListener {
        private static transient /* synthetic */ IpChange $ipChange;

        v() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1439064294")) {
                return ((Boolean) ipChange.ipc$dispatch("1439064294", new Object[]{this})).booleanValue();
            }
            OrderDetailNewActivity.height = OrderDetailNewActivity.this.take_photo_view.getMeasuredHeight();
            OrderDetailNewActivity.width = OrderDetailNewActivity.this.take_photo_view.getMeasuredWidth();
            return true;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class w implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        w() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1223541746")) {
                ipChange.ipc$dispatch("1223541746", new Object[]{this, view});
            } else {
                mo1.i(OrderDetailNewActivity.this);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class x implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        x() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-574030341")) {
                ipChange.ipc$dispatch("-574030341", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            dialogInterface.dismiss();
            OrderDetailNewActivity.this.requestOrderCancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelTimer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-820773743")) {
            ipChange.ipc$dispatch("-820773743", new Object[]{this});
            return;
        }
        this.isUsing = false;
        Thread thread = this.t;
        if (thread != null) {
            thread.interrupt();
            this.t = null;
        }
        Timer timer = this.timer;
        if (timer == null || this.timerTask == null) {
            return;
        }
        timer.cancel();
        this.timer = null;
        this.timerTask.cancel();
        this.timerTask = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changePayMethodState(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1906833805")) {
            ipChange.ipc$dispatch("1906833805", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        for (int i3 = 0; i3 < this.ll_pay_method.getChildCount(); i3++) {
            View childAt = this.ll_pay_method.getChildAt(i3);
            ImageView imageView = (ImageView) childAt.findViewById(R$id.ivSelectedPayMethod);
            if (((PayInfo) childAt.getTag()).payId == i2) {
                imageView.setEnabled(false);
            } else {
                imageView.setEnabled(true);
            }
        }
    }

    private void fillBtn() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1816485789")) {
            ipChange.ipc$dispatch("-1816485789", new Object[]{this});
            return;
        }
        OrderDetail orderDetail = this.mOrderDetail;
        if (orderDetail != null) {
            if (orderDetail.ShowReimbursementButton) {
                this.ll_btn.setVisibility(0);
                this.ll_ok_cancel.setVisibility(8);
                this.ll_ok_replenishment.setVisibility(0);
                if (!TextUtils.isEmpty(this.mOrderDetail.ReimbursementAmount)) {
                    this.tv_replenishment.setText(this.mOrderDetail.ReimbursementAmount);
                }
                this.ll_ok_replenishment.setOnClickListener(new h());
                return;
            }
            if (!orderDetail.C && !orderDetail.P) {
                this.ll_btn.setVisibility(8);
            } else {
                this.ll_btn.setVisibility(0);
                this.ll_ok_cancel.setVisibility(0);
                this.ll_ok_replenishment.setVisibility(8);
            }
            if (this.mOrderDetail.C) {
                this.btn_cancel.setVisibility(0);
            } else {
                this.btn_cancel.setVisibility(8);
            }
            if (this.mOrderDetail.P) {
                this.btn_submit.setVisibility(0);
            } else {
                this.btn_submit.setVisibility(8);
            }
            OrderDetail orderDetail2 = this.mOrderDetail;
            if (orderDetail2.C && orderDetail2.P) {
                this.btn_submit.setBackgroundColor(ContextCompat.getColor(this, R$color.main_color));
            } else if (orderDetail2.P) {
                this.btn_submit.setBackgroundResource(R$drawable.trade_order_bottom_button_bg);
            }
            if (this.hasNoPayMethod) {
                this.btn_submit.setVisibility(8);
            }
            this.btn_cancel.setOnClickListener(new j());
            this.btn_submit.setText(cm2.b(this, R$string.damai_cinemaorder_confirm_payment));
            this.btn_submit.setOnClickListener(new k());
            if (this.mOrderDetail.isShowEticket) {
                this.ll_btn.setVisibility(0);
                this.btn_cancel.setVisibility(8);
                this.btn_submit.setVisibility(0);
                this.btn_submit.setBackgroundResource(R$drawable.trade_order_bottom_button_bg);
                this.btn_submit.setText("查看票夹");
                this.btn_submit.setOnClickListener(new l());
            }
        }
    }

    private void fillDeliveryData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-576108691")) {
            ipChange.ipc$dispatch("-576108691", new Object[]{this});
        } else if (this.mOrderDetail != null) {
            this.deliver_descript_text.setVisibility(8);
            this.mBtnModifyAddress.setVisibility(this.mOrderDetail.isAddress ? 0 : 8);
            Drawable drawable = getResources().getDrawable(R$drawable.dd_express_pic);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            Drawable drawable2 = getResources().getDrawable(R$drawable.dd_code_pic);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            Drawable drawable3 = getResources().getDrawable(R$drawable.dd_deliver_pic);
            drawable3.setBounds(0, 0, drawable3.getIntrinsicWidth(), drawable3.getIntrinsicHeight());
            Drawable drawable4 = getResources().getDrawable(R$drawable.dd_id_pic);
            drawable4.setBounds(0, 0, drawable4.getIntrinsicWidth(), drawable4.getIntrinsicHeight());
            String str = this.mOrderDetail.DeliveryMethod;
            if (TextUtils.isEmpty(str)) {
                str = "";
            } else if (str.contains(jn1.BRACKET_START_STR)) {
                str = str.substring(0, str.indexOf(jn1.BRACKET_START_STR));
            }
            switch (this.mOrderDetail.DeliveryMethodId) {
                case 1:
                case 2:
                case 3:
                    if (TextUtils.isEmpty(str)) {
                        this.deliver_method_text.setText(cm2.b(this, R$string.damai_orderdetailnew_express));
                    } else {
                        this.deliver_method_text.setText(str);
                    }
                    this.iv_deliverway_icon.setImageResource(R$drawable.order_confirmation_kuaidi_normal);
                    this.deliver_name_text.setText("收货人：" + this.mOrderDetail.UserName);
                    this.deliver_phone_text.setText("电话：" + this.mOrderDetail.Mobilephone);
                    this.deliver_address_text.setText(cm2.c(this, R$string.damai_orderdetailnew_receiving_address, this.mOrderDetail.FullAdd));
                    break;
                case 4:
                    if (TextUtils.isEmpty(str)) {
                        this.deliver_method_text.setText(cm2.b(this, R$string.damai_orderdetailnew_door_self));
                    } else {
                        this.deliver_method_text.setText(str);
                    }
                    this.iv_deliverway_icon.setImageResource(R$drawable.order_confirmation_ziqu_normal);
                    this.deliver_name_text.setText(this.mOrderDetail.UserName);
                    this.deliver_phone_text.setText(this.mOrderDetail.Mobilephone);
                    String str2 = "";
                    if (this.mOrderDetail.CompanyAddr != null) {
                        for (int i2 = 0; i2 < this.mOrderDetail.CompanyAddr.size(); i2++) {
                            str2 = i2 != this.mOrderDetail.CompanyAddr.size() - 1 ? str2 + this.mOrderDetail.CompanyAddr.get(i2) + StringUtils.LF : str2 + this.mOrderDetail.CompanyAddr.get(i2);
                        }
                    }
                    this.deliver_address_text.setText("");
                    this.deliver_descript_text.setText(str2);
                    this.deliver_descript_text.setVisibility(0);
                    break;
                case 5:
                case 6:
                case 7:
                case 8:
                case 10:
                    if (TextUtils.isEmpty(str)) {
                        this.deliver_method_text.setText(cm2.b(this, R$string.damai_ticket_electronic_ticket));
                    } else {
                        this.deliver_method_text.setText(str);
                    }
                    this.iv_deliverway_icon.setImageResource(R$drawable.order_confirmation_dianzipiao_normal);
                    this.deliver_name_text.setText("");
                    this.deliver_phone_text.setText(this.mOrderDetail.Mobilephone);
                    this.deliver_address_text.setText(this.mOrderDetail.FullAdd);
                    break;
                case 9:
                    if (TextUtils.isEmpty(str)) {
                        this.deliver_method_text.setText(cm2.b(this, R$string.damai_orderdetailnew_id_ticket));
                    } else {
                        this.deliver_method_text.setText(str);
                    }
                    this.iv_deliverway_icon.setImageResource(R$drawable.order_confirmation_shenfenzheng_normal);
                    this.deliver_name_text.setText(this.mOrderDetail.UserName);
                    this.deliver_phone_text.setText(this.mOrderDetail.Mobilephone);
                    this.deliver_address_text.setText(this.mOrderDetail.FullAdd);
                    break;
                default:
                    if (TextUtils.isEmpty(str)) {
                        this.deliver_method_text.setText(cm2.b(this, R$string.damai_orderdetailnew_express));
                    } else {
                        this.deliver_method_text.setText(str);
                    }
                    this.iv_deliverway_icon.setImageResource(R$drawable.order_confirmation_kuaidi_normal);
                    this.deliver_name_text.setText(this.mOrderDetail.UserName);
                    this.deliver_phone_text.setText(this.mOrderDetail.Mobilephone);
                    this.deliver_address_text.setText(cm2.c(this, R$string.damai_orderdetailnew_receiving_address, this.mOrderDetail.FullAdd));
                    break;
            }
            if (!TextUtils.isEmpty(this.deliver_name_text.getText().toString()) && TextUtils.isEmpty(this.deliver_address_text.getText().toString())) {
                this.deliver_address_text.setText(this.deliver_phone_text.getText().toString());
                this.deliver_phone_text.setText("");
            }
            if (!TextUtils.isEmpty(this.mOrderDetail.UserEmail)) {
                this.deliver_email_text.setText(this.mOrderDetail.UserEmail);
                this.deliver_email_text.setVisibility(0);
            } else {
                this.deliver_email_text.setVisibility(8);
            }
            setYPYZView();
        }
    }

    private void fillOrderInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1862393379")) {
            ipChange.ipc$dispatch("1862393379", new Object[]{this});
        } else if (this.mOrderDetail != null) {
            if (this.iv_header_right_icon != null) {
                if (isShowTitleShareImg()) {
                    this.iv_header_right_icon.setVisibility(0);
                } else {
                    this.iv_header_right_icon.setVisibility(8);
                }
            }
            try {
                String a2 = so1.a(this, this.mOrderDetail.NewOrderStatus);
                if (!TextUtils.isEmpty(a2)) {
                    this.status_text.setTextColor(Color.parseColor(a2));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.status_text.setText(this.mOrderDetail.NewOrderStatus);
            String str = this.mOrderDetail.CreateTimeString;
            if (str != null) {
                this.createtime_text.setText(str.substring(0, str.lastIndexOf(":")));
            }
            TextView textView = this.orderno_text;
            textView.setText(this.mOrderDetail.ServerOrderID + "");
            this.projectname_text.setText(this.mOrderDetail.ProjectName);
            DMImageCreator c2 = cn.damai.common.image.a.b().c(getCustomWidthAndHeightImageAddress(getProjectIdImage(this.mOrderDetail.ProjectID), 134, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_IS_AudioMode));
            int i2 = R$drawable.uikit_default_image_bg_gradient;
            c2.i(i2).c(i2).g(this.project_image);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0160 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void fillPayMethod() {
        /*
            Method dump skipped, instructions count: 478
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.trade.oldtradeorder.ui.orderdetail.detail.activity.OrderDetailNewActivity.fillPayMethod():void");
    }

    private void fillProjectInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-281467528")) {
            ipChange.ipc$dispatch("-281467528", new Object[]{this});
            return;
        }
        OrderDetail orderDetail = this.mOrderDetail;
        if (orderDetail != null) {
            List<SeatItem> list = orderDetail.seatList;
            if (list != null && list.size() > 0) {
                this.seatMoreView.clear();
                this.seat_add_view.removeAllViews();
                List<YPYZInfo> list2 = this.mOrderDetail.Audiences;
                if (list2 == null || list2.isEmpty()) {
                    for (int i2 = 0; i2 < this.mOrderDetail.seatList.size(); i2++) {
                        View inflate = this.mInflater.inflate(R$layout.order_detail_new_buy_seat_item, (ViewGroup) null);
                        TextView textView = (TextView) inflate.findViewById(R$id.tv_seat_name);
                        TextView textView2 = (TextView) inflate.findViewById(R$id.tv_area_name);
                        SeatItem seatItem = this.mOrderDetail.seatList.get(i2);
                        ((TextView) inflate.findViewById(R$id.tv_price)).setText("" + getPriceString(seatItem.seatPrice));
                        String str = seatItem.area;
                        if (str != null && !str.equals("")) {
                            textView2.setVisibility(0);
                            textView2.setText(seatItem.area);
                        } else {
                            textView2.setVisibility(8);
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("");
                        sb.append(wh2.j(seatItem.seatNo) ? cm2.b(this, R$string.damai_orderdetailnew_no_seat) : seatItem.seatNo);
                        String replaceAll = sb.toString().replaceAll(" ", "");
                        replaceAll.trim();
                        textView.setText(replaceAll);
                        this.seat_add_view.addView(inflate, new LinearLayout.LayoutParams(-1, -2));
                        if (i2 > 1) {
                            this.seatMoreView.add(inflate);
                        }
                    }
                }
                TextView textView3 = this.num_ticket_text;
                textView3.setText(this.mOrderDetail.Quantity + "");
            } else {
                TextView textView4 = this.num_ticket_text;
                textView4.setText(this.mOrderDetail.Quantity + "");
                this.has_seat_line_view.setVisibility(8);
            }
            if (this.seatMoreView.size() > 0) {
                this.show_more_seat_view.setVisibility(0);
                ((ImageView) findViewById(R$id.seat_image_btn)).setImageResource(R$drawable.dd_more1_pic);
                this.show_more_seat_view.setOnClickListener(new e());
            } else {
                this.show_more_seat_view.setVisibility(8);
            }
            this.price_ticket_text.setVisibility(0);
            TextView textView5 = this.price_ticket_text;
            StringBuilder sb2 = new StringBuilder();
            OrderDetail orderDetail2 = this.mOrderDetail;
            sb2.append(wh2.o(orderDetail2.Amount - orderDetail2.DeliveryPrice));
            sb2.append("");
            textView5.setText(sb2.toString());
            double d2 = this.mOrderDetail.DeliveryPrice;
        }
    }

    private void fillPushDelivery() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-15482371")) {
            ipChange.ipc$dispatch("-15482371", new Object[]{this});
            return;
        }
        OrderDetail orderDetail = this.mOrderDetail;
        if (orderDetail == null) {
            return;
        }
        if (TextUtils.isEmpty(so1.b(orderDetail.serviceReminder))) {
            this.mPushDeliveryTipLayout.setVisibility(8);
            return;
        }
        this.mPushDeliveryTipTv.setText(this.mOrderDetail.serviceReminder);
        this.mPushDeliveryTipLayout.setVisibility(0);
    }

    private void fillTipContent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-536561843")) {
            ipChange.ipc$dispatch("-536561843", new Object[]{this});
            return;
        }
        OrderDetail orderDetail = this.mOrderDetail;
        if (orderDetail != null && orderDetail.IsPayTime) {
            View inflate = this.mInflater.inflate(R$layout.order_detail_content_tip_time, (ViewGroup) null);
            this.tv_minute_0 = (TextView) inflate.findViewById(R$id.tv_minute_0);
            this.tv_minute_1 = (TextView) inflate.findViewById(R$id.tv_minute_1);
            this.tv_second_0 = (TextView) inflate.findViewById(R$id.tv_second_0);
            this.tv_second_1 = (TextView) inflate.findViewById(R$id.tv_second_1);
            this.tv_time_message = (TextView) inflate.findViewById(R$id.tv_time_message);
            this.ll_tip.setVisibility(0);
            this.ll_tip.removeAllViews();
            this.ll_tip.addView(inflate, new LinearLayout.LayoutParams(-1, -2));
            this.tv_time_message.setText(this.mOrderDetail.PayTimeMessage);
        } else if (orderDetail != null && orderDetail.isShowSerialNumber) {
            View inflate2 = this.mInflater.inflate(R$layout.order_detail_content_tip_num, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) inflate2.findViewById(R$id.paihao_num);
            TextView textView = (TextView) inflate2.findViewById(R$id.choose_seat_starttime);
            TextView textView2 = (TextView) inflate2.findViewById(R$id.timetext);
            TextView textView3 = (TextView) inflate2.findViewById(R$id.status_text);
            this.timeView = inflate2.findViewById(R$id.time_view);
            this.tv_line_tip = (TextView) inflate2.findViewById(R$id.tv_line_tip);
            View findViewById = inflate2.findViewById(R$id.show_time_text);
            this.dayText = (TextView) inflate2.findViewById(R$id.day_text);
            this.hourText = (TextView) inflate2.findViewById(R$id.hour_text);
            this.minText = (TextView) inflate2.findViewById(R$id.min_text);
            this.secondText = (TextView) inflate2.findViewById(R$id.second_text);
            this.choose_zuowei_view = inflate2.findViewById(R$id.choose_zuowei_view);
            this.choose_zuowei_btn = (Button) inflate2.findViewById(R$id.choose_zuowei_btn);
            this.ll_tip.setVisibility(0);
            this.ll_tip.removeAllViews();
            this.ll_tip.addView(inflate2, new LinearLayout.LayoutParams(-1, -2));
            String str = this.mOrderDetail.SerialNumber;
            String substring = str.substring(0, str.length() - 1);
            linearLayout.removeAllViews();
            int i2 = 0;
            while (i2 < substring.length()) {
                int i3 = i2 + 1;
                int parseInt = Integer.parseInt(substring.substring(i2, i3));
                ImageView imageView = new ImageView(this);
                imageView.setBackgroundDrawable(this.drawableArray[parseInt]);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.setMargins(5, 5, 5, 5);
                imageView.setLayoutParams(layoutParams);
                linearLayout.addView(imageView);
                i2 = i3;
            }
            if (this.mOrderDetail.jinPai == null) {
                textView.setText(cm2.b(this, R$string.damai_orderdetailnew_waiting_packets));
                return;
            }
            textView.setText(cm2.b(this, R$string.damai_orderdetailnew_choose_seat_numbers));
            OrderDetail orderDetail2 = this.mOrderDetail;
            if (orderDetail2.jinPai.status) {
                this.timeView.setVisibility(8);
                this.tv_line_tip.setVisibility(8);
                this.choose_zuowei_view.setVisibility(8);
                return;
            }
            int i4 = orderDetail2.jinPaiStatus;
            if (i4 == 0) {
                this.timeView.setVisibility(8);
                this.choose_zuowei_view.setVisibility(8);
            } else if (i4 == 1) {
                this.choose_zuowei_view.setVisibility(8);
                this.timeView.setVisibility(0);
                this.tv_line_tip.setVisibility(0);
                findViewById.setVisibility(8);
                textView2.setVisibility(8);
                textView3.setVisibility(0);
                textView3.setText(cm2.b(this, R$string.damai_orderdetailnew_waiting_packets));
            } else if (i4 != 2) {
                if (i4 == 3) {
                    this.timeView.setVisibility(8);
                    this.tv_line_tip.setVisibility(8);
                    this.choose_zuowei_view.setVisibility(0);
                    this.choose_zuowei_btn.setOnClickListener(new c(this));
                } else if (i4 == 4) {
                    this.choose_zuowei_view.setVisibility(8);
                    this.timeView.setVisibility(0);
                    this.tv_line_tip.setVisibility(0);
                    findViewById.setVisibility(8);
                    textView2.setVisibility(8);
                    textView3.setVisibility(0);
                    textView3.setText(cm2.b(this, R$string.damai_orderdetailnew_grab_seat_over));
                } else if (i4 != 5) {
                } else {
                    this.choose_zuowei_view.setVisibility(8);
                    this.timeView.setVisibility(0);
                    this.tv_line_tip.setVisibility(0);
                    findViewById.setVisibility(8);
                    textView2.setVisibility(8);
                    textView3.setVisibility(0);
                    textView3.setText(cm2.b(this, R$string.damai_orderdetailnew_grab_seat_over));
                }
            } else {
                this.choose_zuowei_view.setVisibility(8);
                this.timeView.setVisibility(0);
                this.tv_line_tip.setVisibility(0);
                findViewById.setVisibility(0);
                textView2.setVisibility(0);
                textView3.setVisibility(8);
                this.timeText = textView2;
                jinPai jinpai = this.mOrderDetail.jinPai;
                String str2 = jinpai.startTime;
                this.startTimeString = str2;
                this.nowTimeString = jinpai.nowTime;
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(this.nowTimeString)) {
                    try {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        if (simpleDateFormat.parse(this.startTimeString).getTime() - simpleDateFormat.parse(this.nowTimeString).getTime() > 0) {
                            this.isUsing = false;
                            Thread thread = this.t;
                            if (thread != null) {
                                thread.interrupt();
                                this.t = null;
                            }
                            startTimeThread();
                            return;
                        }
                        clearTimeText();
                        return;
                    } catch (ParseException e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                clearTimeText();
            }
        } else {
            this.ll_tip.setVisibility(8);
        }
    }

    private void fillTrace() {
        List<TrackInfo> list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1623707226")) {
            ipChange.ipc$dispatch("1623707226", new Object[]{this});
            return;
        }
        OrderDetail orderDetail = this.mOrderDetail;
        if (orderDetail != null && (list = orderDetail.TrackInfo) != null && list.size() > 0) {
            this.ll_trace_info.removeAllViews();
            for (int size = this.mOrderDetail.TrackInfo.size() - 1; size > -1; size--) {
                View inflate = this.mInflater.inflate(R$layout.order_detail_trace_item, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R$id.tv_day);
                TextView textView2 = (TextView) inflate.findViewById(R$id.tv_week);
                TextView textView3 = (TextView) inflate.findViewById(R$id.tv_time);
                TextView textView4 = (TextView) inflate.findViewById(R$id.tv_trace_detail);
                ImageView imageView = (ImageView) inflate.findViewById(R$id.iv_trace_flow_icon);
                TrackInfo trackInfo = this.mOrderDetail.TrackInfo.get(size);
                textView4.setText(trackInfo.Info);
                String str = trackInfo.Time;
                textView.setText(getDay(str));
                textView2.setText(getWeekday(str));
                textView3.setText(getDate(str));
                if (size == this.mOrderDetail.TrackInfo.size() - 1) {
                    imageView.setBackgroundResource(R$drawable.or_flow_icon);
                    textView.setTextColor(-8404632);
                    textView2.setTextColor(-8404632);
                    textView3.setTextColor(-8404632);
                    textView4.setTextColor(-8404632);
                }
                this.ll_trace_info.addView(inflate, new LinearLayout.LayoutParams(-1, -2));
            }
            this.ll_trace.setVisibility(0);
            return;
        }
        this.ll_trace.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1248238636")) {
            ipChange.ipc$dispatch("1248238636", new Object[]{this});
            return;
        }
        int i2 = this.mFromPage;
        if (i2 == 0) {
            OrderListActivity.mFromWhere = "damai";
            Intent intent = new Intent();
            intent.putExtra("refresh", true);
            setResult(-1, intent);
            finish();
        } else if (i2 == 1) {
            DMNav.from(this).toUri(NavUri.b(cs.n));
            finish();
        } else if (i2 != 2) {
            OrderListActivity.mFromWhere = "damai";
            Intent intent2 = new Intent();
            intent2.putExtra("refresh", true);
            setResult(-1, intent2);
            finish();
        } else {
            finish();
        }
    }

    private void flushAdapter(List<SuperTickt> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2020791764")) {
            ipChange.ipc$dispatch("2020791764", new Object[]{this, list});
            return;
        }
        SuperTicketAdapter superTicketAdapter = this.superTicketAdapter;
        if (superTicketAdapter == null) {
            SuperTicketAdapter superTicketAdapter2 = new SuperTicketAdapter(this.mInflater, list);
            this.superTicketAdapter = superTicketAdapter2;
            this.order_new_detail_listview.setAdapter((ListAdapter) superTicketAdapter2);
            return;
        }
        superTicketAdapter.setSuperTicktList(list);
        this.superTicketAdapter.notifyDataSetChanged();
    }

    private String getCustomWidthAndHeightImageAddress(String str, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-565716974")) {
            return (String) ipChange.ipc$dispatch("-565716974", new Object[]{this, str, Integer.valueOf(i2), Integer.valueOf(i3)});
        }
        if (str == null || !URI.create(str).getHost().contains(DamaiDataAccessApi.PROJECT_IMG_DOMAIN)) {
            return "https://mapi.damai.cn/pic.aspx?url=" + str + "&w=" + i2 + "&h=" + i3;
        }
        return str;
    }

    private String getDate(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "44256990")) {
            return (String) ipChange.ipc$dispatch("44256990", new Object[]{this, str});
        }
        if (wh2.j(str)) {
            return "";
        }
        try {
            return new SimpleDateFormat("yyyy-MM HH:mm:ss").format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str));
        } catch (ParseException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private String getDay(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "660159502")) {
            return (String) ipChange.ipc$dispatch("660159502", new Object[]{this, str});
        }
        if (wh2.j(str)) {
            return "";
        }
        try {
            return new SimpleDateFormat("d").format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str));
        } catch (ParseException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private String getProjectIdImage(long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-945158405")) {
            return (String) ipChange.ipc$dispatch("-945158405", new Object[]{this, Long.valueOf(j2)});
        }
        return "https://ossali.damai.cn/perform/project/" + (j2 / 100) + "/" + j2 + "_n.jpg";
    }

    private String getWeekday(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1485127194")) {
            return (String) ipChange.ipc$dispatch("1485127194", new Object[]{this, str});
        }
        if (wh2.j(str)) {
            return "";
        }
        try {
            return new SimpleDateFormat(ExifInterface.LONGITUDE_EAST).format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str));
        } catch (ParseException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private void initData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "868328404")) {
            ipChange.ipc$dispatch("868328404", new Object[]{this});
        } else if (getIntent() == null) {
        } else {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                if (extras.containsKey(DamaiConstants.PUSH_MSG_SUMMARY)) {
                    this.mFromPage = 1;
                    this.orderId = extras.getString(DamaiConstants.PUSH_MSG_SUMMARY);
                } else if (extras.containsKey("backPage")) {
                    this.mFromPage = 2;
                    this.orderId = extras.getString("orderId", "");
                } else {
                    this.orderId = extras.getString("orderId");
                    if (extras.containsKey("projectId")) {
                        this.projectId = extras.getString("projectId");
                    }
                }
            }
            if (wh2.j(this.orderId)) {
                toast("order id is null");
                finish();
            }
        }
    }

    private void initPushDelivery(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1046380542")) {
            ipChange.ipc$dispatch("-1046380542", new Object[]{this, view});
            return;
        }
        this.mPushDeliveryTipLayout = (LinearLayout) view.findViewById(R$id.ll_delivery_tip);
        this.mPushDeliveryTipTv = (TextView) view.findViewById(R$id.tv_delivery_tip);
        this.mPushDeliveryTipLayout.setVisibility(8);
    }

    private boolean isShowTitleShareImg() {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1691703189")) {
            return ((Boolean) ipChange.ipc$dispatch("-1691703189", new Object[]{this})).booleanValue();
        }
        OrderDetail orderDetail = this.mOrderDetail;
        return (orderDetail == null || (str = orderDetail.OrderStatus) == null || (!str.equals("订单完成") && !str.equals("已发货") && !str.equals("已打包，准备配送") && !str.equals("等待自取") && !str.equals("电子票已生效") && !str.equals("预订已生效") && !str.equals("已付款，客服处理中") && !str.equals("已付款，客服已处理") && !str.equals("已付款，项目未开票") && !str.equals("已配送") && !str.equals("已出库"))) ? false : true;
    }

    private void jumpIntoWayPage(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-469224352")) {
            ipChange.ipc$dispatch("-469224352", new Object[]{this, str, str2});
        } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
        } else {
            Intent intent = new Intent(this.mContext, WapPayActivity.class);
            intent.putExtra("wappay_url", str);
            intent.putExtra("type", str2);
            intent.putExtra("orderid", this.orderId);
            startActivityForResult(intent, 2000);
        }
    }

    private void jumpModifyAddress(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1922742810")) {
            ipChange.ipc$dispatch("1922742810", new Object[]{this, str});
            return;
        }
        String str2 = this.orderId;
        OrderDetail orderDetail = this.mOrderDetail;
        mo1.e(this, str2, orderDetail != null ? String.valueOf(orderDetail.ProjectID) : this.projectId, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadPayResult(OrderParmasResult orderParmasResult) {
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1169259168")) {
            ipChange.ipc$dispatch("1169259168", new Object[]{this, orderParmasResult});
            return;
        }
        stopProgressDialog();
        OrderListActivity.mFromWhere = "damai";
        if (orderParmasResult == null || (i2 = orderParmasResult.payId) == 0) {
            if (orderParmasResult != null) {
                toast(orderParmasResult.error);
                return;
            } else {
                toast("");
                return;
            }
        }
        switch (i2) {
            case 2:
                Intent intent = new Intent(this.mContext, AliPayActivity.class);
                intent.putExtra("alipay_param", orderParmasResult.payParm);
                intent.putExtra("orderid", this.orderId);
                startActivityForResult(intent, 2000);
                return;
            case 3:
                jumpIntoWayPage(orderParmasResult.payParm, WapPayActivity.TYPE_ZHIFUBAO);
                return;
            case 4:
            case 6:
            case 7:
            case 10:
            case 11:
            case 14:
            case 16:
            case 18:
            case 20:
            case 23:
            case 28:
            default:
                return;
            case 5:
                Intent intent2 = new Intent(this.mContext, DamaiWXPayActivity.class);
                intent2.putExtra("orderId", this.orderId);
                intent2.putExtra("PayParm", orderParmasResult.payParm);
                intent2.putExtra("from", "OrderDetailPage");
                startActivityForResult(intent2, 2000);
                return;
            case 8:
                Intent intent3 = new Intent(this.mContext, UnionPayActivity.class);
                intent3.putExtra("uninpay_param", orderParmasResult.payParm);
                intent3.putExtra("orderid", this.orderId);
                startActivityForResult(intent3, 2000);
                return;
            case 9:
                jumpIntoWayPage(orderParmasResult.payParm, WapPayActivity.TYPE_WALLET);
                return;
            case 12:
                jumpIntoWayPage(orderParmasResult.payParm, WapPayActivity.TYPE_CHINA_BANK);
                return;
            case 13:
                jumpIntoWayPage(orderParmasResult.payParm, WapPayActivity.TYPE_PUFA_BANK);
                return;
            case 15:
                jumpIntoWayPage(orderParmasResult.payParm, WapPayActivity.TYPE_ICBC_BANK);
                return;
            case 17:
                jumpIntoWayPage(orderParmasResult.payParm, WapPayActivity.TYPE_JD_PAY);
                return;
            case 19:
                jumpIntoWayPage(orderParmasResult.payParm, WapPayActivity.TYPE_UNION_BANK);
                return;
            case 21:
                jumpIntoWayPage(orderParmasResult.payParm, WapPayActivity.TYPE_PINGAN_BANK);
                return;
            case 22:
                jumpIntoWayPage(orderParmasResult.payParm, WapPayActivity.TYPE_JCB_BANK);
                return;
            case 24:
                jumpIntoWayPage(orderParmasResult.payParm, WapPayActivity.TYPE_PUFA_CARD_BANK);
                return;
            case 25:
                jumpIntoWayPage(orderParmasResult.payParm, WapPayActivity.TYPE_GUANGFA_CARD_BANK);
                return;
            case 26:
                jumpIntoWayPage(orderParmasResult.payParm, WapPayActivity.TYPE_AE_CARD);
                return;
            case 27:
                jumpIntoWayPage(orderParmasResult.payParm, WapPayActivity.TYPE_ANT_CHECK_LATER);
                return;
            case 29:
                jumpIntoWayPage(orderParmasResult.payParm, WapPayActivity.TYPE_GUANGDA_CARD_BANK);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPaySubmit() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-24613381")) {
            ipChange.ipc$dispatch("-24613381", new Object[]{this});
            return;
        }
        PayInfo payInfo = this.mPayInfo;
        if (payInfo == null) {
            return;
        }
        int i2 = payInfo.payId;
        if (i2 == 2) {
            getPayParmas(i2);
        } else if (i2 == 3) {
            getPayParmas(i2);
        } else if (i2 == 5) {
            getPayParmas(i2);
        } else if (i2 == 8) {
            getPayParmas(i2);
        } else if (i2 == 9) {
            getPayParmas(i2);
        } else if (i2 == 12) {
            getPayParmas(i2);
        } else if (i2 == 13) {
            getPayParmas(i2);
        } else if (i2 == 15) {
            getICBCPayParmas(i2);
        } else if (i2 == 17) {
            getPayParmas(i2);
        } else if (i2 == 19) {
            getPayParmas(i2);
        } else if (i2 == 21) {
            getPayParmas(i2);
        } else if (i2 == 22) {
            getPayParmas(i2);
        } else if (i2 == 24) {
            getPayParmas(i2);
        } else if (i2 == 25) {
            getPayParmas(i2);
        } else if (i2 == 26) {
            getPayParmas(i2);
        } else if (i2 == 27) {
            getPayParmas(i2);
        } else if (i2 == 29) {
            getPayParmas(i2);
        } else if (i2 == 1) {
            DMDialog dMDialog = new DMDialog(this);
            dMDialog.v(cm2.b(this, R$string.damai_orderdetailnew_reminder));
            dMDialog.q(cm2.b(this, R$string.damai_orderdetailnew_select_reminder));
            dMDialog.n(cm2.b(this, R$string.damai_orderdetailnew_view_orders), new m());
            dMDialog.show();
        }
    }

    private void requestData(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1941368083")) {
            ipChange.ipc$dispatch("-1941368083", new Object[]{this, str});
            return;
        }
        ZLOrderDetailOtherRequest zLOrderDetailOtherRequest = new ZLOrderDetailOtherRequest();
        zLOrderDetailOtherRequest.orderid = str;
        zLOrderDetailOtherRequest.request(new DMMtopResultRequestListener<OrderredBox>(OrderredBox.class) { // from class: cn.damai.trade.oldtradeorder.ui.orderdetail.detail.activity.OrderDetailNewActivity.29
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener
            public void onFail(String str2, String str3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "152034950")) {
                    ipChange2.ipc$dispatch("152034950", new Object[]{this, str2, str3});
                } else {
                    ToastUtil.a().g(OrderDetailNewActivity.this);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener
            public void onSuccess(OrderredBox orderredBox) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "2046582203")) {
                    ipChange2.ipc$dispatch("2046582203", new Object[]{this, orderredBox});
                } else {
                    OrderDetailNewActivity.this.onOk(orderredBox);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestOrderCancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-828434507")) {
            ipChange.ipc$dispatch("-828434507", new Object[]{this});
            return;
        }
        startProgressDialog();
        ZLOrderDetailCancelRequest zLOrderDetailCancelRequest = new ZLOrderDetailCancelRequest();
        zLOrderDetailCancelRequest.id = this.orderId;
        zLOrderDetailCancelRequest.request(new DMMtopResultRequestListener<OrderCancelResult>(OrderCancelResult.class) { // from class: cn.damai.trade.oldtradeorder.ui.orderdetail.detail.activity.OrderDetailNewActivity.23
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "198591104")) {
                    ipChange2.ipc$dispatch("198591104", new Object[]{this, str, str2});
                    return;
                }
                OrderDetailNewActivity.this.stopProgressDialog();
                OrderDetailNewActivity.this.toast(str2);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener
            public void onSuccess(OrderCancelResult orderCancelResult) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-730011964")) {
                    ipChange2.ipc$dispatch("-730011964", new Object[]{this, orderCancelResult});
                    return;
                }
                OrderDetailNewActivity.this.stopProgressDialog();
                if (orderCancelResult != null) {
                    if (orderCancelResult.s) {
                        OrderDetailNewActivity orderDetailNewActivity = OrderDetailNewActivity.this;
                        orderDetailNewActivity.toast(cm2.b(orderDetailNewActivity, R$string.damai_cinemaorder_orders_cancel_toast));
                        OrderDetailNewActivity.this.finishActivity();
                        return;
                    }
                    onFail("", orderCancelResult.error);
                    return;
                }
                onFail("", "");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestOrderDetail() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1016875646")) {
            ipChange.ipc$dispatch("1016875646", new Object[]{this});
            return;
        }
        this.hasSetFirstWay = false;
        this.pull_down_view.setRefreshing(true);
        ZLOrderDetailRequest zLOrderDetailRequest = new ZLOrderDetailRequest();
        zLOrderDetailRequest.id = this.orderId;
        if (this.mHasModifyAddress) {
            zLOrderDetailRequest.isAddress = "true";
        } else {
            zLOrderDetailRequest.isAddress = "";
        }
        zLOrderDetailRequest.request(new DMMtopResultRequestListener<OrderDetail>(OrderDetail.class) { // from class: cn.damai.trade.oldtradeorder.ui.orderdetail.detail.activity.OrderDetailNewActivity.8
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1856977497")) {
                    ipChange2.ipc$dispatch("1856977497", new Object[]{this, str, str2});
                    return;
                }
                OrderDetailNewActivity.this.toast("");
                OrderDetailNewActivity.this.mHasModifyAddress = false;
                cg1.a(str, str2, OrderDetailNewActivity.this.orderId);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener
            public void onSuccess(OrderDetail orderDetail) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-298294343")) {
                    ipChange2.ipc$dispatch("-298294343", new Object[]{this, orderDetail});
                    return;
                }
                OrderDetailNewActivity.this.pull_down_view.setRefreshComplete();
                OrderDetailNewActivity.this.returnOrderDetailData(orderDetail);
            }
        });
    }

    private void scheduleTimer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "745018862")) {
            ipChange.ipc$dispatch("745018862", new Object[]{this});
            return;
        }
        if (this.timer == null) {
            this.timer = new Timer();
        }
        if (this.timerTask == null) {
            TimerTask timerTask = new TimerTask() { // from class: cn.damai.trade.oldtradeorder.ui.orderdetail.detail.activity.OrderDetailNewActivity.15
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1224289709")) {
                        ipChange2.ipc$dispatch("-1224289709", new Object[]{this});
                    } else {
                        OrderDetailNewActivity.this.timeHandler.sendEmptyMessage(0);
                    }
                }
            };
            this.timerTask = timerTask;
            this.timer.schedule(timerTask, 0L, 1000L);
        }
    }

    private void setModifyAddressTipDialog(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1059819333")) {
            ipChange.ipc$dispatch("-1059819333", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            DMDialog dMDialog = new DMDialog(this);
            this.mOrderAddressDialog = dMDialog;
            dMDialog.v("温馨提示");
            this.mOrderAddressDialog.q(str);
            this.mOrderAddressDialog.n("我知道了", new a());
            this.mOrderAddressDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startCouponDialog() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "686708620")) {
            ipChange.ipc$dispatch("686708620", new Object[]{this});
            return;
        }
        DMDialog dMDialog = new DMDialog(this);
        this.mCancelOrderDialog = dMDialog;
        dMDialog.v("取消订单");
        this.mCancelOrderDialog.q("订单取消后将自动关闭，确定取消?");
        this.mCancelOrderDialog.i("取消", null);
        this.mCancelOrderDialog.n("确定", new x());
        this.mCancelOrderDialog.show();
    }

    public void clearTimeText() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1582670645")) {
            ipChange.ipc$dispatch("1582670645", new Object[]{this});
            return;
        }
        this.days = "00";
        this.hours = "00";
        this.mins = "00";
        this.seconds = "00";
        this.dayText.setText("00");
        this.hourText.setText(this.hours);
        this.minText.setText(this.mins);
        this.secondText.setText(this.seconds);
        TextView textView = this.timeText;
        textView.setText(cm2.b(this, R$string.damai_orderdetailnew_grab_seat_start_time) + this.startTimeString);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1740099606")) {
            ipChange.ipc$dispatch("1740099606", new Object[]{this, Integer.valueOf(i2)});
        } else if (i2 != 10001 && i2 != 10003) {
            if ((i2 == 10004 || i2 == 10002) && isShowTitleShareImg() && this.orderredBox != null) {
                Bundle bundle = new Bundle();
                bundle.putString("title", this.orderredBox.Title);
                bundle.putString("message", this.orderredBox.Content);
                bundle.putString("imageurl", this.orderredBox.ShareImg);
                bundle.putString("producturl", this.orderredBox.Url + this.orderId);
                bundle.putString("fromWhere", "orderDetail2");
                bundle.putString("sinaSharePath", this.sharebitmap);
                ShareManager.E().O(this, bundle, R$layout.order_detail_activity);
            }
        } else {
            onBackPressed();
        }
    }

    public Bitmap drawableToBitmap(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "537676712")) {
            return (Bitmap) ipChange.ipc$dispatch("537676712", new Object[]{this, drawable});
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return createBitmap;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01e5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void fillCouponsView() {
        /*
            Method dump skipped, instructions count: 500
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.trade.oldtradeorder.ui.orderdetail.detail.activity.OrderDetailNewActivity.fillCouponsView():void");
    }

    public void fillInvoice() {
        OrderDetailInvoice orderDetailInvoice;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2008749838")) {
            ipChange.ipc$dispatch("-2008749838", new Object[]{this});
            return;
        }
        OrderDetail orderDetail = this.mOrderDetail;
        if (orderDetail == null || (orderDetailInvoice = orderDetail.invoice) == null) {
            return;
        }
        if ("1".equals(orderDetailInvoice.invoicesType)) {
            this.mAddInvoiceLayout.setVisibility(0);
            this.mAddInvoiceTipLayout.setVisibility(8);
            this.mAddInvoiceGoLayout.setVisibility(0);
            this.mAddInvoiceLayout.setEnabled(true);
        } else if ("2".equals(orderDetailInvoice.invoicesType)) {
            this.mAddInvoiceLayout.setVisibility(0);
            this.mAddInvoiceTipLayout.setVisibility(8);
            this.mAddInvoiceGoLayout.setVisibility(0);
            this.mAddInvoiceLayout.setEnabled(true);
        } else if ("3".equals(orderDetailInvoice.invoicesType)) {
            this.mAddInvoiceLayout.setVisibility(0);
            this.mAddInvoiceGoLayout.setVisibility(8);
            this.mAddInvoiceTipLayout.setVisibility(0);
            if (!TextUtils.isEmpty(orderDetailInvoice.invoinceMessage)) {
                this.mAddInvoiceTipTv.setText(orderDetailInvoice.invoinceMessage);
            } else if (!TextUtils.isEmpty(orderDetailInvoice.desc)) {
                this.mAddInvoiceTipTv.setText(orderDetailInvoice.desc);
            } else {
                this.mAddInvoiceTipTv.setText("");
            }
            this.mAddInvoiceLayout.setEnabled(false);
        } else {
            this.mAddInvoiceLayout.setVisibility(8);
        }
    }

    public void getICBCPayParmas(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1310838774")) {
            ipChange.ipc$dispatch("-1310838774", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        startProgressDialog();
        ZLOrderDetailPayRequest zLOrderDetailPayRequest = new ZLOrderDetailPayRequest();
        zLOrderDetailPayRequest.orderId = this.orderId;
        zLOrderDetailPayRequest.type = String.valueOf(i2);
        zLOrderDetailPayRequest.ext1 = "0";
        zLOrderDetailPayRequest.request(new DMMtopResultRequestListener<OrderParmasResult>(OrderParmasResult.class) { // from class: cn.damai.trade.oldtradeorder.ui.orderdetail.detail.activity.OrderDetailNewActivity.26
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "175313027")) {
                    ipChange2.ipc$dispatch("175313027", new Object[]{this, str, str2});
                    return;
                }
                OrderDetailNewActivity.this.stopProgressDialog();
                OrderDetailNewActivity.this.toast(str2);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener
            public void onSuccess(OrderParmasResult orderParmasResult) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1014966595")) {
                    ipChange2.ipc$dispatch("-1014966595", new Object[]{this, orderParmasResult});
                } else {
                    OrderDetailNewActivity.this.loadPayResult(orderParmasResult);
                }
            }
        });
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "242510868") ? ((Integer) ipChange.ipc$dispatch("242510868", new Object[]{this})).intValue() : R$layout.order_detail_activity;
    }

    public void getPayParmas(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1920489349")) {
            ipChange.ipc$dispatch("1920489349", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        startProgressDialog();
        ZLOrderDetailPayRequest zLOrderDetailPayRequest = new ZLOrderDetailPayRequest();
        zLOrderDetailPayRequest.orderId = this.orderId;
        zLOrderDetailPayRequest.type = String.valueOf(i2);
        zLOrderDetailPayRequest.request(new DMMtopResultRequestListener<OrderParmasResult>(OrderParmasResult.class) { // from class: cn.damai.trade.oldtradeorder.ui.orderdetail.detail.activity.OrderDetailNewActivity.25
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "183072386")) {
                    ipChange2.ipc$dispatch("183072386", new Object[]{this, str, str2});
                    return;
                }
                OrderDetailNewActivity.this.stopProgressDialog();
                OrderDetailNewActivity.this.toast(str2);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener
            public void onSuccess(OrderParmasResult orderParmasResult) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1000716450")) {
                    ipChange2.ipc$dispatch("-1000716450", new Object[]{this, orderParmasResult});
                } else {
                    OrderDetailNewActivity.this.loadPayResult(orderParmasResult);
                }
            }
        });
    }

    public String getPriceString(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1165890476")) {
            return (String) ipChange.ipc$dispatch("1165890476", new Object[]{this, str});
        }
        if (str.contains("￥")) {
            str = str.replace("￥", "").trim();
        }
        if (str.contains(".")) {
            if (str.endsWith("0")) {
                str = str.substring(0, str.length() - 1);
            }
            if (str.endsWith("0")) {
                str = str.substring(0, str.length() - 1);
            }
            return str.endsWith(".") ? str.substring(0, str.length() - 1) : str;
        }
        return str;
    }

    public void getSamePriceIdSum() {
        List<jinPaiEntity> list;
        boolean z;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1864196057")) {
            ipChange.ipc$dispatch("1864196057", new Object[]{this});
            return;
        }
        jinPai jinpai = this.mOrderDetail.jinPai;
        if (jinpai == null || (list = jinpai.priceList) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            jinPaiEntity jinpaientity = list.get(i2);
            int i3 = 0;
            while (true) {
                if (i3 >= arrayList.size()) {
                    z = false;
                    break;
                }
                jinPaiEntity jinpaientity2 = (jinPaiEntity) arrayList.get(i3);
                if (jinpaientity.priceId == jinpaientity2.priceId) {
                    jinpaientity2.sum += jinpaientity.sum;
                    z = true;
                    break;
                }
                i3++;
            }
            if (!z) {
                arrayList.add(jinpaientity);
            }
        }
        this.mOrderDetail.jinPai.priceList = arrayList;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1360870887")) {
            ipChange.ipc$dispatch("1360870887", new Object[]{this, Integer.valueOf(i2)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "608185636")) {
            ipChange.ipc$dispatch("608185636", new Object[]{this});
        }
    }

    public void initTenDrawable() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1680716463")) {
            ipChange.ipc$dispatch("-1680716463", new Object[]{this});
            return;
        }
        Drawable[] drawableArr = new Drawable[10];
        this.drawableArray = drawableArr;
        drawableArr[0] = getResources().getDrawable(R$drawable.num_0);
        this.drawableArray[1] = getResources().getDrawable(R$drawable.num_1);
        this.drawableArray[2] = getResources().getDrawable(R$drawable.num_2);
        this.drawableArray[3] = getResources().getDrawable(R$drawable.num_3);
        this.drawableArray[4] = getResources().getDrawable(R$drawable.num_4);
        this.drawableArray[5] = getResources().getDrawable(R$drawable.num_5);
        this.drawableArray[6] = getResources().getDrawable(R$drawable.num_6);
        this.drawableArray[7] = getResources().getDrawable(R$drawable.num_7);
        this.drawableArray[8] = getResources().getDrawable(R$drawable.num_8);
        this.drawableArray[9] = getResources().getDrawable(R$drawable.num_9);
    }

    public void initTicketView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1326055309")) {
            ipChange.ipc$dispatch("1326055309", new Object[]{this});
            return;
        }
        this.tv_product_price = (TextView) findViewById(R$id.tv_product_price);
        this.tv_yunfei_price = (TextView) findViewById(R$id.tv_yunfei_price);
        this.tv_ticket_price = (TextView) findViewById(R$id.tv_ticket_price);
        this.tv_order_price = (TextView) findViewById(R$id.tv_order_price);
        this.rl_yunfei = (RelativeLayout) findViewById(R$id.rl_yunfei);
        this.rl_youhui = (RelativeLayout) findViewById(R$id.rl_youhui);
        this.rl_youhuizc = (RelativeLayout) findViewById(R$id.rl_youhuizc);
        this.rl_jifen = (RelativeLayout) findViewById(R$id.rl_jifen);
        this.rl_yunfei_line = (TextView) findViewById(R$id.rl_yunfei_line);
        this.rl_youhui_line = (TextView) findViewById(R$id.rl_youhui_line);
        this.rl_youhuizc_line = (TextView) findViewById(R$id.rl_youhuizc_line);
        this.rl_jifen_line = (TextView) findViewById(R$id.rl_jifen_line);
        this.baoxian_price_view = findViewById(R$id.baoxian_price_view);
        this.tv_baoxian_price = (TextView) findViewById(R$id.tv_baoxian_price);
        this.order_num = (TextView) findViewById(R$id.order_num);
        this.baoxian_price_view.setVisibility(8);
        this.tv_ticket_yhzc = (TextView) findViewById(R$id.tv_ticket_yhzc);
        this.tv_ticket_score = (TextView) findViewById(R$id.tv_ticket_score);
        this.ll_ok_replenishment = (LinearLayout) findViewById(R$id.ll_ok_replenishment);
        this.ll_ok_cancel = (LinearLayout) findViewById(R$id.ll_ok_cancel);
        this.mTvReplenishment = (TextView) findViewById(R$id.tv_pay_replenishment);
        this.tv_replenishment = (TextView) findViewById(R$id.tv_replenishment);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-120638727")) {
            ipChange.ipc$dispatch("-120638727", new Object[]{this});
            return;
        }
        initTenDrawable();
        initData();
        this.pull_down_view = (PullToRefreshLayout) findViewById(R$id.pull_refresh_layout);
        this.mScrollView = (ObservableScrollView) findViewById(R$id.scrollview);
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R$id.iv_lingqian);
        this.iv_lingqian = floatingActionButton;
        floatingActionButton.attachToScrollView(this.mScrollView, new i(this), new p(this));
        new w2().a(this, this.pull_down_view, this.mScrollView, new s());
        View inflate = this.mInflater.inflate(R$layout.order_datail_new2_content, (ViewGroup) null);
        this.mContentView = inflate;
        this.ray_detail = (LinearLayout) inflate.findViewById(R$id.ray_detail);
        LinearLayout linearLayout = (LinearLayout) this.mContentView.findViewById(R$id.btn_kefu);
        this.btn_kefu = linearLayout;
        linearLayout.setOnClickListener(new t());
        this.ray_image_line = (LinearLayout) this.mContentView.findViewById(R$id.ray_image_line);
        this.ray_text = (TextView) this.mContentView.findViewById(R$id.ray_text);
        this.ray_image = (ImageView) this.mContentView.findViewById(R$id.ray_image);
        this.v_line_1 = this.mContentView.findViewById(R$id.v_line_1);
        this.ll_paydetail = this.mContentView.findViewById(R$id.ll_paydetail);
        LinearLayout linearLayout2 = (LinearLayout) this.mContentView.findViewById(R$id.ll_add_invoice);
        this.mAddInvoiceLayout = linearLayout2;
        this.mAddInvoiceGoLayout = (LinearLayout) linearLayout2.findViewById(R$id.ll_add_invoice_content);
        this.mAddInvoiceTipLayout = (LinearLayout) this.mAddInvoiceLayout.findViewById(R$id.ll_add_invoice_tip);
        this.mAddInvoiceTipTv = (TextView) this.mAddInvoiceLayout.findViewById(R$id.tv_add_invoice_tip);
        this.order_detail_send_llyt = (LinearLayout) this.mContentView.findViewById(R$id.order_detail_send_llyt);
        this.order_new_detail_listview = (MainListView) this.mContentView.findViewById(R$id.order_new_detail_listview);
        this.order_detail_price_rlyt = (RelativeLayout) this.mContentView.findViewById(R$id.order_detail_price_rlyt);
        ImageView imageView = (ImageView) findViewById(R$id.base_right_icon);
        this.iv_header_right_icon = imageView;
        imageView.setImageResource(R$drawable.project_details_share_black_style);
        this.mScrollView.addView(this.mContentView);
        this.mContentView.setVisibility(8);
        this.ypyz_add_view = (LinearLayout) this.mContentView.findViewById(R$id.ypyz_add_view);
        this.ypyz_add_show_view = (LinearLayout) this.mContentView.findViewById(R$id.ypyz_add_show_view);
        this.ypyz_show_more_seat_view = this.mContentView.findViewById(R$id.ypyz_show_more_seat_view);
        this.ypyz_seat_image_btn = (ImageView) this.mContentView.findViewById(R$id.ypyz_seat_image_btn);
        this.mAddInvoiceLayout.setEnabled(false);
        this.mAddInvoiceLayout.setOnClickListener(new u());
        this.ll_projectimage = (LinearLayout) this.mContentView.findViewById(R$id.ll_projectimage);
        this.status_text = (TextView) this.mContentView.findViewById(R$id.status_text);
        this.createtime_text = (TextView) this.mContentView.findViewById(R$id.createtime_text);
        this.orderno_text = (TextView) this.mContentView.findViewById(R$id.orderno_text);
        this.ll_tip = (LinearLayout) this.mContentView.findViewById(R$id.ll_tip);
        this.project_image = (ImageView) this.mContentView.findViewById(R$id.project_image);
        this.projectname_text = (TextView) this.mContentView.findViewById(R$id.projectname_text);
        this.projecttime_text = (TextView) this.mContentView.findViewById(R$id.projecttime_text);
        this.projectaddress_text = (TextView) this.mContentView.findViewById(R$id.projectaddress_text);
        this.num_ticket_text = (TextView) this.mContentView.findViewById(R$id.num_ticket_text);
        this.price_ticket_text = (TextView) this.mContentView.findViewById(R$id.price_ticket_text);
        this.seat_add_view = (LinearLayout) this.mContentView.findViewById(R$id.seat_add_view);
        this.has_seat_line_view = this.mContentView.findViewById(R$id.has_seat_line_view);
        this.show_more_seat_view = this.mContentView.findViewById(R$id.show_more_seat_view);
        this.deliver_method_text = (TextView) this.mContentView.findViewById(R$id.deliver_method_text);
        this.iv_deliverway_icon = (ImageView) this.mContentView.findViewById(R$id.iv_deliverway_icon);
        TextView textView = (TextView) this.mContentView.findViewById(R$id.btn_order_address_modify);
        this.mBtnModifyAddress = textView;
        textView.setOnClickListener(this.mModifyListener);
        this.deliver_name_text = (TextView) this.mContentView.findViewById(R$id.deliver_name_text);
        this.deliver_phone_text = (TextView) this.mContentView.findViewById(R$id.deliver_phone_text);
        this.deliver_email_text = (TextView) this.mContentView.findViewById(R$id.deliver_email_text);
        this.deliver_address_text = (TextView) this.mContentView.findViewById(R$id.deliver_address_text);
        this.deliver_descript_text = (TextView) this.mContentView.findViewById(R$id.deliver_descript_text);
        this.ll_pay_method_tip = (LinearLayout) this.mContentView.findViewById(R$id.ll_pay_method_tip);
        this.pay_desc_text = (TextView) this.mContentView.findViewById(R$id.pay_desc_text);
        this.ll_pay_method = (LinearLayout) this.mContentView.findViewById(R$id.ll_pay_method);
        this.ll_btn = (LinearLayout) findViewById(R$id.ll_btn);
        this.btn_cancel = (Button) findViewById(R$id.btn_cancel);
        this.btn_submit = (Button) findViewById(R$id.btn_submit);
        this.ll_trace = (LinearLayout) this.mContentView.findViewById(R$id.ll_trace);
        this.ll_trace_info = (LinearLayout) this.mContentView.findViewById(R$id.ll_trace_info);
        View findViewById = this.mContentView.findViewById(R$id.take_photo_view);
        this.take_photo_view = findViewById;
        findViewById.getViewTreeObserver().addOnPreDrawListener(new v());
        initPushDelivery(this.mContentView);
        initTicketView();
    }

    public boolean isNumeric(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1764142265") ? ((Boolean) ipChange.ipc$dispatch("-1764142265", new Object[]{this, str})).booleanValue() : Pattern.compile("[0-9]*").matcher(str).matches();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "894684320")) {
            ipChange.ipc$dispatch("894684320", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3), intent});
            return;
        }
        super.onActivityResult(i2, i3, intent);
        ShareManager.E().r0(i2, i3, intent);
        if (i2 == 2000 && i3 == 1000) {
            int i4 = this.mFromPage;
            if (i4 == 1) {
                setResult(1000);
                finish();
            } else if (i4 == 2) {
                finish();
            } else {
                Intent intent2 = new Intent();
                intent2.putExtra("refresh", true);
                setResult(-1, intent2);
                finish();
            }
        } else if (i3 == -1) {
            if (i2 == 8008) {
                this.times = 0;
                cancelTimer();
            } else if (i2 == 1002) {
                AddressBean addressBean = (AddressBean) intent.getParcelableExtra("added_address");
                if (addressBean != null) {
                    jumpModifyAddress(addressBean.getAddressId());
                }
            } else if (i2 == 1001) {
                this.times = 0;
                cancelTimer();
                this.mHasModifyAddress = true;
            }
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "965725248")) {
            ipChange.ipc$dispatch("965725248", new Object[]{this});
        } else {
            finishActivity();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1081299105")) {
            ipChange.ipc$dispatch("1081299105", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setDamaiUTKeyBuilder(pp2.u().z(this.projectId, this.orderId));
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1691545834")) {
            ipChange.ipc$dispatch("-1691545834", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-835107777")) {
            ipChange.ipc$dispatch("-835107777", new Object[]{this});
        }
    }

    public void onOk(OrderredBox orderredBox) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1508123049")) {
            ipChange.ipc$dispatch("-1508123049", new Object[]{this, orderredBox});
            return;
        }
        this.orderredBox = orderredBox;
        if (orderredBox == null || this.mOrderDetail == null || TextUtils.isEmpty(orderredBox.StartTime) || TextUtils.isEmpty(this.mOrderDetail.CreateTimeString)) {
            return;
        }
        String replace = this.orderredBox.StartTime.replace("/Date(", "").replace(")/", "");
        if (isNumeric(replace)) {
            long time = r30.b(this.mOrderDetail.CreateTimeString).getTime();
            long parseLong = Long.parseLong(replace);
            if (this.mOrderDetail.isPayoff && this.orderredBox.State == 1 && time > parseLong) {
                this.iv_lingqian.setVisibility(0);
                saveShareBitmap();
                DMImageCreator c2 = cn.damai.common.image.a.b().c(this.orderredBox.SmallImg);
                int i2 = R$drawable.uikit_default_image_bg_grey;
                c2.i(i2).c(i2).g(this.iv_lingqian);
                this.iv_lingqian.setOnClickListener(new o());
                return;
            }
            this.iv_lingqian.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1005237723")) {
            ipChange.ipc$dispatch("-1005237723", new Object[]{this});
            return;
        }
        super.onPause();
        cancelTimer();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "550188162")) {
            ipChange.ipc$dispatch("550188162", new Object[]{this});
            return;
        }
        super.onResume();
        requestOrderDetail();
    }

    public void returnOrderDetailData(OrderDetail orderDetail) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1325353368")) {
            ipChange.ipc$dispatch("1325353368", new Object[]{this, orderDetail});
            return;
        }
        this.mOrderDetail = orderDetail;
        if (orderDetail != null) {
            this.projectId = String.valueOf(orderDetail.ProjectID);
            OrderDetail orderDetail2 = this.mOrderDetail;
            if (orderDetail2.us == 1 && orderDetail2.os) {
                if (orderDetail2.PayTime > 0) {
                    scheduleTimer();
                }
                this.mContentView.setVisibility(0);
                requestData(this.orderId);
                OrderDetail orderDetail3 = this.mOrderDetail;
                if (orderDetail3.isPayoff && orderDetail3.CategoryID == 192) {
                    List<SuperTickt> list = orderDetail3.SuperTickets;
                    if (list != null && list.size() != 0) {
                        this.order_new_detail_listview.setVisibility(0);
                        ArrayList arrayList = new ArrayList();
                        for (SuperTickt superTickt : this.mOrderDetail.SuperTickets) {
                            String str = superTickt.verifyNo;
                            if (str != null && !str.equals("")) {
                                arrayList.add(superTickt);
                            }
                        }
                        flushAdapter(arrayList);
                    } else {
                        this.order_new_detail_listview.setVisibility(8);
                    }
                } else {
                    this.order_new_detail_listview.setVisibility(8);
                }
                fillTipContent();
                fillProjectInfo();
                fillPushDelivery();
                fillOrderInfo();
                fillDeliveryData();
                fillInvoice();
                fillCouponsView();
                fillPayMethod();
                getSamePriceIdSum();
                if (!TextUtils.isEmpty(this.mOrderDetail.orderFraudNotice) && !mu0.g) {
                    this.ray_text.setText(this.mOrderDetail.orderFraudNotice);
                    this.ray_detail.setVisibility(0);
                    this.ray_image_line.setOnClickListener(new n());
                } else {
                    this.ray_detail.setVisibility(8);
                }
                if (this.mOrderDetail.CategoryID == 192) {
                    TextView textView = this.projecttime_text;
                    textView.setText("数量：" + this.mOrderDetail.Quantity);
                    TextView textView2 = this.projectaddress_text;
                    textView2.setText("商品金额：" + this.mOrderDetail.Amount);
                    this.order_detail_price_rlyt.setVisibility(8);
                    this.order_detail_send_llyt.setVisibility(8);
                    this.ll_trace.setVisibility(8);
                    this.ll_paydetail.setVisibility(8);
                    this.v_line_1.setVisibility(0);
                    List<SuperTickt> list2 = this.mOrderDetail.SuperTickets;
                    if (list2 != null && list2.size() != 0) {
                        if (this.mOrderDetail.SuperTickets.get(0).sendType == 2) {
                            if (this.mOrderDetail.OrderSuccess == 1) {
                                this.ll_btn.setVisibility(8);
                            } else {
                                this.ll_btn.setVisibility(0);
                                fillBtn();
                            }
                        } else if (this.mOrderDetail.isPayoff) {
                            this.ll_btn.setVisibility(8);
                        } else {
                            this.ll_btn.setVisibility(0);
                            fillBtn();
                        }
                    }
                } else {
                    this.v_line_1.setVisibility(8);
                    this.order_detail_send_llyt.setVisibility(0);
                    this.projecttime_text.setText(cm2.c(this, R$string.damai_orderdetailnew_time, this.mOrderDetail.PlayTime));
                    this.projectaddress_text.setText(this.mOrderDetail.VenueName);
                    this.order_detail_price_rlyt.setVisibility(0);
                    this.ll_trace.setVisibility(0);
                    fillTrace();
                    fillBtn();
                }
                if (this.mHasModifyAddress) {
                    this.mHasModifyAddress = false;
                    if (TextUtils.isEmpty(this.mOrderDetail.isAddressStr)) {
                        return;
                    }
                    setModifyAddressTipDialog(this.mOrderDetail.isAddressStr);
                    return;
                }
                return;
            }
            this.mHasModifyAddress = false;
            toast(orderDetail2.error);
        }
    }

    public void saveShareBitmap() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1658783733")) {
            ipChange.ipc$dispatch("-1658783733", new Object[]{this});
            return;
        }
        this.mImageUrl = this.orderredBox.ShareImg;
        new ImageView(this.mContext).setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        if (isActivityFinsihed()) {
            return;
        }
        cn.damai.common.image.a.b().c(this.mImageUrl).n(new r()).e(new q(this)).f();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2048761736") ? (String) ipChange.ipc$dispatch("2048761736", new Object[]{this}) : cm2.b(this, R$string.order_detail);
    }

    public void setYPYZView() {
        List<YPYZInfo> list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1954323293")) {
            ipChange.ipc$dispatch("1954323293", new Object[]{this});
            return;
        }
        OrderDetail orderDetail = this.mOrderDetail;
        if (orderDetail != null && (list = orderDetail.Audiences) != null && list.size() > 0) {
            this.ypyz_add_view.setVisibility(0);
            this.ypyzView.clear();
            this.ypyz_add_show_view.removeAllViews();
            List<YPYZInfo> list2 = this.mOrderDetail.Audiences;
            for (int i2 = 0; i2 < list2.size(); i2++) {
                YPYZInfo yPYZInfo = list2.get(i2);
                View inflate = this.mInflater.inflate(R$layout.ypyz_orderinfo_item, (ViewGroup) null);
                ((TextView) inflate.findViewById(R$id.tv_name)).setText(yPYZInfo.name);
                ((TextView) inflate.findViewById(R$id.tv_cardid)).setText(yPYZInfo.identifier);
                ((TextView) inflate.findViewById(R$id.tv_cardtype)).setText(yPYZInfo.typeName);
                ((TextView) inflate.findViewById(R$id.tv_seatnum)).setText(yPYZInfo.SeatNo);
                this.ypyz_add_show_view.addView(inflate);
                if (i2 > 1) {
                    this.ypyzView.add(inflate);
                    inflate.setVisibility(8);
                }
            }
            if (this.mOrderDetail.Audiences.size() > 2) {
                this.ypyz_show_more_seat_view.setVisibility(0);
                this.ypyz_show_more_seat_view.setOnClickListener(new f());
                return;
            }
            this.ypyz_show_more_seat_view.setVisibility(8);
            return;
        }
        this.ypyz_add_view.setVisibility(8);
    }

    public void startTimeThread() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "114277891")) {
            ipChange.ipc$dispatch("114277891", new Object[]{this});
            return;
        }
        this.isUsing = true;
        if (this.t == null) {
            Thread thread = new Thread(new Runnable() { // from class: cn.damai.trade.oldtradeorder.ui.orderdetail.detail.activity.OrderDetailNewActivity.13
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    long time;
                    StringBuilder sb;
                    StringBuilder sb2;
                    StringBuilder sb3;
                    String str;
                    IpChange ipChange2 = $ipChange;
                    int i2 = 1;
                    if (AndroidInstantRuntime.support(ipChange2, "-831262699")) {
                        ipChange2.ipc$dispatch("-831262699", new Object[]{this});
                        return;
                    }
                    while (OrderDetailNewActivity.this.isUsing) {
                        try {
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            Date parse = simpleDateFormat.parse(OrderDetailNewActivity.this.startTimeString);
                            OrderDetailNewActivity orderDetailNewActivity = OrderDetailNewActivity.this;
                            if (orderDetailNewActivity.nowDate == null) {
                                orderDetailNewActivity.nowDate = simpleDateFormat.parse(orderDetailNewActivity.nowTimeString);
                            } else {
                                orderDetailNewActivity.nowDate = new Date(OrderDetailNewActivity.this.nowDate.getTime() + 1000);
                            }
                            time = parse.getTime() - OrderDetailNewActivity.this.nowDate.getTime();
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        } catch (ParseException e3) {
                            e3.printStackTrace();
                        }
                        if (time < 0) {
                            OrderDetailNewActivity orderDetailNewActivity2 = OrderDetailNewActivity.this;
                            orderDetailNewActivity2.days = "00";
                            orderDetailNewActivity2.hours = "00";
                            orderDetailNewActivity2.mins = "00";
                            orderDetailNewActivity2.seconds = "00";
                            orderDetailNewActivity2.timeThread.sendEmptyMessage(0);
                            OrderDetailNewActivity.this.timeThread.sendEmptyMessage(101);
                            OrderDetailNewActivity orderDetailNewActivity3 = OrderDetailNewActivity.this;
                            if (orderDetailNewActivity3.times == 0) {
                                orderDetailNewActivity3.timeThread.sendEmptyMessageDelayed(100, 1000L);
                            }
                            OrderDetailNewActivity.this.times += i2;
                            return;
                        }
                        long j2 = time / 86400000;
                        long j3 = (time % 86400000) / DateUtils.MILLIS_PER_HOUR;
                        long j4 = (time % DateUtils.MILLIS_PER_HOUR) / DateUtils.MILLIS_PER_MINUTE;
                        long j5 = (time % DateUtils.MILLIS_PER_MINUTE) / 1000;
                        OrderDetailNewActivity orderDetailNewActivity4 = OrderDetailNewActivity.this;
                        if (j2 > 9) {
                            sb = new StringBuilder();
                            sb.append(j2);
                            sb.append("");
                        } else {
                            sb = new StringBuilder();
                            sb.append("0");
                            sb.append(j2);
                        }
                        orderDetailNewActivity4.days = sb.toString();
                        OrderDetailNewActivity orderDetailNewActivity5 = OrderDetailNewActivity.this;
                        if (j3 > 9) {
                            sb2 = new StringBuilder();
                            sb2.append(j3);
                            sb2.append("");
                        } else {
                            sb2 = new StringBuilder();
                            sb2.append("0");
                            sb2.append(j3);
                        }
                        orderDetailNewActivity5.hours = sb2.toString();
                        OrderDetailNewActivity orderDetailNewActivity6 = OrderDetailNewActivity.this;
                        if (j4 > 9) {
                            sb3 = new StringBuilder();
                            sb3.append(j4);
                            sb3.append("");
                        } else {
                            sb3 = new StringBuilder();
                            sb3.append("0");
                            sb3.append(j4);
                        }
                        orderDetailNewActivity6.mins = sb3.toString();
                        OrderDetailNewActivity orderDetailNewActivity7 = OrderDetailNewActivity.this;
                        if (j5 > 9) {
                            str = j5 + "";
                        } else {
                            str = "0" + j5;
                        }
                        orderDetailNewActivity7.seconds = str;
                        OrderDetailNewActivity.this.timeThread.sendEmptyMessage(0);
                        Thread.sleep(1000L);
                        i2 = 1;
                    }
                }
            });
            this.t = thread;
            thread.start();
        }
    }

    public void toast(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1618634337")) {
            ipChange.ipc$dispatch("-1618634337", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str)) {
            ToastUtil.a().g(this);
        } else {
            ToastUtil.i(str);
        }
    }
}
