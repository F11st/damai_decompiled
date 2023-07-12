package cn.damai.common.app.base;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import cn.damai.common.R$id;
import cn.damai.common.R$layout;
import cn.damai.common.app.base.AbstractC0470a;
import cn.damai.common.app.base.BaseModel;
import cn.damai.common.app.widget.DMProgressDialog;
import cn.damai.common.app.widget.GrayFrameLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.concurrent.atomic.AtomicBoolean;
import tb.ok2;
import tb.w6;
import tb.wh2;
import tb.wu0;
import tb.xr;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public abstract class BaseActivity<T extends AbstractC0470a, E extends BaseModel> extends AppCompatActivity implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int CONMENTS_REQUEST = 5001;
    public static final int FINISH_ACTIVITY = 1000;
    public static final int FINISH_REQUEST = 2000;
    protected static final int HEADER_LEFT_ICON = 10003;
    protected static final int HEADER_LEFT_TEXT = 10001;
    protected static final int HEADER_RIGHT_ICON = 10004;
    protected static final int HEADER_RIGHT_TEXT = 10002;
    public static final int LOGIN_REQUEST = 3000;
    public static final int ORDER_PAY_ERROR = 1001;
    public static final int TIXING_REQUEST = 6001;
    public static final int VERCODERESULT = 4000;
    protected LinearLayout base_content_llyt;
    protected View base_head_title_view;
    protected LinearLayout base_header_left;
    protected LinearLayout base_header_right;
    protected TextView base_header_title;
    protected ImageView base_left_icon;
    protected TextView base_left_text;
    protected ImageView base_right_icon;
    protected TextView base_right_text;
    protected LinearLayout bese_content_view;
    protected LinearLayout bese_head_view;
    public Context mContext;
    public xr mDMMessage;
    protected LayoutInflater mInflater;
    public E mModel;
    public T mPresenter;
    protected View mTitleLineView;
    protected DMProgressDialog progressDialog;
    private boolean mIsForeground = false;
    private boolean isGrayView = false;
    private AtomicBoolean mHasDone = new AtomicBoolean(false);
    private AtomicBoolean mHasDoneGray = new AtomicBoolean(false);

    /* compiled from: Taobao */
    /* renamed from: cn.damai.common.app.base.BaseActivity$a */
    /* loaded from: classes13.dex */
    public class DialogInterface$OnDismissListenerC0468a implements DialogInterface.OnDismissListener {
        private static transient /* synthetic */ IpChange $ipChange;

        DialogInterface$OnDismissListenerC0468a(BaseActivity baseActivity) {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1922218552")) {
                ipChange.ipc$dispatch("1922218552", new Object[]{this, dialogInterface});
            }
        }
    }

    private void doBeforeSetcontentView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1508649410")) {
            ipChange.ipc$dispatch("-1508649410", new Object[]{this});
            return;
        }
        w6.b().a(this);
        supportRequestWindowFeature(1);
        setRequestedOrientation(1);
    }

    private void getGrayConfig() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1471546635")) {
            ipChange.ipc$dispatch("1471546635", new Object[]{this});
        } else if (this.mHasDone.compareAndSet(false, true)) {
            this.isGrayView = wu0.c(getClass().getSimpleName());
        }
    }

    private boolean isActivityDestroyed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "953587178")) {
            return ((Boolean) ipChange.ipc$dispatch("953587178", new Object[]{this})).booleanValue();
        }
        if (Build.VERSION.SDK_INT >= 17) {
            return isDestroyed();
        }
        return false;
    }

    private void setBaseHeadView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "60842766")) {
            ipChange.ipc$dispatch("60842766", new Object[]{this});
            return;
        }
        this.base_left_icon = (ImageView) this.base_head_title_view.findViewById(R$id.base_left_icon);
        this.base_right_icon = (ImageView) this.base_head_title_view.findViewById(R$id.base_right_icon);
        this.base_left_text = (TextView) this.base_head_title_view.findViewById(R$id.base_left_text);
        this.base_header_title = (TextView) this.base_head_title_view.findViewById(R$id.base_header_title);
        this.base_right_text = (TextView) this.base_head_title_view.findViewById(R$id.base_right_text);
        this.base_header_left = (LinearLayout) this.base_head_title_view.findViewById(R$id.base_header_left);
        this.base_header_right = (LinearLayout) this.base_head_title_view.findViewById(R$id.base_header_right);
        View findViewById = this.base_head_title_view.findViewById(R$id.view_title_line);
        this.mTitleLineView = findViewById;
        findViewById.setVisibility(8);
        this.base_header_left.setOnClickListener(this);
        this.base_header_right.setOnClickListener(this);
        if (TextUtils.isEmpty(setTitle())) {
            return;
        }
        this.base_header_title.setText(setTitle());
    }

    protected void addContentView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1656501799")) {
            ipChange.ipc$dispatch("1656501799", new Object[]{this});
            return;
        }
        this.bese_head_view = (LinearLayout) findViewById(R$id.bese_head_view);
        this.bese_content_view = (LinearLayout) findViewById(R$id.bese_content_view);
        this.base_content_llyt = (LinearLayout) findViewById(R$id.base_content_llyt);
        this.bese_head_view.setVisibility(0);
        View inflate = this.mInflater.inflate(R$layout.base_header_view, (ViewGroup) null);
        this.base_head_title_view = inflate;
        this.bese_head_view.addView(inflate);
        setBaseHeadView();
        if (getLayoutId() != 0) {
            this.bese_content_view.addView(this.mInflater.inflate(getLayoutId(), (ViewGroup) null), new LinearLayout.LayoutParams(-1, -1));
        }
    }

    public abstract void dealHeaderClick(int i);

    public abstract int getLayoutId();

    public TextView getTitleView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1689656337") ? (TextView) ipChange.ipc$dispatch("1689656337", new Object[]{this}) : this.base_header_title;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hideBaseLayout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-125346489")) {
            ipChange.ipc$dispatch("-125346489", new Object[]{this});
        } else {
            this.bese_head_view.setVisibility(8);
        }
    }

    public abstract void initPresenter();

    public abstract void initView();

    public boolean isActivityFinsihed() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1389043081") ? ((Boolean) ipChange.ipc$dispatch("1389043081", new Object[]{this})).booleanValue() : isFinishing() || isActivityDestroyed();
    }

    public boolean isActivityForeground() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "174750060") ? ((Boolean) ipChange.ipc$dispatch("174750060", new Object[]{this})).booleanValue() : this.mIsForeground;
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1040424427")) {
            ipChange.ipc$dispatch("-1040424427", new Object[]{this, view});
            return;
        }
        int id = view.getId();
        if (id == R$id.base_header_left) {
            if (this.base_left_icon.getVisibility() == 0) {
                dealHeaderClick(10003);
            } else if (this.base_left_text.getVisibility() == 0) {
                dealHeaderClick(10001);
            }
        } else if (id == R$id.base_header_right) {
            if (this.base_right_icon.getVisibility() == 0) {
                dealHeaderClick(10004);
            } else if (this.base_right_text.getVisibility() == 0) {
                dealHeaderClick(10002);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1265627669")) {
            ipChange.ipc$dispatch("-1265627669", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        this.mDMMessage = new xr();
        this.mInflater = getLayoutInflater();
        doBeforeSetcontentView();
        getGrayConfig();
        setContentView(R$layout.activity_base);
        addContentView();
        this.mContext = this;
        this.mPresenter = (T) ok2.a(this, 0);
        this.mModel = (E) ok2.a(this, 1);
        T t = this.mPresenter;
        if (t != null) {
            t.mContext = this;
            t.setMessageCenter(this.mDMMessage);
        }
        initPresenter();
        initView();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1409221440")) {
            return (View) ipChange.ipc$dispatch("1409221440", new Object[]{this, view, str, context, attributeSet});
        }
        try {
            getGrayConfig();
            if ("FrameLayout".equals(str) && this.isGrayView && !this.mHasDoneGray.get()) {
                int attributeCount = attributeSet.getAttributeCount();
                for (int i = 0; i < attributeCount; i++) {
                    String attributeName = attributeSet.getAttributeName(i);
                    String attributeValue = attributeSet.getAttributeValue(i);
                    if (attributeName.equals("id") && "android:id/content".equals(getResources().getResourceName(Integer.parseInt(attributeValue.substring(1))))) {
                        this.mHasDone.compareAndSet(false, true);
                        return new GrayFrameLayout(context, attributeSet);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.onCreateView(view, str, context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "785857515")) {
            ipChange.ipc$dispatch("785857515", new Object[]{this});
            return;
        }
        super.onDestroy();
        stopProgressDialog();
        T t = this.mPresenter;
        if (t != null) {
            t.onDestroy();
        }
        xr xrVar = this.mDMMessage;
        if (xrVar != null) {
            xrVar.a();
        }
        w6.b().d(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1880756335")) {
            ipChange.ipc$dispatch("1880756335", new Object[]{this});
            return;
        }
        super.onPause();
        this.mIsForeground = false;
        DMProgressDialog dMProgressDialog = this.progressDialog;
        if (dMProgressDialog == null || !dMProgressDialog.isShowing()) {
            return;
        }
        stopProgressDialog();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-178309256")) {
            ipChange.ipc$dispatch("-178309256", new Object[]{this});
            return;
        }
        super.onResume();
        this.mIsForeground = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void removeHeadTitleView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1312853517")) {
            ipChange.ipc$dispatch("1312853517", new Object[]{this});
        } else {
            this.bese_head_view.setVisibility(8);
        }
    }

    protected void setLeftIcon(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2054349889")) {
            ipChange.ipc$dispatch("-2054349889", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.base_left_icon.setBackgroundResource(i);
        this.base_left_text.setVisibility(8);
        this.base_left_icon.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setLeftNothing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1248459808")) {
            ipChange.ipc$dispatch("1248459808", new Object[]{this});
        } else {
            this.base_header_left.setVisibility(8);
        }
    }

    protected void setLeftTitle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-54313409")) {
            ipChange.ipc$dispatch("-54313409", new Object[]{this, str});
            return;
        }
        this.base_left_text.setText(str);
        this.base_left_text.setVisibility(0);
        this.base_left_icon.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setRightIcon(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-390560238")) {
            ipChange.ipc$dispatch("-390560238", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.base_right_icon.setBackgroundResource(i);
        this.base_right_text.setVisibility(8);
        this.base_right_icon.setVisibility(0);
    }

    protected void setRightNothing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1872486989")) {
            ipChange.ipc$dispatch("-1872486989", new Object[]{this});
        } else {
            this.base_header_right.setVisibility(8);
        }
    }

    protected void setRightTitle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1172691410")) {
            ipChange.ipc$dispatch("1172691410", new Object[]{this, str});
            return;
        }
        this.base_right_text.setText(str);
        this.base_right_text.setVisibility(0);
        this.base_right_icon.setVisibility(8);
    }

    protected abstract String setTitle();

    public void setTitleContent(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1294408243")) {
            ipChange.ipc$dispatch("-1294408243", new Object[]{this, str});
        } else {
            this.base_header_title.setText(str);
        }
    }

    public void startActivity(Class<?> cls) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1212071768")) {
            ipChange.ipc$dispatch("-1212071768", new Object[]{this, cls});
        } else {
            startActivity(cls, (Bundle) null);
        }
    }

    public void startActivityForResult(Class<?> cls, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-350448267")) {
            ipChange.ipc$dispatch("-350448267", new Object[]{this, cls, Integer.valueOf(i)});
        } else {
            startActivityForResult(cls, (Bundle) null, i);
        }
    }

    public void startProgressDialog(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1469043577")) {
            ipChange.ipc$dispatch("1469043577", new Object[]{this, str});
        } else if (isFinishing()) {
        } else {
            if (this.progressDialog == null) {
                this.progressDialog = new DMProgressDialog(this.mContext).a();
                if (!wh2.j(str)) {
                    this.progressDialog.c(str);
                }
                this.progressDialog.setOnDismissListener(new DialogInterface$OnDismissListenerC0468a(this));
            }
            this.progressDialog.show();
        }
    }

    public void stopProgressDialog() {
        DMProgressDialog dMProgressDialog;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1145268557")) {
            ipChange.ipc$dispatch("1145268557", new Object[]{this});
        } else if (isFinishing() || (dMProgressDialog = this.progressDialog) == null) {
        } else {
            dMProgressDialog.dismiss();
            this.progressDialog = null;
        }
    }

    public void startActivity(Class<?> cls, Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1634806996")) {
            ipChange.ipc$dispatch("-1634806996", new Object[]{this, cls, bundle});
            return;
        }
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    public void startActivityForResult(Class<?> cls, Bundle bundle, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1338524419")) {
            ipChange.ipc$dispatch("-1338524419", new Object[]{this, cls, bundle, Integer.valueOf(i)});
            return;
        }
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, i);
    }

    public void startProgressDialog() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-222427281")) {
            ipChange.ipc$dispatch("-222427281", new Object[]{this});
        } else {
            startProgressDialog(null);
        }
    }
}
