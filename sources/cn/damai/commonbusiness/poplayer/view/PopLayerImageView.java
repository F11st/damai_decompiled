package cn.damai.commonbusiness.poplayer.view;

import android.app.AlertDialog;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.alibaba.poplayer.factory.PLViewInfo;
import com.alibaba.poplayer.factory.view.base.PopLayerBaseView;
import com.alibaba.poplayer.trigger.BaseConfigItem;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.json.JSONObject;
import org.json.JSONTokener;
import tb.dt1;
import tb.et1;
import tb.p40;
import tb.t01;

/* compiled from: Taobao */
@PLViewInfo(type = "image")
/* loaded from: classes4.dex */
public class PopLayerImageView extends PopLayerBaseView<DMImageView, t01> {
    private static transient /* synthetic */ IpChange $ipChange;
    private String url;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.poplayer.view.PopLayerImageView$a */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC0774a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0774a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-708778825")) {
                ipChange.ipc$dispatch("-708778825", new Object[]{this, view});
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("groupId", PopLayerImageView.this.getAttachInfo("groupId"));
                PopLayerImageView.this.fireEventToMasterIfExist("clicked", jSONObject.toString());
                dt1.b("PopLayerImageView.onClick:clicked.", new Object[0]);
            } catch (Throwable th) {
                dt1.c("PopLayerImageView. fire event error.", th);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.poplayer.view.PopLayerImageView$b */
    /* loaded from: classes4.dex */
    public class C0775b extends ClickableSpan {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ BaseConfigItem a;

        C0775b(BaseConfigItem baseConfigItem) {
            this.a = baseConfigItem;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1402511544")) {
                ipChange.ipc$dispatch("1402511544", new Object[]{this, view});
                return;
            }
            AlertDialog create = new AlertDialog.Builder(PopLayerImageView.this.getContext().getApplicationContext(), 3).setMessage(this.a.toString()).setTitle(String.format("Configuration DescItem for %s", this.a.uuid)).create();
            create.getWindow().setType(2038);
            create.show();
        }
    }

    public PopLayerImageView(Context context) {
        super(context);
    }

    private static ImageView.ScaleType getScaleType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1924629829")) {
            return (ImageView.ScaleType) ipChange.ipc$dispatch("-1924629829", new Object[]{str});
        }
        if ("ScaleAspectFit".equals(str)) {
            return ImageView.ScaleType.FIT_CENTER;
        }
        if ("ScaleAspectFill".equals(str)) {
            return ImageView.ScaleType.CENTER_CROP;
        }
        if ("ScaleToFill".equals(str)) {
            return ImageView.ScaleType.FIT_XY;
        }
        if ("SameSizeCentered".equals(str)) {
            return ImageView.ScaleType.CENTER;
        }
        return ImageView.ScaleType.FIT_CENTER;
    }

    @Override // com.alibaba.poplayer.factory.view.base.PopLayerBaseView
    public void destroyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1032256274")) {
            ipChange.ipc$dispatch("1032256274", new Object[]{this});
            return;
        }
        super.destroyView();
        InnerView innerview = this.mInnerView;
        if (innerview != 0) {
            ((DMImageView) innerview).setImageUrl(null);
            this.mInnerView = null;
        }
    }

    @Override // com.alibaba.poplayer.factory.view.base.PopLayerBaseView
    public SpannableStringBuilder getInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2136244016")) {
            return (SpannableStringBuilder) ipChange.ipc$dispatch("2136244016", new Object[]{this});
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        try {
            BaseConfigItem r = getPopRequest().r();
            p40.a(spannableStringBuilder, "UUID", r.uuid, null, new C0775b(r));
            p40.a(spannableStringBuilder, "PopTimes", et1.b(r.uuid, -1) + "", null, null);
            p40.a(spannableStringBuilder, "ImageUrl", this.url, null, null);
            p40.a(spannableStringBuilder, "ModalThreshold", String.format("%.2f", Float.valueOf(((float) getPenetrateAlpha()) / 255.0f)) + "/" + getPenetrateAlpha(), null, null);
        } catch (Throwable unused) {
            p40.a(spannableStringBuilder, "Error", "getInfo Error", null, null);
        }
        return spannableStringBuilder;
    }

    @Override // com.alibaba.poplayer.factory.view.base.PopLayerBaseView
    public void onReceiveEvent(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "993515287")) {
            ipChange.ipc$dispatch("993515287", new Object[]{this, str, str2});
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if ("modifyImage".equals(str)) {
                String optString = new JSONObject(str2).optString("imgUrl");
                if (!TextUtils.isEmpty(optString)) {
                    ((DMImageView) this.mInnerView).setImageUrl(optString);
                    jSONObject.put("succeed", true);
                } else {
                    jSONObject.put("succeed", false);
                }
            } else if ("modifyImageFillMode".equals(str)) {
                String optString2 = new JSONObject(str2).optString("imgFillMode", null);
                if (!TextUtils.isEmpty(optString2)) {
                    ((DMImageView) this.mInnerView).setScaleType(getScaleType(optString2));
                    jSONObject.put("succeed", true);
                } else {
                    jSONObject.put("succeed", false);
                }
            } else {
                jSONObject.put("succeed", false);
                str = "NoSuchOperation";
            }
            fireEventToMasterIfExist(str, jSONObject.toString());
        } catch (Throwable th) {
            dt1.c("ImageTrackController.onReceiveEvent error.", th);
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [InnerView, cn.damai.commonbusiness.poplayer.view.DMImageView, android.widget.ImageView] */
    @Override // com.alibaba.poplayer.factory.view.base.PopLayerBaseView
    public void init(Context context, t01 t01Var) {
        JSONObject jSONObject;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-328919122")) {
            ipChange.ipc$dispatch("-328919122", new Object[]{this, context, t01Var});
            return;
        }
        try {
            String str = t01Var.r().params;
            jSONObject = TextUtils.isEmpty(str) ? null : (JSONObject) new JSONTokener(str).nextValue();
            if (jSONObject == null) {
                return;
            }
        } catch (Throwable th) {
            dt1.c("PopLayerView init fail.", th);
            jSONObject = null;
        }
        String optString = jSONObject.optString("imgUrl", null);
        this.url = optString;
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        ?? dMImageView = new DMImageView(context);
        dMImageView.setImageUrl(this.url);
        dMImageView.setScaleType(getScaleType(jSONObject.optString("imgFillMode", "ScaleAspectFit")));
        dMImageView.setOnClickListener(new View$OnClickListenerC0774a());
        this.mInnerView = dMImageView;
        addView((View) dMImageView, new FrameLayout.LayoutParams(-1, -1));
        showCloseButton(t01Var.r().showCloseBtn);
        increaseReadTimes(t01Var.r().uuid);
        setPenetrateAlpha((int) (t01Var.r().modalThreshold * 255.0d));
    }
}
