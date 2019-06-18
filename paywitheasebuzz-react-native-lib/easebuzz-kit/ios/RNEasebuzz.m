//
//  RNEasebuzz.m
//  easebuzzdemo
//
//  Created by Easebuzz Pvt Ltd on 13/06/19.
//  Copyright © 2019 Facebook. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "React/RCTBridgeModule.h"
#import "React/RCTEventDispatcher.h"
#import "React/RCTBridge.h"
#import "React/RCTBridgeModule.h"

@interface RCT_EXTERN_MODULE(RNEasebuzz, NSObject)

RCT_EXTERN_METHOD(paywithEasebuzzCallback: (NSDictionary *)data)
RCT_EXTERN_METHOD(supportedEvents)
RCT_EXTERN_METHOD(startObserving)
RCT_EXTERN_METHOD(stopObserving)

@end


