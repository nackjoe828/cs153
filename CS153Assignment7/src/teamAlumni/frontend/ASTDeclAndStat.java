/* Generated By:JJTree: Do not edit this line. ASTDeclAndStat.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=wci.intermediate.icodeimpl.ICodeNodeImpl,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package teamAlumni.frontend;

public
class ASTDeclAndStat extends SimpleNode {
  public ASTDeclAndStat(int id) {
    super(id);
  }

  public ASTDeclAndStat(Assignment7 p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(Assignment7Visitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=bdc50e1af79be3f683adee5885211391 (do not edit this line) */
