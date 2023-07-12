package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import com.amap.api.col.s.bt;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.help.Inputtips;
import com.amap.api.services.help.InputtipsQuery;
import com.amap.api.services.help.Tip;
import com.amap.api.services.interfaces.IInputtipsSearch;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class bb implements IInputtipsSearch {
    private Context a;
    private Inputtips.InputtipsListener b;
    private Handler c;
    private InputtipsQuery d;

    public bb(Context context, Inputtips.InputtipsListener inputtipsListener) throws AMapException {
        bu a = bt.a(context, C4434h.a(false));
        if (a.a == bt.EnumC4398c.SuccessCode) {
            this.a = context.getApplicationContext();
            this.b = inputtipsListener;
            this.c = HandlerC4447t.a();
            return;
        }
        String str = a.b;
        throw new AMapException(str, 1, str, a.a.a());
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final InputtipsQuery getQuery() {
        return this.d;
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final ArrayList<Tip> requestInputtips() throws AMapException {
        return a(this.d);
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final void requestInputtipsAsyn() {
        try {
            ao.a().a(new Runnable() { // from class: com.amap.api.col.s.bb.1
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = HandlerC4447t.a().obtainMessage();
                    obtainMessage.obj = bb.this.b;
                    obtainMessage.arg1 = 5;
                    try {
                        try {
                            bb bbVar = bb.this;
                            ArrayList<? extends Parcelable> a = bbVar.a(bbVar.d);
                            Bundle bundle = new Bundle();
                            bundle.putParcelableArrayList("result", a);
                            obtainMessage.setData(bundle);
                            obtainMessage.what = 1000;
                        } catch (AMapException e) {
                            obtainMessage.what = e.getErrorCode();
                        }
                    } finally {
                        bb.this.c.sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            C4435i.a(th, "Inputtips", "requestInputtipsAsynThrowable");
        }
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final void setInputtipsListener(Inputtips.InputtipsListener inputtipsListener) {
        this.b = inputtipsListener;
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final void setQuery(InputtipsQuery inputtipsQuery) {
        this.d = inputtipsQuery;
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final void requestInputtips(String str, String str2) throws AMapException {
        requestInputtips(str, str2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<Tip> a(InputtipsQuery inputtipsQuery) throws AMapException {
        try {
            C4444r.a(this.a);
            if (inputtipsQuery != null) {
                if (inputtipsQuery.getKeyword() != null && !inputtipsQuery.getKeyword().equals("")) {
                    return new C4442p(this.a, inputtipsQuery).b();
                }
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (Throwable th) {
            C4435i.a(th, "Inputtips", "requestInputtips");
            if (th instanceof AMapException) {
                throw th;
            }
            return null;
        }
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final void requestInputtips(String str, String str2, String str3) throws AMapException {
        if (str != null && !str.equals("")) {
            InputtipsQuery inputtipsQuery = new InputtipsQuery(str, str2);
            this.d = inputtipsQuery;
            inputtipsQuery.setType(str3);
            requestInputtipsAsyn();
            return;
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    public bb(Context context, InputtipsQuery inputtipsQuery) {
        this.a = context.getApplicationContext();
        this.d = inputtipsQuery;
        this.c = HandlerC4447t.a();
    }
}
