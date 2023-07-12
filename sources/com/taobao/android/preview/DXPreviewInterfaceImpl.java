package com.taobao.android.preview;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.Keep;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.n;
import com.taobao.android.preview.DXTemplatePreviewActivity;
import tb.hy;
import tb.iz;
import tb.rt;

/* compiled from: Taobao */
@Keep
/* loaded from: classes11.dex */
public class DXPreviewInterfaceImpl implements DXTemplatePreviewActivity.DXPreviewInterface {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class a extends com.taobao.android.dinamicx.a {
        final /* synthetic */ n a;

        a(DXPreviewInterfaceImpl dXPreviewInterfaceImpl, n nVar) {
            this.a = nVar;
        }

        @Override // com.taobao.android.dinamicx.IDXEventHandler
        public void handleEvent(hy hyVar, Object[] objArr, DXRuntimeContext dXRuntimeContext) {
            if (hyVar instanceof rt) {
                Log.i("lx", "checked=" + ((rt) hyVar).f());
            }
            String obj = objArr != null ? objArr.toString() : null;
            Context f = n.f();
            Toast.makeText(f, "收到点击 参数为: " + obj, 0).show();
        }
    }

    @Override // com.taobao.android.preview.DXTemplatePreviewActivity.DXPreviewInterface
    public void previewEngineDidInitialized(n nVar) {
        Log.e("shandian", "反射调用previewEngineDidInitialized");
        nVar.k(iz.a("test"), new a(this, nVar));
    }
}
