package com.taobao.login4android.video;

import com.alibaba.idst.nls.internal.codec.OupsCodec;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class VoiceCodecs {
    private OupsCodec mOupsCodec;

    public VoiceCodecs() {
        this.mOupsCodec = null;
        this.mOupsCodec = new OupsCodec();
    }

    public int bufferFrame(short[] sArr, byte[] bArr) {
        return this.mOupsCodec.encodec(sArr, 0, 320, bArr);
    }

    public void close() {
        this.mOupsCodec.close();
    }

    public boolean open(boolean z) {
        return this.mOupsCodec.open(z);
    }
}
