package ast;

public class ArrType extends Type {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public TypeId name;

    public ArrType(TypeId name) {
        this.name = name;
    }
}
