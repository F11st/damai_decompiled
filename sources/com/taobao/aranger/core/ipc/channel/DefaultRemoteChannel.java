package com.taobao.aranger.core.ipc.channel;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import com.taobao.aranger.ARanger;
import com.taobao.aranger.constant.Constants;
import com.taobao.aranger.core.entity.Call;
import com.taobao.aranger.core.entity.Reply;
import com.taobao.aranger.exception.IPCException;
import java.util.ArrayList;
import java.util.List;
import tb.a11;
import tb.z01;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DefaultRemoteChannel extends AbstractC6693b {
    private static final String c = "DefaultRemoteChannel";
    private final ContentResolver a = ARanger.getContext().getContentResolver();
    private final Uri b;

    public DefaultRemoteChannel(Uri uri) {
        this.b = uri;
    }

    private Reply j(final String str, final Bundle bundle, boolean z, boolean z2) throws IPCException {
        Bundle call;
        try {
            final ContentProviderClient acquireUnstableContentProviderClient = this.a.acquireUnstableContentProviderClient(this.b);
            if (z && z2) {
                a11.b(false, false, new Runnable() { // from class: com.taobao.aranger.core.ipc.channel.DefaultRemoteChannel.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            DefaultRemoteChannel.this.a.call(DefaultRemoteChannel.this.b, str, "", bundle);
                            ContentProviderClient contentProviderClient = acquireUnstableContentProviderClient;
                            if (contentProviderClient == null || Build.VERSION.SDK_INT < 17) {
                                DefaultRemoteChannel.this.a.call(DefaultRemoteChannel.this.b, str, "", bundle);
                            } else {
                                contentProviderClient.call(str, "", bundle);
                            }
                        } catch (Exception e) {
                            z01.c(DefaultRemoteChannel.c, "[call]", e, new Object[0]);
                        }
                    }
                });
                return Reply.obtain().setResult(null);
            }
            if (acquireUnstableContentProviderClient != null && Build.VERSION.SDK_INT >= 17) {
                call = acquireUnstableContentProviderClient.call(str, "", bundle);
            } else {
                call = this.a.call(this.b, str, "", bundle);
            }
            if (z2) {
                return Reply.obtain().setResult(null);
            }
            call.setClassLoader(DefaultRemoteChannel.class.getClassLoader());
            Reply reply = (Reply) call.getParcelable(Constants.PARAM_REPLY);
            if (reply != null) {
                return reply;
            }
            throw new IPCException(35, "reply data encode error from default channel!");
        } catch (Exception e) {
            if (e instanceof RemoteException) {
                throw new IPCException(1, e);
            }
            throw new IPCException(9, e);
        }
    }

    @Override // com.taobao.aranger.core.ipc.channel.AbstractC6693b
    public void c() throws IPCException {
        j("connect", null, true, true);
    }

    @Override // com.taobao.aranger.core.ipc.channel.AbstractC6693b
    public Reply d(Call call) throws IPCException {
        Bundle bundle = new Bundle();
        bundle.putParcelable("call", call);
        return j("call", bundle, call.isOneWay(), call.isVoid());
    }

    @Override // com.taobao.aranger.core.ipc.channel.IChannel
    public void internalRecycle(List<String> list) throws IPCException {
        Bundle bundle = new Bundle();
        bundle.putStringArrayList(Constants.PARAM_KEYS, (ArrayList) list);
        j(Constants.METHOD_RECYCLE_REMOTE, bundle, true, true);
    }

    public String k(String str) throws IPCException {
        Bundle bundle = new Bundle();
        bundle.putString(Constants.PARAM_PROXY_ID, str);
        return (String) j(Constants.METHOD_RECOVER, bundle, false, false).getResult();
    }
}
