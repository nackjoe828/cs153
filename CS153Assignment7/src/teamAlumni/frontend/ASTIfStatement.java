/* Generated By:JJTree: Do not edit this line. ASTIfStatement.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=wci.intermediate.icodeimpl.ICodeNodeImpl,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package teamAlumni.frontend;

public
class ASTIfStatement extends SimpleNode {
  public ASTIfStatement(int id) {
    super(id);
  }

  public ASTIfStatement(Assignment7 p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(Assignment7Visitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=88919bc8681d4f67ad640bf5a53b9d8c (do not edit this line) */
