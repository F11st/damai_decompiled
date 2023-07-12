package com.alibaba.pictures.picpermission.mantle;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.pictures.picpermission.R$id;
import com.alibaba.pictures.picpermission.R$layout;
import com.alibaba.pictures.picpermission.manage.PermissionModel;
import com.alibaba.pictures.picpermission.manage.PicPermissionManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.common.WXModule;
import java.lang.ref.WeakReference;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ab;
import tb.b41;
import tb.k50;
import tb.ka;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 /2\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b-\u0010.J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J%\u0010\r\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0002H\u0014J/\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000b2\u000e\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\"\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0014J\u0006\u0010\u001c\u001a\u00020\u0004R\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\n\u0010 R\u0018\u0010!\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010%\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010\"R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010(R\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u00061"}, d2 = {"Lcom/alibaba/pictures/picpermission/mantle/PermissionBaseActivity;", "Landroidx/fragment/app/FragmentActivity;", "Landroid/os/Bundle;", "savedInstanceState", "Ltb/wt2;", "setupFromSavedInstanceState", "initView", "setViewData", "", "", "permission", "", "code", "request", "([Ljava/lang/String;I)V", "onCreate", "outState", "onSaveInstanceState", "requestCode", "permissions", "", WXModule.GRANT_RESULTS, "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "continuePermissionHandle", "Landroid/widget/LinearLayout;", "container", "Landroid/widget/LinearLayout;", "[Ljava/lang/String;", "title", "Ljava/lang/String;", "iconResId", "I", "describle", "", "showMantle", "Z", "theLast", "Landroid/os/Handler;", "mHandler", "Landroid/os/Handler;", "<init>", "()V", "Companion", "a", "permission_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public final class PermissionBaseActivity extends FragmentActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int CODE_PERMISSIONS_REQUEST_WITHOUT_MANTLE = 2;
    public static final int CODE_PERMISSION_REQUEST = 1;
    @NotNull
    public static final a Companion = new a(null);
    public static final int DELAY_SHOW_TIPS_CODE = 0;
    public static final long DELAY_SHOW_TIPS_TIME = 300;
    @NotNull
    public static final String EXTRA_IS_THE_LAST = "the_last_permission";
    @NotNull
    public static final String EXTRA_PERMISSIONS = "permissions";
    @NotNull
    public static final String EXTRA_TIPS_DESCRIBE = "tips_describe";
    @NotNull
    public static final String EXTRA_TIPS_ICON = "tips_icon";
    @NotNull
    public static final String EXTRA_TIPS_SHOW_MANTLE = "tips_show_mantle";
    @NotNull
    public static final String EXTRA_TIPS_TITLE = "tips_title";
    private LinearLayout container;
    private String describle;
    private int iconResId;
    private String[] permission;
    private boolean showMantle;
    private boolean theLast;
    private String title;
    private ka tipsView = new MantleTipsView();
    private final Handler mHandler = new b(Looper.getMainLooper());

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class b extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;

        b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1436066991")) {
                ipChange.ipc$dispatch("1436066991", new Object[]{this, message});
                return;
            }
            b41.i(message, "msg");
            super.handleMessage(message);
            if (message.what == 0) {
                PermissionBaseActivity.this.setViewData();
            }
        }
    }

    private final void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "669851132")) {
            ipChange.ipc$dispatch("669851132", new Object[]{this});
            return;
        }
        View findViewById = findViewById(R$id.permission_container);
        b41.h(findViewById, "findViewById(R.id.permission_container)");
        this.container = (LinearLayout) findViewById;
        PicPermissionManager.Companion companion = PicPermissionManager.Companion;
        if (companion.instance().getCustomTipsView() != null) {
            ka customTipsView = companion.instance().getCustomTipsView();
            b41.f(customTipsView);
            this.tipsView = customTipsView;
            View inflate = LayoutInflater.from(this).inflate(this.tipsView.b(), (ViewGroup) null);
            this.tipsView.d(inflate);
            if (this.tipsView.a() != null) {
                View a2 = this.tipsView.a();
                if (a2 != null) {
                    a2.setVisibility(8);
                }
                ka kaVar = this.tipsView;
                b41.h(inflate, "view");
                kaVar.c(inflate);
                LinearLayout linearLayout = this.container;
                if (linearLayout == null) {
                    b41.A("container");
                }
                linearLayout.addView(this.tipsView.a());
                return;
            }
            return;
        }
        this.tipsView = new MantleTipsView();
    }

    private final void request(String[] strArr, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1620293966")) {
            ipChange.ipc$dispatch("1620293966", new Object[]{this, strArr, Integer.valueOf(i)});
            return;
        }
        try {
            ActivityCompat.requestPermissions(this, strArr, i);
        } catch (ActivityNotFoundException unused) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setViewData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1908679832")) {
            ipChange.ipc$dispatch("-1908679832", new Object[]{this});
            return;
        }
        ka kaVar = this.tipsView;
        String[] strArr = this.permission;
        if (strArr == null) {
            b41.A("permission");
        }
        kaVar.e(new PermissionModel(strArr, this.title, Integer.valueOf(this.iconResId), this.describle), this.showMantle);
    }

    private final void setupFromSavedInstanceState(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1285199255")) {
            ipChange.ipc$dispatch("1285199255", new Object[]{this, bundle});
        } else if (bundle != null) {
            String[] stringArray = bundle.getStringArray("permissions");
            b41.f(stringArray);
            this.permission = stringArray;
            this.title = bundle.getString(EXTRA_TIPS_TITLE);
            this.iconResId = bundle.getInt(EXTRA_TIPS_ICON);
            this.describle = bundle.getString(EXTRA_TIPS_DESCRIBE);
            this.showMantle = bundle.getBoolean(EXTRA_TIPS_SHOW_MANTLE);
            this.theLast = bundle.getBoolean(EXTRA_IS_THE_LAST);
        } else {
            Intent intent = getIntent();
            String[] stringArrayExtra = intent.getStringArrayExtra("permissions");
            Objects.requireNonNull(stringArrayExtra, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
            this.permission = stringArrayExtra;
            this.title = intent.getStringExtra(EXTRA_TIPS_TITLE);
            this.iconResId = intent.getIntExtra(EXTRA_TIPS_ICON, 0);
            this.describle = intent.getStringExtra(EXTRA_TIPS_DESCRIBE);
            this.showMantle = intent.getBooleanExtra(EXTRA_TIPS_SHOW_MANTLE, false);
            this.theLast = intent.getBooleanExtra(EXTRA_IS_THE_LAST, false);
        }
    }

    public final void continuePermissionHandle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-411294317")) {
            ipChange.ipc$dispatch("-411294317", new Object[]{this});
            return;
        }
        finish();
        overridePendingTransition(0, 0);
        PicPermissionManager.Companion.instance().proceed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1983826205")) {
            ipChange.ipc$dispatch("-1983826205", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
        } else if (i == 2168) {
            for (String str : PicPermissionManager.Companion.instance().getPermissionRecord()) {
                if (ContextCompat.checkSelfPermission(this, str) != 0) {
                    PicPermissionManager.Companion companion = PicPermissionManager.Companion;
                    if (!companion.instance().getDeniedPermissions().contains(str)) {
                        companion.instance().getDeniedPermissions().add(str);
                    }
                } else {
                    PicPermissionManager.Companion.instance().getDeniedPermissions().remove(str);
                }
            }
            continuePermissionHandle();
        } else {
            super.onActivityResult(i, i2, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1088751806")) {
            ipChange.ipc$dispatch("1088751806", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setContentView(R$layout.activity_permission_base);
        setupFromSavedInstanceState(bundle);
        PicPermissionManager.Companion.instance().setLastPermissionActivity(new WeakReference<>(this));
        initView();
        if (this.showMantle) {
            this.mHandler.sendEmptyMessageDelayed(0, 300L);
            String[] strArr = this.permission;
            if (strArr == null) {
                b41.A("permission");
            }
            request(strArr, 1);
            return;
        }
        String[] strArr2 = this.permission;
        if (strArr2 == null) {
            b41.A("permission");
        }
        request(strArr2, 2);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NotNull String[] strArr, @NotNull int[] iArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1335410006")) {
            ipChange.ipc$dispatch("-1335410006", new Object[]{this, Integer.valueOf(i), strArr, iArr});
            return;
        }
        b41.i(strArr, "permissions");
        b41.i(iArr, WXModule.GRANT_RESULTS);
        super.onRequestPermissionsResult(i, strArr, iArr);
        this.mHandler.removeMessages(0);
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            String str = strArr[i2];
            PicPermissionManager.Companion companion = PicPermissionManager.Companion;
            companion.instance().getPermissionRecord().add(str);
            if (-1 == iArr[i2]) {
                companion.instance().getDeniedPermissions().add(str);
                if (!ActivityCompat.shouldShowRequestPermissionRationale(this, str)) {
                    companion.instance().getTotalDeniedPermissions().add(str);
                    companion.instance().getCustomUtHandler().onShowRationale(str);
                } else {
                    companion.instance().getCustomUtHandler().onPermissionDenied(str);
                }
            }
            if (iArr[i2] == 0) {
                companion.instance().getCustomUtHandler().onPermissionGranted(str);
            }
        }
        if (i == 2) {
            PicPermissionManager.Companion.instance().setFinishHandle(true);
        }
        PicPermissionManager.Companion companion2 = PicPermissionManager.Companion;
        ab customRationalBehavior = companion2.instance().getCustomRationalBehavior();
        boolean z = this.theLast;
        if (z && ((!z || !companion2.instance().getTotalDeniedPermissions().isEmpty()) && customRationalBehavior != null)) {
            customRationalBehavior.b(this, companion2.instance().getTotalDeniedPermissions());
            View a2 = this.tipsView.a();
            if (a2 != null) {
                a2.setVisibility(8);
                return;
            }
            return;
        }
        continuePermissionHandle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1395124453")) {
            ipChange.ipc$dispatch("-1395124453", new Object[]{this, bundle});
            return;
        }
        b41.i(bundle, "outState");
        String[] strArr = this.permission;
        if (strArr == null) {
            b41.A("permission");
        }
        bundle.putStringArray("permissions", strArr);
        bundle.putString(EXTRA_TIPS_TITLE, this.title);
        bundle.putInt(EXTRA_TIPS_ICON, this.iconResId);
        bundle.putString(EXTRA_TIPS_DESCRIBE, this.describle);
        super.onSaveInstanceState(bundle);
    }
}
