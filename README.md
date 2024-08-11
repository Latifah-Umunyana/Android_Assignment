# Electronic Devices 
Mobile Application 

# The Project 
This Android app demonstrates fetching data from "https://api.restful-api.dev/objects" and displaying it in a RecyclerView. It includes a listView and a DetailsView, supporting a tablet landscape layout.

# How to Run the App
1. Clone this repository
2. Open the project in Android Studio
3. Build and run the app on an emulator or physical device
4. When you run the app you see the list of all devices.
5. Click device name to get available details

# Libraries and Tools Used
1. Retrofit: For making API calls
2. GSON: For JSON parsing
3. RecyclerView: For displaying the list of items

# Design Decisions and Assumptions
1. App uses MVVM architecture
2. Toast messages for error handling
3. The app uses a single API endpoint and assumes the data structure remains consistent
4. ProgressBar for user experience while interacting with the app
