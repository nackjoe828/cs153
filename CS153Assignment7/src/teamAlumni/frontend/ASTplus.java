/* Generated By:JJTree: Do not edit this line. ASTplus.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=wci.intermediate.icodeimpl.ICodeNodeImpl,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package teamAlumni.frontend;

public
class ASTplus extends SimpleNode {
  public ASTplus(int id) {
    super(id);
  }

  public ASTplus(Assignment7 p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(Assignment7Visitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=30cd46e4d07338fa0a108399a7734b6a (do not edit this line) */
