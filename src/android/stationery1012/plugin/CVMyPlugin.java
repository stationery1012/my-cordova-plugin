package stationery1012.plugin;
 
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * 引数(args[0])で渡された文字列を「レスポンス：args[0]」形式で返却する
 * 例：status(["Hello!"])->レスポンス：Hello!
 */
public class CVMyPlugin extends CordovaPlugin {
    // Androidは必ずexecuteが呼び出されます
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        String param = args.getString(0);
        callbackContext.success("レスポンス：" + param);
        return true;
    }
}