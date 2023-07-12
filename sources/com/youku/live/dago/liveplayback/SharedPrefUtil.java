package com.youku.live.dago.liveplayback;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class SharedPrefUtil {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String KEY_SAVED_VER = "_saved_ver";
    private SharedPreferences.Editor mEditor;
    private SharedPreferences mSp;

    public SharedPrefUtil(String str, int i) {
        Context ctx = SharelibCtx.ctx();
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(getClass().getSimpleName() + JSMethod.NOT_SET + str, 0);
        this.mSp = sharedPreferences;
        if (i > sharedPreferences.getInt(KEY_SAVED_VER, -1)) {
            this.mSp.edit().clear().putInt(KEY_SAVED_VER, i).apply();
        }
    }

    public boolean containKey(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-529375817") ? ((Boolean) ipChange.ipc$dispatch("-529375817", new Object[]{this, str})).booleanValue() : this.mSp.contains(str);
    }

    public boolean getBoolean(String str, boolean z) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1012319052") ? ((Boolean) ipChange.ipc$dispatch("1012319052", new Object[]{this, str, Boolean.valueOf(z)})).booleanValue() : this.mSp.getBoolean(str, z);
    }

    public int getInt(String str, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-439779983") ? ((Integer) ipChange.ipc$dispatch("-439779983", new Object[]{this, str, Integer.valueOf(i)})).intValue() : this.mSp.getInt(str, i);
    }

    public long getLong(String str, long j) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1175211638") ? ((Long) ipChange.ipc$dispatch("-1175211638", new Object[]{this, str, Long.valueOf(j)})).longValue() : this.mSp.getLong(str, j);
    }

    public String getString(String str, String str2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1946387523") ? (String) ipChange.ipc$dispatch("-1946387523", new Object[]{this, str, str2}) : this.mSp.getString(str, str2);
    }

    public SharedPrefUtil putBoolean(String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-516495799")) {
            return (SharedPrefUtil) ipChange.ipc$dispatch("-516495799", new Object[]{this, str, Boolean.valueOf(z)});
        }
        this.mEditor.putBoolean(str, z);
        return this;
    }

    public SharedPrefUtil putInt(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1294641151")) {
            return (SharedPrefUtil) ipChange.ipc$dispatch("1294641151", new Object[]{this, str, Integer.valueOf(i)});
        }
        this.mEditor.putInt(str, i);
        return this;
    }

    public SharedPrefUtil putLong(String str, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-393916375")) {
            return (SharedPrefUtil) ipChange.ipc$dispatch("-393916375", new Object[]{this, str, Long.valueOf(j)});
        }
        this.mEditor.putLong(str, j);
        return this;
    }

    public SharedPrefUtil putString(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "651819588")) {
            return (SharedPrefUtil) ipChange.ipc$dispatch("651819588", new Object[]{this, str, str2});
        }
        this.mEditor.putString(str, str2);
        return this;
    }

    public SharedPrefUtil removeKey(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "757715487")) {
            return (SharedPrefUtil) ipChange.ipc$dispatch("757715487", new Object[]{this, str});
        }
        this.mEditor.remove(str);
        return this;
    }

    @SuppressLint({"CommitPrefEdits"})
    public SharedPrefUtil startEdit() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1919717596")) {
            return (SharedPrefUtil) ipChange.ipc$dispatch("-1919717596", new Object[]{this});
        }
        this.mEditor = this.mSp.edit();
        return this;
    }

    @Deprecated
    public SharedPrefUtil stopEdit() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-708829662")) {
            return (SharedPrefUtil) ipChange.ipc$dispatch("-708829662", new Object[]{this});
        }
        SharedPreferences.Editor editor = this.mEditor;
        if (editor != null) {
            editor.apply();
            this.mEditor = null;
        }
        return this;
    }

    public void stopEditAndCommitIf() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1525266025")) {
            ipChange.ipc$dispatch("-1525266025", new Object[]{this});
            return;
        }
        SharedPreferences.Editor editor = this.mEditor;
        if (editor != null) {
            editor.commit();
            this.mEditor = null;
        }
    }

    public void stopEditIf() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-824677141")) {
            ipChange.ipc$dispatch("-824677141", new Object[]{this});
            return;
        }
        SharedPreferences.Editor editor = this.mEditor;
        if (editor != null) {
            editor.apply();
            this.mEditor = null;
        }
    }
}
