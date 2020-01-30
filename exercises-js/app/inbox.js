/* jshint undef: true, unused: false, esnext: true, strict:false, laxbreak:true */
/* globals module, require */
module.exports = (() => {

let _ = require('lodash');

class Inbox {

	constructor(sendMessage) {
		this.sendMessage = sendMessage;
	}

	receiveMessage(from, message) {
		this.sendMessage({address:'',message:''});
	}
}

return {Inbox};

})();