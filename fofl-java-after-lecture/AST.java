import java.util.HashMap;
import java.util.Map.Entry;
import java.util.List;
import java.util.ArrayList;

class faux{ // collection of non-OO auxiliary functions (currently just error)
    public static void error(String msg){
	System.err.println("Interpreter error: "+msg);
	System.exit(-1);
    }
}

enum Type{
    INTTYPE, BOOLTYPE  
}

class Value {
    public Type valuetype;
    public int i;     // only valid if valuetype==INTTYPE
    public boolean b; // only valid if valuetype==BOOLTYPE
    Value(int i){valuetype=Type.INTTYPE; this.i=i;}
    Value(boolean b){valuetype=Type.BOOLTYPE; this.b=b;}
    public String toString(){
	if (valuetype==Type.BOOLTYPE){
	    return ""+b;
	}
	return ""+i;
    }
}

abstract class AST{
    abstract public Value eval(Environment env, FunEnvironment fenv);
    abstract public Type typecheck(Environment env, FunEnvironment fenv);
}

class TypedIdent extends AST{
    // abstract syntax for an identifier with a type
    // for instance "int x"
    
    public Type valuetype;
    public String ident;
    TypedIdent(Type valuetype, String ident){
	this.valuetype=valuetype; this.ident=ident;}
    public Value eval(Environment env, FunEnvironment fenv){
	// you cannot really run "int x" itself ...
	faux.error("TypedIdent.eval should not be called!");
	return null;
    }
    public Type typecheck(Environment env, FunEnvironment fenv){
	faux.error("TypeIdent.eval should not be called");
	return null;
    }
}

class Fun extends AST{
    // abstract syntax for a function declaration
    // e.g.  int f(int x, int y) = x+y
    
    public TypedIdent typeid;
    // function name and return type (in example "int f")
    public List<TypedIdent> parameters;
    // function parameters (in example ["int x", "int y"])
    
    public Expr e; // the body of the function
    // in the example "x+y"    
    
    Fun(TypedIdent typeid, List<TypedIdent> parameters, Expr e){
	this.typeid=typeid; this.parameters=parameters; this.e=e; }
    public Value eval(Environment env, FunEnvironment fenv){
	// you cannot really run "int f(int x, int y) = x+y"...
	// (instead one needs to use the FunctionCall class below)
	faux.error("Fun.eval should not be called!");
	return null;
    }
    public Type typecheck(Environment env, FunEnvironment fenv){
	faux.error("Fun.eval should not be called");
	return null;
    }
}


// Implementing the vtable of Mogensen's book

// Lookup table that maps each variable name to a value (which is
// either int or boolean)

class Environment {
    private HashMap<String,Value> variableValues = new HashMap<String,Value>();
    public Environment() { }	
    public void setVariable(String name, Value value) {
	variableValues.put(name, value);
    }
    
    public Value getVariable(String name){
	Value value = variableValues.get(name); 
	if (value == null) faux.error("Variable not defined: "+name); 
	return value;
    }
}

// Implementing the ftable of Mogensen's book
// Lookup table for function names, mapping function names to function
// definitions

class FunEnvironment{
    private HashMap<String,Fun> funDefs = new HashMap<String,Fun>();
    public FunEnvironment() { }	
    public void setFunction(String name, Fun f) {
	funDefs.put(name, f);
    }    
    public Fun getFunction(String name){
	Fun f = funDefs.get(name); 
	if (f == null) faux.error("Function not defined: "+name); 
	return f;
    }
}

class Start extends AST{
    // Abstract syntax for the entire program consisting of 
    public List<Fun> funs; // a list of function declarations
    public Expr e;         // a main expression that can use these functions

    Start(List<Fun> funs, Expr e){ this.funs=funs; this.e=e; }
    
    public Value eval(Environment env, FunEnvironment fenv){
	for(Fun f:funs) fenv.setFunction(f.typeid.ident, f);
	return e.eval(env,fenv);
    }
    public Type typecheck(Environment env, FunEnvironment fenv){
	for(Fun f:funs) fenv.setFunction(f.typeid.ident, f);
	return e.typecheck(env,fenv);
    }
}

abstract class Expr extends AST{
    // Abstract superclass of the different kinds of expressions
}

class Constant extends Expr{
    // Abstract syntax for constants (actually will only be ints)
    // e.g. "54"
    public Value v;
    Constant(Value v){ this.v=v; }
    public Value eval(Environment env, FunEnvironment fenv){
	return v;
    }
    public String toString(){return ""+v;}
    public Type typecheck(Environment env, FunEnvironment fenv){
	return v.valuetype;
    }
}

class Variable extends Expr{
    // Abstract syntax for variable names
    // e.g. "x"
    public String varname;
    Variable(String varname){ this.varname=varname; }
    public Value eval(Environment env, FunEnvironment fenv){
	return env.getVariable(varname);
    }
    public Type typecheck(Environment env, FunEnvironment fenv){
	return env.getVariable(varname).valuetype;
    }
}

