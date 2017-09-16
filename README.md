# Hey Java 9, what's up...?

This repositories is a collection of several code snippets that were written to demonstrate the changes and new features in Java 9.

It was created for an open space session on Java 9 for the Zuhlke UK Camp 2017.

To compile and run this code, you'll need a JDK9 installation:
- http://jdk.java.net/9/

## General structure

- All code in the directory `modules`, represents a simple modularised app, which queries the user for the amount of kitten pictures that the user would like to download and subsequently downloads the amount of kitten pictures by randomly fetching images from https://placekitten.com and storing them in the directory `~/kittens`. The code and modules itself don't necessarily provide valuable examples on how an app should be modularised but instead showcase how modularisation including `requires` and `exports` statements work in Java 9.
- All code in the directory `src`, is divided into multiple packages that showcase different additions and changes featured in Java 9:
    - New `Deprecated` annotation changes
    - New existing APIs extensions to
        - `Collections`
        - `Collectors`
        - `Optional`
        - `interface` (private interface methods)
        - `Stream`
    - New HTTP and WebSocket client
    - New JShell