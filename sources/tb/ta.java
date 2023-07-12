package tb;

import android.app.Activity;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.yymidservice.popup.popupcenter.PopupPriorityManager;
import com.alibaba.yymidservice.popup.request.PopupListener;
import com.alibaba.yymidservice.popup.request.PopupRequest;
import com.alibaba.yymidservice.popup.request.bean.PopupResponseBean;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class ta {
    @Nullable
    private WeakReference<Activity> a;
    @Nullable
    private PopupPriorityManager b;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static final class a implements PopupListener {
        final /* synthetic */ PopupListener b;

        a(PopupListener popupListener) {
            this.b = popupListener;
        }

        @Override // com.alibaba.yymidservice.popup.request.PopupListener
        public void clickUpReport() {
        }

        @Override // com.alibaba.yymidservice.popup.request.PopupListener
        public void onFail(@Nullable String str, @Nullable String str2) {
            PopupPriorityManager b = ta.this.b();
            if (b != null) {
                b.j(null);
            }
            PopupListener popupListener = this.b;
            if (popupListener != null) {
                popupListener.onFail(str, str2);
            }
        }

        @Override // com.alibaba.yymidservice.popup.request.PopupListener
        public void onSuccess(@NotNull PopupResponseBean popupResponseBean) {
            b41.i(popupResponseBean, "bean");
            PopupPriorityManager b = ta.this.b();
            if (b != null) {
                b.j(popupResponseBean);
            }
            PopupListener popupListener = this.b;
            if (popupListener != null) {
                popupListener.onSuccess(popupResponseBean);
            }
        }
    }

    public static /* synthetic */ void f(ta taVar, String str, String str2, ArrayList arrayList, JSONObject jSONObject, PopupListener popupListener, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryPopupRequest");
        }
        if ((i & 1) != 0) {
            str = lt1.Companion.a().e();
        }
        taVar.e(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : arrayList, (i & 8) != 0 ? null : jSONObject, (i & 16) == 0 ? popupListener : null);
    }

    @Nullable
    public Activity a() {
        return (Activity) pt1.b(this.a);
    }

    @Nullable
    public final PopupPriorityManager b() {
        return this.b;
    }

    public final void c(@Nullable WeakReference<Activity> weakReference) {
        this.a = weakReference;
    }

    public final void d(@Nullable PopupPriorityManager popupPriorityManager) {
        this.b = popupPriorityManager;
    }

    public final void e(@NotNull String str, @Nullable String str2, @Nullable ArrayList<String> arrayList, @Nullable JSONObject jSONObject, @Nullable PopupListener popupListener) {
        wt2 wt2Var;
        b41.i(str, "comboCityId");
        Activity a2 = a();
        if (a2 != null) {
            PopupRequest popupRequest = PopupRequest.INSTANCE;
            if (str2 == null) {
                str2 = a2.getClass().getSimpleName();
            }
            String str3 = str2;
            b41.h(str3, "sceneType ?: it::class.java.simpleName");
            popupRequest.b(a2, str, str3, arrayList, jSONObject, new a(popupListener));
            wt2Var = wt2.INSTANCE;
        } else {
            wt2Var = null;
        }
        if (wt2Var == null) {
            pt1.g("mCurrentActivity_null", AgooConstants.MESSAGE_POPUP, "tryPopupRequest", null);
        }
    }
}
