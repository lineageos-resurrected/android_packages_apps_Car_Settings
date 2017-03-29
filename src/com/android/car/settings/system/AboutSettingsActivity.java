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

package com.android.car.settings.system;

import android.os.Build;

import com.android.car.settings.common.ListSettingsActivity;
import com.android.car.settings.common.NoDividerItemDecoration;
import com.android.car.settings.common.SimpleTextLineItem;
import com.android.car.settings.common.TypedPagedListAdapter;
import com.android.car.settings.R;
import com.android.car.view.PagedListView;
import com.android.settingslib.DeviceInfoUtils;

import java.util.ArrayList;

/**
 * Shows basic info about the system and provide some actions like update, reset etc.
 */
public class AboutSettingsActivity extends ListSettingsActivity {

    @Override
    public ArrayList<TypedPagedListAdapter.LineItem> getLineItems() {
        ArrayList<TypedPagedListAdapter.LineItem> lineItems = new ArrayList<>();
        lineItems.add(new SimpleTextLineItem(
                getText(R.string.model_info), Build.MODEL + DeviceInfoUtils.getMsvSuffix()));
        lineItems.add(new SimpleTextLineItem(
                getText(R.string.firmware_version),
                getString(R.string.about_summary, Build.VERSION.RELEASE)));
        lineItems.add(new SimpleTextLineItem(
                getText(R.string.security_patch), DeviceInfoUtils.getSecurityPatch()));
        lineItems.add(new SimpleTextLineItem(
                getText(R.string.kernel_version), DeviceInfoUtils.getFormattedKernelVersion()));
        lineItems.add(new SimpleTextLineItem(
                getText(R.string.build_number), Build.DISPLAY));
        return lineItems;
    }

    @Override
    public PagedListView.Decoration getDecoration() {
        return new NoDividerItemDecoration(this);
    }
}
