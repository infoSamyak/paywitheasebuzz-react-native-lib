using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace Easebuzz.Kit.RNEasebuzzKit
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNEasebuzzKitModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNEasebuzzKitModule"/>.
        /// </summary>
        internal RNEasebuzzKitModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNEasebuzzKit";
            }
        }
    }
}
