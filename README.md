# paywitheasebuzz-react-native-lib

## For More description of iOS and Android setup refer below link

https://github.com/easebuzz/paywitheasebuzz-react-native-lib/blob/master/paywitheasebuzz-react-native-lib/documentation.pdf


## React Native Integration Code (Java Script):

1.0 Write below JavaScript Code to Start Payment using Easebuzz Payment Gateway


1.1 Import following components 
 ```
import {Platform, Button, NativeModules,NativeEventEmitter} from 'react-native';
 ```

1.2 Import EasebuzzCheckout module to your component:
  ```
     import EasebuzzCheckout from 'react-native-easebuzz-kit';
 ```

1.3 Write below code in Call Payment Menthod.

Call EasebuzzCheckout.open method with the payment request parameters as options. This method returns a JS Promise where then part corresponds to a successful payment response or failure response and the catch part corresponds to any sdk failure i.e event failed etc.


 ```
const callPaymentGateway  = () => {
var options = {
txnid: 'UNIQUE_TRANSACTION_ID',
amount: 'Transaction amount in string as double format',
productinfo: 'Product Information',
firstname: 'Customer First Name',
email: "customer@gmail.com",
phone: "customer phone number",
key: "YOUR_MERCHANT_KEY",
udf1: "",
udf2: "",
udf3: "",
udf4: "",
udf5: "",
s_url: "http://your.successurl.in",
f_url: "http://your.failureurl.in",
address1: "customer address 1",
address2: "customer address 2",
city: "customer city",
state: "customer state",
country: "customer country",
zipcode: "customer zipcode",
unique_id: "Customers unique ID only for save card feature otherwise pass empty",
pay_mode: "This can be “test” or “production",
hash: "Create hash using following procedure in hash generation section"
}

EasebuzzCheckout.open(options).then((data) => {
//handle the payment success & failed response here
console.log("Payment Response:") 
console.log(data);
}).catch((error) => {
//handle sdk failure issue here
console.log("SDK Error:")
console.log(error);
});
}

 ```
## For More description of request and Response refer below link.

https://docs.easebuzz.in/mobile-integration-react-native/handle-response

## For More description of Android and iOS setup refer below link.

https://docs.easebuzz.in/mobile-integration-react-native
