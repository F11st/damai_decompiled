package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.ailpbaselib.image.DagoImageLoader;
import com.youku.live.dago.widgetlib.ailpbaselib.image.ImageLoadListener;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.expression.ExpressionDict;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.expression.ExpressionManager;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.medals.ActiveStageConfig;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.medals.LFFilePathUtils;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.medals.LevelStatic;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.medals.MedalsConfig;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.AnchorLevelCellItem;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.ButtonCellItem;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.FaceCellItem;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.GiftCellItem;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.ImageCellItem;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.MedalCellItem;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.TextCellItem;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.UserLevelCellItem;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.span.CenterImageSpan;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.span.DagoClickableSpan;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.span.HeaderSpan;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.span.MedalSpan;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.span.RadiusSpan;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.view.TrueLoveMedalView;
import com.youku.live.dago.widgetlib.util.UIUtil;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import com.youku.live.dsl.oss.IXOSSProcessFormater;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import tb.fw0;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DrawCellItemUtils {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int ACTIVE_MEDAL_LEVEL1_TYPE_ID = 7;
    private static final int ACTIVE_MEDAL_LEVEL2_TYPE_ID = 8;
    private static final int ACTIVE_MEDAL_LEVEL3_TYPE_ID = 9;
    private static final String CONTENT_ANCHOR_LEVEL = "[alevel]";
    private static final String CONTENT_GIFT_ICON = "[gift]";
    private static final String CONTENT_HEADER = "[header]";
    private static final String CONTENT_IMAGE = "[image]";
    private static final String CONTENT_MEDAL = "[medal]";
    private static final String CONTENT_USER_LEVEL = "[ulevel]";
    private static final String GIFT_BASE = "xingmeng_gift_";
    private static final int LOVE_MEDAL_TYPE_ID = 11;
    private static final String TAG = "DrawCellItemUtils";
    private static int mIconHeight = UIUtil.dip2px(14);

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface DeleteTextSpanCallBack {
        void removeText(String str);
    }

    static /* synthetic */ Context access$500() {
        return getContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void alarmCommitBigImage(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2114290956")) {
            ipChange.ipc$dispatch("-2114290956", new Object[]{str});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        AppMonitor.Alarm.commitFail("YoukuLiveAlarm", "DagoChatList", new JSONObject(hashMap).toString(), fw0.LOGIN_ALIPAY_FAILED_CODE, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void alarmCommitLoadImageError(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1337349316")) {
            ipChange.ipc$dispatch("-1337349316", new Object[]{str});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        AppMonitor.Alarm.commitFail("YoukuLiveAlarm", "DagoChatList", new JSONObject(hashMap).toString(), fw0.LOGIN_TAOBAO_FAILED_CODE, str);
    }

    public static CharSequence drawAnchorLevelCellItem(AnchorLevelCellItem anchorLevelCellItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2065620812")) {
            return (CharSequence) ipChange.ipc$dispatch("2065620812", new Object[]{anchorLevelCellItem});
        }
        int i = anchorLevelCellItem.level;
        if (i > 0) {
            Bitmap bitmap = null;
            try {
                bitmap = LevelStatic.getInstance().getAnchorLevelById(String.valueOf(i));
            } catch (Exception unused) {
            }
            if (bitmap != null) {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                int i2 = (mIconHeight * width) / height;
                BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), bitmap);
                bitmapDrawable.setBounds(0, 0, i2, mIconHeight);
                ((ILog) Dsl.getService(ILog.class)).i(TAG, "drawAnchorLevelCellItem: btmWidth= " + width + ", btmHeight= " + height + ", mIconWidth= " + i2 + ", mIconHeight= " + mIconHeight);
                CenterImageSpan centerImageSpan = new CenterImageSpan(bitmapDrawable);
                SpannableString spannableString = new SpannableString(CONTENT_ANCHOR_LEVEL);
                spannableString.setSpan(centerImageSpan, 0, 8, 17);
                return spannableString;
            }
        }
        return new SpannableString("");
    }

    public static CharSequence drawButtonCellItem(final ButtonCellItem buttonCellItem, final OnCellClickListener onCellClickListener, final DeleteTextSpanCallBack deleteTextSpanCallBack) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "960258098")) {
            return (CharSequence) ipChange.ipc$dispatch("960258098", new Object[]{buttonCellItem, onCellClickListener, deleteTextSpanCallBack});
        }
        final SpannableString spannableString = new SpannableString(buttonCellItem.text);
        spannableString.setSpan(new RadiusSpan(Color.parseColor(buttonCellItem.bg[0]), Color.parseColor(buttonCellItem.color), UIUtil.dip2px(8), UIUtil.dip2px(14)), 0, spannableString.length(), 33);
        spannableString.setSpan(new AbsoluteSizeSpan(UIUtil.dip2px(8)), 0, spannableString.length(), 33);
        spannableString.setSpan(new DagoClickableSpan(Color.parseColor(buttonCellItem.color)) { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.DrawCellItemUtils.10
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.span.DagoClickableSpan, android.text.style.ClickableSpan
            public void onClick(@NonNull View view) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1104582615")) {
                    ipChange2.ipc$dispatch("-1104582615", new Object[]{this, view});
                    return;
                }
                ((ILog) Dsl.getService(ILog.class)).i(DrawCellItemUtils.TAG, "ButtonCellItem: onClick");
                OnCellClickListener onCellClickListener2 = onCellClickListener;
                if (onCellClickListener2 != null) {
                    onCellClickListener2.onClick(buttonCellItem.clickData);
                }
                if (buttonCellItem.hiddenAfterClick) {
                    ((ILog) Dsl.getService(ILog.class)).i(DrawCellItemUtils.TAG, "ButtonCellItem: hiddenAfterClick");
                    spannableString.removeSpan(this);
                    DeleteTextSpanCallBack deleteTextSpanCallBack2 = deleteTextSpanCallBack;
                    if (deleteTextSpanCallBack2 != null) {
                        deleteTextSpanCallBack2.removeText(buttonCellItem.text);
                    }
                }
            }
        }, 0, buttonCellItem.text.length(), 17);
        return spannableString;
    }

    private static SpannableString drawCustomMedal(TextView textView, BitmapDrawable bitmapDrawable, final String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "937278678")) {
            return (SpannableString) ipChange.ipc$dispatch("937278678", new Object[]{textView, bitmapDrawable, str, str2});
        }
        final WeakReference weakReference = new WeakReference(textView);
        SpannableString spannableString = new SpannableString(str2);
        final MedalSpan medalSpan = new MedalSpan(Color.argb(255, 57, 197, 33), 4, bitmapDrawable);
        int indexOf = str2.indexOf(StringUtils.CR);
        spannableString.setSpan(medalSpan, indexOf, str2.length() + indexOf, 17);
        DagoImageLoader.getInstance().load(getContext(), str, new ImageLoadListener() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.DrawCellItemUtils.9
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.ailpbaselib.image.ImageLoadListener
            public void onFail() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-623836299")) {
                    ipChange2.ipc$dispatch("-623836299", new Object[]{this});
                }
            }

            @Override // com.youku.live.dago.widgetlib.ailpbaselib.image.ImageLoadListener
            public void onSuccess(BitmapDrawable bitmapDrawable2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-628065815")) {
                    ipChange2.ipc$dispatch("-628065815", new Object[]{this, bitmapDrawable2});
                } else if (bitmapDrawable2 == null || bitmapDrawable2.getBitmap() == null) {
                    DrawCellItemUtils.alarmCommitLoadImageError(str);
                } else {
                    medalSpan.setDrawable(bitmapDrawable2);
                    TextView textView2 = (TextView) weakReference.get();
                    if (textView2 != null) {
                        textView2.invalidate();
                    }
                }
            }
        });
        return spannableString;
    }

    public static CharSequence drawFaceCellItem(final FaceCellItem faceCellItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1371828264")) {
            return (CharSequence) ipChange.ipc$dispatch("1371828264", new Object[]{faceCellItem});
        }
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (faceCellItem != null) {
            final HeaderSpan headerSpan = new HeaderSpan();
            final ImageLoadListener imageLoadListener = new ImageLoadListener() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.DrawCellItemUtils.4
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dago.widgetlib.ailpbaselib.image.ImageLoadListener
                public void onFail() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "843178736")) {
                        ipChange2.ipc$dispatch("843178736", new Object[]{this});
                    }
                }

                @Override // com.youku.live.dago.widgetlib.ailpbaselib.image.ImageLoadListener
                public void onSuccess(BitmapDrawable bitmapDrawable) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "435095118")) {
                        ipChange2.ipc$dispatch("435095118", new Object[]{this, bitmapDrawable});
                    } else if (bitmapDrawable == null || bitmapDrawable.getBitmap() == null) {
                        DrawCellItemUtils.alarmCommitLoadImageError(FaceCellItem.this.icon);
                    } else {
                        int i = HeaderSpan.srcSize;
                        bitmapDrawable.setBounds(i / 2, i / 2, i, i);
                        headerSpan.setIconDrawable(bitmapDrawable);
                    }
                }
            };
            String str = faceCellItem.src;
            int i = HeaderSpan.srcSize;
            final String urlWithOriginUrl = ((IXOSSProcessFormater) Dsl.getService(IXOSSProcessFormater.class)).getUrlWithOriginUrl(str, i, i);
            DagoImageLoader.getInstance().loadCircle(getContext(), urlWithOriginUrl, new ImageLoadListener() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.DrawCellItemUtils.5
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dago.widgetlib.ailpbaselib.image.ImageLoadListener
                public void onFail() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "549775729")) {
                        ipChange2.ipc$dispatch("549775729", new Object[]{this});
                    }
                }

                @Override // com.youku.live.dago.widgetlib.ailpbaselib.image.ImageLoadListener
                public void onSuccess(BitmapDrawable bitmapDrawable) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1495523987")) {
                        ipChange2.ipc$dispatch("-1495523987", new Object[]{this, bitmapDrawable});
                    } else if (bitmapDrawable == null || bitmapDrawable.getBitmap() == null) {
                        DrawCellItemUtils.alarmCommitLoadImageError(urlWithOriginUrl);
                    } else {
                        if (DrawCellItemUtils.isBigImage(bitmapDrawable.getBitmap())) {
                            DrawCellItemUtils.alarmCommitBigImage(urlWithOriginUrl);
                        }
                        int i2 = HeaderSpan.srcSize;
                        bitmapDrawable.setBounds(0, 0, i2, i2);
                        headerSpan.setSrcDrawable(DrawCellItemUtils.getOptimizedBitmapDrawable(bitmapDrawable, BitmapFactory.decodeResource(UIUtil.getResources(), R.drawable.dago_pgc_header_default)));
                        SpannableString spannableString = new SpannableString(DrawCellItemUtils.CONTENT_HEADER);
                        spannableString.setSpan(headerSpan, 0, 8, 17);
                        spannableStringBuilder.append((CharSequence) spannableString);
                        if (TextUtils.isEmpty(faceCellItem.icon)) {
                            return;
                        }
                        DagoImageLoader.getInstance().load(DrawCellItemUtils.access$500(), faceCellItem.icon, imageLoadListener);
                    }
                }
            });
            if (headerSpan.getSrcDrawable() == null) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) UIUtil.getResources().getDrawable(R.drawable.dago_pgc_header_default);
                bitmapDrawable.setBounds(0, 0, i, i);
                headerSpan.setSrcDrawable(bitmapDrawable);
                SpannableString spannableString = new SpannableString(CONTENT_HEADER);
                spannableString.setSpan(headerSpan, 0, 8, 17);
                spannableStringBuilder.append((CharSequence) spannableString);
            }
        }
        return spannableStringBuilder;
    }

    public static CharSequence drawGiftCellItem(GiftCellItem giftCellItem) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1482747768") ? (CharSequence) ipChange.ipc$dispatch("-1482747768", new Object[]{giftCellItem}) : drawGiftCellItem(null, giftCellItem);
    }

    public static CharSequence drawImageCellItem(ImageCellItem imageCellItem, OnCellClickListener onCellClickListener) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "364000928") ? (CharSequence) ipChange.ipc$dispatch("364000928", new Object[]{imageCellItem, onCellClickListener}) : drawImageCellItem(null, imageCellItem, onCellClickListener);
    }

    private static SpannableString drawImageMedal(TextView textView, BitmapDrawable bitmapDrawable, final String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1894883026")) {
            return (SpannableString) ipChange.ipc$dispatch("1894883026", new Object[]{textView, bitmapDrawable, str});
        }
        final WeakReference weakReference = new WeakReference(textView);
        final CenterImageSpan centerImageSpan = new CenterImageSpan(bitmapDrawable);
        SpannableString spannableString = new SpannableString(CONTENT_MEDAL);
        spannableString.setSpan(centerImageSpan, 0, 7, 17);
        DagoImageLoader.getInstance().load(getContext(), str, new ImageLoadListener() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.DrawCellItemUtils.7
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.ailpbaselib.image.ImageLoadListener
            public void onFail() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-37030285")) {
                    ipChange2.ipc$dispatch("-37030285", new Object[]{this});
                }
            }

            @Override // com.youku.live.dago.widgetlib.ailpbaselib.image.ImageLoadListener
            public void onSuccess(BitmapDrawable bitmapDrawable2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1061794901")) {
                    ipChange2.ipc$dispatch("-1061794901", new Object[]{this, bitmapDrawable2});
                } else if (bitmapDrawable2 == null || bitmapDrawable2.getBitmap() == null) {
                    DrawCellItemUtils.alarmCommitLoadImageError(str);
                } else {
                    centerImageSpan.setDrawable(bitmapDrawable2);
                    TextView textView2 = (TextView) weakReference.get();
                    if (textView2 != null) {
                        textView2.invalidate();
                    }
                }
            }
        });
        return spannableString;
    }

    public static CharSequence drawMedalCellItem(MedalCellItem medalCellItem) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "654165788") ? (CharSequence) ipChange.ipc$dispatch("654165788", new Object[]{medalCellItem}) : drawMedalCellItem(null, medalCellItem, null);
    }

    public static CharSequence drawTextCellItem(final TextCellItem textCellItem, final OnCellClickListener onCellClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-428613916")) {
            return (CharSequence) ipChange.ipc$dispatch("-428613916", new Object[]{textCellItem, onCellClickListener});
        }
        SpannableString emojiConvertText = getEmojiConvertText(textCellItem);
        emojiConvertText.setSpan(new ForegroundColorSpan(Color.parseColor(textCellItem.color)), 0, emojiConvertText.length(), 17);
        if (textCellItem.bold) {
            emojiConvertText.setSpan(new StyleSpan(1), 0, emojiConvertText.length(), 17);
        }
        if (textCellItem.clickData != null) {
            emojiConvertText.setSpan(new DagoClickableSpan(Color.parseColor(textCellItem.color)) { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.DrawCellItemUtils.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.span.DagoClickableSpan, android.text.style.ClickableSpan
                public void onClick(@NonNull View view) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-631232613")) {
                        ipChange2.ipc$dispatch("-631232613", new Object[]{this, view});
                        return;
                    }
                    OnCellClickListener onCellClickListener2 = onCellClickListener;
                    if (onCellClickListener2 != null) {
                        onCellClickListener2.onClick(textCellItem.clickData);
                    }
                }
            }, 0, emojiConvertText.length(), 17);
        }
        return emojiConvertText;
    }

    private static SpannableString drawTrueLoveMedal(TextView textView, BitmapDrawable bitmapDrawable, final String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-174707195")) {
            return (SpannableString) ipChange.ipc$dispatch("-174707195", new Object[]{textView, bitmapDrawable, str, str2});
        }
        final WeakReference weakReference = new WeakReference(textView);
        TrueLoveMedalView trueLoveMedalView = new TrueLoveMedalView(getContext());
        trueLoveMedalView.setData(bitmapDrawable, str2);
        Bitmap convertViewToBitmap = TrueLoveGroupMapper.convertViewToBitmap(trueLoveMedalView);
        if (convertViewToBitmap != null) {
            int width = convertViewToBitmap.getWidth();
            int height = convertViewToBitmap.getHeight();
            BitmapDrawable bitmapDrawable2 = new BitmapDrawable(convertViewToBitmap);
            bitmapDrawable2.setBounds(0, 0, (mIconHeight * width) / height, mIconHeight);
            final CenterImageSpan centerImageSpan = new CenterImageSpan(bitmapDrawable2);
            SpannableString spannableString = new SpannableString(CONTENT_MEDAL);
            spannableString.setSpan(centerImageSpan, 0, 7, 17);
            DagoImageLoader.getInstance().load(getContext(), str, new ImageLoadListener() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.DrawCellItemUtils.8
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dago.widgetlib.ailpbaselib.image.ImageLoadListener
                public void onFail() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-330433292")) {
                        ipChange2.ipc$dispatch("-330433292", new Object[]{this});
                    }
                }

                @Override // com.youku.live.dago.widgetlib.ailpbaselib.image.ImageLoadListener
                public void onSuccess(BitmapDrawable bitmapDrawable3) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1302553290")) {
                        ipChange2.ipc$dispatch("1302553290", new Object[]{this, bitmapDrawable3});
                    } else if (bitmapDrawable3 == null || bitmapDrawable3.getBitmap() == null) {
                        DrawCellItemUtils.alarmCommitLoadImageError(str);
                    } else {
                        centerImageSpan.setDrawable(bitmapDrawable3);
                        TextView textView2 = (TextView) weakReference.get();
                        if (textView2 != null) {
                            textView2.invalidate();
                        }
                    }
                }
            });
            return spannableString;
        }
        return null;
    }

    public static CharSequence drawUserLevelCellItem(UserLevelCellItem userLevelCellItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "245819040")) {
            return (CharSequence) ipChange.ipc$dispatch("245819040", new Object[]{userLevelCellItem});
        }
        int i = userLevelCellItem.level;
        if (i > 0) {
            Bitmap bitmap = null;
            try {
                bitmap = LevelStatic.getInstance().getUserLevelById(String.valueOf(i));
            } catch (Exception unused) {
            }
            if (bitmap != null) {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                int i2 = (mIconHeight * width) / height;
                BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), bitmap);
                bitmapDrawable.setBounds(0, 0, i2, mIconHeight);
                ((ILog) Dsl.getService(ILog.class)).i(TAG, "drawUserLevelCellItem: btmWidth= " + width + ", btmHeight= " + height + ", mIconWidth= " + i2 + ", mIconHeight= " + mIconHeight);
                CenterImageSpan centerImageSpan = new CenterImageSpan(bitmapDrawable);
                SpannableString spannableString = new SpannableString(CONTENT_USER_LEVEL);
                spannableString.setSpan(centerImageSpan, 0, 8, 17);
                return spannableString;
            }
        }
        return new SpannableString("");
    }

    private static String getActiveText(int i) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "272581857")) {
            return (String) ipChange.ipc$dispatch("272581857", new Object[]{Integer.valueOf(i)});
        }
        try {
            str = ActiveStageConfig.getInstance().getActiveStage(i - 6);
        } catch (Exception unused) {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            str = "普通";
        }
        return "\r\r\r\r\r\r\r\r" + str;
    }

    public static int getBitmapSize(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2111621190")) {
            return ((Integer) ipChange.ipc$dispatch("-2111621190", new Object[]{bitmap})).intValue();
        }
        if (bitmap == null) {
            return 0;
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            return bitmap.getAllocationByteCount();
        }
        if (i >= 12) {
            return bitmap.getByteCount();
        }
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    private static Context getContext() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1358593276") ? (Context) ipChange.ipc$dispatch("1358593276", new Object[0]) : UIUtil.getContext();
    }

    private static SpannableString getEmojiConvertText(TextCellItem textCellItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-170361620")) {
            return (SpannableString) ipChange.ipc$dispatch("-170361620", new Object[]{textCellItem});
        }
        return textCellItem.emoji ? ExpressionManager.getInstance().getExpressionString(ExpressionDict.getInstance().getConvertStringWithRealName(textCellItem.text), ExpressionManager.facePatten.pattern(), (String) null) : new SpannableString(textCellItem.text);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static BitmapDrawable getOptimizedBitmapDrawable(BitmapDrawable bitmapDrawable, Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1364991503")) {
            return (BitmapDrawable) ipChange.ipc$dispatch("-1364991503", new Object[]{bitmapDrawable, bitmap});
        }
        if (bitmapDrawable != null) {
            Rect bounds = bitmapDrawable.getBounds();
            if (!isBigImage(bitmapDrawable.getBitmap()) || bounds.right <= 0 || bounds.bottom <= 0) {
                return bitmapDrawable;
            }
            ((ILog) Dsl.getService(ILog.class)).i(TAG, "jiangzBm getOptimizedBitmapDrawable: " + bounds.right + AVFSCacheConstants.COMMA_SEP + bounds.bottom);
            BitmapDrawable bitmapDrawable2 = new BitmapDrawable(UIUtil.getResources(), bitmap);
            bitmapDrawable2.setBounds(bounds);
            return bitmapDrawable2;
        }
        return bitmapDrawable;
    }

    private static Resources getResources() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1694389537") ? (Resources) ipChange.ipc$dispatch("-1694389537", new Object[0]) : UIUtil.getContext().getResources();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isBigImage(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "109511866") ? ((Boolean) ipChange.ipc$dispatch("109511866", new Object[]{bitmap})).booleanValue() : getBitmapSize(bitmap) > 102400;
    }

    public static CharSequence drawGiftCellItem(TextView textView, GiftCellItem giftCellItem) {
        final String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1130965276")) {
            return (CharSequence) ipChange.ipc$dispatch("-1130965276", new Object[]{textView, giftCellItem});
        }
        final WeakReference weakReference = new WeakReference(textView);
        String valueOf = String.valueOf(giftCellItem.id);
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "drawGiftCellItem:" + valueOf);
        try {
            str = "file://" + LFFilePathUtils.getInstance().getGiftsDirPath() + File.separator + GIFT_BASE + valueOf;
        } catch (Exception unused) {
            str = "";
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "giftIconFilePath: " + str);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(UIUtil.getResources(), BitmapFactory.decodeResource(UIUtil.getResources(), 17170432));
        int i = mIconHeight;
        bitmapDrawable.setBounds(0, 0, i, i);
        SpannableString spannableString = new SpannableString(CONTENT_GIFT_ICON);
        final CenterImageSpan centerImageSpan = new CenterImageSpan(bitmapDrawable);
        spannableString.setSpan(centerImageSpan, 0, 6, 17);
        spannableStringBuilder.append((CharSequence) spannableString);
        DagoImageLoader.getInstance().load(getContext(), str, new ImageLoadListener() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.DrawCellItemUtils.6
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.ailpbaselib.image.ImageLoadListener
            public void onFail() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "256372722")) {
                    ipChange2.ipc$dispatch("256372722", new Object[]{this});
                }
            }

            @Override // com.youku.live.dago.widgetlib.ailpbaselib.image.ImageLoadListener
            public void onSuccess(BitmapDrawable bitmapDrawable2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "868824204")) {
                    ipChange2.ipc$dispatch("868824204", new Object[]{this, bitmapDrawable2});
                } else if (bitmapDrawable2 == null || bitmapDrawable2.getBitmap() == null) {
                    DrawCellItemUtils.alarmCommitLoadImageError(str);
                } else {
                    centerImageSpan.setDrawable(bitmapDrawable2);
                    TextView textView2 = (TextView) weakReference.get();
                    if (textView2 != null) {
                        textView2.invalidate();
                    }
                }
            }
        });
        return spannableStringBuilder;
    }

    public static CharSequence drawImageCellItem(TextView textView, final ImageCellItem imageCellItem, final OnCellClickListener onCellClickListener) {
        final int i;
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "800032318")) {
            return (CharSequence) ipChange.ipc$dispatch("800032318", new Object[]{textView, imageCellItem, onCellClickListener});
        }
        final WeakReference weakReference = new WeakReference(textView);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (imageCellItem != null) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(UIUtil.getResources(), BitmapFactory.decodeResource(UIUtil.getResources(), 17170432));
            int i3 = imageCellItem.w;
            if (i3 > 0 && (i2 = imageCellItem.h) > 0) {
                i = (mIconHeight * i3) / i2;
            } else {
                i = mIconHeight;
            }
            bitmapDrawable.setBounds(0, 0, i, mIconHeight);
            SpannableString spannableString = new SpannableString(CONTENT_IMAGE);
            final CenterImageSpan centerImageSpan = new CenterImageSpan(bitmapDrawable);
            spannableString.setSpan(centerImageSpan, 0, 7, 17);
            if (imageCellItem.clickData != null) {
                spannableString.setSpan(new DagoClickableSpan(Color.parseColor("#FFFFFF")) { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.DrawCellItemUtils.2
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.span.DagoClickableSpan, android.text.style.ClickableSpan
                    public void onClick(@NonNull View view) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "1480057756")) {
                            ipChange2.ipc$dispatch("1480057756", new Object[]{this, view});
                            return;
                        }
                        OnCellClickListener onCellClickListener2 = onCellClickListener;
                        if (onCellClickListener2 != null) {
                            onCellClickListener2.onClick(imageCellItem.clickData);
                        }
                    }
                }, 0, 7, 17);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
            final String urlWithOriginUrl = ((IXOSSProcessFormater) Dsl.getService(IXOSSProcessFormater.class)).getUrlWithOriginUrl(imageCellItem.src, i, mIconHeight);
            DagoImageLoader.getInstance().load(getContext(), urlWithOriginUrl, new ImageLoadListener() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.DrawCellItemUtils.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dago.widgetlib.ailpbaselib.image.ImageLoadListener
                public void onFail() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1136581743")) {
                        ipChange2.ipc$dispatch("1136581743", new Object[]{this});
                    }
                }

                @Override // com.youku.live.dago.widgetlib.ailpbaselib.image.ImageLoadListener
                public void onSuccess(BitmapDrawable bitmapDrawable2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1929253073")) {
                        ipChange2.ipc$dispatch("-1929253073", new Object[]{this, bitmapDrawable2});
                    } else if (bitmapDrawable2 == null || bitmapDrawable2.getBitmap() == null) {
                        DrawCellItemUtils.alarmCommitLoadImageError(urlWithOriginUrl);
                    } else {
                        if (DrawCellItemUtils.isBigImage(bitmapDrawable2.getBitmap())) {
                            DrawCellItemUtils.alarmCommitBigImage(urlWithOriginUrl);
                        }
                        bitmapDrawable2.setBounds(0, 0, i, DrawCellItemUtils.mIconHeight);
                        centerImageSpan.setDrawable(DrawCellItemUtils.getOptimizedBitmapDrawable(bitmapDrawable2, BitmapFactory.decodeResource(UIUtil.getResources(), 17170432)));
                        TextView textView2 = (TextView) weakReference.get();
                        if (textView2 != null) {
                            textView2.invalidate();
                        }
                    }
                }
            });
        }
        return spannableStringBuilder;
    }

    public static CharSequence drawMedalCellItem(TextView textView, MedalCellItem medalCellItem, String str) {
        SpannableString drawCustomMedal;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "67242872")) {
            return (CharSequence) ipChange.ipc$dispatch("67242872", new Object[]{textView, medalCellItem, str});
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "groupName: " + str);
        int i = medalCellItem.id;
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "medalId: " + i);
        long j = (long) i;
        int allMedalType = MedalsConfig.getInstance().getAllMedalType(j);
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "medalType: " + allMedalType);
        String allMedalUrl = MedalsConfig.getInstance().getAllMedalUrl(j);
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "medalUrl: " + allMedalUrl);
        int[] allMedalSize = MedalsConfig.getInstance().getAllMedalSize(j);
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "medelSize: " + allMedalSize[0] + AVFSCacheConstants.COMMA_SEP + allMedalSize[1]);
        if (!TextUtils.isEmpty(allMedalUrl) && allMedalSize[0] + allMedalSize[1] != 0) {
            int i2 = allMedalSize[0];
            int i3 = allMedalSize[1];
            int i4 = (mIconHeight * i2) / i3;
            BitmapDrawable bitmapDrawable = new BitmapDrawable(UIUtil.getResources(), BitmapFactory.decodeResource(UIUtil.getResources(), 17170432));
            bitmapDrawable.setBounds(0, 0, i4, mIconHeight);
            ((ILog) Dsl.getService(ILog.class)).d(TAG, "drawMedalCellItem: btmWidth= " + i2 + ", btmHeight= " + i3 + ", mIconWidth= " + i4 + ", mIconHeight= " + mIconHeight);
            if (allMedalType == 7 || allMedalType == 8 || allMedalType == 9) {
                drawCustomMedal = drawCustomMedal(textView, bitmapDrawable, allMedalUrl, getActiveText(allMedalType));
            } else if (allMedalType != 11) {
                drawCustomMedal = drawImageMedal(textView, bitmapDrawable, allMedalUrl);
            } else {
                drawCustomMedal = drawTrueLoveMedal(textView, bitmapDrawable, allMedalUrl, str);
            }
            if (drawCustomMedal != null) {
                spannableStringBuilder.append((CharSequence) drawCustomMedal);
            }
            return spannableStringBuilder;
        }
        ((ILog) Dsl.getService(ILog.class)).e(TAG, "drawMedalCellItem url or size is null, medalId: " + i);
        return spannableStringBuilder;
    }
}
