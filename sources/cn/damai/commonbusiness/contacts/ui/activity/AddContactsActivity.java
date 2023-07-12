package cn.damai.commonbusiness.contacts.ui.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.ReplacementTransformationMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import cn.damai.common.app.widget.BubbleDialog;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.C0529c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$anim;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.R$string;
import cn.damai.commonbusiness.R$style;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.contacts.bean.AddContactsBean;
import cn.damai.commonbusiness.contacts.bean.CustomerType;
import cn.damai.commonbusiness.contacts.bean.IdCardTypes;
import cn.damai.commonbusiness.contacts.bean.InputField;
import cn.damai.commonbusiness.contacts.bean.QueryCardTypeBean;
import cn.damai.commonbusiness.contacts.net.AddCustomerRequest;
import cn.damai.commonbusiness.contacts.net.QueryCardTypeRequest;
import cn.damai.commonbusiness.contacts.ui.view.AddContactDoubleCheckView;
import cn.damai.commonbusiness.contacts.ui.view.WheelView;
import cn.damai.commonbusiness.contacts.view.RealNameTipView;
import cn.damai.login.LoginManager;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.view.DMLabelType;
import cn.damai.uikit.view.DMLabelView;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.purchase.core.utils.PurchaseConstants;
import com.youku.upsplayer.util.YKUpsConvert;
import java.util.ArrayList;
import java.util.List;
import tb.cm2;
import tb.cs;
import tb.e80;
import tb.kn;
import tb.ln;
import tb.pl;
import tb.qb1;
import tb.t60;
import tb.wh2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class AddContactsActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    private String dialogTipInfo;
    private int lastTypePsoition;
    private View mAddContactsIdcardLine;
    private RelativeLayout mAddContactsRenewalLayout;
    private ImageView mBackIcon;
    private String mBundleName;
    private List<CustomerType> mCardTypeInfo;
    private ClickableSpan mClickableSpan;
    private TextWatcher mContactIdCardNumTextWatcher;
    private TextWatcher mContactNameTextWatcher;
    private TextWatcher mContactRenewalNumTextWatcher;
    private View mContainer;
    private int mCurrentTypePosition;
    private List<IdCardTypes> mDatas;
    private DMDialog mErrorTipDialog;
    private String mIdCardNo;
    private TextView mIdCardNumberTv;
    private TextView mIdTypeBtn;
    private DMIconFontTextView mIdTypeMoreBtn;
    private List<String> mIdTypeNames;
    private EditText mInputRenewalNumber;
    private EditText mInputUserIdNumber;
    private EditText mInputUserName;
    private DMIconFontTextView mIvClearContactIdCardNum;
    private DMIconFontTextView mIvClearContactName;
    private DMIconFontTextView mIvClearRenewalNum;
    private TextView mNameTv;
    private C0626n mNormalTransform;
    private View.OnClickListener mOnClearContactIdCardNumClickListener;
    private View.OnClickListener mOnClearContactNameClickListener;
    private View.OnClickListener mOnClearRenewalNumClickListener;
    private View mProgressBar;
    private boolean mRemindLimit;
    private String mRenewalNo;
    private TextView mRenewalNumberTv;
    private DMLabelView mSaveBtn;
    private TextView mTitle;
    private C0627o mUpperCaseTransform;
    private String mUserName;
    private WindowManager mWindowManager;
    private RealNameTipView notice;
    private boolean mProgressBarIsShowing = false;
    private final String mProtocolStr = "请您认真阅读并同意《实名须知》的全部条款，接受后可开始使用我们的服务";
    private final int mProtocolStart = 9;
    private final int mProtocolEnd = 15;
    private long doubleCheckExposureStr = 0;
    private DialogInterface.OnClickListener mDialogOnClickListener = new DialogInterface$OnClickListenerC0614b();
    private Handler mHandler = new HandlerC0615c();
    private WheelView.C0631b OnWheelViewListener = new C0616d();
    private View.OnTouchListener mOnTouchListener = new View$OnTouchListenerC0617e();

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.contacts.ui.activity.AddContactsActivity$a */
    /* loaded from: classes14.dex */
    public class DialogInterface$OnClickListenerC0613a implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        DialogInterface$OnClickListenerC0613a(AddContactsActivity addContactsActivity, String str) {
            this.a = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1737167689")) {
                ipChange.ipc$dispatch("1737167689", new Object[]{this, dialogInterface, Integer.valueOf(i)});
            } else {
                C0529c.e().x(kn.j().h(this.a));
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.contacts.ui.activity.AddContactsActivity$b */
    /* loaded from: classes14.dex */
    public class DialogInterface$OnClickListenerC0614b implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        DialogInterface$OnClickListenerC0614b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-618637561")) {
                ipChange.ipc$dispatch("-618637561", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            dialogInterface.dismiss();
            if (AddContactsActivity.this.mRemindLimit) {
                AddContactsActivity.this.finish();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.contacts.ui.activity.AddContactsActivity$c */
    /* loaded from: classes14.dex */
    public class HandlerC0615c extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;

        HandlerC0615c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-997885882")) {
                ipChange.ipc$dispatch("-997885882", new Object[]{this, message});
                return;
            }
            super.handleMessage(message);
            CustomerType customerType = (CustomerType) AddContactsActivity.this.mIdTypeBtn.getTag();
            if (customerType == null) {
                customerType = wh2.e(AddContactsActivity.this.mCardTypeInfo) > 0 ? (CustomerType) AddContactsActivity.this.mCardTypeInfo.get(0) : null;
                AddContactsActivity.this.mIdTypeBtn.setTag(customerType);
            }
            if (customerType != null) {
                AddContactsActivity.this.upDateView(customerType);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.contacts.ui.activity.AddContactsActivity$d */
    /* loaded from: classes4.dex */
    public class C0616d extends WheelView.C0631b {
        private static transient /* synthetic */ IpChange $ipChange;

        C0616d() {
        }

        @Override // cn.damai.commonbusiness.contacts.ui.view.WheelView.C0631b
        public void a(int i, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1416192270")) {
                ipChange.ipc$dispatch("1416192270", new Object[]{this, Integer.valueOf(i), str});
                return;
            }
            super.a(i, str);
            int i2 = i - 1;
            AddContactsActivity.this.mCurrentTypePosition = i2;
            AddContactsActivity.this.mIdTypeBtn.setTag(AddContactsActivity.this.mCardTypeInfo.get(i2));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.contacts.ui.activity.AddContactsActivity$e */
    /* loaded from: classes14.dex */
    public class View$OnTouchListenerC0617e implements View.OnTouchListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnTouchListenerC0617e() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1692224123")) {
                return ((Boolean) ipChange.ipc$dispatch("1692224123", new Object[]{this, view, motionEvent})).booleanValue();
            }
            if (motionEvent.getAction() == 0 && AddContactsActivity.this.mProgressBarIsShowing) {
                AddContactsActivity.this.hideProgressBar();
                return true;
            }
            return false;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.contacts.ui.activity.AddContactsActivity$f */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC0618f implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0618f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-160998465")) {
                ipChange.ipc$dispatch("-160998465", new Object[]{this, view});
            } else {
                AddContactsActivity.this.mInputUserName.setText("");
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.contacts.ui.activity.AddContactsActivity$g */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC0619g implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0619g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1950291904")) {
                ipChange.ipc$dispatch("1950291904", new Object[]{this, view});
            } else {
                AddContactsActivity.this.mInputUserIdNumber.setText("");
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.contacts.ui.activity.AddContactsActivity$h */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC0620h implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0620h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-233385023")) {
                ipChange.ipc$dispatch("-233385023", new Object[]{this, view});
            } else {
                AddContactsActivity.this.mInputRenewalNumber.setText("");
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.contacts.ui.activity.AddContactsActivity$i */
    /* loaded from: classes14.dex */
    public class C0621i implements TextWatcher {
        private static transient /* synthetic */ IpChange $ipChange;

        C0621i() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "908197205")) {
                ipChange.ipc$dispatch("908197205", new Object[]{this, editable});
            } else if (editable.length() > 0) {
                AddContactsActivity.this.mIvClearContactName.setVisibility(0);
            } else {
                AddContactsActivity.this.mIvClearContactName.setVisibility(4);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1636447218")) {
                ipChange.ipc$dispatch("-1636447218", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-875317330")) {
                ipChange.ipc$dispatch("-875317330", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.contacts.ui.activity.AddContactsActivity$j */
    /* loaded from: classes14.dex */
    public class C0622j implements TextWatcher {
        private static transient /* synthetic */ IpChange $ipChange;

        C0622j() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-275150092")) {
                ipChange.ipc$dispatch("-275150092", new Object[]{this, editable});
            } else if (editable.length() > 0) {
                AddContactsActivity.this.mIvClearContactIdCardNum.setVisibility(0);
            } else {
                AddContactsActivity.this.mIvClearContactIdCardNum.setVisibility(4);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-503256625")) {
                ipChange.ipc$dispatch("-503256625", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1095622127")) {
                ipChange.ipc$dispatch("1095622127", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.contacts.ui.activity.AddContactsActivity$k */
    /* loaded from: classes14.dex */
    public class C0623k implements TextWatcher {
        private static transient /* synthetic */ IpChange $ipChange;

        C0623k() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1458497389")) {
                ipChange.ipc$dispatch("-1458497389", new Object[]{this, editable});
            } else if (editable.length() > 0) {
                AddContactsActivity.this.mIvClearRenewalNum.setVisibility(0);
            } else {
                AddContactsActivity.this.mIvClearRenewalNum.setVisibility(4);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "629933968")) {
                ipChange.ipc$dispatch("629933968", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1228405712")) {
                ipChange.ipc$dispatch("-1228405712", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.contacts.ui.activity.AddContactsActivity$l */
    /* loaded from: classes14.dex */
    public class C0624l extends ClickableSpan {
        private static transient /* synthetic */ IpChange $ipChange;

        C0624l() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-378158139")) {
                ipChange.ipc$dispatch("-378158139", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("url", "https://m.damai.cn/damai/mine/audience-notice/index.html");
            DMNav.from(AddContactsActivity.this).withExtras(bundle).toUri(NavUri.b(cs.t));
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1536725486")) {
                ipChange.ipc$dispatch("-1536725486", new Object[]{this, textPaint});
                return;
            }
            super.updateDrawState(textPaint);
            textPaint.setColor(Color.parseColor("#ff1268"));
            textPaint.setUnderlineText(false);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.contacts.ui.activity.AddContactsActivity$m */
    /* loaded from: classes14.dex */
    public class DialogInterface$OnClickListenerC0625m implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        DialogInterface$OnClickListenerC0625m(String str) {
            this.a = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1003641833")) {
                ipChange.ipc$dispatch("1003641833", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            C0529c.e().x(kn.j().i(this.a));
            kn.f(System.currentTimeMillis() - AddContactsActivity.this.doubleCheckExposureStr, this.a);
            AddContactsActivity.this.requestAddCustomer(this.a);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.contacts.ui.activity.AddContactsActivity$n */
    /* loaded from: classes14.dex */
    public class C0626n extends ReplacementTransformationMethod {
        private static transient /* synthetic */ IpChange $ipChange;
        private char[] a = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', YKUpsConvert.CHAR_A, 'B', 'C', qb1.LEVEL_D, qb1.LEVEL_E, YKUpsConvert.CHAR_F, 'G', 'H', qb1.LEVEL_I, 'J', 'K', qb1.LEVEL_L, 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', qb1.LEVEL_V, qb1.LEVEL_W, 'X', 'Y', 'Z'};

        C0626n(AddContactsActivity addContactsActivity) {
        }

        @Override // android.text.method.ReplacementTransformationMethod
        protected char[] getOriginal() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-526019620") ? (char[]) ipChange.ipc$dispatch("-526019620", new Object[]{this}) : this.a;
        }

        @Override // android.text.method.ReplacementTransformationMethod
        protected char[] getReplacement() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1247976281") ? (char[]) ipChange.ipc$dispatch("1247976281", new Object[]{this}) : this.a;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.contacts.ui.activity.AddContactsActivity$o */
    /* loaded from: classes14.dex */
    public class C0627o extends ReplacementTransformationMethod {
        private static transient /* synthetic */ IpChange $ipChange;
        private char[] a = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        private char[] b = {YKUpsConvert.CHAR_A, 'B', 'C', qb1.LEVEL_D, qb1.LEVEL_E, YKUpsConvert.CHAR_F, 'G', 'H', qb1.LEVEL_I, 'J', 'K', qb1.LEVEL_L, 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', qb1.LEVEL_V, qb1.LEVEL_W, 'X', 'Y', 'Z'};

        C0627o(AddContactsActivity addContactsActivity) {
        }

        @Override // android.text.method.ReplacementTransformationMethod
        protected char[] getOriginal() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "923289259") ? (char[]) ipChange.ipc$dispatch("923289259", new Object[]{this}) : this.a;
        }

        @Override // android.text.method.ReplacementTransformationMethod
        protected char[] getReplacement() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "302563882") ? (char[]) ipChange.ipc$dispatch("302563882", new Object[]{this}) : this.b;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.contacts.ui.activity.AddContactsActivity$p */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC0628p implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private Dialog a;

        public View$OnClickListenerC0628p(Dialog dialog) {
            this.a = dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "472600360")) {
                ipChange.ipc$dispatch("472600360", new Object[]{this, view});
                return;
            }
            int id = view.getId();
            if (id == R$id.add_contacts_cancel_btn) {
                Dialog dialog = this.a;
                if (dialog != null) {
                    dialog.dismiss();
                }
            } else if (id == R$id.add_contacts_confirm_btn) {
                if (AddContactsActivity.this.lastTypePsoition != AddContactsActivity.this.mCurrentTypePosition) {
                    AddContactsActivity.this.mHandler.sendEmptyMessage(0);
                }
                Dialog dialog2 = this.a;
                if (dialog2 != null) {
                    dialog2.dismiss();
                }
            }
        }
    }

    private List<AddContactDoubleCheckView.C0629a> getCurrentInput() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1913688260")) {
            return (List) ipChange.ipc$dispatch("1913688260", new Object[]{this});
        }
        ArrayList arrayList = new ArrayList();
        AddContactDoubleCheckView.C0629a c0629a = new AddContactDoubleCheckView.C0629a();
        c0629a.b(this.mNameTv.getText().toString());
        c0629a.a(this.mInputUserName.getText().toString());
        arrayList.add(c0629a);
        AddContactDoubleCheckView.C0629a c0629a2 = new AddContactDoubleCheckView.C0629a();
        c0629a2.b(getString(R$string.add_contacts_id_card_type_tetxt));
        c0629a2.a(this.mIdTypeBtn.getText().toString());
        arrayList.add(c0629a2);
        AddContactDoubleCheckView.C0629a c0629a3 = new AddContactDoubleCheckView.C0629a();
        c0629a3.b(this.mIdCardNumberTv.getText().toString());
        c0629a3.a(this.mInputUserIdNumber.getText().toString());
        arrayList.add(c0629a3);
        if (this.mAddContactsRenewalLayout.getVisibility() == 0) {
            AddContactDoubleCheckView.C0629a c0629a4 = new AddContactDoubleCheckView.C0629a();
            c0629a4.b(this.mRenewalNumberTv.getText().toString());
            c0629a4.a(this.mInputRenewalNumber.getText().toString());
            arrayList.add(c0629a4);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideProgressBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1665024442")) {
            ipChange.ipc$dispatch("-1665024442", new Object[]{this});
        } else if (this.mWindowManager == null || this.mProgressBar == null || !this.mProgressBarIsShowing) {
        } else {
            this.mProgressBarIsShowing = false;
            getWindowManager().removeView(this.mProgressBar);
        }
    }

    private void initListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "253080731")) {
            ipChange.ipc$dispatch("253080731", new Object[]{this});
            return;
        }
        this.mOnClearContactNameClickListener = new View$OnClickListenerC0618f();
        this.mOnClearContactIdCardNumClickListener = new View$OnClickListenerC0619g();
        this.mOnClearRenewalNumClickListener = new View$OnClickListenerC0620h();
        this.mContactNameTextWatcher = new C0621i();
        this.mContactIdCardNumTextWatcher = new C0622j();
        this.mContactRenewalNumTextWatcher = new C0623k();
        this.mClickableSpan = new C0624l();
    }

    private void requestAddContacts() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1839485477")) {
            ipChange.ipc$dispatch("-1839485477", new Object[]{this});
            return;
        }
        this.mUserName = this.mInputUserName.getText().toString().trim();
        CustomerType customerType = (CustomerType) this.mIdTypeBtn.getTag();
        this.mIdCardNo = this.mInputUserIdNumber.getText().toString().trim();
        this.mRenewalNo = this.mInputRenewalNumber.getText().toString().trim();
        if (TextUtils.isEmpty(this.mUserName)) {
            ToastUtil.a().e(this, "请输入观演人姓名");
        } else if (customerType != null && customerType.getIdentityCode() != -1) {
            if (TextUtils.isEmpty(this.mIdCardNo)) {
                ToastUtil.a().e(this, "请输入证件号码");
            } else if (this.mAddContactsRenewalLayout.getVisibility() == 0 && TextUtils.isEmpty(this.mRenewalNo)) {
                ToastUtil.a().e(this, "请输入换证次数");
            } else if (!this.notice.getCheckState()) {
                this.notice.startAnimation(AnimationUtils.loadAnimation(this, R$anim.shake_x));
                TextView textView = new TextView(this);
                textView.setText("请先勾选同意后再进行确认");
                textView.setTextSize(12.0f);
                textView.setTextColor(-1);
                new BubbleDialog(this).j(textView).k(this.notice, new int[]{0, 0, 0, 0}).n(8).r().l(0, 0, t60.a(this, 16.0f)).p(0).q(false, true).o(BubbleDialog.Position.TOP).show();
            } else {
                showDoubleCheckDialog(customerType.getIdentityCode() + "");
            }
        } else {
            ToastUtil.a().e(this, "请选择证件类型");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestAddCustomer(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1609747514")) {
            ipChange.ipc$dispatch("1609747514", new Object[]{this, str});
            return;
        }
        AddCustomerRequest addCustomerRequest = new AddCustomerRequest();
        addCustomerRequest.loginkey = z20.q();
        addCustomerRequest.idName = this.mUserName;
        addCustomerRequest.idNumber = this.mIdCardNo;
        addCustomerRequest.cardType = str;
        if (this.mAddContactsRenewalLayout.getVisibility() == 0) {
            addCustomerRequest.renewalNum = this.mRenewalNo;
        }
        addCustomerRequest.request(new DMMtopRequestListener<AddContactsBean>(AddContactsBean.class) { // from class: cn.damai.commonbusiness.contacts.ui.activity.AddContactsActivity.11
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str2, String str3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "474153677")) {
                    ipChange2.ipc$dispatch("474153677", new Object[]{this, str2, str3});
                } else {
                    AddContactsActivity.this.addContactsInfoError(str2, str3);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(AddContactsBean addContactsBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "931042553")) {
                    ipChange2.ipc$dispatch("931042553", new Object[]{this, addContactsBean});
                } else {
                    AddContactsActivity.this.returnContactsInfo(addContactsBean);
                }
            }
        });
        showProgressbar();
    }

    private void requestCardType() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-182583279")) {
            ipChange.ipc$dispatch("-182583279", new Object[]{this});
            return;
        }
        QueryCardTypeRequest queryCardTypeRequest = new QueryCardTypeRequest();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.mDatas.size(); i++) {
            arrayList.add(String.valueOf(this.mDatas.get(i).id));
        }
        if (arrayList.size() > 0) {
            queryCardTypeRequest.needReturnTypeList = arrayList;
        }
        startProgressDialog();
        queryCardTypeRequest.request(new DMMtopRequestListener<QueryCardTypeBean>(QueryCardTypeBean.class) { // from class: cn.damai.commonbusiness.contacts.ui.activity.AddContactsActivity.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-720477148")) {
                    ipChange2.ipc$dispatch("-720477148", new Object[]{this, str, str2});
                    return;
                }
                AddContactsActivity addContactsActivity = AddContactsActivity.this;
                addContactsActivity.onResponseError(str2, str, "mtop.damai.wireless.user.customer.typelist", addContactsActivity.mContainer, false);
                AddContactsActivity.this.stopProgressDialog();
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(QueryCardTypeBean queryCardTypeBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "686698258")) {
                    ipChange2.ipc$dispatch("686698258", new Object[]{this, queryCardTypeBean});
                    return;
                }
                AddContactsActivity addContactsActivity = AddContactsActivity.this;
                addContactsActivity.onResponseSuccess(addContactsActivity.mContainer);
                AddContactsActivity.this.dialogTipInfo = queryCardTypeBean.getTipInfo();
                AddContactsActivity.this.mCardTypeInfo = queryCardTypeBean.getCustomerTypeList();
                for (int i2 = 0; i2 < wh2.e(AddContactsActivity.this.mCardTypeInfo); i2++) {
                    AddContactsActivity.this.mIdTypeNames.add(((CustomerType) AddContactsActivity.this.mCardTypeInfo.get(i2)).getIdentityName());
                }
                if (AddContactsActivity.this.mCardTypeInfo != null && AddContactsActivity.this.mCardTypeInfo.size() > 0) {
                    AddContactsActivity addContactsActivity2 = AddContactsActivity.this;
                    addContactsActivity2.upDateView((CustomerType) addContactsActivity2.mCardTypeInfo.get(0));
                }
                AddContactsActivity.this.stopProgressDialog();
            }
        });
    }

    private void setupListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2140656638")) {
            ipChange.ipc$dispatch("2140656638", new Object[]{this});
            return;
        }
        this.mIvClearContactName.setOnClickListener(this.mOnClearContactNameClickListener);
        this.mIvClearContactIdCardNum.setOnClickListener(this.mOnClearContactIdCardNumClickListener);
        this.mIvClearRenewalNum.setOnClickListener(this.mOnClearRenewalNumClickListener);
        this.mInputUserName.addTextChangedListener(this.mContactNameTextWatcher);
        this.mUpperCaseTransform = new C0627o(this);
        this.mNormalTransform = new C0626n(this);
        this.mInputRenewalNumber.addTextChangedListener(this.mContactRenewalNumTextWatcher);
        this.mInputUserIdNumber.addTextChangedListener(this.mContactIdCardNumTextWatcher);
    }

    private void showDoubleCheckDialog(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-530336974")) {
            ipChange.ipc$dispatch("-530336974", new Object[]{this, str});
        } else if (str.equals("1")) {
            requestAddCustomer(str);
        } else {
            AddContactDoubleCheckView addContactDoubleCheckView = new AddContactDoubleCheckView(this);
            addContactDoubleCheckView.setData(getCurrentInput());
            new DMDialog(this).r(this.dialogTipInfo, Color.parseColor("#353535"), 12.0f).t(GravityCompat.START).y(addContactDoubleCheckView).e(t60.a(this, 18.0f)).i("修改", new DialogInterface$OnClickListenerC0613a(this, str)).n(PurchaseConstants.CONFIRM, new DialogInterface$OnClickListenerC0625m(str)).show();
            this.doubleCheckExposureStr = System.currentTimeMillis();
        }
    }

    private void showProgressbar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-139875167")) {
            ipChange.ipc$dispatch("-139875167", new Object[]{this});
            return;
        }
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.height = -1;
        layoutParams.width = -1;
        layoutParams.format = -3;
        layoutParams.flags = 8;
        this.mProgressBarIsShowing = true;
        if (this.mProgressBar.getParent() != null) {
            this.mWindowManager.removeView(this.mProgressBar);
        }
        this.mWindowManager.addView(this.mProgressBar, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void upDateView(CustomerType customerType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "95092861")) {
            ipChange.ipc$dispatch("95092861", new Object[]{this, customerType});
        } else if (customerType != null) {
            this.mInputUserIdNumber.setText("");
            this.mIdTypeBtn.setTag(customerType);
            List<InputField> inputFields = customerType.getInputFields();
            this.mIdTypeBtn.setText(customerType.getIdentityName());
            if (inputFields.size() >= 2) {
                this.mNameTv.setText(inputFields.get(0).getName() == null ? getString(R$string.add_contacts_user_name) : inputFields.get(0).getName());
                this.mInputUserName.setHint(inputFields.get(0).getPlaceholder() == null ? getString(R$string.add_contacts_hint_input_user_name) : inputFields.get(0).getPlaceholder());
                this.mIdCardNumberTv.setText(inputFields.get(1).getName() == null ? getString(R$string.add_contacts_id_card_number) : inputFields.get(1).getName());
                this.mInputUserIdNumber.setHint(inputFields.get(1).getPlaceholder() == null ? getString(R$string.add_contacts_hint_input_id_card_number_second) : inputFields.get(1).getPlaceholder());
            }
            this.mInputUserIdNumber.setTransformationMethod(1 == customerType.getIdentityCode() ? this.mUpperCaseTransform : this.mNormalTransform);
            if (customerType.getInputFields().size() > 2) {
                this.mAddContactsRenewalLayout.setVisibility(0);
                this.mAddContactsIdcardLine.setVisibility(0);
                this.mRenewalNumberTv.setText(inputFields.get(2).getName() == null ? "" : inputFields.get(2).getName());
                this.mInputRenewalNumber.setHint(inputFields.get(2).getPlaceholder() != null ? inputFields.get(2).getPlaceholder() : "");
                return;
            }
            this.mAddContactsRenewalLayout.setVisibility(8);
            this.mAddContactsIdcardLine.setVisibility(8);
        }
    }

    public void addContactsInfoError(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1494261426")) {
            ipChange.ipc$dispatch("-1494261426", new Object[]{this, str, str2});
            return;
        }
        hideProgressBar();
        this.mRemindLimit = "FAIL_BIZ_UC_5035".equals(str);
        if (!"FAIL_BIZ_UC_5039".equals(str) && !"FAIL_BIZ_UC_5035".equals(str)) {
            if (!"MAPIE97003".equals(str)) {
                if ("FAIL_SYS_SESSION_EXPIRED".equals(str)) {
                    ToastUtil.a().e(this, "您还未登录哦");
                } else {
                    ToastUtil.a().e(this, str2);
                }
            }
        } else {
            DMDialog n = new DMDialog(this).o(false).q(getTipText(str2)).n("知道了", this.mDialogOnClickListener);
            this.mErrorTipDialog = n;
            n.show();
        }
        if (str.equals("FAIL_BIZ_UC_5016") || str.equals("FAIL_BIZ_UC_400") || str.equals("FAIL_BIZ_UC_5039")) {
            return;
        }
        ln.a(this.mBundleName, "mtop.damai.wireless.user.customer.add", str, str2);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-933118232")) {
            ipChange.ipc$dispatch("-933118232", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "226558466") ? ((Integer) ipChange.ipc$dispatch("226558466", new Object[]{this})).intValue() : R$layout.activity_aad_contacts;
    }

    public SpannableStringBuilder getTipText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2140205051")) {
            return (SpannableStringBuilder) ipChange.ipc$dispatch("2140205051", new Object[]{this, str});
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt >= '0' && charAt <= '9') {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R$color.main_color)), i, i + 1, 33);
            }
        }
        return spannableStringBuilder;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "866346425")) {
            ipChange.ipc$dispatch("866346425", new Object[]{this, Integer.valueOf(i)});
        } else {
            requestCardType();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1837170798")) {
            ipChange.ipc$dispatch("-1837170798", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1640623157")) {
            ipChange.ipc$dispatch("-1640623157", new Object[]{this});
            return;
        }
        hideBaseLayout();
        this.mDatas = (List) getIntent().getSerializableExtra("contacts");
        this.mIdTypeNames = new ArrayList();
        if (this.mDatas == null) {
            this.mDatas = new ArrayList();
        }
        long longExtra = getIntent().getLongExtra("projectId", 0L);
        this.mBundleName = getIntent().getStringExtra("bundleName");
        setDamaiUTKeyBuilder(pl.j().l(longExtra));
        this.mContainer = findViewById(R$id.add_contacts_container);
        this.mBackIcon = (ImageView) findViewById(R$id.add_contacts_back_icon);
        this.mTitle = (TextView) findViewById(R$id.add_contacts_title);
        this.mNameTv = (TextView) findViewById(R$id.add_contacts_name_text_tv);
        this.mIdCardNumberTv = (TextView) findViewById(R$id.add_contacts_idcard_number_text_tv);
        this.mRenewalNumberTv = (TextView) findViewById(R$id.add_contacts_renewal_number_text_tv);
        RealNameTipView realNameTipView = (RealNameTipView) findViewById(R$id.add_contacts_notice);
        this.notice = realNameTipView;
        realNameTipView.setText("我已阅读并同意《实名须知》", "《实名须知》");
        this.notice.updateIconVis(true);
        this.notice.updateCheckState(false);
        DMLabelView dMLabelView = (DMLabelView) findViewById(R$id.add_contacts_save_btn);
        this.mSaveBtn = dMLabelView;
        dMLabelView.setLabelType(DMLabelType.LABEL_TYPE_CUSTOM);
        this.mSaveBtn.setBgColor("#FF2869", "#FF3299");
        this.mSaveBtn.setLabelHeight(t60.a(this, 50.0f));
        this.mSaveBtn.setCornerRadii(t60.a(this, 25.0f), t60.a(this, 25.0f), t60.a(this, 25.0f), t60.a(this, 4.0f));
        this.mSaveBtn.setLabelTextSize(16.0f);
        this.mSaveBtn.setLabelName("确定");
        this.mInputUserName = (EditText) findViewById(R$id.add_contacts_name);
        this.mIdTypeBtn = (TextView) findViewById(R$id.add_contacts_id_type_btn);
        this.mIdTypeMoreBtn = (DMIconFontTextView) findViewById(R$id.add_contacts_id_type_more_btn);
        this.mInputUserIdNumber = (EditText) findViewById(R$id.add_contacts_idcard_number);
        this.mInputRenewalNumber = (EditText) findViewById(R$id.add_contacts_renewal_number);
        this.mProgressBar = getLayoutInflater().inflate(R$layout.layout_add_contacts_progress, (ViewGroup) null);
        this.mWindowManager = getWindowManager();
        this.mTitle.setText(cm2.b(this, R$string.add_contacts_title_text));
        this.mBackIcon.setOnClickListener(this);
        this.mSaveBtn.setOnClickListener(this);
        this.mIdTypeBtn.setOnClickListener(this);
        this.mIdTypeMoreBtn.setOnClickListener(this);
        this.mProgressBar.setOnTouchListener(this.mOnTouchListener);
        DMIconFontTextView dMIconFontTextView = (DMIconFontTextView) findViewById(R$id.add_contacts_clear_name_iv);
        this.mIvClearContactName = dMIconFontTextView;
        dMIconFontTextView.setVisibility(4);
        DMIconFontTextView dMIconFontTextView2 = (DMIconFontTextView) findViewById(R$id.add_contacts_clear_idcard_number_iv);
        this.mIvClearContactIdCardNum = dMIconFontTextView2;
        dMIconFontTextView2.setVisibility(4);
        DMIconFontTextView dMIconFontTextView3 = (DMIconFontTextView) findViewById(R$id.add_contacts_clear_renewal_number_iv);
        this.mIvClearRenewalNum = dMIconFontTextView3;
        dMIconFontTextView3.setVisibility(4);
        this.mAddContactsRenewalLayout = (RelativeLayout) findViewById(R$id.add_contacts_renewal_layout);
        this.mAddContactsIdcardLine = findViewById(R$id.add_contacts_idcard_line);
        requestCardType();
        initListeners();
        setupListeners();
    }

    @Override // cn.damai.common.app.base.BaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1759641359")) {
            ipChange.ipc$dispatch("-1759641359", new Object[]{this, view});
            return;
        }
        int id = view.getId();
        if (id == R$id.add_contacts_back_icon) {
            finish();
        } else if (id == R$id.add_contacts_save_btn) {
            if (this.mIdTypeBtn.getTag() != null) {
                C0529c.e().x(kn.j().g(String.valueOf(((CustomerType) this.mIdTypeBtn.getTag()).getIdentityCode())));
                if (LoginManager.k().q()) {
                    requestAddContacts();
                } else {
                    LoginManager.k().v(this);
                }
            }
        } else if ((id == R$id.add_contacts_id_type_btn || id == R$id.add_contacts_id_type_more_btn) && wh2.e(this.mCardTypeInfo) > 0) {
            show();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2086516081")) {
            ipChange.ipc$dispatch("-2086516081", new Object[]{this, bundle});
        } else {
            super.onCreate(bundle);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        DMDialog dMDialog;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "595315429")) {
            return ((Boolean) ipChange.ipc$dispatch("595315429", new Object[]{this, Integer.valueOf(i), keyEvent})).booleanValue();
        }
        if (i == 4 && (((dMDialog = this.mErrorTipDialog) != null && dMDialog.isShowing()) || this.mProgressBarIsShowing)) {
            hideProgressBar();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2108897000")) {
            ipChange.ipc$dispatch("2108897000", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-851060179")) {
            ipChange.ipc$dispatch("-851060179", new Object[]{this});
        }
    }

    public void returnContactsInfo(AddContactsBean addContactsBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-160931494")) {
            ipChange.ipc$dispatch("-160931494", new Object[]{this, addContactsBean});
            return;
        }
        e80.f(this);
        hideProgressBar();
        ToastUtil.a().e(this, "添加成功");
        addContactsBean.setDisplayName(this.mUserName);
        addContactsBean.setDisplayIdentityNo(this.mIdCardNo);
        Intent intent = getIntent();
        intent.putExtra("contacts", addContactsBean);
        setResult(-1, intent);
        finish();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1929264374") ? (String) ipChange.ipc$dispatch("1929264374", new Object[]{this}) : "";
    }

    public void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1610543395")) {
            ipChange.ipc$dispatch("1610543395", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this).inflate(R$layout.add_contacts_select_id_type_layout, (ViewGroup) null);
        WheelView wheelView = (WheelView) inflate.findViewById(R$id.add_contacts_idtype_list);
        wheelView.setOffset(1);
        wheelView.setItems(this.mIdTypeNames);
        wheelView.setSeletion(this.mCurrentTypePosition);
        this.lastTypePsoition = this.mCurrentTypePosition;
        wheelView.setOnWheelViewListener(this.OnWheelViewListener);
        Dialog dialog = new Dialog(this, R$style.ActionSheetDialogStyle);
        dialog.setContentView(inflate);
        Window window = dialog.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        window.setGravity(80);
        attributes.width = DisplayMetrics.getwidthPixels(t60.b(this));
        attributes.height = t60.a(this, 245.0f);
        window.setAttributes(attributes);
        dialog.setCanceledOnTouchOutside(true);
        ((TextView) inflate.findViewById(R$id.add_contacts_cancel_btn)).setOnClickListener(new View$OnClickListenerC0628p(dialog));
        ((TextView) inflate.findViewById(R$id.add_contacts_confirm_btn)).setOnClickListener(new View$OnClickListenerC0628p(dialog));
        if (this.mIdTypeNames.size() > 0) {
            dialog.show();
        }
    }
}
