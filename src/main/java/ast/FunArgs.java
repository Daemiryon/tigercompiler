package ast;

import java.util.ArrayList;

public class FunArgs implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public ArrayList<FieldDec> args;
    int lineNumber;
    int columnNumber;

    public FunArgs(ArrayList<FieldDec> args, int lineNumber, int columnNumber) {
        this.args = args;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }

}
