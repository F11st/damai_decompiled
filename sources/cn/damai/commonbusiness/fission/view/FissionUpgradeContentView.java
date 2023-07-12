package cn.damai.commonbusiness.fission.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.fission.bean.FissionInfoBean;
import cn.damai.commonbusiness.fission.bean.FissionParam;
import cn.damai.commonbusiness.qrcode.util.QrcodeUtil;
import cn.damai.commonbusiness.share.generateimage.GenerateImageUtil;
import cn.damai.uikit.view.RoundImageView;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.net.URLEncoder;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class FissionUpgradeContentView extends ConstraintLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView cb_user_name;
    private TextView chickenSoup;
    private Context context;
    private int count;
    private TextView fission_upgrade_name;
    private ImageView fission_upgrade_qrcode;
    private TextView fission_upgrade_seat;
    private ImageView fission_upgrade_sep_line;
    private TextView fission_upgrade_time;
    private TextView fission_upgrade_venue;
    private int margin;
    private View partent;
    private ImageView projectImage;
    private RoundImageView userImage;
    private ViewInterface viewImp;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public interface ViewInterface {
        void showView();
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.fission.view.FissionUpgradeContentView$a */
    /* loaded from: classes4.dex */
    public class C0709a implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ FissionInfoBean a;
        final /* synthetic */ FissionParam b;
        final /* synthetic */ String c;

        C0709a(FissionInfoBean fissionInfoBean, FissionParam fissionParam, String str) {
            this.a = fissionInfoBean;
            this.b = fissionParam;
            this.c = str;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.C0501d c0501d) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "196518549")) {
                ipChange.ipc$dispatch("196518549", new Object[]{this, c0501d});
                return;
            }
            FissionUpgradeContentView.this.bgDefault();
            FissionUpgradeContentView.this.viewUpdate(this.a, this.b, this.c);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.fission.view.FissionUpgradeContentView$b */
    /* loaded from: classes4.dex */
    public class C0710b implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ FissionInfoBean a;
        final /* synthetic */ FissionParam b;
        final /* synthetic */ String c;

        C0710b(FissionInfoBean fissionInfoBean, FissionParam fissionParam, String str) {
            this.a = fissionInfoBean;
            this.b = fissionParam;
            this.c = str;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.C0502e c0502e) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1993969770")) {
                ipChange.ipc$dispatch("1993969770", new Object[]{this, c0502e});
                return;
            }
            Bitmap bitmap = c0502e.b;
            if (bitmap == null) {
                FissionUpgradeContentView.this.bgDefault();
            } else {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                if (Build.VERSION.SDK_INT >= 16) {
                    FissionUpgradeContentView.this.partent.setBackground(bitmapDrawable);
                } else {
                    FissionUpgradeContentView.this.partent.setBackgroundDrawable(bitmapDrawable);
                }
            }
            FissionUpgradeContentView.this.viewUpdate(this.a, this.b, this.c);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.fission.view.FissionUpgradeContentView$c */
    /* loaded from: classes4.dex */
    public class C0711c implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ FissionInfoBean a;
        final /* synthetic */ FissionParam b;
        final /* synthetic */ String c;

        C0711c(FissionInfoBean fissionInfoBean, FissionParam fissionParam, String str) {
            this.a = fissionInfoBean;
            this.b = fissionParam;
            this.c = str;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.C0501d c0501d) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2136874089")) {
                ipChange.ipc$dispatch("-2136874089", new Object[]{this, c0501d});
                return;
            }
            FissionUpgradeContentView fissionUpgradeContentView = FissionUpgradeContentView.this;
            fissionUpgradeContentView.setBgAndView(fissionUpgradeContentView.projectImage, R$drawable.uikit_default_image_rightangle_bg_grey, this.a, this.b, this.c);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.fission.view.FissionUpgradeContentView$d */
    /* loaded from: classes4.dex */
    public class C0712d implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ FissionInfoBean a;
        final /* synthetic */ FissionParam b;
        final /* synthetic */ String c;

        C0712d(FissionInfoBean fissionInfoBean, FissionParam fissionParam, String str) {
            this.a = fissionInfoBean;
            this.b = fissionParam;
            this.c = str;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.C0502e c0502e) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "777816044")) {
                ipChange.ipc$dispatch("777816044", new Object[]{this, c0502e});
                return;
            }
            Bitmap bitmap = c0502e.b;
            if (bitmap == null) {
                FissionUpgradeContentView.this.projectImage.setImageResource(R$drawable.uikit_default_image_rightangle_bg_grey);
            } else {
                FissionUpgradeContentView.this.projectImage.setImageBitmap(bitmap);
            }
            FissionUpgradeContentView.this.viewUpdate(this.a, this.b, this.c);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.fission.view.FissionUpgradeContentView$e */
    /* loaded from: classes4.dex */
    public class C0713e implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ FissionInfoBean a;
        final /* synthetic */ FissionParam b;
        final /* synthetic */ String c;

        C0713e(FissionInfoBean fissionInfoBean, FissionParam fissionParam, String str) {
            this.a = fissionInfoBean;
            this.b = fissionParam;
            this.c = str;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.C0501d c0501d) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-175299431")) {
                ipChange.ipc$dispatch("-175299431", new Object[]{this, c0501d});
                return;
            }
            FissionUpgradeContentView fissionUpgradeContentView = FissionUpgradeContentView.this;
            fissionUpgradeContentView.setBgAndView(fissionUpgradeContentView.userImage, R$drawable.uikit_user_default_icon, this.a, this.b, this.c);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.fission.view.FissionUpgradeContentView$f */
    /* loaded from: classes4.dex */
    public class C0714f implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ FissionInfoBean a;
        final /* synthetic */ FissionParam b;
        final /* synthetic */ String c;

        C0714f(FissionInfoBean fissionInfoBean, FissionParam fissionParam, String str) {
            this.a = fissionInfoBean;
            this.b = fissionParam;
            this.c = str;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.C0502e c0502e) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-438337682")) {
                ipChange.ipc$dispatch("-438337682", new Object[]{this, c0502e});
                return;
            }
            Bitmap bitmap = c0502e.b;
            if (bitmap == null) {
                FissionUpgradeContentView.this.userImage.setImageResource(R$drawable.uikit_user_default_icon);
            } else {
                FissionUpgradeContentView.this.userImage.setImageBitmap(bitmap);
            }
            FissionUpgradeContentView.this.viewUpdate(this.a, this.b, this.c);
        }
    }

    public FissionUpgradeContentView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgDefault() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "717228233")) {
            ipChange.ipc$dispatch("717228233", new Object[]{this});
        } else {
            this.partent.setBackgroundResource(R$drawable.uikit_default_image_bg_grey);
        }
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1316077680")) {
            ipChange.ipc$dispatch("1316077680", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.context).inflate(R$layout.commonbusiness_fission_upgrade_large_view, this);
        this.partent = inflate;
        this.projectImage = (ImageView) inflate.findViewById(R$id.fission_upgrade_image);
        this.fission_upgrade_sep_line = (ImageView) this.partent.findViewById(R$id.fission_upgrade_sep_line);
        this.fission_upgrade_name = (TextView) this.partent.findViewById(R$id.fission_upgrade_name);
        this.fission_upgrade_time = (TextView) this.partent.findViewById(R$id.fission_upgrade_time);
        this.fission_upgrade_seat = (TextView) this.partent.findViewById(R$id.fission_upgrade_seat);
        this.userImage = (RoundImageView) this.partent.findViewById(R$id.fission_upgrade_user_image);
        this.cb_user_name = (TextView) this.partent.findViewById(R$id.fission_upgrade_user_name);
        this.chickenSoup = (TextView) this.partent.findViewById(R$id.fission_upgrade_chickensoup);
        this.fission_upgrade_venue = (TextView) this.partent.findViewById(R$id.fission_upgrade_venue);
        this.fission_upgrade_qrcode = (ImageView) this.partent.findViewById(R$id.fission_upgrade_qrcode);
    }

    private void qrCode(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "301982390")) {
            ipChange.ipc$dispatch("301982390", new Object[]{this, Integer.valueOf(i), str});
            return;
        }
        int a = t60.a(this.context, i);
        this.fission_upgrade_qrcode.setVisibility(0);
        Bitmap decodeResource = BitmapFactory.decodeResource(this.context.getResources(), R$drawable.damai_small_logo);
        this.fission_upgrade_qrcode.setImageBitmap(QrcodeUtil.b(a, GenerateImageUtil.SHARE_URL + URLEncoder.encode(str), decodeResource));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBgAndView(ImageView imageView, int i, FissionInfoBean fissionInfoBean, FissionParam fissionParam, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1453070278")) {
            ipChange.ipc$dispatch("1453070278", new Object[]{this, imageView, Integer.valueOf(i), fissionInfoBean, fissionParam, str});
            return;
        }
        imageView.setImageResource(i);
        viewUpdate(fissionInfoBean, fissionParam, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void viewUpdate(FissionInfoBean fissionInfoBean, FissionParam fissionParam, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2076547512")) {
            ipChange.ipc$dispatch("-2076547512", new Object[]{this, fissionInfoBean, fissionParam, str});
            return;
        }
        int i = this.count + 1;
        this.count = i;
        if (i < 3) {
            return;
        }
        viewVisible(this.fission_upgrade_name, fissionParam.projectName);
        viewVisible(this.fission_upgrade_time, fissionParam.subMessage);
        FissionInfoBean.UserInfo userInfo = fissionInfoBean.userInfo;
        String str2 = (userInfo == null || TextUtils.isEmpty(userInfo.nickname)) ? "大麦" : fissionInfoBean.userInfo.nickname;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2 + " 说:");
        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#9C9CA5")), spannableStringBuilder.length() - 2, spannableStringBuilder.length(), 33);
        this.cb_user_name.setVisibility(0);
        this.cb_user_name.setText(spannableStringBuilder);
        FissionInfoBean.ActivityInfo activityInfo = fissionInfoBean.shareInfo;
        if (activityInfo != null) {
            viewVisible(this.chickenSoup, activityInfo.chickenSoup);
            viewVisible(this.fission_upgrade_seat, fissionInfoBean.shareInfo.seatInfo);
            viewVisible(this.fission_upgrade_venue, fissionInfoBean.shareInfo.venue);
        }
        if (!TextUtils.isEmpty(str)) {
            qrCode(90, str);
        }
        ViewInterface viewInterface = this.viewImp;
        if (viewInterface != null) {
            viewInterface.showView();
        }
    }

    private void viewVisible(TextView textView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1156892490")) {
            ipChange.ipc$dispatch("-1156892490", new Object[]{this, textView, str});
        } else if (!TextUtils.isEmpty(str)) {
            if (textView.getVisibility() == 8) {
                textView.setVisibility(0);
            }
            textView.setText(str);
        } else if (textView.getVisibility() == 0) {
            textView.setVisibility(8);
        }
    }

    public void setViewImp(ViewInterface viewInterface) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "436561135")) {
            ipChange.ipc$dispatch("436561135", new Object[]{this, viewInterface});
        } else {
            this.viewImp = viewInterface;
        }
    }

    public void update(FissionInfoBean fissionInfoBean, FissionParam fissionParam, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "573696515")) {
            ipChange.ipc$dispatch("573696515", new Object[]{this, fissionInfoBean, fissionParam, str});
        } else if (fissionInfoBean == null || fissionParam == null) {
        } else {
            C0504a.b().h(this.context).c(fissionInfoBean.shareInfo.bgImageUrl).n(new C0710b(fissionInfoBean, fissionParam, str)).e(new C0709a(fissionInfoBean, fissionParam, str)).f();
            int a = DisplayMetrics.getwidthPixels(t60.b(this.context)) - (t60.a(this.context, this.margin) * 2);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.projectImage.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams).width = a;
            ((ViewGroup.MarginLayoutParams) layoutParams).height = (a * 4) / 3;
            C0504a.b().h(this.context).c(fissionParam.imageUrl).n(new C0712d(fissionInfoBean, fissionParam, str)).e(new C0711c(fissionInfoBean, fissionParam, str)).f();
            FissionInfoBean.UserInfo userInfo = fissionInfoBean.userInfo;
            if (userInfo != null && !TextUtils.isEmpty(userInfo.portraitUrl)) {
                C0504a.b().h(this.context).c(fissionInfoBean.userInfo.portraitUrl).n(new C0714f(fissionInfoBean, fissionParam, str)).e(new C0713e(fissionInfoBean, fissionParam, str)).f();
            } else {
                setBgAndView(this.userImage, R$drawable.uikit_user_default_icon, fissionInfoBean, fissionParam, str);
            }
        }
    }

    public FissionUpgradeContentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FissionUpgradeContentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.margin = 15;
        this.count = 0;
        this.context = context;
        setPadding(t60.a(context, 15), t60.a(context, this.margin), t60.a(context, this.margin), t60.a(context, 43.0f));
        initView();
    }
}
