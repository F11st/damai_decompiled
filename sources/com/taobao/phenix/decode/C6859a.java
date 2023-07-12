package com.taobao.phenix.decode;

import com.taobao.pexode.PexodeOptions;
import com.taobao.phenix.loader.network.IncompleteResponseException;
import com.taobao.phenix.request.C6865a;
import com.taobao.rxm.consume.Consumer;
import com.taobao.rxm.produce.BaseChainProducer;
import com.taobao.rxm.request.RequestCancelListener;
import tb.cu1;
import tb.ne0;
import tb.oe0;
import tb.ur1;
import tb.xt2;
import tb.z40;

/* compiled from: Taobao */
/* renamed from: com.taobao.phenix.decode.a */
/* loaded from: classes11.dex */
public class C6859a extends BaseChainProducer<z40, oe0, C6865a> implements RequestCancelListener<C6865a> {
    public C6859a() {
        super(0, 1);
    }

    private void I(Consumer<z40, C6865a> consumer, boolean z, oe0 oe0Var, DecodeException decodeException) {
        if (z) {
            decodeException.setLocalUri(consumer.getContext().G().n());
            Throwable th = decodeException;
            if (oe0Var != null) {
                decodeException.dataFromDisk(oe0Var.k);
                th = decodeException;
                if (!oe0Var.k) {
                    th = decodeException;
                    if (!oe0Var.g) {
                        th = decodeException;
                        if (oe0Var.a()) {
                            xt2.x("Decoder", consumer.getContext(), "actual decode error=%s, convert to error=IncompleteContentError", decodeException);
                            th = new IncompleteResponseException();
                        }
                    }
                }
            }
            consumer.onFailure(th);
            return;
        }
        xt2.m("Decoder", consumer.getContext(), "intermediate result decode error=%s, request not failed yet", decodeException);
    }

