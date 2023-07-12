package cn.damai.commonbusiness.share;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import androidx.annotation.Nullable;
import cn.damai.common.user.a;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.R$string;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import tb.b21;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ShareMiddleActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;

    private void createActivityResult() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1501837121")) {
            ipChange.ipc$dispatch("-1501837121", new Object[]{this});
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("tip", getString(R$string.damai_homepage_commented_tips));
        setResult(-1, intent);
    }

    private void showPopu() {
        String string;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "112181350")) {
            ipChange.ipc$dispatch("112181350", new Object[]{this});
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            extras = new Bundle();
            string = "";
        } else {
            string = extras.getString("imageModeUrl");
        }
        if (TextUtils.isEmpty(string)) {
            return;
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(new File(string));
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream2);
                    extras.putString("imageTitle", getIntent().getExtras().getString("imageTitle"));
                    extras.putString("shareType", "chat_image");
                    extras.putString("dimiss_action", "finish");
                    extras.putBoolean("hideCopyLink", true);
                    extras.putBoolean("isShrareImagePage", true);
                    extras.putString("imageModeUrl", b21.e(this));
                    ShareManager.E().f0(decodeStream).O(this, extras, R$layout.share_middle_main);
                    fileInputStream2.close();
                } catch (Exception unused) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused3) {
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException unused4) {
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "296031503")) {
            ipChange.ipc$dispatch("296031503", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-5492869")) {
            return ((Integer) ipChange.ipc$dispatch("-5492869", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2032277664")) {
            ipChange.ipc$dispatch("-2032277664", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1500204341")) {
            ipChange.ipc$dispatch("-1500204341", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1892253938")) {
            ipChange.ipc$dispatch("1892253938", new Object[]{this});
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1766677593")) {
            ipChange.ipc$dispatch("1766677593", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        ShareManager.E().r0(i, i2, intent);
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1142664729")) {
            ipChange.ipc$dispatch("-1142664729", new Object[]{this});
            return;
        }
        setResult(-1);
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1138924024")) {
            ipChange.ipc$dispatch("-1138924024", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setContentView(R$layout.share_middle_main);
        setDamaiUTKeyBuilder(new a.b().i("share_pic"));
        c.e().K(this);
        ShareManager.E().C();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-130395832")) {
            ipChange.ipc$dispatch("-130395832", new Object[]{this});
            return;
        }
        super.onDestroy();
        ShareManager.E().C();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "482912158")) {
            return ((Boolean) ipChange.ipc$dispatch("482912158", new Object[]{this, Integer.valueOf(i), keyEvent})).booleanValue();
        }
        if (i == 4) {
            ShareManager.E().C();
            setResult(-1);
            finish();
            return false;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-789727089")) {
            ipChange.ipc$dispatch("-789727089", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1083111514")) {
            ipChange.ipc$dispatch("-1083111514", new Object[]{this});
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "453128006")) {
            ipChange.ipc$dispatch("453128006", new Object[]{this});
            return;
        }
        super.onStop();
        ShareManager.E().v0();
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2145611608")) {
            ipChange.ipc$dispatch("2145611608", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.onWindowFocusChanged(z);
        if (z && ShareManager.E().J() == null) {
            showPopu();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-934550865")) {
            return (String) ipChange.ipc$dispatch("-934550865", new Object[]{this});
        }
        return null;
    }
}
