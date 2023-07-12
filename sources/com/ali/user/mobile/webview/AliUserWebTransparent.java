package com.ali.user.mobile.webview;

import android.os.Bundle;
import android.taobao.windvane.fragment.WVWebViewFragment;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.FragmentTransaction;
import com.ali.user.mobile.base.ui.BaseActivity;
import com.ali.user.mobile.ui.R;
import com.ali.user.mobile.ui.WebConstant;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class AliUserWebTransparent extends BaseActivity {
    String mUrl;

    private void addWebFragment() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        View findViewById = findViewById(R.id.aliuser_web_rl);
        if (findViewById != null) {
            findViewById.setVisibility(0);
        }
        ImageView imageView = (ImageView) findViewById(R.id.aliuser_auth_title_back_tv);
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.ali.user.mobile.webview.AliUserWebTransparent.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AliUserWebTransparent.this.onBackPressed();
                }
            });
        }
        Bundle bundle = new Bundle();
        bundle.putString("url", this.mUrl);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        WVWebViewFragment wVWebViewFragment = new WVWebViewFragment(this);
        wVWebViewFragment.setArguments(bundle);
        beginTransaction.add(R.id.browser_fragment_layout, wVWebViewFragment);
        beginTransaction.commit();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ali.user.mobile.base.ui.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.activityIsTranslucent = true;
        super.onCreate(bundle);
        setContentView(R.C2965layout.aliuser_web_trans);
        this.mViewGroup.setBackgroundColor(0);
        try {
            this.mUrl = getIntent().getStringExtra(WebConstant.WEBURL);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (!TextUtils.isEmpty(this.mUrl)) {
            addWebFragment();
        } else {
            finish();
        }
    }
}
