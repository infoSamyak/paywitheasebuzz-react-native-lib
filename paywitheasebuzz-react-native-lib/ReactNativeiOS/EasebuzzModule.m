//
//  EasebuzzModule.m
//  easebuzzdemo
//
//  Created by Easebuzz Pvt Ltd on 12/06/19.
//  Copyright © 2019 Facebook. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "React/RCTBridgeModule.h"

@interface RCT_EXTERN_MODULE(EasebuzzModule, NSObject)
RCT_EXTERN_METHOD(PayEasebuzz:(NSDictionary *)dict)

@end
