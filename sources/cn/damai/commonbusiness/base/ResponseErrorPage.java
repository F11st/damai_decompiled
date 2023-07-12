package cn.damai.commonbusiness.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.R$string;
import cn.damai.login.LoginManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Set;
import tb.ir1;
import tb.mr1;
import tb.pl;
import tb.wh2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class ResponseErrorPage extends LinearLayout implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private String defaultErrorMsg;
    private boolean isOperation;
    private String mApiName;
    private TextView mBtnOther;
    private TextView mBtnRefresh;
    private TextView mBtnReport;
    private Context mContext;
    private String mErrorCode;
    private String mErrorMsg;
    private LinearLayout mErrorPageLayout;
    private int mErrorType;
    private StringBuilder mExtraBuilder;
    private LayoutInflater mLayoutInflater;
    private View mLeftBtn;
    private ErrorRefreshListener mRefreshListener;
    private View mRootView;
    public View mTitleView;
    private TextView mTvErrorContent;
    private ImageView mTvErrorImage;
    private TextView mTvErrorTitle;
    private String refreshContent;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public interface ErrorRefreshListener {
        void handleError(int i);
    }

    public ResponseErrorPage(Activity activity, String str, String str2, String str3) {
        super(activity);
        this.defaultErrorMsg = "";
        this.refreshContent = "努力刷新";
        this.mExtraBuilder = new StringBuilder();
        init(activity, activity, 1, str, str2, str3, null);
    }

    private void exitCurrentPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1442224586")) {
            ipChange.ipc$dispatch("1442224586", new Object[]{this});
            return;
        }
        Context context = this.mContext;
        if (context != null && (context instanceof Activity)) {
            ((Activity) context).finish();
        }
    }

    private void getExtraData(String str) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        boolean z2 = false;
        if (AndroidInstantRuntime.support(ipChange, "-875850948")) {
            ipChange.ipc$dispatch("-875850948", new Object[]{this, str});
            return;
        }
        StringBuilder sb = this.mExtraBuilder;
        sb.delete(0, sb.length());
        String str2 = this.mApiName;
        if (str2 != null) {
            if (str2.toLowerCase().contains("apiname")) {
                this.mExtraBuilder.append(this.mApiName);
            } else {
                StringBuilder sb2 = this.mExtraBuilder;
                sb2.append("apiName:" + this.mApiName);
            }
            z2 = true;
        }
        if (this.mErrorCode != null) {
            if (z2) {
                this.mExtraBuilder.append(",");
            }
            StringBuilder sb3 = this.mExtraBuilder;
            sb3.append("errorCode:" + this.mErrorCode);
        } else {
            z = z2;
        }
        if (this.mErrorMsg != null) {
            if (z) {
                this.mExtraBuilder.append(",");
            }
            StringBuilder sb4 = this.mExtraBuilder;
            sb4.append("errorMsg:" + this.mErrorMsg);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (z) {
            this.mExtraBuilder.append(",");
        }
        this.mExtraBuilder.append(str);
    }

    private String getPageData(Bundle bundle) {
        Set<String> keySet;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1534526033")) {
            return (String) ipChange.ipc$dispatch("1534526033", new Object[]{this, bundle});
        }
        StringBuilder sb = new StringBuilder();
        sb.delete(0, sb.length());
        if (bundle != null && (keySet = bundle.keySet()) != null) {
            sb.append("errorjson={");
            for (String str : keySet) {
                Object obj = bundle.get(str);
                if (obj != null && obj.toString() != null) {
                    sb.append(str);
                    sb.append(":");
                    sb.append(obj.toString());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.delete(sb.length() - 1, sb.length());
            }
            sb.append("}");
        }
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0093, code lost:
        if (r2 != null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0095, code lost:
        r2.recycle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a0, code lost:
        if (r2 != null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00a3, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String getScreenImage() {
        /*
            r12 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.commonbusiness.base.ResponseErrorPage.$ipChange
            java.lang.String r1 = "-39336285"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L17
            java.lang.Object[] r2 = new java.lang.Object[r4]
            r2[r3] = r12
            java.lang.Object r0 = r0.ipc$dispatch(r1, r2)
            java.lang.String r0 = (java.lang.String) r0
            return r0
        L17:
            android.content.Context r0 = r12.mContext
            java.lang.String r1 = ""
            if (r0 != 0) goto L1e
            return r1
        L1e:
            r2 = 0
            android.app.Activity r0 = (android.app.Activity) r0     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            android.view.Window r0 = r0.getWindow()     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            android.view.View r0 = r0.getDecorView()     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            r0.setDrawingCacheEnabled(r4)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            r0.buildDrawingCache()     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            android.graphics.Bitmap r5 = r0.getDrawingCache()     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            android.graphics.Matrix r10 = new android.graphics.Matrix     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            r10.<init>()     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            r0 = 1056964608(0x3f000000, float:0.5)
            r10.setScale(r0, r0)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            r6 = 0
            r7 = 0
            int r8 = r5.getWidth()     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            int r9 = r5.getHeight()     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            r11 = 0
            android.graphics.Bitmap r2 = android.graphics.Bitmap.createBitmap(r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            if (r2 == 0) goto L93
            java.lang.String r0 = cn.damai.common.util.a.m()     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            boolean r4 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            if (r4 != 0) goto L93
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            r4.<init>()     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            r4.append(r0)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            java.lang.String r5 = "/feedback"
            r4.append(r5)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            cn.damai.common.util.a.t(r4, r3)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            r3.<init>()     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            r3.append(r0)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            java.lang.String r0 = "/feedback/screen.jpg"
            r3.append(r0)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            cn.damai.common.util.a.d(r0)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            android.graphics.Bitmap$CompressFormat r4 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            r5 = 100
            r2.compress(r4, r5, r3)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            r3.flush()     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            r3.close()     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            r1 = r0
        L93:
            if (r2 == 0) goto La3
        L95:
            r2.recycle()
            goto La3
        L99:
            r0 = move-exception
            if (r2 == 0) goto L9f
            r2.recycle()
        L9f:
            throw r0
        La0:
            if (r2 == 0) goto La3
            goto L95
        La3:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.commonbusiness.base.ResponseErrorPage.getScreenImage():java.lang.String");
    }

    private void hideRefreshBtn() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-73395693")) {
            ipChange.ipc$dispatch("-73395693", new Object[]{this});
            return;
        }
        TextView textView = this.mBtnRefresh;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void init(Activity activity, Context context, int i, String str, String str2, String str3, Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "893849347")) {
            ipChange.ipc$dispatch("893849347", new Object[]{this, activity, context, Integer.valueOf(i), str, str2, str3, bundle});
            return;
        }
        this.mContext = context;
        this.mApiName = str3;
        this.mErrorCode = str;
        this.mErrorMsg = str2;
        this.mErrorType = i;
        this.mLayoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        if (bundle != null) {
            getExtraData(getPageData(bundle));
        } else if (activity != null) {
            getExtraData(getPageData(activity));
        }
        initView();
        initButtonView(str, i);
        loadErrorMsg(str, str2);
    }

    private void initButtonView(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-620922806")) {
            ipChange.ipc$dispatch("-620922806", new Object[]{this, str, Integer.valueOf(i)});
        } else if (!TextUtils.isEmpty(str) && "DM_SECONDARY_ORDER_ERROR_02".equals(str)) {
            updateReportBtnVis(str);
            updateBtnState(true, this.refreshContent);
            this.defaultErrorMsg = "正在排队，请稍后哦";
            this.mTvErrorImage.setImageResource(R$drawable.dm_common_neterror_waiting);
        } else {
            switch (i) {
                case 1:
                    updateReportBtnVis(str);
                    updateBtnState(true, this.refreshContent);
                    this.defaultErrorMsg = this.mContext.getResources().getString(R$string.common_net_error_tip);
                    this.mTvErrorImage.setImageResource(R$drawable.common_error_net);
                    return;
                case 2:
                case 11:
                    hideReportBtn();
                    updateBtnState(true, "");
                    this.defaultErrorMsg = "抱歉，当前排队的人数太多啦，请稍后再试哦";
                    this.mTvErrorImage.setImageResource(R$drawable.common_error_ticket_limit);
                    return;
                case 3:
                    hideReportBtn();
                    updateBtnState(false, "");
                    this.defaultErrorMsg = this.mContext.getResources().getString(R$string.common_ticket_empty_tip);
                    this.mTvErrorImage.setImageResource(R$drawable.common_error_ticket_empty);
                    return;
                case 4:
                    hideReportBtn();
                    updateBtnState(false, "");
                    this.defaultErrorMsg = this.mContext.getResources().getString(R$string.common_project_no_exist_tip);
                    this.mTvErrorImage.setImageResource(R$drawable.common_error_ticket_empty);
                    return;
                case 5:
                    hideReportBtn();
                    updateBtnState(true, "重新选择");
                    this.defaultErrorMsg = "抱歉，当前排队的人数太多啦，请稍后再试哦";
                    this.mTvErrorImage.setImageResource(R$drawable.common_error_ticket_limit);
                    return;
                case 6:
                    hideReportBtn();
                    updateBtnState(true, "重新选择");
                    this.defaultErrorMsg = "您选购的商品信息已过期，请重新查询";
                    this.mTvErrorImage.setImageResource(R$drawable.common_error_ticket_empty);
                    return;
                case 7:
                    hideReportBtn();
                    updateBtnState(true, "登录");
                    this.defaultErrorMsg = "你还没有登录哦(-.-)";
                    this.mTvErrorImage.setImageResource(R$drawable.common_error_ticket_login);
                    return;
                case 8:
                case 9:
                default:
                    updateReportBtnVis(str);
                    updateBtnState(true, this.refreshContent);
                    this.defaultErrorMsg = this.mContext.getResources().getString(R$string.common_net_error_tip);
                    this.mTvErrorImage.setImageResource(R$drawable.common_error_net);
                    return;
                case 10:
                    hideReportBtn();
                    hideRefreshBtn();
                    updateOtherBtnState(true, "");
                    this.defaultErrorMsg = "这里空空如也";
                    this.mTvErrorImage.setImageResource(R$drawable.common_error_ticket_empty);
                    return;
            }
        }
    }

    private void initRefreshReportView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1491843056")) {
            ipChange.ipc$dispatch("1491843056", new Object[]{this});
            return;
        }
        View view = this.mRootView;
        if (view == null) {
            return;
        }
        this.mBtnRefresh = (TextView) view.findViewById(R$id.btn_refresh);
        this.mBtnReport = (TextView) this.mRootView.findViewById(R$id.tv_report);
        TextView textView = (TextView) this.mRootView.findViewById(R$id.btn_other);
        this.mBtnOther = textView;
        textView.setVisibility(8);
        this.mBtnRefresh.setOnClickListener(this);
        this.mBtnReport.setOnClickListener(this);
        this.mBtnOther.setOnClickListener(this);
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1145865761")) {
            ipChange.ipc$dispatch("1145865761", new Object[]{this});
            return;
        }
        View inflate = this.mLayoutInflater.inflate(R$layout.layout_error_page, this);
        this.mRootView = inflate;
        this.mErrorPageLayout = (LinearLayout) inflate.findViewById(R$id.ll_error);
        this.mTvErrorTitle = (TextView) this.mRootView.findViewById(R$id.base_header_title);
        View findViewById = this.mRootView.findViewById(R$id.base_header_left);
        this.mLeftBtn = findViewById;
        findViewById.setOnClickListener(this);
        this.mTvErrorImage = (ImageView) this.mRootView.findViewById(R$id.iv_error_tip);
        this.mTvErrorContent = (TextView) this.mRootView.findViewById(R$id.tv_error_tip);
        this.mRootView.setOnClickListener(this);
        View findViewById2 = this.mRootView.findViewById(R$id.layout_header_view);
        this.mTitleView = findViewById2;
        findViewById2.setVisibility(0);
        initRefreshReportView();
    }

    private boolean isOperation(String str, String str2) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-386089393")) {
            return ((Boolean) ipChange.ipc$dispatch("-386089393", new Object[]{this, str, str2})).booleanValue();
        }
        if (this.mErrorType != 1) {
            return false;
        }
        try {
            i = Integer.parseInt(str2);
        } catch (Exception e) {
            e.printStackTrace();
            i = 0;
        }
        if (i == 0) {
            return false;
        }
        switch (i) {
            case 550:
            case 551:
            case 552:
                return true;
            default:
                return !wh2.j(str) && str.contains("联系客服");
        }
    }

    private void refreshListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-614830427")) {
            ipChange.ipc$dispatch("-614830427", new Object[]{this});
            return;
        }
        int i = this.mErrorType;
        if (i == 1) {
            if (this.isOperation) {
                try {
                    this.mContext.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:10103721")));
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    ToastUtil.a().j(this.mContext, "无法拨号，请手动拨打10103721");
                    return;
                }
            }
            ErrorRefreshListener errorRefreshListener = this.mRefreshListener;
            if (errorRefreshListener != null) {
                errorRefreshListener.handleError(0);
            }
        } else if (i == 2) {
            ErrorRefreshListener errorRefreshListener2 = this.mRefreshListener;
            if (errorRefreshListener2 != null) {
                errorRefreshListener2.handleError(0);
            }
        } else if (i == 5) {
            ErrorRefreshListener errorRefreshListener3 = this.mRefreshListener;
            if (errorRefreshListener3 != null) {
                errorRefreshListener3.handleError(0);
            } else {
                exitCurrentPage();
            }
        } else if (i == 6) {
            exitCurrentPage();
        } else if (i != 7) {
            ErrorRefreshListener errorRefreshListener4 = this.mRefreshListener;
            if (errorRefreshListener4 != null) {
                errorRefreshListener4.handleError(0);
            }
        } else {
            ErrorRefreshListener errorRefreshListener5 = this.mRefreshListener;
            if (errorRefreshListener5 != null) {
                errorRefreshListener5.handleError(0);
            }
        }
    }

    private void reportListener(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "63777944")) {
            ipChange.ipc$dispatch("63777944", new Object[]{this, str});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("name", "90");
        String str2 = this.mErrorMsg;
        if (str2 != null) {
            bundle.putString("descInfo", str2);
        }
        StringBuilder sb = this.mExtraBuilder;
        String sb2 = sb != null ? sb.toString() : "";
        if (!TextUtils.isEmpty(sb2)) {
            bundle.putString("extra", sb2);
        }
        Context context = this.mContext;
        if (context != null) {
            context.getClass();
            String name = this.mContext.getClass().getName();
            if (!TextUtils.isEmpty(name)) {
                bundle.putString("fromPage", name);
                String[] split = name.split("\\.");
                if (split != null && split.length > 2) {
                    bundle.putString("module", split[2]);
                }
            }
        }
        bundle.putString("screenView", str);
        c.e().x(pl.j().q(z20.E(), this.mErrorMsg));
        DMNav.from(this.mContext).withExtras(bundle).toUri(NavUri.b("feed_back_report"));
    }

    public void askPermission() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1899006796")) {
            ipChange.ipc$dispatch("1899006796", new Object[]{this});
            return;
        }
        try {
            if (ir1.i(mr1.STORAGE)) {
                reportListener(getScreenImage());
            } else {
                reportListener("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public View getRefreshBtn() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2139594655") ? (View) ipChange.ipc$dispatch("2139594655", new Object[]{this}) : this.mBtnRefresh;
    }

    public View getReportBtn() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1287940666") ? (View) ipChange.ipc$dispatch("-1287940666", new Object[]{this}) : this.mBtnReport;
    }

    public void hideReportBtn() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1018401358")) {
            ipChange.ipc$dispatch("1018401358", new Object[]{this});
        } else {
            this.mBtnReport.setVisibility(8);
        }
    }

    public void hideTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "687893246")) {
            ipChange.ipc$dispatch("687893246", new Object[]{this});
        } else {
            this.mRootView.findViewById(R$id.layout_header_view).setVisibility(8);
        }
    }

    public void loadErrorMsg(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-786274453")) {
            ipChange.ipc$dispatch("-786274453", new Object[]{this, str, str2});
            return;
        }
        TextView textView = this.mTvErrorContent;
        if (textView != null) {
            int i = this.mErrorType;
            if (i == 2) {
                textView.setText(this.defaultErrorMsg);
            } else if (i == 5) {
                if (TextUtils.isEmpty(str2)) {
                    this.mTvErrorContent.setText(this.defaultErrorMsg);
                } else {
                    this.mTvErrorContent.setText(str2);
                }
            } else if (!wh2.j(str2)) {
                if (str2.length() <= 100) {
                    this.mTvErrorContent.setText(str2);
                } else {
                    this.mTvErrorContent.setText(str2.substring(0, 100));
                }
            } else {
                this.mTvErrorContent.setText(this.defaultErrorMsg);
            }
        }
        this.isOperation = isOperation(str, str2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ErrorRefreshListener errorRefreshListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "444123591")) {
            ipChange.ipc$dispatch("444123591", new Object[]{this, view});
            return;
        }
        int id = view.getId();
        if (id == R$id.base_header_left) {
            exitCurrentPage();
        } else if (id == R$id.tv_report) {
            if (!LoginManager.k().q()) {
                LoginManager.k().w(this.mContext, new Intent());
                return;
            }
            Context context = this.mContext;
            if (context == null || !(context instanceof Activity)) {
                return;
            }
            askPermission();
        } else if (id == R$id.btn_refresh) {
            refreshListener();
        } else if (id != R$id.btn_other || (errorRefreshListener = this.mRefreshListener) == null) {
        } else {
            errorRefreshListener.handleError(10);
        }
    }

    public void setErrorImageSize(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1551729470")) {
            ipChange.ipc$dispatch("1551729470", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mTvErrorImage.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.mTvErrorImage.setLayoutParams(layoutParams);
    }

    public void setLeftBtnVisibility(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2089801678")) {
            ipChange.ipc$dispatch("-2089801678", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mLeftBtn.setVisibility(i);
        }
    }

    public void setRefreshListener(ErrorRefreshListener errorRefreshListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-460672722")) {
            ipChange.ipc$dispatch("-460672722", new Object[]{this, errorRefreshListener});
        } else {
            this.mRefreshListener = errorRefreshListener;
        }
    }

    public void setTitleContent(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-360984101")) {
            ipChange.ipc$dispatch("-360984101", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            this.mTvErrorTitle.setText(str);
        }
    }

    public void updateBtnState(boolean z, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-665701498")) {
            ipChange.ipc$dispatch("-665701498", new Object[]{this, Boolean.valueOf(z), str});
            return;
        }
        TextView textView = this.mBtnRefresh;
        if (textView != null) {
            if (z) {
                textView.setVisibility(0);
                if (TextUtils.isEmpty(str)) {
                    str = this.refreshContent;
                }
                this.mBtnRefresh.setText(str);
                return;
            }
            hideRefreshBtn();
        }
    }

    public void updateErrorPageGravity(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1432330570")) {
            ipChange.ipc$dispatch("-1432330570", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (i == 48 && i2 != 0) {
            this.mErrorPageLayout.setGravity(49);
            this.mErrorPageLayout.setPadding(0, i2, 0, 0);
        } else {
            this.mErrorPageLayout.setGravity(17);
            this.mErrorPageLayout.setPadding(0, 0, 0, 0);
        }
    }

    public void updateOtherBtnState(boolean z, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2005959782")) {
            ipChange.ipc$dispatch("2005959782", new Object[]{this, Boolean.valueOf(z), str});
            return;
        }
        TextView textView = this.mBtnOther;
        if (textView != null) {
            if (z) {
                textView.setVisibility(0);
                if (TextUtils.isEmpty(str)) {
                    str = "记录我的精彩现场";
                }
                this.mBtnOther.setText(str);
                return;
            }
            textView.setVisibility(8);
        }
    }

    public void updatePageGravity(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "461873886")) {
            ipChange.ipc$dispatch("461873886", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        LinearLayout linearLayout = this.mErrorPageLayout;
        if (linearLayout == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams.height = -2;
        this.mErrorPageLayout.setLayoutParams(layoutParams);
        if (i == 48 && i2 != 0) {
            this.mErrorPageLayout.setGravity(49);
            this.mErrorPageLayout.setPadding(0, i2, 0, 0);
            return;
        }
        this.mErrorPageLayout.setGravity(17);
        this.mErrorPageLayout.setPadding(0, 0, 0, 0);
    }

    public void updateRefreshBtn(boolean z, String str) {
        TextView textView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "686047858")) {
            ipChange.ipc$dispatch("686047858", new Object[]{this, Boolean.valueOf(z), str});
        } else if (this.mErrorType == 5 && (textView = this.mBtnRefresh) != null) {
            if (z) {
                textView.setVisibility(0);
                if (TextUtils.isEmpty(str)) {
                    str = this.refreshContent;
                }
                this.mBtnRefresh.setText(str);
                return;
            }
            hideRefreshBtn();
        }
    }

    public void updateReportBtn(boolean z, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1013865961")) {
            ipChange.ipc$dispatch("1013865961", new Object[]{this, Boolean.valueOf(z), str});
        } else if (z) {
            this.mBtnReport.setVisibility(0);
        } else if (this.mBtnReport.getVisibility() != 8) {
            this.mBtnReport.setVisibility(8);
        }
    }

    public void updateReportBtnVis(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-411731489")) {
            ipChange.ipc$dispatch("-411731489", new Object[]{this, str});
        } else if (!TextUtils.isEmpty(str) && ResponseErrorPageType.a(str)) {
            this.mBtnReport.setVisibility(8);
        } else {
            this.mBtnReport.setVisibility(0);
        }
    }

    public ResponseErrorPage(Context context, String str, String str2, String str3, Bundle bundle) {
        super(context);
        this.defaultErrorMsg = "";
        this.refreshContent = "努力刷新";
        this.mExtraBuilder = new StringBuilder();
        init(null, context, 1, str, str2, str3, bundle);
    }

    public ResponseErrorPage(Activity activity, int i, String str, String str2, String str3) {
        super(activity);
        this.defaultErrorMsg = "";
        this.refreshContent = "努力刷新";
        this.mExtraBuilder = new StringBuilder();
        init(activity, activity, i, str, str2, str3, null);
    }

    private String getPageData(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-530030231")) {
            return (String) ipChange.ipc$dispatch("-530030231", new Object[]{this, activity});
        }
        if (activity == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.delete(0, sb.length());
        getPageData(activity.getIntent() != null ? activity.getIntent().getExtras() : null);
        return sb.toString();
    }
}
