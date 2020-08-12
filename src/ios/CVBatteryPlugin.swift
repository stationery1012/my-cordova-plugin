import Foundation
import UIKit
 
@objc(CVBatteryPlugin) class CVBatteryPlugin: CDVPlugin {
    // JavaScriptに公開する関数名を記述
    @objc(status:)
    func status(command: CDVInvokedUrlCommand) {
      // バッテリーの残量を取得
      UIDevice.current.isBatteryMonitoringEnabled = true
      let bLevel:Float = UIDevice.current.batteryLevel
      // 返却するレスポンスを作成
      let result = CDVPluginResult(status: CDVCommandStatus_OK,
                                   messageAs: String(bLevel))
      // コールバック形式でレスポンスを返却
      self.commandDelegate!.send(result, callbackId: command.callbackId)
    }
}