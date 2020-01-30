/* jshint undef: true, unused: false, esnext: true, strict:false, laxbreak:true */
/* globals require, describe, it, console */
let expect = require('chai').expect;
let _ = require('lodash');
let {Inbox} = require('../app/inbox');

function entry(address,message) {
	return {address, message};
}

describe('Inbox', () => {
	let inbox,
		msgs;
	
	beforeEach(() => {
		msgs = [];
		inbox = new Inbox((msg) => { msgs.push(msg) });
	});

	describe('receiveMessage', () => {
		it('should redirect messages to "reception"', () => {
			inbox.receiveMessage("Artanis", "My life for Aiur");
			
			expect(msgs).to.deep.equal([entry('reception','My life for Aiur')]);
		});
	});

});