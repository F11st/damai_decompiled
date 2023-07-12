package com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.expression;

import android.app.Application;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.DynamicDrawableSpan;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.arch.theadpool.PriorityRunnable;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.AppContextUtils;
import com.youku.live.dago.widgetlib.util.UIUtil;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import com.youku.live.dsl.threadpool.IThreadPool;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ExpressionManager {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "ExpressionManager";
    public static Pattern facePatten = Pattern.compile("n0[0-9]{2}|n10[0-7]|f0[0-9]{2}|f10[0-7]|g0[0-9]{2}|g10[0-7]", 2);
    private static volatile ExpressionManager sInstance = null;
    private Map<String, Drawable> mFaceDrawableMap;

    private ExpressionManager() {
        HashMap hashMap = new HashMap();
        this.mFaceDrawableMap = hashMap;
        if (hashMap.isEmpty()) {
            ((IThreadPool) Dsl.getService(IThreadPool.class)).excute(new PriorityRunnable() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.expression.ExpressionManager.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "985290747")) {
                        ipChange.ipc$dispatch("985290747", new Object[]{this});
                        return;
                    }
                    ExpressionManager.this.init();
                    ((ILog) Dsl.getService(ILog.class)).i(ExpressionManager.TAG, "ExpressionManager init success");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable convertBitmap2Drawable(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "846426997") ? (Drawable) ipChange.ipc$dispatch("846426997", new Object[]{this, bitmap}) : new BitmapDrawable(AppContextUtils.getApp().getResources(), bitmap);
    }

    private void dealExpression(SpannableString spannableString, Pattern pattern, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1033342401")) {
            ipChange.ipc$dispatch("-1033342401", new Object[]{this, spannableString, pattern, Integer.valueOf(i)});
            return;
        }
        final Application app2 = AppContextUtils.getApp();
        Matcher matcher = pattern.matcher(spannableString);
        while (matcher.find()) {
            String group = matcher.group();
            if (matcher.start() >= i) {
                try {
                    final int parseInt = Integer.parseInt(R.drawable.class.getDeclaredField(group).get(null).toString());
                    if (parseInt != 0) {
                        DynamicDrawableSpan dynamicDrawableSpan = new DynamicDrawableSpan(0) { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.expression.ExpressionManager.2
                            private static transient /* synthetic */ IpChange $ipChange;

                            @Override // android.text.style.DynamicDrawableSpan
                            public Drawable getDrawable() {
                                IpChange ipChange2 = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange2, "1111727913")) {
                                    return (Drawable) ipChange2.ipc$dispatch("1111727913", new Object[]{this});
                                }
                                Drawable convertBitmap2Drawable = ExpressionManager.this.convertBitmap2Drawable(BitmapFactory.decodeResource(app2.getResources(), parseInt));
                                convertBitmap2Drawable.setBounds(0, 0, UIUtil.dip2px(18), UIUtil.dip2px(18));
                                return convertBitmap2Drawable;
                            }
                        };
                        int start = matcher.start() + group.length();
                        spannableString.setSpan(dynamicDrawableSpan, matcher.start(), start, 17);
                        if (start < spannableString.length()) {
                            dealExpression(spannableString, pattern, start);
                            return;
                        }
                        return;
                    }
                    continue;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (IllegalArgumentException e2) {
                    e2.printStackTrace();
                } catch (NoSuchFieldException e3) {
                    e3.printStackTrace();
                } catch (NumberFormatException e4) {
                    e4.printStackTrace();
                }
            }
        }
    }

    private void dealExpressionNew(SpannableString spannableString, Pattern pattern, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2120637984")) {
            ipChange.ipc$dispatch("-2120637984", new Object[]{this, spannableString, pattern, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        Matcher matcher = pattern.matcher(spannableString);
        while (matcher.find()) {
            String group = matcher.group();
            if (matcher.start() >= i) {
                try {
                    Drawable drawable = this.mFaceDrawableMap.get(group);
                    if (drawable == null) {
                        drawable = this.mFaceDrawableMap.get("n000");
                    }
                    int start = matcher.start() + group.length();
                    spannableString.setSpan(new VerticalImageSpan(drawable), matcher.start(), start, 17);
                    if (start < spannableString.length()) {
                        dealExpressionNew(spannableString, pattern, start, i2);
                        return;
                    }
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String dealStringExpression1(String str, Pattern pattern) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1956524360")) {
            return (String) ipChange.ipc$dispatch("1956524360", new Object[]{this, str, pattern});
        }
        Matcher matcher = pattern.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        boolean find = matcher.find();
        while (find) {
            String group = matcher.group();
            if (matcher.start() >= 0) {
                matcher.appendReplacement(stringBuffer, ExpressionDict.getInstance().getExpressionByResName(group).getRealName());
                find = matcher.find();
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    private String dealStringExpression2(String str, Pattern pattern) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-218155737")) {
            return (String) ipChange.ipc$dispatch("-218155737", new Object[]{this, str, pattern});
        }
        Matcher matcher = pattern.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        boolean find = matcher.find();
        while (find) {
            String group = matcher.group();
            if (matcher.start() >= 0) {
                matcher.appendReplacement(stringBuffer, ExpressionDict.getInstance().getExpressionByRealName(group).getResName());
                find = matcher.find();
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public static ExpressionManager getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-680254337")) {
            return (ExpressionManager) ipChange.ipc$dispatch("-680254337", new Object[0]);
        }
        if (sInstance == null) {
            synchronized (ExpressionManager.class) {
                if (sInstance == null) {
                    sInstance = new ExpressionManager();
                }
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void init() {
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-452802873")) {
            ipChange.ipc$dispatch("-452802873", new Object[]{this});
            return;
        }
        if (ExpressionDict.isNewExpression()) {
            String prefix = ExpressionDict.getPrefix();
            for (int i = 0; i < ExpressionDict.getMaxIcon(); i++) {
                String str = i < 10 ? prefix + "00" + i : prefix + "0" + i;
                try {
                    drawable3 = AppContextUtils.getApp().getResources().getDrawable(getResId(str, R.drawable.class));
                } catch (Resources.NotFoundException unused) {
                    ((ILog) Dsl.getService(ILog.class)).e("wuxinrong", "文件 " + str + " 找不到");
                    drawable3 = null;
                }
                if (drawable3 != null) {
                    drawable3.setBounds(0, 0, UIUtil.dip2px(18), UIUtil.dip2px(18));
                    this.mFaceDrawableMap.put(str, drawable3);
                }
            }
        }
        for (int i2 = 0; i2 < 24; i2++) {
            String str2 = i2 < 10 ? "f00" + i2 : "f0" + i2;
            try {
                drawable2 = AppContextUtils.getApp().getResources().getDrawable(getResId(str2, R.drawable.class));
            } catch (Resources.NotFoundException unused2) {
                ((ILog) Dsl.getService(ILog.class)).e("wuxinrong", "文件 " + str2 + " 找不到");
                drawable2 = null;
            }
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, UIUtil.dip2px(18), UIUtil.dip2px(18));
                this.mFaceDrawableMap.put(str2, drawable2);
            }
        }
        for (int i3 = 0; i3 < 18; i3++) {
            String str3 = i3 < 10 ? "g00" + i3 : "g0" + i3;
            try {
                drawable = AppContextUtils.getApp().getResources().getDrawable(getResId(str3, R.drawable.class));
            } catch (Resources.NotFoundException unused3) {
                ((ILog) Dsl.getService(ILog.class)).e("wuxinrong", "文件 " + str3 + " 找不到");
                drawable = null;
            }
            if (drawable != null) {
                drawable.setBounds(0, 0, UIUtil.dip2px(18), UIUtil.dip2px(18));
                this.mFaceDrawableMap.put(str3, drawable);
            }
        }
    }

    public static boolean isExpression(CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1829238493") ? ((Boolean) ipChange.ipc$dispatch("1829238493", new Object[]{charSequence})).booleanValue() : facePatten.matcher(charSequence).find();
    }

    public SpannableString getExpressionString(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1931205062")) {
            return (SpannableString) ipChange.ipc$dispatch("1931205062", new Object[]{this, str, str2, str3});
        }
        SpannableString spannableString = new SpannableString(str);
        Pattern compile = Pattern.compile(str2, 2);
        try {
            if (str3 == null) {
                dealExpressionNew(spannableString, compile, 0, 100000);
            } else {
                dealExpression(spannableString, compile, 0, str3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return spannableString;
    }

    public Map<String, Drawable> getExpressioneMap() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "554364323") ? (Map) ipChange.ipc$dispatch("554364323", new Object[]{this}) : this.mFaceDrawableMap;
    }

    public SpannableString getFaceExpressionString(String str, int i, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1524237492")) {
            return (SpannableString) ipChange.ipc$dispatch("-1524237492", new Object[]{this, str, Integer.valueOf(i), str2});
        }
        SpannableString spannableString = new SpannableString(str);
        try {
            if (str2 == null) {
                dealExpressionNew(spannableString, facePatten, 0, i);
            } else {
                dealExpression(spannableString, facePatten, 0, str2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return spannableString;
    }

    public int getResId(String str, Class<?> cls) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "602540756")) {
            return ((Integer) ipChange.ipc$dispatch("602540756", new Object[]{this, str, cls})).intValue();
        }
        try {
            Field declaredField = cls.getDeclaredField(str);
            return declaredField.getInt(declaredField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public SpannableString getFaceExpressionString(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2006279347")) {
            return (SpannableString) ipChange.ipc$dispatch("-2006279347", new Object[]{this, str, str2});
        }
        SpannableString spannableString = new SpannableString(str);
        try {
            if (str2 == null) {
                dealExpressionNew(spannableString, facePatten, 0, 100000);
            } else {
                dealExpression(spannableString, facePatten, 0, str2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return spannableString;
    }

    public String getExpressionString(String str, String str2, int i) {
        String dealStringExpression2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1046970043")) {
            return (String) ipChange.ipc$dispatch("-1046970043", new Object[]{this, str, str2, Integer.valueOf(i)});
        }
        Pattern compile = Pattern.compile(str2, 2);
        try {
            if (i == 0) {
                dealStringExpression2 = dealStringExpression1(str, compile);
            } else {
                dealStringExpression2 = dealStringExpression2(str, compile);
            }
            return dealStringExpression2;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public String getFaceExpressionString(String str, int i) {
        String dealStringExpression2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "372646494")) {
            return (String) ipChange.ipc$dispatch("372646494", new Object[]{this, str, Integer.valueOf(i)});
        }
        try {
            if (i == 0) {
                dealStringExpression2 = dealStringExpression1(str, facePatten);
            } else {
                dealStringExpression2 = dealStringExpression2(str, facePatten);
            }
            return dealStringExpression2;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private void dealExpression(SpannableString spannableString, Pattern pattern, int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-140301751")) {
            ipChange.ipc$dispatch("-140301751", new Object[]{this, spannableString, pattern, Integer.valueOf(i), str});
            return;
        }
        Matcher matcher = pattern.matcher(spannableString);
        while (matcher.find()) {
            String group = matcher.group();
            if (matcher.start() >= i) {
                Drawable createFromPath = Drawable.createFromPath(str);
                if (createFromPath == null) {
                    createFromPath = convertBitmap2Drawable(BitmapFactory.decodeResource(AppContextUtils.getApp().getResources(), R.drawable.dago_pgc_ic_biaoqing));
                }
                createFromPath.setBounds(0, 0, UIUtil.dip2px(24), UIUtil.dip2px(24));
                VerticalImageSpan verticalImageSpan = new VerticalImageSpan(createFromPath);
                int start = matcher.start() + group.length();
                spannableString.setSpan(verticalImageSpan, matcher.start(), start, 17);
                if (start < spannableString.length()) {
                    dealExpression(spannableString, pattern, start);
                    return;
                }
                return;
            }
        }
    }
}
