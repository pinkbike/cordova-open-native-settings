/*
 * PhoneGap is available under *either* the terms of the modified BSD license *or* the
 * MIT License (2008). See http://opensource.org/licenses/alphabetical for full text.
 *
 * Copyright (c) 2005-2010, Nitobi Software Inc.
 * Copyright (c) 2011, IBM Corporation
 */

package com.phonegap.plugins.nativesettings;

import org.json.JSONArray;

import android.content.Intent;
import android.content.Context;
import android.net.Uri;

import android.provider.Settings;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;

public class NativeSettings extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
        PluginResult.Status status = PluginResult.Status.OK;
        Uri packageUri = Uri.parse("package:" + this.cordova.getActivity().getPackageName());
        String result = "";

        //Information on settings can be found here:
        //http://developer.android.com/reference/android/provider/Settings.html

        if (action.equals("open")) {
            this.cordova.getActivity().startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
        } else if (action.equals("application_details")) {
            this.cordova.getActivity().startActivity(new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS, packageUri));
        } else if (action.equals("location_source")) {
            this.cordova.getActivity().startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
        } else {
            status = PluginResult.Status.INVALID_ACTION;
        }
        
        callbackContext.sendPluginResult(new PluginResult(status, result));

        return true;
    }
}

