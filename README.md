# paywitheasebuzz-react-native-lib

## For More description of iOS and Android setup refer below link

https://github.com/easebuzz/paywitheasebuzz-react-native-lib/blob/master/paywitheasebuzz-react-native-lib/documentation.pdf


## React Native Integration Code (Java Script):

1.0 Write below JavaScript Code to Start Payment using Easebuzz Payment Gateway

1.1 Import following components import {Platform, Button, DeviceEventEmitter, NativeModules,NativeEventEmitter} from 'react-native';

1.2 Declare the Easebuzz Specific variables in state as below.

this.state = { eb_transaction_amount: "10", eb_start_payment: false }

1.3 Write below code in componentDidMount() method.

this.setState({eb_start_payment: false}); if (Platform.OS === "android") { this.EasebuzzEventsubscription = DeviceEventEmitter.addListener('EasebuzzPaymentResultEvent', (data) => { this.setState({eb_start_payment: false}); alert(`(Payment Result: ${data.result}` +`):::`+ `Response : ${data.payment_response}`); // Handle payment response according your requirement });

}else{

const { RNEasebuzz } = NativeModules; const easebuzzManagerEmitter = new NativeEventEmitter(RNEasebuzz); const EasebuzziOSEventsubscription = easebuzzManagerEmitter.addListener( 'EasebuzzPaymentResultEvent', (data) => {

this.setState({eb_start_payment: false});

alert(`(Payment Result: ${data.result}`); });

} 

1.4 Write below code in componentWillUnmount() method.

if (Platform.OS === "android") { this.EasebuzzEventsubscription.remove(); }else{ this.EasebuzziOSEventsubscription.remove(); this.easebuzzManagerEmitter.remove(); }

1.5 Write below method to start Payment startPaymentEasebuzz = (options) => { if(this.state.eb_start_payment == false) { this.setState({eb_start_payment: true}); NativeModules.EasebuzzModule.PayEasebuzz(options); } }

1.6 call startPaymentEasebuzz method on Click of Pay Button.

<Button onPress={() => { var options = {txnid: 'UNIQUE_TRANSACTION_ID', amount: this.state.eb_transaction_amount, productinfo: 'Product Information', firstname: 'Customer First Name', email: "customer@gmail.com", phone: "1234567891", key: "YOUR_MERCHANT_KEY", udf1: "", udf2: "", udf3: "", udf4: "", udf5: "", address1: "", address2: "", city: "", state: "", country: "", zipcode: "", unique_id: "", //Customers unique ID hash: "Create hash using following procedure", pay_mode: "production" // This can be “test” or “production”} this.startPaymentEasebuzz(options)

}} title="Make Payment” />

## For More description of request and Response refer below link.

https://docs.easebuzz.in/mobile-integration-react-native/handle-response
