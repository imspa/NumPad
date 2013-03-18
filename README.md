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

## License
This source code is provided under the BSD 3-clause license:

<pre>
Copyright (c) 2013, i'm Spa
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:
* Redistributions of source code must retain the above copyright
  notice, this list of conditions and the following disclaimer.
* Redistributions in binary form must reproduce the above copyright
  notice, this list of conditions and the following disclaimer in the
  documentation and/or other materials provided with the distribution.
* Neither the name of the i'm Spa nor the
  names of its contributors may be used to endorse or promote products
  derived from this software without specific prior written permission.
  
THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL i'm Spa BE LIABLE FOR ANY
DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
</pre>
