//
//  RNEasebuzz.swift
//  easebuzzdemo
//
//  Created by Easebuzz Pvt Ltd on 13/06/19.
//  Copyright © 2019 Facebook. All rights reserved.
//

import Foundation

@objc(RNEasebuzz)
class RNEasebuzz: RCTEventEmitter {
  
  // Returns an array of your named events
  override func supportedEvents() -> [String]! {
    return ["EasebuzzPaymentResultEvent"]
  }
  
  @objc
  override static func requiresMainQueueSetup() -> Bool {
    return true
  }
  
  
  // Takes an errorCallback as a parameter so that you know when things go wrong.
  // This will make more sense once we get to the Javascript
  
  @objc class func paywithEasebuzzCallback(data: [String : AnyObject]) {
    NotificationCenter.default.post(name: Notification.Name(rawValue: "Easebuzz:PAYMENT_SUCCESS"), object: nil, userInfo: data)
  }
  
  override func startObserving() {
    NotificationCenter.default.addObserver(self, selector: #selector(self.onPaymentSuccess(_:)), name: NSNotification.Name(rawValue: "Easebuzz:PAYMENT_SUCCESS"), object: nil)
  }
  
  override func stopObserving() {
    NotificationCenter.default.removeObserver(self)
  }
  
  @objc func onPaymentSuccess(_ notification: Notification) {
    self.sendEvent(withName: "EasebuzzPaymentResultEvent", body: notification.userInfo)
  }
}
