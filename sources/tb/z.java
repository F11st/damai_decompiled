package tb;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.text.TextUtils;
import anet.channel.request.ByteArrayEntry;
import anetwork.channel.NetworkCallBack$FinishListener;
import anetwork.channel.NetworkCallBack$ProgressListener;
import anetwork.channel.NetworkEvent$FinishEvent;
import anetwork.channel.NetworkEvent$ProgressEvent;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.global.SDKConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class z {
    public static final String KEY_DATA = "data";
    public static final String KEY_HEADER = "header";
    public static final String KEY_METHOD = "method";
    public static final String KEY_URL = "url";
    public static final String METHOD_POST = "POST";
    public static final int MSG_ERR = -1;
    public static final int MSG_OK = 1;
    public static final String RESULT_CONTENT = "content";
    public static final String RESULT_KEY = "ret";
    private WVCallBackContext a;
    private Context b = SDKConfig.getInstance().getGlobalContext();
    private Handler c = new a(Looper.getMainLooper());

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            Bundle data = message.getData();
            WVResult wVResult = new WVResult();
            wVResult.addData("status_code", String.valueOf(data.getInt("status_code", 0)));
            String string = data.getString("status");
            if (TextUtils.isEmpty(string)) {
                wVResult.addData("status", string);
            }
            int i = message.what;
            if (i == -1) {
                wVResult.addData("ret", new JSONArray().put("HY_FAILED"));
                z.this.a.error(wVResult);
            } else if (i == 1) {
                wVResult.addData("ret", new JSONArray().put(WVResult.SUCCESS));
                wVResult.addData("content", data.getString("content"));
                z.this.a.success(wVResult);
            }
        }
    }

    private c22 c(String str) {
        byte[] bArr;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("url");
            String string2 = jSONObject.getString("method");
            c22 c22Var = new c22(string);
            c22Var.setMethod(string2);
            JSONObject optJSONObject = jSONObject.optJSONObject("header");
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String string3 = optJSONObject.getString(next);
                    if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(string3)) {
                        c22Var.addHeader(next, string3);
                    }
                }
            }
            if ("POST".equals(string2)) {
                String string4 = jSONObject.getString("data");
                if (!StringUtils.isBlank(string4)) {
                    try {
                        bArr = string4.getBytes("UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                        bArr = null;
                    }
                    if (bArr != null) {
                        c22Var.setBodyEntry(new ByteArrayEntry(bArr));
                    }
                }
            }
            return c22Var;
        } catch (JSONException unused) {
            TBSdkLog.e("ANetBridge", "parseParams error, param=" + str);
            return null;
        }
    }

    public void d(WVCallBackContext wVCallBackContext, String str) {
        if (TBSdkLog.isPrintLog()) {
            TBSdkLog.d("ANetBridge", "Send Params: " + str);
        }
        this.a = wVCallBackContext;
        c22 c = c(str);
        if (c == null) {
            this.c.sendEmptyMessage(-1);
        }
        new k60(this.b).asyncSend(c, null, null, new b(this, null));
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private class b implements NetworkCallBack$FinishListener, NetworkCallBack$ProgressListener {
        private ByteArrayOutputStream a;

        private b() {
            this.a = new ByteArrayOutputStream();
        }

        @Override // anetwork.channel.NetworkCallBack$ProgressListener
        public void onDataReceived(NetworkEvent$ProgressEvent networkEvent$ProgressEvent, Object obj) {
            this.a.write(networkEvent$ProgressEvent.getBytedata(), 0, networkEvent$ProgressEvent.getSize());
        }

        @Override // anetwork.channel.NetworkCallBack$FinishListener
        public void onFinished(NetworkEvent$FinishEvent networkEvent$FinishEvent, Object obj) {
            Message obtainMessage = z.this.c.obtainMessage();
            Bundle bundle = new Bundle();
            try {
                if (networkEvent$FinishEvent.getHttpCode() > 0) {
                    obtainMessage.what = 1;
                    bundle.putString("content", new String(this.a.toByteArray(), "UTF-8"));
                } else {
                    obtainMessage.what = -1;
                }
            } catch (UnsupportedEncodingException unused) {
                TBSdkLog.e("ANetBridge", "ByteArray -> String Error");
            }
            bundle.putInt("status_code", networkEvent$FinishEvent.getHttpCode());
            bundle.putString("status", networkEvent$FinishEvent.getDesc());
            obtainMessage.setData(bundle);
            z.this.c.sendMessage(obtainMessage);
        }

        /* synthetic */ b(z zVar, a aVar) {
            this();
        }
    }
}
