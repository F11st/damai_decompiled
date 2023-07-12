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
/* renamed from: com.alipay.android.phone.mrpc.core.j */
/* loaded from: classes10.dex */
public final class C4077j extends AbstractC4058a {
    public InterfaceC4074g g;

    public C4077j(InterfaceC4074g interfaceC4074g, Method method, int i, String str, byte[] bArr, boolean z) {
        super(method, i, str, bArr, IRequestConst.CONTENT_TYPE_POST, z);
        this.g = interfaceC4074g;
    }

    @Override // com.alipay.android.phone.mrpc.core.InterfaceC4090v
    public final Object a() {
        C4083o c4083o = new C4083o(this.g.a());
        c4083o.a(this.b);
        c4083o.a(this.e);
        c4083o.a(this.f);
        c4083o.a("id", String.valueOf(this.d));
        c4083o.a("operationType", this.c);
        c4083o.a("gzip", String.valueOf(this.g.d()));
        c4083o.a((Header) new BasicHeader("uuid", UUID.randomUUID().toString()));
        List<Header> b = this.g.c().b();
        if (b != null && !b.isEmpty()) {
            for (Header header : b) {
                c4083o.a(header);
            }
        }
        Thread.currentThread().getId();
        c4083o.toString();
        try {
            C4089u c4089u = this.g.b().a(c4083o).get();
            if (c4089u != null) {
                return c4089u.b();
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
