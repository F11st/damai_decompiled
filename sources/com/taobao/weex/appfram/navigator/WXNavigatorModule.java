package com.taobao.weex.appfram.navigator;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.common.WXModule;
import com.taobao.weex.utils.WXLogUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXNavigatorModule extends WXModule {
    public static final String CALLBACK_MESSAGE = "message";
    public static final String CALLBACK_RESULT = "result";
    private static final String INSTANCE_ID = "instanceId";
    public static final String MSG_FAILED = "WX_FAILED";
    public static final String MSG_PARAM_ERR = "WX_PARAM_ERR";
    public static final String MSG_SUCCESS = "WX_SUCCESS";
    private static final String TAG = "Navigator";
    private static final String URL = "url";
    private static final String WEEX = "com.taobao.android.intent.category.WEEX";

    private boolean changeVisibilityOfActionBar(Context context, int i) {
        boolean z;
        ActionBar actionBar;
        try {
            int i2 = AppCompatActivity.a;
            z = true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            z = false;
        }
        if (z && (this.mWXSDKInstance.getContext() instanceof AppCompatActivity)) {
            androidx.appcompat.app.ActionBar supportActionBar = ((AppCompatActivity) this.mWXSDKInstance.getContext()).getSupportActionBar();
            if (supportActionBar == null) {
                return false;
            }
            if (i == 0) {
                supportActionBar.show();
            } else if (i != 1) {
                return false;
            } else {
                supportActionBar.hide();
            }
        } else if (!(this.mWXSDKInstance.getContext() instanceof Activity) || (actionBar = ((Activity) this.mWXSDKInstance.getContext()).getActionBar()) == null) {
            return false;
        } else {
            if (i == 0) {
                actionBar.show();
            } else if (i != 1) {
                return false;
            } else {
                actionBar.hide();
            }
        }
        return true;
    }

    @JSMethod(uiThread = true)
    public void clearNavBarLeftItem(String str, JSCallback jSCallback) {
        if (WXSDKEngine.getActivityNavBarSetter() == null || !WXSDKEngine.getActivityNavBarSetter().clearNavBarLeftItem(str)) {
            if (jSCallback != null) {
                jSCallback.invoke("WX_FAILED");
            }
        } else if (jSCallback != null) {
            jSCallback.invoke("WX_SUCCESS");
        }
    }

    @JSMethod(uiThread = true)
    public void clearNavBarMoreItem(String str, JSCallback jSCallback) {
        if (WXSDKEngine.getActivityNavBarSetter() == null || !WXSDKEngine.getActivityNavBarSetter().clearNavBarMoreItem(str)) {
            if (jSCallback != null) {
                jSCallback.invoke("WX_FAILED");
            }
        } else if (jSCallback != null) {
            jSCallback.invoke("WX_SUCCESS");
        }
    }

    @JSMethod(uiThread = true)
    public void clearNavBarRightItem(String str, JSCallback jSCallback) {
        if (WXSDKEngine.getActivityNavBarSetter() == null || !WXSDKEngine.getActivityNavBarSetter().clearNavBarRightItem(str)) {
            if (jSCallback != null) {
                jSCallback.invoke("WX_FAILED");
            }
        } else if (jSCallback != null) {
            jSCallback.invoke("WX_SUCCESS");
        }
    }

    @JSMethod(uiThread = true)
    public void close(JSONObject jSONObject, JSCallback jSCallback, JSCallback jSCallback2) {
        JSONObject jSONObject2 = new JSONObject();
        if (this.mWXSDKInstance.getContext() instanceof Activity) {
            ((Activity) this.mWXSDKInstance.getContext()).finish();
        } else {
            jSONObject2.put("result", (Object) "WX_FAILED");
            jSONObject2.put("message", (Object) "Close page failed.");
            jSCallback = jSCallback2;
        }
        if (jSCallback != null) {
            jSCallback.invoke(jSONObject2);
        }
    }

    @JSMethod(uiThread = true)
    public void open(JSONObject jSONObject, JSCallback jSCallback, JSCallback jSCallback2) {
        if (jSONObject != null) {
            String string = jSONObject.getString("url");
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(string)) {
                Uri parse = Uri.parse(string);
                String scheme = parse.getScheme();
                if (!TextUtils.isEmpty(scheme) && !"http".equalsIgnoreCase(scheme) && !"https".equalsIgnoreCase(scheme)) {
                    try {
                        this.mWXSDKInstance.getContext().startActivity(new Intent("android.intent.action.VIEW", parse));
                        jSONObject2.put("result", (Object) "WX_SUCCESS");
                    } catch (Throwable th) {
                        th.printStackTrace();
                        jSONObject2.put("result", (Object) "WX_FAILED");
                        jSONObject2.put("message", (Object) "Open page failed.");
                        jSCallback = jSCallback2;
                    }
                } else {
                    push(jSONObject.toJSONString(), jSCallback);
                }
                jSCallback2 = jSCallback;
            } else {
                jSONObject2.put("result", (Object) MSG_PARAM_ERR);
                jSONObject2.put("message", (Object) "The URL parameter is empty.");
            }
            if (jSCallback2 != null) {
                jSCallback2.invoke(jSONObject2);
            }
        }
    }

    @JSMethod(uiThread = true)
    public void pop(String str, JSCallback jSCallback) {
        if (WXSDKEngine.getActivityNavBarSetter() != null && WXSDKEngine.getActivityNavBarSetter().pop(str)) {
            if (jSCallback != null) {
                jSCallback.invoke("WX_SUCCESS");
            }
        } else if (this.mWXSDKInstance.getContext() instanceof Activity) {
            Activity activity = (Activity) this.mWXSDKInstance.getContext();
            if (WXSDKEngine.getNavigator() == null || !WXSDKEngine.getNavigator().pop(activity, str)) {
                if (jSCallback != null) {
                    jSCallback.invoke("WX_SUCCESS");
                }
                ((Activity) this.mWXSDKInstance.getContext()).finish();
            } else if (jSCallback != null) {
                jSCallback.invoke("WX_SUCCESS");
            }
        }
    }

    @JSMethod(uiThread = true)
    public void push(String str, JSCallback jSCallback) {
        if (TextUtils.isEmpty(str)) {
            if (jSCallback != null) {
                jSCallback.invoke("WX_FAILED");
            }
        } else if (WXSDKEngine.getActivityNavBarSetter() != null && WXSDKEngine.getActivityNavBarSetter().push(str)) {
            if (jSCallback != null) {
                jSCallback.invoke("WX_SUCCESS");
            }
        } else {
            if (this.mWXSDKInstance.getContext() instanceof Activity) {
                Activity activity = (Activity) this.mWXSDKInstance.getContext();
                if (WXSDKEngine.getNavigator() != null && WXSDKEngine.getNavigator().push(activity, str)) {
                    if (jSCallback != null) {
                        jSCallback.invoke("WX_SUCCESS");
                        return;
                    }
                    return;
                }
            }
            try {
                String string = JSON.parseObject(str).getString("url");
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                Uri parse = Uri.parse(string);
                String scheme = parse.getScheme();
                Uri.Builder buildUpon = parse.buildUpon();
                if (TextUtils.isEmpty(scheme)) {
                    buildUpon.scheme("http");
                }
                Intent intent = new Intent("android.intent.action.VIEW", buildUpon.build());
                intent.addCategory(WEEX);
                intent.putExtra(INSTANCE_ID, this.mWXSDKInstance.getInstanceId());
                this.mWXSDKInstance.getContext().startActivity(intent);
                if (jSCallback != null) {
                    jSCallback.invoke("WX_SUCCESS");
                }
            } catch (Exception e) {
                WXLogUtils.eTag(TAG, e);
                if (jSCallback != null) {
                    jSCallback.invoke("WX_FAILED");
                }
            }
        }
    }

    @JSMethod
    public void setNavBarHidden(String str, String str2) {
        String str3 = "WX_FAILED";
        try {
            if (changeVisibilityOfActionBar(this.mWXSDKInstance.getContext(), JSON.parseObject(str).getInteger("hidden").intValue())) {
                str3 = "WX_SUCCESS";
            }
        } catch (JSONException e) {
            WXLogUtils.e(TAG, WXLogUtils.getStackTrace(e));
        }
        WXBridgeManager.getInstance().callback(this.mWXSDKInstance.getInstanceId(), str2, str3);
    }

    @JSMethod(uiThread = true)
    public void setNavBarLeftItem(String str, JSCallback jSCallback) {
        if (TextUtils.isEmpty(str) || WXSDKEngine.getActivityNavBarSetter() == null || !WXSDKEngine.getActivityNavBarSetter().setNavBarLeftItem(str)) {
            if (jSCallback != null) {
                jSCallback.invoke("WX_FAILED");
            }
        } else if (jSCallback != null) {
            jSCallback.invoke("WX_SUCCESS");
        }
    }

    @JSMethod(uiThread = true)
    public void setNavBarMoreItem(String str, JSCallback jSCallback) {
        if (TextUtils.isEmpty(str) || WXSDKEngine.getActivityNavBarSetter() == null || !WXSDKEngine.getActivityNavBarSetter().setNavBarMoreItem(str)) {
            if (jSCallback != null) {
                jSCallback.invoke("WX_FAILED");
            }
        } else if (jSCallback != null) {
            jSCallback.invoke("WX_SUCCESS");
        }
    }

    @JSMethod(uiThread = true)
    public void setNavBarRightItem(String str, JSCallback jSCallback) {
        if (TextUtils.isEmpty(str) || WXSDKEngine.getActivityNavBarSetter() == null || !WXSDKEngine.getActivityNavBarSetter().setNavBarRightItem(str)) {
            if (jSCallback != null) {
                jSCallback.invoke("WX_FAILED");
            }
        } else if (jSCallback != null) {
            jSCallback.invoke("WX_SUCCESS");
        }
    }

    @JSMethod(uiThread = true)
    public void setNavBarTitle(String str, JSCallback jSCallback) {
        if (TextUtils.isEmpty(str) || WXSDKEngine.getActivityNavBarSetter() == null || !WXSDKEngine.getActivityNavBarSetter().setNavBarTitle(str)) {
            if (jSCallback != null) {
                jSCallback.invoke("WX_FAILED");
            }
        } else if (jSCallback != null) {
            jSCallback.invoke("WX_SUCCESS");
        }
    }
}
