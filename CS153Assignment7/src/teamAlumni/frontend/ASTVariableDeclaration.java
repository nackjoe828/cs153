/* Generated By:JJTree: Do not edit this line. ASTVariableDeclaration.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=wci.intermediate.icodeimpl.ICodeNodeImpl,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package teamAlumni.frontend;

public
class ASTVariableDeclaration extends SimpleNode {
  public ASTVariableDeclaration(int id) {
    super(id);
  }

  public ASTVariableDeclaration(Assignment7 p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(Assignment7Visitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=dab12fd47e0dcd105833f8e473bac2eb (do not edit this line) */
