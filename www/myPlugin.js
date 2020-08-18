const MyPlugin = function () {}

MyPlugin.prototype.status = function (success, fail, args) {
  cordova.exec(success, fail, 'CVMyPlugin', 'status', args)
}

const myPlugin = new MyPlugin()
module.exports = myPlugin
