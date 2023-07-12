package cn.damai.pay.alipay;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import cn.damai.commonbusiness.R$string;
import cn.damai.pay.alipay.AlixDemo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class BaseHelper {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void chmod(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "400689290")) {
            ipChange.ipc$dispatch("400689290", new Object[]{str, str2});
            return;
        }
        try {
            Runtime.getRuntime().exec("chmod " + str + " " + str2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String convertStreamToString(InputStream inputStream) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1068897151")) {
            return (String) ipChange.ipc$dispatch("-1068897151", new Object[]{inputStream});
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                try {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    } catch (IOException e) {
                        e.printStackTrace();
                        inputStream.close();
                    }
                } catch (Throwable th) {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    throw th;
                }
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
        inputStream.close();
        return sb.toString();
    }

    public static void log(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-311314589")) {
            ipChange.ipc$dispatch("-311314589", new Object[]{str, str2});
        }
    }

    public static void showDialog(Activity activity, String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1719633845")) {
            ipChange.ipc$dispatch("-1719633845", new Object[]{activity, str, str2, Integer.valueOf(i)});
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setIcon(i);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(R$string.Ensure, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    public static ProgressDialog showProgress(Context context, CharSequence charSequence, CharSequence charSequence2, boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1727334177")) {
            return (ProgressDialog) ipChange.ipc$dispatch("-1727334177", new Object[]{context, charSequence, charSequence2, Boolean.valueOf(z), Boolean.valueOf(z2)});
        }
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setTitle(charSequence);
        progressDialog.setMessage(charSequence2);
        progressDialog.setIndeterminate(z);
        progressDialog.setCancelable(false);
        progressDialog.setOnCancelListener(new AlixDemo.AlixOnCancelListener((Activity) context));
        progressDialog.show();
        return progressDialog;
    }

    public static JSONObject string2JSON(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1739725900")) {
            return (JSONObject) ipChange.ipc$dispatch("1739725900", new Object[]{str, str2});
        }
        JSONObject jSONObject = new JSONObject();
        try {
            String[] split = str.split(str2);
            for (int i = 0; i < split.length; i++) {
                String[] split2 = split[i].split("=");
                jSONObject.put(split2[0], split[i].substring(split2[0].length() + 1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
