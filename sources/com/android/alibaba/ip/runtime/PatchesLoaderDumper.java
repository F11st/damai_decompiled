package com.android.alibaba.ip.runtime;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class PatchesLoaderDumper {
    public static void main(String[] strArr) {
        try {
            ((PatchesLoader) Class.forName("com.android.alibaba.ip.runtime.AppPatchesLoaderImpl").newInstance()).load();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InstantiationException e3) {
            e3.printStackTrace();
        }
    }
}
