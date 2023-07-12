package com.alibaba.security.realidentity.d;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.alibaba.security.common.d.h;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.realidentity.a.g;
import com.alibaba.security.realidentity.business.dynamic.model.BcConfig;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.litevm.ILiteVMComponent;
import com.alibaba.wireless.security.open.litevm.LiteVMInstance;
import com.alibaba.wireless.security.open.litevm.LiteVMParamType;
import com.alibaba.wireless.security.open.litevm.LiteVMParameterWrapper;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class b extends a {
    public BcConfig g;
    public boolean h;

    public b(com.alibaba.security.realidentity.e.a aVar) {
        super(aVar);
        this.h = true;
    }

    private void a(BcConfig bcConfig, boolean z) {
        this.g = bcConfig;
        this.h = z;
    }

    private static boolean j() {
        return false;
    }

    private static boolean k() {
        return false;
    }

    private static boolean l() {
        return false;
    }

    private static boolean m() {
        return false;
    }

    private static String n() {
        return null;
    }

    private static Pair<Boolean, String> o() {
        return new Pair<>(Boolean.TRUE, "");
    }

    private BcConfig p() {
        return this.g;
    }

    @Override // com.alibaba.security.realidentity.d.a
    protected final String i() {
        return null;
    }

    @Override // com.alibaba.security.realidentity.d.a
    public final byte[] a(byte[] bArr, String str) {
        if (this.h) {
            BcConfig bcConfig = this.g;
            if (bcConfig != null && !TextUtils.isEmpty(bcConfig.getAuthCode()) && !TextUtils.isEmpty(this.g.getBcDesc()) && this.g.getBcContent() != null && bArr != null) {
                try {
                    ILiteVMComponent iLiteVMComponent = (ILiteVMComponent) SecurityGuardManager.getInstance(this.c, null).getInterface(ILiteVMComponent.class);
                    LiteVMInstance createLiteVMInstance = iLiteVMComponent.createLiteVMInstance(this.g.getAuthCode(), this.g.getBcDesc(), Base64.decode(this.g.getBcContent(), 0), null);
                    byte[] callLiteVMByteMethod = iLiteVMComponent.callLiteVMByteMethod(createLiteVMInstance, 0, new LiteVMParameterWrapper[]{new LiteVMParameterWrapper(LiteVMParamType.PARAM_TYPE.PARAM_TYPE_DATA, bArr)});
                    iLiteVMComponent.destroyLiteVMInstance(createLiteVMInstance);
                    a(0, "BC processing success", str);
                    return callLiteVMByteMethod;
                } catch (Throwable th) {
                    com.alibaba.security.common.c.a.b();
                    a(-1, th.getMessage(), str);
                    return bArr;
                }
            }
            a(-1, "BC or raw Data error", str);
            return null;
        }
        return bArr;
    }

    private static void a(int i, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("fileName", str2);
        hashMap.put("errorCode", Integer.valueOf(i));
        hashMap.put("errorMsg", str);
        g.a.a.a(TrackLog.createVmEncryptLog(i, str, h.a((Map) hashMap)));
    }
}
