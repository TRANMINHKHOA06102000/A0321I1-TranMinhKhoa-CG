package main.Impl;

import main.Greeter;

public class HelloWorld implements Greeter {
    @Override
    public String greet() {
        return "Hello";
    }
}
