package DesignPattern.behavior.visitor;

public interface ItemElement {
	public int accept(ShoppingCartVisitor visitor);
}
