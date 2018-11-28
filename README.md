# BreadcrumbView

This is and Android view intended to show a breadcrumb of a given path

![Screenshot](https://raw.githubusercontent.com/LivioGama/breadcrumbview/master/art/screenshot2.png "Example")


## Installing

Just add the following to your build.gradle file (but not for LivioGama's fork)

```groovy
  compile 'com.worldline:breadcrumbview:1.0.0'
```

## Usage
First, add a namespace into your layout for the non-system resources, for example:

```xml
    xmlns:app="http://schemas.android.com/apk/res-auto"
```

Insert the view on your layout. Here an example:

```xml
    <com.worldline.breadcrumbview.BreadcrumbView
                android:id="@+id/breadcrumbView"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                app:enableFillColor="#FFFFFF"
                app:fillColor="#EFF2F7"
                app:strokeColor="#DEE1E6">
    
            <LinearLayout
                    android:id="@+id/breadcrumb0"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:focusable="false"
                    android:orientation="horizontal">
    
                <ImageView
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:src="@mipmap/ic_launcher" />
    
                <TextView
                        android:layout_width="wrap_content"
                        android:layout_height="match_parent"
                        android:gravity="center"
                        android:text="Book 1" />
            </LinearLayout>
    
            <LinearLayout
                    android:id="@+id/breadcrumb1"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:focusable="true"
                    android:orientation="horizontal">
    
                <ImageView
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:src="@mipmap/ic_launcher" />
    
                <TextView
                        android:layout_width="wrap_content"
                        android:layout_height="match_parent"
                        android:gravity="center"
                        android:text="Chapter 2" />
            </LinearLayout>
    
            <LinearLayout
                    android:id="@+id/breadcrumb2"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:focusable="true"
                    android:orientation="horizontal">
    
                <ImageView
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:src="@mipmap/ic_launcher" />
    
                <TextView
                        android:layout_width="wrap_content"
                        android:layout_height="match_parent"
                        android:gravity="center"
                        android:text="Section 3" />
            </LinearLayout>
    
            <LinearLayout
                    android:id="@+id/breadcrumb3"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:focusable="true"
                    android:orientation="horizontal">
    
                <ImageView
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:src="@mipmap/ic_launcher" />
    
                <TextView
                        android:layout_width="wrap_content"
                        android:layout_height="match_parent"
                        android:gravity="center"
                        android:text="Paragraph 4" />
            </LinearLayout>
        </com.worldline.breadcrumbview.BreadcrumbView>
```

### Properties

* **enableFillColor**: The arrow color when focused
* **fillColor**: The arrow color when not focused
* **strokeColor**: The arrow outline border color

### Events

You can customize your child view as you want, and manually add click listeners.

## LICENSE ##

    Copyright 2016 Wordline Spain

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
