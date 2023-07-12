package com.xiaomi.push;

import java.net.UnknownHostException;
import java.util.Objects;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class ff {

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.ff$a */
    /* loaded from: classes11.dex */
    static class C7652a {
        ez a;

        /* renamed from: a  reason: collision with other field name */
        String f349a;

        C7652a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static C7652a a(Exception exc) {
        m879a(exc);
        boolean z = exc instanceof gh;
        Exception exc2 = exc;
        if (z) {
            gh ghVar = (gh) exc;
            exc2 = exc;
            if (ghVar.a() != null) {
                exc2 = ghVar.a();
            }
        }
        C7652a c7652a = new C7652a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        String str = exc2.getClass().getSimpleName() + ":" + message;
        int a = fy.a(exc2);
        if (a != 0) {
            c7652a.a = ez.a(ez.GSLB_REQUEST_SUCCESS.a() + a);
        }
        if (c7652a.a == null) {
            c7652a.a = ez.GSLB_TCP_ERR_OTHER;
        }
        if (c7652a.a == ez.GSLB_TCP_ERR_OTHER) {
            c7652a.f349a = str;
        }
        return c7652a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static void m879a(Exception exc) {
        Objects.requireNonNull(exc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static C7652a b(Exception exc) {
        ez ezVar;
        ez ezVar2;
        Throwable cause;
        m879a(exc);
        boolean z = exc instanceof gh;
        Exception exc2 = exc;
        if (z) {
            gh ghVar = (gh) exc;
            exc2 = exc;
            if (ghVar.a() != null) {
                exc2 = ghVar.a();
            }
        }
        C7652a c7652a = new C7652a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        int a = fy.a(exc2);
        String str = exc2.getClass().getSimpleName() + ":" + message;
        if (a != 0) {
            ez a2 = ez.a(ez.CONN_SUCCESS.a() + a);
            c7652a.a = a2;
            if (a2 == ez.CONN_BOSH_ERR && (cause = exc2.getCause()) != null && (cause instanceof UnknownHostException)) {
                ezVar = ez.CONN_BOSH_UNKNOWNHOST;
            }
            ezVar2 = c7652a.a;
            if (ezVar2 != ez.CONN_TCP_ERR_OTHER || ezVar2 == ez.CONN_XMPP_ERR || ezVar2 == ez.CONN_BOSH_ERR) {
                c7652a.f349a = str;
            }
            return c7652a;
        }
        ezVar = ez.CONN_XMPP_ERR;
        c7652a.a = ezVar;
        ezVar2 = c7652a.a;
        if (ezVar2 != ez.CONN_TCP_ERR_OTHER) {
        }
        c7652a.f349a = str;
        return c7652a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static C7652a c(Exception exc) {
        ez ezVar;
        ez ezVar2;
        m879a(exc);
        boolean z = exc instanceof gh;
        Exception exc2 = exc;
        if (z) {
            gh ghVar = (gh) exc;
            exc2 = exc;
            if (ghVar.a() != null) {
                exc2 = ghVar.a();
            }
        }
        C7652a c7652a = new C7652a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        int a = fy.a(exc2);
        String str = exc2.getClass().getSimpleName() + ":" + message;
        if (a == 105) {
            ezVar = ez.BIND_TCP_READ_TIMEOUT;
        } else if (a == 199) {
            ezVar = ez.BIND_TCP_ERR;
        } else if (a == 499) {
            c7652a.a = ez.BIND_BOSH_ERR;
            if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                ezVar = ez.BIND_BOSH_ITEM_NOT_FOUND;
            }
            ezVar2 = c7652a.a;
            if (ezVar2 != ez.BIND_TCP_ERR || ezVar2 == ez.BIND_XMPP_ERR || ezVar2 == ez.BIND_BOSH_ERR) {
                c7652a.f349a = str;
            }
            return c7652a;
        } else {
            ezVar = a != 109 ? a != 110 ? ez.BIND_XMPP_ERR : ez.BIND_TCP_BROKEN_PIPE : ez.BIND_TCP_CONNRESET;
        }
        c7652a.a = ezVar;
        ezVar2 = c7652a.a;
        if (ezVar2 != ez.BIND_TCP_ERR) {
        }
        c7652a.f349a = str;
        return c7652a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static C7652a d(Exception exc) {
        ez ezVar;
        ez ezVar2;
        m879a(exc);
        boolean z = exc instanceof gh;
        Exception exc2 = exc;
        if (z) {
            gh ghVar = (gh) exc;
            exc2 = exc;
            if (ghVar.a() != null) {
                exc2 = ghVar.a();
            }
        }
        C7652a c7652a = new C7652a();
        String message = exc2.getMessage();
        int a = fy.a(exc2);
        String str = exc2.getClass().getSimpleName() + ":" + message;
        if (a == 105) {
            ezVar = ez.CHANNEL_TCP_READTIMEOUT;
        } else if (a == 199) {
            ezVar = ez.CHANNEL_TCP_ERR;
        } else if (a == 499) {
            c7652a.a = ez.CHANNEL_BOSH_EXCEPTION;
            if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                ezVar = ez.CHANNEL_BOSH_ITEMNOTFIND;
            }
            ezVar2 = c7652a.a;
            if (ezVar2 != ez.CHANNEL_TCP_ERR || ezVar2 == ez.CHANNEL_XMPPEXCEPTION || ezVar2 == ez.CHANNEL_BOSH_EXCEPTION) {
                c7652a.f349a = str;
            }
            return c7652a;
        } else {
            ezVar = a != 109 ? a != 110 ? ez.CHANNEL_XMPPEXCEPTION : ez.CHANNEL_TCP_BROKEN_PIPE : ez.CHANNEL_TCP_CONNRESET;
        }
        c7652a.a = ezVar;
        ezVar2 = c7652a.a;
        if (ezVar2 != ez.CHANNEL_TCP_ERR) {
        }
        c7652a.f349a = str;
        return c7652a;
    }
}
