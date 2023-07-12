package cn.damai.commonbusiness.screenshot;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import cn.damai.common.user.a;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.login.LoginManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import tb.kg2;
import tb.o62;
import tb.pl;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class ScreenFloatActivity extends Activity {
    private static transient /* synthetic */ IpChange $ipChange;
    private Handler a;
    private ScreenShotBean b;
    private Runnable d;
    private a.b e;
    private long c = 0;
    private View.OnClickListener f = new a();

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-460459214")) {
                ipChange.ipc$dispatch("-460459214", new Object[]{this, view});
                return;
            }
            ScreenFloatActivity.this.g();
            c.e().x(pl.j().h());
            o62.f().g();
            if (!LoginManager.k().q()) {
                LoginManager.k().x(ScreenFloatActivity.this, new Intent(), 100001);
            } else if (ScreenShotDetector.k().m() != null) {
                ScreenShotDetector.k().m().onFeedbackClick(ScreenFloatActivity.this.b, ScreenFloatActivity.this);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class b implements View.OnTouchListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1994583875")) {
                return ((Boolean) ipChange.ipc$dispatch("1994583875", new Object[]{this, view, motionEvent})).booleanValue();
            }
            ScreenFloatActivity.this.finish();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1818671767")) {
            ipChange.ipc$dispatch("-1818671767", new Object[]{this});
            return;
        }
        Runnable runnable = new Runnable() { // from class: cn.damai.commonbusiness.screenshot.ScreenFloatActivity.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-2040651012")) {
                    ipChange2.ipc$dispatch("-2040651012", new Object[]{this});
                } else if (ScreenShotDetector.k().b) {
                    if (SystemClock.elapsedRealtime() - ScreenFloatActivity.this.c >= DanmakuFactory.DEFAULT_DANMAKU_DURATION_V) {
                        ScreenFloatActivity.this.g();
                        ScreenFloatActivity.this.finish();
                        return;
                    }
                    ScreenFloatActivity.this.e();
                }
            }
        };
        this.d = runnable;
        this.a.postDelayed(runnable, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1522879508")) {
            ipChange.ipc$dispatch("-1522879508", new Object[]{this});
            return;
        }
        Handler handler = this.a;
        if (handler != null) {
            Runnable runnable = this.d;
            if (runnable != null) {
                handler.removeCallbacks(runnable);
            }
            this.a = null;
        }
    }

    public void f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-511596225")) {
            ipChange.ipc$dispatch("-511596225", new Object[]{this});
            return;
        }
        View findViewById = findViewById(R$id.status_bar_gap);
        if (Build.VERSION.SDK_INT >= 23) {
            if (findViewById != null) {
                findViewById.getLayoutParams().height = kg2.a(this);
                findViewById.setVisibility(0);
            }
            kg2.f(this, true, R$color.black);
            kg2.d(true, this);
        } else {
            kg2.f(this, false, R$color.black);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
        }
        findViewById(R$id.ll_feedback).setOnClickListener(this.f);
        findViewById(R$id.root_rl).setOnTouchListener(new b());
        this.c = SystemClock.elapsedRealtime();
        e();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2033004902")) {
            ipChange.ipc$dispatch("2033004902", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        if (i == 100001) {
            if (LoginManager.k().q()) {
                if (ScreenShotDetector.k().m() != null) {
                    ScreenShotDetector.k().m().onFeedbackClick(this.b, this);
                    return;
                }
                return;
            }
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1435613339")) {
            ipChange.ipc$dispatch("1435613339", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setContentView(R$layout.activity_screen_shot);
        this.a = new Handler();
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        ScreenShotBean screenShotBean = (ScreenShotBean) intent.getSerializableExtra("screen_shot_info");
        this.b = screenShotBean;
        if (screenShotBean == null) {
            finish();
            return;
        }
        f();
        this.e = pl.j().i();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1635306853")) {
            ipChange.ipc$dispatch("-1635306853", new Object[]{this});
            return;
        }
        super.onDestroy();
        ScreenShotDetector.k().b = false;
    }

    @Override // android.app.Activity
    protected void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1337455391")) {
            ipChange.ipc$dispatch("1337455391", new Object[]{this});
            return;
        }
        super.onPause();
        c.e().j(this, this.e);
    }

    @Override // android.app.Activity
    protected void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "159230664")) {
            ipChange.ipc$dispatch("159230664", new Object[]{this});
            return;
        }
        super.onResume();
        c.e().k(this, this.e);
    }

    @Override // android.app.Activity
    public void onStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1380560179")) {
            ipChange.ipc$dispatch("1380560179", new Object[]{this});
            return;
        }
        super.onStart();
        ScreenShotDetector.k().b = true;
    }
}
