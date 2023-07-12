package com.alibaba.aliweex.adapter.adapter;

import com.taobao.android.autosize.TBDeviceUtils;
import com.taobao.weex.adapter.IWXFoldDeviceAdapter;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class a implements IWXFoldDeviceAdapter {
    private static a a;

    private a() {
    }

    public static a a() {
        try {
            Class.forName(TBDeviceUtils.class.getName());
            if (a == null) {
                synchronized (a.class) {
                    if (a == null) {
                        a = new a();
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
        return TBDeviceUtils.isFoldDevice(com.alibaba.aliweex.a.l().e());
    }

    @Override // com.taobao.weex.adapter.IWXFoldDeviceAdapter
    public boolean isGalaxyFold() {
        return TBDeviceUtils.isGalaxyFold(com.alibaba.aliweex.a.l().e());
    }

    @Override // com.taobao.weex.adapter.IWXFoldDeviceAdapter
    public boolean isMateX() {
        return TBDeviceUtils.isMateX(com.alibaba.aliweex.a.l().e());
    }
}
