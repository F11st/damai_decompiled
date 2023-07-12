package cn.damai.ticklet.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import cn.damai.common.user.b;
import cn.damai.common.user.c;
import cn.damai.member.R$drawable;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.member.R$styleable;
import cn.damai.ticklet.bean.TicketEventCodeBean;
import cn.damai.ticklet.ui.activity.TicketDeatilActivity;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;
import tb.cb1;
import tb.in2;
import tb.nb2;
import tb.py2;
import tb.q60;
import tb.rz0;
import tb.un2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TickletDetailEventCodeView extends ConstraintLayout implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private TicketEventCodeBean codeBean;
    Context context;
    private ImageView downArrow;
    private TextView eventCodeCopy;
    private TextView eventCodeNum;
    private DMIconFontTextView eventCodeTipIcon;
    private TextView eventCodeTitle;
    private DMIconFontTextView iconArrow;
    private Map<String, String> map;
    View parent;
    private String performId;
    private TextView popText;
    private View popWindowView;
    int popupHeight;
    int popupWidth;
    private PopupWindow popupWindow;
    private String projectId;
    private ImageView upArrow;
    private String viewType;
    float xloc;
    float ylocArrow;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-36095054")) {
                ipChange.ipc$dispatch("-36095054", new Object[]{this});
                return;
            }
            TickletDetailEventCodeView.this.popText.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            TickletDetailEventCodeView tickletDetailEventCodeView = TickletDetailEventCodeView.this;
            tickletDetailEventCodeView.popupWidth = tickletDetailEventCodeView.popWindowView.getMeasuredWidth();
            TickletDetailEventCodeView tickletDetailEventCodeView2 = TickletDetailEventCodeView.this;
            tickletDetailEventCodeView2.popupHeight = tickletDetailEventCodeView2.popWindowView.getMeasuredHeight();
            cb1.b("TickletDetailEventCodeView", "addOnGlobalLayoutListener.getHeight = " + TickletDetailEventCodeView.this.popWindowView.getMeasuredHeight());
            cb1.b("TickletDetailEventCodeView", "addOnGlobalLayoutListener.width = " + TickletDetailEventCodeView.this.popWindowView.getMeasuredWidth());
            TickletDetailEventCodeView.this.popupWindow.dismiss();
            PopupWindow popupWindow = TickletDetailEventCodeView.this.popupWindow;
            ImageView imageView = TickletDetailEventCodeView.this.downArrow;
            TickletDetailEventCodeView tickletDetailEventCodeView3 = TickletDetailEventCodeView.this;
            popupWindow.showAtLocation(imageView, 0, (int) tickletDetailEventCodeView3.xloc, tickletDetailEventCodeView3.popWindowYCal(tickletDetailEventCodeView3.ylocArrow));
        }
    }

    public TickletDetailEventCodeView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downArrow(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1627838625")) {
            ipChange.ipc$dispatch("1627838625", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            if (this.downArrow.getVisibility() != 0) {
                this.downArrow.setVisibility(0);
            }
        } else if (this.downArrow.getVisibility() != 4) {
            this.downArrow.setVisibility(4);
        }
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "605366235")) {
            ipChange.ipc$dispatch("605366235", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.context).inflate(R$layout.ticklet_detail_event_code_layout, this);
        this.parent = inflate;
        this.eventCodeTitle = (TextView) inflate.findViewById(R$id.ticklet_detail_event_code_title);
        this.eventCodeNum = (TextView) this.parent.findViewById(R$id.ticklet_detail_event_code_num);
        this.eventCodeCopy = (TextView) this.parent.findViewById(R$id.ticklet_detail_event_code_copy);
        this.eventCodeTipIcon = (DMIconFontTextView) this.parent.findViewById(R$id.ticklet_detail_event_code_tip_icon);
        this.iconArrow = (DMIconFontTextView) this.parent.findViewById(R$id.tiklet_detail_event_code_icon_arrow);
        this.downArrow = (ImageView) this.parent.findViewById(R$id.ticklet_down_code_arrow);
        this.upArrow = (ImageView) this.parent.findViewById(R$id.ticklet_down_code_arrow_bottom);
        popWindowInit();
        this.eventCodeTipIcon.setOnClickListener(this);
        this.eventCodeTitle.setOnClickListener(this);
        this.eventCodeCopy.setOnClickListener(this);
        this.iconArrow.setOnClickListener(this);
    }

    private void popWindowInit() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1891553271")) {
            ipChange.ipc$dispatch("-1891553271", new Object[]{this});
            return;
        }
        View inflate = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(R$layout.ticklet_detail_pop_layout, (ViewGroup) null, false);
        this.popWindowView = inflate;
        this.popText = (TextView) inflate.findViewById(R$id.ticklet_detail_pop_tip_content);
        PopupWindow popupWindow = new PopupWindow(this.popWindowView, -2, -2, true);
        this.popupWindow = popupWindow;
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: cn.damai.ticklet.view.TickletDetailEventCodeView.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "516966530")) {
                    ipChange2.ipc$dispatch("516966530", new Object[]{this});
                    return;
                }
                TickletDetailEventCodeView.this.downArrow(false);
                TickletDetailEventCodeView.this.upArrow(false);
            }
        });
        this.popText.getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int popWindowYCal(float f) {
        int i;
        int i2;
        float f2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-432762417")) {
            return ((Integer) ipChange.ipc$dispatch("-432762417", new Object[]{this, Float.valueOf(f)})).intValue();
        }
        Context context = this.context;
        if (context == null || !(context instanceof TicketDeatilActivity)) {
            i = 0;
            i2 = 0;
        } else {
            i = ((TicketDeatilActivity) context).getBarStatusBarHeight();
            i2 = ((TicketDeatilActivity) this.context).getTitleHeight();
        }
        if ((f - i) - i2 < this.popupHeight) {
            upArrow(true);
            downArrow(false);
            int[] iArr = new int[2];
            this.upArrow.getLocationOnScreen(iArr);
            int i3 = iArr[0];
            f2 = iArr[1] + q60.a(this.context, 6.0f);
        } else {
            upArrow(false);
            downArrow(true);
            f2 = f - this.popupHeight;
        }
        cb1.b("TickletDetailEventCodeView", "yloc = " + f2);
        return (int) f2;
    }

    private void showPop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1007799002")) {
            ipChange.ipc$dispatch("-1007799002", new Object[]{this});
            return;
        }
        this.popWindowView.measure(0, 0);
        this.popupWidth = this.popWindowView.getMeasuredWidth();
        int a2 = q60.a(this.context, 6.0f);
        cb1.b("TickletDetailEventCodeView", "popupWidth = " + this.popupWidth);
        cb1.b("TickletDetailEventCodeView", "popupHeight = " + this.popupHeight);
        int i = DisplayMetrics.getwidthPixels(q60.b(this.context));
        int a3 = q60.a(this.context, 15.0f);
        int i2 = i - (a3 * 2);
        int i3 = this.popupWidth;
        if (i3 > i2) {
            this.popupWindow.setWidth(i2);
            this.popupWidth = i2;
        } else {
            this.popupWindow.setWidth(i3);
        }
        int[] iArr = new int[2];
        this.downArrow.getLocationOnScreen(iArr);
        float f = iArr[1];
        float f2 = iArr[0];
        this.xloc = f2;
        this.ylocArrow = f;
        if (f2 >= i / 2) {
            int i4 = this.popupWidth;
            if ((i - a3) - f2 >= i4 / 2) {
                this.xloc = (f2 - (i4 / 2)) + a2;
            } else {
                this.xloc = (f2 - (i4 / 2)) - ((i4 / 2) - ((i - f2) - a3));
            }
        } else {
            float f3 = a3;
            int i5 = this.popupWidth;
            if (f2 - f3 >= i5 / 2) {
                this.xloc = (f2 - (i5 / 2)) + a2;
            } else {
                this.xloc = f3;
            }
        }
        cb1.b("TickletDetailEventCodeView", "xloc = " + this.xloc);
        cb1.b("TickletDetailEventCodeView", "y = " + f);
        this.popupWindow.showAtLocation(this.downArrow, 0, (int) this.xloc, popWindowYCal(f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void upArrow(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-516767352")) {
            ipChange.ipc$dispatch("-516767352", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            if (this.upArrow.getVisibility() != 0) {
                this.upArrow.setVisibility(0);
            }
        } else if (this.upArrow.getVisibility() != 4) {
            this.upArrow.setVisibility(4);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "763769089")) {
            ipChange.ipc$dispatch("763769089", new Object[]{this, view});
        } else if (view.getId() == R$id.ticklet_detail_event_code_copy) {
            Context context = this.context;
            if (context != null) {
                nb2.b(context, this.codeBean.code, "券码已复制至剪切板");
                c.e().x(b.getInstance().e(un2.TICKLET_DETAIL_PAGE, "thirdcode", rz0.ARG_COPY, un2.k().t(this.projectId, this.performId), Boolean.FALSE));
            }
        } else if (view.getId() == R$id.tiklet_detail_event_code_icon_arrow) {
            py2.f().n(this.context, this.codeBean.schema);
            c.e().x(b.getInstance().e(un2.TICKLET_DETAIL_PAGE, "thirdcode", "open", un2.k().t(this.projectId, this.performId), Boolean.FALSE));
        } else if ((view.getId() == R$id.ticklet_detail_event_code_tip_icon || view.getId() == R$id.ticklet_detail_event_code_title) && !TextUtils.isEmpty(this.codeBean.description)) {
            showPop();
            c.e().x(b.getInstance().e(un2.TICKLET_DETAIL_PAGE, "thirdcode", "info", un2.k().t(this.projectId, this.performId), Boolean.FALSE));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0100, code lost:
        if (r15.equals("3") == false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void update(cn.damai.ticklet.bean.TicketEventCodeBean r14, java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 376
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.ticklet.view.TickletDetailEventCodeView.update(cn.damai.ticklet.bean.TicketEventCodeBean, java.lang.String):void");
    }

    public TickletDetailEventCodeView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TickletDetailEventCodeView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.map = new HashMap();
        this.viewType = "DEFAULT";
        this.popupWidth = 0;
        this.popupHeight = 0;
        this.xloc = 0.0f;
        this.ylocArrow = 0.0f;
        this.context = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ViewType);
        if (obtainStyledAttributes != null) {
            this.viewType = obtainStyledAttributes.getString(R$styleable.ViewType_view_type);
            obtainStyledAttributes.recycle();
        }
        if (in2.TICKLET_TICKET_VIEW_DETAIL_NFT.equals(this.viewType)) {
            setBackgroundResource(R$drawable.shape_solid_all_radius8_white);
        } else {
            setBackgroundResource(R$drawable.shape_solid_all_radius8_f5f5f5);
        }
        initView();
    }
}