    private oe0 J(oe0 oe0Var) {
        EncodedDataInspector h = ur1.o().h();
        if (h == null) {
            return oe0Var;
        }
        ne0 inspectEncodedData = h.inspectEncodedData(oe0Var.i, oe0Var);
        cu1.b(inspectEncodedData != null && inspectEncodedData.a(), "inspected data cannot be null or not available!");
        return inspectEncodedData == oe0Var ? oe0Var : oe0Var.d(inspectEncodedData, oe0Var.l).f(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:166:0x031b, code lost:
        if (r22 != r7) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x033c, code lost:
        if (r22 != r7) goto L24;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02f0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02f7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0314 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0335 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:177:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:213:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0161 A[Catch: all -> 0x0297, UnsatisfiedLinkError -> 0x029b, OutOfMemoryError -> 0x029f, TryCatch #14 {OutOfMemoryError -> 0x029f, UnsatisfiedLinkError -> 0x029b, all -> 0x0297, blocks: (B:77:0x01b1, B:79:0x01b9, B:84:0x01cc, B:86:0x01df, B:88:0x01f1, B:90:0x01f7, B:52:0x0104, B:56:0x010e, B:58:0x015c, B:60:0x0161, B:62:0x016a, B:63:0x016f, B:65:0x0173, B:67:0x0179, B:69:0x0187, B:71:0x018c, B:72:0x0192, B:76:0x01ac), top: B:204:0x0104 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x016a A[Catch: all -> 0x0297, UnsatisfiedLinkError -> 0x029b, OutOfMemoryError -> 0x029f, TryCatch #14 {OutOfMemoryError -> 0x029f, UnsatisfiedLinkError -> 0x029b, all -> 0x0297, blocks: (B:77:0x01b1, B:79:0x01b9, B:84:0x01cc, B:86:0x01df, B:88:0x01f1, B:90:0x01f7, B:52:0x0104, B:56:0x010e, B:58:0x015c, B:60:0x0161, B:62:0x016a, B:63:0x016f, B:65:0x0173, B:67:0x0179, B:69:0x0187, B:71:0x018c, B:72:0x0192, B:76:0x01ac), top: B:204:0x0104 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x018c A[Catch: all -> 0x0297, UnsatisfiedLinkError -> 0x029b, OutOfMemoryError -> 0x029f, TryCatch #14 {OutOfMemoryError -> 0x029f, UnsatisfiedLinkError -> 0x029b, all -> 0x0297, blocks: (B:77:0x01b1, B:79:0x01b9, B:84:0x01cc, B:86:0x01df, B:88:0x01f1, B:90:0x01f7, B:52:0x0104, B:56:0x010e, B:58:0x015c, B:60:0x0161, B:62:0x016a, B:63:0x016f, B:65:0x0173, B:67:0x0179, B:69:0x0187, B:71:0x018c, B:72:0x0192, B:76:0x01ac), top: B:204:0x0104 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01b9 A[Catch: all -> 0x0297, UnsatisfiedLinkError -> 0x029b, OutOfMemoryError -> 0x029f, TRY_LEAVE, TryCatch #14 {OutOfMemoryError -> 0x029f, UnsatisfiedLinkError -> 0x029b, all -> 0x0297, blocks: (B:77:0x01b1, B:79:0x01b9, B:84:0x01cc, B:86:0x01df, B:88:0x01f1, B:90:0x01f7, B:52:0x0104, B:56:0x010e, B:58:0x015c, B:60:0x0161, B:62:0x016a, B:63:0x016f, B:65:0x0173, B:67:0x0179, B:69:0x0187, B:71:0x018c, B:72:0x0192, B:76:0x01ac), top: B:204:0x0104 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01cc A[Catch: all -> 0x0297, UnsatisfiedLinkError -> 0x029b, OutOfMemoryError -> 0x029f, TRY_ENTER, TryCatch #14 {OutOfMemoryError -> 0x029f, UnsatisfiedLinkError -> 0x029b, all -> 0x0297, blocks: (B:77:0x01b1, B:79:0x01b9, B:84:0x01cc, B:86:0x01df, B:88:0x01f1, B:90:0x01f7, B:52:0x0104, B:56:0x010e, B:58:0x015c, B:60:0x0161, B:62:0x016a, B:63:0x016f, B:65:0x0173, B:67:0x0179, B:69:0x0187, B:71:0x018c, B:72:0x0192, B:76:0x01ac), top: B:204:0x0104 }] */
    /* JADX WARN: Type inference failed for: r19v0, types: [tb.jh, com.taobao.rxm.request.RequestCancelListener, com.taobao.phenix.decode.a] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v19, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v31 */
    /* JADX WARN: Type inference failed for: r5v34 */
    /* JADX WARN: Type inference failed for: r5v35 */
    /* JADX WARN: Type inference failed for: r7v30, types: [com.taobao.pexode.mimetype.MimeType] */
    /* JADX WARN: Type inference failed for: r7v46, types: [tb.ne0, tb.oe0] */
    /* JADX WARN: Type inference failed for: r7v49, types: [tb.ne0, tb.oe0] */
    /* JADX WARN: Type inference failed for: r7v52 */
    /* JADX WARN: Type inference failed for: r7v53 */
    /* JADX WARN: Type inference failed for: r7v54, types: [tb.ne0, tb.oe0] */
    /* JADX WARN: Type inference failed for: r7v58 */
    /* JADX WARN: Type inference failed for: r7v59 */
    /* JADX WARN: Type inference failed for: r7v60 */
    @Override // com.taobao.rxm.produce.BaseChainProducer, com.taobao.rxm.consume.ChainConsumer
    /* renamed from: H */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void consumeNewResult(com.taobao.rxm.consume.Consumer<tb.z40, com.taobao.phenix.request.C6865a> r20, boolean r21, tb.oe0 r22) {
        /*
            Method dump skipped, instructions count: 853
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.phenix.decode.C6859a.consumeNewResult(com.taobao.rxm.consume.Consumer, boolean, tb.oe0):void");
    }

    @Override // com.taobao.rxm.request.RequestCancelListener
    /* renamed from: K */
    public void onCancel(C6865a c6865a) {
        xt2.n("Phenix", "Decode Cancel.", c6865a);
        PexodeOptions O = c6865a.O();
        if (O != null) {
            c6865a.p0(null);
            xt2.k("Decoder", c6865a, "cancelled image decoding, result=%b", Boolean.valueOf(O.requestCancel()));
        }
    }

    @Override // tb.jh
    protected boolean a(Consumer<z40, C6865a> consumer) {
        return false;
    }
}
