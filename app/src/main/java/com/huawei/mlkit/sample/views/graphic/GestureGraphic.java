/**
 *  Copyright 2018 Google LLC
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.huawei.mlkit.sample.views.graphic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

import com.huawei.hms.mlsdk.gesture.MLGesture;
import com.huawei.mlkit.sample.R;
import com.huawei.mlkit.sample.entity.TransDataEntity;
import com.huawei.mlkit.sample.views.overlay.GraphicOverlay;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class GestureGraphic extends BaseGraphic {

    //-------------计数
    public static  int count=0;
    public static String date;
    public static boolean isOpen=true;
    //---------------
    private final GraphicOverlay overlay;
    private Context mContext;
    private final List<MLGesture> results;

    private Paint textPaint;
    private Paint linePaint;
    private Paint rectPaint;
    private final Rect rect;
   TransDataEntity mydata=new TransDataEntity();

    public GestureGraphic(GraphicOverlay overlay, Context context, List<MLGesture> results) {
        super(overlay);
        this.overlay = overlay;
        this.mContext = context;
        this.results = results;

        textPaint = new Paint();
        textPaint.setColor(Color.YELLOW);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setStrokeWidth(5f);
        textPaint.setTextSize(100);

        linePaint = new Paint();
        linePaint.setColor(Color.GREEN);
        linePaint.setStyle(Paint.Style.STROKE);
        linePaint.setStrokeWidth(4f);
        linePaint.setAntiAlias(true);

        rectPaint = new Paint();
        rectPaint.setColor(Color.BLUE);
        rectPaint.setStyle(Paint.Style.STROKE);
        rectPaint.setStrokeWidth(5f);
        rectPaint.setAntiAlias(true);

        rect = new Rect();

    }

    @Override
    public synchronized void draw(Canvas canvas) {

        for (int i = 0; i < results.size(); i++) {
            MLGesture mlGesture = results.get(i);

            canvas.drawRect(rect, rectPaint);

            Rect rect = translateRect(mlGesture.getRect());
            if (rect.right < rect.left) {
                int x = rect.left;
                rect.left = rect.right;
                rect.right = x;
            }
            canvas.drawRect(rect, linePaint);
            canvas.drawText(getChineseDescription(mlGesture.getCategory()),
                    translateX((mlGesture.getRect().left+mlGesture.getRect().right)/2),
                    translateY((mlGesture.getRect().top+mlGesture.getRect().bottom)/2),
                    textPaint);

        }
    }

    private String getChineseDescription(int gestureCategory) {
        String chineseDescription;
        switch (gestureCategory) {
            case MLGesture.ONE:
                chineseDescription = mContext.getString(R.string.gesture_one);
                isOpen=true;
                break;
            case MLGesture.SECOND:
                chineseDescription = mContext.getString(R.string.gesture_two);
                isOpen=true;
                break;
            case MLGesture.THREE:
                chineseDescription = mContext.getString(R.string.gesture_three);
                isOpen=true;
                break;
            case MLGesture.FOUR:
                chineseDescription = mContext.getString(R.string.gesture_four);
                isOpen=true;
                break;
            case MLGesture.FIVE:
                chineseDescription = mContext.getString(R.string.gesture_five);
                isOpen=true;
                break;
            case MLGesture.SIX:
                chineseDescription = mContext.getString(R.string.gesture_six);
                isOpen=true;
                break;
            case MLGesture.SEVEN:
                chineseDescription = mContext.getString(R.string.gesture_seven);
                isOpen=true;
                break;
            case MLGesture.EIGHT:
                chineseDescription = mContext.getString(R.string.gesture_eight);
                isOpen=true;
                break;
            case MLGesture.NINE:
                chineseDescription = mContext.getString(R.string.gesture_nine);
                isOpen=true;
                break;
            case MLGesture.DISS:
                chineseDescription = mContext.getString(R.string.gesture_diss);
                isOpen=true;
                break;
            case MLGesture.FIST:
                chineseDescription = mContext.getString(R.string.gesture_clench);
                if(isOpen) {count++; isOpen=false;}
                chineseDescription= chineseDescription + String.valueOf(count) + "次" ;
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateString = formatter.format(new Date());
                date=dateString;
                break;
            case MLGesture.GOOD:
                chineseDescription = mContext.getString(R.string.gesture_likes);
                isOpen=true;
                break;
            case MLGesture.HEART:
                chineseDescription = mContext.getString(R.string.gesture_bx);
                isOpen=true;
                break;
            case MLGesture.OK:
                chineseDescription = mContext.getString(R.string.gesture_confirm);
                isOpen=true;
                break;
            default:
                chineseDescription = mContext.getString(R.string.gesture_others);
                isOpen=true;
                break;

        }
        return chineseDescription;
    }

}
