package com.alibaba.wireless.security.open.initialize;

import android.content.Context;
import com.alibaba.wireless.security.framework.ISGPluginManager;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.initialize.IInitializeComponent;

/* compiled from: Taobao */
/* renamed from: com.alibaba.wireless.security.open.initialize.a */
/* loaded from: classes8.dex */
public class C4023a implements IInitializeComponent {
    private C4024b a;

    public C4023a() {
        this.a = new C4024b();
    }

    public C4023a(String str) {
        this.a = new C4024b(str);
    }

    public int a(Context context, String str, boolean z) throws SecException {
        return this.a.b(context, str, z, true);
    }

    public ISGPluginManager a() {
        return this.a.a();
    }

    @Override // com.alibaba.wireless.security.open.initialize.IInitializeComponent
    public int initialize(Context context) throws SecException {
        return loadLibrarySync(context);
    }

    @Override // com.alibaba.wireless.security.open.initialize.IInitializeComponent
    public void initializeAsync(Context context) {
        try {
            loadLibraryAsync(context);
        } catch (SecException e) {
            e.printStackTrace();
        }
    }

    @Override // com.alibaba.wireless.security.open.initialize.IInitializeComponent
    public boolean isSoValid(Context context) throws SecException {
        return this.a.a(context);
    }

    @Override // com.alibaba.wireless.security.open.initialize.IInitializeComponent
    public void loadLibraryAsync(Context context) throws SecException {
        loadLibraryAsync(context, null);
    }

    @Override // com.alibaba.wireless.security.open.initialize.IInitializeComponent
    public void loadLibraryAsync(Context context, String str) throws SecException {
        this.a.a(context, str, true, true);
    }

    @Override // com.alibaba.wireless.security.open.initialize.IInitializeComponent
    public int loadLibrarySync(Context context) throws SecException {
        return loadLibrarySync(context, null);
    }

    @Override // com.alibaba.wireless.security.open.initialize.IInitializeComponent
    public int loadLibrarySync(Context context, String str) throws SecException {
        return this.a.b(context, str, true, true);
    }

    @Override // com.alibaba.wireless.security.open.initialize.IInitializeComponent
    public void registerInitFinishListener(IInitializeComponent.IInitFinishListener iInitFinishListener) throws SecException {
        this.a.a(iInitFinishListener);
    }

    @Override // com.alibaba.wireless.security.open.initialize.IInitializeComponent
    public void unregisterInitFinishListener(IInitializeComponent.IInitFinishListener iInitFinishListener) throws SecException {
        this.a.a(iInitFinishListener);
    }
}
