package com.nick.smarthome.widgets.wheelpicker.widget.curved;

import android.content.Context;
import android.util.AttributeSet;

import com.nick.smarthome.widgets.wheelpicker.view.WheelCurvedPicker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 基于房间号选择控件
 * RoomNoPicker base on WheelPicker
 *
 * @author nick 2016-03-06
 * @version 1.0.0 beta
 */
public class WheelRoomNoPicker extends WheelCurvedPicker {
    private static final List<String> MONTHS = new ArrayList<>();

    static {
        for (int i = 1; i <= 50; i++) MONTHS.add(String.valueOf(i));
    }

    private List<String> months = MONTHS;

    private int month;

    public WheelRoomNoPicker(Context context) {
        super(context);
        init();
    }

    public WheelRoomNoPicker(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        super.setData(months);
        setCurrentMonth(Calendar.getInstance().get(Calendar.MONTH) + 1);
    }

    @Override
    public void setData(List<String> data) {
        throw new RuntimeException("Set data will not allow here!");
    }

    public void setCurrentMonth(int month) {
        month = Math.max(month, 1);
        month = Math.min(month, 50);
        this.month = month;
        setItemIndex(month - 1);
    }
}