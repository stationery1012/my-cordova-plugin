const Battery = function () {}

Battery.prototype.status = function (success, fail, args) {
  cordova.exec(success, fail, 'CVBatteryPlugin', 'status', args)
}

const battery = new Battery()
module.exports = battery
