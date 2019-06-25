

package com.easebuzz;

import android.app.Activity;
import android.content.Intent;

import com.easebuzz.payment.kit.PWECouponsActivity;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.bridge.ActivityEventListener;

import org.json.JSONException;
import org.json.JSONObject;

import javax.annotation.Nullable;

import datamodels.StaticDataModel;

public class RNEasebuzzKitModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNEasebuzzKitModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
    reactContext.addActivityEventListener(easebuzzActivityEventListener);

  }

  @Override
  public String getName() {
    return "EasebuzzModule";
  }

  @ReactMethod
  public void PayEasebuzz(ReadableMap parameters) {

    JSONObject parametersJSON = EasebuzzUtility.readableMapToJson(parameters);

    Activity currentActivity = getCurrentActivity();
    try {
      Intent intentProceed = new Intent(currentActivity, PWECouponsActivity.class);
      float amount = Float.parseFloat(parameters.getString("amount"));
      intentProceed.putExtra("trxn_id",parametersJSON.optString("txnid")); 
      intentProceed.putExtra("trxn_amount",amount); 
      intentProceed.putExtra("trxn_prod_info",parametersJSON.optString("productinfo")); 
      intentProceed.putExtra("trxn_firstname",parametersJSON.optString("firstname")); 
      intentProceed.putExtra("trxn_email_id",parametersJSON.optString("email")); 
      intentProceed.putExtra("trxn_phone",parametersJSON.optString("phone")); 
      intentProceed.putExtra("trxn_s_url",parametersJSON.optString("surl")); 
      intentProceed.putExtra("trxn_f_url",parametersJSON.optString("furl"));
      intentProceed.putExtra("trxn_key",parametersJSON.optString("key"));  
      intentProceed.putExtra("trxn_udf1",parametersJSON.optString("udf1")); 
      intentProceed.putExtra("trxn_udf2",parametersJSON.optString("udf2"));
      intentProceed.putExtra("trxn_udf3",parametersJSON.optString("udf3"));
      intentProceed.putExtra("trxn_udf4",parametersJSON.optString("udf4"));
      intentProceed.putExtra("trxn_udf5",parametersJSON.optString("udf5"));
      intentProceed.putExtra("trxn_udf6",parametersJSON.optString("udf6"));
      intentProceed.putExtra("trxn_udf7",parametersJSON.optString("udf7"));
      intentProceed.putExtra("trxn_udf8",parametersJSON.optString("udf8"));
      intentProceed.putExtra("trxn_udf9",parametersJSON.optString("ud9"));
      intentProceed.putExtra("trxn_udf10",parametersJSON.optString("udf10"));
      intentProceed.putExtra("trxn_address1",parametersJSON.optString("address1")); 
      intentProceed.putExtra("trxn_address2",parametersJSON.optString("address2")); 
      intentProceed.putExtra("trxn_city",parametersJSON.optString("city")); 
      intentProceed.putExtra("trxn_state",parametersJSON.optString("state")); 
      intentProceed.putExtra("trxn_country",parametersJSON.optString("country")); 
      intentProceed.putExtra("trxn_zipcode",parametersJSON.optString("zipcode")); 
      intentProceed.putExtra("pay_mode",parametersJSON.optString("pay_mode")); 
      intentProceed.putExtra("hash",parametersJSON.optString("hash")); 
      intentProceed.putExtra("unique_id",parametersJSON.optString("unique_id")); 
      intentProceed.putExtra("sub_merchant_id",parametersJSON.optString("sub_merchant_id")); 
      currentActivity.startActivityForResult(intentProceed, StaticDataModel.PWE_REQUEST_CODE);


    } catch (Exception e) {
      String result = "";
      String payment_response = "";
      JSONObject error_object = new JSONObject();
      WritableMap responseMap = Arguments.createMap();

      try {
        error_object.put("error", "Exception");
        error_object.put("error_msg", e.toString());
        responseMap  = EasebuzzUtility.jsonToWritableMap(error_object);
      } catch (JSONException e1) {
      }

      result = "payment_failed";
      setPaymentResult(result, responseMap);
    }
  }


  private final ActivityEventListener easebuzzActivityEventListener = new ActivityEventListener() {

    @Override
    public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {
      if (requestCode == StaticDataModel.PWE_REQUEST_CODE) {
        String result = "";
        String payment_response = "";
         WritableMap responseMap = Arguments.createMap();
        JSONObject error_object = new JSONObject();
        if(data != null ) {
          result = data.getStringExtra("result");
          payment_response = data.getStringExtra("payment_response");
          try {
            JSONObject responseObj = new JSONObject(payment_response);
            responseMap  = EasebuzzUtility.jsonToWritableMap(responseObj);
            setPaymentResult(result, responseMap);

          }catch (Exception e){
            try {
              error_object.put("error", "Exception");
              error_object.put("error_msg", e.toString());
              responseMap  = EasebuzzUtility.jsonToWritableMap(error_object);
            } catch (JSONException e1) {
            }

            result = "payment_failed";
            payment_response = "" + payment_response;
            setPaymentResult(result, responseMap);
          }

        }else{
          try {
            error_object.put("error", "No Response");
            error_object.put("error_msg", "Could not receive the response from easebuzz");
            responseMap  = EasebuzzUtility.jsonToWritableMap(error_object);
          } catch (JSONException e1) {
          }
          result = "payment_failed";
          setPaymentResult(result, responseMap);
        }

      }else
      {
        onActivityResult(activity, requestCode, resultCode, data);
      }
    }

    @Override
    public void onNewIntent(Intent intent) {

    }




  };

  private void setPaymentResult(String result, WritableMap response) {
    WritableMap params = Arguments.createMap();
    params.putString("result", result);
    params.putMap("payment_response", response);
    sendPaymentResult(getReactApplicationContext(), "EasebuzzPaymentResultEvent", params);


  }

  private void sendPaymentResult(ReactContext reactContext, String eventName, @Nullable WritableMap params) {
    reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
            .emit(eventName, params);
  }



}