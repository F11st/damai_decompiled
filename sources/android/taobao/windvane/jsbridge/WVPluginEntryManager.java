package android.taobao.windvane.jsbridge;

import android.content.Context;
import android.content.Intent;
import android.taobao.windvane.util.WVContextUtil;
import android.taobao.windvane.webview.IWVWebView;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVPluginEntryManager {
    private Map<String, Object> entryMap = new HashMap();
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
    private Context mContext;
    private IWVWebView mWebView;

    public WVPluginEntryManager(Context context, IWVWebView iWVWebView) {
        this.mContext = null;
        this.mWebView = null;
        this.mContext = context;
        this.mWebView = iWVWebView;
    }

    public void addEntry(String str, Object obj) {
        this.lock.writeLock().lock();
        try {
            this.entryMap.put(str, obj);
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    public Object getEntry(String str) {
        Context realContext = WVContextUtil.getRealContext(this.mContext);
        if (realContext == null) {
            return "null";
        }
        this.lock.readLock().lock();
        try {
            Object obj = this.entryMap.get(str);
            if (obj == null) {
                this.lock.writeLock().lock();
                try {
                    if (this.entryMap.get(str) == null) {
                        WVApiPlugin createPlugin = WVPluginManager.createPlugin(str, realContext, this.mWebView);
                        if (createPlugin != null) {
                            this.entryMap.put(str, createPlugin);
                            obj = createPlugin;
                        }
                    } else {
                        obj = this.entryMap.get(str);
                    }
                } finally {
                    this.lock.writeLock().unlock();
                }
            }
            return obj;
        } finally {
            this.lock.readLock().unlock();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.lock.readLock().lock();
        try {
            for (Object obj : this.entryMap.values()) {
                if (obj instanceof WVApiPlugin) {
                    ((WVApiPlugin) obj).onActivityResult(i, i2, intent);
                }
            }
        } finally {
            this.lock.readLock().unlock();
        }
    }

    public void onDestroy() {
        this.lock.readLock().lock();
        try {
            for (Object obj : this.entryMap.values()) {
                if (obj instanceof WVApiPlugin) {
                    ((WVApiPlugin) obj).onDestroy();
                }
            }
            this.lock.readLock().unlock();
            this.lock.writeLock().lock();
            try {
                this.entryMap.clear();
            } finally {
                this.lock.writeLock().unlock();
            }
        } catch (Throwable th) {
            this.lock.readLock().unlock();
            throw th;
        }
    }

    public void onPause() {
        this.lock.readLock().lock();
        try {
            for (Object obj : this.entryMap.values()) {
                if (obj instanceof WVApiPlugin) {
                    ((WVApiPlugin) obj).onPause();
                }
            }
        } finally {
            this.lock.readLock().unlock();
        }
    }

    public void onResume() {
        this.lock.readLock().lock();
        try {
            for (Object obj : this.entryMap.values()) {
                if (obj instanceof WVApiPlugin) {
                    ((WVApiPlugin) obj).onResume();
                }
            }
        } finally {
            this.lock.readLock().unlock();
        }
    }

    public void onScrollChanged(int i, int i2, int i3, int i4) {
        this.lock.readLock().lock();
        try {
            for (Object obj : this.entryMap.values()) {
                if (obj instanceof WVApiPlugin) {
                    ((WVApiPlugin) obj).onScrollChanged(i, i2, i3, i4);
                }
            }
        } finally {
            this.lock.readLock().unlock();
        }
    }
}
