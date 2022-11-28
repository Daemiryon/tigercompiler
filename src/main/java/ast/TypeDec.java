package ast;

public class TypeDec implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public TypeId typeId;
    public Type typeValue;

    public TypeDec(TypeId typeId, Type typeValue) {
        this.typeId = typeId;
        this.typeValue = typeValue;
    }


}
