package tb;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.yymidservice.R$id;
import com.alibaba.yymidservice.R$layout;
import com.alient.gaiax.container.gaiax.GaiaXBuilder;
import com.alient.gaiax.container.gaiax.PictureGaiaXDelegate;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class j80 {
    @NotNull
    public static final a Companion = new a(null);

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }

        @JvmOverloads
        @NotNull
        public final View a(@NotNull Activity activity, @Nullable String str, @NotNull String str2, @Nullable String str3, @Nullable JSONObject jSONObject, float f, @NotNull PictureGaiaXDelegate pictureGaiaXDelegate, boolean z, boolean z2) {
            b41.i(activity, "activity");
            b41.i(str2, "templateId");
            b41.i(pictureGaiaXDelegate, "yyDelegate");
            View inflate = activity.getLayoutInflater().inflate(R$layout.component_common_gaiax, (ViewGroup) null);
            b41.h(inflate, "activity.layoutInflater.…onent_common_gaiax, null)");
            View findViewById = inflate.findViewById(R$id.component_common_gaiax_layout);
            b41.g(findViewById, "null cannot be cast to non-null type android.widget.FrameLayout");
            boolean z3 = false;
            GaiaXBuilder.renderGaiaX$default(new GaiaXBuilder(), (FrameLayout) findViewById, activity, str == null || str.length() == 0 ? "" : str, str2, (str3 == null || str3.length() == 0) ? true : true ? "" : str3, null, jSONObject, f, 0, pictureGaiaXDelegate, z, z2, null, 4128, null);
            return inflate;
        }
    }
}
