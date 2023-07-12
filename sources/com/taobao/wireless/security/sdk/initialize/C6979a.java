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
/* renamed from: com.taobao.wireless.security.sdk.initialize.a */
/* loaded from: classes11.dex */
public class C6979a implements IInitializeComponent {
    private Set<C6980a> a = new HashSet();
    private Object b = new Object();

    /* compiled from: Taobao */
    /* renamed from: com.taobao.wireless.security.sdk.initialize.a$a */
    /* loaded from: classes11.dex */
    class C6980a implements IInitializeComponent.IInitFinishListener {
        IInitializeComponent.IInitFinishListener a;

        public C6980a(C6979a c6979a, IInitializeComponent.IInitFinishListener iInitFinishListener) {
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
        C6980a c6980a = new C6980a(this, iInitFinishListener);
        synchronized (this.b) {
            this.a.add(c6980a);
        }
        try {
            SecurityGuardManager.getInitializer().registerInitFinishListener(c6980a);
        } catch (SecException e) {
            e.printStackTrace();
        }
    }

    @Override // com.taobao.wireless.security.sdk.initialize.IInitializeComponent
    public void unregisterInitFinishListener(IInitializeComponent.IInitFinishListener iInitFinishListener) {
        if (iInitFinishListener == null) {
            return;
        }
        C6980a c6980a = null;
        synchronized (this.b) {
            Iterator<C6980a> it = this.a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C6980a next = it.next();
                if (next.a == iInitFinishListener) {
                    c6980a = next;
                    break;
                }
            }
            if (c6980a != null) {
                this.a.remove(c6980a);
            }
        }
        if (c6980a == null) {
            return;
        }
        try {
            SecurityGuardManager.getInitializer().unregisterInitFinishListener(c6980a);
        } catch (SecException e) {
            e.printStackTrace();
        }
    }
}
