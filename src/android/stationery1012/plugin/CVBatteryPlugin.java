package stationery1012.plugin;
 
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import android.content.IntentFilter;
import android.content.Intent;
import android.os.BatteryManager;
import android.content.Context;
 
public class CVBatteryPlugin extends CordovaPlugin {
    // Androidは必ずexecuteが呼び出されます
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        // actionにJavaScriptで呼び出したメソッド名が入るので、必要に応じて処理分岐します
        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        // バッテリーの残量の取得
        Context context = this.cordova.getActivity().getApplicationContext();
        Intent batteryStatus = context.registerReceiver(null, ifilter);
        int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale = batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
        float bLevel = level / (float)scale;
        // コールバック形式でレスポンスを返却
        callbackContext.success(String.valueOf(bLevel));
        return true;
    }
}