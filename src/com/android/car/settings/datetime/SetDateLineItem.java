/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.android.car.settings.datetime;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.text.format.DateFormat;

import com.android.car.settings.R;
import com.android.car.settings.common.AnimationUtil;
import com.android.car.settings.common.TextLineItem;
import com.android.settingslib.datetime.ZoneGetter;

import java.util.Calendar;

/**
 * A LineItem that displays and sets system date.
 */
class SetDateLineItem extends TextLineItem {

    private Context mContext;

    public SetDateLineItem(Context context) {
        super(context.getString(R.string.date_time_set_date));
        mContext = context;
    }

    @Override
    public CharSequence getDesc() {
        return DateFormat.getLongDateFormat(mContext).format(Calendar.getInstance().getTime());
    }

    @Override
    public boolean isEnabled() {
        return Settings.Global.getInt(mContext.getContentResolver(),
                Settings.Global.AUTO_TIME, 0) <= 0;
    }

    @Override
    public void onClick() {
        Intent intent = new Intent(mContext /* context */, DatePickerActivity.class);
        mContext.startActivity(intent, AnimationUtil.slideInFromRightOption(mContext).toBundle());
    }
}
