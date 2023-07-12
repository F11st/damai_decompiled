package com.alibaba.aliweex.bundle;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.alibaba.aliweex.R$id;
import com.alibaba.aliweex.bundle.WeexPageContract;
import com.alibaba.aliweex.bundle.WeexPageFragment;
import com.taobao.weex.IWXRenderListener;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.WXErrorCode;
import com.taobao.weex.utils.WXExceptionUtils;
import com.taobao.weex.utils.WXLogUtils;
import java.util.HashMap;

/* compiled from: Taobao */
/* renamed from: com.alibaba.aliweex.bundle.g */
/* loaded from: classes5.dex */
public class C3090g implements IWXRenderListener {
    private ViewGroup a;
    private WeexPageContract.IErrorView b;
    private WeexPageContract.IProgressBar c;
    private WeexPageContract.IUTPresenter d;
    private WeexPageFragment.C3076b e;
    private WeexPageFragment.C3076b f;

    public C3090g(ViewGroup viewGroup, WeexPageContract.IProgressBar iProgressBar, WeexPageContract.IUTPresenter iUTPresenter, WeexPageFragment.C3076b c3076b, WeexPageFragment.C3076b c3076b2) {
        this.a = viewGroup;
        this.c = iProgressBar;
        this.d = iUTPresenter;
        this.e = c3076b;
        this.f = c3076b2;
    }

    private boolean b() {
        WeexPageFragment.C3076b c3076b = this.e;
        return c3076b != null && c3076b.a();
    }

    private void c(View view) {
        if (view == null || view.getParent() == null || !(view.getParent() instanceof ViewGroup)) {
            return;
        }
        ((ViewGroup) view.getParent()).removeView(view);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d(android.view.View r3) {
        /*
            r2 = this;
            android.view.ViewGroup r0 = r2.a
            android.view.ViewParent r0 = r0.getParent()
            if (r0 == 0) goto L20
            boolean r1 = r0 instanceof android.view.ViewGroup
            if (r1 == 0) goto L20
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            int r1 = r0.getChildCount()
            if (r1 <= 0) goto L20
            int r1 = com.alibaba.aliweex.R$id.weex_render_view
            android.view.View r0 = r0.findViewById(r1)
            if (r0 == 0) goto L21
            r2.c(r0)
            goto L21
        L20:
            r0 = 0
        L21:
            if (r0 != 0) goto L32
            android.view.ViewGroup r0 = r2.a
            int r1 = com.alibaba.aliweex.R$id.weex_render_view
            android.view.View r0 = r0.findViewById(r1)
            if (r0 == 0) goto L32
            android.view.ViewGroup r1 = r2.a
            r1.removeView(r0)
        L32:
            if (r0 != 0) goto L37
            r2.c(r3)
        L37:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.aliweex.bundle.C3090g.d(android.view.View):void");
    }

    private void e(WXSDKInstance wXSDKInstance, String str) {
        int indexOf;
        HashMap hashMap = new HashMap(1);
        if (!TextUtils.isEmpty(str) && str.contains("networkMsg==") && str.contains("networkErrorCode") && (indexOf = str.indexOf("|mWXResponse")) > 0) {
            String substring = str.substring(0, indexOf);
            hashMap.put("wxErrorMsgDetail", str);
            str = substring;
        }
        String instanceId = wXSDKInstance.getInstanceId();
        WXErrorCode wXErrorCode = WXErrorCode.WX_KEY_EXCEPTION_JS_DOWNLOAD_FAILED;
        WXExceptionUtils.commitCriticalExceptionRT(instanceId, wXErrorCode, "WXRenderListener.onException", wXErrorCode.getErrorMsg() + "--" + str, hashMap);
    }

    public WeexPageFragment.C3076b a() {
        return this.e;
    }

    public void f(WeexPageContract.IErrorView iErrorView) {
        this.b = iErrorView;
    }

    public void g(WeexPageFragment.C3076b c3076b) {
        this.e = c3076b;
    }

    @Override // com.taobao.weex.IWXRenderListener
    public void onException(WXSDKInstance wXSDKInstance, String str, String str2) {
        boolean shouldDegrade;
        WXLogUtils.d("WXRenderListener", "into--[onException] errCode:" + str + " msg:" + str2);
        if (TextUtils.equals(str, WXErrorCode.WX_DEGRAD_ERR_NETWORK_BUNDLE_DOWNLOAD_FAILED.getErrorCode())) {
            this.b.createErrorView(wXSDKInstance.getContext(), this.a);
            this.b.showErrorView(true, "网络错误，点击刷新重试！");
            e(wXSDKInstance, str2);
            shouldDegrade = false;
        } else {
            shouldDegrade = WeexPageFragment.shouldDegrade(wXSDKInstance, str, str2);
        }
        if (WXEnvironment.isApkDebugable()) {
            Toast.makeText(wXSDKInstance.getContext(), str2, 1).show();
        }
        this.c.showProgressBar(false);
        this.f.onException(wXSDKInstance, str, str2);
        WeexPageFragment.C3076b c3076b = this.e;
        if (c3076b != null) {
            c3076b.c(wXSDKInstance, shouldDegrade, str, str2);
        }
    }

    @Override // com.taobao.weex.IWXRenderListener
    public void onRefreshSuccess(WXSDKInstance wXSDKInstance, int i, int i2) {
        WXLogUtils.d("WXRenderListener", "into--[onRefreshSuccess]");
        WeexPageContract.IProgressBar iProgressBar = this.c;
        if (iProgressBar != null) {
            iProgressBar.showProgressBar(false);
        }
    }

    @Override // com.taobao.weex.IWXRenderListener
    public void onRenderSuccess(WXSDKInstance wXSDKInstance, int i, int i2) {
        WXLogUtils.d("WXRenderListener", "into--[onRenderSuccess]");
        WeexPageFragment.C3076b c3076b = this.e;
        if (c3076b != null) {
            c3076b.onRenderSuccess(wXSDKInstance, i, i2);
        }
        WeexPageContract.IProgressBar iProgressBar = this.c;
        if (iProgressBar != null) {
            iProgressBar.showProgressBar(false);
        }
    }

    @Override // com.taobao.weex.IWXRenderListener
    public void onViewCreated(WXSDKInstance wXSDKInstance, View view) {
        WXLogUtils.d("WXRenderListener", "into--[onViewCreated]");
        if (this.a != null) {
            if (b()) {
                d(view);
                WeexPageFragment.C3076b c3076b = this.e;
                View b = c3076b != null ? c3076b.b(wXSDKInstance, view) : view;
                b.setId(R$id.weex_render_view);
                if (this.a.getParent() instanceof FrameLayout) {
                    ((ViewGroup) this.a.getParent()).addView(b);
                } else {
                    this.a.addView(b);
                }
            } else if (view.getParent() == null) {
                if (this.a.getChildCount() > 2) {
                    this.a.removeViewAt(2);
                }
                this.a.addView(view);
            }
            this.c.showProgressBar(false);
            this.f.onViewCreated(wXSDKInstance, view);
            WeexPageFragment.C3076b c3076b2 = this.e;
            if (c3076b2 != null) {
                c3076b2.onViewCreated(wXSDKInstance, view);
            }
            WeexPageContract.IUTPresenter iUTPresenter = this.d;
            if (iUTPresenter != null) {
                iUTPresenter.tryToUpdatePageSpmCnt(wXSDKInstance);
            }
        }
    }
}
