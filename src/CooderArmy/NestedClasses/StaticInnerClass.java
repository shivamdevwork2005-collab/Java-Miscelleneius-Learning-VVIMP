package CooderArmy.NestedClasses;

// Static Inner Class Demo
class Outer {
    private static int x = 20; // Belongs to the class, not instance/object
    int y = 30;

    // Static inner class - belongs to the Outer class, not any instance/object
    // Private fields and methods are accessible to inner classes because they are members of the same class scope
    static class Inner {
        static int z = 40;
        public String name;
        private int k;

        // Commented constructor
        // public Inner(String name, int k) {
        //     this.name = name;
        //     this.k = k;
        // }

        void display() {
            System.out.println("Inner Class");
            System.out.println(x);
            // System.out.println(y); // Cannot access non-static member from static context
            Outer o = new Outer();
            System.out.println(o.y); // Access non-static member by creating Outer instance
        }

        void display2(Outer o) {
            System.out.println(o.y); // Alternative approach: pass Outer instance as parameter
        }

        public static void display4() {
            System.out.println("Static Inner Class");
        }

        // Alternative approach: store Outer reference in constructor
        // Outer outer;
        // Inner(Outer outer) {
        //     this.outer = outer;
        // }
        // void display3() {
        //     System.out.println(outer.y);
        // }

    }

}

// Properties of static inner class:
// 1. Belongs to the class, not instance/object
// 2. Can access static members of outer class
// 3. Can access non-static members of outer class by creating instance of outer
// 4. Can be accessed directly by ClassName
// 5. Same as normal class - can implement, extend, override, etc.
// 6. Can do whatever a normal class can do with extra flexibility
// 7. Access pattern differs: creation, usage, destruction, passing, returning
// 8. Access modifiers can be used with inner class


class Bank {

    // Logical grouping: Interest calculator as a helper class
    public static class InterestCalculator {
        static double calculateInterestYearly(double p, double r, double t) {
            return (p * r * t) / 100 * 12;
        }

        static double calculateInterestMonthly(double p, double r, double t) {
            return (p * r * t) / 100;
        }

        static double calculateInterestDaily(double p, double r, double t) {
            return (p * r * t) / 100 * 365;
        }
    }

    public double calculateInterest(double p, double r, double t) {
        return InterestCalculator.calculateInterestYearly(p, r, t);
    }

}


// Use cases of static inner class (nested class):
// 1. Logical grouping
// 2. Group related classes together
// 3. Act as a helper class for outer class
// 4. Achieve encapsulation
// 5. Achieve abstraction
// 6. Achieve reusability
// 7. Achieve modularity
// 8. Achieve flexibility
// 9. Achieve performance
// 10. Achieve security
// 11. Builder design pattern
// 12. Factory design pattern
// 13. Host static methods
// 14. Request/Response DTO (Data Transfer Object)



public class StaticInnerClass {
    public static void main(String[] args) {
        Outer outer = new Outer();
        // Class name is Outer.Inner - access inner classes by nesting hierarchy
        // Inner is static, so we can access it directly without creating Outer instance
        Outer.Inner inner = new Outer.Inner();

        inner.display(); // Output: Inner Class

        // Inner inner = new Inner(); // Error: Inner is not available directly to JVM

        inner.display2(outer);
        Outer.Inner.display4();

        // Bank as outer class
        Bank b = new Bank();
        Bank.InterestCalculator c = new Bank.InterestCalculator();
        System.out.println(b.calculateInterest(15000.55, 12.5, 2));
    }
}
