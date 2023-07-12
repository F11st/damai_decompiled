package com.taobao.wireless.security.sdk.initialize;

import android.content.Context;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.initialize.IInitializeComponent;
import com.taobao.wireless.security.sdk.initialize.IInitializeComponent;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class a implements IInitializeComponent {
    private Set<C0337a> a = new HashSet();
    private Object b = new Object();

    /* compiled from: Taobao */
    /* renamed from: com.taobao.wireless.security.sdk.initialize.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    class C0337a implements IInitializeComponent.IInitFinishListener {
        IInitializeComponent.IInitFinishListener a;

        public C0337a(a aVar, IInitializeComponent.IInitFinishListener iInitFinishListener) {
            this.a = iInitFinishListener;
        }

        @Override // com.alibaba.wireless.security.open.initialize.IInitializeComponent.IInitFinishListener
        public void onError() {
            this.a.onError();
        }

        @Override // com.alibaba.wireless.security.open.initialize.IInitializeComponent.IInitFinishListener
        public void onSuccess() {
            this.a.onSuccess();
        }
    }

    @Override // com.taobao.wireless.security.sdk.initialize.IInitializeComponent
    public int initialize(Context context) {
        try {
            return SecurityGuardManager.getInitializer().initialize(context);
        } catch (SecException e) {
            e.printStackTrace();
            return 1;
        }
    }

    @Override // com.taobao.wireless.security.sdk.initialize.IInitializeComponent
    public synchronized void initializeAsync(Context context) {
        SecurityGuardManager.getInitializer().initializeAsync(context);
    }

    @Override // com.taobao.wireless.security.sdk.initialize.IInitializeComponent
    public boolean isSoValid(Context context) {
        return true;
    }

    @Override // com.taobao.wireless.security.sdk.initialize.IInitializeComponent
    public synchronized void loadLibraryAsync(Context context) {
        SecurityGuardManager.getInitializer().initializeAsync(context);
    }

    @Override // com.taobao.wireless.security.sdk.initialize.IInitializeComponent
    public void loadLibraryAsync(Context context, String str) {
        try {
            SecurityGuardManager.getInitializer().loadLibraryAsync(context, str);
        } catch (SecException e) {
            e.printStackTrace();
        }
    }

    @Override // com.taobao.wireless.security.sdk.initialize.IInitializeComponent
    public synchronized int loadLibrarySync(Context context) {
        try {
        } catch (SecException e) {
            e.printStackTrace();
            return 1;
        }
        return SecurityGuardManager.getInitializer().loadLibrarySync(context);
    }

    @Override // com.taobao.wireless.security.sdk.initialize.IInitializeComponent
    public int loadLibrarySync(Context context, String str) {
        try {
            return SecurityGuardManager.getInitializer().loadLibrarySync(context, str);
        } catch (SecException e) {
            e.printStackTrace();
            return 1;
        }
    }

    @Override // com.taobao.wireless.security.sdk.initialize.IInitializeComponent
    public void registerInitFinishListener(IInitializeComponent.IInitFinishListener iInitFinishListener) {
        if (iInitFinishListener == null) {
            return;
        }
        C0337a c0337a = new C0337a(this, iInitFinishListener);
        synchronized (this.b) {
            this.a.add(c0337a);
        }
        try {
            SecurityGuardManager.getInitializer().registerInitFinishListener(c0337a);
        } catch (SecException e) {
            e.printStackTrace();
        }
    }

    @Override // com.taobao.wireless.security.sdk.initialize.IInitializeComponent
    public void unregisterInitFinishListener(IInitializeComponent.IInitFinishListener iInitFinishListener) {
        if (iInitFinishListener == null) {
            return;
        }
        C0337a c0337a = null;
        synchronized (this.b) {
            Iterator<C0337a> it = this.a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C0337a next = it.next();
                if (next.a == iInitFinishListener) {
                    c0337a = next;
                    break;
                }
            }
            if (c0337a != null) {
                this.a.remove(c0337a);
            }
        }
        if (c0337a == null) {
            return;
        }
        try {
            SecurityGuardManager.getInitializer().unregisterInitFinishListener(c0337a);
        } catch (SecException e) {
            e.printStackTrace();
        }
    }
}
