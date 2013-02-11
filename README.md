NumPad
======

A numeric input pad for the i'm Watch

## Installation

Just clone the repository on your computer, then reference the `Numpad` Android Library project from your project. The repository contains both [Eclipse][1] and [IntelliJ IDEA][2] project files for the library project.

## Usage

In order to implement the Overlay Menu in your project, you have to follow these steps:

  1. Reference the `Numpad` Android library project into your app's project, and make sure you've added the [Android Support Library][3] to your classpath, because the **Numpad** is implemented as a `Fragment`.
  2. Customize the `NumpadFragment` to your needs (icons, callbacks, and so on). Please remember that the i'm Watch is *not* supposed to support full-text input. Use i'm Cloud JSON configuration mechanism to provide app configuration and any kind of data entry other than simple numeric input.
  3. Make sure the `Activity` you want to use the Numpad in extends the `FragmentActivity` found in the Android Support Library v4.
  4. Add the `NumpadFragment` to your app's XML layout and/or code and wire it up.

   [1]: http://www.eclipse.org/
   [2]: http://www.jetbrains.com/idea/
   [3]: http://developer.android.com/tools/extras/support-library.html
