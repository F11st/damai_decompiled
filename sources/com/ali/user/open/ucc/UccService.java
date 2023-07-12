package com.ali.user.open.ucc;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.ali.user.open.session.Session;
import com.ali.user.open.ucc.model.UccParams;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public interface UccService {
    void applyToken(String str, Map<String, String> map, UccCallback uccCallback);

    void bind(Activity activity, String str, UccCallback uccCallback);

    void bind(Activity activity, @NonNull String str, String str2, UccCallback uccCallback);

    void bind(Activity activity, @NonNull String str, String str2, Map<String, String> map, UccCallback uccCallback);

    void bind(Activity activity, String str, Map<String, String> map, UccCallback uccCallback);

    void bind(@NonNull String str, String str2, Map<String, String> map, UccCallback uccCallback);

    void bind(String str, Map<String, String> map, UccCallback uccCallback);

    void bindAlipay(String str, String str2, Map<String, String> map, UccCallback uccCallback);

    void bindWithIBB(Activity activity, String str, String str2, Map<String, String> map, UccCallback uccCallback);

    void cleanUp();

    void doChangeBind(Activity activity, UccParams uccParams, int i, String str, String str2, Map<String, String> map, UccCallback uccCallback);

    void fetchUrl(Context context, String str, Map<String, String> map, UccCallback uccCallback);

    Session getSession(String str);

    UccDataProvider getUccDataProvider();

    boolean isLoginUrl(String str, String str2);

    void launchTaobao(Context context, String str, UccCallback uccCallback);

    void logout(Context context, String str);

    void logoutAll(Context context);

    void noActionBind(String str, Map<String, String> map, UccCallback uccCallback);

    void noActionBindWithChangeBind(Activity activity, String str, Map<String, String> map, UccCallback uccCallback);

    void queryBind(String str, String str2, String str3, boolean z, Map<String, String> map, UccCallback uccCallback);

    void queryBind(String str, Map<String, String> map, UccCallback uccCallback);

    void setUccDataProvider(UccDataProvider uccDataProvider);

    void setUccDataProvider(String str, UccDataProvider uccDataProvider);

    void trustLogin(Activity activity, String str, UccCallback uccCallback);

    void trustLogin(Activity activity, String str, Map<String, String> map, UccCallback uccCallback);

    void trustLogin(String str, Map<String, String> map, UccCallback uccCallback);

    void uccOAuthLogin(Activity activity, String str, Map<String, String> map, UccCallback uccCallback);

    void unbind(String str, UccCallback uccCallback);

    void unbind(String str, Map<String, String> map, UccCallback uccCallback);

    void updateGrantAuthorization(String str, String str2, String str3, String str4, UccCallback uccCallback);

    void updateGrantAuthorization(String str, String str2, String str3, String str4, boolean z, UccCallback uccCallback);

    void updateGrantAuthorization(String str, String str2, Map<String, String> map, UccCallback uccCallback);
}
