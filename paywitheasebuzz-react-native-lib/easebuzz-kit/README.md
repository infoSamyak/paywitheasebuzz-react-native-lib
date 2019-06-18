
# react-native-easebuzz-kit

## Getting started

`$ npm install react-native-easebuzz-kit --save`

### Mostly automatic installation

`$ react-native link react-native-easebuzz-kit`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-easebuzz-kit` and add `RNEasebuzzKit.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNEasebuzzKit.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.easebuzz.RNEasebuzzKitPackage;` to the imports at the top of the file
  - Add `new RNEasebuzzKitPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-easebuzz-kit'
  	project(':react-native-easebuzz-kit').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-easebuzz-kit/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-easebuzz-kit')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNEasebuzzKit.sln` in `node_modules/react-native-easebuzz-kit/windows/RNEasebuzzKit.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Easebuzz.Kit.RNEasebuzzKit;` to the usings at the top of the file
  - Add `new RNEasebuzzKitPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNEasebuzzKit from 'react-native-easebuzz-kit';

// TODO: What to do with the module?
RNEasebuzzKit;
```
  