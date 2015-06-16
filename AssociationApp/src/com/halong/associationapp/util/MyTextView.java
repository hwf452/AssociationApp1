package com.halong.associationapp.util;



import android.content.Context;

import android.graphics.Canvas;
import android.graphics.Color;


import android.util.AttributeSet;

import android.widget.TextView;

//自定义文本标签，自动换行
import android.app.Activity;  
  
 
import android.graphics.Paint;  
 
  
public class MyTextView extends TextView{  
    private final String namespace = "http://schemas.android.com/apk/res/android";  
    private String text;  
    private float textSize;  
    private float paddingLeft;  
    private float paddingRight;
    
    private float marginLeft;  
    private float marginRight;  
    private int textColor;  
      
      
    private Paint paint1 = new Paint();  
    private float textShowWidth;  
    public MyTextView(Context context, AttributeSet attrs) {  
        super(context, attrs);  
        text = attrs.getAttributeValue(  
                namespace, "text");  
        textSize = attrs.getAttributeIntValue(namespace, "textSize",DisplayUtil.sp2px(context, getTextSize()));  
        textColor = attrs.getAttributeIntValue(namespace, "textColor",Color.BLACK);  
        paddingLeft = attrs.getAttributeIntValue(namespace, "paddingLeft", DisplayUtil.dip2px(context, getPaddingLeft()));  
        paddingRight = attrs.getAttributeIntValue(namespace, "paddingRight", DisplayUtil.dip2px(context, getPaddingRight()));  
       
        
        marginLeft = attrs.getAttributeIntValue(namespace, "marginLeft", DisplayUtil.dip2px(context, getLeft()));  
        marginRight = attrs.getAttributeIntValue(namespace, "marginRight", DisplayUtil.dip2px(context, getRight()));
      
        paint1.setTextSize(textSize);  
        paint1.setColor(textColor);  
        paint1.setAntiAlias(true);  
        textShowWidth = ((Activity) context).getWindowManager().getDefaultDisplay().getWidth() - paddingLeft - paddingRight - marginLeft - marginRight;  
    }  
    @Override  
    protected void onDraw(Canvas canvas) {  
        //super.onDraw(canvas);  
        int lineCount = 0;  
        text = this.getText().toString();//.replaceAll("\n", "\r\n");  
        if(text==null)return;  
        char[] textCharArray = text.toCharArray();  
        // 已绘的宽度  
        float drawedWidth = 0;  
        float charWidth;  
        for (int i = 0; i < textCharArray.length; i++) {  
            charWidth = paint1.measureText(textCharArray, i, 1);  
              
            if(textCharArray[i]=='\n'){  
                lineCount++;  
                drawedWidth = 0;  
                continue;  
            }  
            if (textShowWidth - drawedWidth < charWidth) {  
                lineCount++;  
                drawedWidth = 0;  
            }  
            canvas.drawText(textCharArray, i, 1, paddingLeft + drawedWidth,  
                    (lineCount + 1) * textSize, paint1);  
            drawedWidth += charWidth;  
        }  
        setHeight((lineCount + 1) * (int) textSize + 5);  
    }  
}  
