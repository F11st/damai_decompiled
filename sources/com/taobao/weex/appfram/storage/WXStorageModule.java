package com.taobao.weex.appfram.storage;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.appfram.storage.IWXStorageAdapter;
import com.taobao.weex.bridge.JSCallback;
import java.util.Map;
import tb.vg2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXStorageModule extends WXSDKEngine.DestroyableModule implements IWXStorage {
    IWXStorageAdapter mStorageAdapter;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class a implements IWXStorageAdapter.OnResultReceivedListener {
        final /* synthetic */ JSCallback a;

        a(WXStorageModule wXStorageModule, JSCallback jSCallback) {
            this.a = jSCallback;
        }

        @Override // com.taobao.weex.appfram.storage.IWXStorageAdapter.OnResultReceivedListener
        public void onReceived(Map<String, Object> map) {
            JSCallback jSCallback = this.a;
            if (jSCallback != null) {
                jSCallback.invoke(map);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class b implements IWXStorageAdapter.OnResultReceivedListener {
        final /* synthetic */ JSCallback a;

        b(WXStorageModule wXStorageModule, JSCallback jSCallback) {
            this.a = jSCallback;
        }

        @Override // com.taobao.weex.appfram.storage.IWXStorageAdapter.OnResultReceivedListener
        public void onReceived(Map<String, Object> map) {
            JSCallback jSCallback = this.a;
            if (jSCallback != null) {
                jSCallback.invoke(map);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class c implements IWXStorageAdapter.OnResultReceivedListener {
        final /* synthetic */ JSCallback a;

        c(WXStorageModule wXStorageModule, JSCallback jSCallback) {
            this.a = jSCallback;
        }

        @Override // com.taobao.weex.appfram.storage.IWXStorageAdapter.OnResultReceivedListener
        public void onReceived(Map<String, Object> map) {
            JSCallback jSCallback = this.a;
            if (jSCallback != null) {
                jSCallback.invoke(map);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class d implements IWXStorageAdapter.OnResultReceivedListener {
        final /* synthetic */ JSCallback a;

        d(WXStorageModule wXStorageModule, JSCallback jSCallback) {
            this.a = jSCallback;
        }

        @Override // com.taobao.weex.appfram.storage.IWXStorageAdapter.OnResultReceivedListener
        public void onReceived(Map<String, Object> map) {
            JSCallback jSCallback = this.a;
            if (jSCallback != null) {
                jSCallback.invoke(map);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class e implements IWXStorageAdapter.OnResultReceivedListener {
        final /* synthetic */ JSCallback a;

        e(WXStorageModule wXStorageModule, JSCallback jSCallback) {
            this.a = jSCallback;
        }

        @Override // com.taobao.weex.appfram.storage.IWXStorageAdapter.OnResultReceivedListener
        public void onReceived(Map<String, Object> map) {
            JSCallback jSCallback = this.a;
            if (jSCallback != null) {
                jSCallback.invoke(map);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class f implements IWXStorageAdapter.OnResultReceivedListener {
        final /* synthetic */ JSCallback a;

        f(WXStorageModule wXStorageModule, JSCallback jSCallback) {
            this.a = jSCallback;
        }

        @Override // com.taobao.weex.appfram.storage.IWXStorageAdapter.OnResultReceivedListener
        public void onReceived(Map<String, Object> map) {
            JSCallback jSCallback = this.a;
            if (jSCallback != null) {
                jSCallback.invoke(map);
            }
        }
    }

    private IWXStorageAdapter ability() {
        IWXStorageAdapter iWXStorageAdapter = this.mStorageAdapter;
        if (iWXStorageAdapter != null) {
            return iWXStorageAdapter;
        }
        IWXStorageAdapter iWXStorageAdapter2 = WXSDKEngine.getIWXStorageAdapter();
        this.mStorageAdapter = iWXStorageAdapter2;
        return iWXStorageAdapter2;
    }

    @Override // com.taobao.weex.common.Destroyable
    public void destroy() {
        IWXStorageAdapter ability = ability();
        if (ability != null) {
            ability.close();
        }
    }

    @Override // com.taobao.weex.appfram.storage.IWXStorage
    @JSMethod(uiThread = false)
    public void getAllKeys(@Nullable JSCallback jSCallback) {
        IWXStorageAdapter ability = ability();
        if (ability == null) {
            vg2.e(jSCallback);
        } else {
            ability.getAllKeys(new e(this, jSCallback));
        }
    }

    @Override // com.taobao.weex.appfram.storage.IWXStorage
    @JSMethod(uiThread = false)
    public void getItem(String str, @Nullable JSCallback jSCallback) {
        if (TextUtils.isEmpty(str)) {
            vg2.d(jSCallback);
            return;
        }
        IWXStorageAdapter ability = ability();
        if (ability == null) {
            vg2.e(jSCallback);
        } else {
            ability.getItem(str, new b(this, jSCallback));
        }
    }

    @Override // com.taobao.weex.appfram.storage.IWXStorage
    @JSMethod(uiThread = false)
    public void length(@Nullable JSCallback jSCallback) {
        IWXStorageAdapter ability = ability();
        if (ability == null) {
            vg2.e(jSCallback);
        } else {
            ability.length(new d(this, jSCallback));
        }
    }

    @Override // com.taobao.weex.appfram.storage.IWXStorage
    @JSMethod(uiThread = false)
    public void removeItem(String str, @Nullable JSCallback jSCallback) {
        if (TextUtils.isEmpty(str)) {
            vg2.d(jSCallback);
            return;
        }
        IWXStorageAdapter ability = ability();
        if (ability == null) {
            vg2.e(jSCallback);
        } else {
            ability.removeItem(str, new c(this, jSCallback));
        }
    }

    @Override // com.taobao.weex.appfram.storage.IWXStorage
    @JSMethod(uiThread = false)
    public void setItem(String str, String str2, @Nullable JSCallback jSCallback) {
        if (!TextUtils.isEmpty(str) && str2 != null) {
            IWXStorageAdapter ability = ability();
            if (ability == null) {
                vg2.e(jSCallback);
                return;
            } else {
                ability.setItem(str, str2, new a(this, jSCallback));
                return;
            }
        }
        vg2.d(jSCallback);
    }

    @Override // com.taobao.weex.appfram.storage.IWXStorage
    @JSMethod(uiThread = false)
    public void setItemPersistent(String str, String str2, @Nullable JSCallback jSCallback) {
        if (!TextUtils.isEmpty(str) && str2 != null) {
            IWXStorageAdapter ability = ability();
            if (ability == null) {
                vg2.e(jSCallback);
                return;
            } else {
                ability.setItemPersistent(str, str2, new f(this, jSCallback));
                return;
            }
        }
        vg2.d(jSCallback);
    }
}