class Addition extends Expr{
    // Abstract syntax for Addition
    // e.g. "x+5"
    public Expr e1,e2;
    Addition(Expr e1, Expr e2){ this.e1=e1; this.e2=e2; }
    public Value eval(Environment env, FunEnvironment fenv){
	Value v1=e1.eval(env,fenv);
	Value v2=e2.eval(env,fenv);
	//if (v1.valuetype!=Type.INTTYPE || v2.valuetype!=Type.INTTYPE)
	//    faux.error("Addition of non-integers: "+e1+"+"+e2);
	// just assuming these are integers:
	return new Value(v1.i+v2.i);
    }
    public Type typecheck(Environment env, FunEnvironment fenv){
	Type v1=e1.typecheck(env,fenv);
	Type v2=e2.typecheck(env,fenv);
	if (v1!=Type.INTTYPE || v2!=Type.INTTYPE)
	    faux.error("Addition of non-integers: "+e1+"+"+e2);
	return Type.INTTYPE;
    }
}

class Multiplication extends Expr{
    // Abstract syntax for Multiplication
    // e.g. "x*5"
    public Expr e1,e2;
    Multiplication(Expr e1, Expr e2){ this.e1=e1; this.e2=e2; }
    public Value eval(Environment env, FunEnvironment fenv){
	Value v1=e1.eval(env,fenv);
	Value v2=e2.eval(env,fenv);
	// just assuming these are integers:
	return new Value(v1.i*v2.i);
    }
    public Type typecheck(Environment env, FunEnvironment fenv){
	Type v1=e1.typecheck(env,fenv);
	Type v2=e2.typecheck(env,fenv);
	if (v1!=Type.INTTYPE || v2!=Type.INTTYPE)
	    faux.error("Multiplication of non-integers: "+e1+"+"+e2);
	return Type.INTTYPE;
    }
}

class Comparison extends Expr{
    // Abstract syntax for Comparison
    // e.g. "x==5"
    public Expr e1,e2;
    Comparison(Expr e1, Expr e2){ this.e1=e1; this.e2=e2; }
    public Value eval(Environment env, FunEnvironment fenv){
	Value v1=e1.eval(env,fenv);
	Value v2=e2.eval(env,fenv);
	// just assuming these are integers:
	return new Value(v1.i==v2.i);
    }
    public Type typecheck(Environment env, FunEnvironment fenv){
	Type v1=e1.typecheck(env,fenv);
	Type v2=e2.typecheck(env,fenv);
	if (v1!=Type.INTTYPE || v2!=Type.INTTYPE)
	    faux.error("Multiplication of non-integers: "+e1+"+"+e2);
	return Type.BOOLTYPE;
    }    
    public String toString(){return ""+e1+"=="+e2; }
}

class Conditional extends Expr{
    // Abstract syntax for if-then-else
    // e.g. "if (x==5) then 3 else x"
    public Expr cond, e1, e2;
    Conditional(Expr cond, Expr e1, Expr e2){ this.cond=cond; this.e1=e1; this.e2=e2; }
    public Value eval(Environment env, FunEnvironment fenv){
	Value vcond = cond.eval(env,fenv);
	// just assuming this is boolean
	if (vcond.b)
	    return e1.eval(env,fenv);
	else 
	    return e2.eval(env,fenv);
    }
   public Type typecheck(Environment env, FunEnvironment fenv){
       Type c=cond.typecheck(env,fenv);
       Type v1=e1.typecheck(env,fenv);
       Type v2=e2.typecheck(env,fenv);
       if (c!=Type.BOOLTYPE)
	   faux.error("Condition shall be a boolean");
       if (v1!=v2)
	   faux.error("If then and else have different types: "+e1+" vs "+e2);
       return v1;
   }    
}

class FunctionCall extends Expr{
    // Abstract syntax for calling functions
    // e.g. "exp(5,3)"
    public String fname; // in the example "exp"    
    public List<Expr> parameters; // in the example [5,3]
    
    FunctionCall(String fname, List<Expr> parameters){
	this.fname=fname;
	this.parameters=parameters;
    }
    public Value eval(Environment env, FunEnvironment fenv){
	Fun f=fenv.getFunction(fname);
	Environment newenv = new Environment();
	for(int i=0; i<parameters.size(); i++){
	    newenv.setVariable(f.parameters.get(i).ident,
			       parameters.get(i).eval(env,fenv) );
	}
	return f.e.eval(newenv,fenv);
    }
    public Type typecheck(Environment env, FunEnvironment fenv){
	Fun f=fenv.getFunction(fname);
	if (parameters.size()!=f.parameters.size())
	    faux.error(fname+" expects "+f.parameters.size()+" arguments "
		       +"but is called with "+parameters.size());
	for(int i=0; i<parameters.size(); i++){
	    if(parameters.get(i).typecheck(env,fenv)!=f.parameters.get(i).valuetype)
		faux.error("Wrong type");
	}
	
	return f.typeid.valuetype;
    }
}
