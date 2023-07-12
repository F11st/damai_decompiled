package com.taobao.android.preview;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.Keep;
import com.taobao.android.dinamicx.AbstractC6362a;
import com.taobao.android.dinamicx.C6387n;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.preview.DXTemplatePreviewActivity;
import tb.hy;
import tb.iz;
import tb.rt;

/* compiled from: Taobao */
@Keep
/* loaded from: classes11.dex */
public class DXPreviewInterfaceImpl implements DXTemplatePreviewActivity.DXPreviewInterface {

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.preview.DXPreviewInterfaceImpl$a */
    /* loaded from: classes11.dex */
    class C6554a extends AbstractC6362a {
        final /* synthetic */ C6387n a;

        C6554a(DXPreviewInterfaceImpl dXPreviewInterfaceImpl, C6387n c6387n) {
            this.a = c6387n;
        }

        @Override // com.taobao.android.dinamicx.IDXEventHandler
        public void handleEvent(hy hyVar, Object[] objArr, DXRuntimeContext dXRuntimeContext) {
            if (hyVar instanceof rt) {
                Log.i("lx", "checked=" + ((rt) hyVar).f());
            }
            String obj = objArr != null ? objArr.toString() : null;
            Context f = C6387n.f();
            Toast.makeText(f, "收到点击 参数为: " + obj, 0).show();
        }
    }

    @Override // com.taobao.android.preview.DXTemplatePreviewActivity.DXPreviewInterface
    public void previewEngineDidInitialized(C6387n c6387n) {
        Log.e("shandian", "反射调用previewEngineDidInitialized");
        c6387n.k(iz.a("test"), new C6554a(this, c6387n));
    }
}
