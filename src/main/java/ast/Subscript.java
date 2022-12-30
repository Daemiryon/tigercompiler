package ast;

public class Subscript implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast lValue;
    public Ast expr;
    public int lineNumber;
    public int columnNumber;

    public Subscript(Ast lValue, Ast expr, int lineNumber, int columnNumber) {
        this.lValue = lValue;
        this.expr = expr;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }

}
