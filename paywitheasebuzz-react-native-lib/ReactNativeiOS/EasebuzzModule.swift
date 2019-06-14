//
//  EasebuzzModule.swift
//  DemoApp
//
//  Created by Easebuzz Pvt Ltd on 14/06/19.
//  Copyright © 2019 Facebook. All rights reserved.
//

import Foundation
import Easebuzz
@objc(EasebuzzModule)
class EasebuzzModule: NSObject,PayWithEasebuzzCallback {
  func PEBCallback(data: [String : AnyObject]) {
    RNEasebuzz.paywithEasebuzzCallback(data: data)
  }
  @objc
  static func requiresMainQueueSetup() -> Bool {
    return true
  }
  @objc func PayEasebuzz(_ dict: Dictionary<String,Any>) {
    let payment = Payment.init(customerData: dict as! Dictionary<String, String>)
    let paymentValid = payment.isValid().validity
    if !paymentValid {
      print("Invalid records")
    }else{
      DispatchQueue.main.async {
        PayWithEasebuzz.setUp(pebCallback: self )
        PayWithEasebuzz.invokePaymentOptionsView(paymentObj: payment, isFrom: self)
      }
    }
  }
}
