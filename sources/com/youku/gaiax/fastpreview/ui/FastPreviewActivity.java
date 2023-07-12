package com.youku.gaiax.fastpreview.ui;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.studio.GXClientToStudio;
import com.alibaba.gaiax.studio.GXSocket;
import com.taobao.weex.WXGlobalEventReceiver;
import com.youku.gaiax.GaiaX;
import com.youku.gaiax.IExperiment;
import com.youku.gaiax.LoadType;
import com.youku.gaiax.api.data.EventParams;
import com.youku.gaiax.common.utils.ScreenUtils;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.jn1;
import tb.k50;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u0000 :2\u00020\u0001:\u0002:;B\u0007¢\u0006\u0004\b8\u00109J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014J\b\u0010\r\u001a\u00020\u0004H\u0014J\u0010\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u0011\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u0012\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u0013\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u0014\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u0015\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eR\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u001fR\u0018\u0010!\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010#\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R$\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00100\u001a\u00020/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b0\u00102\"\u0004\b3\u00104R\u0013\u00107\u001a\u00020\u000e8F@\u0006¢\u0006\u0006\u001a\u0004\b5\u00106¨\u0006<"}, d2 = {"Lcom/youku/gaiax/fastpreview/ui/FastPreviewActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/youku/gaiax/GaiaX$Params;", "buildGaiaXParams", "Ltb/wt2;", "doForceCreate", "doDestroy", "doVisible", "doInvisible", "doCreateOrReuse", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "onDestroy", "Landroid/view/View;", "view", "OnCreate", "OnDestroy", "OnVisible", "OnInvisible", "OnReuse", "OnSwitch", "", "templateId", "Ljava/lang/String;", "", "height", "I", "width", "Lcom/alibaba/fastjson/JSONObject;", "constraintSize", "Lcom/alibaba/fastjson/JSONObject;", "templateData", "params", "Lcom/youku/gaiax/GaiaX$Params;", "gaiax_render_root_parent", "Landroid/view/View;", "Lcom/youku/gaiax/IExperiment$IStudioSocket;", "jsIStudioSocket", "Lcom/youku/gaiax/IExperiment$IStudioSocket;", "Lcom/youku/gaiax/fastpreview/ui/FastPreviewActivity$FastPreviewListener;", "gxSocketToStudioListener", "Lcom/youku/gaiax/fastpreview/ui/FastPreviewActivity$FastPreviewListener;", "getGxSocketToStudioListener", "()Lcom/youku/gaiax/fastpreview/ui/FastPreviewActivity$FastPreviewListener;", "setGxSocketToStudioListener", "(Lcom/youku/gaiax/fastpreview/ui/FastPreviewActivity$FastPreviewListener;)V", "", "isSwitch", "Z", "()Z", "setSwitch", "(Z)V", "getContainerView", "()Landroid/view/View;", "containerView", "<init>", "()V", "Companion", "FastPreviewListener", "workspace_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class FastPreviewActivity extends AppCompatActivity {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final String TAG = "[GaiaX][FastPreview]";
    @Nullable
    private JSONObject constraintSize;
    @Nullable
    private View gaiax_render_root_parent;
    @Nullable
    private FastPreviewListener gxSocketToStudioListener;
    private int height;
    private boolean isSwitch;
    @Nullable
    private GaiaX.Params params;
    @Nullable
    private JSONObject templateData;
    private int width;
    @NotNull
    private String templateId = "";
    @NotNull
    private IExperiment.IStudioSocket jsIStudioSocket = new IExperiment.IStudioSocket() { // from class: com.youku.gaiax.fastpreview.ui.FastPreviewActivity$jsIStudioSocket$1
        @Override // com.youku.gaiax.IExperiment.IStudioSocket
        public void sendMsg(@NotNull JSONObject jSONObject) {
            b41.i(jSONObject, "data");
            GXClientToStudio.Companion.a().s(jSONObject);
        }
    };

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/youku/gaiax/fastpreview/ui/FastPreviewActivity$Companion;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "workspace_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/youku/gaiax/fastpreview/ui/FastPreviewActivity$FastPreviewListener;", "Lcom/alibaba/gaiax/studio/GXClientToStudio$GXSocketToStudioListener;", "", "templateId", "Lcom/alibaba/fastjson/JSONObject;", "templateData", "Ltb/wt2;", "onAddData", "onUpdate", "Lcom/youku/gaiax/fastpreview/ui/FastPreviewActivity;", "activity", "Lcom/youku/gaiax/fastpreview/ui/FastPreviewActivity;", "getActivity", "()Lcom/youku/gaiax/fastpreview/ui/FastPreviewActivity;", "setActivity", "(Lcom/youku/gaiax/fastpreview/ui/FastPreviewActivity;)V", "<init>", "()V", "workspace_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class FastPreviewListener implements GXClientToStudio.GXSocketToStudioListener {
        @Nullable
        private FastPreviewActivity activity;

        @Nullable
        public final FastPreviewActivity getActivity() {
            return this.activity;
        }

        @Override // com.alibaba.gaiax.studio.GXClientToStudio.GXSocketToStudioListener
        public void onAddData(@NotNull String str, @NotNull JSONObject jSONObject) {
            b41.i(str, "templateId");
            b41.i(jSONObject, "templateData");
            IExperiment experiment = GaiaX.Companion.getInstance().experiment();
            if (experiment != null) {
                experiment.addTemplateToRealTime("fastpreview", str, jSONObject);
            }
            FastPreviewActivity fastPreviewActivity = this.activity;
            if (fastPreviewActivity != null) {
                Toast.makeText(fastPreviewActivity, b41.r("推送成功 模板ID=", str), 1).show();
            }
        }

        @Override // com.alibaba.gaiax.studio.GXClientToStudio.GXSocketToStudioListener
        public void onUpdate(@NotNull String str, @NotNull JSONObject jSONObject) {
            JSONObject jSONObject2;
            b41.i(str, "templateId");
            b41.i(jSONObject, "templateData");
            JSONObject jSONObject3 = jSONObject.getJSONObject("index.json");
            JSONObject jSONObject4 = null;
            if (jSONObject3 != null && (jSONObject2 = jSONObject3.getJSONObject("package")) != null) {
                jSONObject4 = jSONObject2.getJSONObject("constraint-size");
            }
            FastPreviewActivity fastPreviewActivity = this.activity;
            if (fastPreviewActivity != null) {
                if (fastPreviewActivity != null) {
                    fastPreviewActivity.templateId = str;
                }
                FastPreviewActivity fastPreviewActivity2 = this.activity;
                if (fastPreviewActivity2 != null) {
                    fastPreviewActivity2.constraintSize = jSONObject4;
                }
                FastPreviewActivity fastPreviewActivity3 = this.activity;
                if (fastPreviewActivity3 != null) {
                    fastPreviewActivity3.templateData = jSONObject;
                }
                FastPreviewActivity fastPreviewActivity4 = this.activity;
                if (fastPreviewActivity4 == null) {
                    return;
                }
                fastPreviewActivity4.doForceCreate();
            }
        }

        public final void setActivity(@Nullable FastPreviewActivity fastPreviewActivity) {
            this.activity = fastPreviewActivity;
        }
    }

    private final GaiaX.Params buildGaiaXParams() {
        int i;
        int i2;
        JSONObject jSONObject = this.constraintSize;
        if (jSONObject != null) {
            if (jSONObject.containsKey("width")) {
                Integer integer = jSONObject.getInteger("width");
                b41.h(integer, "{\n                it.get…er(\"width\")\n            }");
                i = integer.intValue();
            } else {
                i = -1;
            }
            this.width = i;
            if (jSONObject.containsKey("height")) {
                Integer integer2 = jSONObject.getInteger("height");
                b41.h(integer2, "{\n                it.get…r(\"height\")\n            }");
                i2 = integer2.intValue();
            } else {
                i2 = -1;
            }
            this.height = i2;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = this.templateData;
        JSONObject jSONObject4 = jSONObject3 == null ? null : jSONObject3.getJSONObject("index.mock");
        if (jSONObject4 != null) {
            jSONObject2 = jSONObject4;
        }
        GaiaX.Params.Builder container = new GaiaX.Params.Builder().templateBiz("fastpreview").templateId(this.templateId).data(jSONObject2).mode(LoadType.SYNC_NORMAL).container(getContainerView());
        int i3 = this.width;
        if (i3 != -1) {
            container.width(ScreenUtils.INSTANCE.toPx(i3));
        } else {
            container.width(ScreenUtils.INSTANCE.getScreenWidthPx());
        }
        int i4 = this.height;
        if (i4 != -1) {
            container.height(ScreenUtils.INSTANCE.toPx(i4));
        }
        GaiaX.Params build = container.build();
        build.setEventDelegate(new GaiaX.IEventDelegate() { // from class: com.youku.gaiax.fastpreview.ui.FastPreviewActivity$buildGaiaXParams$2
            @Override // com.youku.gaiax.GaiaX.IEventDelegate
            public void onEvent(@NotNull EventParams eventParams) {
                b41.i(eventParams, WXGlobalEventReceiver.EVENT_PARAMS);
                Log.d(GXSocket.TAG, "onEvent() called with: eventParams = [" + eventParams + jn1.ARRAY_END);
            }
        });
        build.setMessage(new GaiaX.IHostMessage() { // from class: com.youku.gaiax.fastpreview.ui.FastPreviewActivity$buildGaiaXParams$3
            @Override // com.youku.gaiax.GaiaX.IHostMessage
            public boolean onMessage(@NotNull String str, @NotNull JSONObject jSONObject5) {
                b41.i(str, "type");
                b41.i(jSONObject5, "data");
                Log.e(GXSocket.TAG, "onMessage() called with: type = [" + str + "], data = [" + jSONObject5 + jn1.ARRAY_END);
                return false;
            }
        });
        return build;
    }

    private final void doCreateOrReuse() {
        this.params = buildGaiaXParams();
        GaiaX companion = GaiaX.Companion.getInstance();
        GaiaX.Params params = this.params;
        b41.f(params);
        companion.bindView(params);
    }

    private final void doDestroy() {
        if (this.params != null) {
            GaiaX companion = GaiaX.Companion.getInstance();
            GaiaX.Params params = this.params;
            b41.f(params);
            companion.unbindView(params);
            this.params = null;
        }
        View containerView = getContainerView();
        if (containerView instanceof ViewGroup) {
            ((ViewGroup) containerView).removeAllViews();
        }
        containerView.setTag(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doForceCreate() {
        doDestroy();
        this.params = buildGaiaXParams();
        GaiaX companion = GaiaX.Companion.getInstance();
        GaiaX.Params params = this.params;
        b41.f(params);
        companion.bindView(params);
    }

    private final void doInvisible() {
        if (this.params != null) {
            GaiaX companion = GaiaX.Companion.getInstance();
            GaiaX.Params params = this.params;
            b41.f(params);
            companion.invisibleView(params);
        }
    }

    private final void doVisible() {
        if (this.params != null) {
            GaiaX companion = GaiaX.Companion.getInstance();
            GaiaX.Params params = this.params;
            b41.f(params);
            companion.visibleView(params);
        }
    }

    public final void OnCreate(@Nullable View view) {
        doForceCreate();
    }

    public final void OnDestroy(@Nullable View view) {
        doDestroy();
    }

    public final void OnInvisible(@Nullable View view) {
        doInvisible();
    }

    public final void OnReuse(@Nullable View view) {
        doCreateOrReuse();
    }

    public final void OnSwitch(@Nullable View view) {
        if (!this.isSwitch) {
            this.isSwitch = true;
            View view2 = this.gaiax_render_root_parent;
            b41.f(view2);
            view2.setBackgroundColor(-1);
            return;
        }
        this.isSwitch = false;
        View view3 = this.gaiax_render_root_parent;
        b41.f(view3);
        view3.setBackgroundColor(Color.parseColor("#22252C"));
    }

    public final void OnVisible(@Nullable View view) {
        doVisible();
    }

    @NotNull
    public final View getContainerView() {
        View findViewById = findViewById(R.id.fast_preview_layout);
        b41.h(findViewById, "findViewById(R.id.fast_preview_layout)");
        return findViewById;
    }

    @Nullable
    public final FastPreviewListener getGxSocketToStudioListener() {
        return this.gxSocketToStudioListener;
    }

    public final boolean isSwitch() {
        return this.isSwitch;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.C7909layout.gaiax_fast_preview_activity);
        this.gaiax_render_root_parent = findViewById(R.id.gaiax_render_root_parent);
        findViewById(R.id.close).setOnClickListener(new View.OnClickListener() { // from class: com.youku.gaiax.fastpreview.ui.FastPreviewActivity$onCreate$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FastPreviewActivity.this.finish();
            }
        });
        Uri data = getIntent().getData();
        String encodedQuery = data == null ? null : data.getEncodedQuery();
        GXClientToStudio.C3381a c3381a = GXClientToStudio.Companion;
        JSONObject l = c3381a.a().l(encodedQuery);
        if (l == null) {
            finish();
            return;
        }
        GXClientToStudio a = c3381a.a();
        Context applicationContext = getApplicationContext();
        b41.h(applicationContext, "applicationContext");
        a.m(applicationContext);
        FastPreviewListener fastPreviewListener = new FastPreviewListener();
        this.gxSocketToStudioListener = fastPreviewListener;
        fastPreviewListener.setActivity(this);
        c3381a.a().t(this.gxSocketToStudioListener);
        IExperiment experiment = GaiaX.Companion.getInstance().experiment();
        if (experiment != null) {
            experiment.setGaiaXStudioSocket(this.jsIStudioSocket);
        }
        if (b41.d("auto", l.getString("TYPE"))) {
            c3381a.a().i(this, l);
        } else if (b41.d("manual", l.getString("TYPE"))) {
            c3381a.a().o(this, l);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        FastPreviewListener fastPreviewListener = this.gxSocketToStudioListener;
        if (fastPreviewListener != null) {
            fastPreviewListener.setActivity(null);
        }
        this.gxSocketToStudioListener = null;
    }

    public final void setGxSocketToStudioListener(@Nullable FastPreviewListener fastPreviewListener) {
        this.gxSocketToStudioListener = fastPreviewListener;
    }

    public final void setSwitch(boolean z) {
        this.isSwitch = z;
    }
}
