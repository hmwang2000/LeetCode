package DesignPattern.behavior.visitor2;

// http://www.tutorialspoint.com/design_pattern/visitor_pattern.htm

public class VisitorPatternDemo {
	   public static void main(String[] args) {

	      ComputerPart computer = new Computer();
	      computer.accept(new ComputerPartDisplayVisitor());
	   }
}
