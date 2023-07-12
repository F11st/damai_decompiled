package com.alipay.android.phone.mrpc.core;

import com.alimm.xadsdk.request.builder.IRequestConst;
import java.lang.reflect.Method;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class j extends a {
    public g g;

    public j(g gVar, Method method, int i, String str, byte[] bArr, boolean z) {
        super(method, i, str, bArr, IRequestConst.CONTENT_TYPE_POST, z);
        this.g = gVar;
    }

    @Override // com.alipay.android.phone.mrpc.core.v
    public final Object a() {
        o oVar = new o(this.g.a());
        oVar.a(this.b);
        oVar.a(this.e);
        oVar.a(this.f);
        oVar.a("id", String.valueOf(this.d));
        oVar.a("operationType", this.c);
        oVar.a("gzip", String.valueOf(this.g.d()));
        oVar.a((Header) new BasicHeader("uuid", UUID.randomUUID().toString()));
        List<Header> b = this.g.c().b();
        if (b != null && !b.isEmpty()) {
            for (Header header : b) {
                oVar.a(header);
            }
        }
        Thread.currentThread().getId();
        oVar.toString();
        try {
            u uVar = this.g.b().a(oVar).get();
            if (uVar != null) {
                return uVar.b();
            }
            throw new RpcException((Integer) 9, "response is null");
        } catch (InterruptedException e) {
            throw new RpcException(13, "", e);
        } catch (CancellationException e2) {
            throw new RpcException(13, "", e2);
        } catch (ExecutionException e3) {
            Throwable cause = e3.getCause();
            if (cause == null || !(cause instanceof HttpException)) {
                throw new RpcException(9, "", e3);
            }
            HttpException httpException = (HttpException) cause;
            int code = httpException.getCode();
            switch (code) {
                case 1:
                    code = 2;
                    break;
                case 2:
                    code = 3;
                    break;
                case 3:
                    code = 4;
                    break;
                case 4:
                    code = 5;
                    break;
                case 5:
                    code = 6;
                    break;
                case 6:
                    code = 7;
                    break;
                case 7:
                    code = 8;
                    break;
                case 8:
                    code = 15;
                    break;
                case 9:
                    code = 16;
                    break;
            }
            throw new RpcException(Integer.valueOf(code), httpException.getMsg());
        }
    }
}
