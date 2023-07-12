package com.alibaba.aliweex.adapter.adapter;

import com.alibaba.aliweex.C3004a;
import com.taobao.android.autosize.TBDeviceUtils;
import com.taobao.weex.adapter.IWXFoldDeviceAdapter;

/* compiled from: Taobao */
/* renamed from: com.alibaba.aliweex.adapter.adapter.a */
/* loaded from: classes5.dex */
public class C3016a implements IWXFoldDeviceAdapter {
    private static C3016a a;

    private C3016a() {
    }

    public static C3016a a() {
        try {
            Class.forName(TBDeviceUtils.class.getName());
            if (a == null) {
                synchronized (C3016a.class) {
                    if (a == null) {
                        a = new C3016a();
                    }
                }
            }
            return a;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.taobao.weex.adapter.IWXFoldDeviceAdapter
    public boolean isFoldDevice() {
        return TBDeviceUtils.isFoldDevice(C3004a.l().e());
    }

    @Override // com.taobao.weex.adapter.IWXFoldDeviceAdapter
    public boolean isGalaxyFold() {
        return TBDeviceUtils.isGalaxyFold(C3004a.l().e());
    }

    @Override // com.taobao.weex.adapter.IWXFoldDeviceAdapter
    public boolean isMateX() {
        return TBDeviceUtils.isMateX(C3004a.l().e());
    }
}
