package ast;

public class Assign implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast lValue;
    public Ast expr;

    public Assign(Ast lValue, Ast expr) {
        this.lValue = lValue;
        this.expr = expr;
    }

}
