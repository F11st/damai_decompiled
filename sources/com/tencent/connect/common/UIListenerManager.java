package com.tencent.connect.common;

import android.content.Intent;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.C7123k;
import com.tencent.open.utils.C7126m;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UIListenerManager {
    private static UIListenerManager a;
    private Map<String, ApiTask> b;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class ApiTask {
        public IUiListener mListener;
        public int mRequestCode;

        public ApiTask(int i, IUiListener iUiListener) {
            this.mRequestCode = i;
            this.mListener = iUiListener;
        }
    }

    private UIListenerManager() {
        Map<String, ApiTask> synchronizedMap = Collections.synchronizedMap(new HashMap());
        this.b = synchronizedMap;
        if (synchronizedMap == null) {
            this.b = Collections.synchronizedMap(new HashMap());
        }
    }

    private IUiListener a(int i, IUiListener iUiListener) {
        if (i == 11101) {
            SLog.e("openSDK_LOG.UIListenerManager", "登录的接口回调不能重新构建，暂时无法提供，先记录下来这种情况是否存在");
        } else if (i == 11105) {
            SLog.e("openSDK_LOG.UIListenerManager", "Social Api 的接口回调需要使用param来重新构建，暂时无法提供，先记录下来这种情况是否存在");
        } else if (i == 11106) {
            SLog.e("openSDK_LOG.UIListenerManager", "Social Api 的H5接口回调需要使用param来重新构建，暂时无法提供，先记录下来这种情况是否存在");
        }
        return iUiListener;
    }

    public static UIListenerManager getInstance() {
        if (a == null) {
            a = new UIListenerManager();
        }
        return a;
    }

    public IUiListener getListnerWithAction(String str) {
        ApiTask apiTask;
        if (str == null) {
            SLog.e("openSDK_LOG.UIListenerManager", "getListnerWithAction action is null!");
            return null;
        }
        synchronized (this.b) {
            apiTask = this.b.get(str);
            this.b.remove(str);
        }
        if (apiTask == null) {
            return null;
        }
        return apiTask.mListener;
    }

    public IUiListener getListnerWithRequestCode(int i) {
        String a2 = C7123k.a(i);
        if (a2 == null) {
            SLog.e("openSDK_LOG.UIListenerManager", "getListner action is null! rquestCode=" + i);
            return null;
        }
        return getListnerWithAction(a2);
    }

    public void handleDataToListener(Intent intent, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.UIListenerManager", "handleDataToListener");
        if (intent == null) {
            iUiListener.onCancel();
            return;
        }
        String stringExtra = intent.getStringExtra(Constants.KEY_ACTION);
        if ("action_login".equals(stringExtra)) {
            int intExtra = intent.getIntExtra(Constants.KEY_ERROR_CODE, 0);
            if (intExtra == 0) {
                String stringExtra2 = intent.getStringExtra(Constants.KEY_RESPONSE);
                if (stringExtra2 != null) {
                    try {
                        iUiListener.onComplete(C7126m.d(stringExtra2));
                        return;
                    } catch (JSONException e) {
                        iUiListener.onError(new UiError(-4, Constants.MSG_JSON_ERROR, stringExtra2));
                        SLog.e("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, json error", e);
                        return;
                    }
                }
                SLog.d("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onComplete");
                iUiListener.onComplete(new JSONObject());
                return;
            }
            SLog.e("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onError = " + intExtra + "");
            iUiListener.onError(new UiError(intExtra, intent.getStringExtra(Constants.KEY_ERROR_MSG), intent.getStringExtra(Constants.KEY_ERROR_DETAIL)));
        } else if ("action_share".equals(stringExtra)) {
            String stringExtra3 = intent.getStringExtra("result");
            String stringExtra4 = intent.getStringExtra("response");
            if ("cancel".equals(stringExtra3)) {
                iUiListener.onCancel();
            } else if ("error".equals(stringExtra3)) {
                iUiListener.onError(new UiError(-6, "unknown error", stringExtra4 + ""));
            } else if ("complete".equals(stringExtra3)) {
                try {
                    iUiListener.onComplete(new JSONObject(stringExtra4 == null ? "{\"ret\": 0}" : stringExtra4));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    iUiListener.onError(new UiError(-4, "json error", stringExtra4 + ""));
                }
            }
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.UIListenerManager", "onActivityResult req=" + i + " res=" + i2);
        IUiListener listnerWithRequestCode = getListnerWithRequestCode(i);
        if (listnerWithRequestCode == null) {
            if (iUiListener != null) {
                listnerWithRequestCode = a(i, iUiListener);
            } else {
                SLog.e("openSDK_LOG.UIListenerManager", "onActivityResult can't find the listener");
                return false;
            }
        }
        if (i2 != -1) {
            listnerWithRequestCode.onCancel();
            return true;
        } else if (intent == null) {
            listnerWithRequestCode.onError(new UiError(-6, "onActivityResult intent data is null.", "onActivityResult intent data is null."));
            return true;
        } else {
            String stringExtra = intent.getStringExtra(Constants.KEY_ACTION);
            if ("action_login".equals(stringExtra)) {
                int intExtra = intent.getIntExtra(Constants.KEY_ERROR_CODE, 0);
                if (intExtra == 0) {
                    String stringExtra2 = intent.getStringExtra(Constants.KEY_RESPONSE);
                    if (stringExtra2 != null) {
                        try {
                            listnerWithRequestCode.onComplete(C7126m.d(stringExtra2));
                            return true;
                        } catch (JSONException e) {
                            listnerWithRequestCode.onError(new UiError(-4, Constants.MSG_JSON_ERROR, stringExtra2));
                            SLog.e("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, json error", e);
                            return true;
                        }
                    }
                    SLog.d("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onComplete");
                    listnerWithRequestCode.onComplete(new JSONObject());
                    return true;
                }
                SLog.e("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onError = " + intExtra + "");
                listnerWithRequestCode.onError(new UiError(intExtra, intent.getStringExtra(Constants.KEY_ERROR_MSG), intent.getStringExtra(Constants.KEY_ERROR_DETAIL)));
                return true;
            } else if (!"action_share".equals(stringExtra) && !"action_request_avatar".equals(stringExtra) && !"action_request_dynamic_avatar".equals(stringExtra) && !"action_request_set_emotion".equals(stringExtra) && !"guildOpen".equals(stringExtra)) {
                if ("action_common_channel".equals(stringExtra)) {
                    int intExtra2 = intent.getIntExtra(Constants.KEY_ERROR_CODE, 0);
                    if (intExtra2 == 0) {
                        String stringExtra3 = intent.getStringExtra("response");
                        if (stringExtra3 != null) {
                            try {
                                String stringExtra4 = intent.getStringExtra("message");
                                JSONObject d = C7126m.d(stringExtra3);
                                d.put("message", stringExtra4);
                                listnerWithRequestCode.onComplete(d);
                                return true;
                            } catch (JSONException unused) {
                                listnerWithRequestCode.onError(new UiError(-4, Constants.MSG_JSON_ERROR, stringExtra3));
                                return true;
                            }
                        }
                        listnerWithRequestCode.onComplete(new JSONObject());
                        return true;
                    }
                    listnerWithRequestCode.onError(new UiError(intExtra2, intent.getStringExtra(Constants.KEY_ERROR_MSG), intent.getStringExtra(Constants.KEY_ERROR_DETAIL)));
                    return true;
                }
                int intExtra3 = intent.getIntExtra(Constants.KEY_ERROR_CODE, 0);
                if (intExtra3 == 0) {
                    String stringExtra5 = intent.getStringExtra(Constants.KEY_RESPONSE);
                    if (stringExtra5 != null) {
                        try {
                            listnerWithRequestCode.onComplete(C7126m.d(stringExtra5));
                            return true;
                        } catch (JSONException unused2) {
                            listnerWithRequestCode.onError(new UiError(-4, Constants.MSG_JSON_ERROR, stringExtra5));
                            return true;
                        }
                    }
                    listnerWithRequestCode.onComplete(new JSONObject());
                    return true;
                }
                listnerWithRequestCode.onError(new UiError(intExtra3, intent.getStringExtra(Constants.KEY_ERROR_MSG), intent.getStringExtra(Constants.KEY_ERROR_DETAIL)));
                return true;
            } else {
                String stringExtra6 = intent.getStringExtra("result");
                String stringExtra7 = intent.getStringExtra("response");
                if ("cancel".equals(stringExtra6)) {
                    listnerWithRequestCode.onCancel();
                    return true;
                } else if ("error".equals(stringExtra6)) {
                    listnerWithRequestCode.onError(new UiError(-6, "unknown error", stringExtra7 + ""));
                    return true;
                } else if ("complete".equals(stringExtra6)) {
                    try {
                        listnerWithRequestCode.onComplete(new JSONObject(stringExtra7 == null ? "{\"ret\": 0}" : stringExtra7));
                        return true;
                    } catch (JSONException e2) {
                        SLog.e("openSDK_LOG.UIListenerManager", "JSONException", e2);
                        listnerWithRequestCode.onError(new UiError(-4, "json error", stringExtra7 + ""));
                        return true;
                    }
                } else {
                    return true;
                }
            }
        }
    }

    public Object setListenerWithRequestcode(int i, IUiListener iUiListener) {
        ApiTask put;
        String a2 = C7123k.a(i);
        if (a2 == null) {
            SLog.e("openSDK_LOG.UIListenerManager", "setListener action is null! rquestCode=" + i);
            return null;
        }
        synchronized (this.b) {
            put = this.b.put(a2, new ApiTask(i, iUiListener));
        }
        if (put == null) {
            return null;
        }
        return put.mListener;
    }

    public Object setListnerWithAction(String str, IUiListener iUiListener) {
        ApiTask put;
        int b = C7123k.b(str);
        if (b == -1) {
            SLog.e("openSDK_LOG.UIListenerManager", "setListnerWithAction fail, action = " + str);
            return null;
        }
        synchronized (this.b) {
            put = this.b.put(str, new ApiTask(b, iUiListener));
        }
        if (put == null) {
            return null;
        }
        return put.mListener;
    }
}
