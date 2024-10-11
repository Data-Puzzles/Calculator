package com.mycompany.calc;

abstract class Shape {
    private String law;
    abstract double calculateArea();
    protected void setLaw(String law) {
        this.law = law;
    }
    public String getLaw() {
        return this.law;
    }
};
class Square extends Shape {
    private double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
        setLaw("Area = L × L");
    }

    public double calculateArea() {
        return sideLength * sideLength;
    }

};
class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
        setLaw("Area = L × L");
    }

    public double calculateArea() {
        return 0.5 * base * height;
    }
};
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double  calculateArea() {
        return Math.PI * radius * radius;
    }
};
class Rectangle extends Shape {
    private double length;
    private double width;
     

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
        setLaw("Area = L × W");
    }

    public double calculateArea() {
        return length * width;
        
    }
}
