package org.example.beanshell;

import bsh.EvalError;
import bsh.Interpreter;
import org.example.OpcodeRequest;

import java.beans.PropertyEditorSupport;
import java.util.Date;

/**
 * @author 01404547
 * @date 2022/4/30
 */
public class InterpreterTest {
    public static void main(String[] args) throws EvalError {
        Interpreter i = new Interpreter();  // Construct an interpreter
        i.set("foo", 5);                    // Set variables
        i.set("date", new Date() );
        i.set("opcodeRequest",createOpcodeRequest());

        Date date = (Date)i.get("date");    // retrieve a variable

// Eval a statement and get the result
        i.eval("bar = foo*10");
        System.out.println( i.get("bar") );
        i.eval("result = opcodeRequest.getExt1().equals(\"1\")");
        System.out.println(i.get("result"));
    }

    public static OpcodeRequest createOpcodeRequest() {
        OpcodeRequest opcodeRequest = new OpcodeRequest();
        opcodeRequest.setExt1("1");
        opcodeRequest.setExt2("2");
        return opcodeRequest;
    }
}
