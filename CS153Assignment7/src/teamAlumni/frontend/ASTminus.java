/* Generated By:JJTree: Do not edit this line. ASTminus.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=wci.intermediate.icodeimpl.ICodeNodeImpl,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package teamAlumni.frontend;

public
class ASTminus extends SimpleNode {
  public ASTminus(int id) {
    super(id);
  }

  public ASTminus(Assignment7 p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(Assignment7Visitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=44e83ea9a3d3f02bc9ab738c2b29d99b (do not edit this line) */
