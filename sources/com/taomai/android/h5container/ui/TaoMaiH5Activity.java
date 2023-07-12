package com.taomai.android.h5container.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.taomai.android.h5container.R$id;
import com.taomai.android.h5container.R$layout;
import com.taomai.android.h5container.utils.ActivityStackManager;
import com.youku.arch.v3.event.Subject;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.dv0;
import tb.f5;
import tb.mo2;
import tb.yk2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001f\u0010 J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0014J\b\u0010\t\u001a\u00020\u0005H\u0016J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\"\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014J\u0012\u0010\u0016\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016R$\u0010\u0019\u001a\u0004\u0018\u00010\u00178\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/taomai/android/h5container/ui/TaoMaiH5Activity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/taomai/android/h5container/utils/ActivityStackManager$IActivityStackBackEvent;", "Landroid/os/Bundle;", "bundle", "Ltb/wt2;", "fixState", "savedInstanceState", "onCreate", "onBackPressed", "Landroid/view/Menu;", "menu", "", "onCreateOptionsMenu", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "", "jsonData", "onPageBackResult", "Landroidx/fragment/app/Fragment;", "createFragment", Subject.FRAGMENT, "Landroidx/fragment/app/Fragment;", "getFragment", "()Landroidx/fragment/app/Fragment;", "setFragment", "(Landroidx/fragment/app/Fragment;)V", "<init>", "()V", "h5container_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes11.dex */
public class TaoMaiH5Activity extends AppCompatActivity implements ActivityStackManager.IActivityStackBackEvent {
    @Nullable
    private Fragment fragment;

    private final void fixState(Bundle bundle) {
        Set<String> keySet;
        int i = Build.VERSION.SDK_INT;
        if (i == 29 || i == 28) {
            ClassLoader classLoader = TaoMaiH5Activity.class.getClassLoader();
            if (bundle != null) {
                bundle.setClassLoader(classLoader);
                Bundle bundle2 = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
                if (bundle2 == null || (keySet = bundle2.keySet()) == null) {
                    return;
                }
                for (String str : keySet) {
                    Object obj = bundle2.get(str);
                    if (!(obj instanceof Bundle)) {
                        obj = null;
                    }
                    Bundle bundle3 = (Bundle) obj;
                    if (bundle3 != null) {
                        bundle3.setClassLoader(classLoader);
                    }
                }
            }
        }
    }

    @NotNull
    public Fragment createFragment() {
        if (yk2.INSTANCE.c()) {
            return new TaoMaiUCH5Fragment();
        }
        return new TaoMaiH5Fragment();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final Fragment getFragment() {
        return this.fragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        Fragment fragment = this.fragment;
        if (fragment != null) {
            fragment.onActivityResult(i, i2, intent);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (yk2.INSTANCE.c()) {
            Fragment fragment = this.fragment;
            TaoMaiUCH5Fragment taoMaiUCH5Fragment = fragment instanceof TaoMaiUCH5Fragment ? fragment : null;
            if (taoMaiUCH5Fragment != null && taoMaiUCH5Fragment.onBackPressed()) {
                return;
            }
        } else {
            Fragment fragment2 = this.fragment;
            TaoMaiH5Fragment taoMaiH5Fragment = fragment2 instanceof TaoMaiH5Fragment ? fragment2 : null;
            if (taoMaiH5Fragment != null && taoMaiH5Fragment.onBackPressed()) {
                return;
            }
        }
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Bundle extras;
        fixState(bundle);
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null) {
            fixState(extras);
        }
        super.onCreate(bundle);
        setContentView(R$layout.activity_taomai_h5_container_layout);
        Log.e("Kian", "TaoMaiH5Activity onCreate");
        String stringExtra = getIntent().getStringExtra("url");
        String stringExtra2 = getIntent().getStringExtra("spm");
        Intent intent2 = getIntent();
        b41.h(intent2, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
        Bundle extras2 = intent2.getExtras();
        if (extras2 == null) {
            extras2 = new Bundle();
        }
        b41.h(extras2, "intent.extras ?: Bundle()");
        extras2.putString("spm", stringExtra2);
        String string = extras2.getString("title");
        extras2.putAll(dv0.INSTANCE.a(stringExtra));
        if (!TextUtils.isEmpty(string)) {
            extras2.putString("title", string);
        }
        extras2.putString("url", stringExtra);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        b41.h(supportFragmentManager, "this.supportFragmentManager");
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        b41.h(beginTransaction, "fragmentManager.beginTransaction()");
        Fragment createFragment = createFragment();
        this.fragment = createFragment;
        b41.f(createFragment);
        createFragment.setArguments(extras2);
        int i = R$id.fragment;
        Fragment fragment = this.fragment;
        b41.f(fragment);
        beginTransaction.add(i, fragment);
        beginTransaction.commitAllowingStateLoss();
        mo2.Companion.a(this, 1325400064);
        f5.c(this);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(@Nullable Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.taomai.android.h5container.utils.ActivityStackManager.IActivityStackBackEvent
    public void onPageBackResult(@Nullable String str) {
        Fragment fragment = this.fragment;
        TaoMaiH5Fragment taoMaiH5Fragment = (TaoMaiH5Fragment) (!(fragment instanceof TaoMaiH5Fragment) ? null : fragment);
        if (taoMaiH5Fragment != null) {
            taoMaiH5Fragment.onPageBackResult(str);
            return;
        }
        if (!(fragment instanceof TaoMaiUCH5Fragment)) {
            fragment = null;
        }
        TaoMaiUCH5Fragment taoMaiUCH5Fragment = (TaoMaiUCH5Fragment) fragment;
        if (taoMaiUCH5Fragment != null) {
            taoMaiUCH5Fragment.onPageBackResult(str);
        }
    }

    protected final void setFragment(@Nullable Fragment fragment) {
        this.fragment = fragment;
    }
}
