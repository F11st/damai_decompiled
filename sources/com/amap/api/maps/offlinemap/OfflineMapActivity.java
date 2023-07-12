package com.amap.api.maps.offlinemap;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.amap.api.mapcore.util.fp;
import com.amap.api.mapcore.util.fq;
import com.amap.api.mapcore.util.fs;
import com.amap.api.offlineservice.AMapPermissionActivity;
import com.amap.api.offlineservice.AbstractC4659a;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class OfflineMapActivity extends AMapPermissionActivity implements View.OnClickListener {
    private static int a;
    private AbstractC4659a b;
    private fp c;
    private fp[] d = new fp[32];
    private int e = -1;
    private fq f;

    private void a(fp fpVar) {
        try {
            AbstractC4659a abstractC4659a = this.b;
            if (abstractC4659a != null) {
                abstractC4659a.d();
                this.b = null;
            }
            AbstractC4659a c = c(fpVar);
            this.b = c;
            if (c != null) {
                this.c = fpVar;
                c.a(this);
                this.b.a(this.c.b);
                this.b.a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void b(fp fpVar) {
        try {
            a++;
            a(fpVar);
            int i = (this.e + 1) % 32;
            this.e = i;
            this.d[i] = fpVar;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private AbstractC4659a c(fp fpVar) {
        try {
            if (fpVar.a != 1) {
                return null;
            }
            if (this.f == null) {
                this.f = new fq();
            }
            return this.f;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void closeScr() {
        try {
            if (a((Bundle) null)) {
                return;
            }
            AbstractC4659a abstractC4659a = this.b;
            if (abstractC4659a != null) {
                abstractC4659a.d();
            }
            finish();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            AbstractC4659a abstractC4659a = this.b;
            if (abstractC4659a != null) {
                abstractC4659a.a(view);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        try {
            super.onConfigurationChanged(configuration);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            getWindow().setSoftInputMode(32);
            getWindow().setFormat(-3);
            requestWindowFeature(1);
            fs.a(getApplicationContext());
            this.e = -1;
            a = 0;
            b(new fp(1, null));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        try {
            super.onDestroy();
            AbstractC4659a abstractC4659a = this.b;
            if (abstractC4659a != null) {
                abstractC4659a.d();
                this.b = null;
            }
            this.c = null;
            this.d = null;
            fq fqVar = this.f;
            if (fqVar != null) {
                fqVar.d();
                this.f = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            try {
                AbstractC4659a abstractC4659a = this.b;
                if (abstractC4659a != null && !abstractC4659a.b()) {
                    return true;
                }
                if (a((Bundle) null)) {
                    return false;
                }
                if (keyEvent == null) {
                    if (a == 1) {
                        finish();
                    }
                    return false;
                }
                this.e = -1;
                a = 0;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onPause() {
        try {
            super.onPause();
            AbstractC4659a abstractC4659a = this.b;
            if (abstractC4659a != null) {
                abstractC4659a.h();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.offlineservice.AMapPermissionActivity, android.app.Activity
    public void onResume() {
        try {
            super.onResume();
            AbstractC4659a abstractC4659a = this.b;
            if (abstractC4659a != null) {
                abstractC4659a.f();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        try {
            super.onStart();
            AbstractC4659a abstractC4659a = this.b;
            if (abstractC4659a != null) {
                abstractC4659a.e();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        try {
            super.onStop();
            AbstractC4659a abstractC4659a = this.b;
            if (abstractC4659a != null) {
                abstractC4659a.g();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void showScr() {
        try {
            setContentView(this.b.c());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void closeScr(Bundle bundle) {
        try {
            if (a(bundle)) {
                return;
            }
            AbstractC4659a abstractC4659a = this.b;
            if (abstractC4659a != null) {
                abstractC4659a.d();
            }
            finish();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private boolean a(Bundle bundle) {
        try {
            int i = a;
            if ((i != 1 || this.b == null) && i > 1) {
                a = i - 1;
                int i2 = ((this.e - 1) + 32) % 32;
                this.e = i2;
                fp fpVar = this.d[i2];
                fpVar.b = bundle;
                a(fpVar);
                return true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }
}
