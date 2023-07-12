package com.alibaba.security.realidentity.jsbridge;

import com.alibaba.security.common.d.C3810g;
import com.alibaba.security.common.d.C3811h;
import com.alibaba.security.common.track.RPTrack;
import com.alibaba.security.common.track.model.LastExitTrackMsg;
import com.alibaba.security.common.track.model.LastExitTrackMsgPage;
import com.alibaba.security.realidentity.a.C3847g;
import java.io.File;

/* compiled from: Taobao */
@InterfaceC3904f(a = "finish")
/* renamed from: com.alibaba.security.realidentity.jsbridge.d */
/* loaded from: classes8.dex */
public class C3902d extends AbstractC3893a {
    private static final String as = "FinishJSApi";

    private static void d() {
        if (C3810g.a() != null) {
            C3810g.a(new File(C3810g.a()));
        }
    }

    private static LastExitTrackMsg e() {
        LastExitTrackMsg lastExitTrackMsg = new LastExitTrackMsg();
        lastExitTrackMsg.setPage(LastExitTrackMsgPage.H5.getMsg());
        lastExitTrackMsg.setView("");
        RPTrack.LastExitTrackParams lastExitTrackParams = new RPTrack.LastExitTrackParams();
        lastExitTrackParams.setUrl(C3847g.C3848a.a.f);
        lastExitTrackMsg.setParams(C3811h.a(lastExitTrackParams));
        return lastExitTrackMsg;
    }

    private static RPTrack.LastExitTrackParams f() {
        RPTrack.LastExitTrackParams lastExitTrackParams = new RPTrack.LastExitTrackParams();
        lastExitTrackParams.setUrl(C3847g.C3848a.a.f);
        return lastExitTrackParams;
    }

    @Override // com.alibaba.security.realidentity.jsbridge.AbstractC3893a
    protected final String a() {
        return "finish";
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0101  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0059 -> B:27:0x0065). Please submit an issue!!! */
    @Override // com.alibaba.security.realidentity.jsbridge.AbstractC3893a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(java.lang.String r10, com.alibaba.security.realidentity.jsbridge.AbstractC3907h r11) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.realidentity.jsbridge.C3902d.a(java.lang.String, com.alibaba.security.realidentity.jsbridge.h):boolean");
    }
}
