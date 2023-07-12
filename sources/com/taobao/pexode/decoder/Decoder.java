package com.taobao.pexode.decoder;

import android.content.Context;
import com.taobao.pexode.PexodeOptions;
import com.taobao.pexode.common.DegradeEventListener;
import com.taobao.pexode.entity.RewindableStream;
import com.taobao.pexode.exception.PexodeException;
import com.taobao.pexode.mimetype.MimeType;
import java.io.IOException;
import tb.or1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface Decoder {
    boolean acceptInputType(int i, MimeType mimeType, boolean z);

    boolean canDecodeIncrementally(MimeType mimeType);

    or1 decode(RewindableStream rewindableStream, PexodeOptions pexodeOptions, DegradeEventListener degradeEventListener) throws PexodeException, IOException;

    MimeType detectMimeType(byte[] bArr);

    boolean isSupported(MimeType mimeType);

    void prepare(Context context);
}
